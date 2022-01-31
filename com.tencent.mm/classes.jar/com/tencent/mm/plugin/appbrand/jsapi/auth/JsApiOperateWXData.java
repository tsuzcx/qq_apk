package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends c
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, b paramb)
  {
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        paramJSONObject = new JsApiOperateWXData.OperateWXDataTask();
        paramJSONObject.appId = paramf.getAppId();
        paramJSONObject.gjL = "operateWXData";
        com.tencent.mm.plugin.appbrand.config.i locali = paramf.getRuntime().ZB();
        if (locali != null) {
          paramJSONObject.fJy = locali.fPS.fEM;
        }
        paramJSONObject.gjH = this;
        paramJSONObject.gjI = paramf;
        paramJSONObject.gjX = str;
        paramJSONObject.gfg = paramInt;
        paramJSONObject.gjJ = paramb;
        paramJSONObject.gjP = new Bundle();
        paramb = a.qp(paramJSONObject.appId);
        if (paramb != null) {
          paramJSONObject.ghm = paramb.scene;
        }
        if ((paramf instanceof o))
        {
          paramJSONObject.gjQ = 1;
          paramJSONObject.ahC();
          AppBrandMainProcessService.a(paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        y.e("MicroMsg.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramf.C(paramInt, h("fail", null));
        return;
      }
      if ((paramf instanceof q)) {
        paramJSONObject.gjQ = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */