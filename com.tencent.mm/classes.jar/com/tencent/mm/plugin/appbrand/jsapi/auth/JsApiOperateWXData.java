package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(143383);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(143383);
      return;
    }
    try
    {
      JsApiOperateWXData.OperateWXDataTask.aBY();
      String[] arrayOfString = JsApiOperateWXData.OperateWXDataTask.aBZ().allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(143383);
        return;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(str)) && (str.startsWith(paramString))) {
          JsApiOperateWXData.OperateWXDataTask.aBZ().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(143383);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localThrowable });
      AppMethodBeat.o(143383);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, d paramd)
  {
    AppMethodBeat.i(130895);
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        paramJSONObject = new JsApiOperateWXData.OperateWXDataTask();
        paramJSONObject.appId = paramh.getAppId();
        paramJSONObject.hDy = "operateWXData";
        com.tencent.mm.plugin.appbrand.config.h localh = paramh.getRuntime().wY();
        if (localh != null) {
          paramJSONObject.hcr = localh.hiX.gXe;
        }
        paramJSONObject.hDu = this;
        paramJSONObject.hDv = paramh;
        paramJSONObject.hDT = str;
        paramJSONObject.hry = paramInt;
        paramJSONObject.hDw = paramd;
        paramJSONObject.hDX = new HashMap();
        paramd = a.xN(paramJSONObject.appId);
        if (paramd != null) {
          paramJSONObject.hzB = paramd.scene;
        }
        if ((paramh instanceof r))
        {
          paramJSONObject.hDJ = 1;
          paramJSONObject.aBj();
          AppBrandMainProcessService.a(paramJSONObject);
          AppMethodBeat.o(130895);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramh.h(paramInt, j("fail", null));
        AppMethodBeat.o(130895);
        return;
      }
      if ((paramh instanceof v)) {
        paramJSONObject.hDJ = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */