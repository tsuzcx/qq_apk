package com.tencent.mm.plugin.appbrand.config;

import android.support.v4.f.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class g
  implements j.a
{
  private static g fPt;
  private static String[] fPw = { "appId", "versionInfo", "appInfo", "brandIconURL", "nickname" };
  public final Map<String, AppBrandInitConfigWC> fPu = new a();
  public final Map<String, String> fPv = new a();
  
  public static AppBrandInitConfigWC a(WxaAttributes paramWxaAttributes)
  {
    AppBrandInitConfigWC localAppBrandInitConfigWC = null;
    if (paramWxaAttributes != null)
    {
      localAppBrandInitConfigWC = new AppBrandInitConfigWC();
      localAppBrandInitConfigWC.username = paramWxaAttributes.field_username;
      localAppBrandInitConfigWC.appId = paramWxaAttributes.field_appId;
      localAppBrandInitConfigWC.bJw = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigWC.iconUrl = paramWxaAttributes.field_smallHeadURL;
      localAppBrandInitConfigWC.bFB = paramWxaAttributes.aen().dWx;
      if (paramWxaAttributes.aen().fRc <= 0) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandInitConfigWC.fPs = bool;
      if (paramWxaAttributes.aep() != null)
      {
        localAppBrandInitConfigWC.fPB = paramWxaAttributes.aep().fPB;
        localAppBrandInitConfigWC.cau = paramWxaAttributes.aep().cau;
      }
      return localAppBrandInitConfigWC;
    }
  }
  
  public static g aed()
  {
    try
    {
      g localg = fPt;
      return localg;
    }
    finally {}
  }
  
  public static void init()
  {
    try
    {
      fPt = new g();
      r.aem().c(fPt);
      return;
    }
    finally {}
  }
  
  public static void release()
  {
    try
    {
      fPt = null;
      return;
    }
    finally {}
  }
  
  private AppBrandInitConfigWC sk(String paramString)
  {
    if (bk.bl(paramString)) {
      ??? = null;
    }
    Object localObject2;
    for (;;)
    {
      return ???;
      synchronized (this.fPv)
      {
        localObject2 = (String)this.fPv.get(paramString);
        if (bk.bl((String)localObject2))
        {
          localObject2 = a(e.aaT().d(paramString, fPw));
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          synchronized (this.fPv)
          {
            this.fPv.put(paramString, ((AppBrandInitConfigWC)localObject2).appId);
            return localObject2;
          }
        }
      }
    }
    return sl((String)localObject2);
  }
  
  public final void a(String arg1, l paraml)
  {
    if ("single".equals(???)) {
      if (String.class.isInstance(paraml.obj))
      {
        ??? = String.valueOf(paraml.obj);
        if (!bk.bl(???)) {
          sk(???);
        }
      }
    }
    while (!"batch".equals(???)) {
      return;
    }
    synchronized (this.fPu)
    {
      this.fPu.clear();
      return;
    }
  }
  
  public final String sj(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    synchronized (this.fPv)
    {
      paramString = (String)this.fPv.get(paramString);
      return paramString;
    }
  }
  
  public final AppBrandInitConfigWC sl(String paramString)
  {
    if (bk.bl(paramString)) {
      ??? = null;
    }
    for (;;)
    {
      return ???;
      synchronized (this.fPu)
      {
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)this.fPu.remove(paramString);
        ??? = localAppBrandInitConfigWC;
        if (localAppBrandInitConfigWC != null) {
          continue;
        }
        return a(e.aaT().e(paramString, fPw));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g
 * JD-Core Version:    0.7.0.1
 */