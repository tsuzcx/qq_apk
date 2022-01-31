package com.tencent.mm.ax;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import java.util.Map;

public final class e
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(78429);
    ab.d("dancy", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    int k;
    int m;
    int n;
    long l;
    int j;
    label144:
    label159:
    label174:
    String str;
    label190:
    int i;
    if ((bo.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      a.bWS();
      if (paramMap != null) {
        break label407;
      }
      ab.e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
      paramString = null;
      if (paramString != null)
      {
        k = paramString.field_tipId;
        m = paramString.field_tipVersion;
        n = paramString.field_tipType;
        l = bo.aoy();
        ah.getContext().getSharedPreferences(ah.dsP() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l).commit();
        if (paramString.field_tipsShowInfo == null) {
          break label733;
        }
        j = paramString.field_tipsShowInfo.showType;
        if (paramString.field_tipsShowInfo == null) {
          break label739;
        }
        paramMap = paramString.field_tipsShowInfo.title;
        if (paramString.field_tipsShowInfo == null) {
          break label745;
        }
        parama = paramString.field_tipsShowInfo.kWy;
        if (paramString.field_tipsShowInfo == null) {
          break label751;
        }
        str = paramString.field_tipsShowInfo.path;
        a.bWU();
        if (c.b(paramString)) {
          break label758;
        }
        i = 2;
      }
    }
    label407:
    label733:
    label739:
    label867:
    for (;;)
    {
      h.qsU.e(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l), "", "", "", "", "", "", "", Integer.valueOf(j), paramMap, parama, str, Integer.valueOf(i), Integer.valueOf(b.fLf), "" });
      paramMap = a.bWS().fLi;
      if (paramMap != null)
      {
        a.bWU();
        if (c.d(paramString))
        {
          ab.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(paramString.field_isExit), Long.valueOf(paramString.field_beginShowTime) });
          paramMap.e(paramString);
        }
      }
      AppMethodBeat.o(78429);
      return null;
      l = bo.aox();
      paramString = new bm();
      paramString.field_tipId = bo.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
      paramString.field_tipVersion = bo.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
      paramString.field_tipType = bo.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
      paramString.field_beginShowTime = Math.max(bo.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
      paramString.field_overdueTime = bo.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
      paramString.field_disappearTime = bo.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
      if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
      {
        paramString.field_tipsShowInfo = new ckh();
        paramString.field_tipsShowInfo.showType = bo.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
        paramString.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
        paramString.field_tipsShowInfo.kWy = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
        paramString.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
      }
      paramString.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
      a.bWT().Ny(paramString.field_tipId);
      a.bWU();
      if ((c.a(paramString)) && (c.b(paramString)) && (c.c(paramString)) && (!paramString.field_isReject)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString.field_isExit = true;
          a.bWT().a(paramString, new String[0]);
        }
        break;
      }
      j = 0;
      break label144;
      paramMap = "";
      break label159;
      label745:
      parama = "";
      break label174;
      label751:
      str = "";
      break label190;
      label758:
      if (!c.c(paramString))
      {
        i = 3;
      }
      else if (!c.a(paramString))
      {
        i = 4;
      }
      else
      {
        bm localbm = a.bWT().Ny(paramString.field_tipId);
        if ((localbm != null) && (paramString.field_tipType == localbm.field_tipType)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label833;
          }
          i = 5;
          break;
        }
        if (a.bWT().Ny(paramString.field_tipId) != null) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label867;
          }
          i = 6;
          break;
        }
        if (paramString.field_isReject) {
          i = 7;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ax.e
 * JD-Core Version:    0.7.0.1
 */