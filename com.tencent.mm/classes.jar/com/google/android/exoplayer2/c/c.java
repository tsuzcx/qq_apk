package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.j;
import java.io.EOFException;

public final class c
  implements k
{
  public final int a(e parame, int paramInt, boolean paramBoolean)
  {
    paramInt = parame.cK(paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    return paramInt;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, k.a parama) {}
  
  public final void a(j paramj, int paramInt)
  {
    paramj.dB(paramInt);
  }
  
  public final void f(Format paramFormat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c
 * JD-Core Version:    0.7.0.1
 */