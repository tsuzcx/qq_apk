package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;

public final class i
  extends a
{
  public i(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  public static e b(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117855);
    paramRandomAccessFile = (e)c.a(paramRandomAccessFile, paramArrayOfByte, a.aET);
    AppMethodBeat.o(117855);
    return paramRandomAccessFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.a.i
 * JD-Core Version:    0.7.0.1
 */