package com.tencent.mm.bk;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
  extends a<byte[]>
{
  public static final b ixQ;
  private static int ixR;
  
  static
  {
    AppMethodBeat.i(127065);
    ixQ = new b();
    ixR = 0;
    AppMethodBeat.o(127065);
  }
  
  public final long ayJ()
  {
    AppMethodBeat.i(127058);
    if (ixR <= 0) {
      ixR = ((ActivityManager)ak.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (ixR >= 512)
    {
      AppMethodBeat.o(127058);
      return 41943040L;
    }
    AppMethodBeat.o(127058);
    return 20971520L;
  }
  
  public final long ayK()
  {
    return 10485760L;
  }
  
  public final void ayL()
  {
    AppMethodBeat.i(127059);
    super.ayL();
    AppMethodBeat.o(127059);
  }
  
  public final byte[] h(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(127057);
      byte[] arrayOfByte2 = (byte[])super.e(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(127057);
      return arrayOfByte1;
    }
    finally {}
  }
  
  public final void k(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(127056);
      super.bL(paramArrayOfByte);
      AppMethodBeat.o(127056);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bk.b
 * JD-Core Version:    0.7.0.1
 */