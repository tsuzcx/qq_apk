package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public final class g
  implements u
{
  public static final int[] tdE = { 1025, 1031, 1032 };
  public static final int[] tdF = { 1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126 };
  private final d tdG;
  private final f tdH;
  private final c tdI;
  
  public g()
  {
    AppMethodBeat.i(47416);
    this.tdG = new d();
    this.tdH = new f();
    this.tdI = new c();
    AppMethodBeat.o(47416);
  }
  
  public final boolean b(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(321043);
    if (a.contains(tdE, paramInt))
    {
      if (a.a.tdv == this.tdG.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(321043);
        return true;
      }
      AppMethodBeat.o(321043);
      return false;
    }
    if (a.contains(tdF, paramInt))
    {
      if (a.a.tdv == this.tdH.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(321043);
        return true;
      }
      AppMethodBeat.o(321043);
      return false;
    }
    if ((1064 == paramInt) || (1078 == paramInt))
    {
      if (a.a.tdv == this.tdI.a(paramContext, paramString, paramInt, paramBundle1, paramBundle2))
      {
        AppMethodBeat.o(321043);
        return true;
      }
      AppMethodBeat.o(321043);
      return false;
    }
    Log.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(321043);
    return false;
  }
  
  public final boolean s(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(321042);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(321042);
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
          if ((!Util.isNullOrNil(str1)) && (au.Hh(str1))) {
            break label189;
          }
          AppMethodBeat.o(321042);
          return false;
          paramString = new com.tencent.mm.plugin.appbrand.api.g();
          paramString.username = str1;
          paramString.version = -1;
          paramString.euz = 0;
          paramString.qAF = str2;
          paramString.scene = localObject1.scene;
          paramString.hzx = b.cAK();
          paramString.qAI = b.cAL();
          paramString.qAJ = b.cAM();
          paramBundle = b.ae(paramBundle);
          if (paramBundle == null) {
            break label263;
          }
          paramString.qAR = paramBundle;
          ((t)h.ax(t.class)).a(null, paramString);
          AppMethodBeat.o(321042);
          return true;
        }
        if (paramString == null)
        {
          AppMethodBeat.o(321042);
          return false;
          j = 0;
          break label80;
          i += 1;
          break;
        }
      }
      label189:
      AppMethodBeat.o(321042);
      label263:
      return false;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.g
 * JD-Core Version:    0.7.0.1
 */