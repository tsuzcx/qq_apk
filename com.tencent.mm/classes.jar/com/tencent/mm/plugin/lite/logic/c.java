package com.tencent.mm.plugin.lite.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppCallback;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class c
  implements LiteAppCenter.ILiteAppCallback
{
  public static c uYP;
  
  public static com.tencent.mm.plugin.lite.d.b aoy(String paramString)
  {
    AppMethodBeat.i(217189);
    try
    {
      paramString = aj.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/"), "getLiteAppInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(217189);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.LiteApp.LiteAppService", paramString, "", new Object[0]);
        paramString = null;
      }
      com.tencent.mm.plugin.lite.d.b localb = new com.tencent.mm.plugin.lite.d.b();
      localb.field_appId = paramString.getString("appId");
      localb.field_updateTime = paramString.getLong("updateTime");
      localb.field_patchId = paramString.getString("patchId");
      localb.field_pkgPath = paramString.getString("pkgPath");
      localb.field_pkgType = paramString.getString("pkgType");
      localb.field_signatureKey = paramString.getString("signatureKey");
      AppMethodBeat.o(217189);
      return localb;
    }
  }
  
  public static void b(com.tencent.mm.plugin.lite.d.b paramb)
  {
    AppMethodBeat.i(217190);
    if (paramb.field_appId.equalsIgnoreCase("wxalited0d6cb88ac866bcdf3b738f1f3df8872"))
    {
      ax localax = ax.flh();
      localax.putString("wxa_lite_app_game_center_version", paramb.field_patchId);
      localax.commit();
    }
    AppMethodBeat.o(217190);
  }
  
  private static boolean c(com.tencent.mm.plugin.lite.d.b paramb)
  {
    AppMethodBeat.i(217192);
    if (paramb == null)
    {
      AppMethodBeat.o(217192);
      return true;
    }
    if (paramb.dfH())
    {
      AppMethodBeat.o(217192);
      return false;
    }
    AppMethodBeat.o(217192);
    return true;
  }
  
  public static boolean dfC()
  {
    AppMethodBeat.i(217195);
    if (aj.cmR())
    {
      boolean bool;
      int i;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCc, 0) == 1)
      {
        bool = true;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCe, 10);
        localObject = aoy("wxalited0d6cb88ac866bcdf3b738f1f3df8872");
        if (localObject != null) {
          break label146;
        }
      }
      label146:
      for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.lite.d.b)localObject).field_patchId)
      {
        int j = ax.flh().getInt("count_".concat(String.valueOf(localObject)), 0);
        ad.i("MicroMsg.LiteApp.LiteAppService", "isLiteAppOpen version%s enable:%b, crashCount:%d", new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label174;
        }
        if (j >= i) {
          break label154;
        }
        com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 100L, 1L);
        AppMethodBeat.o(217195);
        return true;
        bool = false;
        break;
      }
      label154:
      com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(217195);
        return false;
        label174:
        com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 102L, 1L);
      }
    }
    ad.i("MicroMsg.LiteApp.LiteAppService", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(217195);
    return false;
  }
  
  public static c dfF()
  {
    AppMethodBeat.i(217187);
    if (uYP == null) {}
    try
    {
      c localc = new c();
      uYP = localc;
      LiteAppCenter.setCallback(localc);
      localc = uYP;
      AppMethodBeat.o(217187);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(217187);
    }
  }
  
  public static boolean dfG()
  {
    AppMethodBeat.i(217194);
    if (aj.cmR())
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCc, 0) == 1)
      {
        AppMethodBeat.o(217194);
        return true;
      }
      AppMethodBeat.o(217194);
      return false;
    }
    AppMethodBeat.o(217194);
    return false;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(217188);
    Uri localUri = Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/");
    AppMethodBeat.o(217188);
    return localUri;
  }
  
  public final void a(String paramString, final a parama)
  {
    AppMethodBeat.i(217191);
    final com.tencent.mm.plugin.lite.d.b localb = aoy(paramString);
    if (c(localb)) {
      if ((localb == null) || (localb.field_patchId == null) || (localb.field_patchId.isEmpty())) {
        break label100;
      }
    }
    label100:
    for (String str = localb.field_patchId;; str = "")
    {
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).a(paramString, paramString, str, new f()
      {
        public final void a(com.tencent.mm.plugin.boots.a.g paramAnonymousg)
        {
          AppMethodBeat.i(217186);
          if (!bt.isNullOrNil(paramAnonymousg.gHx))
          {
            com.tencent.mm.plugin.lite.b.uXY.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(217186);
            return;
          }
          if (parama != null)
          {
            if (localb != null)
            {
              parama.a(localb);
              AppMethodBeat.o(217186);
              return;
            }
            parama.cXf();
          }
          AppMethodBeat.o(217186);
        }
      });
      AppMethodBeat.o(217191);
      return;
      if (parama != null) {
        parama.a(localb);
      }
      AppMethodBeat.o(217191);
      return;
    }
  }
  
  public String[] getAppInfo(String paramString)
  {
    AppMethodBeat.i(217193);
    Object localObject = aoy(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(217193);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath;
    localObject = ((com.tencent.mm.plugin.lite.d.b)localObject).field_signatureKey;
    AppMethodBeat.o(217193);
    return new String[] { paramString, localObject };
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.c
 * JD-Core Version:    0.7.0.1
 */