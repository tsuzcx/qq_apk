package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a cxO;
  
  static
  {
    AppMethodBeat.i(139954);
    cxO = new a()
    {
      public final int p(String paramAnonymousString, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final Drawable q(String paramAnonymousString, int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(139954);
  }
  
  public static a Hw()
  {
    return cxO;
  }
  
  public static void a(a parama)
  {
    cxO = parama;
  }
  
  public static abstract interface a
  {
    public abstract int p(String paramString, int paramInt);
    
    public abstract Drawable q(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */