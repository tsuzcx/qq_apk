package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a cNp;
  
  static
  {
    AppMethodBeat.i(139954);
    cNp = new a()
    {
      public final int A(String paramAnonymousString, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final Drawable B(String paramAnonymousString, int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(139954);
  }
  
  public static a Vd()
  {
    return cNp;
  }
  
  public static void a(a parama)
  {
    cNp = parama;
  }
  
  public static abstract interface a
  {
    public abstract int A(String paramString, int paramInt);
    
    public abstract Drawable B(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */