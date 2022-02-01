package com.tencent.mm.plugin.mmsight.model.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  extends a<byte[]>
{
  public static final j KXq;
  private static int pch;
  
  static
  {
    AppMethodBeat.i(148835);
    KXq = new j();
    pch = 0;
    AppMethodBeat.o(148835);
  }
  
  public final void as(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(148826);
      super.dn(paramArrayOfByte);
      AppMethodBeat.o(148826);
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
    AppMethodBeat.i(148828);
    if (pch <= 0) {
      pch = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (pch >= 512)
    {
      AppMethodBeat.o(148828);
      return 41943040L;
    }
    AppMethodBeat.o(148828);
    return 20971520L;
  }
  
  public final long bvF()
  {
    return 10485760L;
  }
  
  public final void bvG()
  {
    AppMethodBeat.i(148829);
    super.bvG();
    AppMethodBeat.o(148829);
  }
  
  public final byte[] m(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(148827);
      byte[] arrayOfByte2 = (byte[])super.h(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      AppMethodBeat.o(148827);
      return arrayOfByte1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.j
 * JD-Core Version:    0.7.0.1
 */