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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class b
  implements k.a
{
  public static b cml;
  private static String[] cmo = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  protected final Map<String, AppBrandInitConfigLU> cmm;
  private final Map<String, String> cmn;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.cmm = new a();
    this.cmn = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b DX()
  {
    try
    {
      b localb = cml;
      return localb;
    }
    finally {}
  }
  
  private AppBrandInitConfigLU cZ(String paramString)
  {
    AppMethodBeat.i(146688);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.cmn)
    {
      localObject2 = (String)this.cmn.get(paramString);
      if (bt.isNullOrNil((String)localObject2))
      {
        y.bes();
        localObject2 = a(y.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.cmn)
      {
        this.cmn.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = df((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      cml = null;
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
      localAppBrandInitConfigLU.doD = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.bel() == null) {
        break label143;
      }
      localAppBrandInitConfigLU.cmr = paramWxaAttributes.bel().cQN;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.bel().originalFlag;
      localAppBrandInitConfigLU.jXq = paramWxaAttributes.bel().jXq;
      if (paramWxaAttributes.ben() == null) {
        break label171;
      }
      localAppBrandInitConfigLU.cmx = paramWxaAttributes.ben().cmx;
      localAppBrandInitConfigLU.aDD = paramWxaAttributes.ben().aDD;
      localAppBrandInitConfigLU.cmy = paramWxaAttributes.ben();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.cmz = paramWxaAttributes.field_passThroughInfo;
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label143:
      ad.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label171:
      ad.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(192183);
    if ((paramAppBrandInitConfigLU == null) || (bt.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(192183);
      return;
    }
    ad.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.aDD) });
    synchronized (this.cmm)
    {
      this.cmm.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (bt.isNullOrNil(paramString)) {
        break label138;
      }
    }
    synchronized (this.cmn)
    {
      this.cmn.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(192183);
      return;
      paramString = finally;
      AppMethodBeat.o(192183);
      throw paramString;
    }
    label138:
    AppMethodBeat.o(192183);
  }
  
  public final void a(String arg1, m paramm)
  {
    AppMethodBeat.i(146686);
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramm.obj))
      {
        paramm = String.valueOf(paramm.obj);
        if (!bt.isNullOrNil(paramm)) {
          try
          {
            cZ(paramm);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ad.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramm });
            synchronized (this.cmn)
            {
              paramm = (String)this.cmn.remove(paramm);
              if (TextUtils.isEmpty(paramm)) {
                break label150;
              }
            }
            synchronized (this.cmm)
            {
              this.cmm.remove(paramm);
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
      synchronized (this.cmm)
      {
        this.cmm.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
  
  public AppBrandInitConfigLU df(String paramString)
  {
    AppMethodBeat.i(146690);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
      AppMethodBeat.o(146690);
      return null;
    }
    for (;;)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU;
      synchronized (this.cmm)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.cmm.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label129;
        }
        y.bes();
        localAppBrandInitConfigLU = a(y.e(paramString, cmo));
        if (localAppBrandInitConfigLU == null)
        {
          i = -1;
          ad.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
          paramString = localAppBrandInitConfigLU;
          AppMethodBeat.o(146690);
          return paramString;
        }
      }
      int i = localAppBrandInitConfigLU.aDD;
      continue;
      label129:
      ad.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localAppBrandInitConfigLU.aDD) });
      paramString = localAppBrandInitConfigLU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */