package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(18)
public class f
  extends a
{
  static final String TAG;
  public static String pjh;
  public static String pji;
  public int pjj = -1;
  public int pjk = -1;
  public int pjl = -1;
  public long pjm = 0L;
  public long pjn = 0L;
  
  static
  {
    AppMethodBeat.i(22584);
    TAG = f.class.getName();
    pjh = h.phL;
    pji = h.phM;
    AppMethodBeat.o(22584);
  }
  
  public f()
  {
    this.pie = null;
    this.pif = 8;
    this.phx = 1L;
  }
  
  public final byte[] ckM()
  {
    AppMethodBeat.i(22583);
    if (this.pjj < 0)
    {
      Log.e(TAG, "stepCount is invalid");
      AppMethodBeat.o(22583);
      return null;
    }
    if (this.pjk >= 0) {}
    for (int i = 7;; i = 4)
    {
      int j = i;
      if (this.pjl >= 0) {
        j = i + 3;
      }
      byte[] arrayOfByte = new byte[j];
      arrayOfByte[0] = 1;
      j = 0;
      i = 1;
      while (j < 3)
      {
        arrayOfByte[i] = ((byte)(this.pjj >> j * 8 & 0xFF));
        i += 1;
        j += 1;
      }
      j = i;
      int k;
      if (this.pjk >= 0)
      {
        arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x2));
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          arrayOfByte[i] = ((byte)(this.pjk >> k * 8 & 0xFF));
          i += 1;
          k += 1;
        }
      }
      if (this.pjl >= 0)
      {
        arrayOfByte[0] = 4;
        k = 0;
        i = j;
        j = k;
        while (j < 3)
        {
          arrayOfByte[i] = ((byte)(this.pjl >> j * 8 & 0xFF));
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