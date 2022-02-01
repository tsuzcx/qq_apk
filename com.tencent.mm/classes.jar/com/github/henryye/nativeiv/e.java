package com.github.henryye.nativeiv;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
public class e
{
  private static volatile e baJ = null;
  b baK;
  
  private e()
  {
    AppMethodBeat.i(127355);
    this.baK = new a((byte)0);
    this.baK.init();
    AppMethodBeat.o(127355);
  }
  
  public static e sR()
  {
    AppMethodBeat.i(127354);
    if (baJ == null) {
      try
      {
        if (baJ == null) {
          baJ = new e();
        }
        e locale1 = baJ;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(127354);
      }
    }
    e locale2 = baJ;
    AppMethodBeat.o(127354);
    return locale2;
  }
  
  final class a
    implements e.b
  {
    private a() {}
    
    public final Bitmap aX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(127353);
      b.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      AppMethodBeat.o(127353);
      return localBitmap;
    }
    
    public final void init()
    {
      AppMethodBeat.i(127352);
      b.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
      AppMethodBeat.o(127352);
    }
  }
  
  public static abstract interface b
  {
    public abstract Bitmap aX(int paramInt1, int paramInt2);
    
    public abstract void init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.e
 * JD-Core Version:    0.7.0.1
 */