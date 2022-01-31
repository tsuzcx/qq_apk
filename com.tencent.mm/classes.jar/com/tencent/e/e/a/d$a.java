package com.tencent.e.e.a;

import android.content.Context;
import com.tencent.e.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
{
  int Bkw;
  public long Bkx;
  int action;
  Context context;
  int requestType;
  long yoo;
  
  private d$a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114534);
    this.requestType = 0;
    this.Bkw = 0;
    this.action = 0;
    this.Bkx = (f.BkP * 12L);
    this.yoo = 0L;
    if (paramInt1 < 0)
    {
      paramContext = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(114534);
      throw paramContext;
    }
    this.context = paramContext.getApplicationContext();
    this.Bkw = paramInt1;
    this.action = paramInt2;
    AppMethodBeat.o(114534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.d.a
 * JD-Core Version:    0.7.0.1
 */