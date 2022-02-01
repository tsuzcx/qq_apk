package com.tencent.h.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.g.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private SharedPreferences ZUY;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(208177);
    try
    {
      this.ZUY = paramContext.getSharedPreferences("ts_" + d.U(d.ZRA), 0);
      AppMethodBeat.o(208177);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.d.c
 * JD-Core Version:    0.7.0.1
 */