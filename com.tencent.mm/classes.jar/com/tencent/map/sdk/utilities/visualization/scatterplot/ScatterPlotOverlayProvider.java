package com.tencent.map.sdk.utilities.visualization.scatterplot;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import java.util.ArrayList;
import java.util.List;

public abstract class ScatterPlotOverlayProvider
  extends BaseOverlayProvider
{
  private List<ScatterLatLng> dataList = new ArrayList();
  private boolean mDraw3D = false;
  private int mType = 0;
  
  public ScatterPlotOverlayProvider data(List<ScatterLatLng> paramList)
  {
    if (paramList != null) {
      this.dataList = paramList;
    }
    return this;
  }
  
  public ScatterPlotOverlayProvider displayLevel(int paramInt)
  {
    super.displayLevel(paramInt);
    return this;
  }
  
  public ScatterPlotOverlayProvider enable3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
    return this;
  }
  
  public List<ScatterLatLng> getData()
  {
    return this.dataList;
  }
  
  public int getDisplayLevel()
  {
    return super.getDisplayLevel();
  }
  
  public int getMaxZoom()
  {
    return super.getMaxZoom();
  }
  
  public int getMinZoom()
  {
    return super.getMinZoom();
  }
  
  public float getOpacity()
  {
    return super.getOpacity();
  }
  
  public int getType()
  {
    return ScatterPlotOverlayProvider.ScatterPlotType.values()[this.mType].ordinal();
  }
  
  public int getZIndex()
  {
    return super.getZIndex();
  }
  
  public boolean isEnable3D()
  {
    return this.mDraw3D;
  }
  
  public boolean isVisibility()
  {
    return super.isVisibility();
  }
  
  public ScatterPlotOverlayProvider opacity(float paramFloat)
  {
    super.opacity(paramFloat);
    return this;
  }
  
  protected ScatterPlotOverlayProvider type(ScatterPlotOverlayProvider.ScatterPlotType paramScatterPlotType)
  {
    this.mType = paramScatterPlotType.ordinal();
    return this;
  }
  
  public ScatterPlotOverlayProvider visibility(boolean paramBoolean)
  {
    super.visibility(paramBoolean);
    return this;
  }
  
  public ScatterPlotOverlayProvider zIndex(int paramInt)
  {
    super.zIndex(paramInt);
    return this;
  }
  
  public ScatterPlotOverlayProvider zoomRange(int paramInt1, int paramInt2)
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
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider
 * JD-Core Version:    0.7.0.1
 */