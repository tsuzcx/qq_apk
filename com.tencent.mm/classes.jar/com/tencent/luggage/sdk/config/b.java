package com.tencent.luggage.sdk.config;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class b
  implements k.a
{
  public static b bCQ;
  private static String[] bCT = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  private final Map<String, AppBrandInitConfigLU> bCR;
  private final Map<String, String> bCS;
  
  protected b()
  {
    AppMethodBeat.i(101602);
    this.bCR = new a();
    this.bCS = new a();
    AppMethodBeat.o(101602);
  }
  
  private AppBrandInitConfigLU ca(String paramString)
  {
    AppMethodBeat.i(101605);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101605);
      return null;
    }
    Object localObject2;
    synchronized (this.bCS)
    {
      localObject2 = (String)this.bCS.get(paramString);
      if (bo.isNullOrNil((String)localObject2))
      {
        t.ayI();
        localObject2 = a(t.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.bCS)
      {
        this.bCS.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(101605);
        return ???;
        paramString = finally;
        AppMethodBeat.o(101605);
        throw paramString;
      }
      ??? = cb((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      bCQ = null;
      return;
    }
    finally {}
  }
  
  public static b vW()
  {
    try
    {
      b localb = bCQ;
      return localb;
    }
    finally {}
  }
  
  public AppBrandInitConfigLU a(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(101606);
    Object localObject = null;
    if (paramWxaAttributes != null)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU = new AppBrandInitConfigLU();
      localAppBrandInitConfigLU.username = paramWxaAttributes.field_username;
      localAppBrandInitConfigLU.appId = paramWxaAttributes.field_appId;
      localAppBrandInitConfigLU.cqQ = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      localAppBrandInitConfigLU.bCV = paramWxaAttributes.ayC().fmF;
      localAppBrandInitConfigLU.hix = paramWxaAttributes.ayC().hix;
      localAppBrandInitConfigLU.hiy = paramWxaAttributes.ayC().hiy;
      localObject = localAppBrandInitConfigLU;
      if (paramWxaAttributes.ayE() != null)
      {
        localAppBrandInitConfigLU.bDd = paramWxaAttributes.ayE().bDd;
        localAppBrandInitConfigLU.bDc = paramWxaAttributes.ayE().bDc;
        localAppBrandInitConfigLU.bDe = paramWxaAttributes.ayE();
        localObject = localAppBrandInitConfigLU;
      }
    }
    AppMethodBeat.o(101606);
    return localObject;
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(101608);
    if ((paramAppBrandInitConfigLU == null) || (bo.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(101608);
      return;
    }
    synchronized (this.bCR)
    {
      this.bCR.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (bo.isNullOrNil(paramString)) {
        break label106;
      }
    }
    synchronized (this.bCS)
    {
      this.bCS.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(101608);
      return;
      paramString = finally;
      AppMethodBeat.o(101608);
      throw paramString;
    }
    label106:
    AppMethodBeat.o(101608);
  }
  
  public final void a(String arg1, m paramm)
  {
    AppMethodBeat.i(101603);
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramm.obj))
      {
        ??? = String.valueOf(paramm.obj);
        if (!bo.isNullOrNil(???)) {
          ca(???);
        }
      }
      AppMethodBeat.o(101603);
      return;
    }
    if ("batch".equals(???)) {
      synchronized (this.bCR)
      {
        this.bCR.clear();
        AppMethodBeat.o(101603);
        return;
      }
    }
    AppMethodBeat.o(101603);
  }
  
  public final String bZ(String paramString)
  {
    AppMethodBeat.i(101604);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101604);
      return null;
    }
    synchronized (this.bCS)
    {
      paramString = (String)this.bCS.get(paramString);
      AppMethodBeat.o(101604);
      return paramString;
    }
  }
  
  public AppBrandInitConfigLU cb(String paramString)
  {
    AppMethodBeat.i(101607);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101607);
      return null;
    }
    synchronized (this.bCR)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.bCR.remove(paramString);
      ??? = localAppBrandInitConfigLU;
      if (localAppBrandInitConfigLU == null)
      {
        t.ayI();
        ??? = a(t.AF(paramString));
      }
      AppMethodBeat.o(101607);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */