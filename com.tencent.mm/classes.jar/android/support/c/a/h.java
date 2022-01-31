package android.support.c.a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.support.v4.a.a.e;

abstract class h
  extends Drawable
  implements e
{
  Drawable mN;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mN != null) {
      a.a(this.mN, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.mN != null)
    {
      this.mN.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mN != null)
    {
      Drawable localDrawable = this.mN;
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 21) {
        localObject1 = localDrawable.getColorFilter();
      }
    }
    return localObject1;
  }
  
  public Drawable getCurrent()
  {
    if (this.mN != null) {
      return this.mN.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    if (this.mN != null) {
      return this.mN.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.mN != null) {
      return this.mN.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.mN != null) {
      return this.mN.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.mN != null) {
      return this.mN.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.mN != null) {
      return this.mN.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    if (this.mN != null) {
      this.mN.jumpToCurrentState();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mN != null)
    {
      this.mN.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mN != null) {
      return this.mN.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.mN != null)
    {
      this.mN.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.mN != null)
    {
      this.mN.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.mN != null) {
      this.mN.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mN != null) {
      a.a(this.mN, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mN != null) {
      a.a(this.mN, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.mN != null) {
      return this.mN.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.h
 * JD-Core Version:    0.7.0.1
 */