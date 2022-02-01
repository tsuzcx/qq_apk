package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.qf;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.b.t;
import com.tencent.mm.plugin.fts.ui.b.u;
import com.tencent.mm.plugin.fts.ui.d.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.threadpool.i;
import java.util.ArrayList;

public final class l
{
  private static int C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      paramInt2 = 15;
    }
    do
    {
      return paramInt2;
      if (paramInt1 == 131072)
      {
        switch (paramInt2)
        {
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          return 0;
        case 1: 
          return 1;
        case 2: 
          return 2;
        case 3: 
          return 3;
        case 4: 
          return 4;
        case 5: 
          return 5;
        case 6: 
          return 6;
        case 7: 
          return 7;
        case 11: 
          return 8;
        case 16: 
          return 10;
        case 17: 
        case 18: 
          return 9;
        }
        return 16;
      }
      if (paramInt1 == 131075)
      {
        switch (paramInt2)
        {
        default: 
          return 0;
        case 1: 
        case 5: 
          return 12;
        case 2: 
        case 6: 
          return 13;
        case 3: 
        case 7: 
          return 14;
        }
        return 11;
      }
      if (paramInt1 == 131081) {
        return 19;
      }
      paramInt2 = i;
    } while (paramInt1 != 65536);
    return 17;
  }
  
  private static int Wo(int paramInt)
  {
    int i = 6;
    switch (paramInt)
    {
    case 33: 
    default: 
      i = 0;
    case 35: 
    case 36: 
      return i;
    case 37: 
      return 16;
    case 32: 
      return 4;
    case 34: 
      return 5;
    case 29: 
      return 1;
    case 30: 
      return 2;
    }
    return 3;
  }
  
  public static final int a(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    int i = 3;
    int j = parama.xVf;
    if (j == -8)
    {
      if (parama.xVf == -8) {}
      switch (parama.viewType)
      {
      default: 
        i = 0;
      }
      while (i != 0)
      {
        return 2;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 10;
        continue;
        i = 19;
        continue;
        i = 31;
      }
    }
    switch (parama.viewType)
    {
    case 11: 
    case 15: 
    case 16: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
    case 10: 
    case 8: 
      do
      {
        return 0;
        return 3;
        return 4;
        return 5;
        return 10;
        return 11;
        return 12;
        return 20;
        if (j == -5) {
          return 16;
        }
        if (j == -3) {
          return 4;
        }
        if (j == -4) {
          return 3;
        }
        if (j == -1) {
          return 12;
        }
        if (j == -2) {
          return 11;
        }
        if (j == -15) {
          return 21;
        }
        if (j == -6) {
          return 10;
        }
        if (j == -13) {
          return 19;
        }
        if (j == -7) {
          return 5;
        }
        if (j == -23) {
          break;
        }
      } while (j != -20);
      if (parama.Huv == 2) {
        return 26;
      }
      return 25;
    case 7: 
      if (parama.Huu) {
        return 8;
      }
      return 9;
    case 9: 
      return 19;
    case 13: 
      return 21;
    case 12: 
      return 22;
    case 14: 
      if (parama.Huv == 2) {
        return 26;
      }
      return 25;
    }
    return 31;
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, com.tencent.mm.plugin.fts.ui.d.a parama1)
  {
    AppMethodBeat.i(112018);
    int m = parama.Huq;
    String str2 = parama.Hus;
    long l2 = parama.Hut;
    int n = C(parama.Huv, parama.Huw, parama.fxL());
    int i;
    long l1;
    long l3;
    int j;
    label221:
    int k;
    switch (parama.viewType)
    {
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      AppMethodBeat.o(112018);
      return;
    case 1: 
      i = 3;
      if ((parama instanceof t))
      {
        localObject = (t)parama;
        boolean bool = ((t)localObject).contact.aGe();
        l1 = ((t)localObject).rpp.timestamp / 1000L;
        l3 = ((t)localObject).rpp.HtI;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(((t)localObject).username);
        j = 0;
        if (localObject != null)
        {
          j = ((bd)localObject).field_unReadCount;
          if (!bool) {
            break label794;
          }
          k = 1;
        }
      }
      break;
    }
    label229:
    for (Object localObject = String.format("%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Integer.valueOf(0), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(0) });; localObject = "0,0,0,0,0,0")
    {
      l1 = System.currentTimeMillis() - parama1.HBX;
      if ((l1 < 0L) || (parama1.HBX == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.syO), Integer.valueOf(i), Integer.valueOf(m), Util.nullAs(str2, ""), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(parama.coC()), Integer.valueOf(Wo(parama.fxK())), parama.coB(), Long.valueOf(l1), Integer.valueOf(parama1.HBY), localObject, "", "", "", "", "", "", "", "", "", Long.valueOf(e.HrM), Long.valueOf(parama1.HBZ) });
      Log.d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(11310, parama);
      AppMethodBeat.o(112018);
      return;
      i = 4;
      break;
      i = 5;
      break;
      i = 10;
      break;
      i = 11;
      break;
      i = 12;
      break;
      i = 20;
      break;
      com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
      String str1 = parama.FWt.Hte;
      localObject = str1;
      if (str1 != null) {
        localObject = str1.replaceAll(",", " ");
      }
      localn.s("20KeyWordId", (String)localObject + ",");
      localn.s("21ViewType", "2,");
      localn.s("22OpType", "2,");
      localn.s("23ResultCount", ",");
      localn.s("24ClickPos", parama.Hur + ",");
      localn.s("25ClickAppUserName", parama.hZn + ",");
      Log.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.aIF() });
      com.tencent.mm.plugin.report.service.h.OAn.b(13963, new Object[] { localn });
      i = 19;
      break;
      i = 21;
      break;
      i = 31;
      break;
      Log.w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
      break label221;
      k = 0;
      break label229;
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, b paramb)
  {
    AppMethodBeat.i(112016);
    int j = 1;
    int m = parama.Huq;
    int n = parama.Hur;
    String str = parama.Hus;
    long l2 = parama.Hut;
    Object localObject2 = parama.coB();
    int i1 = C(parama.Huv, parama.Huw, parama.fxL());
    int i;
    Object localObject1;
    long l1;
    int k;
    label206:
    Object localObject3;
    if (parama.xVf == -8)
    {
      i = 0;
      switch (parama.viewType)
      {
      default: 
        localObject1 = i + "$" + (String)localObject2;
        i = 2;
        l1 = System.currentTimeMillis() - paramb.HBX;
        if ((l1 < 0L) || (paramb.HBX == 0L)) {
          l1 = 0L;
        }
        if (!paramb.HCw.equals(parama.FWt.Hte))
        {
          k = 1;
          localObject2 = new qf();
          ((qf)localObject2).jqk = parama.syO;
          ((qf)localObject2).jql = i;
          ((qf)localObject2).jqm = m;
          ((qf)localObject2).jqn = j;
          ((qf)localObject2).jqo = n;
          localObject3 = ((qf)localObject2).xk(Util.nullAs(str, ""));
          ((qf)localObject3).jqp = l2;
          ((qf)localObject3).jqq = i1;
          ((qf)localObject3).jqr = 0L;
          ((qf)localObject3).jqs = parama.coC();
          ((qf)localObject3).jqt = Wo(parama.fxK());
          localObject1 = ((qf)localObject3).xl((String)localObject1);
          ((qf)localObject1).jip = l1;
          ((qf)localObject1).jqv = paramb.HCb;
          ((qf)localObject1).jqw = paramb.HCc;
          ((qf)localObject1).jqx = paramb.HCd;
          ((qf)localObject1).jqy = paramb.HCh;
          ((qf)localObject1).jqz = paramb.HCi;
          ((qf)localObject1).jqA = paramb.favCount;
          ((qf)localObject1).jqB = 0L;
          ((qf)localObject1).jqC = paramb.HCj;
          ((qf)localObject1).jqD = paramb.HCk;
          localObject1 = ((qf)localObject1).xm(String.valueOf(e.HrM)).xn(parama.FWt.Hte);
          ((qf)localObject1).jqF = 0L;
          ((qf)localObject1).jqG = 0L;
          ((qf)localObject1).jqH = paramb.fyX();
          localObject1 = ((qf)localObject1).xo("").xp("").xq("");
          ((qf)localObject1).jqJ = 1L;
          if (k == 0) {
            break label1615;
          }
          l1 = 1L;
          label493:
          ((qf)localObject1).jqK = l1;
          ((qf)localObject1).jqL = 0L;
          ((qf)localObject1).jqM = 0L;
          ((qf)localObject1).jqN = 0L;
          ((qf)localObject1).jqO = 0L;
          ((qf)localObject1).jqP = 0L;
          ((qf)localObject1).jqQ = 0L;
          ((qf)localObject1).jqR = 0L;
          localObject1 = ((qf)localObject1).xr("").xs("").xt("").xu("").xv("");
          ((qf)localObject1).jqW = 0L;
          localObject1 = ((qf)localObject1).xw("").xx("");
          ((qf)localObject1).jqZ = e.HrM;
          ((qf)localObject1).jra = e.HrN;
          localObject1 = ((qf)localObject1).xC(e.HrM).xD(e.HrN).xy("").xz(parama.getAppId()).xA(parama.egv());
          ((qf)localObject1).jre = paramb.HCf;
          ((qf)localObject1).jrf = 0L;
          if (!(parama instanceof t)) {
            break label1627;
          }
          localObject1 = (t)parama;
          if (!((t)localObject1).contact.aGe()) {
            break label1621;
          }
          l1 = 1L;
          label711:
          ((qf)localObject2).jqO = l1;
          ((qf)localObject2).jqL = (((t)localObject1).rpp.timestamp / 1000L);
          ((qf)localObject2).jqN = ((t)localObject1).rpp.HtI;
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(((t)localObject1).username);
          if (localObject1 != null) {
            ((qf)localObject2).jqP = ((bd)localObject1).field_unReadCount;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(parama.egv()))
      {
        ((qf)localObject2).xB(parama.egv());
        paramb.HCA = parama.egv();
      }
      if (!Util.isNullOrNil(parama.coA()))
      {
        ((qf)localObject2).xB(parama.coA());
        paramb.HCA = parama.coA();
      }
      ((qf)localObject2).xE(e.fxu());
      ((qf)localObject2).bMH();
      parama = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(112016);
      return;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
      i = 10;
      break;
      i = 19;
      break;
      i = 31;
      break;
      switch (parama.viewType)
      {
      case 11: 
      case 15: 
      case 16: 
      default: 
        AppMethodBeat.o(112016);
        return;
      case 1: 
        i = 3;
        localObject1 = localObject2;
        break;
      case 2: 
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        i = 5;
        localObject1 = localObject2;
        break;
      case 3: 
        i = 10;
        localObject1 = localObject2;
        break;
      case 5: 
        i = 11;
        localObject1 = localObject2;
        break;
      case 6: 
        i = 12;
        localObject1 = localObject2;
        break;
      case 10: 
        i = 20;
        localObject1 = localObject2;
        break;
      case 8: 
        if (parama.xVf == -5)
        {
          i = 16;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -3)
        {
          i = 4;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -4)
        {
          i = 3;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -1)
        {
          i = 12;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -2)
        {
          i = 11;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -15)
        {
          i = 21;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -6)
        {
          i = 10;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -13)
        {
          i = 19;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -7)
        {
          i = 5;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -23)
        {
          i = 31;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.xVf == -20)
        {
          if (parama.Huv == 2)
          {
            i = 26;
            j = 2;
            localObject1 = localObject2;
            break;
          }
          i = 25;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        AppMethodBeat.o(112016);
        return;
      case 7: 
        if (parama.Huu)
        {
          i = 8;
          localObject1 = localObject2;
          break;
        }
        i = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
        localObject3 = parama.FWt.Hte;
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ((String)localObject3).replaceAll(",", " ");
        }
        localn.s("20KeyWordId", (String)localObject1 + ",");
        localn.s("21ViewType", "1,");
        localn.s("22OpType", "2,");
        localn.s("23ResultCount", ",");
        localn.s("24ClickPos", parama.Hur + ",");
        localn.s("25ClickAppUserName", parama.hZn + ",");
        Log.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.aIF() });
        com.tencent.mm.plugin.report.service.h.OAn.b(13963, new Object[] { localn });
        i = 19;
        localObject1 = localObject2;
        break;
      case 13: 
        i = 21;
        localObject1 = localObject2;
        break;
      case 12: 
        i = 22;
        localObject1 = localObject2;
        break;
      case 14: 
        if (parama.Huv == 2)
        {
          i = 26;
          localObject1 = localObject2;
          break;
        }
        i = 25;
        localObject1 = localObject2;
        break;
      case 17: 
        i = 31;
        localObject1 = localObject2;
        break;
        k = 0;
        break label206;
        label1615:
        l1 = 0L;
        break label493;
        label1621:
        l1 = 0L;
        break label711;
        label1627:
        if ((parama instanceof u))
        {
          localObject1 = (u)parama;
          if (((u)localObject1).contact.aGe()) {}
          for (l1 = 1L;; l1 = 0L)
          {
            ((qf)localObject2).jqO = l1;
            ((qf)localObject2).jqL = (((u)localObject1).rpp.timestamp / 1000L);
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(((u)localObject1).username);
            if (localObject1 == null) {
              break;
            }
            ((qf)localObject2).jqP = ((bd)localObject1).field_unReadCount;
            break;
          }
        }
        if ((parama instanceof com.tencent.mm.plugin.brandservice.api.d))
        {
          ((qf)localObject2).xB(((com.tencent.mm.plugin.brandservice.api.d)parama).getUserName());
          paramb.HCA = ((com.tencent.mm.plugin.brandservice.api.d)parama).getUserName();
        }
        break;
      }
    }
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(112011);
    if (Util.isNullOrNil(paramb.query))
    {
      AppMethodBeat.o(112011);
      return;
    }
    int k = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWM, 0);
    long l2 = paramb.HBX - paramb.HxE;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    l2 = paramb.HBZ;
    long l3 = e.HrM;
    String str1 = paramb.query;
    String str2 = paramb.fza();
    int i;
    if (paramb.HCx)
    {
      i = 2;
      if (paramb.HCy <= 0) {
        break label342;
      }
    }
    label342:
    for (int j = 1;; j = 0)
    {
      paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), str1, str2, Integer.valueOf(i), Integer.valueOf(j), paramb.fyZ(), paramb.fzd(), Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramb.HCv), paramb.fzb(), paramb.fzc(), "", Integer.valueOf(0), paramb.HBZ, e.HrM, System.currentTimeMillis() });
      Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(17510), paramb });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(17510, paramb);
      AppMethodBeat.o(112011);
      return;
      i = 1;
      break;
    }
  }
  
  public static final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, b paramb, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112020);
    long l1 = System.currentTimeMillis() - paramb.HBX;
    if ((l1 < 0L) || (paramb.HBX == 0L)) {
      l1 = 0L;
    }
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    long l2;
    int i5;
    if (!paramb.HCw.equals(paramString1))
    {
      i = 1;
      j = paramb.HCb;
      k = paramb.HCc;
      m = paramb.HCd;
      n = paramb.HCh;
      i1 = paramb.HCi;
      i2 = paramb.favCount;
      i3 = paramb.HCj;
      i4 = paramb.HCk;
      l2 = e.HrM;
      i5 = paramb.fyX();
      if (i == 0) {
        break label545;
      }
    }
    label545:
    for (int i = 1;; i = 0)
    {
      paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l2), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i5), "", "", "", Integer.valueOf(1), Integer.valueOf(i), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(e.HrM), Long.valueOf(paramb.HBZ), paramString3, paramString4, "", Integer.valueOf(0) });
      Log.d("MicroMsg.FTS.FTSReportLogic", "10991 reportPardusResultClick click: %d, %s", new Object[] { Integer.valueOf(10991), paramString1 });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10991, paramString1);
      AppMethodBeat.o(112020);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(112014);
    switch (paramInt2)
    {
    case -14: 
    case -13: 
    case -12: 
    case -11: 
    case -10: 
    case -9: 
    case -8: 
    case -7: 
    case -6: 
    default: 
      paramInt2 = 0;
    }
    for (;;)
    {
      paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s,%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramb.HCa), Integer.valueOf(paramb.HCd), Integer.valueOf(paramb.HCk), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(e.HrM), Integer.valueOf(paramb.HCc), Integer.valueOf(paramb.HCh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(0), Long.valueOf(e.HrM), Long.valueOf(paramb.HBZ) });
      Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(11062), paramString });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(11062, paramString);
      AppMethodBeat.o(112014);
      return;
      paramInt2 = 2;
      continue;
      paramInt2 = 1;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, b paramb, int paramInt3)
  {
    AppMethodBeat.i(112017);
    long l = System.currentTimeMillis() - paramb.HBX;
    if ((l < 0L) || (paramb.HBX == 0L)) {
      l = 0L;
    }
    int i;
    qf localqf1;
    if (!paramb.HCw.equals(paramString))
    {
      i = 1;
      localqf1 = new qf();
      localqf1.jqk = paramInt2;
      if (!com.tencent.mm.plugin.fts.a.d.aEk(paramString)) {
        break label572;
      }
      localqf1.jql = 8L;
      label80:
      localqf1.jqm = (paramInt1 + 1);
      if ((paramb.HxE > 0L) && (paramb.HxE < System.currentTimeMillis())) {
        localqf1.jip = (System.currentTimeMillis() - paramb.HBX);
      }
      if (!paramb.HCw.equals(paramString)) {
        localqf1.jqK = 1L;
      }
      localqf1.jqk = paramInt2;
      localqf1.jql = paramInt3;
      localqf1.jqm = (paramInt1 + 1);
      localqf1.jqn = 0L;
      localqf1.jqo = 0L;
      localqf1.jip = l;
      localqf1.jqv = paramb.HCb;
      localqf1.jqw = paramb.HCc;
      localqf1.jqx = paramb.HCd;
      qf localqf2 = localqf1.xo("").xp("").xq("").xr("").xs("").xt("").xu("").xv("").xw("").xx("").xy("").xz("");
      localqf2.jqv = paramb.HCb;
      localqf2.jqy = paramb.HCh;
      localqf2.jqz = paramb.HCi;
      localqf2.jqA = paramb.favCount;
      localqf2.jqC = paramb.HCj;
      localqf2.jqD = paramb.HCk;
      paramString = localqf2.xm(String.valueOf(e.HrM)).xn(paramString);
      paramString.jqH = paramb.fyX();
      if (i == 0) {
        break label583;
      }
    }
    label572:
    label583:
    for (l = 1L;; l = 0L)
    {
      paramString.jqK = l;
      paramString.jqL = 0L;
      paramString.jqJ = 1L;
      paramString = paramString.xk(paramb.HBZ).xq(e.HrM);
      paramString.jqZ = e.HrM;
      paramString.jra = paramb.HBZ;
      paramString = paramString.xy(paramb.fyZ());
      paramString.jre = paramb.HCf;
      paramString.xB(paramb.HCA).xB(paramb.HCA).xD(paramb.HBZ).xC(e.HrM).xE(e.fxu()).ivT = cn.bDw();
      localqf1.bMH();
      Log.i("MicroMsg.FTS.FTSReportLogic", "%s", new Object[] { localqf1.aIF().replace("\r\n", " ") });
      AppMethodBeat.o(112017);
      return;
      i = 0;
      break;
      localqf1.jql = 9L;
      break label80;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(112013);
    if (paramBoolean) {
      paramInt1 = 3;
    }
    for (;;)
    {
      a(paramString, paramInt1, paramInt2, paramb);
      AppMethodBeat.o(112013);
      return;
      if (paramInt1 > 0) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public static void aC(int paramInt, long paramLong)
  {
    AppMethodBeat.i(112010);
    Log.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112010);
      return;
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(79);
      localIDKey1.SetKey(paramInt + 1);
      localIDKey1.SetValue((int)paramLong);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(79);
      localIDKey2.SetKey(paramInt + 2);
      localIDKey2.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, false);
    }
  }
  
  public static String aEL(String paramString)
  {
    AppMethodBeat.i(112022);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112022);
      return "";
    }
    paramString = paramString.replaceAll("<em class=\"highlight\">", "").replaceAll("</em>", "");
    AppMethodBeat.o(112022);
    return paramString;
  }
  
  public static void ak(long paramLong, int paramInt)
  {
    AppMethodBeat.i(112023);
    Log.d("MicroMsg.FTS.FTSReportLogic", "reportWebSearchPardusStatus 18201 %s %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    f.Ozc.b(18201, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Long.valueOf(cn.bDw()) });
    AppMethodBeat.o(112023);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(112015);
    String str = paramb.query;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(112015);
      return;
    }
    paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", new Object[] { str, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(paramb.HCa), Integer.valueOf(paramb.HCd), Integer.valueOf(paramb.HCk), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(e.HrM), Integer.valueOf(paramb.HCc), Integer.valueOf(paramb.HCh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(0), Long.valueOf(e.HrM) });
    Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(16050), paramb });
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(16050, paramb);
    AppMethodBeat.o(112015);
  }
  
  public static void bY(int paramInt, String paramString)
  {
    AppMethodBeat.i(265709);
    com.tencent.threadpool.h.ahAA.p(new l.1(paramInt, paramString), 100L);
    AppMethodBeat.o(265709);
  }
  
  public static void c(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112012);
    a(paramString, paramBoolean, paramInt1, paramInt2, new b());
    AppMethodBeat.o(112012);
  }
  
  public static final void vP(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(112019);
    com.tencent.mm.plugin.report.service.h localh;
    if (paramBoolean)
    {
      i = 1;
      Log.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", new Object[] { Integer.valueOf(13970), Integer.valueOf(i) });
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i = j;; i = 0)
    {
      localh.b(13970, new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(112019);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l
 * JD-Core Version:    0.7.0.1
 */