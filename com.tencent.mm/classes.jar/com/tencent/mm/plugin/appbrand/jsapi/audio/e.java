package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.f.a.y;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.music.b.b;
import com.tencent.mm.plugin.music.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e
  extends aa
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> cAG;
  
  static
  {
    AppMethodBeat.i(145703);
    cAG = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String m(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(145702);
    parame = parame.getAppId();
    String str = h.fcQ();
    Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { parame, str });
    Object localObject = new a();
    ((a)localObject).fmF = str;
    ((a)localObject).cUP = 0;
    ((a)localObject).appId = parame;
    ((a)localObject).bsM();
    localObject = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.ay(this.val$appId, false);
        paramAnonymousd = new e.a();
        paramAnonymousd.cUP = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.bsM();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.ay(this.val$appId, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        e.a locala = new e.a();
        locala.cUP = 2;
        locala.appId = this.val$appId;
        locala.bPY();
        k.b(this.val$appId, this);
        e.bQa().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.ay(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!cAG.contains(parame))
    {
      k.a(parame, (k.c)localObject);
      cAG.add(parame);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", m(parame));
    parame = m("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return parame;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int cUP = 0;
    public String fmF = "";
    public String mvQ = "";
    
    public final void adj()
    {
      AppMethodBeat.i(145699);
      Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.cUP) });
      this.mvQ = "";
      if (this.cUP == 0)
      {
        this.fmF = c.be(this.appId, this.fmF);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.fmF });
        if (TextUtils.isEmpty(this.fmF)) {
          this.mvQ = "fail to create audio instance";
        }
      }
      for (;;)
      {
        callback();
        AppMethodBeat.o(145699);
        return;
        String str;
        y localy;
        if (this.cUP == 1)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localy = new y();
          localy.fvx.action = 12;
          localy.fvx.appId = str;
          b.a(localy);
        }
        else if (this.cUP == 2)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localy = new y();
          localy.fvx.action = 9;
          localy.fvx.appId = str;
          b.a(localy);
          com.tencent.mm.plugin.appbrand.media.a.a.aku(this.appId);
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145700);
      super.callback();
      if (this.cUP == 0)
      {
        if (!TextUtils.isEmpty(this.fmF))
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.cUP != 1) {
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */