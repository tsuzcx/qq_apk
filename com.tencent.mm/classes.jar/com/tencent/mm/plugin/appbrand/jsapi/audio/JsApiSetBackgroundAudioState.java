package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState
  extends a
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask hBT;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(137793);
    parama = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramc, paramInt);
    AppMethodBeat.o(137793);
    return parama;
  }
  
  protected String a(JSONObject paramJSONObject, c paramc)
  {
    AppMethodBeat.i(137791);
    paramJSONObject = paramJSONObject.optString("src");
    AppMethodBeat.o(137791);
    return paramJSONObject;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137790);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(137790);
      return;
    }
    String str = paramc.getAppId();
    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { str, paramJSONObject.toString() });
    if (this.hBT == null) {
      this.hBT = a(this, paramc, paramInt);
    }
    this.hBT.hry = paramInt;
    this.hBT.appId = str;
    JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.a(this.hBT);
    ??? = v.oQ("AppBrandService#" + paramc.hashCode());
    a((String)???, paramc);
    synchronized (v.aae().z((String)???, true))
    {
      if ((e.c)((v.b)???).get("AppBrandLifeCycle.Listener", null) == null)
      {
        JsApiSetBackgroundAudioState.1 local1 = new JsApiSetBackgroundAudioState.1(this, (v.b)???, paramc, paramInt);
        ((v.b)???).i("AppBrandLifeCycle.Listener", local1);
        ((v.b)???).i("appId", str);
        this.hBT.bCv = local1;
      }
      AppBrandMainProcessService.a(this.hBT);
      ??? = b(this, paramc, paramInt);
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).hry = paramInt;
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).appId = str;
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).hBW = paramJSONObject.toString();
      ((JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask)???).cBD = a(paramJSONObject, paramc);
      AppBrandMainProcessService.a((MainProcessTask)???);
      AppMethodBeat.o(137790);
      return;
    }
  }
  
  protected void a(String paramString, c paramc) {}
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(137792);
    parama = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(this, paramc, paramInt);
    AppMethodBeat.o(137792);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */