package com.tencent.map.lib.models;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HeatmapInfo
{
  private static final float DEFAULT_MAX_OPACITY = 1.0F;
  private static final float DEFAULT_MIN_OPACITY = 0.0F;
  protected int activeIndex;
  protected int colorMapSize;
  protected float[] colorPoints;
  protected int[] colors;
  protected boolean draw3D;
  protected boolean intensityFlag;
  protected int level;
  protected boolean mAnimate;
  protected int mAnimateDuration;
  protected float maxHeight;
  protected float maxIntensity;
  protected int maxZoom;
  protected float minIntensity;
  protected int minZoom;
  protected int[] nodeIndexes;
  protected WeightedLatLng[] notes;
  protected float opacity;
  protected int radius;
  protected int sample;
  protected boolean visible;
  protected int zIndex;
  
  public HeatmapInfo()
  {
    AppMethodBeat.i(210935);
    this.activeIndex = 0;
    this.level = 1;
    this.zIndex = 0;
    this.sample = 4;
    this.maxHeight = 1000.0F;
    this.draw3D = false;
    this.intensityFlag = false;
    this.maxIntensity = 0.0F;
    this.minIntensity = 0.0F;
    this.mAnimate = false;
    this.mAnimateDuration = 5000;
    this.notes = new WeightedLatLng[0];
    this.nodeIndexes = new int[0];
    AppMethodBeat.o(210935);
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
  
  public void setAnimateTime(int paramInt)
  {
    this.mAnimateDuration = paramInt;
  }
  
  public void setColorPoints(float[] paramArrayOfFloat)
  {
    this.colorPoints = paramArrayOfFloat;
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    this.colors = paramArrayOfInt;
  }
  
  public void setDataList(List<Collection<WeightedLatLng>> paramList)
  {
    AppMethodBeat.i(210942);
    if (paramList == null)
    {
      this.notes = new WeightedLatLng[0];
      this.nodeIndexes = new int[0];
      AppMethodBeat.o(210942);
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
    this.notes = ((WeightedLatLng[])localArrayList.toArray(new WeightedLatLng[0]));
    AppMethodBeat.o(210942);
  }
  
  public void setDraw3D(boolean paramBoolean)
  {
    this.draw3D = paramBoolean;
  }
  
  public void setLevel(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      this.level = paramInt;
    }
  }
  
  public void setMaxHeight(float paramFloat)
  {
    this.maxHeight = paramFloat;
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
    if (paramFloat > 1.0F)
    {
      this.opacity = 1.0F;
      return;
    }
    if (paramFloat < 0.0F)
    {
      this.opacity = 0.0F;
      return;
    }
    this.opacity = paramFloat;
  }
  
  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }
  
  public void setSample(int paramInt)
  {
    this.sample = paramInt;
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
 * Qualified Name:     com.tencent.map.lib.models.HeatmapInfo
 * JD-Core Version:    0.7.0.1
 */