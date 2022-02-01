package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.Serializable;

public abstract class a
  implements Serializable
{
  private static final String TAG = a.class.getName();
  public long nQV;
  public String nRB;
  public int nRC;
  
  public static a aG(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ad.e(TAG, "data input error");
      return null;
    }
    paramArrayOfByte = b.bj(paramArrayOfByte);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof a))) {
      return (a)paramArrayOfByte;
    }
    ad.e(TAG, "bytes2object is not instanceof BaseProfileParser");
    return null;
  }
  
  public abstract byte[] bMO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */