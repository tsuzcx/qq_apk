package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class j
  extends i
{
  public static final int CTRL_INDEX = 874;
  public static final String NAME = "adOperateWXData";
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(188279);
    com.tencent.mm.plugin.appbrand.ad.d.M(paramd.getAppId(), System.currentTimeMillis());
    for (;;)
    {
      brg localbrg;
      try
      {
        paramJSONObject = paramJSONObject.getString("data");
        parame = new b.a();
        parame.hNM = new brg();
        parame.hNN = new brh();
        parame.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        parame.funcId = 1133;
        parame.hNO = 0;
        parame.respCmdId = 0;
        parame = parame.aDC();
        localbrg = (brg)parame.hNK.hNQ;
        localbrg.iht = paramd.getAppId();
        if (paramJSONObject.getBytes() == null)
        {
          paramJSONObject = new byte[0];
          localbrg.nCV = new com.tencent.mm.bx.b(paramJSONObject);
          paramJSONObject = paramd.getRuntime().Fh();
          if (paramJSONObject != null) {
            localbrg.GLq = paramJSONObject.jYh.jIU;
          }
          if (!(paramd instanceof q)) {
            break label332;
          }
          if (localbrg.GLr == null) {
            localbrg.GLr = new egx();
          }
          localbrg.GLr.HRI = 1;
          if (((paramd.getRuntime() instanceof o)) && (((o)paramd.getRuntime()).Fb().cmC != null))
          {
            if (localbrg.GLr == null) {
              localbrg.GLr = new egx();
            }
            localbrg.GLr.scene = ((o)paramd.getRuntime()).Fb().cmC.scene;
          }
          IPCRunCgi.a(parame, new j.1(this, paramd, paramInt));
          AppMethodBeat.o(188279);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.h(paramInt, e("fail:invalid data", null));
        AppMethodBeat.o(188279);
        return;
      }
      paramJSONObject = paramJSONObject.getBytes();
      continue;
      label332:
      if ((paramd instanceof aa))
      {
        if (localbrg.GLr == null) {
          localbrg.GLr = new egx();
        }
        localbrg.GLr.HRI = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */