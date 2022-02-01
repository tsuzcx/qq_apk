package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.util.c;
import java.util.ArrayList;

public final class k
{
  private static int DL(int paramInt)
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
  
  public static void H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(112023);
    ad.d("MicroMsg.FTS.FTSReportLogic", "reportWebSearchPardusStatus 18201 %s %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.vIY.f(18201, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(112023);
  }
  
  public static final int a(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    int i = 3;
    int j = parama.oEL;
    if (j == -8)
    {
      if (parama.oEL == -8) {}
      switch (parama.nBH)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
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
      }
    }
    switch (parama.nBH)
    {
    case 11: 
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
      } while (j != -20);
      if (parama.rqF == 2) {
        return 26;
      }
      return 25;
    case 7: 
      if (parama.rqE) {
        return 8;
      }
      return 9;
    case 9: 
      return 19;
    case 13: 
      return 21;
    case 12: 
      return 22;
    }
    if (parama.rqF == 2) {
      return 26;
    }
    return 25;
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, com.tencent.mm.plugin.fts.ui.c.a parama1)
  {
    AppMethodBeat.i(112018);
    int m = parama.rqA;
    String str2 = parama.rqC;
    long l2 = parama.rqD;
    int n = s(parama.rqF, parama.rqG, parama.cxw());
    int i;
    long l1;
    long l3;
    int j;
    label205:
    int k;
    switch (parama.nBH)
    {
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    default: 
      AppMethodBeat.o(112018);
      return;
    case 1: 
      i = 3;
      if ((parama instanceof q))
      {
        localObject = (q)parama;
        boolean bool = ((q)localObject).contact.Ny();
        l1 = ((q)localObject).jpy.timestamp / 1000L;
        l3 = ((q)localObject).jpy.rpT;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(((q)localObject).username);
        j = 0;
        if (localObject != null)
        {
          j = ((ay)localObject).field_unReadCount;
          if (!bool) {
            break label774;
          }
          k = 1;
        }
      }
      break;
    }
    label213:
    for (Object localObject = String.format("%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Integer.valueOf(0), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(0) });; localObject = "0,0,0,0,0,0")
    {
      l1 = System.currentTimeMillis() - parama1.rwE;
      if ((l1 < 0L) || (parama1.rwE == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.kme), Integer.valueOf(i), Integer.valueOf(m), bt.by(str2, ""), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(parama.aWu()), Integer.valueOf(DL(parama.cxv())), parama.aWt(), Long.valueOf(l1), Integer.valueOf(parama1.rwF), localObject, "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Long.valueOf(parama1.rwG) });
      ad.d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(11310, parama);
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
      f localf = new f();
      String str1 = parama.roS.rpq;
      localObject = str1;
      if (str1 != null) {
        localObject = str1.replaceAll(",", " ");
      }
      localf.o("20KeyWordId", (String)localObject + ",");
      localf.o("21ViewType", "2,");
      localf.o("22OpType", "2,");
      localf.o("23ResultCount", ",");
      localf.o("24ClickPos", parama.rqB + ",");
      localf.o("25ClickAppUserName", parama.info + ",");
      ad.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localf.PW() });
      com.tencent.mm.plugin.report.service.h.vKh.f(13963, new Object[] { localf });
      i = 19;
      break;
      i = 21;
      break;
      ad.w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
      break label205;
      k = 0;
      break label213;
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, com.tencent.mm.plugin.fts.ui.c.b paramb)
  {
    AppMethodBeat.i(112016);
    int j = 1;
    int n = parama.rqA;
    int i1 = parama.rqB;
    String str2 = parama.rqC;
    long l2 = parama.rqD;
    Object localObject2 = parama.aWt();
    int i2 = s(parama.rqF, parama.rqG, parama.cxw());
    int i;
    Object localObject1;
    long l1;
    long l3;
    label243:
    int m;
    label251:
    String str1;
    label309:
    label358:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    if (parama.oEL == -8)
    {
      k = 0;
      i = k;
      switch (parama.nBH)
      {
      default: 
        i = k;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        localObject1 = i + "$" + (String)localObject2;
        i = 2;
        if ((parama instanceof q))
        {
          localObject2 = (q)parama;
          boolean bool = ((q)localObject2).contact.Ny();
          l1 = ((q)localObject2).jpy.timestamp / 1000L;
          l3 = ((q)localObject2).jpy.rpT;
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(((q)localObject2).username);
          k = 0;
          if (localObject2 != null)
          {
            k = ((ay)localObject2).field_unReadCount;
            if (!bool) {
              break label1567;
            }
            m = 1;
            localObject2 = String.format("%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Integer.valueOf(0), Long.valueOf(l3), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(0) });
            l1 = System.currentTimeMillis() - paramb.rwE;
            if ((l1 < 0L) || (paramb.rwE == 0L)) {
              l1 = 0L;
            }
            if (paramb.rwZ.equals(parama.roS.rpq)) {
              break label1581;
            }
            k = 1;
            m = parama.kme;
            str1 = bt.by(str2, "");
            i3 = parama.aWu();
            i4 = DL(parama.cxv());
            i5 = paramb.rwI;
            i6 = paramb.rwJ;
            i7 = paramb.rwK;
            i8 = paramb.rwL;
            i9 = paramb.rwM;
            i10 = paramb.favCount;
            i11 = paramb.rwN;
            i12 = paramb.rwO;
            l3 = com.tencent.mm.plugin.fts.a.e.rob;
            str2 = parama.roS.rpq;
            i13 = paramb.cyf();
            if (k == 0) {
              break label1587;
            }
          }
        }
        break;
      }
    }
    label1567:
    label1581:
    label1587:
    for (int k = 1;; k = 0)
    {
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), str1, Long.valueOf(l2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), localObject1, Long.valueOf(l1), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(0), Integer.valueOf(i11), Integer.valueOf(i12), Long.valueOf(l3), str2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i13), "", "", "", Integer.valueOf(1), Integer.valueOf(k), localObject2, "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Long.valueOf(com.tencent.mm.plugin.fts.a.e.roc), "", parama.getAppId() });
      ad.d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", new Object[] { Integer.valueOf(10991), parama });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10991, parama);
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
      switch (parama.nBH)
      {
      case 11: 
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
        if (parama.oEL == -5)
        {
          i = 16;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -3)
        {
          i = 4;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -4)
        {
          i = 3;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -1)
        {
          i = 12;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -2)
        {
          i = 11;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -15)
        {
          i = 21;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -6)
        {
          i = 10;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -13)
        {
          i = 19;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -7)
        {
          i = 5;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.oEL == -20)
        {
          if (parama.rqF == 2)
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
        if (parama.rqE)
        {
          i = 8;
          localObject1 = localObject2;
          break;
        }
        i = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        f localf = new f();
        str1 = parama.roS.rpq;
        localObject1 = str1;
        if (str1 != null) {
          localObject1 = str1.replaceAll(",", " ");
        }
        localf.o("20KeyWordId", (String)localObject1 + ",");
        localf.o("21ViewType", "1,");
        localf.o("22OpType", "2,");
        localf.o("23ResultCount", ",");
        localf.o("24ClickPos", parama.rqB + ",");
        localf.o("25ClickAppUserName", parama.info + ",");
        ad.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localf.PW() });
        com.tencent.mm.plugin.report.service.h.vKh.f(13963, new Object[] { localf });
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
        if (parama.rqF == 2)
        {
          i = 26;
          localObject1 = localObject2;
          break;
        }
        i = 25;
        localObject1 = localObject2;
        break;
        ad.w("MicroMsg.FTS.FTSReportLogic", "10991 conv null");
        break label243;
        m = 0;
        break label251;
        localObject2 = "0,0,0,0,0,0";
        break label309;
        k = 0;
        break label358;
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.ui.c.b paramb)
  {
    AppMethodBeat.i(112011);
    if (bt.isNullOrNil(paramb.query))
    {
      AppMethodBeat.o(112011);
      return;
    }
    int k = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prb, c.fgV());
    long l2 = paramb.rwE - paramb.rty;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    l2 = paramb.rwG;
    long l3 = com.tencent.mm.plugin.fts.a.e.rob;
    String str1 = paramb.query;
    String str2 = paramb.cyi();
    int i;
    if (paramb.rxa)
    {
      i = 2;
      if (paramb.rxb <= 0) {
        break label269;
      }
    }
    label269:
    for (int j = 1;; j = 0)
    {
      paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), str1, str2, Integer.valueOf(i), Integer.valueOf(j), paramb.cyh(), paramb.cyl(), Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramb.rwY), paramb.cyj(), paramb.cyk() });
      ad.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(17510), paramb });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(17510, paramb);
      AppMethodBeat.o(112011);
      return;
      i = 1;
      break;
    }
  }
  
  public static final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.fts.ui.c.b paramb, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112020);
    long l1 = System.currentTimeMillis() - paramb.rwE;
    if ((l1 < 0L) || (paramb.rwE == 0L)) {
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
    if (!paramb.rwZ.equals(paramString1))
    {
      i = 1;
      j = paramb.rwI;
      k = paramb.rwJ;
      m = paramb.rwK;
      n = paramb.rwL;
      i1 = paramb.rwM;
      i2 = paramb.favCount;
      i3 = paramb.rwN;
      i4 = paramb.rwO;
      l2 = com.tencent.mm.plugin.fts.a.e.rob;
      i5 = paramb.cyf();
      if (i == 0) {
        break label531;
      }
    }
    label531:
    for (int i = 1;; i = 0)
    {
      paramString1 = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString2, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l2), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i5), "", "", "", Integer.valueOf(1), Integer.valueOf(i), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Long.valueOf(paramb.rwG), paramString3, paramString4 });
      ad.d("MicroMsg.FTS.FTSReportLogic", "10991 reportPardusResultClick click: %d, %s", new Object[] { Integer.valueOf(10991), paramString1 });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10991, paramString1);
      AppMethodBeat.o(112020);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.ui.c.b paramb)
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
      paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s,%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramb.rwH), Integer.valueOf(paramb.rwK), Integer.valueOf(paramb.rwO), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Integer.valueOf(paramb.rwJ), Integer.valueOf(paramb.rwL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Long.valueOf(paramb.rwG) });
      ad.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(11062), paramString });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(11062, paramString);
      AppMethodBeat.o(112014);
      return;
      paramInt2 = 2;
      continue;
      paramInt2 = 1;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.ui.c.b paramb, int paramInt3)
  {
    AppMethodBeat.i(112017);
    long l1 = System.currentTimeMillis() - paramb.rwE;
    if ((l1 < 0L) || (paramb.rwE == 0L)) {
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
    if (!paramb.rwZ.equals(paramString))
    {
      i = 1;
      j = paramb.rwI;
      k = paramb.rwJ;
      m = paramb.rwK;
      n = paramb.rwL;
      i1 = paramb.rwM;
      i2 = paramb.favCount;
      i3 = paramb.rwN;
      i4 = paramb.rwO;
      l2 = com.tencent.mm.plugin.fts.a.e.rob;
      i5 = paramb.cyf();
      if (i == 0) {
        break label520;
      }
    }
    label520:
    for (int i = 1;; i = 0)
    {
      paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1 + 1), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l2), paramString, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i5), "", "", "", Integer.valueOf(1), Integer.valueOf(i), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Long.valueOf(paramb.rwG), "", "" });
      ad.d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", new Object[] { Integer.valueOf(10991), paramString });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10991, paramString);
      AppMethodBeat.o(112017);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.ui.c.b paramb)
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
  
  public static String aby(String paramString)
  {
    AppMethodBeat.i(112022);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112022);
      return "";
    }
    paramString = paramString.replaceAll("<em class=\"highlight\">", "").replaceAll("</em>", "");
    AppMethodBeat.o(112022);
    return paramString;
  }
  
  public static void af(int paramInt, long paramLong)
  {
    AppMethodBeat.i(112010);
    ad.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
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
      com.tencent.mm.plugin.report.service.h.vKh.b(localArrayList, false);
    }
  }
  
  public static void b(com.tencent.mm.plugin.fts.ui.c.b paramb)
  {
    AppMethodBeat.i(112015);
    String str = paramb.query;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(112015);
      return;
    }
    paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", new Object[] { str, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(paramb.rwH), Integer.valueOf(paramb.rwK), Integer.valueOf(paramb.rwO), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob), Integer.valueOf(paramb.rwJ), Integer.valueOf(paramb.rwL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.rob) });
    ad.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(16050), paramb });
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(16050, paramb);
    AppMethodBeat.o(112015);
  }
  
  public static void c(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112012);
    a(paramString, paramBoolean, paramInt1, paramInt2, new com.tencent.mm.plugin.fts.ui.c.b());
    AppMethodBeat.o(112012);
  }
  
  public static final void lB(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(112019);
    com.tencent.mm.plugin.report.service.h localh;
    if (paramBoolean)
    {
      i = 1;
      ad.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", new Object[] { Integer.valueOf(13970), Integer.valueOf(i) });
      localh = com.tencent.mm.plugin.report.service.h.vKh;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i = j;; i = 0)
    {
      localh.f(13970, new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(112019);
      return;
      i = 0;
      break;
    }
  }
  
  private static int s(int paramInt1, int paramInt2, boolean paramBoolean)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */