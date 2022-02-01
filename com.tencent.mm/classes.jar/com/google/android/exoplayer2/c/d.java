package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class d
  implements m
{
  public final int a(f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91974);
    paramInt = paramf.ht(paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(91974);
        return -1;
      }
      paramf = new EOFException();
      AppMethodBeat.o(91974);
      throw paramf;
    }
    AppMethodBeat.o(91974);
    return paramInt;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, m.a parama) {}
  
  public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(91975);
    paramm.iH(paramInt);
    AppMethodBeat.o(91975);
  }
  
  public final void f(Format paramFormat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d
 * JD-Core Version:    0.7.0.1
 */