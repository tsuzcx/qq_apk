package com.tencent.map.sdk.comps.vis;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Options;

public class VisualLayerOptions
  implements Options<VisualLayerOptions, VisualLayerOptionsBuilder>
{
  float mAlpha = 1.0F;
  boolean mIsVisible = true;
  String mLayerId;
  int mLevel = 1;
  int mTimeInternal = 0;
  int mZIndex;
  
  public VisualLayerOptions(String paramString)
  {
    this.mLayerId = paramString;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public String getLayerId()
  {
    return this.mLayerId;
  }
  
  public int getLevel()
  {
    return this.mLevel;
  }
  
  public int getTimeInterval()
  {
    return this.mTimeInternal;
  }
  
  public int getZIndex()
  {
    return this.mZIndex;
  }
  
  public boolean isVisible()
  {
    return this.mIsVisible;
  }
  
  public VisualLayerOptionsBuilder newBuilder()
  {
    AppMethodBeat.i(211057);
    VisualLayerOptionsBuilder localVisualLayerOptionsBuilder = new VisualLayerOptionsBuilder(this);
    AppMethodBeat.o(211057);
    return localVisualLayerOptionsBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.comps.vis.VisualLayerOptions
 * JD-Core Version:    0.7.0.1
 */