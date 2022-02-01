package com.tencent.mm.plugin.lite.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppCallback;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public class c
  implements LiteAppCenter.ILiteAppCallback
{
  public static c tWg;
  
  public static com.tencent.mm.plugin.lite.d.b ajL(String paramString)
  {
    AppMethodBeat.i(205712);
    try
    {
      paramString = ai.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/"), "getLiteAppInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(205712);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.LiteApp.LiteAppService", paramString, "", new Object[0]);
        paramString = null;
      }
      com.tencent.mm.plugin.lite.d.b localb = new com.tencent.mm.plugin.lite.d.b();
      localb.field_appId = paramString.getString("appId");
      localb.field_updateTime = paramString.getLong("updateTime");
      localb.field_patchId = paramString.getString("patchId");
      localb.field_pkgPath = paramString.getString("pkgPath");
      localb.field_pkgType = paramString.getString("pkgType");
      localb.field_signatureKey = paramString.getString("signatureKey");
      AppMethodBeat.o(205712);
      return localb;
    }
  }
  
  private static boolean b(com.tencent.mm.plugin.lite.d.b paramb)
  {
    AppMethodBeat.i(205714);
    if (paramb == null)
    {
      AppMethodBeat.o(205714);
      return true;
    }
    if (paramb.cWv())
    {
      AppMethodBeat.o(205714);
      return false;
    }
    AppMethodBeat.o(205714);
    return true;
  }
  
  public static c cWu()
  {
    AppMethodBeat.i(205710);
    if (tWg == null) {}
    try
    {
      c localc = new c();
      tWg = localc;
      LiteAppCenter.setCallback(localc);
      localc = tWg;
      AppMethodBeat.o(205710);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(205710);
    }
  }
  
  public static void d(com.tencent.mm.plugin.lite.d.b paramb)
  {
    AppMethodBeat.i(210481);
    if (paramb.field_appId.equalsIgnoreCase("wxalited0d6cb88ac866bcdf3b738f1f3df8872"))
    {
      aw localaw = aw.eVA();
      localaw.putString("wxa_lite_app_game_center_version", paramb.field_patchId);
      localaw.commit();
    }
    AppMethodBeat.o(210481);
  }
  
  public static boolean dzy()
  {
    AppMethodBeat.i(210483);
    if (ai.cin())
    {
      boolean bool;
      int i;
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXa, 0) == 1)
      {
        bool = true;
        i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.sKa, 10);
        localObject = ajL("wxalited0d6cb88ac866bcdf3b738f1f3df8872");
        if (localObject != null) {
          break label146;
        }
      }
      label146:
      for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.lite.d.b)localObject).field_patchId)
      {
        int j = aw.eVA().getInt("count_".concat(String.valueOf(localObject)), 0);
        ac.i("MicroMsg.LiteApp.LiteAppService", "isLiteAppOpen version%s enable:%b, crashCount:%d", new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label174;
        }
        if (j >= i) {
          break label154;
        }
        h.wUl.n(1293L, 100L, 1L);
        AppMethodBeat.o(210483);
        return true;
        bool = false;
        break;
      }
      label154:
      h.wUl.n(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(210483);
        return false;
        label174:
        h.wUl.n(1293L, 102L, 1L);
      }
    }
    ac.i("MicroMsg.LiteApp.LiteAppService", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(210483);
    return false;
  }
  
  public static boolean exo()
  {
    AppMethodBeat.i(210482);
    if (ai.cin())
    {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXa, 0) == 1)
      {
        AppMethodBeat.o(210482);
        return true;
      }
      AppMethodBeat.o(210482);
      return false;
    }
    AppMethodBeat.o(210482);
    return false;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(205711);
    Uri localUri = Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/");
    AppMethodBeat.o(205711);
    return localUri;
  }
  
  public final void a(String paramString, final a parama)
  {
    AppMethodBeat.i(205713);
    final com.tencent.mm.plugin.lite.d.b localb = ajL(paramString);
    if (b(localb)) {
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
          AppMethodBeat.i(205709);
          if (!bs.isNullOrNil(paramAnonymousg.gnO))
          {
            com.tencent.mm.plugin.lite.b.tVw.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(205709);
            return;
          }
          if (parama != null)
          {
            if (localb != null)
            {
              parama.a(localb);
              AppMethodBeat.o(205709);
              return;
            }
            parama.cOG();
          }
          AppMethodBeat.o(205709);
        }
      });
      AppMethodBeat.o(205713);
      return;
      if (parama != null) {
        parama.a(localb);
      }
      AppMethodBeat.o(205713);
      return;
    }
  }
  
  public String[] getAppInfo(String paramString)
  {
    AppMethodBeat.i(205715);
    Object localObject = ajL(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(205715);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath;
    localObject = ((com.tencent.mm.plugin.lite.d.b)localObject).field_signatureKey;
    AppMethodBeat.o(205715);
    return new String[] { paramString, localObject };
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.c
 * JD-Core Version:    0.7.0.1
 */