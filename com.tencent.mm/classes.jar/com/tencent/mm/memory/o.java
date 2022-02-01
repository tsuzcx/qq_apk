package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends e<Bitmap, b>
{
  public static o heJ;
  
  static
  {
    AppMethodBeat.i(156463);
    heJ = new o();
    AppMethodBeat.o(156463);
  }
  
  private static Bitmap b(b paramb)
  {
    AppMethodBeat.i(156456);
    paramb = Bitmap.createBitmap(paramb.width, paramb.height, k.hew);
    AppMethodBeat.o(156456);
    return paramb;
  }
  
  public final Bitmap a(b paramb)
  {
    try
    {
      AppMethodBeat.i(156454);
      Bitmap localBitmap2 = (Bitmap)super.a(paramb);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = b(paramb);
      }
      AppMethodBeat.o(156454);
      return localBitmap1;
    }
    finally {}
  }
  
  protected final long avH()
  {
    return 1228800L;
  }
  
  protected final long avI()
  {
    return 307200L;
  }
  
  public final void f(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(156455);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        super.bJ(paramBitmap);
      }
      AppMethodBeat.o(156455);
      return;
    }
    finally {}
  }
  
  static final class a
    extends d<Bitmap, o.b>
  {
    public a(o.b paramb)
    {
      super();
    }
  }
  
  public static final class b
    implements Comparable
  {
    private String heK;
    public int height;
    public int width;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(156453);
      this.width = paramInt1;
      this.height = paramInt2;
      this.heK = String.format("SightBitmapSize: [%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(156453);
    }
    
    public final int compareTo(Object paramObject)
    {
      if (paramObject == null) {
        return 0;
      }
      if ((paramObject instanceof b))
      {
        if ((this.width == ((b)paramObject).width) && (this.height == ((b)paramObject).height)) {
          return 0;
        }
        int i = this.width;
        if (this.height * i > ((b)paramObject).width * ((b)paramObject).height) {
          return 1;
        }
        return -1;
      }
      return 0;
    }
    
    public final String toString()
    {
      return this.heK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.o
 * JD-Core Version:    0.7.0.1
 */