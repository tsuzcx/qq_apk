package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends i
{
  public static final int CTRL_INDEX = 874;
  public static final String NAME = "adOperateWXData";
  
  public final void a(final com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, final int paramInt, e parame)
  {
    AppMethodBeat.i(226688);
    parame = paramd.getAppId();
    if (parame == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "appId is null");
      paramd.i(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(226688);
      return;
    }
    com.tencent.mm.plugin.appbrand.ad.e.M(parame, System.currentTimeMillis());
    for (;;)
    {
      ceu localceu;
      try
      {
        paramJSONObject = paramJSONObject.getString("data");
        parame = f.id(this.iLM).aXF();
        localceu = (ceu)parame.iLK.iLR;
        localceu.jfi = paramd.getAppId();
        if (paramJSONObject.getBytes() == null)
        {
          paramJSONObject = new byte[0];
          localceu.oTm = new b(paramJSONObject);
          paramJSONObject = paramd.getRuntime();
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.OT();
            if (paramJSONObject != null) {
              localceu.MjZ = paramJSONObject.leE.kNW;
            }
          }
          if (!(paramd instanceof s)) {
            break label317;
          }
          if (localceu.Mka == null) {
            localceu.Mka = new fdg();
          }
          localceu.Mka.NyS = 1;
          if (((paramd.getRuntime() instanceof q)) && (((q)paramd.getRuntime()).ON().cyA != null))
          {
            if (localceu.Mka == null) {
              localceu.Mka = new fdg();
            }
            localceu.Mka.scene = ((q)paramd.getRuntime()).ON().cyA.scene;
          }
          IPCRunCgi.a(parame, new IPCRunCgi.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
            {
              AppMethodBeat.i(226687);
              if ((!paramd.bsV()) && (!paramd.isRunning()))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", new Object[] { Integer.valueOf(paramInt) });
                AppMethodBeat.o(226687);
                return;
              }
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(paramAnonymousd.iLL.iLR instanceof cev)))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousd.iLL.iLR });
                paramd.i(paramInt, j.this.h("fail invalid response", null));
                AppMethodBeat.o(226687);
                return;
              }
              paramAnonymousd = (cev)paramAnonymousd.iLL.iLR;
              if (paramAnonymousd.Mkb.dIZ == 0)
              {
                paramAnonymousString = paramAnonymousd.oTm.yO();
                if (Util.isNullOrNil(paramAnonymousString))
                {
                  Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
                  paramd.i(paramInt, j.this.h("fail invalid response", null));
                  AppMethodBeat.o(226687);
                  return;
                }
                com.tencent.mm.plugin.appbrand.ad.e.N(paramd.getAppId(), System.currentTimeMillis());
                Log.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", new Object[] { Integer.valueOf(paramInt), paramAnonymousd.oTm });
                paramAnonymousd = new HashMap();
                paramAnonymousd.put("data", paramAnonymousString);
                paramd.i(paramInt, j.this.n("ok", paramAnonymousd));
                AppMethodBeat.o(226687);
                return;
              }
              paramd.i(paramInt, j.this.h("fail:errorCode:" + paramAnonymousd.Mkb.dIZ + ",errorMsg:" + paramAnonymousd.Mkb.dJa, null));
              AppMethodBeat.o(226687);
            }
          });
          AppMethodBeat.o(226688);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.i(paramInt, h("fail:invalid data", null));
        AppMethodBeat.o(226688);
        return;
      }
      paramJSONObject = paramJSONObject.getBytes();
      continue;
      label317:
      if ((paramd instanceof ac))
      {
        if (localceu.Mka == null) {
          localceu.Mka = new fdg();
        }
        localceu.Mka.NyS = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */