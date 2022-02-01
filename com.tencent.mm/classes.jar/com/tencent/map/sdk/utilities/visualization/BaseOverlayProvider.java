package com.tencent.map.sdk.utilities.visualization;

import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;

public abstract class BaseOverlayProvider
  implements VectorOverlayProvider
{
  private static final float DEFAULT_MAX_OPACITY = 1.0F;
  private static final int DEFAULT_MAX_ZOOM = 22;
  private static final float DEFAULT_MIN_OPACITY = 0.0F;
  private static final int DEFAULT_MIN_ZOOM = 3;
  private static final float DEFAULT_OPACITY = 1.0F;
  private static final int DEFAULT_ZINDEX = 0;
  protected int mDisplayLevel = 1;
  protected int mMaxZoom = 22;
  protected int mMinZoom = 4;
  protected float mOpacity = 1.0F;
  protected boolean mVisibility = true;
  protected int mZIndex = 0;
  
  public BaseOverlayProvider displayLevel(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      this.mDisplayLevel = paramInt;
    }
    return this;
  }
  
  public int getDisplayLevel()
  {
    return this.mDisplayLevel;
  }
  
  public int getMaxZoom()
  {
    return this.mMaxZoom;
  }
  
  public int getMinZoom()
  {
    return this.mMinZoom;
  }
  
  public float getOpacity()
  {
    return this.mOpacity;
  }
  
  public int getZIndex()
  {
    return this.mZIndex;
  }
  
  public boolean isVisibility()
  {
    return this.mVisibility;
  }
  
  public BaseOverlayProvider maxZoom(int paramInt)
  {
    if (paramInt <= 22)
    {
      this.mMaxZoom = paramInt;
      return this;
    }
    this.mMaxZoom = 22;
    return this;
  }
  
  public BaseOverlayProvider minZoom(int paramInt)
  {
    if (paramInt >= 3)
    {
      this.mMinZoom = paramInt;
      return this;
    }
    this.mMinZoom = 3;
    return this;
  }
  
  public BaseOverlayProvider opacity(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      this.mOpacity = 1.0F;
      return this;
    }
    if (paramFloat < 0.0F)
    {
      this.mOpacity = 0.0F;
      return this;
    }
    this.mOpacity = paramFloat;
    return this;
  }
  
  public String toString()
  {
    return "BaseOverlayProvider{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + '}';
  }
  
  public BaseOverlayProvider visibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
    return this;
  }
  
  public BaseOverlayProvider zIndex(int paramInt)
  {
    this.mZIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider
 * JD-Core Version:    0.7.0.1
 */