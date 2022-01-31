package com.tencent.magicbrush.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.a.d.f;

@SuppressLint({"LongLogTag"})
public class a
{
  private static volatile a bmk = null;
  public b bml = new a((byte)0);
  
  private a()
  {
    this.bml.init();
  }
  
  public static a qN()
  {
    if (bmk == null) {
      try
      {
        if (bmk == null) {
          bmk = new a();
        }
        a locala = bmk;
        return locala;
      }
      finally {}
    }
    return bmk;
  }
  
  private final class a
    implements a.b
  {
    private a() {}
    
    public final Bitmap aS(int paramInt1, int paramInt2)
    {
      d.f.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
      return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    
    public final void init()
    {
      d.f.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
    }
  }
  
  public static abstract interface b
  {
    public abstract Bitmap aS(int paramInt1, int paramInt2);
    
    public abstract void init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.b.a
 * JD-Core Version:    0.7.0.1
 */