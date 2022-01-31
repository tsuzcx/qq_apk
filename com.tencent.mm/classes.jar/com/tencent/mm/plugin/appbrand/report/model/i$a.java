package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Set;

final class i$a
  implements Runnable
{
  String appId;
  String cmG;
  String cvF;
  String hCt;
  String iHa;
  int iHb;
  long iHc;
  
  private String aLn()
  {
    AppMethodBeat.i(132618);
    Object localObject1 = "";
    if ((bo.isNullOrNil(this.cvF)) || (bo.isNullOrNil(this.iHa)))
    {
      AppMethodBeat.o(132618);
      return "";
    }
    for (;;)
    {
      try
      {
        localObject2 = this.iHa;
        i = -1;
        int j = ((String)localObject2).hashCode();
        switch (j)
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
      catch (g localg)
      {
        Object localObject2;
        int i;
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localg, "get keyParam error!", new Object[0]);
        continue;
      }
      AppMethodBeat.o(132618);
      return localObject1;
      if (((String)localObject2).equals("getLocation"))
      {
        i = 0;
        continue;
        localObject2 = com.tencent.mm.aa.h.mp(this.cvF);
        localObject2 = String.format("%s;%s;%s;%s;%s;%s;%s", new Object[] { ((c)localObject2).optString("latitude"), ((c)localObject2).optString("longitude"), ((c)localObject2).optString("speed"), ((c)localObject2).optString("accuracy"), ((c)localObject2).optString("altitude"), ((c)localObject2).optString("verticalAccuracy"), ((c)localObject2).optString("horizontalAccuracy") });
        localObject1 = localObject2;
      }
    }
  }
  
  private String b(c paramc)
  {
    AppMethodBeat.i(132619);
    Object localObject = new com.tencent.mm.aa.i();
    for (;;)
    {
      try
      {
        str = this.iHa;
        i = -1;
        int j = str.hashCode();
        switch (j)
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
      catch (g paramc)
      {
        String str;
        int i;
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", paramc, "get keyParam error!", new Object[0]);
        continue;
      }
      paramc = null;
      try
      {
        localObject = URLEncoder.encode(((com.tencent.mm.aa.i)localObject).toString(), "UTF-8");
        paramc = (c)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        continue;
      }
      AppMethodBeat.o(132619);
      return paramc;
      if (str.equals("chooseImage"))
      {
        i = 0;
        continue;
        ((com.tencent.mm.aa.i)localObject).f("sizeType", paramc.optString("sizeType"));
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(132617);
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.xN(this.appId);
    if (localAppBrandStatObject == null)
    {
      ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
      AppMethodBeat.o(132617);
      return;
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if (!i.aBJ().contains(this.iHa))
    {
      localObject3 = "";
      localObject4 = "";
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (!bo.isNullOrNil(this.hCt))
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (bo.isNullOrNil(this.iHa)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject6 = com.tencent.mm.aa.h.mp(this.hCt);
        localObject1 = b((c)localObject6);
        localObject2 = localObject3;
      }
      catch (g localg1)
      {
        Object localObject6;
        String str4;
        label336:
        label874:
        localObject1 = localObject5;
        localObject2 = localObject3;
      }
      for (;;)
      {
        try
        {
          if (((c)localObject6).has("url"))
          {
            localObject2 = localObject3;
            if (!this.iHa.equals("openLink"))
            {
              localObject2 = localObject3;
              if (!this.iHa.equals("redirectTo"))
              {
                localObject2 = localObject3;
                if (!this.iHa.equals("navigateTo"))
                {
                  localObject2 = localObject3;
                  if (!this.iHa.equals("request"))
                  {
                    localObject2 = localObject3;
                    if (!this.iHa.equals("connectSocket"))
                    {
                      localObject2 = localObject3;
                      if (!this.iHa.equals("uploadFile"))
                      {
                        localObject2 = localObject3;
                        if (!this.iHa.equals("downloadFile")) {
                          break label874;
                        }
                      }
                    }
                  }
                }
              }
            }
            localObject2 = localObject3;
            localObject3 = ((c)localObject6).optString("url");
            localObject2 = localObject3;
            str4 = aLn();
            localObject4 = "";
            localObject3 = localObject4;
            if (!bo.isNullOrNil(this.cmG))
            {
              localObject3 = localObject4;
              if (this.cmG.contains(".html")) {
                localObject3 = this.cmG.substring(0, this.cmG.lastIndexOf(".html") + 5);
              }
            }
            localObject4 = "";
          }
        }
        catch (g localg2)
        {
          continue;
        }
        try
        {
          localObject6 = URLEncoder.encode(bo.nullAsNil((String)localObject3), "UTF-8");
          localObject4 = localObject6;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException2, "encode page path error!", new Object[0]);
          break label336;
        }
      }
      localObject6 = "";
      try
      {
        localObject7 = URLEncoder.encode(bo.nullAsNil((String)localObject2), "UTF-8");
        localObject6 = localObject7;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException3)
      {
        Object localObject7;
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException3, "encode keyParam path error!", new Object[0]);
        continue;
      }
      localObject7 = "";
      try
      {
        str3 = URLEncoder.encode(bo.nullAsNil(str4), "UTF-8");
        localObject7 = str3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException4)
      {
        String str3;
        String str5;
        int i;
        String str6;
        String str7;
        AppBrandSysConfigWC localAppBrandSysConfigWC;
        int j;
        int k;
        int m;
        boolean bool;
        Object localObject5;
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException4, "encode keyResult path error!", new Object[0]);
        continue;
      }
      str3 = bo.nullAsNil(this.iHa);
      str5 = i.EJ(this.cvF);
      i = i.EK(str5);
      str6 = bo.nullAsNil(localAppBrandStatObject.cmF);
      str7 = e.cZ(ah.getContext());
      if (localAppBrandStatObject.scene == 0) {
        localAppBrandStatObject.scene = 1000;
      }
      localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.a.xM(this.appId);
      if (localAppBrandSysConfigWC != null)
      {
        j = localAppBrandSysConfigWC.hiX.gXf;
        k = localAppBrandSysConfigWC.hiX.gXe + 1;
        m = e.ED(this.appId);
        ab.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str6, this.appId, Integer.valueOf(j), Integer.valueOf(k), localObject3, str7, str3, localObject2, Integer.valueOf(i), Integer.valueOf(this.iHb), Integer.valueOf(0), Long.valueOf(this.iHc), Integer.valueOf(0), str5, Integer.valueOf(localAppBrandStatObject.iFX), Integer.valueOf(m), str4, localObject1 });
        localObject2 = new Object[21];
        localObject2[0] = Integer.valueOf(localAppBrandStatObject.scene);
        localObject2[1] = str6;
        localObject2[2] = this.appId;
        localObject2[3] = Integer.valueOf(j);
        localObject2[4] = Integer.valueOf(k);
        localObject2[5] = localObject4;
        localObject2[6] = str7;
        localObject2[7] = str3;
        localObject2[8] = localObject6;
        localObject2[9] = Integer.valueOf(i);
        localObject2[10] = Integer.valueOf(this.iHb);
        localObject2[11] = Integer.valueOf(0);
        localObject2[12] = Long.valueOf(this.iHc);
        localObject2[13] = Integer.valueOf(0);
        localObject2[14] = str5;
        localObject2[15] = Integer.valueOf(localAppBrandStatObject.iFX);
        localObject2[16] = Integer.valueOf(localAppBrandStatObject.cJb);
        localObject2[17] = localAppBrandStatObject.cJc;
        localObject2[18] = Integer.valueOf(m);
        localObject2[19] = localObject7;
        localObject2[20] = localObject1;
        localObject1 = com.tencent.mm.plugin.appbrand.report.a.iFe;
        com.tencent.mm.plugin.appbrand.report.a.a(13542, true, (Object[])localObject2);
        if (i.aLm().contains(str3))
        {
          localObject1 = com.tencent.mm.plugin.appbrand.report.a.iFe;
          com.tencent.mm.plugin.appbrand.report.a.e(15761, (Object[])localObject2);
        }
      }
      AppMethodBeat.o(132617);
      return;
      localObject2 = localObject3;
      bool = this.iHa.equals("authorize");
      if (bool)
      {
        localObject2 = localObject3;
        try
        {
          localObject4 = com.tencent.mm.aa.h.mq(((c)localObject6).optString("scope"));
          localObject2 = localObject3;
          localObject6 = new LinkedList();
          i = 0;
          localObject2 = localObject3;
          if (i < ((com.tencent.mm.aa.a)localObject4).length())
          {
            localObject2 = localObject3;
            ((LinkedList)localObject6).add(((com.tencent.mm.aa.a)localObject4).optString(i));
            i += 1;
            continue;
          }
          localObject2 = localObject3;
        }
        catch (Exception localException1)
        {
          localObject2 = localObject3;
          ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", new Object[] { localException1.getMessage() });
          AppMethodBeat.o(132617);
          return;
        }
        localObject3 = ((LinkedList)localObject6).toString();
        localObject2 = localObject3;
      }
      else
      {
        localObject2 = localObject3;
        bool = this.iHa.equals("shareAppMessage");
        if (bool)
        {
          localObject2 = localObject3;
          try
          {
            String str1 = URLEncoder.encode(bo.nullAsNil(localObject6.toString()), "UTF-8");
            localObject2 = str1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            localObject2 = localObject3;
            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException1, "", new Object[0]);
            localObject2 = localObject3;
          }
        }
        else
        {
          localObject2 = localObject3;
          if (this.iHa.equals("requestPayment"))
          {
            localObject2 = localObject3;
            localObject3 = ((c)localObject6).optString("package");
            localObject2 = localObject3;
          }
          else
          {
            localObject2 = localObject3;
            if (this.iHa.equals("reportSubmitForm"))
            {
              localObject2 = localObject3;
              localObject3 = n.yc(this.appId).gQV;
              localObject2 = localObject3;
            }
            else
            {
              localObject2 = localObject3;
              if (this.iHa.equals("makePhoneCall"))
              {
                localObject2 = localObject3;
                localObject3 = ((c)localObject6).optString("phoneNumber");
                localObject2 = localObject3;
              }
              else
              {
                localObject2 = localObject3;
                if (this.iHa.equals("chooseVideo"))
                {
                  localObject2 = localObject3;
                  localObject3 = ((c)localObject6).optString("maxDuration");
                  localObject2 = localObject3;
                }
                else
                {
                  localObject2 = localObject3;
                  if (this.iHa.equals("updateHTMLWebView"))
                  {
                    localObject2 = localObject3;
                    localObject3 = ((c)localObject6).optString("src");
                    localObject2 = localObject3;
                    try
                    {
                      String str2 = URLEncoder.encode(((c)localObject6).optString("src"), "UTF-8");
                      localObject2 = str2;
                    }
                    catch (Exception localException2)
                    {
                      localObject2 = localObject3;
                      ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException2.toString());
                      localObject2 = localObject3;
                    }
                  }
                  else
                  {
                    localObject2 = localObject3;
                    if (this.iHa.equals("showKeyboard"))
                    {
                      localObject2 = localObject3;
                      localObject3 = ((c)localObject6).optString("confirmType");
                      localObject2 = localObject3;
                    }
                    else
                    {
                      localObject5 = localObject3;
                      localObject2 = localObject3;
                      if (this.iHa.equals("setAudioState"))
                      {
                        localObject2 = localObject3;
                        localObject5 = ((c)localObject6).optString("volume");
                        localObject2 = localObject5;
                        if (!bo.isNullOrNil((String)localObject5))
                        {
                          localObject2 = localObject5;
                          if (!((String)localObject5).equalsIgnoreCase("1")) {}
                        }
                        else
                        {
                          localObject2 = localObject5;
                          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(952L, 1L, 1L, false);
                          localObject2 = localObject5;
                          continue;
                        }
                        localObject2 = localObject5;
                        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(952L, 0L, 1L, false);
                      }
                      else
                      {
                        localObject2 = localObject5;
                        continue;
                        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localg1, "get keyParam error!", new Object[0]);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.a
 * JD-Core Version:    0.7.0.1
 */