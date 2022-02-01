package com.tencent.map.sdk.utilities.visualization.aggregation;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;

public abstract class AggregationOverlayProvider
  extends BaseOverlayProvider
{
  private static final int[] DEFAULT_COLORS = { Color.argb(255, 31, 44, 71), Color.argb(255, 40, 72, 138), Color.argb(255, 38, 97, 217), Color.argb(255, 90, 140, 242), Color.argb(255, 153, 187, 255) };
  private static final double DEFAULT_MAX_HEIGHT = 100.0D;
  private static final int DEFAULT_MAX_INTENSITY = 2000;
  private static final double DEFAULT_MIN_HEIGHT = 0.0D;
  private static final int DEFAULT_MIN_INTENSITY = 0;
  private static final int DEFAULT_MIN_SIZE = 10;
  private static final int DEFAULT_SIZE = 2000;
  private static final double[] DEFAULT_START_POINTS = { 0.0D, 0.1000000014901161D, 0.1500000059604645D, 0.300000011920929D, 0.5D };
  private boolean mAnimate = false;
  private int mAnimateDuration = 0;
  private int[] mColors = DEFAULT_COLORS;
  private boolean mDraw3D = false;
  private float mGap = 0.0F;
  private double mMaxHeight = 100.0D;
  private double mMaxIntensity = 2000.0D;
  private double mMinHeight = 0.0D;
  private double mMinIntensity = 0.0D;
  private WeightedLatLng[] mNodes;
  private boolean mRangeFlag = false;
  private float mSize = 2000.0F;
  private double[] mStartPoints = DEFAULT_START_POINTS;
  private int mType = 0;
  
  public AggregationOverlayProvider colors(int[] paramArrayOfInt, double[] paramArrayOfDouble)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfDouble != null) && (paramArrayOfInt.length > 0) && (paramArrayOfDouble.length > 0) && (paramArrayOfInt.length == paramArrayOfDouble.length))
    {
      i = 1;
      if (i >= paramArrayOfDouble.length) {
        break label90;
      }
      if (paramArrayOfDouble[(i - 1)] <= paramArrayOfDouble[i]) {
        break label83;
      }
    }
    label83:
    label90:
    for (int i = 0;; i = 1)
    {
      if ((i == 1) && (paramArrayOfDouble[0] >= 0.0D) && (paramArrayOfDouble[(paramArrayOfDouble.length - 1)] <= 1.0D))
      {
        this.mColors = paramArrayOfInt;
        this.mStartPoints = paramArrayOfDouble;
      }
      return this;
      i += 1;
      break;
    }
  }
  
  public AggregationOverlayProvider displayLevel(int paramInt)
  {
    super.displayLevel(paramInt);
    return this;
  }
  
  public AggregationOverlayProvider enable3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
    return this;
  }
  
  public AggregationOverlayProvider gap(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.mGap = paramFloat;
    }
    return this;
  }
  
  public int getAnimateDuration()
  {
    return this.mAnimateDuration;
  }
  
  public int[] getColors()
  {
    return this.mColors;
  }
  
  public int getDisplayLevel()
  {
    return super.getDisplayLevel();
  }
  
  public float getGap()
  {
    return this.mGap;
  }
  
  public double getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public double getMaxIntensity()
  {
    return this.mMaxIntensity;
  }
  
  public int getMaxZoom()
  {
    return super.getMaxZoom();
  }
  
  public double getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public double getMinIntensity()
  {
    return this.mMinIntensity;
  }
  
  public int getMinZoom()
  {
    return super.getMinZoom();
  }
  
  public WeightedLatLng[] getNodes()
  {
    return this.mNodes;
  }
  
  public float getOpacity()
  {
    return super.getOpacity();
  }
  
  AggregationOverlayProvider.AggregationOverlayType getOverlayType()
  {
    return AggregationOverlayProvider.AggregationOverlayType.values()[this.mType];
  }
  
  public boolean getRangeFlag()
  {
    return this.mRangeFlag;
  }
  
  public float getSize()
  {
    return this.mSize;
  }
  
  public double[] getStartPoints()
  {
    return this.mStartPoints;
  }
  
  public int getType()
  {
    return getOverlayType().ordinal();
  }
  
  public int getZIndex()
  {
    return super.getZIndex();
  }
  
  public boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public boolean isEnable3D()
  {
    return this.mDraw3D;
  }
  
  public boolean isVisibility()
  {
    return super.isVisibility();
  }
  
  public AggregationOverlayProvider nodes(WeightedLatLng[] paramArrayOfWeightedLatLng)
  {
    if (paramArrayOfWeightedLatLng != null) {
      this.mNodes = paramArrayOfWeightedLatLng;
    }
    return this;
  }
  
  public AggregationOverlayProvider opacity(float paramFloat)
  {
    super.opacity(paramFloat);
    return this;
  }
  
  public AggregationOverlayProvider setAnimateDuration(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mAnimate = false;
      this.mAnimateDuration = 0;
    }
    while (paramInt <= 0) {
      return this;
    }
    this.mAnimateDuration = paramInt;
    this.mAnimate = true;
    return this;
  }
  
  public AggregationOverlayProvider setHeightRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMaxHeight = paramDouble2;
      this.mMinHeight = paramDouble1;
    }
    return this;
  }
  
  public AggregationOverlayProvider setIntensityRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMaxIntensity = paramDouble2;
      this.mMinIntensity = paramDouble1;
      this.mRangeFlag = true;
    }
    return this;
  }
  
  public AggregationOverlayProvider size(float paramFloat)
  {
    if (paramFloat < 10.0F) {
      return this;
    }
    this.mSize = paramFloat;
    return this;
  }
  
  protected AggregationOverlayProvider type(AggregationOverlayProvider.AggregationOverlayType paramAggregationOverlayType)
  {
    this.mType = paramAggregationOverlayType.ordinal();
    return this;
  }
  
  public AggregationOverlayProvider visibility(boolean paramBoolean)
  {
    super.visibility(paramBoolean);
    return this;
  }
  
  public AggregationOverlayProvider zIndex(int paramInt)
  {
    super.zIndex(paramInt);
    return this;
  }
  
  public AggregationOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      super.minZoom(paramInt1);
      super.maxZoom(paramInt2);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider
 * JD-Core Version:    0.7.0.1
 */