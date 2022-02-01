package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class e
{
  public static final boolean a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(943);
    int i = 0;
    for (;;)
    {
      if (i >= paramInt)
      {
        AppMethodBeat.o(943);
        return true;
      }
      int j = paramInputStream.read(paramArrayOfByte, i + 0, paramInt - i);
      if (j < 0)
      {
        AppMethodBeat.o(943);
        return false;
      }
      i += j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.e
 * JD-Core Version:    0.7.0.1
 */