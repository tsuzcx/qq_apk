package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class j
  extends a<byte[]>
{
  private static int fYn;
  public static final j oJp;
  
  static
  {
    AppMethodBeat.i(60325);
    oJp = new j();
    fYn = 0;
    AppMethodBeat.o(60325);
  }
  
  public final void O(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(60316);
      super.aG(paramArrayOfByte);
      AppMethodBeat.o(60316);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final long XH()
  {
    AppMethodBeat.i(60318);
    if (fYn <= 0) {
      fYn = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (fYn >= 512)
    {
      AppMethodBeat.o(60318);
      return 41943040L;
    }
    AppMethodBeat.o(60318);
    return 20971520L;
  }
  
  public final long XI()
  {
    return 10485760L;
  }
  
  public final void XJ()
  {
    AppMethodBeat.i(60319);
    super.XJ();
    AppMethodBeat.o(60319);
  }
  
  public final byte[] f(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(60317);
      byte[] arrayOfByte2 = (byte[])super.c(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(60317);
      return arrayOfByte1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.j
 * JD-Core Version:    0.7.0.1
 */