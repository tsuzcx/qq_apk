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
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class d
  extends y
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> kbD;
  
  static
  {
    AppMethodBeat.i(145703);
    kbD = new Vector();
    AppMethodBeat.o(145703);
  }
  
  static String k(c paramc)
  {
    AppMethodBeat.i(145702);
    paramc = paramc.getAppId();
    String str = e.dhk();
    ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, str });
    Object localObject = new a();
    ((a)localObject).cQO = str;
    ((a)localObject).drx = 0;
    ((a)localObject).appId = paramc;
    ((a)localObject).aLt();
    localObject = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(145697);
        ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
        com.tencent.mm.plugin.appbrand.media.a.a.at(this.val$appId, false);
        paramAnonymousd = new d.a();
        paramAnonymousd.drx = 1;
        paramAnonymousd.appId = this.val$appId;
        paramAnonymousd.aLt();
        AppMethodBeat.o(145697);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(145695);
        com.tencent.mm.plugin.appbrand.media.a.a.at(this.val$appId, true);
        AppMethodBeat.o(145695);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(145698);
        ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
        d.a locala = new d.a();
        locala.drx = 2;
        locala.appId = this.val$appId;
        locala.beY();
        g.b(this.val$appId, this);
        d.bfa().remove(this.val$appId);
        AppMethodBeat.o(145698);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(145696);
        com.tencent.mm.plugin.appbrand.media.a.a.at(this.val$appId, true);
        AppMethodBeat.o(145696);
      }
    };
    if (!kbD.contains(paramc))
    {
      g.a(paramc, (g.c)localObject);
      kbD.add(paramc);
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
    public String cQO = "";
    public int drx = 0;
    public String imz = "";
    
    public final void Am()
    {
      AppMethodBeat.i(145700);
      super.Am();
      if (this.drx == 0)
      {
        if (!TextUtils.isEmpty(this.cQO))
        {
          ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
          AppMethodBeat.o(145700);
          return;
        }
        ac.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
        AppMethodBeat.o(145700);
        return;
      }
      if (this.drx != 1) {
        ac.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
      }
      AppMethodBeat.o(145700);
    }
    
    public final void MO()
    {
      AppMethodBeat.i(145699);
      ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.drx) });
      this.imz = "";
      String str;
      Object localObject;
      if (this.drx == 0)
      {
        str = this.appId;
        localObject = this.cQO;
        ac.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
        v localv = new v();
        localv.cZg.action = 10;
        localv.cZg.appId = str;
        localv.cZg.cQO = ((String)localObject);
        com.tencent.mm.plugin.music.b.a.a(localv);
        this.cQO = localv.cZg.cQO;
        ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.cQO });
        if (TextUtils.isEmpty(this.cQO)) {
          this.imz = "fail to create audio instance";
        }
      }
      for (;;)
      {
        Am();
        AppMethodBeat.o(145699);
        return;
        if (this.drx == 1)
        {
          ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
          str = this.appId;
          ac.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).cZg.action = 12;
          ((v)localObject).cZg.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
        }
        else if (this.drx == 2)
        {
          ac.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
          str = this.appId;
          ac.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
          localObject = new v();
          ((v)localObject).cZg.action = 9;
          ((v)localObject).cZg.appId = str;
          com.tencent.mm.plugin.music.b.a.a((v)localObject);
          com.tencent.mm.plugin.appbrand.media.a.a.OK(this.appId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d
 * JD-Core Version:    0.7.0.1
 */