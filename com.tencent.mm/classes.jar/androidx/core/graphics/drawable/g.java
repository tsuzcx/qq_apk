package androidx.core.graphics.drawable;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

class g
  extends Drawable
  implements Drawable.Callback, e, f
{
  static final PorterDuff.Mode KQ = PorterDuff.Mode.SRC_IN;
  private int KZ;
  private PorterDuff.Mode La;
  private boolean Lb;
  i Lc;
  private boolean iF;
  Drawable mDrawable;
  
  g(Drawable paramDrawable)
  {
    AppMethodBeat.i(250911);
    this.Lc = gE();
    s(paramDrawable);
    AppMethodBeat.o(250911);
  }
  
  g(i parami, Resources paramResources)
  {
    AppMethodBeat.i(250908);
    this.Lc = parami;
    if ((this.Lc != null) && (this.Lc.Le != null)) {
      s(this.Lc.Le.newDrawable(paramResources));
    }
    AppMethodBeat.o(250908);
  }
  
  private boolean f(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250982);
    if (!gF())
    {
      AppMethodBeat.o(250982);
      return false;
    }
    ColorStateList localColorStateList = this.Lc.zb;
    PorterDuff.Mode localMode = this.Lc.jF;
    if ((localColorStateList != null) && (localMode != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!this.Lb) || (i != this.KZ) || (localMode != this.La))
      {
        setColorFilter(i, localMode);
        this.KZ = i;
        this.La = localMode;
        this.Lb = true;
        AppMethodBeat.o(250982);
        return true;
      }
    }
    else
    {
      this.Lb = false;
      clearColorFilter();
    }
    AppMethodBeat.o(250982);
    return false;
  }
  
  private i gE()
  {
    AppMethodBeat.i(250966);
    i locali = new i(this.Lc);
    AppMethodBeat.o(250966);
    return locali;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(250918);
    this.mDrawable.draw(paramCanvas);
    AppMethodBeat.o(250918);
  }
  
  public final Drawable gD()
  {
    return this.mDrawable;
  }
  
  protected boolean gF()
  {
    return true;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(250927);
    int j = super.getChangingConfigurations();
    if (this.Lc != null) {}
    for (int i = this.Lc.getChangingConfigurations();; i = 0)
    {
      int k = this.mDrawable.getChangingConfigurations();
      AppMethodBeat.o(250927);
      return i | j | k;
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(250963);
    if (this.Lc != null)
    {
      if (this.Lc.Le != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.Lc.mChangingConfigurations = getChangingConfigurations();
        i locali = this.Lc;
        AppMethodBeat.o(250963);
        return locali;
      }
    }
    AppMethodBeat.o(250963);
    return null;
  }
  
  public Drawable getCurrent()
  {
    AppMethodBeat.i(250947);
    Drawable localDrawable = this.mDrawable.getCurrent();
    AppMethodBeat.o(250947);
    return localDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(250954);
    int i = this.mDrawable.getIntrinsicHeight();
    AppMethodBeat.o(250954);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(250953);
    int i = this.mDrawable.getIntrinsicWidth();
    AppMethodBeat.o(250953);
    return i;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(250956);
    int i = this.mDrawable.getMinimumHeight();
    AppMethodBeat.o(250956);
    return i;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(250955);
    int i = this.mDrawable.getMinimumWidth();
    AppMethodBeat.o(250955);
    return i;
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(250950);
    int i = this.mDrawable.getOpacity();
    AppMethodBeat.o(250950);
    return i;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(250959);
    boolean bool = this.mDrawable.getPadding(paramRect);
    AppMethodBeat.o(250959);
    return bool;
  }
  
  public int[] getState()
  {
    AppMethodBeat.i(250946);
    int[] arrayOfInt = this.mDrawable.getState();
    AppMethodBeat.o(250946);
    return arrayOfInt;
  }
  
  public Region getTransparentRegion()
  {
    AppMethodBeat.i(250951);
    Region localRegion = this.mDrawable.getTransparentRegion();
    AppMethodBeat.o(250951);
    return localRegion;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(250968);
    invalidateSelf();
    AppMethodBeat.o(250968);
  }
  
  public boolean isAutoMirrored()
  {
    AppMethodBeat.i(250962);
    boolean bool = this.mDrawable.isAutoMirrored();
    AppMethodBeat.o(250962);
    return bool;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(250942);
    if ((gF()) && (this.Lc != null)) {}
    for (ColorStateList localColorStateList = this.Lc.zb; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null)
    {
      AppMethodBeat.o(250942);
      return true;
    }
    AppMethodBeat.o(250942);
    return false;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(250915);
    this.mDrawable.jumpToCurrentState();
    AppMethodBeat.o(250915);
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(250964);
    i locali;
    if ((!this.iF) && (super.mutate() == this))
    {
      this.Lc = gE();
      if (this.mDrawable != null) {
        this.mDrawable.mutate();
      }
      if (this.Lc != null)
      {
        locali = this.Lc;
        if (this.mDrawable == null) {
          break label87;
        }
      }
    }
    label87:
    for (Drawable.ConstantState localConstantState = this.mDrawable.getConstantState();; localConstantState = null)
    {
      locali.Le = localConstantState;
      this.iF = true;
      AppMethodBeat.o(250964);
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(250921);
    if (this.mDrawable != null) {
      this.mDrawable.setBounds(paramRect);
    }
    AppMethodBeat.o(250921);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(250974);
    boolean bool = this.mDrawable.setLevel(paramInt);
    AppMethodBeat.o(250974);
    return bool;
  }
  
  public final void s(Drawable paramDrawable)
  {
    AppMethodBeat.i(250985);
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
      if (this.Lc != null) {
        this.Lc.Le = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
    AppMethodBeat.o(250985);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(250970);
    scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(250970);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(250935);
    this.mDrawable.setAlpha(paramInt);
    AppMethodBeat.o(250935);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(250961);
    this.mDrawable.setAutoMirrored(paramBoolean);
    AppMethodBeat.o(250961);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    AppMethodBeat.i(250925);
    this.mDrawable.setChangingConfigurations(paramInt);
    AppMethodBeat.o(250925);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(250938);
    this.mDrawable.setColorFilter(paramColorFilter);
    AppMethodBeat.o(250938);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(250930);
    this.mDrawable.setDither(paramBoolean);
    AppMethodBeat.o(250930);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(250933);
    this.mDrawable.setFilterBitmap(paramBoolean);
    AppMethodBeat.o(250933);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250945);
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    if ((f(paramArrayOfInt)) || (bool))
    {
      AppMethodBeat.o(250945);
      return true;
    }
    AppMethodBeat.o(250945);
    return false;
  }
  
  public void setTint(int paramInt)
  {
    AppMethodBeat.i(250976);
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(250976);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(250978);
    this.Lc.zb = paramColorStateList;
    f(getState());
    AppMethodBeat.o(250978);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(250980);
    this.Lc.jF = paramMode;
    f(getState());
    AppMethodBeat.o(250980);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(250949);
    if ((super.setVisible(paramBoolean1, paramBoolean2)) || (this.mDrawable.setVisible(paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(250949);
      return true;
    }
    AppMethodBeat.o(250949);
    return false;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(250972);
    unscheduleSelf(paramRunnable);
    AppMethodBeat.o(250972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.g
 * JD-Core Version:    0.7.0.1
 */