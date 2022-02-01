package com.tencent.f;

import android.content.Context;
import com.tencent.f.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private static i ahVe;
  private Context mAppContext;
  private boolean mStarted;
  
  private static i kcO()
  {
    AppMethodBeat.i(62809);
    if (ahVe == null) {}
    try
    {
      if (ahVe == null) {
        ahVe = new i();
      }
      i locali = ahVe;
      AppMethodBeat.o(62809);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(62809);
    }
  }
  
  public static void oE(Context paramContext)
  {
    AppMethodBeat.i(62810);
    i locali = kcO();
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
      finally
      {
        com.tencent.pb.common.c.b.w("service", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(62810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.f.i
 * JD-Core Version:    0.7.0.1
 */