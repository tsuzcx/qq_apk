package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;

public abstract class a
  implements Serializable
{
  private static final String TAG = a.class.getName();
  public long phx;
  public String pie;
  public int pif;
  
  public static a aX(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e(TAG, "data input error");
      return null;
    }
    paramArrayOfByte = b.bz(paramArrayOfByte);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof a))) {
      return (a)paramArrayOfByte;
    }
    Log.e(TAG, "bytes2object is not instanceof BaseProfileParser");
    return null;
  }
  
  public abstract byte[] ckM();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */