package com.tencent.h;

import android.content.Context;
import com.tencent.h.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public final class i
{
  private static i ByQ;
  private boolean mStarted;
  private Context zF;
  
  private static i dWX()
  {
    AppMethodBeat.i(127762);
    if (ByQ == null) {}
    try
    {
      if (ByQ == null) {
        ByQ = new i();
      }
      i locali = ByQ;
      AppMethodBeat.o(127762);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(127762);
    }
  }
  
  public static void jL(Context paramContext)
  {
    AppMethodBeat.i(127763);
    i locali = dWX();
    if (!locali.mStarted)
    {
      locali.zF = paramContext;
      paramContext = new d("EventCenter", com.tencent.h.a.b.class.getName());
      try
      {
        paramContext = f.a(paramContext);
        if (paramContext != null) {
          paramContext.start();
        }
        AppMethodBeat.o(127763);
        return;
      }
      catch (Throwable paramContext)
      {
        c.w("service", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(127763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.h.i
 * JD-Core Version:    0.7.0.1
 */