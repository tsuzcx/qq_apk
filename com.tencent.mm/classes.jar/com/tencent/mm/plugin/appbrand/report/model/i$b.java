package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import kotlin.g.b.p;

final class i$b
  implements Runnable
{
  String appId;
  long costTime;
  String fGw;
  String fve;
  String oAb;
  int qLc;
  String qnk;
  
  private String b(c paramc)
  {
    AppMethodBeat.i(48124);
    Object localObject = new com.tencent.mm.ad.i();
    for (;;)
    {
      try
      {
        str = this.qnk;
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
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", paramc, "get keyParam error!", new Object[0]);
        continue;
      }
      paramc = null;
      try
      {
        localObject = URLEncoder.encode(((com.tencent.mm.ad.i)localObject).toString(), "UTF-8");
        paramc = (c)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        continue;
      }
      AppMethodBeat.o(48124);
      return paramc;
      if (str.equals("chooseImage"))
      {
        i = 0;
        continue;
        ((com.tencent.mm.ad.i)localObject).g("sizeType", paramc.optString("sizeType"));
      }
    }
  }
  
  private String chV()
  {
    AppMethodBeat.i(48123);
    Object localObject1 = "";
    if ((Util.isNullOrNil(this.fGw)) || (Util.isNullOrNil(this.qnk)))
    {
      AppMethodBeat.o(48123);
      return "";
    }
    for (;;)
    {
      try
      {
        localObject2 = this.qnk;
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
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localg, "get keyParam error!", new Object[0]);
        continue;
      }
      AppMethodBeat.o(48123);
      return localObject1;
      if (((String)localObject2).equals("getLocation"))
      {
        i = 0;
        continue;
        localObject2 = com.tencent.mm.ad.h.MF(this.fGw);
        localObject2 = String.format("%s;%s;%s;%s;%s;%s;%s", new Object[] { ((c)localObject2).optString("latitude"), ((c)localObject2).optString("longitude"), ((c)localObject2).optString("speed"), ((c)localObject2).optString("accuracy"), ((c)localObject2).optString("altitude"), ((c)localObject2).optString("verticalAccuracy"), ((c)localObject2).optString("horizontalAccuracy") });
        localObject1 = localObject2;
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(48122);
    AppBrandStatObject localAppBrandStatObject = d.abC(this.appId);
    if (localAppBrandStatObject == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
      AppMethodBeat.o(48122);
      return;
    }
    Object localObject9;
    Object localObject8;
    Object localObject4;
    Object localObject6;
    Object localObject7;
    if (!i.bKm().contains(this.qnk))
    {
      localObject9 = "";
      localObject8 = "";
      Object localObject1 = localObject9;
      localObject4 = localObject8;
      if (!Util.isNullOrNil(this.oAb))
      {
        localObject1 = localObject9;
        localObject4 = localObject8;
        if (!Util.isNullOrNil(this.qnk))
        {
          localObject6 = localObject9;
          localObject7 = localObject8;
        }
      }
      for (;;)
      {
        try
        {
          localObject10 = com.tencent.mm.ad.h.MF(this.oAb);
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject8 = b((c)localObject10);
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!((c)localObject10).has("url")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("openLink"))
          {
            localObject6 = localObject9;
            localObject7 = localObject8;
            if (!this.qnk.equals("redirectTo"))
            {
              localObject6 = localObject9;
              localObject7 = localObject8;
              if (!this.qnk.equals("navigateTo"))
              {
                localObject6 = localObject9;
                localObject7 = localObject8;
                if (!this.qnk.equals("request"))
                {
                  localObject6 = localObject9;
                  localObject7 = localObject8;
                  if (!this.qnk.equals("connectSocket"))
                  {
                    localObject6 = localObject9;
                    localObject7 = localObject8;
                    if (!this.qnk.equals("uploadFile"))
                    {
                      localObject6 = localObject9;
                      localObject7 = localObject8;
                      if (!this.qnk.equals("downloadFile")) {
                        continue;
                      }
                    }
                  }
                }
              }
            }
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject1 = ((c)localObject10).optString("url");
          localObject4 = localObject8;
        }
        catch (g localg)
        {
          Object localObject10;
          String str2;
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localg, "get keyParam error!", new Object[0]);
          localObject3 = localObject6;
          localObject4 = localObject7;
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("requestPayment")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("package");
          localObject4 = localObject8;
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("reportSubmitForm")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = s.abV(this.appId).nwa;
          localObject4 = localObject8;
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("makePhoneCall")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("phoneNumber");
          localObject4 = localObject8;
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("chooseVideo")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("maxDuration");
          localObject4 = localObject8;
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("updateHTMLWebView")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("src");
          localObject6 = localObject3;
          localObject7 = localObject8;
          try
          {
            localObject4 = URLEncoder.encode(((c)localObject10).optString("src"), "UTF-8");
            localObject3 = localObject4;
            localObject4 = localObject8;
          }
          catch (Exception localException2)
          {
            localObject6 = localObject3;
            localObject7 = localObject8;
            Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException2.toString());
            localObject5 = localObject8;
          }
          continue;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("showKeyboard")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("confirmType");
          localObject5 = localObject8;
          continue;
          localObject3 = localObject9;
          localObject5 = localObject8;
          localObject6 = localObject9;
          localObject7 = localObject8;
          if (!this.qnk.equals("setAudioState")) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          localObject3 = ((c)localObject10).optString("volume");
          localObject5 = localObject8;
          continue;
        }
        str2 = chV();
        localObject7 = "";
        localObject6 = localObject7;
        if (!Util.isNullOrNil(this.fve))
        {
          localObject6 = localObject7;
          if (this.fve.contains(".html")) {
            localObject6 = this.fve.substring(0, this.fve.lastIndexOf(".html") + 5);
          }
        }
        localObject7 = "";
        try
        {
          localObject8 = URLEncoder.encode(Util.nullAsNil((String)localObject6), "UTF-8");
          localObject7 = localObject8;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException2, "encode page path error!", new Object[0]);
          continue;
        }
        localObject8 = "";
        try
        {
          localObject9 = URLEncoder.encode(Util.nullAsNil((String)localObject1), "UTF-8");
          localObject8 = localObject9;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException3)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException3, "encode keyParam path error!", new Object[0]);
          continue;
        }
        localObject9 = "";
        try
        {
          localObject10 = URLEncoder.encode(Util.nullAsNil(str2), "UTF-8");
          localObject9 = localObject10;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException4)
        {
          String str3;
          String str4;
          String str5;
          AppBrandSysConfigWC localAppBrandSysConfigWC;
          AppBrandInitConfigWC localAppBrandInitConfigWC;
          int j;
          int k;
          int m;
          boolean bool;
          String str1;
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException4, "encode keyResult path error!", new Object[0]);
          continue;
          int i = 0;
          continue;
          Object localObject5 = com.tencent.mm.plugin.report.service.h.IzE;
          localObject5 = com.tencent.mm.plugin.report.service.h.u((Object[])localObject3);
          localObject6 = com.tencent.mm.plugin.appbrand.report.a.qIj;
          com.tencent.mm.plugin.appbrand.report.a.a(13542, i, false, false, true, (String)localObject5);
          continue;
          localObject5 = com.tencent.mm.plugin.appbrand.report.a.qIj;
          p.k(localObject3, "vals");
          localObject5 = com.tencent.mm.plugin.report.service.h.IzE;
          Object localObject3 = com.tencent.mm.plugin.report.service.h.u(Arrays.copyOf((Object[])localObject3, 23));
          p.j(localObject3, "ReportManager.INSTANCE.g…StringFromMutilObj(*vals)");
          com.tencent.mm.plugin.appbrand.report.a.a(15761, i, false, false, false, (String)localObject3);
        }
        localObject10 = Util.nullAsNil(this.qnk);
        str3 = i.amK(this.fGw);
        i = i.amL(str3);
        str4 = Util.nullAsNil(localAppBrandStatObject.fvd);
        str5 = j.getNetworkType(MMApplicationContext.getContext());
        if (localAppBrandStatObject.scene == 0) {
          localAppBrandStatObject.scene = 1000;
        }
        localAppBrandSysConfigWC = d.abB(this.appId);
        if (localAppBrandSysConfigWC == null) {
          break label1866;
        }
        localAppBrandInitConfigWC = d.abA(this.appId).bDy();
        j = localAppBrandSysConfigWC.nYR.pkgVersion;
        k = localAppBrandSysConfigWC.nYR.nHY + 1;
        m = j.amB(this.appId);
        if (Log.getLogLevel() <= 1) {
          Log.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s, instanceId:%s, sessionId:%s", new Object[] { Integer.valueOf(localAppBrandStatObject.scene), str4, this.appId, Integer.valueOf(j), Integer.valueOf(k), localObject6, str5, localObject10, localObject1, Integer.valueOf(i), Integer.valueOf(this.qLc), Integer.valueOf(0), Long.valueOf(this.costTime), Integer.valueOf(0), str3, Integer.valueOf(localAppBrandStatObject.qJF), Integer.valueOf(m), str2, localObject4, localAppBrandInitConfigWC.cwQ, localAppBrandInitConfigWC.cwP });
        }
        localObject1 = new Object[23];
        localObject1[0] = Integer.valueOf(localAppBrandStatObject.scene);
        localObject1[1] = str4;
        localObject1[2] = this.appId;
        localObject1[3] = Integer.valueOf(j);
        localObject1[4] = Integer.valueOf(k);
        localObject1[5] = localObject7;
        localObject1[6] = str5;
        localObject1[7] = localObject10;
        localObject1[8] = localObject8;
        localObject1[9] = Integer.valueOf(i);
        localObject1[10] = Integer.valueOf(this.qLc);
        localObject1[11] = Integer.valueOf(0);
        localObject1[12] = Long.valueOf(this.costTime);
        localObject1[13] = Integer.valueOf(0);
        localObject1[14] = str3;
        localObject1[15] = Integer.valueOf(localAppBrandStatObject.qJF);
        localObject1[16] = Integer.valueOf(localAppBrandStatObject.fXa);
        localObject1[17] = localAppBrandStatObject.fXb;
        localObject1[18] = Integer.valueOf(m);
        localObject1[19] = localObject9;
        localObject1[20] = localObject4;
        localObject1[21] = localAppBrandInitConfigWC.cwQ;
        localObject1[22] = localAppBrandInitConfigWC.cwP;
        bool = ((String)localObject10).startsWith("shareAppMessage");
        if (!i.a.chT().contains(this.qnk)) {
          break label1779;
        }
        i = 1;
        if (!bool) {
          break label1784;
        }
        localObject4 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject4 = com.tencent.mm.plugin.report.service.h.u((Object[])localObject1);
        localObject6 = com.tencent.mm.plugin.report.service.h.IzE;
        com.tencent.mm.plugin.report.service.h.c(13542, i, (String)localObject4, false, true);
        if (!i.a.chU().contains(localObject10)) {
          break label1866;
        }
        if (!bool) {
          break label1816;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(15761, i, (Object[])localObject1);
        AppMethodBeat.o(48122);
        return;
        localObject6 = localObject9;
        localObject7 = localObject8;
        bool = this.qnk.equals("authorize");
        if (bool)
        {
          localObject6 = localObject9;
          localObject7 = localObject8;
          try
          {
            localObject1 = com.tencent.mm.ad.h.MG(((c)localObject10).optString("scope"));
            localObject6 = localObject9;
            localObject7 = localObject8;
            localObject4 = new LinkedList();
            i = 0;
            localObject6 = localObject9;
            localObject7 = localObject8;
            if (i < ((com.tencent.mm.ad.a)localObject1).length())
            {
              localObject6 = localObject9;
              localObject7 = localObject8;
              ((LinkedList)localObject4).add(((com.tencent.mm.ad.a)localObject1).optString(i));
              i += 1;
              continue;
            }
            localObject6 = localObject9;
          }
          catch (Exception localException1)
          {
            localObject6 = localObject9;
            localObject7 = localObject8;
            Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", new Object[] { localException1.getMessage() });
            AppMethodBeat.o(48122);
            return;
          }
          localObject7 = localObject8;
          str1 = ((LinkedList)localObject4).toString();
          localObject4 = localObject8;
        }
        else
        {
          localObject6 = localObject9;
          localObject7 = localObject8;
          bool = this.qnk.equals("shareAppMessage");
          if (!bool) {
            continue;
          }
          localObject6 = localObject9;
          localObject7 = localObject8;
          try
          {
            str1 = URLEncoder.encode(Util.nullAsNil(localObject10.toString()), "UTF-8");
            localObject4 = localObject8;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            localObject6 = localObject9;
            localObject7 = localObject8;
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localUnsupportedEncodingException1, "", new Object[0]);
            Object localObject2 = localObject9;
            localObject4 = localObject8;
          }
        }
      }
    }
    label1779:
    label1784:
    AppMethodBeat.o(48122);
    label1816:
    label1866:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.b
 * JD-Core Version:    0.7.0.1
 */