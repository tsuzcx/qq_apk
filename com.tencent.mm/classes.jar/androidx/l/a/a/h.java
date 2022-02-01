package androidx.l.a.a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.e;

abstract class h
  extends Drawable
  implements e
{
  Drawable cix;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.cix != null) {
      a.a(this.cix, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.cix != null)
    {
      this.cix.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    if (this.cix != null) {
      return a.q(this.cix);
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    if (this.cix != null) {
      return this.cix.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    if (this.cix != null) {
      return this.cix.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.cix != null) {
      return this.cix.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.cix != null) {
      return this.cix.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.cix != null) {
      return this.cix.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.cix != null) {
      return this.cix.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    if (this.cix != null) {
      a.m(this.cix);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.cix != null)
    {
      this.cix.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.cix != null) {
      return this.cix.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.cix != null)
    {
      this.cix.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.cix != null)
    {
      this.cix.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.cix != null) {
      this.cix.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.cix != null) {
      a.a(this.cix, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.cix != null) {
      a.a(this.cix, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.cix != null) {
      return this.cix.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.l.a.a.h
 * JD-Core Version:    0.7.0.1
 */