package android.support.v4.a.a;

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
  static final PorterDuff.Mode mO = PorterDuff.Mode.SRC_IN;
  private int Aw;
  private PorterDuff.Mode Ax;
  private boolean Ay;
  a Az;
  Drawable mDrawable;
  private boolean mS;
  
  g(Drawable paramDrawable)
  {
    this.Az = cs();
    h(paramDrawable);
  }
  
  g(a parama, Resources paramResources)
  {
    this.Az = parama;
    if ((this.Az != null) && (this.Az.AA != null)) {
      h(this.Az.AA.newDrawable(paramResources));
    }
  }
  
  private boolean d(int[] paramArrayOfInt)
  {
    if (!ct()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.Az.nM;
      localMode = this.Az.nN;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.Ay) && (i == this.Aw) && (localMode == this.Ax));
    setColorFilter(i, localMode);
    this.Aw = i;
    this.Ax = localMode;
    this.Ay = true;
    return true;
    this.Ay = false;
    clearColorFilter();
    return false;
  }
  
  public final Drawable cr()
  {
    return this.mDrawable;
  }
  
  a cs()
  {
    return new b(this.Az);
  }
  
  protected boolean ct()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.Az != null) {}
    for (int i = this.Az.getChangingConfigurations();; i = 0) {
      return i | j | this.mDrawable.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.Az != null)
    {
      if (this.Az.AA != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.Az.mChangingConfigurations = getChangingConfigurations();
        return this.Az;
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
  
  public final void h(Drawable paramDrawable)
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
      if (this.Az != null) {
        this.Az.AA = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if ((ct()) && (this.Az != null)) {}
    for (ColorStateList localColorStateList = this.Az.nM; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null) {
      return true;
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    this.mDrawable.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    a locala;
    if ((!this.mS) && (super.mutate() == this))
    {
      this.Az = cs();
      if (this.mDrawable != null) {
        this.mDrawable.mutate();
      }
      if (this.Az != null)
      {
        locala = this.Az;
        if (this.mDrawable == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.mDrawable.getConstantState();; localConstantState = null)
    {
      locala.AA = localConstantState;
      this.mS = true;
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
    return (d(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.Az.nM = paramColorStateList;
    d(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.Az.nN = paramMode;
    d(getState());
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
    Drawable.ConstantState AA;
    int mChangingConfigurations;
    ColorStateList nM = null;
    PorterDuff.Mode nN = g.mO;
    
    a(a parama)
    {
      if (parama != null)
      {
        this.mChangingConfigurations = parama.mChangingConfigurations;
        this.AA = parama.AA;
        this.nM = parama.nM;
        this.nN = parama.nN;
      }
    }
    
    public int getChangingConfigurations()
    {
      int j = this.mChangingConfigurations;
      if (this.AA != null) {}
      for (int i = this.AA.getChangingConfigurations();; i = 0) {
        return i | j;
      }
    }
    
    public Drawable newDrawable()
    {
      return newDrawable(null);
    }
    
    public abstract Drawable newDrawable(Resources paramResources);
  }
  
  private static final class b
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
 * Qualified Name:     android.support.v4.a.a.g
 * JD-Core Version:    0.7.0.1
 */