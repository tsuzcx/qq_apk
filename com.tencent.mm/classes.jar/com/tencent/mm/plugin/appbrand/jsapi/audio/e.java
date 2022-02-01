package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e
  extends y
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> kwc;
  
  static
  {
    AppMethodBeat.i(145703);
    kwc = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String k(c paramc)
  {
    AppMethodBeat.i(145702);
    paramc = paramc.getAppId();
    String str = com.tencent.mm.plugin.music.b.e.drx();
    ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, str });
    Object localObject = new a();
    ((a)localObject).dce = str;
    ((a)localObject).dDp = 0;
    ((a)localObject).appId = paramc;
    ((a)localObject).aOD();
    localObject = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.av(this.val$appId, false);
        paramAnonymousd = new e.a();
        paramAnonymousd.dDp = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.aOD();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.av(this.val$appId, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        e.a locala = new e.a();
        locala.dDp = 2;
        locala.appId = this.val$appId;
        locala.biB();
        g.b(this.val$appId, this);
        e.biD().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.av(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!kwc.contains(paramc))
    {
      g.a(paramc, (g.c)localObject);
      kwc.add(paramc);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", k(paramc));
    paramc = m("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return paramc;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int dDp = 0;
    public String dce = "";
    public String iFQ = "";
    
    public final void BJ()
    {
      AppMethodBeat.i(145700);
      super.BJ();
      if (this.dDp == 0)
      {
        if (!TextUtils.isEmpty(this.dce))
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        ad.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.dDp != 1) {
        ad.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145699);
      ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.dDp) });
      this.iFQ = "";
      String str;
      Object localObject;
      if (this.dDp == 0)
      {
        str = this.appId;
        localObject = this.dce;
        ad.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
        v localv = new v();
        localv.dky.action = 10;
        localv.dky.appId = str;
        localv.dky.dce = ((String)localObject);
        com.tencent.mm.plugin.music.b.a.a(localv);
        this.dce = localv.dky.dce;
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.dce });
        if (TextUtils.isEmpty(this.dce)) {
          this.iFQ = "fail to create audio instance";
        }
      }
      for (;;)
      {
        BJ();
        AppMethodBeat.o(145699);
        return;
        if (this.dDp == 1)
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          ad.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).dky.action = 12;
          ((v)localObject).dky.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
        }
        else if (this.dDp == 2)
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          ad.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).dky.action = 9;
          ((v)localObject).dky.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
          com.tencent.mm.plugin.appbrand.media.a.a.Sn(this.appId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */