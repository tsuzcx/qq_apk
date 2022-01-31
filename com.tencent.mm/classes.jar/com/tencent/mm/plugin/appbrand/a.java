package com.tencent.mm.plugin.appbrand;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<String, n> fxs = new HashMap();
  private static Map<String, a.a> fxt = new HashMap();
  private static Map<String, j> fxu = new HashMap();
  
  public static void a(n paramn)
  {
    if (bk.bl(paramn.mAppId))
    {
      y.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
      return;
    }
    for (;;)
    {
      synchronized (fxs)
      {
        n localn = (n)fxs.get(paramn.mAppId);
        if ((localn == null) || (localn == paramn))
        {
          fxs.put(paramn.mAppId, null);
          return;
        }
      }
      y.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[] { bk.j(new Throwable()) });
    }
  }
  
  public static void a(String paramString, j paramj)
  {
    fxu.put(paramString, paramj);
  }
  
  public static void b(n paramn)
  {
    if (bk.bl(paramn.mAppId)) {
      y.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
    }
    for (;;)
    {
      return;
      synchronized (fxs)
      {
        fxs.put(paramn.mAppId, paramn);
        if (paramn.aac() == null) {
          continue;
        }
        d.aY(paramn.mAppId, paramn.aac().bFB);
        return;
      }
    }
  }
  
  public static n qn(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    synchronized (fxs)
    {
      paramString = (n)fxs.get(paramString);
      return paramString;
    }
  }
  
  public static AppBrandSysConfigWC qo(String paramString)
  {
    paramString = qn(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.aaa();
  }
  
  public static AppBrandStatObject qp(String paramString)
  {
    paramString = qn(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.aab();
  }
  
  public static j qq(String paramString)
  {
    return (j)fxu.get(paramString);
  }
  
  public static void qr(String paramString)
  {
    fxu.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */