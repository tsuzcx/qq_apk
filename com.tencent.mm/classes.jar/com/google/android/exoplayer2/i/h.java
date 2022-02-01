package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class h
{
  private long[] bqO;
  public int size;
  
  public h()
  {
    this((byte)0);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(93136);
    this.bqO = new long[32];
    AppMethodBeat.o(93136);
  }
  
  public final void add(long paramLong)
  {
    AppMethodBeat.i(93137);
    if (this.size == this.bqO.length) {
      this.bqO = Arrays.copyOf(this.bqO, this.size * 2);
    }
    long[] arrayOfLong = this.bqO;
    int i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
    AppMethodBeat.o(93137);
  }
  
  public final long get(int paramInt)
  {
    AppMethodBeat.i(93138);
    if ((paramInt < 0) || (paramInt >= this.size))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("Invalid index " + paramInt + ", size is " + this.size);
      AppMethodBeat.o(93138);
      throw localIndexOutOfBoundsException;
    }
    long l = this.bqO[paramInt];
    AppMethodBeat.o(93138);
    return l;
  }
  
  public final long[] vb()
  {
    AppMethodBeat.i(93139);
    long[] arrayOfLong = Arrays.copyOf(this.bqO, this.size);
    AppMethodBeat.o(93139);
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.h
 * JD-Core Version:    0.7.0.1
 */