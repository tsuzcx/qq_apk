package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class d
  implements m
{
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94859);
    paramInt = paramf.df(paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(94859);
        return -1;
      }
      paramf = new EOFException();
      AppMethodBeat.o(94859);
      throw paramf;
    }
    AppMethodBeat.o(94859);
    return paramInt;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, m.a parama) {}
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(94860);
    paramm.en(paramInt);
    AppMethodBeat.o(94860);
  }
  
  public final void f(Format paramFormat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d
 * JD-Core Version:    0.7.0.1
 */