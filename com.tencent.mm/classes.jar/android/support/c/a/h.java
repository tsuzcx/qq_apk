package android.support.c.a;

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
  Drawable ul;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.ul != null) {
      a.a(this.ul, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.ul != null)
    {
      this.ul.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.ul != null)
    {
      Drawable localDrawable = this.ul;
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = localDrawable.getColorFilter();
      }
    }
    return localObject1;
  }
  
  public Drawable getCurrent()
  {
    if (this.ul != null) {
      return this.ul.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    if (this.ul != null) {
      return this.ul.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.ul != null) {
      return this.ul.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.ul != null) {
      return this.ul.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.ul != null) {
      return this.ul.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.ul != null) {
      return this.ul.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    if (this.ul != null) {
      this.ul.jumpToCurrentState();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.ul != null)
    {
      this.ul.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.ul != null) {
      return this.ul.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.ul != null)
    {
      this.ul.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.ul != null)
    {
      this.ul.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.ul != null) {
      this.ul.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.ul != null) {
      a.a(this.ul, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.ul != null) {
      a.a(this.ul, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.ul != null) {
      return this.ul.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.h
 * JD-Core Version:    0.7.0.1
 */