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
  public static final a kQu;
  public static final a kQv;
  public static final a kQw;
  public static final a kQx;
  
  static
  {
    AppMethodBeat.i(44429);
    kQt = new a("INSTANCE");
    kQy = new a[] { kQt };
    kQu = new a() {};
    kQv = new a() {};
    kQw = new a() {};
    kQx = new a() {};
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
      com.tencent.mm.plugin.report.service.h.CyF.n(paramLong1, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.h.CyF.a(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    if (843L != paramLong1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.n(843L, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.h.CyF.a(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(44428);
  }
  
  public static void dN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258360);
    F(paramInt1, paramInt2);
    AppMethodBeat.o(258360);
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
    
    public final int get(_Key param_Key)
    {
      AppMethodBeat.i(44424);
      int i = ct(param_Key);
      AppMethodBeat.o(44424);
      return i;
    }
    
    public final void h(_Key param_Key, int paramInt)
    {
      AppMethodBeat.i(44422);
      super.put(param_Key.hashCode(), paramInt);
      AppMethodBeat.o(44422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.c.a
 * JD-Core Version:    0.7.0.1
 */