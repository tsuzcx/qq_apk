package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.source.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class c$a
  extends c
{
  public final String aRj;
  byte[] result;
  
  public c$a(g paramg, j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
  {
    super(paramg, paramj, paramFormat, paramInt, paramObject, paramArrayOfByte);
    this.aRj = paramString;
  }
  
  public final void d(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(125899);
    this.result = Arrays.copyOf(paramArrayOfByte, paramInt);
    AppMethodBeat.o(125899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c.a
 * JD-Core Version:    0.7.0.1
 */