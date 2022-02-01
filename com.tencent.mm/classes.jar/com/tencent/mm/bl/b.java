package com.tencent.mm.bl;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  extends a<byte[]>
{
  public static final b iuW;
  private static int iuX;
  
  static
  {
    AppMethodBeat.i(127065);
    iuW = new b();
    iuX = 0;
    AppMethodBeat.o(127065);
  }
  
  public final long ayu()
  {
    AppMethodBeat.i(127058);
    if (iuX <= 0) {
      iuX = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (iuX >= 512)
    {
      AppMethodBeat.o(127058);
      return 41943040L;
    }
    AppMethodBeat.o(127058);
    return 20971520L;
  }
  
  public final long ayv()
  {
    return 10485760L;
  }
  
  public final void ayw()
  {
    AppMethodBeat.i(127059);
    super.ayw();
    AppMethodBeat.o(127059);
  }
  
  public final byte[] g(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(127057);
      byte[] arrayOfByte2 = (byte[])super.d(paramInteger);
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
 * Qualified Name:     com.tencent.mm.bl.b
 * JD-Core Version:    0.7.0.1
 */