package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;

public final class g
  implements q
{
  private static final int[] lRj = { 1025, 1031, 1032 };
  private static final int[] lRk = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d lRl;
  private final f lRm;
  private final c lRn;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.lRl = new d();
    this.lRm = new f();
    this.lRn = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(222810);
    if (a.contains(lRj, paramInt))
    {
      if (a.a.lRa == this.lRl.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(222810);
        return true;
      }
      AppMethodBeat.o(222810);
      return false;
    }
    if (a.contains(lRk, paramInt))
    {
      if (a.a.lRa == this.lRm.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(222810);
        return true;
      }
      AppMethodBeat.o(222810);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.lRa == this.lRn.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(222810);
        return true;
      }
      AppMethodBeat.o(222810);
      return false;
    }
    ae.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(222810);
    return false;
  }
  
  public final boolean n(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(222809);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(222809);
      return false;
    }
    ae.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[] { paramString });
    Object localObject2 = b.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if ((!bu.isNullOrNil(paramString)) && (paramString.startsWith(localObject1.iqJ)))
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
            ae.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[] { paramString, localException });
            paramString = null;
          }
          String str1 = paramString.getQueryParameter("username");
          String str2 = paramString.getQueryParameter("path");
          if ((!bu.isNullOrNil(str1)) && (an.zd(str1))) {
            break label189;
          }
          AppMethodBeat.o(222809);
          return false;
          paramString = new com.tencent.mm.plugin.appbrand.api.f();
          paramString.username = str1;
          paramString.version = -1;
          paramString.hSZ = 0;
          paramString.jFL = str2;
          paramString.scene = localObject1.scene;
          paramString.dlj = b.bsE();
          paramString.jFO = 0;
          paramString.jFP = b.bsF();
          paramBundle = b.L(paramBundle);
          if (paramBundle == null) {
            break label261;
          }
          paramString.jFY = paramBundle;
          ((p)com.tencent.mm.kernel.g.ab(p.class)).a(null, paramString);
          AppMethodBeat.o(222809);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(222809);
          return false;
          j = 0;
          break label80;
          i += 1;
          break;
        }
      }
      label189:
      AppMethodBeat.o(222809);
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