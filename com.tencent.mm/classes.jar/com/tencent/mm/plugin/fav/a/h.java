package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> jYE = new HashMap();
  private static Map<Long, Long> jYF = new HashMap();
  
  public static String a(a parama)
  {
    int k = 1;
    String str = parama.toString();
    y.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    f.nEG.aC(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.jYG;
    int i1 = parama.type;
    str = parama.jYH;
    int i2 = parama.source;
    long l2 = parama.timestamp;
    long l3 = parama.jYI;
    long l4 = parama.jYJ;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.jYK)
    {
      i = 1;
      i3 = parama.jYL;
      i4 = parama.jYM;
      i5 = parama.jYN;
      i6 = parama.jYO;
      i7 = parama.jYP;
      if (!parama.jYQ) {
        break label312;
      }
      j = 1;
      label137:
      if (!parama.jYR) {
        break label317;
      }
    }
    for (;;)
    {
      return String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.jYS) });
      i = 0;
      break;
      label312:
      j = 0;
      break label137;
      label317:
      k = 0;
    }
  }
  
  public static int cP(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -401) {
      return -4;
    }
    if (paramInt1 == 4) {
      return -2;
    }
    return -1;
  }
  
  public static void ew(long paramLong)
  {
    if (jYE.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    jYE.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static long ex(long paramLong)
  {
    Long localLong = (Long)jYE.get(Long.valueOf(paramLong));
    if (localLong == null) {
      return -1L;
    }
    return System.currentTimeMillis() - localLong.longValue();
  }
  
  public static void ey(long paramLong)
  {
    if (jYF.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    jYF.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void f(long paramLong, int paramInt1, int paramInt2)
  {
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
    int j;
    String str;
    int i;
    if (localg != null)
    {
      j = localg.field_favProto.sXa.bIl;
      str = localg.field_favProto.sXa.bRO;
      if (paramInt1 != 1) {
        break label187;
      }
      if (!s.fn(localg.field_favProto.sXa.bRO)) {
        break label181;
      }
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "" });
      return;
      label181:
      i = 1;
      continue;
      label187:
      i = 0;
    }
  }
  
  public static void g(long paramLong, int paramInt1, int paramInt2)
  {
    g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavTagSetMgr().aQh()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.sXa.bIl), localg.field_favProto.sXa.bRO });
    }
  }
  
  public static final void qV(int paramInt)
  {
    f.nEG.a(802L, paramInt, 1L, false);
  }
  
  public static final void qW(int paramInt)
  {
    f.nEG.a(802L, 4L, paramInt, false);
  }
  
  public static final class a
  {
    public String bVk;
    public int index;
    public long jYG;
    public String jYH;
    public long jYI;
    public long jYJ;
    public boolean jYK;
    public int jYL;
    public int jYM;
    public int jYN;
    public int jYO;
    public int jYP;
    public boolean jYQ;
    public boolean jYR;
    public int jYS;
    public int jYT;
    public String jYU;
    public int scene;
    public String sid;
    public int source;
    public long timestamp;
    public int type;
    
    public final String toString()
    {
      int k = 1;
      int m = this.scene;
      int n = this.index;
      long l1 = this.jYG;
      int i1 = this.type;
      String str = this.jYH;
      int i2 = this.source;
      long l2 = this.timestamp;
      long l3 = this.jYI;
      long l4 = this.jYJ;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.jYK)
      {
        i = 1;
        i3 = this.jYL;
        i4 = this.jYM;
        i5 = this.jYN;
        i6 = this.jYO;
        i7 = this.jYP;
        if (!this.jYQ) {
          break label314;
        }
        j = 1;
        label104:
        if (!this.jYR) {
          break label319;
        }
      }
      for (;;)
      {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.jYS), this.sid, Integer.valueOf(this.jYT), this.bVk, this.jYU });
        i = 0;
        break;
        label314:
        j = 0;
        break label104;
        label319:
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h
 * JD-Core Version:    0.7.0.1
 */