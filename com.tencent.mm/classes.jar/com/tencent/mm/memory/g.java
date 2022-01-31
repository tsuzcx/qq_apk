package com.tencent.mm.memory;

import java.util.Arrays;

public final class g
  extends a<byte[]>
{
  public static final g dPb = new g();
  
  protected final long ER()
  {
    return 5242880L;
  }
  
  protected final long ES()
  {
    return 1048576L;
  }
  
  public final void z(byte[] paramArrayOfByte)
  {
    try
    {
      Arrays.fill(paramArrayOfByte, (byte)0);
      super.ar(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.memory.g
 * JD-Core Version:    0.7.0.1
 */