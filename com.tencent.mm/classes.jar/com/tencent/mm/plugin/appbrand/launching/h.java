package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class h
  extends i<g>
{
  public static final String[] dUb = { i.a(g.fCU, "DevPkgLaunchExtInfo") };
  
  public h(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, g.fCU, "DevPkgLaunchExtInfo", g.cqY);
  }
  
  public final String aV(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    g localg = new g();
    localg.field_appId = paramString;
    localg.field_versionType = paramInt;
    if (super.b(localg, g.fCT)) {
      return localg.field_extJson;
    }
    return "";
  }
  
  public final boolean l(String paramString1, int paramInt, String paramString2)
  {
    boolean bool;
    if (bk.bl(paramString1)) {
      bool = false;
    }
    for (;;)
    {
      g localg;
      if (bool) {
        localg = null;
      }
      try
      {
        paramString2 = WxaAttributes.WxaVersionModuleInfo.sJ(new JSONObject(paramString2).optString("module_list"));
        if (!bk.dk(paramString2)) {
          com.tencent.mm.plugin.appbrand.app.e.abb().a(paramString1, paramInt, -1, paramString2);
        }
        return bool;
        localg = new g();
        localg.field_appId = paramString1;
        localg.field_versionType = paramInt;
        if (super.b(localg, g.fCT))
        {
          localg.field_extJson = bk.aM(paramString2, "{}");
          bool = super.c(localg, new String[0]);
          continue;
        }
        localg.field_extJson = bk.aM(paramString2, "{}");
        bool = super.b(localg);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2 = localg;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h
 * JD-Core Version:    0.7.0.1
 */