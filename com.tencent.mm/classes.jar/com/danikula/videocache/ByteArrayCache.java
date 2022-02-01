package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class ByteArrayCache
  implements Cache
{
  private volatile boolean completed;
  private volatile byte[] data;
  
  public ByteArrayCache()
  {
    this(new byte[0]);
    AppMethodBeat.i(192465);
    AppMethodBeat.o(192465);
  }
  
  public ByteArrayCache(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192466);
    this.data = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    AppMethodBeat.o(192466);
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(192468);
    Preconditions.checkNotNull(this.data);
    if ((paramInt >= 0) && (paramInt <= paramArrayOfByte.length)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      byte[] arrayOfByte = Arrays.copyOf(this.data, this.data.length + paramInt);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.data.length, paramInt);
      this.data = arrayOfByte;
      AppMethodBeat.o(192468);
      return;
    }
  }
  
  public long available()
  {
    return this.data.length;
  }
  
  public void close() {}
  
  public void complete()
  {
    this.completed = true;
  }
  
  public boolean isCompleted()
  {
    return this.completed;
  }
  
  public int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(192467);
    if (paramLong >= this.data.length)
    {
      AppMethodBeat.o(192467);
      return -1;
    }
    if (paramLong > 2147483647L)
    {
      paramArrayOfByte = new IllegalArgumentException("Too long offset for memory cache ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(192467);
      throw paramArrayOfByte;
    }
    paramInt = new ByteArrayInputStream(this.data).read(paramArrayOfByte, (int)paramLong, paramInt);
    AppMethodBeat.o(192467);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.ByteArrayCache
 * JD-Core Version:    0.7.0.1
 */