package com.tencent.mm.plugin.ext.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static SparseArray<byte[]> mfi;
  
  static
  {
    AppMethodBeat.i(20416);
    mfi = new SparseArray(1);
    AppMethodBeat.o(20416);
  }
  
  private static int aS(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  static c btN()
  {
    AppMethodBeat.i(20414);
    d.a locala = new d.a();
    AppMethodBeat.o(20414);
    return locala;
  }
  
  static abstract interface c
  {
    public abstract d.b aM(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d
 * JD-Core Version:    0.7.0.1
 */