package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private static Map<Long, Long> Acv;
  private static Map<Long, Long> Acw;
  
  static
  {
    AppMethodBeat.i(103397);
    Acv = new HashMap();
    Acw = new HashMap();
    AppMethodBeat.o(103397);
  }
  
  public static void I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(274351);
    b(paramLong, paramInt, 0, -1);
    AppMethodBeat.o(274351);
  }
  
  public static final void MA(int paramInt)
  {
    AppMethodBeat.i(103389);
    f.Ozc.idkeyStat(802L, paramInt, 1L, false);
    AppMethodBeat.o(103389);
  }
  
  public static final void MB(int paramInt)
  {
    AppMethodBeat.i(103390);
    f.Ozc.idkeyStat(802L, 4L, paramInt, false);
    AppMethodBeat.o(103390);
  }
  
  public static String a(a parama)
  {
    int k = 1;
    AppMethodBeat.i(103394);
    String str = parama.toString();
    Log.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[] { str });
    f.Ozc.kvStat(15098, str);
    int m = parama.scene;
    int n = parama.index;
    long l1 = parama.Acx;
    int i1 = parama.type;
    str = parama.Acy;
    int i2 = parama.source;
    long l2 = parama.timestamp;
    long l3 = parama.Acz;
    long l4 = parama.AcA;
    int i;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int j;
    if (parama.AcB)
    {
      i = 1;
      i3 = parama.AcC;
      i4 = parama.AcD;
      i5 = parama.AcE;
      i6 = parama.AcF;
      i7 = parama.AcG;
      if (!parama.AcH) {
        break label324;
      }
      j = 1;
      label142:
      if (!parama.AcI) {
        break label329;
      }
    }
    for (;;)
    {
      parama = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(parama.AcJ) });
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
    AppMethodBeat.i(274352);
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    int j;
    String str;
    if (localg != null)
    {
      j = localg.field_favProto.ZBt.sourceType;
      str = localg.field_favProto.ZBt.hQQ;
      i = 0;
      if (paramInt1 == 1) {
        if (!au.bwE(localg.field_favProto.ZBt.hQQ)) {
          break label253;
        }
      }
    }
    label253:
    for (int i = 2;; i = 1)
    {
      ht localht = new ht();
      localht.hIR.type = 40;
      localht.hIR.hDt = localg.field_favProto;
      localht.publish();
      com.tencent.mm.plugin.report.service.h.OAn.b(10651, new Object[] { Integer.valueOf(localg.field_type), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_id), b.r(localg), Long.valueOf(localg.field_updateTime / 1000L), Integer.valueOf(j), str, Integer.valueOf(i), "", localht.hIS.hJk, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(274352);
      return;
    }
  }
  
  public static int hi(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -401) {
      return -4;
    }
    if (paramInt1 == 4) {
      return -2;
    }
    return -1;
  }
  
  public static void k(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103396);
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(paramLong);
    if (localg != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(11122, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().dQx()), Integer.valueOf(paramInt2), Integer.valueOf(localg.field_type), b.r(localg), Long.valueOf(localg.field_updateTime), Integer.valueOf(localg.field_favProto.ZBt.sourceType), localg.field_favProto.ZBt.hQQ });
    }
    AppMethodBeat.o(103396);
  }
  
  public static void mC(long paramLong)
  {
    AppMethodBeat.i(103391);
    if (Acv.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103391);
      return;
    }
    Acv.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103391);
  }
  
  public static long mD(long paramLong)
  {
    AppMethodBeat.i(103392);
    Long localLong = (Long)Acv.get(Long.valueOf(paramLong));
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
  
  public static void mE(long paramLong)
  {
    AppMethodBeat.i(103393);
    if (Acw.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(103393);
      return;
    }
    Acw.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(103393);
  }
  
  public static final class a
  {
    public long AcA;
    public boolean AcB;
    public int AcC;
    public int AcD;
    public int AcE;
    public int AcF;
    public int AcG;
    public boolean AcH;
    public boolean AcI;
    public int AcJ;
    public int AcK;
    public String AcL;
    public long Acx;
    public String Acy;
    public long Acz;
    public int index;
    public String query;
    public int scene;
    public int source;
    public long timestamp;
    public int type;
    public String zIC;
    
    public final String toString()
    {
      int k = 1;
      AppMethodBeat.i(103388);
      int m = this.scene;
      int n = this.index;
      long l1 = this.Acx;
      int i1 = this.type;
      String str = this.Acy;
      int i2 = this.source;
      long l2 = this.timestamp;
      long l3 = this.Acz;
      long l4 = this.AcA;
      int i;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int j;
      if (this.AcB)
      {
        i = 1;
        i3 = this.AcC;
        i4 = this.AcD;
        i5 = this.AcE;
        i6 = this.AcF;
        i7 = this.AcG;
        if (!this.AcH) {
          break label328;
        }
        j = 1;
        label109:
        if (!this.AcI) {
          break label333;
        }
      }
      for (;;)
      {
        str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1), str, Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.AcJ), this.zIC, Integer.valueOf(this.AcK), this.query, this.AcL });
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