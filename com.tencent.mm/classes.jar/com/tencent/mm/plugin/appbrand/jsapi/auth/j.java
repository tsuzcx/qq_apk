package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cd.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends c<g>
{
  public static final int CTRL_INDEX = 874;
  public static final String NAME = "adOperateWXData";
  
  private void a(final g paramg, JSONObject paramJSONObject, final int paramInt, final com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    AppMethodBeat.i(272589);
    boolean bool = paramJSONObject.optBoolean("keepAlive", false);
    Object localObject = paramg.getAppId();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "appId is null");
      paramg.a(paramInt, h("fail:internal error", null), paramo);
      AppMethodBeat.o(272589);
      return;
    }
    e.M((String)localObject, System.currentTimeMillis());
    for (;;)
    {
      cno localcno;
      try
      {
        paramJSONObject = paramJSONObject.getString("data");
        localObject = f.iX(bool).bgN();
        localcno = (cno)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
        localcno.lVG = paramg.getAppId();
        if (paramJSONObject.getBytes() == null)
        {
          paramJSONObject = new byte[0];
          localcno.rVk = new b(paramJSONObject);
          paramJSONObject = paramg.getRuntime();
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.Sp();
            if (paramJSONObject != null) {
              localcno.TuP = paramJSONObject.nYR.nHY;
            }
          }
          if (!(paramg instanceof v)) {
            break label330;
          }
          if (localcno.TuQ == null) {
            localcno.TuQ = new foh();
          }
          localcno.TuQ.UMw = 1;
          if (((paramg.getRuntime() instanceof t)) && (((t)paramg.getRuntime()).Sk().cxf != null))
          {
            if (localcno.TuQ == null) {
              localcno.TuQ = new foh();
            }
            localcno.TuQ.scene = ((t)paramg.getRuntime()).Sk().cxf.scene;
          }
          IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
            {
              AppMethodBeat.i(272722);
              if (!paramg.a(j.this.getName(), paramo))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", new Object[] { Integer.valueOf(paramInt) });
                AppMethodBeat.o(272722);
                return;
              }
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(d.c.b(paramAnonymousd.lBS) instanceof cnp)))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, d.c.b(paramAnonymousd.lBS) });
                paramg.a(paramInt, j.this.h("fail invalid response", null), paramo);
                AppMethodBeat.o(272722);
                return;
              }
              paramAnonymousd = (cnp)d.c.b(paramAnonymousd.lBS);
              if (paramAnonymousd.TuR.fBP == 0)
              {
                paramAnonymousString = paramAnonymousd.rVk.Ap();
                if (Util.isNullOrNil(paramAnonymousString))
                {
                  Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
                  paramg.a(paramInt, j.this.h("fail invalid response", null), paramo);
                  AppMethodBeat.o(272722);
                  return;
                }
                e.N(paramg.getAppId(), System.currentTimeMillis());
                Log.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", new Object[] { Integer.valueOf(paramInt), paramAnonymousd.rVk.Ap() });
                paramAnonymousd = new HashMap();
                paramAnonymousd.put("data", paramAnonymousString);
                paramg.a(paramInt, j.this.m("ok", paramAnonymousd), paramo);
                AppMethodBeat.o(272722);
                return;
              }
              paramg.a(paramInt, j.this.h("fail:errorCode:" + paramAnonymousd.TuR.fBP + ",errorMsg:" + paramAnonymousd.TuR.errmsg, null), paramo);
              AppMethodBeat.o(272722);
            }
          });
          AppMethodBeat.o(272589);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", new Object[] { paramJSONObject.getMessage() });
        paramg.a(paramInt, h("fail:invalid data", null), paramo);
        AppMethodBeat.o(272589);
        return;
      }
      paramJSONObject = paramJSONObject.getBytes();
      continue;
      label330:
      if ((paramg instanceof ad))
      {
        if (localcno.TuQ == null) {
          localcno.TuQ = new foh();
        }
        localcno.TuQ.UMw = 2;
      }
    }
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */