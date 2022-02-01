package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ad;

@TargetApi(18)
public class f
  extends a
{
  static final String TAG;
  public static String nSD;
  public static String nSE;
  public int nSF = -1;
  public int nSG = -1;
  public int nSH = -1;
  public long nSI = 0L;
  public long nSJ = 0L;
  
  static
  {
    AppMethodBeat.i(22584);
    TAG = f.class.getName();
    nSD = h.nRj;
    nSE = h.nRk;
    AppMethodBeat.o(22584);
  }
  
  public f()
  {
    this.nRB = null;
    this.nRC = 8;
    this.nQV = 1L;
  }
  
  public final byte[] bMO()
  {
    AppMethodBeat.i(22583);
    if (this.nSF < 0)
    {
      ad.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(22583);
      return null;
    }
    if (this.nSG >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.nSH >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.nSF >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.nSG >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.nSG >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.nSH >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.nSH >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(22583);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */