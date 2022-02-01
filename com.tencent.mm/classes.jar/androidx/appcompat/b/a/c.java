package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends Drawable
  implements Drawable.Callback
{
  public Drawable kD;
  
  public c(Drawable paramDrawable)
  {
    AppMethodBeat.i(199281);
    if (this.kD != null) {
      this.kD.setCallback(null);
    }
    this.kD = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    AppMethodBeat.o(199281);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199289);
    this.kD.draw(paramCanvas);
    AppMethodBeat.o(199289);
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(199322);
    int i = this.kD.getChangingConfigurations();
    AppMethodBeat.o(199322);
    return i;
  }
  
  public Drawable getCurrent()
  {
    AppMethodBeat.i(199415);
    Drawable localDrawable = this.kD.getCurrent();
    AppMethodBeat.o(199415);
    return localDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(199484);
    int i = this.kD.getIntrinsicHeight();
    AppMethodBeat.o(199484);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(199471);
    int i = this.kD.getIntrinsicWidth();
    AppMethodBeat.o(199471);
    return i;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(199516);
    int i = this.kD.getMinimumHeight();
    AppMethodBeat.o(199516);
    return i;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(199499);
    int i = this.kD.getMinimumWidth();
    AppMethodBeat.o(199499);
    return i;
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(199440);
    int i = this.kD.getOpacity();
    AppMethodBeat.o(199440);
    return i;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(199534);
    boolean bool = this.kD.getPadding(paramRect);
    AppMethodBeat.o(199534);
    return bool;
  }
  
  public int[] getState()
  {
    AppMethodBeat.i(199393);
    int[] arrayOfInt = this.kD.getState();
    AppMethodBeat.o(199393);
    return arrayOfInt;
  }
  
  public Region getTransparentRegion()
  {
    AppMethodBeat.i(199458);
    Region localRegion = this.kD.getTransparentRegion();
    AppMethodBeat.o(199458);
    return localRegion;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199548);
    invalidateSelf();
    AppMethodBeat.o(199548);
  }
  
  public boolean isAutoMirrored()
  {
    AppMethodBeat.i(199631);
    boolean bool = a.n(this.kD);
    AppMethodBeat.o(199631);
    return bool;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(199366);
    boolean bool = this.kD.isStateful();
    AppMethodBeat.o(199366);
    return bool;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(199405);
    a.m(this.kD);
    AppMethodBeat.o(199405);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(199297);
    this.kD.setBounds(paramRect);
    AppMethodBeat.o(199297);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(199597);
    boolean bool = this.kD.setLevel(paramInt);
    AppMethodBeat.o(199597);
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(199565);
    scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(199565);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(199342);
    this.kD.setAlpha(paramInt);
    AppMethodBeat.o(199342);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(199617);
    a.b(this.kD, paramBoolean);
    AppMethodBeat.o(199617);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    AppMethodBeat.i(199310);
    this.kD.setChangingConfigurations(paramInt);
    AppMethodBeat.o(199310);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(199354);
    this.kD.setColorFilter(paramColorFilter);
    AppMethodBeat.o(199354);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(199329);
    this.kD.setDither(paramBoolean);
    AppMethodBeat.o(199329);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(199335);
    this.kD.setFilterBitmap(paramBoolean);
    AppMethodBeat.o(199335);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199681);
    a.a(this.kD, paramFloat1, paramFloat2);
    AppMethodBeat.o(199681);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199697);
    a.a(this.kD, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(199697);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199377);
    boolean bool = this.kD.setState(paramArrayOfInt);
    AppMethodBeat.o(199377);
    return bool;
  }
  
  public void setTint(int paramInt)
  {
    AppMethodBeat.i(199649);
    a.a(this.kD, paramInt);
    AppMethodBeat.o(199649);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199657);
    a.a(this.kD, paramColorStateList);
    AppMethodBeat.o(199657);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199671);
    a.a(this.kD, paramMode);
    AppMethodBeat.o(199671);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199428);
    if ((super.setVisible(paramBoolean1, paramBoolean2)) || (this.kD.setVisible(paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(199428);
      return true;
    }
    AppMethodBeat.o(199428);
    return false;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(199582);
    unscheduleSelf(paramRunnable);
    AppMethodBeat.o(199582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.b.a.c
 * JD-Core Version:    0.7.0.1
 */