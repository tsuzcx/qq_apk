package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

public final class g
  implements e
{
  private static final int[] gMf = { 1025, 1031, 1032 };
  private static final int[] gMg = { 1011, 1012, 1013, 1047, 1049, 1048, 1050 };
  private final d gMh = new d();
  private final f gMi = new f();
  private final c gMj = new c();
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    if (a.d(gMf, paramInt)) {
      if (a.a.gLW != this.gMh.a(paramContext, paramString, paramInt, paramBundle)) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!a.d(gMg, paramInt)) {
          break;
        }
      } while (a.a.gLW == this.gMi.a(paramContext, paramString, paramInt, paramBundle));
      return false;
      if ((1064 != paramInt) && (1078 != paramInt)) {
        break;
      }
    } while (a.a.gLW == this.gMj.a(paramContext, paramString, paramInt, paramBundle));
    return false;
    y.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    return false;
  }
  
  public final boolean uW(String paramString)
  {
    if (bk.bl(paramString)) {}
    label36:
    label69:
    label223:
    for (;;)
    {
      return false;
      y.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
      Object localObject2 = b.values();
      int k = localObject2.length;
      int i = 0;
      Object localObject1;
      int j;
      if (i < k)
      {
        localObject1 = localObject2[i];
        if ((!bk.bl(paramString)) && (paramString.startsWith(localObject1.eyz)))
        {
          j = 1;
          if (j == 0) {
            break label185;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label223;
        }
        try
        {
          localObject2 = Uri.parse(paramString);
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            AppBrandStatObject localAppBrandStatObject;
            y.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
        }
        if (paramString == null) {
          break;
        }
        localObject2 = paramString.getQueryParameter("username");
        paramString = paramString.getQueryParameter("path");
        if ((bk.bl((String)localObject2)) || (!ad.gr((String)localObject2))) {
          break;
        }
        localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = localObject1.scene;
        localAppBrandStatObject.bFv = b.alW();
        localAppBrandStatObject.caB = b.alX();
        localAppBrandStatObject.caC = b.alY();
        AppBrandLaunchProxyUI.a(null, (String)localObject2, paramString, 0, -1, localAppBrandStatObject, null, null);
        return true;
        j = 0;
        break label69;
        i += 1;
        break label36;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.g
 * JD-Core Version:    0.7.0.1
 */