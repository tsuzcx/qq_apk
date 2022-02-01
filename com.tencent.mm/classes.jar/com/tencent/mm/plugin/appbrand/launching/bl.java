package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

final class bl
{
  private static String RV(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bc localbc = j.aYX().a(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbc != null)
    {
      paramString = localObject;
      if (!bt.isNullOrNil(localbc.field_pkgPath))
      {
        paramString = localObject;
        if (i.fv(localbc.field_pkgPath))
        {
          paramString = localObject;
          if (!bt.isNullOrNil(localbc.field_versionMd5))
          {
            paramString = localObject;
            if (localbc.field_pkgPath.equals(i.aPK(localbc.field_pkgPath))) {
              paramString = localbc.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void RW(String paramString)
  {
    AppMethodBeat.i(47361);
    if (bt.isNullOrNil(paramString))
    {
      bf.uk(2131755379);
      AppMethodBeat.o(47361);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(47361);
  }
  
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.ben().cmx)
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
    Object localObject = new bm(paramString, RV(paramString), paramBoolean).brJ();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    ad.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    bm.a locala = bm.a.un(i);
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
        bf.uk(2131755378);
        h.S(paramString, 13, 3);
        AppMethodBeat.o(47360);
        return false;
      case -13003: 
        RW((String)localObject);
        h.S(paramString, 12, 3);
        AppMethodBeat.o(47360);
        return false;
      }
      bf.RO(aj.getResources().getString(2131755580, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
      AppMethodBeat.o(47360);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(47360);
      return true;
    }
    switch (1.lLG[locala.ordinal()])
    {
    default: 
      bf.uk(2131755376);
      h.S(paramString, 13, 3);
      AppMethodBeat.o(47360);
      return false;
    case 1: 
      AppMethodBeat.o(47360);
      return true;
    }
    bf.uk(2131755377);
    h.S(paramString, 13, 3);
    AppMethodBeat.o(47360);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bl
 * JD-Core Version:    0.7.0.1
 */