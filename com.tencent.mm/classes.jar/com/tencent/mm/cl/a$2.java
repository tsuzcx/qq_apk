package com.tencent.mm.cl;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.r;

final class a$2
  extends r
{
  final String TAG = "XWebIdkey";
  
  public final void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    y.v("XWebIdkey", "callback: kvStat:15003, 180801," + paramInt1 + ",0," + paramString + "," + paramInt3 + ",-1," + paramInt4 + "," + paramInt5 + "," + paramInt6);
    h.nFQ.f(15003, new Object[] { Integer.valueOf(180801), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(aq.getNetType(ae.getContext())), Integer.valueOf(paramInt3), Integer.valueOf(-1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
  }
  
  public final void aC(int paramInt, String paramString)
  {
    y.v("XWebIdkey", "callback: kvStat:" + paramInt + ", " + paramString);
    h.nFQ.aC(paramInt, paramString);
  }
  
  public final void at(int paramInt1, int paramInt2, int paramInt3)
  {
    y.v("XWebIdkey", "callback: idkeyForPair:577, " + paramInt1 + ", 1, 577, " + paramInt2 + ", " + paramInt3);
    h.nFQ.a(577, 577, paramInt1, paramInt2, 1, paramInt3, true);
  }
  
  public final void h(long paramLong1, long paramLong2, long paramLong3)
  {
    y.v("XWebIdkey", "callback: idkeyStat:" + paramLong1 + ", " + paramLong2 + ", " + paramLong3);
    h.nFQ.a(paramLong1, paramLong2, paramLong3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cl.a.2
 * JD-Core Version:    0.7.0.1
 */