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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class b
  implements k.a
{
  public static b cbU;
  private static String[] cbX = { "username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname" };
  protected final Map<String, AppBrandInitConfigLU> cbV;
  private final Map<String, String> cbW;
  
  protected b()
  {
    AppMethodBeat.i(146685);
    this.cbV = new a();
    this.cbW = new a();
    AppMethodBeat.o(146685);
  }
  
  public static b Cy()
  {
    try
    {
      b localb = cbU;
      return localb;
    }
    finally {}
  }
  
  private AppBrandInitConfigLU cf(String paramString)
  {
    AppMethodBeat.i(146688);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146688);
      return null;
    }
    Object localObject2;
    synchronized (this.cbW)
    {
      localObject2 = (String)this.cbW.get(paramString);
      if (bs.isNullOrNil((String)localObject2))
      {
        x.baS();
        localObject2 = a(x.f(String.format("%s=?", new Object[] { "username" }), new String[] { paramString }));
        ??? = localObject2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      synchronized (this.cbW)
      {
        this.cbW.put(paramString, ((AppBrandInitConfigLU)localObject2).appId);
        ??? = localObject2;
        AppMethodBeat.o(146688);
        return ???;
        paramString = finally;
        AppMethodBeat.o(146688);
        throw paramString;
      }
      ??? = cg((String)localObject2);
    }
  }
  
  public static void release()
  {
    try
    {
      cbU = null;
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
      localAppBrandInitConfigLU.ddh = paramWxaAttributes.field_nickname;
      localAppBrandInitConfigLU.iconUrl = paramWxaAttributes.field_smallHeadURL;
      if (paramWxaAttributes.baL() == null) {
        break label143;
      }
      localAppBrandInitConfigLU.cca = paramWxaAttributes.baL().cFI;
      localAppBrandInitConfigLU.originalFlag = paramWxaAttributes.baL().originalFlag;
      localAppBrandInitConfigLU.jDu = paramWxaAttributes.baL().jDu;
      if (paramWxaAttributes.baN() == null) {
        break label171;
      }
      localAppBrandInitConfigLU.ccg = paramWxaAttributes.baN().ccg;
      localAppBrandInitConfigLU.aBM = paramWxaAttributes.baN().aBM;
      localAppBrandInitConfigLU.cch = paramWxaAttributes.baN();
    }
    for (;;)
    {
      localAppBrandInitConfigLU.cci = paramWxaAttributes.field_passThroughInfo;
      AppMethodBeat.o(146689);
      return localAppBrandInitConfigLU;
      label143:
      ac.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
      break;
      label171:
      ac.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", new Object[] { paramWxaAttributes.field_username, paramWxaAttributes.field_appId });
    }
  }
  
  public final void a(String paramString, AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(206115);
    if ((paramAppBrandInitConfigLU == null) || (bs.isNullOrNil(paramAppBrandInitConfigLU.appId)))
    {
      AppMethodBeat.o(206115);
      return;
    }
    ac.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d", new Object[] { paramString, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandInitConfigLU.aBM) });
    synchronized (this.cbV)
    {
      this.cbV.put(paramAppBrandInitConfigLU.appId, paramAppBrandInitConfigLU);
      if (bs.isNullOrNil(paramString)) {
        break label138;
      }
    }
    synchronized (this.cbW)
    {
      this.cbW.put(paramString, paramAppBrandInitConfigLU.appId);
      AppMethodBeat.o(206115);
      return;
      paramString = finally;
      AppMethodBeat.o(206115);
      throw paramString;
    }
    label138:
    AppMethodBeat.o(206115);
  }
  
  public final void a(String arg1, m paramm)
  {
    AppMethodBeat.i(146686);
    if ("single".equals(???))
    {
      if (String.class.isInstance(paramm.obj))
      {
        paramm = String.valueOf(paramm.obj);
        if (!bs.isNullOrNil(paramm)) {
          try
          {
            cf(paramm);
            AppMethodBeat.o(146686);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ac.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", localRuntimeException, "onNotifyChange event[%s] username[%s]", new Object[] { ???, paramm });
            synchronized (this.cbW)
            {
              paramm = (String)this.cbW.remove(paramm);
              if (TextUtils.isEmpty(paramm)) {
                break label150;
              }
            }
            synchronized (this.cbV)
            {
              this.cbV.remove(paramm);
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
      synchronized (this.cbV)
      {
        this.cbV.clear();
        AppMethodBeat.o(146686);
        return;
      }
    }
    AppMethodBeat.o(146686);
  }
  
  public AppBrandInitConfigLU cg(String paramString)
  {
    AppMethodBeat.i(146690);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
      AppMethodBeat.o(146690);
      return null;
    }
    for (;;)
    {
      AppBrandInitConfigLU localAppBrandInitConfigLU;
      synchronized (this.cbV)
      {
        localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.cbV.remove(paramString);
        if (localAppBrandInitConfigLU != null) {
          break label129;
        }
        x.baS();
        localAppBrandInitConfigLU = a(x.e(paramString, cbX));
        if (localAppBrandInitConfigLU == null)
        {
          i = -1;
          ac.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", new Object[] { paramString, Integer.valueOf(i) });
          paramString = localAppBrandInitConfigLU;
          AppMethodBeat.o(146690);
          return paramString;
        }
      }
      int i = localAppBrandInitConfigLU.aBM;
      continue;
      label129:
      ac.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", new Object[] { paramString, Integer.valueOf(localAppBrandInitConfigLU.aBM) });
      paramString = localAppBrandInitConfigLU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.b
 * JD-Core Version:    0.7.0.1
 */