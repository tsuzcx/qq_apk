package com.github.henryye.nativeiv;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
public class e
{
  private static volatile e baN = null;
  b baO;
  
  private e()
  {
    AppMethodBeat.i(127355);
    this.baO = new a((byte)0);
    this.baO.init();
    AppMethodBeat.o(127355);
  }
  
  public static e sO()
  {
    AppMethodBeat.i(127354);
    if (baN == null) {
      try
      {
        if (baN == null) {
          baN = new e();
        }
        e locale1 = baN;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(127354);
      }
    }
    e locale2 = baN;
    AppMethodBeat.o(127354);
    return locale2;
  }
  
  final class a
    implements e.b
  {
    private a() {}
    
    public final Bitmap bd(int paramInt1, int paramInt2)
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
    public abstract Bitmap bd(int paramInt1, int paramInt2);
    
    public abstract void init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.e
 * JD-Core Version:    0.7.0.1
 */