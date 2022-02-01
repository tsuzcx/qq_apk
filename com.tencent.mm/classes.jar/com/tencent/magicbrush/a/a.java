package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a cMC;
  
  static
  {
    AppMethodBeat.i(139954);
    cMC = new a()
    {
      public final int q(String paramAnonymousString, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final Drawable r(String paramAnonymousString, int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(139954);
  }
  
  public static a Rt()
  {
    return cMC;
  }
  
  public static void a(a parama)
  {
    cMC = parama;
  }
  
  public static abstract interface a
  {
    public abstract int q(String paramString, int paramInt);
    
    public abstract Drawable r(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */