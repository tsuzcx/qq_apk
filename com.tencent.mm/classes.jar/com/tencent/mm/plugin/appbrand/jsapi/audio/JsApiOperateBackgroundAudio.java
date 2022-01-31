package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio
  extends a
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask giA;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramc, paramInt);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      return;
    }
    String str = paramc.getAppId();
    y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.giA == null) {
      this.giA = a(this, paramc, paramInt);
    }
    this.giA.gfg = paramInt;
    this.giA.appId = str;
    h(paramc);
    paramc = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask(this, paramc, paramInt);
    paramc.gfg = paramInt;
    paramc.appId = str;
    paramc.giD = paramJSONObject.toString();
    AppBrandMainProcessService.a(paramc);
  }
  
  protected void h(c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
 * JD-Core Version:    0.7.0.1
 */