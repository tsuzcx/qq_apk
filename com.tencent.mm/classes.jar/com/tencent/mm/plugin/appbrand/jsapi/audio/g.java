package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145708);
    a(paramc, paramJSONObject, paramInt, paramc.aYh());
    AppMethodBeat.o(145708);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(198673);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(198673);
      return;
    }
    ad.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ad.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(198673);
      return;
    }
    paramo = new a(this, paramc, paramInt);
    paramo.appId = paramc.getAppId();
    paramo.dce = paramJSONObject;
    paramo.aOD();
    c.kvZ.Pk(paramc.getAppId()).remove(paramJSONObject);
    AppMethodBeat.o(198673);
  }
  
  public final boolean bij()
  {
    return true;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String dce = "";
    public boolean error = false;
    public int kje;
    private m kry;
    public com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kry = paramm;
      this.ktc = paramc;
      this.kje = paramInt;
    }
    
    public final void BJ()
    {
      AppMethodBeat.i(145707);
      super.BJ();
      ad.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
        AppMethodBeat.o(145707);
        return;
      }
      if (this.error)
      {
        this.ktc.h(this.kje, this.kry.e("fail", null));
        AppMethodBeat.o(145707);
        return;
      }
      this.ktc.h(this.kje, this.kry.e("ok", null));
      AppMethodBeat.o(145707);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145706);
      ad.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
      String str = this.dce;
      ad.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
      v localv = new v();
      localv.dky.action = 5;
      localv.dky.dce = str;
      com.tencent.mm.plugin.music.b.a.a(localv);
      this.error = localv.dkz.result;
      BJ();
      AppMethodBeat.o(145706);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */