package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

final class bi
{
  private static String Ko(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bb localbb = j.aOK().a(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbb != null)
    {
      paramString = localObject;
      if (!bt.isNullOrNil(localbb.field_pkgPath))
      {
        paramString = localObject;
        if (i.eK(localbb.field_pkgPath))
        {
          paramString = localObject;
          if (!bt.isNullOrNil(localbb.field_versionMd5))
          {
            paramString = localObject;
            if (localbb.field_pkgPath.equals(i.aEN(localbb.field_pkgPath))) {
              paramString = localbb.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void Kp(String paramString)
  {
    AppMethodBeat.i(47361);
    if (bt.isNullOrNil(paramString))
    {
      bc.sP(2131755379);
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
    if (1 == paramWxaAttributes.aTP().cfk)
    {
      AppBrand404PageUI.a(paramActivityStarterIpcDelegate);
      h.R(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47360);
    Object localObject = new bj(paramString, Ko(paramString), paramBoolean).bgX();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    ad.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    bj.a locala = bj.a.sS(i);
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
        bc.sP(2131755378);
        h.R(paramString, 13, 3);
        AppMethodBeat.o(47360);
        return false;
      case -13003: 
        Kp((String)localObject);
        h.R(paramString, 12, 3);
        AppMethodBeat.o(47360);
        return false;
      }
      bc.Kj(aj.getResources().getString(2131755580, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
      AppMethodBeat.o(47360);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(47360);
      return true;
    }
    switch (1.kMO[locala.ordinal()])
    {
    default: 
      bc.sP(2131755376);
      h.R(paramString, 13, 3);
      AppMethodBeat.o(47360);
      return false;
    case 1: 
      AppMethodBeat.o(47360);
      return true;
    }
    bc.sP(2131755377);
    h.R(paramString, 13, 3);
    AppMethodBeat.o(47360);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bi
 * JD-Core Version:    0.7.0.1
 */