package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends b.a
{
  public abstract void Wl();
  
  public abstract void Wm();
  
  public abstract int getCircularRevealScrimColor();
  
  public abstract d getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(int paramInt);
  
  public abstract void setRevealInfo(d paramd);
  
  public static final class a
    implements TypeEvaluator<c.d>
  {
    public static final TypeEvaluator<c.d> dtg;
    private final c.d dtc;
    
    static
    {
      AppMethodBeat.i(209032);
      dtg = new a();
      AppMethodBeat.o(209032);
    }
    
    public a()
    {
      AppMethodBeat.i(209029);
      this.dtc = new c.d((byte)0);
      AppMethodBeat.o(209029);
    }
  }
  
  public static final class b
    extends Property<c, c.d>
  {
    public static final Property<c, c.d> dth;
    
    static
    {
      AppMethodBeat.i(209035);
      dth = new b("circularReveal");
      AppMethodBeat.o(209035);
    }
    
    private b(String paramString)
    {
      super(paramString);
    }
  }
  
  public static final class c
    extends Property<c, Integer>
  {
    public static final Property<c, Integer> dti;
    
    static
    {
      AppMethodBeat.i(209046);
      dti = new c("circularRevealScrimColor");
      AppMethodBeat.o(209046);
    }
    
    private c(String paramString)
    {
      super(paramString);
    }
  }
  
  public static class d
  {
    public float centerX;
    public float centerY;
    public float radius;
    
    private d() {}
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public d(d paramd)
    {
      this(paramd.centerX, paramd.centerY, paramd.radius);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(209109);
      n(paramd.centerX, paramd.centerY, paramd.radius);
      AppMethodBeat.o(209109);
    }
    
    public final boolean isInvalid()
    {
      return this.radius == 3.4028235E+38F;
    }
    
    public final void n(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.c
 * JD-Core Version:    0.7.0.1
 */