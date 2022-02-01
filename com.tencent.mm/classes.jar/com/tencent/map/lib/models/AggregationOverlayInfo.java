package com.tencent.map.lib.models;

import androidx.annotation.Keep;
import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class AggregationOverlayInfo
{
  protected int[] mColors;
  protected float mGap;
  protected int mMaxZoom;
  protected int mMinZoom;
  protected WeightedLatLng[] mNodes;
  protected float mOpacity;
  protected float mSize;
  protected double[] mStartPoints;
  protected int mType;
  protected boolean mVisibility;
  
  public AggregationOverlayInfo()
  {
    AppMethodBeat.i(235882);
    this.mType = 0;
    this.mSize = 2000.0F;
    this.mGap = 0.0F;
    this.mOpacity = 1.0F;
    this.mVisibility = true;
    this.mMinZoom = 3;
    this.mMaxZoom = 22;
    this.mColors = new int[] { 1174031124, -1711650028, -637908204 };
    this.mStartPoints = new double[] { 0.0D, 0.6D, 0.8D };
    AppMethodBeat.o(235882);
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
  }
  
  public void setGap(float paramFloat)
  {
    this.mGap = paramFloat;
  }
  
  public void setMaxZoom(int paramInt)
  {
    this.mMaxZoom = paramInt;
  }
  
  public void setMinZoom(int paramInt)
  {
    this.mMinZoom = paramInt;
  }
  
  public void setNodes(WeightedLatLng[] paramArrayOfWeightedLatLng)
  {
    this.mNodes = paramArrayOfWeightedLatLng;
  }
  
  public void setOpacity(float paramFloat)
  {
    this.mOpacity = paramFloat;
  }
  
  public void setSize(float paramFloat)
  {
    this.mSize = paramFloat;
  }
  
  public void setStartPoints(double[] paramArrayOfDouble)
  {
    this.mStartPoints = paramArrayOfDouble;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.models.AggregationOverlayInfo
 * JD-Core Version:    0.7.0.1
 */