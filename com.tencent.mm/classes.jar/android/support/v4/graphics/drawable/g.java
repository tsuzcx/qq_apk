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
  static final PorterDuff.Mode vl = PorterDuff.Mode.SRC_IN;
  private int IA;
  private PorterDuff.Mode IB;
  private boolean IC;
  a IE;
  Drawable mDrawable;
  private boolean vp;
  
  g(Drawable paramDrawable)
  {
    this.IE = el();
    l(paramDrawable);
  }
  
  g(a parama, Resources paramResources)
  {
    this.IE = parama;
    if ((this.IE != null) && (this.IE.IF != null)) {
      l(this.IE.IF.newDrawable(paramResources));
    }
  }
  
  private boolean f(int[] paramArrayOfInt)
  {
    if (!em()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.IE.wm;
      localMode = this.IE.wn;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.IC) && (i == this.IA) && (localMode == this.IB));
    setColorFilter(i, localMode);
    this.IA = i;
    this.IB = localMode;
    this.IC = true;
    return true;
    this.IC = false;
    clearColorFilter();
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public final Drawable ek()
  {
    return this.mDrawable;
  }
  
  a el()
  {
    return new b(this.IE);
  }
  
  protected boolean em()
  {
    return true;
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.IE != null) {}
    for (int i = this.IE.getChangingConfigurations();; i = 0) {
      return i | j | this.mDrawable.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.IE != null)
    {
      if (this.IE.IF != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.IE.mChangingConfigurations = getChangingConfigurations();
        return this.IE;
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
    if ((em()) && (this.IE != null)) {}
    for (ColorStateList localColorStateList = this.IE.wm; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null) {
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
      if (this.IE != null) {
        this.IE.IF = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public Drawable mutate()
  {
    a locala;
    if ((!this.vp) && (super.mutate() == this))
    {
      this.IE = el();
      if (this.mDrawable != null) {
        this.mDrawable.mutate();
      }
      if (this.IE != null)
      {
        locala = this.IE;
        if (this.mDrawable == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.mDrawable.getConstantState();; localConstantState = null)
    {
      locala.IF = localConstantState;
      this.vp = true;
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
    this.IE.wm = paramColorStateList;
    f(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.IE.wn = paramMode;
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
    Drawable.ConstantState IF;
    int mChangingConfigurations;
    ColorStateList wm = null;
    PorterDuff.Mode wn = g.vl;
    
    a(a parama)
    {
      if (parama != null)
      {
        this.mChangingConfigurations = parama.mChangingConfigurations;
        this.IF = parama.IF;
        this.wm = parama.wm;
        this.wn = parama.wn;
      }
    }
    
    public int getChangingConfigurations()
    {
      int j = this.mChangingConfigurations;
      if (this.IF != null) {}
      for (int i = this.IF.getChangingConfigurations();; i = 0) {
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