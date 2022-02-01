package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public class f
  extends a
{
  static final String TAG;
  public static String vxp;
  public static String vxq;
  public int vxr = -1;
  public int vxs = -1;
  public int vxt = -1;
  public long vxu = 0L;
  public long vxv = 0L;
  
  static
  {
    AppMethodBeat.i(22584);
    TAG = f.class.getName();
    vxp = h.vvV;
    vxq = h.vvW;
    AppMethodBeat.o(22584);
  }
  
  public f()
  {
    this.vwn = null;
    this.vwo = 8;
    this.vvH = 1L;
  }
  
  public final byte[] daY()
  {
    AppMethodBeat.i(22583);
    if (this.vxr < 0)
    {
      Log.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(22583);
      return null;
    }
    if (this.vxs >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.vxt >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.vxr >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.vxs >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.vxs >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.vxt >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.vxt >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(22583);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */