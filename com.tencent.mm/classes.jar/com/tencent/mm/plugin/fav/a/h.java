package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> taj;
  private static Map<Long, Long> tak;
  
  static
  {
    AppMethodBeat.i(103397);
    taj = new HashMap();
    tak = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static void DQ(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (taj.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    taj.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long DR(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)taj.get(Long.valueOf(paramLong));
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
  
  public static void DS(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (tak.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    tak.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final void HT(int paramInt)
  {
    AppMethodBeat.i(103389);
    e.Cxv.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void HU(int paramInt)
  {
    AppMethodBeat.i(103390);
    e.Cxv.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    Log.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.Cxv.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.tal;
    int i1 = parama.type;
    str = parama.tam;
    int i2 = parama.source;
    long l2 = parama.timestamp;
    long l3 = parama.tan;
    long l4 = parama.tao;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.tap)
    {
      i = 1;
      i3 = parama.taq;
      i4 = parama.tar;
      i5 = parama.tas;
      i6 = parama.tat;
      i7 = parama.tau;
      if (!parama.tav) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.taw) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.pHw) });
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
    AppMethodBeat.i(199703);
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.Lya.sourceType;
      str = localg.field_favProto.Lya.dRL;
      i = 0;
      if (paramInt1 == 1) {
        if (!ab.Eq(localg.field_favProto.Lya.dRL)) {
          break label257;
        }
      }
    }
    label257:
    for (int i = 2;; i = 1)
    {
      hb localhb = new hb();
      localhb.dLm.type = 40;
      localhb.dLm.dGb = localg.field_favProto;
      EventCenter.instance.publish(localhb);
      com.tencent.mm.plugin.report.service.h.CyF.a(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localhb.dLn.dLF, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(199703);
      return;
    }
  }
  
  public static int fS(int paramInt1, int paramInt2)
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
    g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.CyF.a(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().cUF()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.Lya.sourceType), localg.field_favProto.Lya.dRL });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void w(long paramLong, int paramInt)
  {
    AppMethodBeat.i(199702);
    b(paramLong, paramInt, 0, -1);
    AppMethodBeat.o(199702);
  }
  
  public static final class a
  {
    public int index;
    public int pHw;
    public String query;
    public String sGF;
    public int scene;
    public int source;
    public long tal;
    public String tam;
    public long tan;
    public long tao;
    public boolean tap;
    public int taq;
    public int tar;
    public int tas;
    public int tat;
    public int tau;
    public boolean tav;
    public boolean taw;
    public int tax;
    public String tay;
    public long timestamp;
    public int type;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.tal;
      int i1 = this.type;
      String str = this.tam;
      int i2 = this.source;
      long l2 = this.timestamp;
      long l3 = this.tan;
      long l4 = this.tao;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.tap)
      {
        i = 1;
        i3 = this.taq;
        i4 = this.tar;
        i5 = this.tas;
        i6 = this.tat;
        i7 = this.tau;
        if (!this.tav) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.taw) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.pHw), this.sGF, Integer.valueOf(this.tax), this.query, this.tay });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h
 * JD-Core Version:    0.7.0.1
 */