package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class d
  extends y
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> jBh;
  
  static
  {
    AppMethodBeat.i(145703);
    jBh = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String k(c paramc)
  {
    AppMethodBeat.i(145702);
    paramc = paramc.getAppId();
    String str = e.cTA();
    ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, str });
    Object localObject = new a();
    ((a)localObject).cTr = str;
    ((a)localObject).dtM = 0;
    ((a)localObject).appId = paramc;
    ((a)localObject).aEC();
    localObject = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.as(this.val$appId, false);
        paramAnonymousd = new d.a();
        paramAnonymousd.dtM = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.aEC();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.as(this.val$appId, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        d.a locala = new d.a();
        locala.dtM = 2;
        locala.appId = this.val$appId;
        locala.aYb();
        g.b(this.val$appId, this);
        d.aYd().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.as(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!jBh.contains(paramc))
    {
      g.a(paramc, (g.c)localObject);
      jBh.add(paramc);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", k(paramc));
    paramc = k("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return paramc;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String cTr = "";
    public int dtM = 0;
    public String hMd = "";
    
    public final void AI()
    {
      AppMethodBeat.i(145700);
      super.AI();
      if (this.dtM == 0)
      {
        if (!TextUtils.isEmpty(this.cTr))
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        ad.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.dtM != 1) {
        ad.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
    
    public final void MQ()
    {
      AppMethodBeat.i(145699);
      ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.dtM) });
      this.hMd = "";
      String str;
      Object localObject;
      if (this.dtM == 0)
      {
        str = this.appId;
        localObject = this.cTr;
        ad.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
        u localu = new u();
        localu.dbH.action = 10;
        localu.dbH.appId = str;
        localu.dbH.cTr = ((String)localObject);
        com.tencent.mm.plugin.music.b.a.a(localu);
        this.cTr = localu.dbH.cTr;
        ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.cTr });
        if (TextUtils.isEmpty(this.cTr)) {
          this.hMd = "fail to create audio instance";
        }
      }
      for (;;)
      {
        AI();
        AppMethodBeat.o(145699);
        return;
        if (this.dtM == 1)
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          ad.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new u();
          ((u)localObject).dbH.action = 12;
          ((u)localObject).dbH.appId = str;
          com.tencent.mm.plugin.music.b.a.a((u)localObject);
        }
        else if (this.dtM == 2)
        {
          ad.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          ad.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new u();
          ((u)localObject).dbH.action = 9;
          ((u)localObject).dbH.appId = str;
          com.tencent.mm.plugin.music.b.a.a((u)localObject);
          com.tencent.mm.plugin.appbrand.media.a.a.KD(this.appId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d
 * JD-Core Version:    0.7.0.1
 */