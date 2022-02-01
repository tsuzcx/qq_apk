package com.tencent.luggage.sdk.config;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class b
  implements k.a
{
  public static b cmn;
  private static String[] cmq = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  protected final Map<String, AppBrandInitConfigLU> cmo;
  private final Map<String, String> cmp;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.cmo = new a();
    this.cmp = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b Ea()
  {
    try
    {
      b localb = cmn;
      return localb;
    }
    finally {}
  }
  
  private AppBrandInitConfigLU dg(String paramString)
  {
    AppMethodBeat.i(146688);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.cmp)
    {
      localObject2 = (String)this.cmp.get(paramString);
      if (bu.isNullOrNil((String)localObject2))
      {
        y.bfa();
        localObject2 = a(y.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.cmp)
      {
        this.cmp.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = dk((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      cmn = null;
      return;
    }
    finally {}
  }
  
  public AppBrandInitConfigLU a(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(146689);
    AppBrandInitConfigLU localAppBrandInitConfigLU = null;
    if (paramWxaAttributes != null)
    {
      localAppBrandInitConfigLU = new AppBrandInitConfigLU();
      localAppBrandInitConfigLU.username = paramWxaAttributes.field_username;
      localAppBrandInitConfigLU.appId = paramWxaAttributes.field_appId;
      localAppBrandInitConfigLU.dpI = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.beT() == null) {
        break label143;
      }
      localAppBrandInitConfigLU.cmt = paramWxaAttributes.beT().cRx;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.beT().originalFlag;
      localAppBrandInitConfigLU.kaF = paramWxaAttributes.beT().kaF;
      if (paramWxaAttributes.beV() == null) {
        break label171;
      }
      localAppBrandInitConfigLU.cmz = paramWxaAttributes.beV().cmz;
      localAppBrandInitConfigLU.aDD = paramWxaAttributes.beV().aDD;
      localAppBrandInitConfigLU.cmA = paramWxaAttributes.beV();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.cmB = paramWxaAttributes.field_passThroughInfo;
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label143:
      ae.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label171:
      ae.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(220756);
    if ((paramAppBrandInitConfigLU == null) || (bu.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(220756);
      return;
    }
    ae.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.aDD) });
    synchronized (this.cmo)
    {
      this.cmo.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (bu.isNullOrNil(paramString)) {
        break label138;
      }
    }
    synchronized (this.cmp)
    {
      this.cmp.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(220756);
      return;
      paramString = finally;
      AppMethodBeat.o(220756);
      throw paramString;
    }
    label138:
    AppMethodBeat.o(220756);
  }
  
  public final void a(String arg1, m paramm)
  {
    AppMethodBeat.i(146686);
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramm.obj))
      {
        paramm = String.valueOf(paramm.obj);
        if (!bu.isNullOrNil(paramm)) {
          try
          {
            dg(paramm);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ae.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramm });
            synchronized (this.cmp)
            {
              paramm = (String)this.cmp.remove(paramm);
              if (TextUtils.isEmpty(paramm)) {
                break label150;
              }
            }
            synchronized (this.cmo)
            {
              this.cmo.remove(paramm);
              AppMethodBeat.o(146686);
              return;
              paramm = finally;
              AppMethodBeat.o(146686);
              throw paramm;
            }
          }
        }
      }
      label150:
      AppMethodBeat.o(146686);
      return;
    }
    if ("batch".equals(???)) {
      synchronized (this.cmo)
      {
        this.cmo.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
  
  public AppBrandInitConfigLU dk(String paramString)
  {
    AppMethodBeat.i(146690);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
      AppMethodBeat.o(146690);
      return null;
    }
    for (;;)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU;
      synchronized (this.cmo)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.cmo.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label129;
        }
        y.bfa();
        localAppBrandInitConfigLU = a(y.e(paramString, cmq));
        if (localAppBrandInitConfigLU == null)
        {
          i = -1;
          ae.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
          paramString = localAppBrandInitConfigLU;
          AppMethodBeat.o(146690);
          return paramString;
        }
      }
      int i = localAppBrandInitConfigLU.aDD;
      continue;
      label129:
      ae.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localAppBrandInitConfigLU.aDD) });
      paramString = localAppBrandInitConfigLU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */