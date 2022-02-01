package com.tencent.map.sdk.utilities.visualization.scatterplot;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class DotScatterPlotOverlayProvider
  extends ScatterPlotOverlayProvider
{
  private static final int[] DEFAULT_SCATTER_COLORS;
  private final int DEFAULT_RADIUS;
  private boolean mAnimate;
  private int[] mColors;
  private int mRadius;
  
  static
  {
    AppMethodBeat.i(211082);
    DEFAULT_SCATTER_COLORS = new int[] { Color.argb(255, 255, 202, 31), Color.argb(229, 204, 24, 93), Color.argb(127, 148, 28, 230) };
    AppMethodBeat.o(211082);
  }
  
  public DotScatterPlotOverlayProvider()
  {
    AppMethodBeat.i(211077);
    this.DEFAULT_RADIUS = 6;
    this.mRadius = 6;
    this.mColors = DEFAULT_SCATTER_COLORS;
    this.mAnimate = false;
    type(ScatterPlotOverlayProvider.ScatterPlotType.Dot);
    AppMethodBeat.o(211077);
  }
  
  public final DotScatterPlotOverlayProvider animate(boolean paramBoolean)
  {
    this.mAnimate = paramBoolean;
    return this;
  }
  
  public final DotScatterPlotOverlayProvider colors(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      this.mColors = paramArrayOfInt;
    }
    return this;
  }
  
  public final DotScatterPlotOverlayProvider data(List<ScatterLatLng> paramList)
  {
    AppMethodBeat.i(211111);
    super.data(paramList);
    AppMethodBeat.o(211111);
    return this;
  }
  
  public final DotScatterPlotOverlayProvider displayLevel(int paramInt)
  {
    AppMethodBeat.i(211194);
    super.displayLevel(paramInt);
    AppMethodBeat.o(211194);
    return this;
  }
  
  public final DotScatterPlotOverlayProvider enable3D(boolean paramBoolean)
  {
    AppMethodBeat.i(211144);
    super.enable3D(paramBoolean);
    AppMethodBeat.o(211144);
    return this;
  }
  
  public final int[] getColors()
  {
    return this.mColors;
  }
  
  public final List<ScatterLatLng> getData()
  {
    AppMethodBeat.i(211119);
    List localList = super.getData();
    AppMethodBeat.o(211119);
    return localList;
  }
  
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(211190);
    int i = super.getDisplayLevel();
    AppMethodBeat.o(211190);
    return i;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(211164);
    int i = super.getMaxZoom();
    AppMethodBeat.o(211164);
    return i;
  }
  
  public final int getMinZoom()
  {
    AppMethodBeat.i(211159);
    int i = super.getMinZoom();
    AppMethodBeat.o(211159);
    return i;
  }
  
  public final float getOpacity()
  {
    AppMethodBeat.i(211125);
    float f = super.getOpacity();
    AppMethodBeat.o(211125);
    return f;
  }
  
  public final int getRadius()
  {
    return this.mRadius;
  }
  
  public final int getZIndex()
  {
    AppMethodBeat.i(211180);
    int i = super.getZIndex();
    AppMethodBeat.o(211180);
    return i;
  }
  
  public final boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public final boolean isEnable3D()
  {
    AppMethodBeat.i(211140);
    boolean bool = super.isEnable3D();
    AppMethodBeat.o(211140);
    return bool;
  }
  
  public final boolean isVisibility()
  {
    AppMethodBeat.i(211171);
    boolean bool = super.isVisibility();
    AppMethodBeat.o(211171);
    return bool;
  }
  
  public final DotScatterPlotOverlayProvider opacity(float paramFloat)
  {
    AppMethodBeat.i(211131);
    super.opacity(paramFloat);
    AppMethodBeat.o(211131);
    return this;
  }
  
  public final DotScatterPlotOverlayProvider radius(int paramInt)
  {
    if (paramInt > 0) {
      this.mRadius = paramInt;
    }
    return this;
  }
  
  public final DotScatterPlotOverlayProvider visibility(boolean paramBoolean)
  {
    AppMethodBeat.i(211175);
    super.visibility(paramBoolean);
    AppMethodBeat.o(211175);
    return this;
  }
  
  public final DotScatterPlotOverlayProvider zIndex(int paramInt)
  {
    AppMethodBeat.i(211183);
    super.zIndex(paramInt);
    AppMethodBeat.o(211183);
    return this;
  }
  
  public final DotScatterPlotOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211152);
    super.zoomRange(paramInt1, paramInt2);
    AppMethodBeat.o(211152);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider
 * JD-Core Version:    0.7.0.1
 */