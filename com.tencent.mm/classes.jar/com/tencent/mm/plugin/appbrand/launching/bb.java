package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

final class bb
{
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.bLH().cwX)
    {
      AppBrand404PageUI.a(au.i.app_brand_launching_release_version_not_published_yet, paramActivityStarterIpcDelegate);
      j.V(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean a(String paramString, boolean paramBoolean, y paramy)
  {
    AppMethodBeat.i(281569);
    Object localObject = new bc(paramString, akc(paramString), paramBoolean).caj();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    Log.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    bc.a locala = bc.a.BM(i);
    if (locala == null)
    {
      switch (i)
      {
      default: 
        if (paramBoolean)
        {
          AppMethodBeat.o(281569);
          return true;
        }
        break;
      case -13002: 
        av.a(au.i.app_brand_demo_pkg_has_been_deleted, paramy);
        j.V(paramString, 13, 3);
        AppMethodBeat.o(281569);
        return false;
      case -13003: 
        if (paramy.bZy()) {
          b((String)localObject, paramy);
        }
        j.V(paramString, 12, 3);
        AppMethodBeat.o(281569);
        return false;
      }
      av.a(MMApplicationContext.getResources().getString(au.i.app_brand_preparing_comm_err_code, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }), paramy);
      AppMethodBeat.o(281569);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(281569);
      return true;
    }
    switch (1.pXA[locala.ordinal()])
    {
    default: 
      av.a(au.i.app_brand_demo_pkg_cgi_fail, paramy);
      j.V(paramString, 13, 3);
      AppMethodBeat.o(281569);
      return false;
    case 1: 
      AppMethodBeat.o(281569);
      return true;
    }
    av.a(au.i.app_brand_demo_pkg_cgi_timeout, paramy);
    j.V(paramString, 13, 3);
    AppMethodBeat.o(281569);
    return false;
  }
  
  private static String akc(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bh localbh = m.bFP().c(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbh != null)
    {
      paramString = localObject;
      if (!Util.isNullOrNil(localbh.field_pkgPath))
      {
        paramString = localObject;
        if (u.agG(localbh.field_pkgPath))
        {
          paramString = localObject;
          if (!Util.isNullOrNil(localbh.field_versionMd5))
          {
            paramString = localObject;
            if (localbh.field_pkgPath.equals(u.buc(localbh.field_pkgPath))) {
              paramString = localbh.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void b(String paramString, y paramy)
  {
    AppMethodBeat.i(281570);
    if (Util.isNullOrNil(paramString))
    {
      av.a(au.i.app_brand_demo_pkg_user_not_in_white_list, paramy);
      AppMethodBeat.o(281570);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(281570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */