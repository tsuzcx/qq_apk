package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class g
  extends FilterInputStream
{
  private int aMk = -2147483648;
  
  public g(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long q(long paramLong)
  {
    long l;
    if (this.aMk == 0) {
      l = -1L;
    }
    do
    {
      do
      {
        return l;
        l = paramLong;
      } while (this.aMk == -2147483648);
      l = paramLong;
    } while (paramLong <= this.aMk);
    return this.aMk;
  }
  
  private void r(long paramLong)
  {
    if ((this.aMk != -2147483648) && (paramLong != -1L)) {
      this.aMk = ((int)(this.aMk - paramLong));
    }
  }
  
  public final int available()
  {
    AppMethodBeat.i(77760);
    if (this.aMk == -2147483648)
    {
      i = super.available();
      AppMethodBeat.o(77760);
      return i;
    }
    int i = Math.min(this.aMk, super.available());
    AppMethodBeat.o(77760);
    return i;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(77755);
      super.mark(paramInt);
      this.aMk = paramInt;
      AppMethodBeat.o(77755);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int read()
  {
    AppMethodBeat.i(77756);
    if (q(1L) == -1L)
    {
      AppMethodBeat.o(77756);
      return -1;
    }
    int i = super.read();
    r(1L);
    AppMethodBeat.o(77756);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77757);
    paramInt2 = (int)q(paramInt2);
    if (paramInt2 == -1)
    {
      AppMethodBeat.o(77757);
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    r(paramInt1);
    AppMethodBeat.o(77757);
    return paramInt1;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(77758);
      super.reset();
      this.aMk = -2147483648;
      AppMethodBeat.o(77758);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(77759);
    paramLong = q(paramLong);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(77759);
      return 0L;
    }
    paramLong = super.skip(paramLong);
    r(paramLong);
    AppMethodBeat.o(77759);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.g
 * JD-Core Version:    0.7.0.1
 */