package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;

public final class p
  extends a
{
  public g iUw;
  public d iUx;
  
  public p(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  public static g b(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133892);
    paramRandomAccessFile = (g)c.a(paramRandomAccessFile, paramArrayOfByte, a.bls);
    AppMethodBeat.o(133892);
    return paramRandomAccessFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.p
 * JD-Core Version:    0.7.0.1
 */