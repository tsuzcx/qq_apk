package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.mm.plugin.f.a.b.h;

public class e
  extends a
{
  static final String TAG = e.class.getName();
  public static final String hWm = h.hVg;
  public static final String hWn = h.hVh;
  public static final String hWo = h.hVi;
  public static final String hWp = h.hVj;
  public byte hWq = 0;
  public byte hWr = 0;
  public byte hWs = 0;
  public byte hWt = 0;
  public byte[] hWu = { 0, 0 };
  public int hWv = -1;
  public byte hWw = 0;
  public byte hWx = 0;
  public byte[] hWy = null;
  
  public e()
  {
    this.hVw = null;
    this.hVx = 8;
    this.hUQ = 16L;
  }
  
  public final byte[] awy()
  {
    Object localObject;
    if (this.hVw.equalsIgnoreCase(hWm))
    {
      localObject = new byte[3];
      System.arraycopy(Byte.valueOf(this.hWq), 0, localObject, 0, 1);
      System.arraycopy(Byte.valueOf(this.hWr), 0, localObject, 1, 1);
      System.arraycopy(Byte.valueOf(this.hWs), 0, localObject, 2, 1);
    }
    byte[] arrayOfByte;
    do
    {
      return localObject;
      if (this.hVw.equalsIgnoreCase(hWn))
      {
        localObject = new byte[1];
        System.arraycopy(Byte.valueOf(this.hWt), 0, localObject, 0, 1);
        return localObject;
      }
      if (!this.hVw.equalsIgnoreCase(hWp)) {
        break;
      }
      arrayOfByte = new byte[this.hWv];
      byte b1 = (byte)(this.hWv & 0xFF);
      byte b2 = (byte)(this.hWv >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.hWw), 0, arrayOfByte, 2, 1);
      localObject = arrayOfByte;
    } while (this.hWv <= 3);
    System.arraycopy(this.hWy, 0, arrayOfByte, 3, this.hWv - 3);
    return arrayOfByte;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */