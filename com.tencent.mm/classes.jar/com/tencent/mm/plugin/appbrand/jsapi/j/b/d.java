package com.tencent.mm.plugin.appbrand.jsapi.j.b;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(179534);
    ad.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiOperateRequestTask", "data is null");
      AppMethodBeat.o(179534);
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.h(paramInt, e("fail:requestTaskId is null or nil", null));
      AppMethodBeat.o(179534);
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(179534);
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.bip().Lb(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateRequestTask", "request is null");
        AppMethodBeat.o(179534);
        return;
      }
      e locale = paramJSONObject.La(str);
      int i;
      if (locale != null)
      {
        ad.i("MicroMsg.AppBrandNetworkRequest", "lm:try to abortTask taskId:%s, appId:%s", new Object[] { locale.hLO, paramJSONObject.kUQ });
        paramJSONObject.kUM.add(locale.hLO);
        paramJSONObject.a(locale.hLO, locale.kVh);
        if (!bt.isNullOrNil(locale.kVi)) {
          CronetLogic.cancelCronetTask(locale.kVi);
        }
        i = 1;
      }
      while (i == 0)
      {
        paramc.h(paramInt, e("fail:no task", null));
        ad.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
        AppMethodBeat.o(179534);
        return;
        if (!paramJSONObject.kUN.contains(str))
        {
          i = 0;
        }
        else
        {
          paramJSONObject.kUM.add(str);
          i = 1;
        }
      }
      paramc.h(paramInt, e("ok", null));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().h(paramc).HK(paramJSONObject).aXQ();
      ad.i("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
      AppMethodBeat.o(179534);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    AppMethodBeat.o(179534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.d
 * JD-Core Version:    0.7.0.1
 */