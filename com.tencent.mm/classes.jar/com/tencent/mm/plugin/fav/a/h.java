package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> rsr;
  private static Map<Long, Long> rss;
  
  static
  {
    AppMethodBeat.i(103397);
    rsr = new HashMap();
    rss = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static final void DV(int paramInt)
  {
    AppMethodBeat.i(103389);
    e.ygI.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void DW(int paramInt)
  {
    AppMethodBeat.i(103390);
    e.ygI.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    ad.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.ygI.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.rst;
    int i1 = parama.type;
    str = parama.rsu;
    int i2 = parama.dnh;
    long l2 = parama.timestamp;
    long l3 = parama.rsv;
    long l4 = parama.rsw;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.rsx)
    {
      i = 1;
      i3 = parama.rsy;
      i4 = parama.rsz;
      i5 = parama.rsA;
      i6 = parama.rsB;
      i7 = parama.rsC;
      if (!parama.rsD) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.rsE) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.ooi) });
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
  
  public static int fE(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(103395);
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.Gjv.sourceType;
      str = localg.field_favProto.Gjv.dyU;
      i = 0;
      if (paramInt1 == 1) {
        if (!w.vF(localg.field_favProto.Gjv.dyU)) {
          break label247;
        }
      }
    }
    label247:
    for (int i = 2;; i = 1)
    {
      gw localgw = new gw();
      localgw.dsV.type = 40;
      localgw.dsV.dnI = localg.field_favProto;
      a.IbL.l(localgw);
      com.tencent.mm.plugin.report.service.g.yhR.f(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localgw.dsW.dto });
      AppMethodBeat.o(103395);
      return;
    }
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cva()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.Gjv.sourceType), localg.field_favProto.Gjv.dyU });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void vw(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (rsr.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    rsr.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long vx(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)rsr.get(Long.valueOf(paramLong));
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
  
  public static void vy(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (rss.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    rss.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final class a
  {
    public int dnh;
    public int index;
    public int ooi;
    public String qXk;
    public String query;
    public int rsA;
    public int rsB;
    public int rsC;
    public boolean rsD;
    public boolean rsE;
    public int rsF;
    public String rsG;
    public long rst;
    public String rsu;
    public long rsv;
    public long rsw;
    public boolean rsx;
    public int rsy;
    public int rsz;
    public int scene;
    public long timestamp;
    public int type;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.rst;
      int i1 = this.type;
      String str = this.rsu;
      int i2 = this.dnh;
      long l2 = this.timestamp;
      long l3 = this.rsv;
      long l4 = this.rsw;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.rsx)
      {
        i = 1;
        i3 = this.rsy;
        i4 = this.rsz;
        i5 = this.rsA;
        i6 = this.rsB;
        i7 = this.rsC;
        if (!this.rsD) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.rsE) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.ooi), this.qXk, Integer.valueOf(this.rsF), this.query, this.rsG });
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