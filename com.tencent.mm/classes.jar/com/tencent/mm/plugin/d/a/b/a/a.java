package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.Serializable;

public abstract class a
  implements Serializable
{
  private static final String TAG = a.class.getName();
  public long npZ;
  public String nqF;
  public int nqG;
  
  public static a aG(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ac.e(TAG, "data input error");
      return null;
    }
    paramArrayOfByte = b.bg(paramArrayOfByte);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof a))) {
      return (a)paramArrayOfByte;
    }
    ac.e(TAG, "bytes2object is not instanceof BaseProfileParser");
    return null;
  }
  
  public abstract byte[] bIB();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */