package com.tencent.luggage.sdk.config;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class b
  implements k.a
{
  public static b ceX;
  private static String[] cfa = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  protected final Map<String, AppBrandInitConfigLU> ceY;
  private final Map<String, String> ceZ;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.ceY = new a();
    this.ceZ = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b CV()
  {
    try
    {
      b localb = ceX;
      return localb;
    }
    finally {}
  }
  
  private AppBrandInitConfigLU cq(String paramString)
  {
    AppMethodBeat.i(146688);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.ceZ)
    {
      localObject2 = (String)this.ceZ.get(paramString);
      if (bt.isNullOrNil((String)localObject2))
      {
        x.aTU();
        localObject2 = a(x.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.ceZ)
      {
        this.ceZ.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = cr((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      ceX = null;
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
      localAppBrandInitConfigLU.dfM = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.aTN() == null) {
        break label135;
      }
      localAppBrandInitConfigLU.cfd = paramWxaAttributes.aTN().cIB;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.aTN().originalFlag;
      localAppBrandInitConfigLU.jdh = paramWxaAttributes.aTN().jdh;
      if (paramWxaAttributes.aTP() == null) {
        break label163;
      }
      localAppBrandInitConfigLU.cfk = paramWxaAttributes.aTP().cfk;
      localAppBrandInitConfigLU.aAS = paramWxaAttributes.aTP().aAS;
      localAppBrandInitConfigLU.cfl = paramWxaAttributes.aTP();
    }
    for (;;)
    {
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label135:
      ad.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label163:
      ad.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(186867);
    if ((paramAppBrandInitConfigLU == null) || (bt.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(186867);
      return;
    }
    ad.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.aAS) });
    synchronized (this.ceY)
    {
      this.ceY.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (bt.isNullOrNil(paramString)) {
        break label138;
      }
    }
    synchronized (this.ceZ)
    {
      this.ceZ.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(186867);
      return;
      paramString = finally;
      AppMethodBeat.o(186867);
      throw paramString;
    }
    label138:
    AppMethodBeat.o(186867);
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
            cq(paramm);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ad.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramm });
            synchronized (this.ceZ)
            {
              paramm = (String)this.ceZ.remove(paramm);
              if (TextUtils.isEmpty(paramm)) {
                break label150;
              }
            }
            synchronized (this.ceY)
            {
              this.ceY.remove(paramm);
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
      synchronized (this.ceY)
      {
        this.ceY.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
  
  public AppBrandInitConfigLU cr(String paramString)
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
      synchronized (this.ceY)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.ceY.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label128;
        }
        x.aTU();
        localAppBrandInitConfigLU = a(x.e(paramString, cfa));
        if (localAppBrandInitConfigLU == null)
        {
          i = -1;
          ad.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
          paramString = localAppBrandInitConfigLU;
          AppMethodBeat.o(146690);
          return paramString;
        }
      }
      int i = localAppBrandInitConfigLU.aAS;
      continue;
      label128:
      ad.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localAppBrandInitConfigLU.aAS) });
      paramString = localAppBrandInitConfigLU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */