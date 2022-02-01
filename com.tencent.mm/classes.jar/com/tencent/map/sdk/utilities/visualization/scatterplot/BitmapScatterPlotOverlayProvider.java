package com.tencent.map.sdk.utilities.visualization.scatterplot;

import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import java.util.List;

public final class BitmapScatterPlotOverlayProvider
  extends ScatterPlotOverlayProvider
{
  private static final BitmapDescriptor[] DEFAULT_BITMAP_ICONS = new BitmapDescriptor[0];
  private int DEFAULT_HEIGHT;
  private int DEFAULT_WIDTH;
  private BitmapDescriptor[] mBitmaps;
  private int mHeight;
  private int mWidth;
  
  public BitmapScatterPlotOverlayProvider()
  {
    AppMethodBeat.i(211071);
    this.DEFAULT_WIDTH = 30;
    this.DEFAULT_HEIGHT = 30;
    this.mWidth = this.DEFAULT_WIDTH;
    this.mHeight = this.DEFAULT_HEIGHT;
    this.mBitmaps = DEFAULT_BITMAP_ICONS;
    type(ScatterPlotOverlayProvider.ScatterPlotType.Bitmap);
    AppMethodBeat.o(211071);
  }
  
  public final BitmapScatterPlotOverlayProvider bitmaps(BitmapDescriptor[] paramArrayOfBitmapDescriptor)
  {
    if (this.mBitmaps.length > 0) {}
    while ((this.mBitmaps.length != 0) || (paramArrayOfBitmapDescriptor == null)) {
      return this;
    }
    this.mBitmaps = paramArrayOfBitmapDescriptor;
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider data(List<ScatterLatLng> paramList)
  {
    AppMethodBeat.i(211104);
    super.data(paramList);
    AppMethodBeat.o(211104);
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider displayLevel(int paramInt)
  {
    AppMethodBeat.i(211187);
    super.displayLevel(paramInt);
    AppMethodBeat.o(211187);
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider enable3D(boolean paramBoolean)
  {
    AppMethodBeat.i(211136);
    super.enable3D(paramBoolean);
    AppMethodBeat.o(211136);
    return this;
  }
  
  public final BitmapDescriptor[] getBitmaps()
  {
    return this.mBitmaps;
  }
  
  public final List<ScatterLatLng> getData()
  {
    AppMethodBeat.i(211107);
    List localList = super.getData();
    AppMethodBeat.o(211107);
    return localList;
  }
  
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(211182);
    int i = super.getDisplayLevel();
    AppMethodBeat.o(211182);
    return i;
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(211153);
    int i = super.getMaxZoom();
    AppMethodBeat.o(211153);
    return i;
  }
  
  public final int getMinZoom()
  {
    AppMethodBeat.i(211148);
    int i = super.getMinZoom();
    AppMethodBeat.o(211148);
    return i;
  }
  
  public final float getOpacity()
  {
    AppMethodBeat.i(211115);
    float f = super.getOpacity();
    AppMethodBeat.o(211115);
    return f;
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public final int getZIndex()
  {
    AppMethodBeat.i(211173);
    int i = super.getZIndex();
    AppMethodBeat.o(211173);
    return i;
  }
  
  public final boolean isEnable3D()
  {
    AppMethodBeat.i(211129);
    boolean bool = super.isEnable3D();
    AppMethodBeat.o(211129);
    return bool;
  }
  
  public final boolean isVisibility()
  {
    AppMethodBeat.i(211160);
    boolean bool = super.isVisibility();
    AppMethodBeat.o(211160);
    return bool;
  }
  
  public final BitmapScatterPlotOverlayProvider opacity(float paramFloat)
  {
    AppMethodBeat.i(211122);
    super.opacity(paramFloat);
    AppMethodBeat.o(211122);
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider scale(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider visibility(boolean paramBoolean)
  {
    AppMethodBeat.i(211166);
    super.visibility(paramBoolean);
    AppMethodBeat.o(211166);
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider zIndex(int paramInt)
  {
    AppMethodBeat.i(211176);
    super.zIndex(paramInt);
    AppMethodBeat.o(211176);
    return this;
  }
  
  public final BitmapScatterPlotOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211141);
    super.zoomRange(paramInt1, paramInt2);
    AppMethodBeat.o(211141);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider
 * JD-Core Version:    0.7.0.1
 */