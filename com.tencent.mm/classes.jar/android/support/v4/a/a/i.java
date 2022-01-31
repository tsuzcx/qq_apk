package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

final class i
  extends h
{
  private static Method AB;
  
  i(Drawable paramDrawable)
  {
    super(paramDrawable);
    cu();
  }
  
  i(g.a parama, Resources paramResources)
  {
    super(parama, paramResources);
    cu();
  }
  
  private static void cu()
  {
    if (AB == null) {}
    try
    {
      AB = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
      return;
    }
    catch (Exception localException) {}
  }
  
  final g.a cs()
  {
    return new a(this.Az);
  }
  
  protected final boolean ct()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = this.mDrawable;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)) && (!(localDrawable instanceof InsetDrawable)))
      {
        bool1 = bool2;
        if (!(localDrawable instanceof RippleDrawable)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Rect getDirtyBounds()
  {
    return this.mDrawable.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline)
  {
    this.mDrawable.getOutline(paramOutline);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.mDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    if (ct())
    {
      super.setTint(paramInt);
      return;
    }
    this.mDrawable.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (ct())
    {
      super.setTintList(paramColorStateList);
      return;
    }
    this.mDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (ct())
    {
      super.setTintMode(paramMode);
      return;
    }
    this.mDrawable.setTintMode(paramMode);
  }
  
  private static final class a
    extends g.a
  {
    a(g.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new i(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.a.i
 * JD-Core Version:    0.7.0.1
 */