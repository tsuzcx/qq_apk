package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a.a cnj;
  
  static
  {
    AppMethodBeat.i(139954);
    cnj = new a.a()
    {
      public final int n(String paramAnonymousString, int paramAnonymousInt)
      {
        return 0;
      }
      
      public final Drawable o(String paramAnonymousString, int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(139954);
  }
  
  public static a.a Gb()
  {
    return cnj;
  }
  
  public static void a(a.a parama)
  {
    cnj = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */