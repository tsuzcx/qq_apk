package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class f
  extends a<byte[]>
{
  public static final f nNs;
  
  static
  {
    AppMethodBeat.i(156423);
    nNs = new f();
    AppMethodBeat.o(156423);
  }
  
  public final void as(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(156418);
      Arrays.fill(paramArrayOfByte, (byte)0);
      super.dn(paramArrayOfByte);
      AppMethodBeat.o(156418);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  protected final long bvE()
  {
    return 5242880L;
  }
  
  protected final long bvF()
  {
    return 1048576L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.f
 * JD-Core Version:    0.7.0.1
 */