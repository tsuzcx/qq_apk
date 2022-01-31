package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState
  extends s
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramc = paramc.getAppId();
    paramJSONObject = new JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask();
    paramJSONObject.appId = paramc;
    if (!AppBrandMainProcessService.b(paramJSONObject))
    {
      y.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      return h("fail", null);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(paramJSONObject.duration));
    localHashMap.put("currentTime", Integer.valueOf(paramJSONObject.bFN));
    boolean bool;
    if (paramJSONObject.eCF == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(paramJSONObject.eaX));
      localHashMap.put("src", paramJSONObject.eaY);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.gip);
      localHashMap.put("singer", paramJSONObject.giq);
      localHashMap.put("coverImgUrl", paramJSONObject.gir);
      localHashMap.put("webUrl", paramJSONObject.gis);
      if (paramJSONObject.protocol != null) {
        break label314;
      }
      paramc = "";
      label220:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.startTime / 1000));
      if (!TextUtils.isEmpty(paramJSONObject.gio)) {
        break label322;
      }
    }
    label314:
    label322:
    for (paramc = "";; paramc = paramJSONObject.gio)
    {
      if (!paramJSONObject.error) {
        break label330;
      }
      y.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      return h("fail:" + paramc, null);
      bool = false;
      break;
      paramc = paramJSONObject.protocol;
      break label220;
    }
    label330:
    y.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    return h("ok", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */