package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.sdk.platformtools.ae;

public enum a
{
  public static final a jNN;
  public static final a jNO;
  public static final a jNP;
  public static final a jNQ;
  
  static
  {
    AppMethodBeat.i(44429);
    jNM = new a("INSTANCE");
    jNR = new a[] { jNM };
    jNN = new a() {};
    jNO = new a() {};
    jNP = new a() {};
    jNQ = new a() {};
    AppMethodBeat.o(44429);
  }
  
  private a() {}
  
  public static void A(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44428);
    if (paramLong2 < 0L)
    {
      ae.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(44428);
      return;
    }
    if (paramLong1 > 0L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(paramLong1, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.g.yxI.f(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    if (843L != paramLong1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(843L, paramLong2, 1L);
      com.tencent.mm.plugin.report.service.g.yxI.f(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(44428);
  }
  
  public static void dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224361);
    A(paramInt1, paramInt2);
    AppMethodBeat.o(224361);
  }
  
  public static class a<_Key>
    extends SparseIntArray
  {
    private int ck(_Key param_Key)
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
    
    public final void g(_Key param_Key, int paramInt)
    {
      AppMethodBeat.i(44422);
      super.put(param_Key.hashCode(), paramInt);
      AppMethodBeat.o(44422);
    }
    
    public final int get(_Key param_Key)
    {
      AppMethodBeat.i(44424);
      int i = ck(param_Key);
      AppMethodBeat.o(44424);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a
 * JD-Core Version:    0.7.0.1
 */