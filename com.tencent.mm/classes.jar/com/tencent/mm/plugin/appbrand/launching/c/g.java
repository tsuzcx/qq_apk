package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;

public final class g
  implements p
{
  private static final int[] lMJ = { 1025, 1031, 1032 };
  private static final int[] lMK = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d lML;
  private final f lMM;
  private final c lMN;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.lML = new d();
    this.lMM = new f();
    this.lMN = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(188648);
    if (a.contains(lMJ, paramInt))
    {
      if (a.a.lMA == this.lML.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(188648);
        return true;
      }
      AppMethodBeat.o(188648);
      return false;
    }
    if (a.contains(lMK, paramInt))
    {
      if (a.a.lMA == this.lMM.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(188648);
        return true;
      }
      AppMethodBeat.o(188648);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.lMA == this.lMN.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(188648);
        return true;
      }
      AppMethodBeat.o(188648);
      return false;
    }
    ad.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(188648);
    return false;
  }
  
  public final boolean n(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(188647);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188647);
      return false;
    }
    ad.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
    Object localObject2 = b.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith(localObject1.inP)))
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
            ad.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
          String str1 = paramString.getQueryParameter("username");
          String str2 = paramString.getQueryParameter("path");
          if ((!bt.isNullOrNil(str1)) && (am.yt(str1))) {
            break label189;
          }
          AppMethodBeat.o(188647);
          return false;
          paramString = new com.tencent.mm.plugin.appbrand.api.f();
          paramString.username = str1;
          paramString.version = -1;
          paramString.hQh = 0;
          paramString.jCN = str2;
          paramString.scene = localObject1.scene;
          paramString.dkh = b.brT();
          paramString.jCQ = 0;
          paramString.jCR = b.brU();
          paramBundle = b.K(paramBundle);
          if (paramBundle == null) {
            break label261;
          }
          paramString.jDa = paramBundle;
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(null, paramString);
          AppMethodBeat.o(188647);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(188647);
          return false;
          j = 0;
          break label80;
          i += 1;
          break;
        }
      }
      label189:
      AppMethodBeat.o(188647);
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