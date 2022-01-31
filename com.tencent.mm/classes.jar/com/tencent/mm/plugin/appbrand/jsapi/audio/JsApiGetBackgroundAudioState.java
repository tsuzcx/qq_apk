package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState
  extends u
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137736);
    paramc = paramc.getAppId();
    paramJSONObject = new JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask();
    paramJSONObject.appId = paramc;
    if (!AppBrandMainProcessService.b(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramc = j("fail", null);
      AppMethodBeat.o(137736);
      return paramc;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.hBG));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.hBH));
    boolean bool;
    if (paramJSONObject.fSw == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.hBI));
      localHashMap.put("src", paramJSONObject.ceq);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.hBJ);
      localHashMap.put("singer", paramJSONObject.hBK);
      localHashMap.put("coverImgUrl", paramJSONObject.hBL);
      localHashMap.put("webUrl", paramJSONObject.hBM);
      if (paramJSONObject.protocol != null) {
        break label326;
      }
      paramc = "";
      label232:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.startTime / 1000));
      if (!TextUtils.isEmpty(paramJSONObject.hBF)) {
        break label334;
      }
    }
    label326:
    label334:
    for (paramc = "";; paramc = paramJSONObject.hBF)
    {
      if (!paramJSONObject.error) {
        break label342;
      }
      ab.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      paramc = j("fail:".concat(String.valueOf(paramc)), null);
      AppMethodBeat.o(137736);
      return paramc;
      bool = false;
      break;
      paramc = paramJSONObject.protocol;
      break label232;
    }
    label342:
    ab.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramc = j("ok", localHashMap);
    AppMethodBeat.o(137736);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */