package com.tencent.map.lib.models;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AggregationOverlayInfo
{
  private static final float DEFAULT_MAX_OPACITY = 1.0F;
  private static final float DEFAULT_MIN_OPACITY = 0.0F;
  protected boolean mAnimate;
  protected int mAnimateDuration;
  protected int[] mColors;
  protected int mDisplayLevel;
  protected boolean mDraw3D;
  protected float mGap;
  protected double mMaxHeight;
  protected double mMaxIntensity;
  protected int mMaxZoom;
  protected double mMinHeight;
  protected double mMinIntensity;
  protected int mMinZoom;
  protected WeightedLatLng[] mNodes;
  protected float mOpacity;
  protected boolean mRangeFlag;
  protected float mSize;
  protected double[] mStartPoints;
  protected int mType;
  protected boolean mVisibility;
  protected int mZIndex;
  
  public AggregationOverlayInfo()
  {
    AppMethodBeat.i(210960);
    this.mType = 0;
    this.mSize = 2000.0F;
    this.mGap = 0.0F;
    this.mOpacity = 1.0F;
    this.mVisibility = true;
    this.mMinZoom = 3;
    this.mMaxZoom = 22;
    this.mDisplayLevel = 1;
    this.mZIndex = 0;
    this.mMinHeight = 0.0D;
    this.mMaxHeight = 1000.0D;
    this.mMinIntensity = 0.0D;
    this.mMaxIntensity = 2000.0D;
    this.mRangeFlag = false;
    this.mColors = new int[] { 1174031124, -1711650028, -637908204 };
    this.mStartPoints = new double[] { 0.0D, 0.6D, 0.8D };
    this.mDraw3D = false;
    this.mAnimate = false;
    this.mAnimateDuration = 5000;
    this.mNodes = new WeightedLatLng[0];
    AppMethodBeat.o(210960);
  }
  
  public boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public void setAnimate(boolean paramBoolean)
  {
    this.mAnimate = paramBoolean;
  }
  
  public void setAnimateTime(int paramInt)
  {
    this.mAnimateDuration = paramInt;
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
  }
  
  public void setDisplayLevel(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      this.mDisplayLevel = paramInt;
    }
  }
  
  public void setDraw3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
  }
  
  public void setGap(float paramFloat)
  {
    this.mGap = paramFloat;
  }
  
  public void setHeightRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMaxHeight = paramDouble2;
      this.mMinHeight = paramDouble1;
      return;
    }
    this.mMinHeight = 0.0D;
    this.mMaxHeight = 1000.0D;
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
    if (paramFloat > 1.0F) {
      this.mOpacity = 1.0F;
    }
    for (;;)
    {
      this.mOpacity = paramFloat;
      return;
      if (paramFloat < 0.0F) {
        this.mOpacity = 0.0F;
      } else {
        this.mOpacity = paramFloat;
      }
    }
  }
  
  public void setShowRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMinIntensity = paramDouble1;
      this.mMaxIntensity = paramDouble2;
      this.mRangeFlag = true;
      return;
    }
    this.mMinIntensity = 0.0D;
    this.mMaxIntensity = 2000.0D;
    this.mRangeFlag = false;
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
  
  public void setZIndex(int paramInt)
  {
    this.mZIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.AggregationOverlayInfo
 * JD-Core Version:    0.7.0.1
 */