package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> wGm;
  private static Map<Long, Long> wGn;
  
  static
  {
    AppMethodBeat.i(103397);
    wGm = new HashMap();
    wGn = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static void Ke(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (wGm.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    wGm.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long Kf(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)wGm.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(103392);
      return -1L;
    }
    paramLong = System.currentTimeMillis();
    long l = localLong.longValue();
    AppMethodBeat.o(103392);
    return paramLong - l;
  }
  
  public static void Kg(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (wGn.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    wGn.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final void LD(int paramInt)
  {
    AppMethodBeat.i(103389);
    f.Iyx.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void LE(int paramInt)
  {
    AppMethodBeat.i(103390);
    f.Iyx.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    Log.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    f.Iyx.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.wGo;
    int i1 = parama.type;
    str = parama.wGp;
    int i2 = parama.source;
    long l2 = parama.timestamp;
    long l3 = parama.wGq;
    long l4 = parama.wGr;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.wGs)
    {
      i = 1;
      i3 = parama.wGt;
      i4 = parama.wGu;
      i5 = parama.wGv;
      i6 = parama.wGw;
      i7 = parama.wGx;
      if (!parama.wGy) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.wGz) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.wGA) });
      AppMethodBeat.o(103394);
      return parama;
      i = 0;
      break;
      label324:
      j = 0;
      break label142;
      label329:
      k = 0;
    }
  }
  
  public static void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203874);
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.SAB.sourceType;
      str = localg.field_favProto.SAB.fLi;
      i = 0;
      if (paramInt1 == 1) {
        if (!ab.Lj(localg.field_favProto.SAB.fLi)) {
          break label257;
        }
      }
    }
    label257:
    for (int i = 2;; i = 1)
    {
      hi localhi = new hi();
      localhi.fEb.type = 40;
      localhi.fEb.fyK = localg.field_favProto;
      EventCenter.instance.publish(localhi);
      com.tencent.mm.plugin.report.service.h.IzE.a(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localhi.fEc.fEu, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(203874);
      return;
    }
  }
  
  public static int gp(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -401) {
      return -4;
    }
    if (paramInt1 == 4) {
      return -2;
    }
    return -1;
  }
  
  public static void i(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().djL()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.SAB.sourceType), localg.field_favProto.SAB.fLi });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203873);
    b(paramLong, paramInt, 0, -1);
    AppMethodBeat.o(203873);
  }
  
  public static final class a
  {
    public int index;
    public String query;
    public int scene;
    public int source;
    public long timestamp;
    public int type;
    public int wGA;
    public int wGB;
    public String wGC;
    public long wGo;
    public String wGp;
    public long wGq;
    public long wGr;
    public boolean wGs;
    public int wGt;
    public int wGu;
    public int wGv;
    public int wGw;
    public int wGx;
    public boolean wGy;
    public boolean wGz;
    public String wmA;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.wGo;
      int i1 = this.type;
      String str = this.wGp;
      int i2 = this.source;
      long l2 = this.timestamp;
      long l3 = this.wGq;
      long l4 = this.wGr;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.wGs)
      {
        i = 1;
        i3 = this.wGt;
        i4 = this.wGu;
        i5 = this.wGv;
        i6 = this.wGw;
        i7 = this.wGx;
        if (!this.wGy) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.wGz) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.wGA), this.wmA, Integer.valueOf(this.wGB), this.query, this.wGC });
        AppMethodBeat.o(103388);
        return str;
        i = 0;
        break;
        label328:
        j = 0;
        break label109;
        label333:
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h
 * JD-Core Version:    0.7.0.1
 */