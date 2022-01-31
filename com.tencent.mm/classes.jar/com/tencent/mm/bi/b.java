package com.tencent.mm.bi;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<byte[]>
{
  public static final b eIx = new b();
  private static int eIy = 0;
  
  protected final long ER()
  {
    if (eIy <= 0) {
      eIy = ((ActivityManager)ae.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (eIy >= 512) {
      return 41943040L;
    }
    return 20971520L;
  }
  
  protected final long ES()
  {
    return 10485760L;
  }
  
  public final void ET()
  {
    super.ET();
  }
  
  public final byte[] f(Integer paramInteger)
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])super.c(paramInteger);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = new byte[paramInteger.intValue()];
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  public final void z(byte[] paramArrayOfByte)
  {
    try
    {
      super.ar(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bi.b
 * JD-Core Version:    0.7.0.1
 */