package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
{
  private static a rNH = null;
  long rNI;
  
  private a()
  {
    AppMethodBeat.i(220249);
    this.rNI = 0L;
    if (g.aAc())
    {
      this.rNI = g.aAh().azQ().a(ar.a.OgH, Util.nowMilliSecond());
      AppMethodBeat.o(220249);
      return;
    }
    this.rNI = Util.nowMilliSecond();
    AppMethodBeat.o(220249);
  }
  
  public static boolean GK(int paramInt)
  {
    AppMethodBeat.i(220250);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(220250);
      return false;
    }
    Object localObject = b.cMz();
    if (paramInt < 0) {
      Log.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(863L, 163L, 1L, false);
      AppMethodBeat.o(220250);
      return true;
      if (paramInt >= 0)
      {
        localObject = ((b)localObject).aTI();
        if (localObject != null) {
          break;
        }
        Log.e(b.TAG, "get mmkv is null!, err");
      }
    }
    int i = ((MultiProcessMMKV)localObject).decodeInt(String.valueOf(paramInt));
    if (i == 0) {
      ((MultiProcessMMKV)localObject).putInt(String.valueOf(paramInt), 1);
    }
    for (;;)
    {
      Log.i(b.TAG, "exptid  count  [%d] [%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i + 1) });
      break;
      ((MultiProcessMMKV)localObject).putInt(String.valueOf(paramInt), i + 1);
    }
  }
  
  public static a cMx()
  {
    AppMethodBeat.i(220248);
    if (rNH == null) {
      rNH = new a();
    }
    a locala = rNH;
    AppMethodBeat.o(220248);
    return locala;
  }
  
  public static void cMy()
  {
    AppMethodBeat.i(220252);
    g.azz().a(new c(), 0);
    AppMethodBeat.o(220252);
  }
  
  public final boolean Dl(long paramLong)
  {
    AppMethodBeat.i(220251);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(220251);
      return false;
    }
    if (g.aAc())
    {
      Log.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", new Object[] { Long.valueOf(g.aAh().azQ().a(ar.a.OgH, 0L)), Long.valueOf(paramLong) });
      g.aAh().azQ().set(ar.a.OgH, Long.valueOf(paramLong));
      this.rNI = paramLong;
      AppMethodBeat.o(220251);
      return true;
    }
    AppMethodBeat.o(220251);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a
 * JD-Core Version:    0.7.0.1
 */