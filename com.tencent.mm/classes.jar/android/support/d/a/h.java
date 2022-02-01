package android.support.d.a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.e;

abstract class h
  extends Drawable
  implements e
{
  Drawable xk;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.xk != null) {
      a.a(this.xk, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.xk != null)
    {
      this.xk.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.xk != null)
    {
      Drawable localDrawable = this.xk;
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = localDrawable.getColorFilter();
      }
    }
    return localObject1;
  }
  
  public Drawable getCurrent()
  {
    if (this.xk != null) {
      return this.xk.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    if (this.xk != null) {
      return this.xk.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.xk != null) {
      return this.xk.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.xk != null) {
      return this.xk.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.xk != null) {
      return this.xk.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.xk != null) {
      return this.xk.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    if (this.xk != null) {
      this.xk.jumpToCurrentState();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.xk != null)
    {
      this.xk.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.xk != null) {
      return this.xk.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.xk != null)
    {
      this.xk.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.xk != null)
    {
      this.xk.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.xk != null) {
      this.xk.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.xk != null) {
      a.a(this.xk, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.xk != null) {
      a.a(this.xk, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.xk != null) {
      return this.xk.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.h
 * JD-Core Version:    0.7.0.1
 */