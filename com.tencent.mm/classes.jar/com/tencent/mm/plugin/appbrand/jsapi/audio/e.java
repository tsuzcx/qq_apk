package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e
  extends y
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> kzr;
  
  static
  {
    AppMethodBeat.i(145703);
    kzr = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String k(c paramc)
  {
    AppMethodBeat.i(145702);
    paramc = paramc.getAppId();
    String str = com.tencent.mm.plugin.music.b.e.duJ();
    ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, str });
    Object localObject = new a();
    ((a)localObject).ddg = str;
    ((a)localObject).dEu = 0;
    ((a)localObject).appId = paramc;
    ((a)localObject).aPa();
    localObject = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.av(this.val$appId, false);
        paramAnonymousd = new e.a();
        paramAnonymousd.dEu = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.aPa();
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
        ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        e.a locala = new e.a();
        locala.dEu = 2;
        locala.appId = this.val$appId;
        locala.bjk();
        h.b(this.val$appId, this);
        e.bjm().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.av(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!kzr.contains(paramc))
    {
      h.a(paramc, (h.c)localObject);
      kzr.add(paramc);
    }
    AppMethodBeat.o(145702);
    return str;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145701);
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", k(paramc));
    paramc = n("ok", paramJSONObject);
    AppMethodBeat.o(145701);
    return paramc;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int dEu = 0;
    public String ddg = "";
    public String iIJ = "";
    
    public final void BK()
    {
      AppMethodBeat.i(145700);
      super.BK();
      if (this.dEu == 0)
      {
        if (!TextUtils.isEmpty(this.ddg))
        {
          ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        ae.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.dEu != 1) {
        ae.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
    
    public final void Ov()
    {
      AppMethodBeat.i(145699);
      ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.dEu) });
      this.iIJ = "";
      String str;
      Object localObject;
      if (this.dEu == 0)
      {
        str = this.appId;
        localObject = this.ddg;
        ae.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
        v localv = new v();
        localv.dlA.action = 10;
        localv.dlA.appId = str;
        localv.dlA.ddg = ((String)localObject);
        com.tencent.mm.plugin.music.b.a.a(localv);
        this.ddg = localv.dlA.ddg;
        ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.ddg });
        if (TextUtils.isEmpty(this.ddg)) {
          this.iIJ = "fail to create audio instance";
        }
      }
      for (;;)
      {
        BK();
        AppMethodBeat.o(145699);
        return;
        if (this.dEu == 1)
        {
          ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          ae.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).dlA.action = 12;
          ((v)localObject).dlA.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
        }
        else if (this.dEu == 2)
        {
          ae.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          ae.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).dlA.action = 9;
          ((v)localObject).dlA.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
          com.tencent.mm.plugin.appbrand.media.a.a.SW(this.appId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e
 * JD-Core Version:    0.7.0.1
 */