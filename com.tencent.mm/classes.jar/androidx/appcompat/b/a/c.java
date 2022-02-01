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
  public Drawable mDrawable;
  
  public c(Drawable paramDrawable)
  {
    AppMethodBeat.i(238808);
    if (this.mDrawable != null) {
      this.mDrawable.setCallback(null);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    AppMethodBeat.o(238808);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238809);
    this.mDrawable.draw(paramCanvas);
    AppMethodBeat.o(238809);
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(238812);
    int i = this.mDrawable.getChangingConfigurations();
    AppMethodBeat.o(238812);
    return i;
  }
  
  public Drawable getCurrent()
  {
    AppMethodBeat.i(238823);
    Drawable localDrawable = this.mDrawable.getCurrent();
    AppMethodBeat.o(238823);
    return localDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(238832);
    int i = this.mDrawable.getIntrinsicHeight();
    AppMethodBeat.o(238832);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(238830);
    int i = this.mDrawable.getIntrinsicWidth();
    AppMethodBeat.o(238830);
    return i;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(238835);
    int i = this.mDrawable.getMinimumHeight();
    AppMethodBeat.o(238835);
    return i;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(238834);
    int i = this.mDrawable.getMinimumWidth();
    AppMethodBeat.o(238834);
    return i;
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(238826);
    int i = this.mDrawable.getOpacity();
    AppMethodBeat.o(238826);
    return i;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(238836);
    boolean bool = this.mDrawable.getPadding(paramRect);
    AppMethodBeat.o(238836);
    return bool;
  }
  
  public int[] getState()
  {
    AppMethodBeat.i(238820);
    int[] arrayOfInt = this.mDrawable.getState();
    AppMethodBeat.o(238820);
    return arrayOfInt;
  }
  
  public Region getTransparentRegion()
  {
    AppMethodBeat.i(238827);
    Region localRegion = this.mDrawable.getTransparentRegion();
    AppMethodBeat.o(238827);
    return localRegion;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(238838);
    invalidateSelf();
    AppMethodBeat.o(238838);
  }
  
  public boolean isAutoMirrored()
  {
    AppMethodBeat.i(238847);
    boolean bool = a.l(this.mDrawable);
    AppMethodBeat.o(238847);
    return bool;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(238818);
    boolean bool = this.mDrawable.isStateful();
    AppMethodBeat.o(238818);
    return bool;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(238821);
    this.mDrawable.jumpToCurrentState();
    AppMethodBeat.o(238821);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(238810);
    this.mDrawable.setBounds(paramRect);
    AppMethodBeat.o(238810);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(238843);
    boolean bool = this.mDrawable.setLevel(paramInt);
    AppMethodBeat.o(238843);
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(238840);
    scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(238840);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(238815);
    this.mDrawable.setAlpha(paramInt);
    AppMethodBeat.o(238815);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(238845);
    a.b(this.mDrawable, paramBoolean);
    AppMethodBeat.o(238845);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    AppMethodBeat.i(238811);
    this.mDrawable.setChangingConfigurations(paramInt);
    AppMethodBeat.o(238811);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(238816);
    this.mDrawable.setColorFilter(paramColorFilter);
    AppMethodBeat.o(238816);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(238813);
    this.mDrawable.setDither(paramBoolean);
    AppMethodBeat.o(238813);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(238814);
    this.mDrawable.setFilterBitmap(paramBoolean);
    AppMethodBeat.o(238814);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(238854);
    a.a(this.mDrawable, paramFloat1, paramFloat2);
    AppMethodBeat.o(238854);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(238856);
    a.a(this.mDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(238856);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238819);
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    AppMethodBeat.o(238819);
    return bool;
  }
  
  public void setTint(int paramInt)
  {
    AppMethodBeat.i(238848);
    a.a(this.mDrawable, paramInt);
    AppMethodBeat.o(238848);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238850);
    a.a(this.mDrawable, paramColorStateList);
    AppMethodBeat.o(238850);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(238852);
    a.a(this.mDrawable, paramMode);
    AppMethodBeat.o(238852);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(238824);
    if ((super.setVisible(paramBoolean1, paramBoolean2)) || (this.mDrawable.setVisible(paramBoolean1, paramBoolean2)))
    {
      AppMethodBeat.o(238824);
      return true;
    }
    AppMethodBeat.o(238824);
    return false;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(238841);
    unscheduleSelf(paramRunnable);
    AppMethodBeat.o(238841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.c
 * JD-Core Version:    0.7.0.1
 */