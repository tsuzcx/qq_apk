package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
  extends a<byte[]>
{
  public static final g ity;
  
  static
  {
    AppMethodBeat.i(156423);
    ity = new g();
    AppMethodBeat.o(156423);
  }
  
  protected final long aRP()
  {
    return 5242880L;
  }
  
  protected final long aRQ()
  {
    return 1048576L;
  }
  
  public final void k(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(156418);
      Arrays.fill(paramArrayOfByte, (byte)0);
      super.bU(paramArrayOfByte);
      AppMethodBeat.o(156418);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.g
 * JD-Core Version:    0.7.0.1
 */