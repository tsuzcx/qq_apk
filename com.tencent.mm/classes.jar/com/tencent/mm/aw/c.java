package com.tencent.mm.aw;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;

public final class c
{
  public static boolean a(bm parambm)
  {
    if (parambm == null)
    {
      y.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
      return false;
    }
    long l1 = bk.UX();
    boolean bool2;
    if ((parambm.field_overdueTime == 0L) && (parambm.field_disappearTime == 0L))
    {
      bool2 = true;
      y.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", new Object[] { Long.valueOf(l1), Long.valueOf(parambm.field_overdueTime), Long.valueOf(parambm.field_disappearTime), Boolean.valueOf(bool2) });
      return bool2;
    }
    Long localLong = Long.valueOf(Math.min(parambm.field_beginShowTime + parambm.field_overdueTime, parambm.field_disappearTime));
    if ((l1 >= parambm.field_beginShowTime) && (l1 <= localLong.longValue())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (l1 <= localLong.longValue()) {
        break;
      }
      long l2 = bk.UY();
      ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l2).commit();
      bool2 = bool1;
      break;
    }
  }
  
  public static boolean b(bm parambm)
  {
    if (parambm == null) {
      y.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
    }
    do
    {
      return false;
      localObject = a.bou().Fr(parambm.field_tipId);
    } while ((localObject == null) || (((bm)localObject).field_tipsShowInfo == null) || (parambm.field_tipsShowInfo == null));
    Object localObject = ((bm)localObject).field_tipsShowInfo.path;
    parambm = parambm.field_tipsShowInfo.path;
    if (((localObject == null) && (parambm == null)) || ((localObject != null) && (((String)localObject).equals(parambm)))) {
      return true;
    }
    y.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", new Object[] { localObject, parambm });
    return false;
  }
  
  public static boolean c(bm parambm)
  {
    if (parambm == null) {
      y.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
    }
    bm localbm;
    do
    {
      return false;
      localbm = a.bou().Fr(parambm.field_tipId);
    } while ((localbm == null) || ((parambm.field_tipVersion <= localbm.field_tipVersion) && ((parambm.field_hadRead) || (parambm.field_tipVersion != localbm.field_tipVersion))));
    return true;
  }
  
  protected static boolean d(bm parambm)
  {
    if (parambm == null)
    {
      y.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
      return false;
    }
    if ((parambm.field_isExit) && (!parambm.field_hadRead) && (a(parambm))) {
      return true;
    }
    y.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", new Object[] { Boolean.valueOf(parambm.field_isExit), Boolean.valueOf(parambm.field_hadRead), Boolean.valueOf(a(parambm)) });
    return false;
  }
  
  public static boolean iW(int paramInt)
  {
    bm localbm = a.bou().Fr(paramInt);
    if (localbm == null)
    {
      y.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
      return false;
    }
    String str3;
    label270:
    Object localObject;
    label288:
    String str1;
    if ((d(a.bou().Fr(paramInt))) && (localbm.field_tipsShowInfo != null) && (localbm.field_tipsShowInfo.showType == b.evn))
    {
      if (localbm == null) {
        y.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
      }
      do
      {
        return true;
        str3 = String.format("newtips_show_%d-%d", new Object[] { Integer.valueOf(localbm.field_tipId), Integer.valueOf(localbm.field_tipVersion) });
      } while (ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getBoolean(str3, false));
      i = localbm.field_tipId;
      j = localbm.field_tipVersion;
      k = localbm.field_tipType;
      l1 = ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
      l2 = bk.UY();
      ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", l2).commit();
      if (localbm.field_tipsShowInfo != null)
      {
        paramInt = localbm.field_tipsShowInfo.showType;
        if (localbm.field_tipsShowInfo == null) {
          break label513;
        }
        localObject = localbm.field_tipsShowInfo.title;
        if (localbm.field_tipsShowInfo == null) {
          break label520;
        }
        str1 = localbm.field_tipsShowInfo.iQn;
        label306:
        if (localbm.field_tipsShowInfo == null) {
          break label527;
        }
      }
      label513:
      label520:
      label527:
      for (str2 = localbm.field_tipsShowInfo.path;; str2 = "")
      {
        h.nFQ.f(14995, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), "", "", "", Long.valueOf(l2), "", "", "", Integer.valueOf(paramInt), localObject, str1, str2, "", Integer.valueOf(b.evt), "" });
        ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
        break;
        paramInt = 0;
        break label270;
        localObject = "";
        break label288;
        str1 = "";
        break label306;
      }
    }
    if (localbm == null) {
      y.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
    }
    do
    {
      return false;
      str3 = String.format("newtips_dismiss_%d-%d", new Object[] { Integer.valueOf(localbm.field_tipId), Integer.valueOf(localbm.field_tipVersion) });
    } while (ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getBoolean(str3, false));
    int j = localbm.field_tipId;
    int k = localbm.field_tipVersion;
    int m = localbm.field_tipType;
    long l1 = ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
    long l2 = localbm.field_beginShowTime;
    long l3 = localbm.field_overdueTime;
    long l4 = localbm.field_disappearTime;
    long l5 = ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getLong("newtips_realshow_time", 0L);
    long l6 = ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).getLong("newtips_makeread_time", 0L);
    int i = 0;
    long l7 = bk.UX();
    if ((!b(localbm)) || (!c(localbm)))
    {
      paramInt = 1;
      label799:
      if (localbm.field_tipsShowInfo == null) {
        break label1290;
      }
      i = localbm.field_tipsShowInfo.showType;
      label816:
      if (localbm.field_tipsShowInfo == null) {
        break label1295;
      }
      localObject = localbm.field_tipsShowInfo.title;
      label834:
      if (localbm.field_tipsShowInfo == null) {
        break label1302;
      }
      str1 = localbm.field_tipsShowInfo.iQn;
      label852:
      if (localbm.field_tipsShowInfo == null) {
        break label1309;
      }
    }
    label1290:
    label1295:
    label1302:
    label1309:
    for (String str2 = localbm.field_tipsShowInfo.path;; str2 = "")
    {
      l7 = localbm.field_pagestaytime;
      h.nFQ.f(14995, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l6 - l5), Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str1, str2, "", Integer.valueOf(b.evu), Long.valueOf(l7) });
      if (m == b.eve)
      {
        localObject = a.bou();
        str1 = "delete from NewTipsInfo where tipId = " + localbm.field_tipId;
        y.i("MicroMsg.NewTipsInfoStorage", "delete sql: " + str1);
        ((bn)localObject).dXw.gk("NewTipsInfo", str1);
        ((bn)localObject).b(localbm.field_tipId, 5, Integer.valueOf(localbm.field_tipId));
      }
      ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
      break;
      if (localbm.field_hadRead)
      {
        paramInt = 4;
        break label799;
      }
      if ((localbm.field_disappearTime != 0L) && (l7 > localbm.field_disappearTime))
      {
        paramInt = 3;
        break label799;
      }
      paramInt = i;
      if (localbm.field_overdueTime == 0L) {
        break label799;
      }
      paramInt = i;
      if (localbm.field_beginShowTime + localbm.field_overdueTime > localbm.field_disappearTime) {
        break label799;
      }
      paramInt = i;
      if (l7 <= localbm.field_beginShowTime + localbm.field_overdueTime) {
        break label799;
      }
      paramInt = 2;
      break label799;
      i = 0;
      break label816;
      localObject = "";
      break label834;
      str1 = "";
      break label852;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.c
 * JD-Core Version:    0.7.0.1
 */