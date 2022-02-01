package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;

public final class g
  implements o
{
  private static final int[] lpq = { 1025, 1031, 1032 };
  private static final int[] lpr = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d lps;
  private final f lpt;
  private final c lpu;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.lps = new d();
    this.lpt = new f();
    this.lpu = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean Oy(String paramString)
  {
    AppMethodBeat.i(47417);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47417);
      return false;
    }
    ac.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
    Object localObject2 = b.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if ((!bs.isNullOrNil(paramString)) && (paramString.startsWith(localObject1.hUu)))
      {
        j = 1;
        label79:
        if (j == 0) {
          break label113;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        try
        {
          localObject2 = Uri.parse(paramString);
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label113:
            ac.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
          String str = paramString.getQueryParameter("username");
          paramString = paramString.getQueryParameter("path");
          if ((!bs.isNullOrNil(str)) && (ai.vC(str))) {
            break label185;
          }
          AppMethodBeat.o(47417);
          return false;
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = localObject1.scene;
          localAppBrandStatObject.cYP = b.boa();
          localAppBrandStatObject.dxE = 0;
          localAppBrandStatObject.dxF = b.bob();
          AppBrandLaunchProxyUI.a(null, str, paramString, 0, -1, localAppBrandStatObject, null, null);
          AppMethodBeat.o(47417);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(47417);
          return false;
          j = 0;
          break label79;
          i += 1;
          break;
        }
      }
      label185:
      AppMethodBeat.o(47417);
      return false;
      localObject1 = null;
    }
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(47418);
    if (a.contains(lpq, paramInt))
    {
      if (a.a.lph == this.lps.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(47418);
        return true;
      }
      AppMethodBeat.o(47418);
      return false;
    }
    if (a.contains(lpr, paramInt))
    {
      if (a.a.lph == this.lpt.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(47418);
        return true;
      }
      AppMethodBeat.o(47418);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.lph == this.lpu.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(47418);
        return true;
      }
      AppMethodBeat.o(47418);
      return false;
    }
    ac.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(47418);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.g
 * JD-Core Version:    0.7.0.1
 */