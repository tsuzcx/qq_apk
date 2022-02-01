package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static boolean a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(42528);
    if ((paramg1 == null) || (Util.isNullOrNil(paramg1.field_appIconUrl)))
    {
      AppMethodBeat.o(42528);
      return true;
    }
    if ((paramg2 == null) || (Util.isNullOrNil(paramg2.field_appIconUrl)))
    {
      AppMethodBeat.o(42528);
      return false;
    }
    if (!paramg1.field_appIconUrl.equals(paramg2.field_appIconUrl))
    {
      AppMethodBeat.o(42528);
      return true;
    }
    AppMethodBeat.o(42528);
    return false;
  }
  
  public static void bz(LinkedList<? extends g> paramLinkedList)
  {
    AppMethodBeat.i(42529);
    if (paramLinkedList == null)
    {
      Log.e("MicroMsg.GameDataUtil", "Null appInfos");
      AppMethodBeat.o(42529);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      c((g)paramLinkedList.next());
    }
    AppMethodBeat.o(42529);
  }
  
  public static void c(g paramg)
  {
    AppMethodBeat.i(42527);
    if (paramg == null)
    {
      Log.e("MicroMsg.GameDataUtil", "Null appInfo");
      AppMethodBeat.o(42527);
      return;
    }
    if (Util.isNullOrNil(paramg.field_appId))
    {
      Log.e("MicroMsg.GameDataUtil", "Invalid appId");
      AppMethodBeat.o(42527);
      return;
    }
    String str1 = paramg.field_appId;
    g localg = h.s(str1, true, false);
    if (localg == null)
    {
      localg = new g();
      localg.field_appId = str1;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      String str2 = LocaleUtil.getApplicationLanguage();
      boolean bool1;
      if (str2.equals("zh_CN"))
      {
        localg.field_appName = paramg.field_appName;
        localg.field_appType = paramg.field_appType;
        localg.field_packageName = paramg.field_packageName;
        localg.AE(paramg.jOq);
        localg.AH(paramg.jOv);
        localg.pl(paramg.jOz);
        localg.AI(paramg.jOw);
        localg.AN(paramg.jOC);
        localg.AO(paramg.jOD);
        localg.AL(paramg.jOA);
        localg.AM(paramg.jOB);
        localg.pm(paramg.jOF);
        if (!Util.isNullOrNil(paramg.jOt)) {
          localg.AF(paramg.jOt);
        }
        if (!bool2) {
          break label308;
        }
        bool1 = com.tencent.mm.plugin.openapi.a.gxn().r(localg);
        a.a.gxu().aRb(str1);
      }
      for (;;)
      {
        Log.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[] { str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(42527);
        return;
        if ((str2.equals("zh_TW")) || (str2.equals("zh_HK")))
        {
          localg.field_appName_tw = paramg.field_appName;
          break;
        }
        localg.field_appName_en = paramg.field_appName;
        break;
        label308:
        if (localg.field_appVersion < paramg.field_appVersion)
        {
          Log.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[] { Integer.valueOf(localg.field_appVersion), Integer.valueOf(paramg.field_appVersion) });
          bool1 = com.tencent.mm.plugin.openapi.a.gxn().a(localg, new String[0]);
          a.a.gxu().aRb(str1);
        }
        else if (a(localg, paramg))
        {
          Log.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[] { localg.field_appIconUrl, paramg.field_appIconUrl });
          localg.field_appIconUrl = paramg.field_appIconUrl;
          bool1 = com.tencent.mm.plugin.openapi.a.gxn().a(localg, new String[0]);
          com.tencent.mm.plugin.openapi.a.gxl().ir(str1, 1);
          com.tencent.mm.plugin.openapi.a.gxl().ir(str1, 2);
          com.tencent.mm.plugin.openapi.a.gxl().ir(str1, 3);
          com.tencent.mm.plugin.openapi.a.gxl().ir(str1, 4);
          com.tencent.mm.plugin.openapi.a.gxl().ir(str1, 5);
        }
        else
        {
          bool1 = com.tencent.mm.plugin.openapi.a.gxn().a(localg, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.d
 * JD-Core Version:    0.7.0.1
 */