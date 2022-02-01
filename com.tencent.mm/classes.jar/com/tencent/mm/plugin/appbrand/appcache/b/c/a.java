package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.g;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public enum a
{
  public static final a jqH;
  public static final a jqI;
  public static final a jqJ;
  public static final a jqK;
  
  static
  {
    AppMethodBeat.i(44429);
    jqG = new a("INSTANCE");
    jqL = new a[] { jqG };
    jqH = new a() {};
    jqI = new a() {};
    jqJ = new a() {};
    jqK = new a() {};
    AppMethodBeat.o(44429);
  }
  
  private a() {}
  
  public static void A(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44428);
    if (paramLong2 < 0L)
    {
      ac.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(44428);
      return;
    }
    if (paramLong1 > 0L)
    {
      h.wUl.n(paramLong1, paramLong2, 1L);
      h.wUl.f(15272, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    if (843L != paramLong1)
    {
      h.wUl.n(843L, paramLong2, 1L);
      h.wUl.f(15272, new Object[] { Integer.valueOf(843), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(44428);
  }
  
  public static void dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210154);
    A(paramInt1, paramInt2);
    AppMethodBeat.o(210154);
  }
  
  public static class a<_Key>
    extends SparseIntArray
  {
    private int ci(_Key param_Key)
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
    
    public final void f(_Key param_Key, int paramInt)
    {
      AppMethodBeat.i(44422);
      super.put(param_Key.hashCode(), paramInt);
      AppMethodBeat.o(44422);
    }
    
    public final int get(_Key param_Key)
    {
      AppMethodBeat.i(44424);
      int i = ci(param_Key);
      AppMethodBeat.o(44424);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a
 * JD-Core Version:    0.7.0.1
 */