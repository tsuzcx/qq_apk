package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
  extends a<byte[]>
{
  public static final g fdI;
  
  static
  {
    AppMethodBeat.i(115377);
    fdI = new g();
    AppMethodBeat.o(115377);
  }
  
  public final void O(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(115372);
      Arrays.fill(paramArrayOfByte, (byte)0);
      super.aG(paramArrayOfByte);
      AppMethodBeat.o(115372);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  protected final long XH()
  {
    return 5242880L;
  }
  
  protected final long XI()
  {
    return 1048576L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.memory.g
 * JD-Core Version:    0.7.0.1
 */