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
  static final PorterDuff.Mode bqY = PorterDuff.Mode.SRC_IN;
  private int bri;
  private PorterDuff.Mode brj;
  private boolean brk;
  i brl;
  private boolean jA;
  Drawable kD;
  
  g(Drawable paramDrawable)
  {
    AppMethodBeat.i(196175);
    this.brl = DO();
    v(paramDrawable);
    AppMethodBeat.o(196175);
  }
  
  g(i parami, Resources paramResources)
  {
    AppMethodBeat.i(196162);
    this.brl = parami;
    if ((this.brl != null) && (this.brl.brn != null)) {
      v(this.brl.brn.newDrawable(paramResources));
    }
    AppMethodBeat.o(196162);
  }
  
  private i DO()
  {
    AppMethodBeat.i(196190);
    i locali = new i(this.brl);
    AppMethodBeat.o(196190);
    return locali;
  }
  
  private boolean i(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196204);
    if (!DP())
    {
      AppMethodBeat.o(196204);
      return false;
    }
    ColorStateList localColorStateList = this.brl.Rq;
    PorterDuff.Mode localMode = this.brl.kA;
    if ((localColorStateList != null) && (localMode != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!this.brk) || (i != this.bri) || (localMode != this.brj))
      {
        setColorFilter(i, localMode);
        this.bri = i;
        this.brj = localMode;
        this.brk = true;
        AppMethodBeat.o(196204);
        return true;
      }
    }
    else
    {
      this.brk = false;
      clearColorFilter();
    }
    AppMethodBeat.o(196204);
    return false;
  }
  
  public final Drawable DN()
  {
    return this.kD;
  }
  
  protected boolean DP()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196238);
    this.kD.draw(paramCanvas);
    AppMethodBeat.o(196238);
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(196277);
    int j = super.getChangingConfigurations();
    if (this.brl != null) {}
    for (int i = this.brl.getChangingConfigurations();; i = 0)
    {
      int k = this.kD.getChangingConfigurations();
      AppMethodBeat.o(196277);
      return i | j | k;
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(196509);
    if (this.brl != null)
    {
      if (this.brl.brn != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.brl.mChangingConfigurations = getChangingConfigurations();
        i locali = this.brl;
        AppMethodBeat.o(196509);
        return locali;
      }
    }
    AppMethodBeat.o(196509);
    return null;
  }
  
  public Drawable getCurrent()
  {
    AppMethodBeat.i(196370);
    Drawable localDrawable = this.kD.getCurrent();
    AppMethodBeat.o(196370);
    return localDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(196432);
    int i = this.kD.getIntrinsicHeight();
    AppMethodBeat.o(196432);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(196423);
    int i = this.kD.getIntrinsicWidth();
    AppMethodBeat.o(196423);
    return i;
  }
  
  public int getLayoutDirection()
  {
    AppMethodBeat.i(196496);
    int i = a.u(this.kD);
    AppMethodBeat.o(196496);
    return i;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(196443);
    int i = this.kD.getMinimumHeight();
    AppMethodBeat.o(196443);
    return i;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(196437);
    int i = this.kD.getMinimumWidth();
    AppMethodBeat.o(196437);
    return i;
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(196397);
    int i = this.kD.getOpacity();
    AppMethodBeat.o(196397);
    return i;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(196454);
    boolean bool = this.kD.getPadding(paramRect);
    AppMethodBeat.o(196454);
    return bool;
  }
  
  public int[] getState()
  {
    AppMethodBeat.i(196358);
    int[] arrayOfInt = this.kD.getState();
    AppMethodBeat.o(196358);
    return arrayOfInt;
  }
  
  public Region getTransparentRegion()
  {
    AppMethodBeat.i(196413);
    Region localRegion = this.kD.getTransparentRegion();
    AppMethodBeat.o(196413);
    return localRegion;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(196533);
    invalidateSelf();
    AppMethodBeat.o(196533);
  }
  
  public boolean isAutoMirrored()
  {
    AppMethodBeat.i(196478);
    boolean bool = a.n(this.kD);
    AppMethodBeat.o(196478);
    return bool;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(196337);
    if ((DP()) && (this.brl != null)) {}
    for (ColorStateList localColorStateList = this.brl.Rq; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.kD.isStateful()); localColorStateList = null)
    {
      AppMethodBeat.o(196337);
      return true;
    }
    AppMethodBeat.o(196337);
    return false;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(196228);
    this.kD.jumpToCurrentState();
    AppMethodBeat.o(196228);
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(196523);
    i locali;
    if ((!this.jA) && (super.mutate() == this))
    {
      this.brl = DO();
      if (this.kD != null) {
        this.kD.mutate();
      }
      if (this.brl != null)
      {
        locali = this.brl;
        if (this.kD == null) {
          break label87;
        }
      }
    }
    label87:
    for (Drawable.ConstantState localConstantState = this.kD.getConstantState();; localConstantState = null)
    {
      locali.brn = localConstantState;
      this.jA = true;
      AppMethodBeat.o(196523);
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(196252);
    if (this.kD != null) {
      this.kD.setBounds(paramRect);
    }
    AppMethodBeat.o(196252);
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    AppMethodBeat.i(196487);
    boolean bool = a.b(this.kD, paramInt);
    AppMethodBeat.o(196487);
    return bool;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(196574);
    boolean bool = this.kD.setLevel(paramInt);
    AppMethodBeat.o(196574);
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(196548);
    scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(196548);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(196310);
    this.kD.setAlpha(paramInt);
    AppMethodBeat.o(196310);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(196466);
    a.b(this.kD, paramBoolean);
    AppMethodBeat.o(196466);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    AppMethodBeat.i(196266);
    this.kD.setChangingConfigurations(paramInt);
    AppMethodBeat.o(196266);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(196321);
    this.kD.setColorFilter(paramColorFilter);
    AppMethodBeat.o(196321);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(196287);
    this.kD.setDither(paramBoolean);
    AppMethodBeat.o(196287);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(196299);
    this.kD.setFilterBitmap(paramBoolean);
    AppMethodBeat.o(196299);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196345);
    boolean bool = this.kD.setState(paramArrayOfInt);
    if ((i(paramArrayOfInt)) || (bool))
    {
      AppMethodBeat.o(196345);
      return true;
    }
    AppMethodBeat.o(196345);
    return false;
  }
  
  public void setTint(int paramInt)
  {
    AppMethodBeat.i(196582);
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(196582);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(196591);
    this.brl.Rq = paramColorStateList;
    i(getState());
    AppMethodBeat.o(196591);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(196601);
    this.brl.kA = paramMode;
    i(getState());
    AppMethodBeat.o(196601);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(196383);
    if ((super.setVisible(paramBoolean1, paramBoolean2)) || (this.kD.setVisible(paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(196383);
      return true;
    }
    AppMethodBeat.o(196383);
    return false;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(196565);
    unscheduleSelf(paramRunnable);
    AppMethodBeat.o(196565);
  }
  
  public final void v(Drawable paramDrawable)
  {
    AppMethodBeat.i(196621);
    if (this.kD != null) {
      this.kD.setCallback(null);
    }
    this.kD = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      if (this.brl != null) {
        this.brl.brn = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
    AppMethodBeat.o(196621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.g
 * JD-Core Version:    0.7.0.1
 */