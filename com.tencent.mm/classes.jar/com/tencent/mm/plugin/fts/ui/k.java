package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class k
{
  public static void A(int paramInt, long paramLong)
  {
    y.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    default: 
      return;
    }
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
    h.nFQ.b(localArrayList, false);
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, com.tencent.mm.plugin.fts.ui.c.a parama1)
  {
    int j = parama.kxV;
    String str3 = parama.kxX;
    long l2 = parama.kxY;
    int k = i(parama.kya, parama.kyb, parama.aVG());
    int i;
    switch (parama.ivk)
    {
    case 10: 
    case 11: 
    case 12: 
    case 15: 
    case 18: 
    case 19: 
    default: 
      return;
    case 1: 
      i = 3;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - parama1.kDV;
      if ((l1 < 0L) || (parama1.kDV == 0L)) {
        l1 = 0L;
      }
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.kxJ), Integer.valueOf(i), Integer.valueOf(j), bk.aM(str3, ""), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(parama.afM()), Integer.valueOf(rE(parama.aVF())), parama.afL(), Long.valueOf(l1), Integer.valueOf(parama1.kDW) });
      y.d("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", new Object[] { parama });
      h.nFQ.aC(11310, parama);
      return;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
      continue;
      i = 14;
      continue;
      i = 16;
      continue;
      i = 15;
      continue;
      i = 17;
      continue;
      i = 20;
      continue;
      d locald = new d();
      String str2 = parama.kwi.kwG;
      String str1 = str2;
      if (str2 != null) {
        str1 = str2.replaceAll(",", " ");
      }
      locald.j("20KeyWordId", str1 + ",");
      locald.j("21ViewType", "2,");
      locald.j("22OpType", "2,");
      locald.j("23ResultCount", ",");
      locald.j("24ClickPos", parama.kxW + ",");
      locald.j("25ClickAppUserName", parama.info + ",");
      y.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.uJ() });
      h.nFQ.f(13963, new Object[] { locald });
      i = 19;
      continue;
      i = 21;
    }
  }
  
  public static void a(com.tencent.mm.plugin.fts.a.d.a.a parama, b paramb)
  {
    int j = 1;
    int m = parama.kxV;
    int n = parama.kxW;
    String str3 = parama.kxX;
    long l2 = parama.kxY;
    String str1 = parama.afL();
    int i1 = i(parama.kya, parama.kyb, parama.aVG());
    int i;
    if (parama.kxU == -8)
    {
      int k = 2;
      i = 0;
      switch (parama.ivk)
      {
      default: 
        str1 = i + "$" + str1;
        i = k;
      }
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - paramb.kDV;
      if ((l1 < 0L) || (paramb.kDV == 0L)) {
        l1 = 0L;
      }
      Object localObject = paramb.El(parama.kwi.kwG);
      parama = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parama.kxJ), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), bk.aM(str3, ""), Long.valueOf(l2), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(parama.afM()), Integer.valueOf(rE(parama.aVF())), str1, Long.valueOf(l1), Integer.valueOf(paramb.kDY), Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEc), Integer.valueOf(paramb.kEd), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEg), Integer.valueOf(paramb.kEh), e.kvx, parama.kwi.kwG, Integer.valueOf(paramb.kEf), Integer.valueOf(paramb.kEi), Integer.valueOf(paramb.aWt()), "", localObject });
      y.d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", new Object[] { Integer.valueOf(10991), parama });
      h.nFQ.aC(10991, parama);
      do
      {
        return;
        i = 3;
        break;
        i = 4;
        break;
        i = 5;
        break;
        i = 10;
        break;
        switch (parama.ivk)
        {
        case 11: 
        case 15: 
        case 18: 
        default: 
          return;
        case 1: 
          i = 3;
          break;
        case 2: 
          i = 4;
          break;
        case 4: 
          i = 5;
          break;
        case 3: 
          i = 10;
          break;
        case 6: 
          i = 11;
          break;
        case 14: 
          i = 15;
          break;
        case 5: 
          i = 16;
          break;
        case 13: 
          i = 17;
          break;
        case 7: 
          i = 12;
          break;
        case 8: 
          i = 13;
          break;
        case 9: 
          i = 14;
          break;
        case 17: 
          i = 20;
          break;
        case 12: 
          j = 2;
          if (parama.kxU == -5)
          {
            i = 16;
            break;
          }
          if (parama.kxU == -3)
          {
            i = 4;
            break;
          }
          if (parama.kxU == -4)
          {
            i = 3;
            break;
          }
          if (parama.kxU == -1)
          {
            i = 12;
            break;
          }
          if (parama.kxU == -2)
          {
            i = 11;
            break;
          }
          if (parama.kxU == -15)
          {
            i = 21;
            break;
          }
          if (parama.kxU == -6)
          {
            i = 10;
            break;
          }
          if (parama.kxU == -13)
          {
            i = 19;
            break;
          }
          break;
        }
      } while (parama.kxU != -7);
      i = 5;
      continue;
      if (parama.kxZ)
      {
        i = 8;
      }
      else
      {
        i = 9;
        continue;
        i = 19;
        d locald = new d();
        String str2 = parama.kwi.kwG;
        localObject = str2;
        if (str2 != null) {
          localObject = str2.replaceAll(",", " ");
        }
        locald.j("20KeyWordId", (String)localObject + ",");
        locald.j("21ViewType", "1,");
        locald.j("22OpType", "2,");
        locald.j("23ResultCount", ",");
        locald.j("24ClickPos", parama.kxW + ",");
        locald.j("25ClickAppUserName", parama.info + ",");
        y.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[] { locald.uJ() });
        h.nFQ.f(13963, new Object[] { locald });
        continue;
        i = 21;
        continue;
        i = 22;
      }
    }
  }
  
  public static void a(b paramb)
  {
    String str = paramb.bVk;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[] { str, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(paramb.kDX), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEh), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEf), e.kvx, Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEk), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.kEl) });
    y.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(16050), paramb });
    h.nFQ.aC(16050, paramb);
  }
  
  static void a(String paramString, int paramInt1, int paramInt2, b paramb, int paramInt3)
  {
    long l = System.currentTimeMillis() - paramb.kDV;
    if ((l < 0L) || (paramb.kDV == 0L)) {
      l = 0L;
    }
    String str = paramb.El(paramString);
    paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1 + 1), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(l), Integer.valueOf(paramb.kDY), Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEc), Integer.valueOf(paramb.kEd), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEg), Integer.valueOf(paramb.kEh), e.kvx, paramString, Integer.valueOf(paramb.kEf), Integer.valueOf(paramb.kEi), Integer.valueOf(paramb.aWt()), "", str });
    y.d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", new Object[] { Integer.valueOf(10991), paramString });
    h.nFQ.aC(10991, paramString);
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, b paramb)
  {
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
      if (paramBoolean) {
        paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramb.kDX), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEh), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEf), e.kvx, Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEk), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.kEl) });
      }
      break;
    }
    for (;;)
    {
      y.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[] { Integer.valueOf(11062), paramString });
      h.nFQ.aC(11062, paramString);
      return;
      paramInt2 = 2;
      break;
      paramInt2 = 1;
      break;
      if (paramInt1 > 0) {
        paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(paramInt2), Integer.valueOf(paramb.kDX), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEh), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEf), e.kvx, Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEk), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.kEl) });
      } else {
        paramString = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramb.kDX), Integer.valueOf(paramb.kEa), Integer.valueOf(paramb.kEh), Integer.valueOf(paramb.kEe), Integer.valueOf(paramb.kEf), e.kvx, Integer.valueOf(paramb.kDZ), Integer.valueOf(paramb.kEb), Integer.valueOf(paramb.kEk), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.kEl) });
      }
    }
  }
  
  public static void c(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a(paramString, paramBoolean, paramInt1, paramInt2, new b());
  }
  
  public static final void go(boolean paramBoolean)
  {
    int j = 1;
    h localh;
    if (paramBoolean)
    {
      i = 1;
      y.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", new Object[] { Integer.valueOf(13970), Integer.valueOf(i) });
      localh = h.nFQ;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (int i = j;; i = 0)
    {
      localh.f(13970, new Object[] { Integer.valueOf(i) });
      return;
      i = 0;
      break;
    }
  }
  
  private static int i(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private static int rE(int paramInt)
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