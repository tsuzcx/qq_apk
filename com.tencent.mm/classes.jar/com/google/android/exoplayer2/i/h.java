package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class h
{
  private long[] baR;
  public int size;
  
  public h()
  {
    this((byte)0);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(95876);
    this.baR = new long[32];
    AppMethodBeat.o(95876);
  }
  
  public final void add(long paramLong)
  {
    AppMethodBeat.i(95877);
    if (this.size == this.baR.length) {
      this.baR = Arrays.copyOf(this.baR, this.size * 2);
    }
    long[] arrayOfLong = this.baR;
    int i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
    AppMethodBeat.o(95877);
  }
  
  public final long get(int paramInt)
  {
    AppMethodBeat.i(95878);
    if ((paramInt < 0) || (paramInt >= this.size))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("Invalid index " + paramInt + ", size is " + this.size);
      AppMethodBeat.o(95878);
      throw localIndexOutOfBoundsException;
    }
    long l = this.baR[paramInt];
    AppMethodBeat.o(95878);
    return l;
  }
  
  public final long[] toArray()
  {
    AppMethodBeat.i(95879);
    long[] arrayOfLong = Arrays.copyOf(this.baR, this.size);
    AppMethodBeat.o(95879);
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.h
 * JD-Core Version:    0.7.0.1
 */