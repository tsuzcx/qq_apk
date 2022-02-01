package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> qIq;
  private static Map<Long, Long> qIr;
  
  static
  {
    AppMethodBeat.i(103397);
    qIq = new HashMap();
    qIr = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static final void Dd(int paramInt)
  {
    AppMethodBeat.i(103389);
    e.wTc.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void De(int paramInt)
  {
    AppMethodBeat.i(103390);
    e.wTc.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    ac.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.wTc.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.qIs;
    int i1 = parama.type;
    str = parama.qIt;
    int i2 = parama.dbL;
    long l2 = parama.timestamp;
    long l3 = parama.qIu;
    long l4 = parama.qIv;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.qIw)
    {
      i = 1;
      i3 = parama.qIx;
      i4 = parama.qIy;
      i5 = parama.qIz;
      i6 = parama.qIA;
      i7 = parama.qIB;
      if (!parama.qIC) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.qID) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.nLC) });
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
  
  public static int fw(int paramInt1, int paramInt2)
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
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.EBJ.sourceType;
      str = localg.field_favProto.EBJ.dng;
      i = 0;
      if (paramInt1 == 1) {
        if (!w.sQ(localg.field_favProto.EBJ.dng)) {
          break label247;
        }
      }
    }
    label247:
    for (int i = 2;; i = 1)
    {
      gt localgt = new gt();
      localgt.dhx.type = 40;
      localgt.dhx.dcm = localg.field_favProto;
      a.GpY.l(localgt);
      com.tencent.mm.plugin.report.service.h.wUl.f(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localgt.dhy.dhQ });
      AppMethodBeat.o(103395);
      return;
    }
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.wUl.f(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavTagSetMgr().cpv()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.EBJ.sourceType), localg.field_favProto.EBJ.dng });
    }
    AppMethodBeat.o(103396);
  }
  
  public static long tA(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)qIq.get(Long.valueOf(paramLong));
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
  
  public static void tB(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (qIr.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    qIr.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static void tz(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (qIq.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    qIq.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static final class a
  {
    public int dbL;
    public int index;
    public int nLC;
    public int qIA;
    public int qIB;
    public boolean qIC;
    public boolean qID;
    public int qIE;
    public String qIF;
    public long qIs;
    public String qIt;
    public long qIu;
    public long qIv;
    public boolean qIw;
    public int qIx;
    public int qIy;
    public int qIz;
    public String qon;
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
      long l1 = this.qIs;
      int i1 = this.type;
      String str = this.qIt;
      int i2 = this.dbL;
      long l2 = this.timestamp;
      long l3 = this.qIu;
      long l4 = this.qIv;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.qIw)
      {
        i = 1;
        i3 = this.qIx;
        i4 = this.qIy;
        i5 = this.qIz;
        i6 = this.qIA;
        i7 = this.qIB;
        if (!this.qIC) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.qID) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.nLC), this.qon, Integer.valueOf(this.qIE), this.query, this.qIF });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h
 * JD-Core Version:    0.7.0.1
 */