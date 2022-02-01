package com.tencent.h.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.g.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private SharedPreferences ahZx;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(212084);
    try
    {
      this.ahZx = paramContext.getSharedPreferences("ts_" + d.W(d.ahVX), 0);
      return;
    }
    finally
    {
      AppMethodBeat.o(212084);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.d.c
 * JD-Core Version:    0.7.0.1
 */