package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState
  extends a
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask giA;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramc, paramInt);
  }
  
  protected String a(JSONObject paramJSONObject, c paramc)
  {
    return paramJSONObject.optString("src");
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      return;
    }
    String str = paramc.getAppId();
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { str, paramJSONObject.toString() });
    if (this.giA == null) {
      this.giA = a(this, paramc, paramInt);
    }
    this.giA.gfg = paramInt;
    this.giA.appId = str;
    JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.a(this.giA);
    ??? = u.ij("AppBrandService#" + paramc.hashCode());
    a((String)???, paramc);
    synchronized (u.Hc().v((String)???, true))
    {
      if ((g.b)((u.b)???).get("AppBrandLifeCycle.Listener", null) == null)
      {
        JsApiSetBackgroundAudioState.1 local1 = new JsApiSetBackgroundAudioState.1(this, (u.b)???, paramc, paramInt);
        ((u.b)???).h("AppBrandLifeCycle.Listener", local1);
        this.giA.gda = local1;
      }
      AppBrandMainProcessService.a(this.giA);
      ??? = b(this, paramc, paramInt);
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).gfg = paramInt;
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).appId = str;
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).giD = paramJSONObject.toString();
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).bTY = a(paramJSONObject, paramc);
      AppBrandMainProcessService.a((MainProcessTask)???);
      return;
    }
  }
  
  protected void a(String paramString, c paramc) {}
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(this, paramc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */