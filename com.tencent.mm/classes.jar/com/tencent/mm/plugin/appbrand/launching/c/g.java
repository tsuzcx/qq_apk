package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class g
  implements s
{
  private static final int[] mYs = { 1025, 1031, 1032 };
  private static final int[] mYt = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d mYu;
  private final f mYv;
  private final c mYw;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.mYu = new d();
    this.mYv = new f();
    this.mYw = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(227134);
    if (a.contains(mYs, paramInt))
    {
      if (a.a.mYj == this.mYu.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(227134);
        return true;
      }
      AppMethodBeat.o(227134);
      return false;
    }
    if (a.contains(mYt, paramInt))
    {
      if (a.a.mYj == this.mYv.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(227134);
        return true;
      }
      AppMethodBeat.o(227134);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.mYj == this.mYw.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(227134);
        return true;
      }
      AppMethodBeat.o(227134);
      return false;
    }
    Log.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(227134);
    return false;
  }
  
  public final boolean n(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(227133);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(227133);
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
          if ((!Util.isNullOrNil(str1)) && (as.HF(str1))) {
            break label189;
          }
          AppMethodBeat.o(227133);
          return false;
          paramString = new com.tencent.mm.plugin.appbrand.api.g();
          paramString.username = str1;
          paramString.version = -1;
          paramString.iOo = 0;
          paramString.kHw = str2;
          paramString.scene = localObject1.scene;
          paramString.dCw = b.bOa();
          paramString.kHz = 0;
          paramString.kHA = b.bOb();
          paramBundle = b.R(paramBundle);
          if (paramBundle == null) {
            break label261;
          }
          paramString.kHJ = paramBundle;
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(null, paramString);
          AppMethodBeat.o(227133);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(227133);
          return false;
          j = 0;
          break label80;
          i += 1;
          break;
        }
      }
      label189:
      AppMethodBeat.o(227133);
      label261:
      return false;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.g
 * JD-Core Version:    0.7.0.1
 */