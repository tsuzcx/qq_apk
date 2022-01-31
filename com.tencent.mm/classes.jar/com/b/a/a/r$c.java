package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$c
  extends r.a
{
  private final long bpA;
  private final String bpz;
  private final int dataType;
  
  private r$c(r paramr, String paramString, long paramLong, int paramInt)
  {
    super(paramr, (byte)0);
    this.bpz = paramString;
    this.bpA = paramLong;
    this.dataType = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(55541);
    for (;;)
    {
      try
      {
        int i = this.dataType;
        switch (i)
        {
        default: 
          AppMethodBeat.o(55541);
          return;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(55541);
        return;
      }
      r.a(tv(), this.bpz, this.bpA);
      AppMethodBeat.o(55541);
      return;
      r.a(tv(), this.bpz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.b.a.a.r.c
 * JD-Core Version:    0.7.0.1
 */