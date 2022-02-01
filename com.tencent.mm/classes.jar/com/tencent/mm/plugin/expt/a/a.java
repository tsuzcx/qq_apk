package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
{
  private static a yFP = null;
  long yFQ;
  
  private a()
  {
    AppMethodBeat.i(299826);
    this.yFQ = 0L;
    if (h.baz())
    {
      this.yFQ = h.baE().ban().a(at.a.acWG, Util.nowMilliSecond());
      AppMethodBeat.o(299826);
      return;
    }
    this.yFQ = Util.nowMilliSecond();
    AppMethodBeat.o(299826);
  }
  
  public static boolean Lr(int paramInt)
  {
    AppMethodBeat.i(299834);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(299834);
      return false;
    }
    Object localObject = b.dHJ();
    if (paramInt < 0) {
      Log.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 163L, 1L, false);
      AppMethodBeat.o(299834);
      return true;
      if (paramInt >= 0)
      {
        localObject = ((b)localObject).atj();
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
  
  public static a dHH()
  {
    AppMethodBeat.i(299819);
    if (yFP == null) {
      yFP = new a();
    }
    a locala = yFP;
    AppMethodBeat.o(299819);
    return locala;
  }
  
  public static void dHI()
  {
    AppMethodBeat.i(299840);
    h.aZW().a(new c(), 0);
    AppMethodBeat.o(299840);
  }
  
  public final boolean lQ(long paramLong)
  {
    AppMethodBeat.i(299853);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(299853);
      return false;
    }
    if (h.baz())
    {
      Log.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", new Object[] { Long.valueOf(h.baE().ban().a(at.a.acWG, 0L)), Long.valueOf(paramLong) });
      h.baE().ban().set(at.a.acWG, Long.valueOf(paramLong));
      this.yFQ = paramLong;
      AppMethodBeat.o(299853);
      return true;
    }
    AppMethodBeat.o(299853);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a
 * JD-Core Version:    0.7.0.1
 */