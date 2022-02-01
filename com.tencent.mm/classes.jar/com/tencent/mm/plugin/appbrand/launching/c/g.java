package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class g
  implements s
{
  private static final int[] pYR = { 1025, 1031, 1032 };
  private static final int[] pYS = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d pYT;
  private final f pYU;
  private final c pYV;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.pYT = new d();
    this.pYU = new f();
    this.pYV = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(280631);
    if (a.contains(pYR, paramInt))
    {
      if (a.a.pYI == this.pYT.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(280631);
        return true;
      }
      AppMethodBeat.o(280631);
      return false;
    }
    if (a.contains(pYS, paramInt))
    {
      if (a.a.pYI == this.pYU.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(280631);
        return true;
      }
      AppMethodBeat.o(280631);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.pYI == this.pYV.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(280631);
        return true;
      }
      AppMethodBeat.o(280631);
      return false;
    }
    Log.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(280631);
    return false;
  }
  
  public final boolean s(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(280630);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(280630);
      return false;
    }
    Log.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
    Object localObject2 = b.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith(localObject1.prefix)))
      {
        j = 1;
        label80:
        if (j == 0) {
          break label116;
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
            label116:
            Log.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
          String str1 = paramString.getQueryParameter("username");
          String str2 = paramString.getQueryParameter("path");
          if ((!Util.isNullOrNil(str1)) && (as.OS(str1))) {
            break label189;
          }
          AppMethodBeat.o(280630);
          return false;
          paramString = new com.tencent.mm.plugin.appbrand.api.g();
          paramString.username = str1;
          paramString.version = -1;
          paramString.cBU = 0;
          paramString.nBq = str2;
          paramString.scene = localObject1.scene;
          paramString.fvd = b.cau();
          paramString.nBt = 0;
          paramString.nBu = b.cav();
          paramBundle = b.T(paramBundle);
          if (paramBundle == null) {
            break label261;
          }
          paramString.nBC = paramBundle;
          ((r)h.ae(r.class)).a(null, paramString);
          AppMethodBeat.o(280630);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(280630);
          return false;
          j = 0;
          break label80;
          i += 1;
          break;
        }
      }
      label189:
      AppMethodBeat.o(280630);
      label261:
      return false;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.g
 * JD-Core Version:    0.7.0.1
 */