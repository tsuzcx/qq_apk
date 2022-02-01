package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Builder;

public class VisualLayerOptionsBuilder
  implements Builder<VisualLayerOptions>
{
  protected final VisualLayerOptions mLayerOptions;
  
  VisualLayerOptionsBuilder(VisualLayerOptions paramVisualLayerOptions)
  {
    this.mLayerOptions = paramVisualLayerOptions;
  }
  
  public VisualLayerOptions build()
  {
    return this.mLayerOptions;
  }
  
  public VisualLayerOptionsBuilder setAlpha(float paramFloat)
  {
    this.mLayerOptions.mAlpha = paramFloat;
    return this;
  }
  
  public VisualLayerOptionsBuilder setLevel(int paramInt)
  {
    this.mLayerOptions.mLevel = paramInt;
    return this;
  }
  
  public VisualLayerOptionsBuilder setTimeInterval(int paramInt)
  {
    this.mLayerOptions.mTimeInternal = paramInt;
    return this;
  }
  
  public VisualLayerOptionsBuilder setZIndex(int paramInt)
  {
    this.mLayerOptions.mZIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.comps.vis.VisualLayerOptionsBuilder
 * JD-Core Version:    0.7.0.1
 */