package com.tencent.mm.plugin.appbrand.config;

import android.webkit.WebSettings;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static com.tencent.mm.plugin.appbrand.jsapi.file.a a(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    com.tencent.mm.plugin.appbrand.jsapi.file.a locala = new com.tencent.mm.plugin.appbrand.jsapi.file.a();
    locala.fQf = paramAppBrandSysConfigWC.fQf;
    return locala;
  }
  
  private static String adX()
  {
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(ae.getContext());
      return s.aX(ae.getContext(), str1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = System.getProperty("http.agent");
      }
    }
  }
  
  private static int h(int... paramVarArgs)
  {
    int k = 0;
    int i = 0;
    if (k < 2)
    {
      int m = paramVarArgs[k];
      int j;
      if (m > 0) {
        if (i == 0) {
          j = m;
        }
      }
      for (;;)
      {
        k += 1;
        i = j;
        break;
        j = m;
        if (m >= i) {
          j = i;
        }
      }
    }
    return i;
  }
  
  public static com.tencent.mm.plugin.appbrand.o.a h(n paramn)
  {
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramn.aac();
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramn.aaa();
    Object localObject = paramn.getAppConfig();
    com.tencent.mm.plugin.appbrand.o.a locala = new com.tencent.mm.plugin.appbrand.o.a();
    boolean bool;
    if ((localAppBrandInitConfigWC.fPz) || (localAppBrandInitConfigWC.ZH()))
    {
      bool = true;
      locala.gQw = bool;
      if ((localAppBrandSysConfigWC.fPS.fEM != 1) && (localAppBrandSysConfigWC.fPS.fEM != 2)) {
        break label602;
      }
      i = 1;
      label76:
      if (!localAppBrandSysConfigWC.fPx) {
        break label612;
      }
      if ((i != 0) && (localAppBrandSysConfigWC.fPV)) {
        break label607;
      }
      bool = true;
      label98:
      locala.gQx = bool;
      i = h(new int[] { localAppBrandSysConfigWC.fQq.fOI.fPg, ((a)localObject).fNE.cdI });
      if (i > 0) {
        locala.gQy = i;
      }
      i = h(new int[] { localAppBrandSysConfigWC.fQq.fOI.fPd, ((a)localObject).fNE.fNM });
      if (i > 0) {
        locala.gQz = i;
      }
      i = h(new int[] { localAppBrandSysConfigWC.fQq.fOI.fPe, ((a)localObject).fNE.fNN });
      if (i > 0) {
        locala.gQA = i;
      }
      i = h(new int[] { localAppBrandSysConfigWC.fQq.fOI.fPf, ((a)localObject).fNE.fNO });
      if (i > 0) {
        locala.gQB = i;
      }
      locala.fPZ = localAppBrandSysConfigWC.fPZ;
      locala.gQC = localAppBrandSysConfigWC.fQc;
      locala.fQa = localAppBrandSysConfigWC.fQa;
      locala.fQb = localAppBrandSysConfigWC.fQb;
      locala.fQj = localAppBrandSysConfigWC.fQj;
      locala.fQk = localAppBrandSysConfigWC.fQk;
      locala.fQl = localAppBrandSysConfigWC.fQl;
      locala.fQm = localAppBrandSysConfigWC.fQm;
      if (localAppBrandSysConfigWC.fQq.fOI.mode != 1) {
        break label634;
      }
      if (localAppBrandSysConfigWC.fQq.fOI.fPb != null) {
        locala.gQD = localAppBrandSysConfigWC.fQq.fOI.fPb;
      }
      label393:
      locala.mode = localAppBrandSysConfigWC.fQq.fOI.mode;
      locala.gQF = n(paramn);
      if (!localAppBrandInitConfigWC.ZH()) {
        break label682;
      }
    }
    label682:
    for (int i = localAppBrandSysConfigWC.fQq.fOT;; i = localAppBrandSysConfigWC.fQq.fOD)
    {
      locala.fOD = i;
      locala.fQe = localAppBrandSysConfigWC.fQe;
      locala.gQG = adX();
      localObject = "";
      paramn = (n)localObject;
      if (localAppBrandSysConfigWC.fQq != null)
      {
        paramn = (n)localObject;
        if (localAppBrandSysConfigWC.fQq.fOI != null) {
          paramn = localAppBrandSysConfigWC.fQq.fOI.fPh;
        }
      }
      localObject = paramn;
      if (bk.bl(paramn)) {
        localObject = "servicewechat.com";
      }
      paramn = new StringBuilder();
      paramn.append("https://");
      paramn.append((String)localObject);
      paramn.append("/");
      paramn.append(localAppBrandSysConfigWC.appId);
      paramn.append("/");
      paramn.append(localAppBrandSysConfigWC.fPS.fEN);
      paramn.append("/page-frame.html");
      locala.referer = paramn.toString();
      locala.fPx = localAppBrandInitConfigWC.fPx;
      return locala;
      bool = false;
      break;
      label602:
      i = 0;
      break label76;
      label607:
      bool = false;
      break label98;
      label612:
      if ((i == 0) || (!localAppBrandSysConfigWC.fPN))
      {
        bool = true;
        break label98;
      }
      bool = false;
      break label98;
      label634:
      if ((localAppBrandSysConfigWC.fQq.fOI.mode != 2) || (localAppBrandSysConfigWC.fQq.fOI.fPc == null)) {
        break label393;
      }
      locala.gQE = localAppBrandSysConfigWC.fQq.fOI.fPc;
      break label393;
    }
  }
  
  private static ArrayList<byte[]> n(i parami)
  {
    localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.plugin.appbrand.u.k();
    parami.Zl().b("cer", (com.tencent.mm.plugin.appbrand.u.k)localObject);
    if (((com.tencent.mm.plugin.appbrand.u.k)localObject).value == null) {
      return localArrayList;
    }
    parami = ((ByteBuffer)((com.tencent.mm.plugin.appbrand.u.k)localObject).value).array();
    try
    {
      localObject = new avm();
      ((avm)localObject).aH(parami);
      if (((avm)localObject).tqY == null) {
        return localArrayList;
      }
      parami = ((avm)localObject).tqY.iterator();
      while (parami.hasNext()) {
        localArrayList.add(((b)parami.next()).oY);
      }
      return localArrayList;
    }
    catch (Exception parami)
    {
      y.e("", "readPkgCertificate, parse error: " + parami);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.d
 * JD-Core Version:    0.7.0.1
 */