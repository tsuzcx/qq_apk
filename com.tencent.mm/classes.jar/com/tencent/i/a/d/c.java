package com.tencent.i.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.h.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private SharedPreferences Stv;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(214827);
    try
    {
      this.Stv = paramContext.getSharedPreferences("ts_" + d.V(d.SpV), 0);
      AppMethodBeat.o(214827);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.d.c
 * JD-Core Version:    0.7.0.1
 */