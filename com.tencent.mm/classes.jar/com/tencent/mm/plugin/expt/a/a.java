package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
{
  private static a vtr = null;
  long vts;
  
  private a()
  {
    AppMethodBeat.i(256737);
    this.vts = 0L;
    if (h.aHB())
    {
      this.vts = h.aHG().aHp().a(ar.a.VuX, Util.nowMilliSecond());
      AppMethodBeat.o(256737);
      return;
    }
    this.vts = Util.nowMilliSecond();
    AppMethodBeat.o(256737);
  }
  
  public static boolean Ks(int paramInt)
  {
    AppMethodBeat.i(256740);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(256740);
      return false;
    }
    Object localObject = b.dbn();
    if (paramInt < 0) {
      Log.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(863L, 163L, 1L, false);
      AppMethodBeat.o(256740);
      return true;
      if (paramInt >= 0)
      {
        localObject = ((b)localObject).bcJ();
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
  
  public static a dbl()
  {
    AppMethodBeat.i(256733);
    if (vtr == null) {
      vtr = new a();
    }
    a locala = vtr;
    AppMethodBeat.o(256733);
    return locala;
  }
  
  public static void dbm()
  {
    AppMethodBeat.i(256743);
    h.aGY().a(new c(), 0);
    AppMethodBeat.o(256743);
  }
  
  public final boolean Jz(long paramLong)
  {
    AppMethodBeat.i(256742);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(256742);
      return false;
    }
    if (h.aHB())
    {
      Log.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", new Object[] { Long.valueOf(h.aHG().aHp().a(ar.a.VuX, 0L)), Long.valueOf(paramLong) });
      h.aHG().aHp().set(ar.a.VuX, Long.valueOf(paramLong));
      this.vts = paramLong;
      AppMethodBeat.o(256742);
      return true;
    }
    AppMethodBeat.o(256742);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a
 * JD-Core Version:    0.7.0.1
 */