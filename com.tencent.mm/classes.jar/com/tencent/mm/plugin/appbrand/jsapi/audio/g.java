package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private j.a hBQ;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(137747);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.Dx(paramc.getAppId()))
    {
      ab.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, j("fail:App is paused or background", null));
      AppMethodBeat.o(137747);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(137747);
      return;
    }
    ab.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      ab.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.h(paramInt, j("fail:audioId is empty", null));
      AppMethodBeat.o(137747);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      ab.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.h(paramInt, j("fail:operationType is empty", null));
      AppMethodBeat.o(137747);
      return;
    }
    if (this.hBQ == null) {
      this.hBQ = new j.a(this, paramc, paramInt);
    }
    this.hBQ.appId = paramc.getAppId();
    this.hBQ.aBL();
    g.a locala = new g.a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.ceu = str1;
    locala.cmU = i;
    locala.hBR = str2;
    if (str2.equalsIgnoreCase("play"))
    {
      long l4 = paramJSONObject.optLong("timestamp", 0L);
      long l3 = System.currentTimeMillis();
      long l1 = l2;
      if (l4 > 0L)
      {
        l1 = l2;
        if (l4 < l3) {
          l1 = l3 - l4;
        }
      }
      locala.frc = l1;
      locala.frd = l3;
    }
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.Dv(str1);
    if (paramc != null)
    {
      locala.hBS = paramc.hBS;
      locala.gUy = paramc.gUy;
      locala.ceq = paramc.ceq;
    }
    locala.processName = ah.getProcessName();
    locala.aBL();
    AppMethodBeat.o(137747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */