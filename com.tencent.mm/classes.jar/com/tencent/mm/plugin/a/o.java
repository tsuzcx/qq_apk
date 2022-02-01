package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;

public final class o
  extends a
{
  public f hYq;
  public d hYr;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  public static f b(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133892);
    paramRandomAccessFile = (f)c.a(paramRandomAccessFile, paramArrayOfByte, a.bal);
    AppMethodBeat.o(133892);
    return paramRandomAccessFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */