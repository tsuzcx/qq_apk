package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

final class bi
{
  private static String Ov(String paramString)
  {
    AppMethodBeat.i(180317);
    Object localObject = null;
    bb localbb = j.aVC().a(paramString, 10001, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localbb != null)
    {
      paramString = localObject;
      if (!bs.isNullOrNil(localbb.field_pkgPath))
      {
        paramString = localObject;
        if (i.eA(localbb.field_pkgPath))
        {
          paramString = localObject;
          if (!bs.isNullOrNil(localbb.field_versionMd5))
          {
            paramString = localObject;
            if (localbb.field_pkgPath.equals(i.aKe(localbb.field_pkgPath))) {
              paramString = localbb.field_versionMd5;
            }
          }
        }
      }
    }
    AppMethodBeat.o(180317);
    return paramString;
  }
  
  private static void Ow(String paramString)
  {
    AppMethodBeat.i(47361);
    if (bs.isNullOrNil(paramString))
    {
      bc.tG(2131755379);
      AppMethodBeat.o(47361);
      return;
    }
    paramString = new Intent().putExtra("rawUrl", paramString).putExtra("forceHideShare", true);
    d.b(ai.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(47361);
  }
  
  static boolean a(WxaAttributes paramWxaAttributes, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(47358);
    if (1 == paramWxaAttributes.baN().ccg)
    {
      AppBrand404PageUI.a(paramActivityStarterIpcDelegate);
      g.Q(paramWxaAttributes.field_appId, 14, 1);
      AppMethodBeat.o(47358);
      return false;
    }
    AppMethodBeat.o(47358);
    return true;
  }
  
  static boolean as(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47360);
    Object localObject = new bj(paramString, Ov(paramString), paramBoolean).bnR();
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    ac.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    bj.a locala = bj.a.tJ(i);
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
        bc.tG(2131755378);
        g.Q(paramString, 13, 3);
        AppMethodBeat.o(47360);
        return false;
      case -13003: 
        Ow((String)localObject);
        g.Q(paramString, 12, 3);
        AppMethodBeat.o(47360);
        return false;
      }
      bc.Oq(ai.getResources().getString(2131755580, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
      AppMethodBeat.o(47360);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(47360);
      return true;
    }
    switch (1.lon[locala.ordinal()])
    {
    default: 
      bc.tG(2131755376);
      g.Q(paramString, 13, 3);
      AppMethodBeat.o(47360);
      return false;
    case 1: 
      AppMethodBeat.o(47360);
      return true;
    }
    bc.tG(2131755377);
    g.Q(paramString, 13, 3);
    AppMethodBeat.o(47360);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bi
 * JD-Core Version:    0.7.0.1
 */