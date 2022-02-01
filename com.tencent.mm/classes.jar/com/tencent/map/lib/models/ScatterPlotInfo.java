package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ScatterPlotInfo
{
  protected int activeIndex;
  protected double[] circleStartPoints;
  protected int colorMapSize;
  protected int[] colors;
  protected float[] colorsPoints;
  protected boolean draw3D;
  protected boolean intensityFlag;
  protected int level;
  protected boolean mAnimate;
  protected int mBitmapHeight;
  protected int mBitmapWidth;
  protected Bitmap[] mBitmaps;
  protected int mMaxRadius;
  protected int mMinRadius;
  protected int mStrokeColor;
  protected int mStrokeWidth;
  protected int mType;
  protected float maxIntensity;
  protected int maxZoom;
  protected float minIntensity;
  protected int minZoom;
  protected int[] nodeIndexes;
  protected ScatterLatLng[] notes;
  protected float opacity;
  protected int radius;
  protected boolean visible;
  protected int zIndex;
  
  public ScatterPlotInfo()
  {
    AppMethodBeat.i(210931);
    this.activeIndex = 0;
    this.mType = 0;
    this.level = 1;
    this.zIndex = 0;
    this.draw3D = false;
    this.colorMapSize = 200;
    this.mAnimate = false;
    this.intensityFlag = false;
    this.mMinRadius = 0;
    this.mMaxRadius = 30;
    this.mStrokeColor = -1;
    this.mStrokeWidth = 4;
    this.notes = new ScatterLatLng[0];
    this.nodeIndexes = new int[0];
    this.mBitmaps = new Bitmap[0];
    AppMethodBeat.o(210931);
  }
  
  public boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public void setActiveIndex(int paramInt)
  {
    this.activeIndex = paramInt;
  }
  
  public void setAnimate(boolean paramBoolean)
  {
    this.mAnimate = paramBoolean;
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.colors = paramArrayOfInt;
  }
  
  public void setColorsPoints(double[] paramArrayOfDouble)
  {
    this.circleStartPoints = paramArrayOfDouble;
  }
  
  public void setColorsPoints(float[] paramArrayOfFloat)
  {
    this.colorsPoints = paramArrayOfFloat;
  }
  
  public void setDataList(List<Collection<ScatterLatLng>> paramList)
  {
    AppMethodBeat.i(210939);
    if (paramList == null)
    {
      this.notes = new ScatterLatLng[0];
      this.nodeIndexes = new int[0];
      AppMethodBeat.o(210939);
      return;
    }
    this.nodeIndexes = new int[paramList.size()];
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Collection localCollection = (Collection)paramList.get(i);
      this.nodeIndexes[i] = localCollection.size();
      localArrayList.addAll(localCollection);
      i += 1;
    }
    this.notes = ((ScatterLatLng[])localArrayList.toArray(new ScatterLatLng[0]));
    AppMethodBeat.o(210939);
  }
  
  public void setDraw3D(boolean paramBoolean)
  {
    this.draw3D = paramBoolean;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setMaxZoom(int paramInt)
  {
    this.maxZoom = paramInt;
  }
  
  public void setMinZoom(int paramInt)
  {
    this.minZoom = paramInt;
  }
  
  public void setOpacity(float paramFloat)
  {
    this.opacity = paramFloat;
  }
  
  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
  
  public void setzIndex(int paramInt)
  {
    this.zIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.ScatterPlotInfo
 * JD-Core Version:    0.7.0.1
 */