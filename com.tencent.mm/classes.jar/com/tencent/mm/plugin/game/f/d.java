package com.tencent.mm.plugin.game.f;

import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static void Y(LinkedList<? extends f> paramLinkedList)
  {
    if (paramLinkedList == null) {
      y.e("MicroMsg.GameDataUtil", "Null appInfos");
    }
    for (;;)
    {
      return;
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext()) {
        a((f)paramLinkedList.next());
      }
    }
  }
  
  public static void a(f paramf)
  {
    if (paramf == null)
    {
      y.e("MicroMsg.GameDataUtil", "Null appInfo");
      return;
    }
    if (bk.bl(paramf.field_appId))
    {
      y.e("MicroMsg.GameDataUtil", "Invalid appId");
      return;
    }
    String str1 = paramf.field_appId;
    f localf = g.by(str1, true);
    if (localf == null)
    {
      localf = new f();
      localf.field_appId = str1;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      String str2 = x.cqJ();
      boolean bool1;
      if (str2.equals("zh_CN"))
      {
        localf.field_appName = paramf.field_appName;
        localf.field_appType = paramf.field_appType;
        localf.field_packageName = paramf.field_packageName;
        localf.cN(paramf.cvy);
        localf.cQ(paramf.cvD);
        localf.fd(paramf.cvH);
        localf.cR(paramf.cvE);
        localf.cW(paramf.cvK);
        localf.cX(paramf.cvL);
        localf.cU(paramf.cvI);
        localf.cV(paramf.cvJ);
        localf.fe(paramf.cvN);
        if (!bk.bl(paramf.cvB)) {
          localf.cO(paramf.cvB);
        }
        if (!bool2) {
          break label307;
        }
        bool1 = com.tencent.mm.plugin.z.a.brn().l(localf);
        a.a.bru().KE(str1);
      }
      label539:
      for (;;)
      {
        y.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[] { str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
          y.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[] { Integer.valueOf(localf.field_appVersion), Integer.valueOf(paramf.field_appVersion) });
          bool1 = com.tencent.mm.plugin.z.a.brn().a(localf, new String[0]);
          a.a.bru().KE(str1);
        }
        else
        {
          int i;
          if ((localf == null) || (bk.bl(localf.field_appIconUrl))) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label539;
            }
            y.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[] { localf.field_appIconUrl, paramf.field_appIconUrl });
            localf.field_appIconUrl = paramf.field_appIconUrl;
            bool1 = com.tencent.mm.plugin.z.a.brn().a(localf, new String[0]);
            com.tencent.mm.plugin.z.a.brl().dg(str1, 1);
            com.tencent.mm.plugin.z.a.brl().dg(str1, 2);
            com.tencent.mm.plugin.z.a.brl().dg(str1, 3);
            com.tencent.mm.plugin.z.a.brl().dg(str1, 4);
            com.tencent.mm.plugin.z.a.brl().dg(str1, 5);
            break;
            if ((paramf == null) || (bk.bl(paramf.field_appIconUrl))) {
              i = 0;
            } else if (!localf.field_appIconUrl.equals(paramf.field_appIconUrl)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          bool1 = com.tencent.mm.plugin.z.a.brn().a(localf, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.d
 * JD-Core Version:    0.7.0.1
 */