package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
{
  private static a qwa = null;
  long qwb;
  
  private a()
  {
    AppMethodBeat.i(195829);
    this.qwb = 0L;
    if (g.ajM())
    {
      this.qwb = g.ajR().ajA().a(am.a.IYk, bu.fpO());
      AppMethodBeat.o(195829);
      return;
    }
    this.qwb = bu.fpO();
    AppMethodBeat.o(195829);
  }
  
  public static boolean CZ(int paramInt)
  {
    AppMethodBeat.i(195830);
    if (paramInt < 0)
    {
      ae.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(195830);
      return false;
    }
    Object localObject = b.coo();
    if (paramInt < 0) {
      ae.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(863L, 163L, 1L, false);
      AppMethodBeat.o(195830);
      return true;
      if (paramInt >= 0)
      {
        localObject = ((b)localObject).bOc();
        if (localObject != null) {
          break;
        }
        ae.e(b.TAG, "get mmkv is null!, err");
      }
    }
    int i = ((ay)localObject).decodeInt(String.valueOf(paramInt));
    if (i == 0) {
      ((ay)localObject).putInt(String.valueOf(paramInt), 1);
    }
    for (;;)
    {
      ae.i(b.TAG, "exptid  count  [%d] [%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i + 1) });
      break;
      ((ay)localObject).putInt(String.valueOf(paramInt), i + 1);
    }
  }
  
  public static a com()
  {
    AppMethodBeat.i(195828);
    if (qwa == null) {
      qwa = new a();
    }
    a locala = qwa;
    AppMethodBeat.o(195828);
    return locala;
  }
  
  public static void con()
  {
    AppMethodBeat.i(195832);
    g.ajj().a(new c(), 0);
    AppMethodBeat.o(195832);
  }
  
  public final boolean vh(long paramLong)
  {
    AppMethodBeat.i(195831);
    if (paramLong <= 0L)
    {
      ae.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(195831);
      return false;
    }
    if (g.ajM())
    {
      ae.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", new Object[] { Long.valueOf(g.ajR().ajA().a(am.a.IYk, 0L)), Long.valueOf(paramLong) });
      g.ajR().ajA().set(am.a.IYk, Long.valueOf(paramLong));
      this.qwb = paramLong;
      AppMethodBeat.o(195831);
      return true;
    }
    AppMethodBeat.o(195831);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a
 * JD-Core Version:    0.7.0.1
 */