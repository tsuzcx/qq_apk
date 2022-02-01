package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class mv
  extends ArcLineOverlayInfo
  implements mo
{
  ArcLineOverlayProvider a;
  
  public mv(ArcLineOverlayProvider paramArcLineOverlayProvider)
  {
    AppMethodBeat.i(221513);
    this.a = paramArcLineOverlayProvider;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramArcLineOverlayProvider.getData());
    setDataList(localArrayList);
    this.mType = 0;
    this.mOpacity = paramArcLineOverlayProvider.getOpacity();
    this.mVisibility = paramArcLineOverlayProvider.isVisibility();
    this.mMinZoom = paramArcLineOverlayProvider.getMinZoom();
    this.mMaxZoom = paramArcLineOverlayProvider.getMaxZoom();
    this.mWidth = paramArcLineOverlayProvider.getWidth();
    this.mZIndex = paramArcLineOverlayProvider.getZIndex();
    this.mDraw3D = paramArcLineOverlayProvider.isEnable3D();
    this.mAnimate = paramArcLineOverlayProvider.isAnimate();
    this.mAnimateDuration = paramArcLineOverlayProvider.getAnimateDuration();
    this.mHighLightDuration = paramArcLineOverlayProvider.getHighLightDuration();
    this.mAnimateColor = paramArcLineOverlayProvider.getAnimateColor();
    this.mColors = paramArcLineOverlayProvider.getColors();
    this.mColorPoints = paramArcLineOverlayProvider.getColorPoints();
    this.mColorMapSize = paramArcLineOverlayProvider.getColorMapSize();
    this.mDisplayLevel = paramArcLineOverlayProvider.getDisplayLevel();
    AppMethodBeat.o(221513);
  }
  
  private ArcLineOverlayProvider a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mv
 * JD-Core Version:    0.7.0.1
 */