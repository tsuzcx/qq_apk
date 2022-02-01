package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class j
  extends i
{
  public static final int CTRL_INDEX = 874;
  public static final String NAME = "adOperateWXData";
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(222405);
    com.tencent.mm.plugin.appbrand.ad.e.M(paramd.getAppId(), System.currentTimeMillis());
    for (;;)
    {
      bsa localbsa;
      try
      {
        paramJSONObject = paramJSONObject.getString("data");
        parame = new b.a();
        parame.hQF = new bsa();
        parame.hQG = new bsb();
        parame.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        parame.funcId = 1133;
        parame.hQH = 0;
        parame.respCmdId = 0;
        parame = parame.aDS();
        localbsa = (bsa)parame.hQD.hQJ;
        localbsa.ikm = paramd.getAppId();
        if (paramJSONObject.getBytes() == null)
        {
          paramJSONObject = new byte[0];
          localbsa.nIq = new com.tencent.mm.bw.b(paramJSONObject);
          paramJSONObject = paramd.getRuntime().Fm();
          if (paramJSONObject != null) {
            localbsa.HeR = paramJSONObject.kbw.jLV;
          }
          if (!(paramd instanceof r)) {
            break label332;
          }
          if (localbsa.HeS == null) {
            localbsa.HeS = new eio();
          }
          localbsa.HeS.IlP = 1;
          if (((paramd.getRuntime() instanceof p)) && (((p)paramd.getRuntime()).Fg().cmE != null))
          {
            if (localbsa.HeS == null) {
              localbsa.HeS = new eio();
            }
            localbsa.HeS.scene = ((p)paramd.getRuntime()).Fg().cmE.scene;
          }
          IPCRunCgi.a(parame, new j.1(this, paramd, paramInt));
          AppMethodBeat.o(222405);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ae.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.h(paramInt, e("fail:invalid data", null));
        AppMethodBeat.o(222405);
        return;
      }
      paramJSONObject = paramJSONObject.getBytes();
      continue;
      label332:
      if ((paramd instanceof z))
      {
        if (localbsa.HeS == null) {
          localbsa.HeS = new eio();
        }
        localbsa.HeS.IlP = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */