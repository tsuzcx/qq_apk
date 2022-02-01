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
  Drawable xd;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.xd != null) {
      a.a(this.xd, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.xd != null)
    {
      this.xd.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.xd != null)
    {
      Drawable localDrawable = this.xd;
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = localDrawable.getColorFilter();
      }
    }
    return localObject1;
  }
  
  public Drawable getCurrent()
  {
    if (this.xd != null) {
      return this.xd.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    if (this.xd != null) {
      return this.xd.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.xd != null) {
      return this.xd.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.xd != null) {
      return this.xd.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.xd != null) {
      return this.xd.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.xd != null) {
      return this.xd.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    if (this.xd != null) {
      this.xd.jumpToCurrentState();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.xd != null)
    {
      this.xd.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.xd != null) {
      return this.xd.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.xd != null)
    {
      this.xd.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.xd != null)
    {
      this.xd.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.xd != null) {
      this.xd.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.xd != null) {
      a.a(this.xd, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.xd != null) {
      a.a(this.xd, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.xd != null) {
      return this.xd.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.h
 * JD-Core Version:    0.7.0.1
 */