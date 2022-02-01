package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  public static final int CTRL_INDEX = 874;
  public static final String NAME = "adOperateWXData";
  
  private void a(final g paramg, JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    AppMethodBeat.i(326883);
    boolean bool = paramJSONObject.optBoolean("keepAlive", false);
    Object localObject = paramg.getAppId();
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "appId is null");
      paramg.a(paramInt, ZP("fail:internal error"), paramo);
      AppMethodBeat.o(326883);
      return;
    }
    e.R((String)localObject, System.currentTimeMillis());
    for (;;)
    {
      deg localdeg;
      try
      {
        paramJSONObject = paramJSONObject.getString("data");
        localObject = f.kf(bool).bEF();
        localdeg = (deg)c.b.b(((com.tencent.mm.am.c)localObject).otB);
        localdeg.oOI = paramg.getAppId();
        if (paramJSONObject.getBytes() == null)
        {
          paramJSONObject = new byte[0];
          localdeg.vgA = new b(paramJSONObject);
          paramJSONObject = paramg.getRuntime();
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.asG();
            if (paramJSONObject != null) {
              localdeg.aaJu = paramJSONObject.qYY.qHO;
            }
          }
          if (!(paramg instanceof y)) {
            break label328;
          }
          if (localdeg.aaJv == null) {
            localdeg.aaJv = new glg();
          }
          localdeg.aaJv.acgQ = 1;
          if (((paramg.getRuntime() instanceof w)) && (((w)paramg.getRuntime()).asA().epn != null))
          {
            if (localdeg.aaJv == null) {
              localdeg.aaJv = new glg();
            }
            localdeg.aaJv.scene = ((w)paramg.getRuntime()).asA().epn.scene;
          }
          IPCRunCgi.a((com.tencent.mm.am.c)localObject, new IPCRunCgi.a()
          {
            public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
            {
              AppMethodBeat.i(326790);
              if (!paramg.a(k.this.getName(), paramo))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", new Object[] { Integer.valueOf(paramInt) });
                AppMethodBeat.o(326790);
                return;
              }
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(c.c.b(paramAnonymousc.otC) instanceof deh)))
              {
                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, c.c.b(paramAnonymousc.otC) });
                paramg.a(paramInt, k.this.ZP("fail invalid response"), paramo);
                AppMethodBeat.o(326790);
                return;
              }
              paramAnonymousc = (deh)c.c.b(paramAnonymousc.otC);
              if (paramAnonymousc.aaJx.hGE == 0)
              {
                paramAnonymousString = paramAnonymousc.vgA.ZV();
                if (Util.isNullOrNil(paramAnonymousString))
                {
                  Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
                  paramg.a(paramInt, k.this.ZP("fail invalid response"), paramo);
                  AppMethodBeat.o(326790);
                  return;
                }
                e.S(paramg.getAppId(), System.currentTimeMillis());
                Log.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", new Object[] { Integer.valueOf(paramInt), paramAnonymousc.vgA.ZV() });
                paramAnonymousc = new HashMap();
                paramAnonymousc.put("data", paramAnonymousString);
                paramg.a(paramInt, k.this.m("ok", paramAnonymousc), paramo);
                AppMethodBeat.o(326790);
                return;
              }
              paramg.a(paramInt, k.this.ZP("fail:errorCode:" + paramAnonymousc.aaJx.hGE + ",errorMsg:" + paramAnonymousc.aaJx.errmsg), paramo);
              AppMethodBeat.o(326790);
            }
          });
          AppMethodBeat.o(326883);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", new Object[] { paramJSONObject.getMessage() });
        paramg.a(paramInt, ZP("fail:invalid data"), paramo);
        AppMethodBeat.o(326883);
        return;
      }
      paramJSONObject = paramJSONObject.getBytes();
      continue;
      label328:
      if ((paramg instanceof ad))
      {
        if (localdeg.aaJv == null) {
          localdeg.aaJv = new glg();
        }
        localdeg.aaJv.acgQ = 2;
      }
    }
  }
  
  public final boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */