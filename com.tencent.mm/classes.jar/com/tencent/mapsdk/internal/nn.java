package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class nn
  extends TrailOverlayInfo
  implements mo
{
  TrailOverlayProvider a;
  
  public nn(TrailOverlayProvider paramTrailOverlayProvider)
  {
    AppMethodBeat.i(221592);
    this.a = paramTrailOverlayProvider;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTrailOverlayProvider.getData());
    setDataList(localArrayList);
    this.mType = paramTrailOverlayProvider.getType();
    this.mOpacity = paramTrailOverlayProvider.getOpacity();
    this.mVisibility = paramTrailOverlayProvider.isVisibility();
    this.mMinZoom = paramTrailOverlayProvider.getMinZoom();
    this.mMaxZoom = paramTrailOverlayProvider.getMaxZoom();
    this.mWidth = paramTrailOverlayProvider.getWidth();
    this.mZIndex = paramTrailOverlayProvider.getZIndex();
    this.mAnimateStartTime = paramTrailOverlayProvider.getAnimateStartTime();
    this.mAnimateEndTime = paramTrailOverlayProvider.getAnimateEndTime();
    this.mHighLightDuration = paramTrailOverlayProvider.getHighLightDuration();
    this.mPlayRatio = paramTrailOverlayProvider.getPlayRatio();
    this.mDisplayLevel = paramTrailOverlayProvider.getDisplayLevel();
    this.colorMapSize = paramTrailOverlayProvider.getColorMapSize();
    this.colorPoints = paramTrailOverlayProvider.getColorPoints();
    this.colors = paramTrailOverlayProvider.getColors();
    AppMethodBeat.o(221592);
  }
  
  private TrailOverlayProvider a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nn
 * JD-Core Version:    0.7.0.1
 */