package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.music.b.b;
import com.tencent.mm.plugin.music.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.ab
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> etb;
  
  static
  {
    AppMethodBeat.i(145703);
    etb = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String o(f paramf)
  {
    AppMethodBeat.i(145702);
    paramf = paramf.getAppId();
    String str = h.glT();
    Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramf, str });
    Object localObject = new a();
    ((a)localObject).hqQ = str;
    ((a)localObject).eQp = 0;
    ((a)localObject).appId = paramf;
    ((a)localObject).bQt();
    localObject = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { g.this });
        com.tencent.mm.plugin.appbrand.media.a.a.aL(g.this, false);
        paramAnonymousd = new g.a();
        paramAnonymousd.eQp = 1;
        paramAnonymousd.appId = g.this;
        paramAnonymousd.bQt();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.aL(g.this, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { g.this });
        g.a locala = new g.a();
        locala.eQp = 2;
        locala.appId = g.this;
        locala.cqe();
        k.b(g.this, this);
        g.cqh().remove(g.this);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.aL(g.this, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!etb.contains(paramf))
    {
      k.a(paramf, (k.c)localObject);
      etb.add(paramf);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", o(paramf));
    paramf = m("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return paramf;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int eQp = 0;
    public String hqQ = "";
    public String ppp = "";
    
    public final void aFi()
    {
      AppMethodBeat.i(145699);
      Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.eQp) });
      this.ppp = "";
      if (this.eQp == 0)
      {
        this.hqQ = c.bo(this.appId, this.hqQ);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.hqQ });
        if (TextUtils.isEmpty(this.hqQ)) {
          this.ppp = "fail to create audio instance";
        }
      }
      for (;;)
      {
        callback();
        AppMethodBeat.o(145699);
        return;
        String str;
        com.tencent.mm.autogen.a.ab localab;
        if (this.eQp == 1)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localab = new com.tencent.mm.autogen.a.ab();
          localab.hzS.action = 12;
          localab.hzS.appId = str;
          b.a(localab);
        }
        else if (this.eQp == 2)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localab = new com.tencent.mm.autogen.a.ab();
          localab.hzS.action = 9;
          localab.hzS.appId = str;
          b.a(localab);
          com.tencent.mm.plugin.appbrand.media.a.a.adA(this.appId);
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145700);
      super.callback();
      if (this.eQp == 0)
      {
        if (!TextUtils.isEmpty(this.hqQ))
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.eQp != 1) {
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */