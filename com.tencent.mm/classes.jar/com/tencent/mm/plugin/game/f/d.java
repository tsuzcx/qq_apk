package com.tencent.mm.plugin.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static boolean a(f paramf1, f paramf2)
  {
    AppMethodBeat.i(112324);
    if ((paramf1 == null) || (bo.isNullOrNil(paramf1.field_appIconUrl)))
    {
      AppMethodBeat.o(112324);
      return true;
    }
    if ((paramf2 == null) || (bo.isNullOrNil(paramf2.field_appIconUrl)))
    {
      AppMethodBeat.o(112324);
      return false;
    }
    if (!paramf1.field_appIconUrl.equals(paramf2.field_appIconUrl))
    {
      AppMethodBeat.o(112324);
      return true;
    }
    AppMethodBeat.o(112324);
    return false;
  }
  
  public static void ag(LinkedList<? extends f> paramLinkedList)
  {
    AppMethodBeat.i(112325);
    if (paramLinkedList == null)
    {
      ab.e("MicroMsg.GameDataUtil", "Null appInfos");
      AppMethodBeat.o(112325);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      c((f)paramLinkedList.next());
    }
    AppMethodBeat.o(112325);
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(112323);
    if (paramf == null)
    {
      ab.e("MicroMsg.GameDataUtil", "Null appInfo");
      AppMethodBeat.o(112323);
      return;
    }
    if (bo.isNullOrNil(paramf.field_appId))
    {
      ab.e("MicroMsg.GameDataUtil", "Invalid appId");
      AppMethodBeat.o(112323);
      return;
    }
    String str1 = paramf.field_appId;
    f localf = g.ca(str1, true);
    if (localf == null)
    {
      localf = new f();
      localf.field_appId = str1;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      String str2 = aa.dsG();
      boolean bool1;
      if (str2.equals("zh_CN"))
      {
        localf.field_appName = paramf.field_appName;
        localf.field_appType = paramf.field_appType;
        localf.field_packageName = paramf.field_packageName;
        localf.iV(paramf.djJ);
        localf.iY(paramf.djO);
        localf.ho(paramf.djS);
        localf.iZ(paramf.djP);
        localf.je(paramf.djV);
        localf.jf(paramf.djW);
        localf.jc(paramf.djT);
        localf.jd(paramf.djU);
        localf.hp(paramf.djY);
        if (!bo.isNullOrNil(paramf.djM)) {
          localf.iW(paramf.djM);
        }
        if (!bool2) {
          break label307;
        }
        bool1 = com.tencent.mm.plugin.s.a.cac().p(localf);
        a.a.caj().WF(str1);
      }
      for (;;)
      {
        ab.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[] { str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(112323);
        return;
        if ((str2.equals("zh_TW")) || (str2.equals("zh_HK")))
        {
          localf.field_appName_tw = paramf.field_appName;
          break;
        }
        localf.field_appName_en = paramf.field_appName;
        break;
        label307:
        if (localf.field_appVersion < paramf.field_appVersion)
        {
          ab.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[] { Integer.valueOf(localf.field_appVersion), Integer.valueOf(paramf.field_appVersion) });
          bool1 = com.tencent.mm.plugin.s.a.cac().a(localf, new String[0]);
          a.a.caj().WF(str1);
        }
        else if (a(localf, paramf))
        {
          ab.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[] { localf.field_appIconUrl, paramf.field_appIconUrl });
          localf.field_appIconUrl = paramf.field_appIconUrl;
          bool1 = com.tencent.mm.plugin.s.a.cac().a(localf, new String[0]);
          com.tencent.mm.plugin.s.a.caa().el(str1, 1);
          com.tencent.mm.plugin.s.a.caa().el(str1, 2);
          com.tencent.mm.plugin.s.a.caa().el(str1, 3);
          com.tencent.mm.plugin.s.a.caa().el(str1, 4);
          com.tencent.mm.plugin.s.a.caa().el(str1, 5);
        }
        else
        {
          bool1 = com.tencent.mm.plugin.s.a.cac().a(localf, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.d
 * JD-Core Version:    0.7.0.1
 */