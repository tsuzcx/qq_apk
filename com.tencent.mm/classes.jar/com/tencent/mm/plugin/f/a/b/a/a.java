package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Serializable;

public abstract class a
  implements Serializable
{
  private static final String TAG = a.class.getName();
  public long hUQ;
  public String hVw;
  public int hVx;
  
  public static a Z(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      y.e(TAG, "data input error");
      return null;
    }
    paramArrayOfByte = b.at(paramArrayOfByte);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof a))) {
      return (a)paramArrayOfByte;
    }
    y.e(TAG, "bytes2object is not instanceof BaseProfileParser");
    return null;
  }
  
  public abstract byte[] awy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */