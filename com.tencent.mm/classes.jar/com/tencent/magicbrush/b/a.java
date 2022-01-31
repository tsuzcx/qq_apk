package com.tencent.magicbrush.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
public class a
{
  private static volatile a bLi = null;
  public b bLj;
  
  private a()
  {
    AppMethodBeat.i(115987);
    this.bLj = new a.a(this, (byte)0);
    this.bLj.init();
    AppMethodBeat.o(115987);
  }
  
  public static a yw()
  {
    AppMethodBeat.i(115986);
    if (bLi == null) {
      try
      {
        if (bLi == null) {
          bLi = new a();
        }
        a locala1 = bLi;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(115986);
      }
    }
    a locala2 = bLi;
    AppMethodBeat.o(115986);
    return locala2;
  }
  
  public static abstract interface b
  {
    public abstract Bitmap bP(int paramInt1, int paramInt2);
    
    public abstract void init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.b.a
 * JD-Core Version:    0.7.0.1
 */