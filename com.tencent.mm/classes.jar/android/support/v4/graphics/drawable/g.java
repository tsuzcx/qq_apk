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
  static final PorterDuff.Mode um = PorterDuff.Mode.SRC_IN;
  private int HE;
  private PorterDuff.Mode HF;
  private boolean HG;
  a HH;
  Drawable mDrawable;
  private boolean uq;
  
  g(Drawable paramDrawable)
  {
    this.HH = ea();
    l(paramDrawable);
  }
  
  g(a parama, Resources paramResources)
  {
    this.HH = parama;
    if ((this.HH != null) && (this.HH.HI != null)) {
      l(this.HH.HI.newDrawable(paramResources));
    }
  }
  
  private boolean f(int[] paramArrayOfInt)
  {
    if (!eb()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.HH.vn;
      localMode = this.HH.vo;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.HG) && (i == this.HE) && (localMode == this.HF));
    setColorFilter(i, localMode);
    this.HE = i;
    this.HF = localMode;
    this.HG = true;
    return true;
    this.HG = false;
    clearColorFilter();
    return false;
  }
  
  public final Drawable dZ()
  {
    return this.mDrawable;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  a ea()
  {
    return new b(this.HH);
  }
  
  protected boolean eb()
  {
    return true;
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.HH != null) {}
    for (int i = this.HH.getChangingConfigurations();; i = 0) {
      return i | j | this.mDrawable.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.HH != null)
    {
      if (this.HH.HI != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.HH.mChangingConfigurations = getChangingConfigurations();
        return this.HH;
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
    if ((eb()) && (this.HH != null)) {}
    for (ColorStateList localColorStateList = this.HH.vn; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null) {
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
      if (this.HH != null) {
        this.HH.HI = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public Drawable mutate()
  {
    a locala;
    if ((!this.uq) && (super.mutate() == this))
    {
      this.HH = ea();
      if (this.mDrawable != null) {
        this.mDrawable.mutate();
      }
      if (this.HH != null)
      {
        locala = this.HH;
        if (this.mDrawable == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.mDrawable.getConstantState();; localConstantState = null)
    {
      locala.HI = localConstantState;
      this.uq = true;
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
    this.HH.vn = paramColorStateList;
    f(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.HH.vo = paramMode;
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
    Drawable.ConstantState HI;
    int mChangingConfigurations;
    ColorStateList vn = null;
    PorterDuff.Mode vo = g.um;
    
    a(a parama)
    {
      if (parama != null)
      {
        this.mChangingConfigurations = parama.mChangingConfigurations;
        this.HI = parama.HI;
        this.vn = parama.vn;
        this.vo = parama.vo;
      }
    }
    
    public int getChangingConfigurations()
    {
      int j = this.mChangingConfigurations;
      if (this.HI != null) {}
      for (int i = this.HI.getChangingConfigurations();; i = 0) {
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