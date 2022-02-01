package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends b.a
{
  public abstract int getCircularRevealScrimColor();
  
  public abstract d getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(int paramInt);
  
  public abstract void setRevealInfo(d paramd);
  
  public abstract void wM();
  
  public abstract void wN();
  
  public static final class a
    implements TypeEvaluator<c.d>
  {
    public static final TypeEvaluator<c.d> bAf;
    private final c.d bAb;
    
    static
    {
      AppMethodBeat.i(236808);
      bAf = new a();
      AppMethodBeat.o(236808);
    }
    
    public a()
    {
      AppMethodBeat.i(236805);
      this.bAb = new c.d((byte)0);
      AppMethodBeat.o(236805);
    }
  }
  
  public static final class b
    extends Property<c, c.d>
  {
    public static final Property<c, c.d> bAg;
    
    static
    {
      AppMethodBeat.i(236823);
      bAg = new b("circularReveal");
      AppMethodBeat.o(236823);
    }
    
    private b(String paramString)
    {
      super(paramString);
    }
  }
  
  public static final class c
    extends Property<c, Integer>
  {
    public static final Property<c, Integer> bAh;
    
    static
    {
      AppMethodBeat.i(236857);
      bAh = new c("circularRevealScrimColor");
      AppMethodBeat.o(236857);
    }
    
    private c(String paramString)
    {
      super(paramString);
    }
  }
  
  public static class d
  {
    public float aGt;
    public float aGu;
    public float radius;
    
    private d() {}
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.aGt = paramFloat1;
      this.aGu = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public d(d paramd)
    {
      this(paramd.aGt, paramd.aGu, paramd.radius);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(236905);
      k(paramd.aGt, paramd.aGu, paramd.radius);
      AppMethodBeat.o(236905);
    }
    
    public final boolean isInvalid()
    {
      return this.radius == 3.4028235E+38F;
    }
    
    public final void k(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.aGt = paramFloat1;
      this.aGu = paramFloat2;
      this.radius = paramFloat3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.c
 * JD-Core Version:    0.7.0.1
 */