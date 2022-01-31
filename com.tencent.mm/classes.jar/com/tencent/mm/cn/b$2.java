package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.xweb.y;

final class b$2
  extends y
{
  final String TAG = "XWebIdkey";
  
  public final void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(80378);
    ab.v("XWebIdkey", "callback: kvStat:15003, 190503," + paramInt1 + ",0," + paramString + "," + paramInt3 + ",-1," + paramInt4 + "," + paramInt5 + "," + paramInt6);
    h.qsU.e(15003, new Object[] { Integer.valueOf(190503), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(at.getNetType(ah.getContext())), Integer.valueOf(paramInt3), Integer.valueOf(-1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
    AppMethodBeat.o(80378);
  }
  
  public final void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(80376);
    ab.v("XWebIdkey", "callback: idkeyForPair:577, " + paramInt1 + ", 1, 577, " + paramInt2 + ", " + paramInt3);
    h.qsU.a(577, 577, paramInt1, paramInt2, 1, paramInt3, true);
    AppMethodBeat.o(80376);
  }
  
  public final void j(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(80375);
    ab.v("XWebIdkey", "callback: idkeyStat:" + paramLong1 + ", " + paramLong2 + ", " + paramLong3);
    h.qsU.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(80375);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(80377);
    ab.v("XWebIdkey", "callback: kvStat:" + paramInt + ", " + paramString);
    h.qsU.kvStat(paramInt, paramString);
    AppMethodBeat.o(80377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cn.b.2
 * JD-Core Version:    0.7.0.1
 */