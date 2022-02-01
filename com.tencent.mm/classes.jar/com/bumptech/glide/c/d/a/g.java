package com.bumptech.glide.c.d.a;

import com.bumptech.glide.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g
{
  public static final g aJi = new e();
  public static final g aJj = new d();
  public static final g aJk = new a();
  public static final g aJl = new b();
  public static final g aJm = new c();
  public static final g aJn = new f();
  public static final g aJo = aJj;
  public static final i<g> aJp = i.b("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", aJo);
  
  public abstract float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract g pe();
  
  static final class a
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(77384);
      paramInt1 = Math.min(paramInt2 / paramInt4, paramInt1 / paramInt3);
      if (paramInt1 == 0)
      {
        AppMethodBeat.o(77384);
        return 1.0F;
      }
      float f = 1.0F / Integer.highestOneBit(paramInt1);
      AppMethodBeat.o(77384);
      return f;
    }
    
    public final g.g pe()
    {
      return g.g.aJr;
    }
  }
  
  static final class b
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 1;
      AppMethodBeat.i(77385);
      paramInt1 = (int)Math.ceil(Math.max(paramInt2 / paramInt4, paramInt1 / paramInt3));
      paramInt2 = Math.max(1, Integer.highestOneBit(paramInt1));
      if (paramInt2 < paramInt1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        float f = 1.0F / (paramInt2 << paramInt1);
        AppMethodBeat.o(77385);
        return f;
      }
    }
    
    public final g.g pe()
    {
      return g.g.aJq;
    }
  }
  
  static final class c
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(77386);
      float f = Math.min(1.0F, aJi.l(paramInt1, paramInt2, paramInt3, paramInt4));
      AppMethodBeat.o(77386);
      return f;
    }
    
    public final g.g pe()
    {
      return g.g.aJr;
    }
  }
  
  static final class d
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(77387);
      float f = Math.max(paramInt3 / paramInt1, paramInt4 / paramInt2);
      AppMethodBeat.o(77387);
      return f;
    }
    
    public final g.g pe()
    {
      return g.g.aJr;
    }
  }
  
  static final class e
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(77388);
      float f = Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
      AppMethodBeat.o(77388);
      return f;
    }
    
    public final g.g pe()
    {
      return g.g.aJr;
    }
  }
  
  static final class f
    extends g
  {
    public final float l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return 1.0F;
    }
    
    public final g.g pe()
    {
      return g.g.aJr;
    }
  }
  
  public static enum g
  {
    static
    {
      AppMethodBeat.i(77391);
      aJq = new g("MEMORY", 0);
      aJr = new g("QUALITY", 1);
      aJs = new g[] { aJq, aJr };
      AppMethodBeat.o(77391);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.g
 * JD-Core Version:    0.7.0.1
 */