package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> rAE;
  private static Map<Long, Long> rAF;
  
  static
  {
    AppMethodBeat.i(103397);
    rAE = new HashMap();
    rAF = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static final void Ei(int paramInt)
  {
    AppMethodBeat.i(103389);
    e.ywz.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void Ej(int paramInt)
  {
    AppMethodBeat.i(103390);
    e.ywz.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    ae.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.ywz.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.rAG;
    int i1 = parama.type;
    str = parama.rAH;
    int i2 = parama.doj;
    long l2 = parama.timestamp;
    long l3 = parama.rAI;
    long l4 = parama.rAJ;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.rAK)
    {
      i = 1;
      i3 = parama.rAL;
      i4 = parama.rAM;
      i5 = parama.rAN;
      i6 = parama.rAO;
      i7 = parama.rAP;
      if (!parama.rAQ) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.rAR) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.otZ) });
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
  
  public static int fC(int paramInt1, int paramInt2)
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
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.GCe.sourceType;
      str = localg.field_favProto.GCe.dzZ;
      i = 0;
      if (paramInt1 == 1) {
        if (!com.tencent.mm.model.x.wb(localg.field_favProto.GCe.dzZ)) {
          break label247;
        }
      }
    }
    label247:
    for (int i = 2;; i = 1)
    {
      gx localgx = new gx();
      localgx.dub.type = 40;
      localgx.dub.doN = localg.field_favProto;
      a.IvT.l(localgx);
      com.tencent.mm.plugin.report.service.g.yxI.f(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localgx.duc.duu });
      AppMethodBeat.o(103395);
      return;
    }
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cwB()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.GCe.sourceType), localg.field_favProto.GCe.dzZ });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void vM(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (rAE.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    rAE.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long vN(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)rAE.get(Long.valueOf(paramLong));
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
  
  public static void vO(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (rAF.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    rAF.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final class a
  {
    public int doj;
    public int index;
    public int otZ;
    public String query;
    public long rAG;
    public String rAH;
    public long rAI;
    public long rAJ;
    public boolean rAK;
    public int rAL;
    public int rAM;
    public int rAN;
    public int rAO;
    public int rAP;
    public boolean rAQ;
    public boolean rAR;
    public int rAS;
    public String rAT;
    public String rfp;
    public int scene;
    public long timestamp;
    public int type;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.rAG;
      int i1 = this.type;
      String str = this.rAH;
      int i2 = this.doj;
      long l2 = this.timestamp;
      long l3 = this.rAI;
      long l4 = this.rAJ;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.rAK)
      {
        i = 1;
        i3 = this.rAL;
        i4 = this.rAM;
        i5 = this.rAN;
        i6 = this.rAO;
        i7 = this.rAP;
        if (!this.rAQ) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.rAR) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.otZ), this.rfp, Integer.valueOf(this.rAS), this.query, this.rAT });
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