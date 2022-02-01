package android.support.design.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

public abstract interface c
  extends b.a
{
  public abstract void aV();
  
  public abstract void aW();
  
  public abstract int getCircularRevealScrimColor();
  
  public abstract d getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(int paramInt);
  
  public abstract void setRevealInfo(d paramd);
  
  public static final class a
    implements TypeEvaluator<c.d>
  {
    public static final TypeEvaluator<c.d> gT = new a();
    private final c.d gP = new c.d((byte)0);
  }
  
  public static final class b
    extends Property<c, c.d>
  {
    public static final Property<c, c.d> gU = new b("circularReveal");
    
    private b(String paramString)
    {
      super(paramString);
    }
  }
  
  public static final class c
    extends Property<c, Integer>
  {
    public static final Property<c, Integer> gV = new c("circularRevealScrimColor");
    
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
      c(paramd.centerX, paramd.centerY, paramd.radius);
    }
    
    public final boolean bc()
    {
      return this.radius == 3.4028235E+38F;
    }
    
    public final void c(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.c
 * JD-Core Version:    0.7.0.1
 */