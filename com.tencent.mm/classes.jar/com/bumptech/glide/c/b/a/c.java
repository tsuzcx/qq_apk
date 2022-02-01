package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements l
{
  private final b aFI;
  private final h<a, Bitmap> aFJ;
  
  c()
  {
    AppMethodBeat.i(77071);
    this.aFI = new b();
    this.aFJ = new h();
    AppMethodBeat.o(77071);
  }
  
  static String d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77079);
    paramConfig = "[" + paramInt1 + "x" + paramInt2 + "], " + paramConfig;
    AppMethodBeat.o(77079);
    return paramConfig;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77073);
    paramConfig = this.aFI.f(paramInt1, paramInt2, paramConfig);
    paramConfig = (Bitmap)this.aFJ.b(paramConfig);
    AppMethodBeat.o(77073);
    return paramConfig;
  }
  
  public final String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77076);
    paramConfig = d(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(77076);
    return paramConfig;
  }
  
  public final void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77072);
    a locala = this.aFI.f(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.aFJ.a(locala, paramBitmap);
    AppMethodBeat.o(77072);
  }
  
  public final String h(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77075);
    paramBitmap = d(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    AppMethodBeat.o(77075);
    return paramBitmap;
  }
  
  public final int i(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77077);
    int i = j.k(paramBitmap);
    AppMethodBeat.o(77077);
    return i;
  }
  
  public final Bitmap ot()
  {
    AppMethodBeat.i(77074);
    Bitmap localBitmap = (Bitmap)this.aFJ.removeLast();
    AppMethodBeat.o(77074);
    return localBitmap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77078);
    String str = "AttributeStrategy:\n  " + this.aFJ;
    AppMethodBeat.o(77078);
    return str;
  }
  
  static final class a
    implements m
  {
    private final c.b aFK;
    private Bitmap.Config aFL;
    private int height;
    private int width;
    
    public a(c.b paramb)
    {
      this.aFK = paramb;
    }
    
    public final void e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.aFL = paramConfig;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.width == paramObject.width)
        {
          bool1 = bool2;
          if (this.height == paramObject.height)
          {
            bool1 = bool2;
            if (this.aFL == paramObject.aFL) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(77066);
      int j = this.width;
      int k = this.height;
      if (this.aFL != null) {}
      for (int i = this.aFL.hashCode();; i = 0)
      {
        AppMethodBeat.o(77066);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final void ou()
    {
      AppMethodBeat.i(77068);
      this.aFK.a(this);
      AppMethodBeat.o(77068);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(77067);
      String str = c.d(this.width, this.height, this.aFL);
      AppMethodBeat.o(77067);
      return str;
    }
  }
  
  static final class b
    extends d<c.a>
  {
    final c.a f(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      AppMethodBeat.i(77069);
      c.a locala = (c.a)ow();
      locala.e(paramInt1, paramInt2, paramConfig);
      AppMethodBeat.o(77069);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */