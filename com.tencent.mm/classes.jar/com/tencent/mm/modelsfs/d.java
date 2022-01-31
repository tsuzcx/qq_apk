package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends SFSInputStream
{
  private a fOh;
  
  public d(long paramLong1, long paramLong2)
  {
    super(paramLong1);
    AppMethodBeat.i(93164);
    this.fOh = new a(paramLong2);
    AppMethodBeat.o(93164);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93170);
    super.close();
    if (this.fOh != null) {
      this.fOh.free();
    }
    AppMethodBeat.o(93170);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(93165);
    super.mark(paramInt);
    this.fOh.ajg();
    AppMethodBeat.o(93165);
  }
  
  public final int read()
  {
    AppMethodBeat.i(93167);
    int i = super.read();
    AppMethodBeat.o(93167);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93168);
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(93168);
      return paramInt1;
    }
    this.fOh.y(paramArrayOfByte, paramInt2);
    AppMethodBeat.o(93168);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93166);
    super.reset();
    this.fOh.reset();
    AppMethodBeat.o(93166);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(93169);
    long l = super.skip(paramLong);
    this.fOh.seek(paramLong);
    AppMethodBeat.o(93169);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.d
 * JD-Core Version:    0.7.0.1
 */