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
  public static String mPv;
  public static String mPw;
  public long mPA = 0L;
  public long mPB = 0L;
  public int mPx = -1;
  public int mPy = -1;
  public int mPz = -1;
  
  static
  {
    AppMethodBeat.i(22584);
    TAG = f.class.getName();
    mPv = h.mOb;
    mPw = h.mOc;
    AppMethodBeat.o(22584);
  }
  
  public f()
  {
    this.mOt = null;
    this.mOu = 8;
    this.mNN = 1L;
  }
  
  public final byte[] bBD()
  {
    AppMethodBeat.i(22583);
    if (this.mPx < 0)
    {
      ad.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(22583);
      return null;
    }
    if (this.mPy >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.mPz >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.mPx >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.mPy >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.mPy >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.mPz >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.mPz >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(22583);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */