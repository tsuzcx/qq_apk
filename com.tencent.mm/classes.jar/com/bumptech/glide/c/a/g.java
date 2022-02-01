package com.bumptech.glide.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class g
  extends FilterInputStream
{
  private static final byte[] aDx = { -1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0 };
  private static final int aDy = 29;
  private static final int aDz = 31;
  private final byte aDA;
  private int position;
  
  public g(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    AppMethodBeat.i(76879);
    if ((paramInt < -1) || (paramInt > 8))
    {
      paramInputStream = new IllegalArgumentException("Cannot add invalid orientation: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(76879);
      throw paramInputStream;
    }
    this.aDA = ((byte)paramInt);
    AppMethodBeat.o(76879);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(76880);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(76880);
    throw localUnsupportedOperationException;
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  public final int read()
  {
    AppMethodBeat.i(76881);
    int i;
    if ((this.position < 2) || (this.position > aDz)) {
      i = super.read();
    }
    for (;;)
    {
      if (i != -1) {
        this.position += 1;
      }
      AppMethodBeat.o(76881);
      return i;
      if (this.position == aDz) {
        i = this.aDA;
      } else {
        i = aDx[(this.position - 2)] & 0xFF;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76882);
    if (this.position > aDz) {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      if (paramInt1 > 0) {
        this.position += paramInt1;
      }
      AppMethodBeat.o(76882);
      return paramInt1;
      if (this.position == aDz)
      {
        paramArrayOfByte[paramInt1] = this.aDA;
        paramInt1 = 1;
      }
      else if (this.position < 2)
      {
        paramInt1 = super.read(paramArrayOfByte, paramInt1, 2 - this.position);
      }
      else
      {
        paramInt2 = Math.min(aDz - this.position, paramInt2);
        System.arraycopy(aDx, this.position - 2, paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 = paramInt2;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76884);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(76884);
    throw localUnsupportedOperationException;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(76883);
    paramLong = super.skip(paramLong);
    if (paramLong > 0L) {
      this.position = ((int)(this.position + paramLong));
    }
    AppMethodBeat.o(76883);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.g
 * JD-Core Version:    0.7.0.1
 */