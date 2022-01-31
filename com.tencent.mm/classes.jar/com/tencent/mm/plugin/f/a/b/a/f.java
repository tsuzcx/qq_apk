package com.tencent.mm.plugin.f.a.b.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.f.a.b.h;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(18)
public class f
  extends a
{
  static final String TAG = f.class.getName();
  public static String hWA = h.hVf;
  public static String hWz = h.hVe;
  public int hWB = -1;
  public int hWC = -1;
  public int hWD = -1;
  public long hWE = 0L;
  public long hWF = 0L;
  
  public f()
  {
    this.hVw = null;
    this.hVx = 8;
    this.hUQ = 1L;
  }
  
  public final byte[] awy()
  {
    if (this.hWB < 0)
    {
      y.e(TAG, "stepCount is invalid");
      return null;
    }
    if (this.hWC >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.hWD >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.hWB >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.hWC >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.hWC >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.hWD >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.hWD >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */