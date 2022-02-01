package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class bd
{
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.clf().eoZ)
    {
      AppBrand404PageUI.a(ba.i.app_brand_launching_release_version_not_published_yet, paramActivityStarterIpcDelegate);
      j.Z(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean a(String paramString, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(321014);
    if (paramBoolean)
    {
      localObject = v.sZx;
      if (v.cAc())
      {
        AppMethodBeat.o(321014);
        return true;
      }
    }
    Object localObject = new be(paramString, adi(paramString), paramBoolean).cAx();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    Log.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    be.a locala = be.a.Cb(i);
    if (locala == null)
    {
      switch (i)
      {
      default: 
        if (paramBoolean)
        {
          AppMethodBeat.o(321014);
          return true;
        }
        break;
      case -13002: 
        ax.a(ba.i.app_brand_demo_pkg_has_been_deleted, paramaa);
        j.Z(paramString, 13, 3);
        AppMethodBeat.o(321014);
        return false;
      case -13003: 
        if (paramaa.czJ()) {
          b((String)localObject, paramaa);
        }
        j.Z(paramString, 12, 3);
        AppMethodBeat.o(321014);
        return false;
      }
      ax.a(MMApplicationContext.getResources().getString(ba.i.app_brand_preparing_comm_err_code, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }), paramaa);
      AppMethodBeat.o(321014);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(321014);
      return true;
    }
    switch (1.tcq[locala.ordinal()])
    {
    default: 
      ax.a(ba.i.app_brand_demo_pkg_cgi_fail, paramaa);
      j.Z(paramString, 13, 3);
      AppMethodBeat.o(321014);
      return false;
    case 1: 
      AppMethodBeat.o(321014);
      return true;
    }
    ax.a(ba.i.app_brand_demo_pkg_cgi_timeout, paramaa);
    j.Z(paramString, 13, 3);
    AppMethodBeat.o(321014);
    return false;
  }
  
  private static String adi(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bh localbh = n.cfm().c(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbh != null)
    {
      paramString = localObject;
      if (!Util.isNullOrNil(localbh.field_pkgPath))
      {
        paramString = localObject;
        if (y.ZC(localbh.field_pkgPath))
        {
          paramString = localObject;
          if (!Util.isNullOrNil(localbh.field_versionMd5))
          {
            paramString = localObject;
            if (localbh.field_pkgPath.equals(y.bub(localbh.field_pkgPath))) {
              paramString = localbh.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void b(String paramString, aa paramaa)
  {
    AppMethodBeat.i(321020);
    if (Util.isNullOrNil(paramString))
    {
      ax.a(ba.i.app_brand_demo_pkg_user_not_in_white_list, paramaa);
      AppMethodBeat.o(321020);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(321020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bd
 * JD-Core Version:    0.7.0.1
 */