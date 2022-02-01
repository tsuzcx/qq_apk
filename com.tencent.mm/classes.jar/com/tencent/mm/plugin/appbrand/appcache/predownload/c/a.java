package com.tencent.mm.plugin.appbrand.appcache.predownload.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.f;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.g;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.sdk.platformtools.Log;

public enum a
{
  public static final a nKC;
  public static final a nKD;
  public static final a nKE;
  public static final a nKF;
  
  static
  {
    AppMethodBeat.i(44429);
    nKB = new a("INSTANCE");
    nKG = new a[] { nKB };
    nKC = new a() {};
    nKD = new a() {};
    nKE = new a() {};
    nKF = new a() {};
    AppMethodBeat.o(44429);
  }
  
  private a() {}
  
  public static void F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44428);
    if (paramLong2 < 0L)
    {
      Log.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(44428);
      return;
    }
    if (paramLong1 > 0L)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(paramLong1, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.h.IzE.a(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    if (843L != paramLong1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(843L, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.h.IzE.a(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(44428);
  }
  
  public static void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293284);
    F(paramInt1, paramInt2);
    AppMethodBeat.o(293284);
  }
  
  public static class a<_Key>
    extends SparseIntArray
  {
    private int ct(_Key param_Key)
    {
      AppMethodBeat.i(44423);
      if (param_Key == null)
      {
        AppMethodBeat.o(44423);
        return -1;
      }
      int i = super.get(param_Key.hashCode(), -1);
      AppMethodBeat.o(44423);
      return i;
    }
    
    public final int S(_Key param_Key)
    {
      AppMethodBeat.i(44424);
      int i = ct(param_Key);
      AppMethodBeat.o(44424);
      return i;
    }
    
    public final void i(_Key param_Key, int paramInt)
    {
      AppMethodBeat.i(44422);
      super.put(param_Key.hashCode(), paramInt);
      AppMethodBeat.o(44422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.c.a
 * JD-Core Version:    0.7.0.1
 */