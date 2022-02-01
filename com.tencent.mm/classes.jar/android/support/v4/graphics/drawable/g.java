package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class g
  extends Drawable
  implements Drawable.Callback, e, f
{
  static final PorterDuff.Mode xl = PorterDuff.Mode.SRC_IN;
  private int KC;
  private PorterDuff.Mode KD;
  private boolean KE;
  a KF;
  Drawable mDrawable;
  private boolean xp;
  
  g(Drawable paramDrawable)
  {
    this.KF = eG();
    l(paramDrawable);
  }
  
  g(a parama, Resources paramResources)
  {
    this.KF = parama;
    if ((this.KF != null) && (this.KF.KG != null)) {
      l(this.KF.KG.newDrawable(paramResources));
    }
  }
  
  private boolean f(int[] paramArrayOfInt)
  {
    if (!eH()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.KF.yk;
      localMode = this.KF.yl;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.KE) && (i == this.KC) && (localMode == this.KD));
    setColorFilter(i, localMode);
    this.KC = i;
    this.KD = localMode;
    this.KE = true;
    return true;
    this.KE = false;
    clearColorFilter();
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public final Drawable eF()
  {
    return this.mDrawable;
  }
  
  a eG()
  {
    return new b(this.KF);
  }
  
  protected boolean eH()
  {
    return true;
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.KF != null) {}
    for (int i = this.KF.getChangingConfigurations();; i = 0) {
      return i | j | this.mDrawable.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.KF != null)
    {
      if (this.KF.KG != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.KF.mChangingConfigurations = getChangingConfigurations();
        return this.KF;
      }
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mDrawable.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.mDrawable.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawable.isAutoMirrored();
  }
  
  public boolean isStateful()
  {
    if ((eH()) && (this.KF != null)) {}
    for (ColorStateList localColorStateList = this.KF.yk; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null) {
      return true;
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    this.mDrawable.jumpToCurrentState();
  }
  
  public final void l(Drawable paramDrawable)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setCallback(null);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      if (this.KF != null) {
        this.KF.KG = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public Drawable mutate()
  {
    a locala;
    if ((!this.xp) && (super.mutate() == this))
    {
      this.KF = eG();
      if (this.mDrawable != null) {
        this.mDrawable.mutate();
      }
      if (this.KF != null)
      {
        locala = this.KF;
        if (this.mDrawable == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.mDrawable.getConstantState();; localConstantState = null)
    {
      locala.KG = localConstantState;
      this.xp = true;
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawable.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    return (f(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.KF.yk = paramColorStateList;
    f(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.KF.yl = paramMode;
    f(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.mDrawable.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  protected static abstract class a
    extends Drawable.ConstantState
  {
    Drawable.ConstantState KG;
    int mChangingConfigurations;
    ColorStateList yk = null;
    PorterDuff.Mode yl = g.xl;
    
    a(a parama)
    {
      if (parama != null)
      {
        this.mChangingConfigurations = parama.mChangingConfigurations;
        this.KG = parama.KG;
        this.yk = parama.yk;
        this.yl = parama.yl;
      }
    }
    
    public int getChangingConfigurations()
    {
      int j = this.mChangingConfigurations;
      if (this.KG != null) {}
      for (int i = this.KG.getChangingConfigurations();; i = 0) {
        return i | j;
      }
    }
    
    public Drawable newDrawable()
    {
      return newDrawable(null);
    }
    
    public abstract Drawable newDrawable(Resources paramResources);
  }
  
  static final class b
    extends g.a
  {
    b(g.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new g(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.g
 * JD-Core Version:    0.7.0.1
 */