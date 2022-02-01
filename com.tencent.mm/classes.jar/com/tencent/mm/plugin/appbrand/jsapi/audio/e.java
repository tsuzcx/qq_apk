package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.music.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e
  extends ab
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> lDK;
  
  static
  {
    AppMethodBeat.i(145703);
    lDK = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String k(f paramf)
  {
    AppMethodBeat.i(145702);
    paramf = paramf.getAppId();
    String str = g.esG();
    Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramf, str });
    Object localObject = new a();
    ((a)localObject).dtX = str;
    ((a)localObject).cSx = 0;
    ((a)localObject).appId = paramf;
    ((a)localObject).bjm();
    localObject = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.aw(this.val$appId, false);
        paramAnonymousd = new e.a();
        paramAnonymousd.cSx = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.bjm();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.aw(this.val$appId, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        e.a locala = new e.a();
        locala.cSx = 2;
        locala.appId = this.val$appId;
        locala.bEy();
        h.b(this.val$appId, this);
        e.bEA().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.aw(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!lDK.contains(paramf))
    {
      h.a(paramf, (h.c)localObject);
      lDK.add(paramf);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", k(paramf));
    paramf = n("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return paramf;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int cSx = 0;
    public String dtX = "";
    public String jFn = "";
    
    public final void YC()
    {
      AppMethodBeat.i(145699);
      Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.cSx) });
      this.jFn = "";
      String str;
      Object localObject;
      if (this.cSx == 0)
      {
        str = this.appId;
        localObject = this.dtX;
        Log.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
        x localx = new x();
        localx.dCQ.action = 10;
        localx.dCQ.appId = str;
        localx.dCQ.dtX = ((String)localObject);
        com.tencent.mm.plugin.music.b.a.a(localx);
        this.dtX = localx.dCQ.dtX;
        Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.dtX });
        if (TextUtils.isEmpty(this.dtX)) {
          this.jFn = "fail to create audio instance";
        }
      }
      for (;;)
      {
        callback();
        AppMethodBeat.o(145699);
        return;
        if (this.cSx == 1)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new x();
          ((x)localObject).dCQ.action = 12;
          ((x)localObject).dCQ.appId = str;
          com.tencent.mm.plugin.music.b.a.a((x)localObject);
        }
        else if (this.cSx == 2)
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          Log.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new x();
          ((x)localObject).dCQ.action = 9;
          ((x)localObject).dCQ.appId = str;
          com.tencent.mm.plugin.music.b.a.a((x)localObject);
          com.tencent.mm.plugin.appbrand.media.a.a.acA(this.appId);
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145700);
      super.callback();
      if (this.cSx == 0)
      {
        if (!TextUtils.isEmpty(this.dtX))
        {
          Log.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.cSx != 1) {
        Log.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */