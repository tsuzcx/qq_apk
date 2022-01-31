package com.tencent.mm.bj;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
  extends a<byte[]>
{
  public static final b fYm;
  private static int fYn;
  
  static
  {
    AppMethodBeat.i(50895);
    fYm = new b();
    fYn = 0;
    AppMethodBeat.o(50895);
  }
  
  public final void O(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(50886);
      super.aG(paramArrayOfByte);
      AppMethodBeat.o(50886);
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
    AppMethodBeat.i(50888);
    if (fYn <= 0) {
      fYn = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (fYn >= 512)
    {
      AppMethodBeat.o(50888);
      return 41943040L;
    }
    AppMethodBeat.o(50888);
    return 20971520L;
  }
  
  public final long XI()
  {
    return 10485760L;
  }
  
  public final void XJ()
  {
    AppMethodBeat.i(50889);
    super.XJ();
    AppMethodBeat.o(50889);
  }
  
  public final byte[] f(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(50887);
      byte[] arrayOfByte2 = (byte[])super.c(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(50887);
      return arrayOfByte1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bj.b
 * JD-Core Version:    0.7.0.1
 */