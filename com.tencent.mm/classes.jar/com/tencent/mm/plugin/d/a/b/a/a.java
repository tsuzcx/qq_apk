package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.Serializable;

public abstract class a
  implements Serializable
{
  private static final String TAG = a.class.getName();
  public long nWB;
  public String nXh;
  public int nXi;
  
  public static a aG(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ae.e(TAG, "data input error");
      return null;
    }
    paramArrayOfByte = b.bi(paramArrayOfByte);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof a))) {
      return (a)paramArrayOfByte;
    }
    ae.e(TAG, "bytes2object is not instanceof BaseProfileParser");
    return null;
  }
  
  public abstract byte[] bNM();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */