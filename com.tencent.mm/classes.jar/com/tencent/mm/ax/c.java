package com.tencent.mm.ax;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;

public final class c
{
  public static boolean a(bm parambm)
  {
    AppMethodBeat.i(78420);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
      AppMethodBeat.o(78420);
      return false;
    }
    long l1 = bo.aox();
    boolean bool2;
    if ((parambm.field_overdueTime == 0L) && (parambm.field_disappearTime == 0L))
    {
      bool2 = true;
      ab.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", new Object[] { Long.valueOf(l1), Long.valueOf(parambm.field_overdueTime), Long.valueOf(parambm.field_disappearTime), Boolean.valueOf(bool2) });
      AppMethodBeat.o(78420);
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
      long l2 = bo.aoy();
      ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l2).commit();
      bool2 = bool1;
      break;
    }
  }
  
  public static boolean b(bm parambm)
  {
    AppMethodBeat.i(78421);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
      AppMethodBeat.o(78421);
      return false;
    }
    Object localObject = a.bWT().Ny(parambm.field_tipId);
    if ((localObject != null) && (((bm)localObject).field_tipsShowInfo != null) && (parambm.field_tipsShowInfo != null))
    {
      localObject = ((bm)localObject).field_tipsShowInfo.path;
      parambm = parambm.field_tipsShowInfo.path;
      if (((localObject == null) && (parambm == null)) || ((localObject != null) && (((String)localObject).equals(parambm))))
      {
        AppMethodBeat.o(78421);
        return true;
      }
      ab.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", new Object[] { localObject, parambm });
    }
    AppMethodBeat.o(78421);
    return false;
  }
  
  public static boolean c(bm parambm)
  {
    AppMethodBeat.i(78422);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
      AppMethodBeat.o(78422);
      return false;
    }
    bm localbm = a.bWT().Ny(parambm.field_tipId);
    if ((localbm != null) && ((parambm.field_tipVersion > localbm.field_tipVersion) || ((!parambm.field_hadRead) && (parambm.field_tipVersion == localbm.field_tipVersion))))
    {
      AppMethodBeat.o(78422);
      return true;
    }
    AppMethodBeat.o(78422);
    return false;
  }
  
  protected static boolean d(bm parambm)
  {
    AppMethodBeat.i(78423);
    if (parambm == null)
    {
      ab.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
      AppMethodBeat.o(78423);
      return false;
    }
    if ((parambm.field_isExit) && (!parambm.field_hadRead) && (a(parambm)))
    {
      AppMethodBeat.o(78423);
      return true;
    }
    ab.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", new Object[] { Boolean.valueOf(parambm.field_isExit), Boolean.valueOf(parambm.field_hadRead), Boolean.valueOf(a(parambm)) });
    AppMethodBeat.o(78423);
    return false;
  }
  
  public static boolean lO(int paramInt)
  {
    AppMethodBeat.i(78424);
    bm localbm = a.bWT().Ny(paramInt);
    if (localbm == null)
    {
      ab.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
      AppMethodBeat.o(78424);
      return false;
    }
    String str3;
    label285:
    Object localObject;
    label303:
    String str1;
    if ((d(a.bWT().Ny(paramInt))) && (localbm.field_tipsShowInfo != null) && (localbm.field_tipsShowInfo.showType == b.fLa))
    {
      if (localbm == null) {
        ab.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
      }
      do
      {
        AppMethodBeat.o(78424);
        return true;
        str3 = String.format("newtips_show_%d-%d", new Object[] { Integer.valueOf(localbm.field_tipId), Integer.valueOf(localbm.field_tipVersion) });
      } while (ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getBoolean(str3, false));
      i = localbm.field_tipId;
      j = localbm.field_tipVersion;
      k = localbm.field_tipType;
      l1 = ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
      l2 = bo.aoy();
      ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", l2).commit();
      if (localbm.field_tipsShowInfo != null)
      {
        paramInt = localbm.field_tipsShowInfo.showType;
        if (localbm.field_tipsShowInfo == null) {
          break label528;
        }
        localObject = localbm.field_tipsShowInfo.title;
        if (localbm.field_tipsShowInfo == null) {
          break label535;
        }
        str1 = localbm.field_tipsShowInfo.kWy;
        label321:
        if (localbm.field_tipsShowInfo == null) {
          break label542;
        }
      }
      label528:
      label535:
      label542:
      for (str2 = localbm.field_tipsShowInfo.path;; str2 = "")
      {
        h.qsU.e(14995, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l1), "", "", "", Long.valueOf(l2), "", "", "", Integer.valueOf(paramInt), localObject, str1, str2, "", Integer.valueOf(b.fLg), "" });
        ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
        break;
        paramInt = 0;
        break label285;
        localObject = "";
        break label303;
        str1 = "";
        break label321;
      }
    }
    if (localbm == null) {
      ab.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
    }
    do
    {
      AppMethodBeat.o(78424);
      return false;
      str3 = String.format("newtips_dismiss_%d-%d", new Object[] { Integer.valueOf(localbm.field_tipId), Integer.valueOf(localbm.field_tipVersion) });
    } while (ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getBoolean(str3, false));
    int j = localbm.field_tipId;
    int k = localbm.field_tipVersion;
    int m = localbm.field_tipType;
    long l1 = ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getLong("newtips_gettipstime", 0L);
    long l2 = localbm.field_beginShowTime;
    long l3 = localbm.field_overdueTime;
    long l4 = localbm.field_disappearTime;
    long l5 = ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getLong("newtips_realshow_time", 0L);
    long l6 = ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).getLong("newtips_makeread_time", 0L);
    int i = 0;
    long l7 = bo.aox();
    if ((!b(localbm)) || (!c(localbm)))
    {
      paramInt = 1;
      label819:
      if (localbm.field_tipsShowInfo == null) {
        break label1303;
      }
      i = localbm.field_tipsShowInfo.showType;
      label836:
      if (localbm.field_tipsShowInfo == null) {
        break label1308;
      }
      localObject = localbm.field_tipsShowInfo.title;
      label854:
      if (localbm.field_tipsShowInfo == null) {
        break label1315;
      }
      str1 = localbm.field_tipsShowInfo.kWy;
      label872:
      if (localbm.field_tipsShowInfo == null) {
        break label1322;
      }
    }
    label1303:
    label1308:
    label1315:
    label1322:
    for (String str2 = localbm.field_tipsShowInfo.path;; str2 = "")
    {
      l7 = localbm.field_pagestaytime;
      h.qsU.e(14995, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l6 - l5), Integer.valueOf(paramInt), Integer.valueOf(i), localObject, str1, str2, "", Integer.valueOf(b.fLh), Long.valueOf(l7) });
      if (m == b.fKR)
      {
        localObject = a.bWT();
        str1 = "delete from NewTipsInfo where tipId = " + localbm.field_tipId;
        ab.i("MicroMsg.NewTipsInfoStorage", "delete sql: ".concat(String.valueOf(str1)));
        ((bn)localObject).db.execSQL("NewTipsInfo", str1);
        ((bn)localObject).doNotify(localbm.field_tipId, 5, Integer.valueOf(localbm.field_tipId));
      }
      ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).edit().putBoolean(str3, true).commit();
      break;
      if (localbm.field_hadRead)
      {
        paramInt = 4;
        break label819;
      }
      if ((localbm.field_disappearTime != 0L) && (l7 > localbm.field_disappearTime))
      {
        paramInt = 3;
        break label819;
      }
      paramInt = i;
      if (localbm.field_overdueTime == 0L) {
        break label819;
      }
      paramInt = i;
      if (localbm.field_beginShowTime + localbm.field_overdueTime > localbm.field_disappearTime) {
        break label819;
      }
      paramInt = i;
      if (l7 <= localbm.field_beginShowTime + localbm.field_overdueTime) {
        break label819;
      }
      paramInt = 2;
      break label819;
      i = 0;
      break label836;
      localObject = "";
      break label854;
      str1 = "";
      break label872;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ax.c
 * JD-Core Version:    0.7.0.1
 */