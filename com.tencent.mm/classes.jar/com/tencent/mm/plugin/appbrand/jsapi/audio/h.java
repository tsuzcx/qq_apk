package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private k.a gix;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!com.tencent.mm.plugin.appbrand.media.a.a.vb(paramc.getAppId()))
    {
      y.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.C(paramInt, h("fail:App is paused or background", null));
      return;
    }
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    y.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    Long localLong2 = Long.valueOf(paramJSONObject.optLong("timestamp", 0L));
    Object localObject = Long.valueOf(0L);
    Long localLong1 = Long.valueOf(System.currentTimeMillis());
    paramJSONObject = (JSONObject)localObject;
    if (localLong2.longValue() > 0L)
    {
      paramJSONObject = (JSONObject)localObject;
      if (localLong2.longValue() < localLong1.longValue()) {
        paramJSONObject = Long.valueOf(localLong1.longValue() - localLong2.longValue());
      }
    }
    y.d("MicroMsg.Audio.JsApiOperateAudio", "leonlaudio operateAudio jsCallTime:%s jsInvokeTime:%s,invokeCallTime:%s", new Object[] { localLong2, paramJSONObject, localLong1 });
    if (TextUtils.isEmpty(str1))
    {
      y.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.C(paramInt, h("fail:audioId is empty", null));
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      y.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.C(paramInt, h("fail:operationType is empty", null));
      return;
    }
    if (this.gix == null) {
      this.gix = new k.a(this, paramc, paramInt);
    }
    this.gix.appId = paramc.getAppId();
    this.gix.ahU();
    localObject = new h.a(this, paramc, paramInt);
    ((h.a)localObject).appId = paramc.getAppId();
    ((h.a)localObject).bFM = str1;
    ((h.a)localObject).bFN = i;
    ((h.a)localObject).giy = str2;
    ((h.a)localObject).eaT = paramJSONObject.longValue();
    ((h.a)localObject).eaU = localLong1.longValue();
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.uZ(str1);
    if (paramc != null)
    {
      ((h.a)localObject).giz = paramc.giz;
      ((h.a)localObject).fCl = paramc.fCl;
      ((h.a)localObject).eaY = paramc.eaY;
    }
    ((h.a)localObject).processName = ae.getProcessName();
    ((h.a)localObject).ahU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */