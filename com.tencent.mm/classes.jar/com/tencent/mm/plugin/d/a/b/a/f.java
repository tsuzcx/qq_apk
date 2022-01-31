package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(18)
public class f
  extends a
{
  static final String TAG;
  public static String jQs;
  public static String jQt;
  public int jQu = -1;
  public int jQv = -1;
  public int jQw = -1;
  public long jQx = 0L;
  public long jQy = 0L;
  
  static
  {
    AppMethodBeat.i(18473);
    TAG = f.class.getName();
    jQs = h.jOY;
    jQt = h.jOZ;
    AppMethodBeat.o(18473);
  }
  
  public f()
  {
    this.jPq = null;
    this.jPr = 8;
    this.jOK = 1L;
  }
  
  public final byte[] aWb()
  {
    AppMethodBeat.i(18472);
    if (this.jQu < 0)
    {
      ab.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(18472);
      return null;
    }
    if (this.jQv >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.jQw >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.jQu >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.jQv >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.jQv >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.jQw >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.jQw >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(18472);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */