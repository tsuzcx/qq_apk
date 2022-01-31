package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import java.util.ArrayList;

public final class k
{
  public static void R(int paramInt, long paramLong)
  {
    AppMethodBeat.i(61935);
    ab.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(61935);
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
      h.qsU.b(localArrayList, false);
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, com.tencent.mm.plugin.fts.ui.c.a parama1)
  {
    AppMethodBeat.i(61941);
    int m = parama.mTI;
    String str2 = parama.mTK;
    long l2 = parama.mTL;
    int n = l(parama.mTN, parama.mTO, parama.bCi());
    int i;
    long l1;
    long l3;
    int j;
    label233:
    int k;
    switch (parama.kwo)
    {
    case 10: 
    case 11: 
    case 12: 
    case 15: 
    case 18: 
    case 19: 
    default: 
      AppMethodBeat.o(61941);
      return;
    case 1: 
      i = 3;
      if ((parama instanceof q))
      {
        localObject = (q)parama;
        boolean bool = ((q)localObject).contact.DP();
        l1 = ((q)localObject).hrL.timestamp / 1000L;
        l3 = ((q)localObject).hrL.mSZ;
        localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arH(((q)localObject).username);
        j = 0;
        if (localObject != null)
        {
          j = ((au)localObject).field_unReadCount;
          if (!bool) {
            break label836;
          }
          k = 1;
        }
      }
      break;
    }
    label241:
    for (Object localObject = String.format("%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Integer.valueOf(0), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(0) });; localObject = "0,0,0,0,0,0")
    {
      l1 = System.currentTimeMillis() - parama1.nae;
      if ((l1 < 0L) || (parama1.nae == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.ibk), Integer.valueOf(i), Integer.valueOf(m), bo.bf(str2, ""), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(parama.aAp()), Integer.valueOf(wz(parama.bCh())), parama.aAo(), Long.valueOf(l1), Integer.valueOf(parama1.naf), localObject, "", "", "", "", "", "", "", "", "", Long.valueOf(e.mRk), Long.valueOf(parama1.nag) });
      ab.d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", new Object[] { parama });
      h.qsU.kvStat(11310, parama);
      AppMethodBeat.o(61941);
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
      i = 13;
      break;
      i = 14;
      break;
      i = 16;
      break;
      i = 15;
      break;
      i = 17;
      break;
      i = 20;
      break;
      d locald = new d();
      String str1 = parama.mRX.mSw;
      localObject = str1;
      if (str1 != null) {
        localObject = str1.replaceAll(",", " ");
      }
      locald.k("20KeyWordId", (String)localObject + ",");
      locald.k("21ViewType", "2,");
      locald.k("22OpType", "2,");
      locald.k("23ResultCount", ",");
      locald.k("24ClickPos", parama.mTJ + ",");
      locald.k("25ClickAppUserName", parama.info + ",");
      ab.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.Fg() });
      h.qsU.e(13963, new Object[] { locald });
      i = 19;
      break;
      i = 21;
      break;
      ab.w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
      break label233;
      k = 0;
      break label241;
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, b paramb)
  {
    AppMethodBeat.i(61939);
    int j = 1;
    int n = parama.mTI;
    int i1 = parama.mTJ;
    String str2 = parama.mTK;
    long l2 = parama.mTL;
    Object localObject2 = parama.aAo();
    int i2 = l(parama.mTN, parama.mTO, parama.bCi());
    int i;
    Object localObject1;
    long l1;
    long l3;
    label216:
    int m;
    label224:
    String str1;
    label282:
    label331:
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
    int i14;
    int i15;
    int i16;
    if (parama.lox == -8)
    {
      i = 0;
      switch (parama.kwo)
      {
      default: 
        localObject1 = i + "$" + (String)localObject2;
        i = 2;
        if ((parama instanceof q))
        {
          localObject2 = (q)parama;
          boolean bool = ((q)localObject2).contact.DP();
          l1 = ((q)localObject2).hrL.timestamp / 1000L;
          l3 = ((q)localObject2).hrL.mSZ;
          localObject2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arH(((q)localObject2).username);
          k = 0;
          if (localObject2 != null)
          {
            k = ((au)localObject2).field_unReadCount;
            if (!bool) {
              break label1561;
            }
            m = 1;
            localObject2 = String.format("%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Integer.valueOf(0), Long.valueOf(l3), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(0) });
            l1 = System.currentTimeMillis() - paramb.nae;
            if ((l1 < 0L) || (paramb.nae == 0L)) {
              l1 = 0L;
            }
            if (paramb.nax.equals(parama.mRX.mSw)) {
              break label1575;
            }
            k = 1;
            m = parama.ibk;
            str1 = bo.bf(str2, "");
            i3 = parama.aAp();
            i4 = wz(parama.bCh());
            i5 = paramb.nai;
            i6 = paramb.naj;
            i7 = paramb.nak;
            i8 = paramb.nal;
            i9 = paramb.nam;
            i10 = paramb.nan;
            i11 = paramb.nao;
            i12 = paramb.naq;
            i13 = paramb.nar;
            l3 = e.mRk;
            parama = parama.mRX.mSw;
            i14 = paramb.nap;
            i15 = paramb.nat;
            i16 = paramb.bCX();
            if (k == 0) {
              break label1581;
            }
          }
        }
        break;
      }
    }
    label1561:
    label1575:
    label1581:
    for (int k = 1;; k = 0)
    {
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), str1, Long.valueOf(l2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), localObject1, Long.valueOf(l1), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Long.valueOf(l3), parama, Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), "", "", "", Integer.valueOf(1), Integer.valueOf(k), localObject2, "", "", "", "", "", "", "", "", "", Long.valueOf(e.mRk), Long.valueOf(e.mRl) });
      ab.d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", new Object[] { Integer.valueOf(10991), parama });
      h.qsU.kvStat(10991, parama);
      AppMethodBeat.o(61939);
      return;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
      i = 10;
      break;
      switch (parama.kwo)
      {
      case 11: 
      case 15: 
      case 18: 
      default: 
        AppMethodBeat.o(61939);
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
      case 6: 
        i = 11;
        localObject1 = localObject2;
        break;
      case 14: 
        i = 15;
        localObject1 = localObject2;
        break;
      case 5: 
        i = 16;
        localObject1 = localObject2;
        break;
      case 13: 
        i = 17;
        localObject1 = localObject2;
        break;
      case 7: 
        i = 12;
        localObject1 = localObject2;
        break;
      case 8: 
        i = 13;
        localObject1 = localObject2;
        break;
      case 9: 
        i = 14;
        localObject1 = localObject2;
        break;
      case 17: 
        i = 20;
        localObject1 = localObject2;
        break;
      case 12: 
        if (parama.lox == -5)
        {
          i = 16;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -3)
        {
          i = 4;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -4)
        {
          i = 3;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -1)
        {
          i = 12;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -2)
        {
          i = 11;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -15)
        {
          i = 21;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -6)
        {
          i = 10;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -13)
        {
          i = 19;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        if (parama.lox == -7)
        {
          i = 5;
          j = 2;
          localObject1 = localObject2;
          break;
        }
        AppMethodBeat.o(61939);
        return;
      case 10: 
        if (parama.mTM)
        {
          i = 8;
          localObject1 = localObject2;
          break;
        }
        i = 9;
        localObject1 = localObject2;
        break;
      case 16: 
        d locald = new d();
        str1 = parama.mRX.mSw;
        localObject1 = str1;
        if (str1 != null) {
          localObject1 = str1.replaceAll(",", " ");
        }
        locald.k("20KeyWordId", (String)localObject1 + ",");
        locald.k("21ViewType", "1,");
        locald.k("22OpType", "2,");
        locald.k("23ResultCount", ",");
        locald.k("24ClickPos", parama.mTJ + ",");
        locald.k("25ClickAppUserName", parama.info + ",");
        ab.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.Fg() });
        h.qsU.e(13963, new Object[] { locald });
        i = 19;
        localObject1 = localObject2;
        break;
      case 20: 
        i = 21;
        localObject1 = localObject2;
        break;
      case 19: 
        i = 22;
        localObject1 = localObject2;
        break;
      case 21: 
        i = 25;
        localObject1 = localObject2;
        break;
        ab.w("MicroMsg.FTS.FTSReportLogic", "10991 conv null");
        break label216;
        m = 0;
        break label224;
        localObject2 = "0,0,0,0,0,0";
        break label282;
        k = 0;
        break label331;
      }
    }
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(152152);
    if (bo.isNullOrNil(paramb.query))
    {
      AppMethodBeat.o(152152);
      return;
    }
    int k = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWg, 0);
    long l2 = paramb.nae - paramb.mWI;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    l2 = paramb.nag;
    long l3 = e.mRk;
    String str1 = paramb.query;
    String str2 = paramb.bCZ();
    int i;
    if (paramb.nay)
    {
      i = 2;
      if (paramb.naz <= 0) {
        break label251;
      }
    }
    label251:
    for (int j = 1;; j = 0)
    {
      paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), str1, str2, Integer.valueOf(i), Integer.valueOf(j), paramb.bCY(), paramb.bDa(), Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramb.nau) });
      ab.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(17510), paramb });
      h.qsU.kvStat(17510, paramb);
      AppMethodBeat.o(152152);
      return;
      i = 1;
      break;
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(152153);
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
      paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s,%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramb.nah), Integer.valueOf(paramb.nak), Integer.valueOf(paramb.nar), Integer.valueOf(paramb.nao), Integer.valueOf(paramb.nap), Long.valueOf(e.mRk), Integer.valueOf(paramb.naj), Integer.valueOf(paramb.nal), Integer.valueOf(paramb.nav), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.naw), Long.valueOf(e.mRk), Long.valueOf(paramb.nag) });
      ab.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(11062), paramString });
      h.qsU.kvStat(11062, paramString);
      AppMethodBeat.o(152153);
      return;
      paramInt2 = 2;
      continue;
      paramInt2 = 1;
    }
  }
  
  static void a(String paramString, int paramInt1, int paramInt2, b paramb, int paramInt3)
  {
    AppMethodBeat.i(61940);
    long l1 = System.currentTimeMillis() - paramb.nae;
    if ((l1 < 0L) || (paramb.nae == 0L)) {
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
    int i5;
    long l2;
    int i6;
    int i7;
    int i8;
    if (!paramb.nax.equals(paramString))
    {
      i = 1;
      j = paramb.nai;
      k = paramb.naj;
      m = paramb.nak;
      n = paramb.nal;
      i1 = paramb.nam;
      i2 = paramb.nan;
      i3 = paramb.nao;
      i4 = paramb.naq;
      i5 = paramb.nar;
      l2 = e.mRk;
      i6 = paramb.nap;
      i7 = paramb.nat;
      i8 = paramb.bCX();
      if (i == 0) {
        break label529;
      }
    }
    label529:
    for (int i = 1;; i = 0)
    {
      paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1 + 1), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(l2), paramString, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), "", "", "", Integer.valueOf(1), Integer.valueOf(i), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(e.mRk), Long.valueOf(paramb.nag) });
      ab.d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", new Object[] { Integer.valueOf(10991), paramString });
      h.qsU.kvStat(10991, paramString);
      AppMethodBeat.o(61940);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(61937);
    if (paramBoolean) {
      paramInt1 = 3;
    }
    for (;;)
    {
      a(paramString, paramInt1, paramInt2, paramb);
      AppMethodBeat.o(61937);
      return;
      if (paramInt1 > 0) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public static final int b(com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    int j = 3;
    int k = parama.lox;
    if (k == -8)
    {
      i = 2;
      return i;
    }
    int i = j;
    switch (parama.kwo)
    {
    case 1: 
    case 11: 
    case 15: 
    case 18: 
    default: 
    case 2: 
    case 4: 
    case 3: 
    case 6: 
    case 14: 
    case 5: 
    case 13: 
    case 7: 
    case 8: 
    case 9: 
    case 17: 
    case 12: 
      do
      {
        return 0;
        return 4;
        return 5;
        return 10;
        return 11;
        return 15;
        return 16;
        return 17;
        return 12;
        return 13;
        return 14;
        return 20;
        if (k == -5) {
          return 16;
        }
        if (k == -3) {
          return 4;
        }
        i = j;
        if (k == -4) {
          break;
        }
        if (k == -1) {
          return 12;
        }
        if (k == -2) {
          return 11;
        }
        if (k == -15) {
          return 21;
        }
        if (k == -6) {
          return 10;
        }
        if (k == -13) {
          return 19;
        }
      } while (k != -7);
      return 5;
    case 10: 
      if (parama.mTM) {
        return 8;
      }
      return 9;
    case 16: 
      return 19;
    case 20: 
      return 21;
    case 19: 
      return 22;
    }
    return 25;
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(61938);
    String str = paramb.query;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(61938);
      return;
    }
    paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", new Object[] { str, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(paramb.nah), Integer.valueOf(paramb.nak), Integer.valueOf(paramb.nar), Integer.valueOf(paramb.nao), Integer.valueOf(paramb.nap), Long.valueOf(e.mRk), Integer.valueOf(paramb.naj), Integer.valueOf(paramb.nal), Integer.valueOf(paramb.nav), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.naw), Long.valueOf(e.mRk) });
    ab.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(16050), paramb });
    h.qsU.kvStat(16050, paramb);
    AppMethodBeat.o(61938);
  }
  
  public static void c(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61936);
    a(paramString, paramBoolean, paramInt1, paramInt2, new b());
    AppMethodBeat.o(61936);
  }
  
  public static final void hR(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(61942);
    h localh;
    if (paramBoolean)
    {
      i = 1;
      ab.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", new Object[] { Integer.valueOf(13970), Integer.valueOf(i) });
      localh = h.qsU;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i = j;; i = 0)
    {
      localh.e(13970, new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(61942);
      return;
      i = 0;
      break;
    }
  }
  
  private static int l(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private static int wz(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k
 * JD-Core Version:    0.7.0.1
 */