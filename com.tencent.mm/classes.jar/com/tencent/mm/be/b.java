package com.tencent.mm.be;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends a<byte[]>
{
  public static final b pcg;
  private static int pch;
  
  static
  {
    AppMethodBeat.i(127065);
    pcg = new b();
    pch = 0;
    AppMethodBeat.o(127065);
  }
  
  public final void as(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(127056);
      super.dn(paramArrayOfByte);
      AppMethodBeat.o(127056);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final long bvE()
  {
    AppMethodBeat.i(127058);
    if (pch <= 0) {
      pch = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (pch >= 512)
    {
      AppMethodBeat.o(127058);
      return 41943040L;
    }
    AppMethodBeat.o(127058);
    return 20971520L;
  }
  
  public final long bvF()
  {
    return 10485760L;
  }
  
  public final void bvG()
  {
    AppMethodBeat.i(127059);
    super.bvG();
    AppMethodBeat.o(127059);
  }
  
  public final byte[] m(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(127057);
      byte[] arrayOfByte2 = (byte[])super.h(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(127057);
      return arrayOfByte1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.b
 * JD-Core Version:    0.7.0.1
 */