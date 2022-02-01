package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

final class bd
{
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.bAp().cyu)
    {
      AppBrand404PageUI.a(paramActivityStarterIpcDelegate);
      i.T(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean a(String paramString, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(227116);
    Object localObject = new be(paramString, aci(paramString), paramBoolean).bNQ();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    Log.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    be.a locala = be.a.ym(i);
    if (locala == null)
    {
      switch (i)
      {
      default: 
        if (paramBoolean)
        {
          AppMethodBeat.o(227116);
          return true;
        }
        break;
      case -13002: 
        ax.a(2131755416, paramaa);
        i.T(paramString, 13, 3);
        AppMethodBeat.o(227116);
        return false;
      case -13003: 
        if (paramaa.bNh()) {
          b((String)localObject, paramaa);
        }
        i.T(paramString, 12, 3);
        AppMethodBeat.o(227116);
        return false;
      }
      ax.a(MMApplicationContext.getResources().getString(2131755623, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }), paramaa);
      AppMethodBeat.o(227116);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(227116);
      return true;
    }
    switch (1.mXg[locala.ordinal()])
    {
    default: 
      ax.a(2131755414, paramaa);
      i.T(paramString, 13, 3);
      AppMethodBeat.o(227116);
      return false;
    case 1: 
      AppMethodBeat.o(227116);
      return true;
    }
    ax.a(2131755415, paramaa);
    i.T(paramString, 13, 3);
    AppMethodBeat.o(227116);
    return false;
  }
  
  private static String aci(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    com.tencent.mm.plugin.appbrand.appcache.bd localbd = n.buL().a(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbd != null)
    {
      paramString = localObject;
      if (!Util.isNullOrNil(localbd.field_pkgPath))
      {
        paramString = localObject;
        if (s.YS(localbd.field_pkgPath))
        {
          paramString = localObject;
          if (!Util.isNullOrNil(localbd.field_versionMd5))
          {
            paramString = localObject;
            if (localbd.field_pkgPath.equals(s.bhK(localbd.field_pkgPath))) {
              paramString = localbd.field_versionMd5;
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
    AppMethodBeat.i(227117);
    if (Util.isNullOrNil(paramString))
    {
      ax.a(2131755417, paramaa);
      AppMethodBeat.o(227117);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(227117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bd
 * JD-Core Version:    0.7.0.1
 */