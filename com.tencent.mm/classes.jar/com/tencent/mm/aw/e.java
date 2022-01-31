package com.tencent.mm.aw;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import java.util.Map;

public final class e
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    y.d("dancy", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    int k;
    int m;
    int n;
    long l;
    int j;
    label139:
    label154:
    label169:
    String str;
    label185:
    int i;
    if ((bk.pm(paramString).equals("newtips")) && (paramMap != null))
    {
      a.bot();
      if (paramMap != null) {
        break label397;
      }
      y.e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
      paramString = null;
      if (paramString != null)
      {
        k = paramString.field_tipId;
        m = paramString.field_tipVersion;
        n = paramString.field_tipType;
        l = bk.UY();
        ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l).commit();
        if (paramString.field_tipsShowInfo == null) {
          break label719;
        }
        j = paramString.field_tipsShowInfo.showType;
        if (paramString.field_tipsShowInfo == null) {
          break label725;
        }
        paramMap = paramString.field_tipsShowInfo.title;
        if (paramString.field_tipsShowInfo == null) {
          break label731;
        }
        parama = paramString.field_tipsShowInfo.iQn;
        if (paramString.field_tipsShowInfo == null) {
          break label737;
        }
        str = paramString.field_tipsShowInfo.path;
        a.bov();
        if (c.b(paramString)) {
          break label744;
        }
        i = 2;
      }
    }
    label397:
    label719:
    label725:
    label853:
    for (;;)
    {
      h.nFQ.f(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l), "", "", "", "", "", "", "", Integer.valueOf(j), paramMap, parama, str, Integer.valueOf(i), Integer.valueOf(b.evs), "" });
      paramMap = a.bot().evv;
      if (paramMap != null)
      {
        a.bov();
        if (c.d(paramString))
        {
          y.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(paramString.field_isExit), Long.valueOf(paramString.field_beginShowTime) });
          paramMap.e(paramString);
        }
      }
      return null;
      l = bk.UX();
      paramString = new bm();
      paramString.field_tipId = bk.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
      paramString.field_tipVersion = bk.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
      paramString.field_tipType = bk.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
      paramString.field_beginShowTime = Math.max(bk.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
      paramString.field_overdueTime = bk.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
      paramString.field_disappearTime = bk.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
      if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
      {
        paramString.field_tipsShowInfo = new bxw();
        paramString.field_tipsShowInfo.showType = bk.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
        paramString.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
        paramString.field_tipsShowInfo.iQn = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
        paramString.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
      }
      paramString.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
      a.bou().Fr(paramString.field_tipId);
      a.bov();
      if ((c.a(paramString)) && (c.b(paramString)) && (c.c(paramString)) && (!paramString.field_isReject)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString.field_isExit = true;
          a.bou().a(paramString, new String[0]);
        }
        break;
      }
      j = 0;
      break label139;
      paramMap = "";
      break label154;
      label731:
      parama = "";
      break label169;
      label737:
      str = "";
      break label185;
      label744:
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
        bm localbm = a.bou().Fr(paramString.field_tipId);
        if ((localbm != null) && (paramString.field_tipType == localbm.field_tipType)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label819;
          }
          i = 5;
          break;
        }
        if (a.bou().Fr(paramString.field_tipId) != null) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label853;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.e
 * JD-Core Version:    0.7.0.1
 */