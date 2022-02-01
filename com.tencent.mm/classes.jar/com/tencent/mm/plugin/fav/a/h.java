package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> pZJ;
  private static Map<Long, Long> pZK;
  
  static
  {
    AppMethodBeat.i(103397);
    pZJ = new HashMap();
    pZK = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static final void Ci(int paramInt)
  {
    AppMethodBeat.i(103389);
    e.vIY.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void Cj(int paramInt)
  {
    AppMethodBeat.i(103390);
    e.vIY.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    ad.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.vIY.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.pZL;
    int i1 = parama.type;
    str = parama.pZM;
    int i2 = parama.dep;
    long l2 = parama.timestamp;
    long l3 = parama.pZN;
    long l4 = parama.pZO;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.pZP)
    {
      i = 1;
      i3 = parama.pZQ;
      i4 = parama.pZR;
      i5 = parama.pZS;
      i6 = parama.pZT;
      i7 = parama.pZU;
      if (!parama.pZV) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.pZW) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.niJ) });
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
  
  public static int ft(int paramInt1, int paramInt2)
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
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.DiD.sourceType;
      str = localg.field_favProto.DiD.dpv;
      i = 0;
      if (paramInt1 == 1) {
        if (!w.pF(localg.field_favProto.DiD.dpv)) {
          break label247;
        }
      }
    }
    label247:
    for (int i = 2;; i = 1)
    {
      gs localgs = new gs();
      localgs.dkc.type = 40;
      localgs.dkc.deS = localg.field_favProto;
      a.ESL.l(localgs);
      com.tencent.mm.plugin.report.service.h.vKh.f(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localgs.dkd.dkv });
      AppMethodBeat.o(103395);
      return;
    }
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.vKh.f(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().chO()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.DiD.sourceType), localg.field_favProto.DiD.dpv });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void pK(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (pZJ.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    pZJ.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long pL(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)pZJ.get(Long.valueOf(paramLong));
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
  
  public static void pM(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (pZK.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    pZK.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final class a
  {
    public int dep;
    public int index;
    public int niJ;
    public long pZL;
    public String pZM;
    public long pZN;
    public long pZO;
    public boolean pZP;
    public int pZQ;
    public int pZR;
    public int pZS;
    public int pZT;
    public int pZU;
    public boolean pZV;
    public boolean pZW;
    public String pZX;
    public int pZY;
    public String pZZ;
    public String query;
    public int scene;
    public long timestamp;
    public int type;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.pZL;
      int i1 = this.type;
      String str = this.pZM;
      int i2 = this.dep;
      long l2 = this.timestamp;
      long l3 = this.pZN;
      long l4 = this.pZO;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.pZP)
      {
        i = 1;
        i3 = this.pZQ;
        i4 = this.pZR;
        i5 = this.pZS;
        i6 = this.pZT;
        i7 = this.pZU;
        if (!this.pZV) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.pZW) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.niJ), this.pZX, Integer.valueOf(this.pZY), this.query, this.pZZ });
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