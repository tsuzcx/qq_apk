package com.tencent.f;

import android.content.Context;
import com.tencent.f.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private static i MHc;
  private Context IR;
  private boolean mStarted;
  
  private static i gdp()
  {
    AppMethodBeat.i(62809);
    if (MHc == null) {}
    try
    {
      if (MHc == null) {
        MHc = new i();
      }
      i locali = MHc;
      AppMethodBeat.o(62809);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(62809);
    }
  }
  
  public static void lw(Context paramContext)
  {
    AppMethodBeat.i(62810);
    i locali = gdp();
    if (!locali.mStarted)
    {
      locali.IR = paramContext;
      paramContext = new d("EventCenter", com.tencent.f.a.b.class.getName());
      try
      {
        paramContext = f.a(paramContext);
        if (paramContext != null) {
          paramContext.start();
        }
        AppMethodBeat.o(62810);
        return;
      }
      catch (Throwable paramContext)
      {
        com.tencent.pb.common.c.b.w("service", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(62810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.f.i
 * JD-Core Version:    0.7.0.1
 */