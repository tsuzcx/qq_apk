package com.tencent.f;

import android.content.Context;
import com.tencent.f.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private static i ZQH;
  private Context mAppContext;
  private boolean mStarted;
  
  private static i itw()
  {
    AppMethodBeat.i(62809);
    if (ZQH == null) {}
    try
    {
      if (ZQH == null) {
        ZQH = new i();
      }
      i locali = ZQH;
      AppMethodBeat.o(62809);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(62809);
    }
  }
  
  public static void mo(Context paramContext)
  {
    AppMethodBeat.i(62810);
    i locali = itw();
    if (!locali.mStarted)
    {
      locali.mAppContext = paramContext;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.f.i
 * JD-Core Version:    0.7.0.1
 */