package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions.VectorHeatOverlayType;

public class mr
  extends AggregationOverlayInfo
  implements mo
{
  AggregationOverlayProvider a;
  
  public mr(AggregationOverlayProvider paramAggregationOverlayProvider)
  {
    AppMethodBeat.i(222916);
    this.a = paramAggregationOverlayProvider;
    this.mNodes = paramAggregationOverlayProvider.getNodes();
    this.mType = paramAggregationOverlayProvider.getType();
    this.mColors = paramAggregationOverlayProvider.getColors();
    this.mSize = paramAggregationOverlayProvider.getSize();
    this.mGap = paramAggregationOverlayProvider.getGap();
    this.mOpacity = paramAggregationOverlayProvider.getOpacity();
    this.mVisibility = paramAggregationOverlayProvider.isVisibility();
    this.mMinZoom = paramAggregationOverlayProvider.getMinZoom();
    this.mMaxZoom = paramAggregationOverlayProvider.getMaxZoom();
    this.mColors = paramAggregationOverlayProvider.getColors();
    this.mStartPoints = paramAggregationOverlayProvider.getStartPoints();
    this.mDraw3D = paramAggregationOverlayProvider.isEnable3D();
    this.mMaxHeight = paramAggregationOverlayProvider.getMaxHeight();
    this.mMinHeight = paramAggregationOverlayProvider.getMinHeight();
    this.mMaxIntensity = paramAggregationOverlayProvider.getMaxIntensity();
    this.mMinIntensity = paramAggregationOverlayProvider.getMinIntensity();
    this.mRangeFlag = paramAggregationOverlayProvider.getRangeFlag();
    this.mAnimate = paramAggregationOverlayProvider.isAnimate();
    this.mAnimateDuration = paramAggregationOverlayProvider.getAnimateDuration();
    this.mDisplayLevel = paramAggregationOverlayProvider.getDisplayLevel();
    this.mZIndex = paramAggregationOverlayProvider.getZIndex();
    AppMethodBeat.o(222916);
  }
  
  public mr(VectorHeatOverlayOptions paramVectorHeatOverlayOptions)
  {
    AppMethodBeat.i(222902);
    this.mNodes = paramVectorHeatOverlayOptions.getNodes();
    this.mType = paramVectorHeatOverlayOptions.getType().ordinal();
    this.mColors = paramVectorHeatOverlayOptions.getColors();
    this.mSize = paramVectorHeatOverlayOptions.getSize();
    this.mGap = paramVectorHeatOverlayOptions.getGap();
    this.mOpacity = paramVectorHeatOverlayOptions.getOpacity();
    this.mVisibility = paramVectorHeatOverlayOptions.isVisibility();
    this.mMinZoom = paramVectorHeatOverlayOptions.getMinZoom();
    this.mMaxZoom = paramVectorHeatOverlayOptions.getMaxZoom();
    this.mColors = paramVectorHeatOverlayOptions.getColors();
    this.mStartPoints = paramVectorHeatOverlayOptions.getStartPoints();
    this.mDraw3D = paramVectorHeatOverlayOptions.isDraw3D();
    this.mMaxHeight = paramVectorHeatOverlayOptions.getMaxHeight();
    this.mMinHeight = paramVectorHeatOverlayOptions.getMinHeight();
    this.mMaxIntensity = paramVectorHeatOverlayOptions.getMaxIntensity();
    this.mMinIntensity = paramVectorHeatOverlayOptions.getMinIntensity();
    this.mRangeFlag = paramVectorHeatOverlayOptions.getRangeFlag();
    this.mAnimate = paramVectorHeatOverlayOptions.isAnimate();
    this.mAnimateDuration = paramVectorHeatOverlayOptions.getAnimateTime();
    this.mDisplayLevel = paramVectorHeatOverlayOptions.getDisplayLevel();
    this.mZIndex = paramVectorHeatOverlayOptions.getZIndex();
    AppMethodBeat.o(222902);
  }
  
  private AggregationOverlayProvider a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mr
 * JD-Core Version:    0.7.0.1
 */