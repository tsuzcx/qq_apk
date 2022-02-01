package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
{
  private static a qpu = null;
  long qpv;
  
  private a()
  {
    AppMethodBeat.i(210189);
    this.qpv = 0L;
    if (g.ajx())
    {
      this.qpv = g.ajC().ajl().a(al.a.IDK, bt.flT());
      AppMethodBeat.o(210189);
      return;
    }
    this.qpv = bt.flT();
    AppMethodBeat.o(210189);
  }
  
  public static boolean CN(int paramInt)
  {
    AppMethodBeat.i(210190);
    if (paramInt < 0)
    {
      ad.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(210190);
      return false;
    }
    b localb = b.cmY();
    if (paramInt < 0) {
      ad.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(863L, 163L, 1L, false);
      AppMethodBeat.o(210190);
      return true;
      if (paramInt >= 0)
      {
        localb.cBy = b.bNe();
        if (localb.cBy != null) {
          break;
        }
        ad.e(b.TAG, "get mmkv is null!, err");
      }
    }
    int i = localb.cBy.decodeInt(String.valueOf(paramInt));
    if (i == 0) {
      localb.cBy.putInt(String.valueOf(paramInt), 1);
    }
    for (;;)
    {
      ad.i(b.TAG, "exptid  count  [%d] [%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
      break;
      localb.cBy.putInt(String.valueOf(paramInt), i + 1);
    }
  }
  
  public static a cmW()
  {
    AppMethodBeat.i(210188);
    if (qpu == null) {
      qpu = new a();
    }
    a locala = qpu;
    AppMethodBeat.o(210188);
    return locala;
  }
  
  public static void cmX()
  {
    AppMethodBeat.i(210192);
    g.aiU().a(new c(), 0);
    AppMethodBeat.o(210192);
  }
  
  public final boolean uQ(long paramLong)
  {
    AppMethodBeat.i(210191);
    if (paramLong <= 0L)
    {
      ad.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(210191);
      return false;
    }
    if (g.ajx())
    {
      ad.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", new Object[] { Long.valueOf(g.ajC().ajl().a(al.a.IDK, 0L)), Long.valueOf(paramLong) });
      g.ajC().ajl().set(al.a.IDK, Long.valueOf(paramLong));
      this.qpv = paramLong;
      AppMethodBeat.o(210191);
      return true;
    }
    AppMethodBeat.o(210191);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a
 * JD-Core Version:    0.7.0.1
 */