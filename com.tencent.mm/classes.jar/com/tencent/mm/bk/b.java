package com.tencent.mm.bk;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends a<byte[]>
{
  public static final b ibA;
  private static int ibB;
  
  static
  {
    AppMethodBeat.i(127065);
    ibA = new b();
    ibB = 0;
    AppMethodBeat.o(127065);
  }
  
  public final long avH()
  {
    AppMethodBeat.i(127058);
    if (ibB <= 0) {
      ibB = ((ActivityManager)ai.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (ibB >= 512)
    {
      AppMethodBeat.o(127058);
      return 41943040L;
    }
    AppMethodBeat.o(127058);
    return 20971520L;
  }
  
  public final long avI()
  {
    return 10485760L;
  }
  
  public final void avJ()
  {
    AppMethodBeat.i(127059);
    super.avJ();
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
      super.bJ(paramArrayOfByte);
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