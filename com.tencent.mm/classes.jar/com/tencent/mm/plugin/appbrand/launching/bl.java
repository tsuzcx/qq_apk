package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

final class bl
{
  private static String SE(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bd localbd = j.aZu().a(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbd != null)
    {
      paramString = localObject;
      if (!bu.isNullOrNil(localbd.field_pkgPath))
      {
        paramString = localObject;
        if (o.fB(localbd.field_pkgPath))
        {
          paramString = localObject;
          if (!bu.isNullOrNil(localbd.field_versionMd5))
          {
            paramString = localObject;
            if (localbd.field_pkgPath.equals(o.aRh(localbd.field_pkgPath))) {
              paramString = localbd.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void SF(String paramString)
  {
    AppMethodBeat.i(47361);
    if (bu.isNullOrNil(paramString))
    {
      bf.uq(2131755379);
      AppMethodBeat.o(47361);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(47361);
  }
  
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.beV().cmz)
    {
      AppBrand404PageUI.a(paramActivityStarterIpcDelegate);
      h.S(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean au(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47360);
    Object localObject = new bm(paramString, SE(paramString), paramBoolean).bsu();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    ae.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    bm.a locala = bm.a.ut(i);
    if (locala == null)
    {
      switch (i)
      {
      default: 
        if (paramBoolean)
        {
          AppMethodBeat.o(47360);
          return true;
        }
        break;
      case -13002: 
        bf.uq(2131755378);
        h.S(paramString, 13, 3);
        AppMethodBeat.o(47360);
        return false;
      case -13003: 
        SF((String)localObject);
        h.S(paramString, 12, 3);
        AppMethodBeat.o(47360);
        return false;
      }
      bf.Sx(ak.getResources().getString(2131755580, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
      AppMethodBeat.o(47360);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(47360);
      return true;
    }
    switch (1.lQg[locala.ordinal()])
    {
    default: 
      bf.uq(2131755376);
      h.S(paramString, 13, 3);
      AppMethodBeat.o(47360);
      return false;
    case 1: 
      AppMethodBeat.o(47360);
      return true;
    }
    bf.uq(2131755377);
    h.S(paramString, 13, 3);
    AppMethodBeat.o(47360);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bl
 * JD-Core Version:    0.7.0.1
 */