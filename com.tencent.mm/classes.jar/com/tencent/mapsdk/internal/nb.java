package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class nb
  extends HeatmapInfo
  implements mo
{
  GradientVectorOverlayProvider a;
  
  public nb(GradientVectorOverlayProvider paramGradientVectorOverlayProvider)
  {
    AppMethodBeat.i(221406);
    this.a = paramGradientVectorOverlayProvider;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGradientVectorOverlayProvider.getData());
    setDataList(localArrayList);
    this.radius = paramGradientVectorOverlayProvider.getRadius();
    this.colors = paramGradientVectorOverlayProvider.getColors();
    this.colorPoints = paramGradientVectorOverlayProvider.getColorPoints();
    this.colorMapSize = paramGradientVectorOverlayProvider.getColorMapSize();
    this.visible = paramGradientVectorOverlayProvider.isVisibility();
    this.opacity = paramGradientVectorOverlayProvider.getOpacity();
    this.maxZoom = paramGradientVectorOverlayProvider.getMaxZoom();
    this.minZoom = paramGradientVectorOverlayProvider.getMinZoom();
    this.maxHeight = paramGradientVectorOverlayProvider.getMaxHeight();
    this.draw3D = paramGradientVectorOverlayProvider.isEnable3D();
    this.maxIntensity = paramGradientVectorOverlayProvider.getMaxIntensity();
    this.minIntensity = paramGradientVectorOverlayProvider.getMinIntensity();
    this.intensityFlag = paramGradientVectorOverlayProvider.isIntensityFlag();
    this.mAnimate = paramGradientVectorOverlayProvider.isAnimate();
    this.mAnimateDuration = paramGradientVectorOverlayProvider.getAnimateDuration();
    this.level = paramGradientVectorOverlayProvider.getDisplayLevel();
    this.zIndex = paramGradientVectorOverlayProvider.getZIndex();
    new StringBuilder("java colors : ").append(this.colors.length);
    int i = 0;
    while (i < this.colors.length)
    {
      new StringBuilder("java colors: ").append(this.colors[i]);
      i += 1;
    }
    new StringBuilder("java opacity : ").append(this.opacity);
    new StringBuilder("java colorPoints : ").append(this.colorPoints.length);
    new StringBuilder("java colorMapSize : ").append(this.colorMapSize);
    new StringBuilder("java notes : ").append(this.notes.length);
    new StringBuilder("java nodeIndexes : ").append(this.nodeIndexes.length);
    AppMethodBeat.o(221406);
  }
  
  private GradientVectorOverlayProvider a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nb
 * JD-Core Version:    0.7.0.1
 */