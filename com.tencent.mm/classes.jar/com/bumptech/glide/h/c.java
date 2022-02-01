package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c
  extends FilterInputStream
{
  private final long aNU;
  private int aNV;
  
  private c(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.aNU = paramLong;
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong)
  {
    AppMethodBeat.i(77728);
    paramInputStream = new c(paramInputStream, paramLong);
    AppMethodBeat.o(77728);
    return paramInputStream;
  }
  
  private int dv(int paramInt)
  {
    AppMethodBeat.i(77733);
    if (paramInt >= 0) {
      this.aNV += paramInt;
    }
    while (this.aNU - this.aNV <= 0L)
    {
      AppMethodBeat.o(77733);
      return paramInt;
    }
    IOException localIOException = new IOException("Failed to read all expected data, expected: " + this.aNU + ", but read: " + this.aNV);
    AppMethodBeat.o(77733);
    throw localIOException;
  }
  
  public final int available()
  {
    try
    {
      AppMethodBeat.i(77729);
      int i = (int)Math.max(this.aNU - this.aNV, this.in.available());
      AppMethodBeat.o(77729);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final int read()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 80
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 82	java/io/FilterInputStream:read	()I
    //   11: istore_2
    //   12: iload_2
    //   13: iflt +20 -> 33
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: iload_1
    //   20: invokespecial 84	com/bumptech/glide/h/c:dv	(I)I
    //   23: pop
    //   24: ldc 80
    //   26: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_m1
    //   34: istore_1
    //   35: goto -17 -> 18
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	c
    //   17	18	1	i	int
    //   11	21	2	j	int
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	38	finally
    //   18	29	38	finally
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77731);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(77731);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(77732);
      paramInt1 = dv(super.read(paramArrayOfByte, paramInt1, paramInt2));
      AppMethodBeat.o(77732);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.c
 * JD-Core Version:    0.7.0.1
 */