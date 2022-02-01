package com.tencent.mm.plugin.f.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(18)
public class f
  extends a
{
  static final String TAG;
  public static String slq;
  public static String slr;
  public int sls = -1;
  public int slt = -1;
  public int slu = -1;
  public long slv = 0L;
  public long slw = 0L;
  
  static
  {
    AppMethodBeat.i(22584);
    TAG = f.class.getName();
    slq = h.sjW;
    slr = h.sjX;
    AppMethodBeat.o(22584);
  }
  
  public f()
  {
    this.sko = null;
    this.skp = 8;
    this.sjI = 1L;
  }
  
  public final byte[] cyh()
  {
    AppMethodBeat.i(22583);
    if (this.sls < 0)
    {
      Log.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(22583);
      return null;
    }
    if (this.slt >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.slu >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.sls >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.slt >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.slt >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.slu >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.slu >> j * 8 & 0xFF));
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(22583);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */