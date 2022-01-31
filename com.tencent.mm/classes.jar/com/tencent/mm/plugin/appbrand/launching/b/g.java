package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class g
  implements k
{
  private static final int[] inw = { 1025, 1031, 1032 };
  private static final int[] inx = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final c inA;
  private final d iny;
  private final f inz;
  
  public g()
  {
    AppMethodBeat.i(132041);
    this.iny = new d();
    this.inz = new f();
    this.inA = new c();
    AppMethodBeat.o(132041);
  }
  
  public final boolean Dp(String paramString)
  {
    AppMethodBeat.i(132042);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132042);
      return false;
    }
    ab.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
    Object localObject2 = b.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith(localObject1.fOn)))
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
            ab.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
          String str = paramString.getQueryParameter("username");
          paramString = paramString.getQueryParameter("path");
          if ((!bo.isNullOrNil(str)) && (ad.na(str))) {
            break label185;
          }
          AppMethodBeat.o(132042);
          return false;
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = localObject1.scene;
          localAppBrandStatObject.cmF = b.aHq();
          localAppBrandStatObject.cJb = 0;
          localAppBrandStatObject.cJc = b.aHr();
          AppBrandLaunchProxyUI.a(null, str, paramString, 0, -1, localAppBrandStatObject, null, null);
          AppMethodBeat.o(132042);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(132042);
          return false;
          j = 0;
          break label79;
          i += 1;
          break;
        }
      }
      label185:
      AppMethodBeat.o(132042);
      return false;
      localObject1 = null;
    }
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(132043);
    if (a.contains(inw, paramInt))
    {
      if (a.a.inm == this.iny.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(132043);
        return true;
      }
      AppMethodBeat.o(132043);
      return false;
    }
    if (a.contains(inx, paramInt))
    {
      if (a.a.inm == this.inz.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(132043);
        return true;
      }
      AppMethodBeat.o(132043);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.inm == this.inA.a(paramContext, paramString, paramInt, paramBundle))
      {
        AppMethodBeat.o(132043);
        return true;
      }
      AppMethodBeat.o(132043);
      return false;
    }
    ab.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(132043);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.g
 * JD-Core Version:    0.7.0.1
 */