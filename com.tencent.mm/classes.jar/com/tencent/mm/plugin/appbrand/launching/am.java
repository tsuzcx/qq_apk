package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class am
{
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(131991);
    if (1 == paramWxaAttributes.ayE().bDd)
    {
      AppBrand404PageUI.a(paramActivityStarterIpcDelegate);
      com.tencent.mm.plugin.appbrand.report.e.U(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(131991);
      return false;
    }
    AppMethodBeat.o(131991);
    return true;
  }
  
  static boolean ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131993);
    int i = new an(paramString, bo(paramString, 2), bo(paramString, 10001), paramBoolean).azZ();
    ab.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    an.a locala = an.a.oI(i);
    if (locala == null)
    {
      switch (i)
      {
      default: 
        if (paramBoolean)
        {
          AppMethodBeat.o(131993);
          return true;
        }
        break;
      case -13002: 
        ah.oH(2131296610);
        com.tencent.mm.plugin.appbrand.report.e.U(paramString, 13, 3);
        AppMethodBeat.o(131993);
        return false;
      case -13003: 
        ah.oH(2131296611);
        com.tencent.mm.plugin.appbrand.report.e.U(paramString, 12, 3);
        AppMethodBeat.o(131993);
        return false;
      }
      ah.Do(com.tencent.mm.sdk.platformtools.ah.getResources().getString(2131296789, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
      AppMethodBeat.o(131993);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(131993);
      return true;
    }
    switch (am.1.imQ[locala.ordinal()])
    {
    default: 
      ah.oH(2131296608);
      com.tencent.mm.plugin.appbrand.report.e.U(paramString, 13, 3);
      AppMethodBeat.o(131993);
      return false;
    case 1: 
      AppMethodBeat.o(131993);
      return true;
    }
    ah.oH(2131296609);
    com.tencent.mm.plugin.appbrand.report.e.U(paramString, 13, 3);
    AppMethodBeat.o(131993);
    return false;
  }
  
  private static String bo(String paramString, int paramInt)
  {
    AppMethodBeat.i(131992);
    Object localObject = null;
    at localat = g.auM().a(paramString, paramInt, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localat != null)
    {
      paramString = localObject;
      if (!bo.isNullOrNil(localat.field_pkgPath))
      {
        paramString = localObject;
        if (com.tencent.mm.vfs.e.cN(localat.field_pkgPath))
        {
          paramString = localObject;
          if (!bo.isNullOrNil(localat.field_versionMd5))
          {
            paramString = localObject;
            if (localat.field_pkgPath.equals(com.tencent.mm.vfs.e.avP(localat.field_pkgPath))) {
              paramString = localat.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(131992);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */