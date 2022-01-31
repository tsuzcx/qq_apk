package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> msX;
  private static Map<Long, Long> msY;
  
  static
  {
    AppMethodBeat.i(102657);
    msX = new HashMap();
    msY = new HashMap();
    AppMethodBeat.o(102657);
  }
  
  public static String a(h.a parama)
  {
    int k = 1;
    AppMethodBeat.i(102654);
    String str = parama.toString();
    ab.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    e.qrI.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.msZ;
    int i1 = parama.type;
    str = parama.mta;
    int i2 = parama.cpt;
    long l2 = parama.timestamp;
    long l3 = parama.mtb;
    long l4 = parama.mtc;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.mtd)
    {
      i = 1;
      i3 = parama.mte;
      i4 = parama.mtf;
      i5 = parama.mtg;
      i6 = parama.mth;
      i7 = parama.mti;
      if (!parama.mtj) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.mtk) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.kbN) });
      AppMethodBeat.o(102654);
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
  
  public static int en(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(102655);
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.wVa.cpG;
      str = localg.field_favProto.wVa.czp;
      i = 0;
      if (paramInt1 == 1) {
        if (!t.lA(localg.field_favProto.wVa.czp)) {
          break label194;
        }
      }
    }
    label194:
    for (int i = 2;; i = 1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "" });
      AppMethodBeat.o(102655);
      return;
    }
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102656);
    g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.qsU.e(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavTagSetMgr().bww()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.wVa.cpG), localg.field_favProto.wVa.czp });
    }
    AppMethodBeat.o(102656);
  }
  
  public static void jT(long paramLong)
  {
    AppMethodBeat.i(102651);
    if (msX.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(102651);
      return;
    }
    msX.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(102651);
  }
  
  public static long jU(long paramLong)
  {
    AppMethodBeat.i(102652);
    Long localLong = (Long)msX.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      AppMethodBeat.o(102652);
      return -1L;
    }
    paramLong = System.currentTimeMillis();
    long l = localLong.longValue();
    AppMethodBeat.o(102652);
    return paramLong - l;
  }
  
  public static void jV(long paramLong)
  {
    AppMethodBeat.i(102653);
    if (msY.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(102653);
      return;
    }
    msY.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(102653);
  }
  
  public static final void vQ(int paramInt)
  {
    AppMethodBeat.i(102649);
    e.qrI.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(102649);
  }
  
  public static final void vR(int paramInt)
  {
    AppMethodBeat.i(102650);
    e.qrI.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(102650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.h
 * JD-Core Version:    0.7.0.1
 */