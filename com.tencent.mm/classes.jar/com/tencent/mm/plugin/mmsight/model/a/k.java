package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class k
  extends a<byte[]>
{
  private static int iuX;
  public static final k vQc;
  
  static
  {
    AppMethodBeat.i(148835);
    vQc = new k();
    iuX = 0;
    AppMethodBeat.o(148835);
  }
  
  public final long ayu()
  {
    AppMethodBeat.i(148828);
    if (iuX <= 0) {
      iuX = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (iuX >= 512)
    {
      AppMethodBeat.o(148828);
      return 41943040L;
    }
    AppMethodBeat.o(148828);
    return 20971520L;
  }
  
  public final long ayv()
  {
    return 10485760L;
  }
  
  public final void ayw()
  {
    AppMethodBeat.i(148829);
    super.ayw();
    AppMethodBeat.o(148829);
  }
  
  public final byte[] g(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(148827);
      byte[] arrayOfByte2 = (byte[])super.d(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(148827);
      return arrayOfByte1;
    }
    finally {}
  }
  
  public final void k(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(148826);
      super.bL(paramArrayOfByte);
      AppMethodBeat.o(148826);
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
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.k
 * JD-Core Version:    0.7.0.1
 */