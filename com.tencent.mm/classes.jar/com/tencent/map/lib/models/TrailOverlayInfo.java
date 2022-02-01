package com.tencent.map.lib.models;

import com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrailOverlayInfo
{
  protected int activeIndex;
  protected int colorMapSize;
  protected float[] colorPoints;
  protected int[] colors;
  protected boolean mAnimate;
  protected int mAnimateColor;
  protected int mAnimateEndTime;
  protected int mAnimateStartTime;
  protected int mDisplayLevel;
  protected int mHighLightDuration;
  protected int mMaxZoom;
  protected int mMinZoom;
  protected float mOpacity;
  protected float mPlayRatio;
  protected int mPulseInterval;
  protected int mType;
  protected boolean mVisibility;
  protected float mWidth;
  protected int mZIndex;
  protected int[] nodeIndexes;
  protected TrailLatLng[] notes;
  
  public TrailOverlayInfo()
  {
    AppMethodBeat.i(210925);
    this.mType = 0;
    this.mZIndex = 0;
    this.activeIndex = 0;
    this.mOpacity = 1.0F;
    this.mVisibility = true;
    this.mMinZoom = 3;
    this.mMaxZoom = 22;
    this.mDisplayLevel = 1;
    this.mWidth = 4.0F;
    this.mAnimate = true;
    this.mHighLightDuration = 5000;
    this.mAnimateStartTime = 0;
    this.mAnimateEndTime = 2000;
    this.mAnimateColor = -16776961;
    this.colorMapSize = 200;
    this.mPlayRatio = 1.0F;
    this.mPulseInterval = 200;
    this.notes = new TrailLatLng[0];
    this.nodeIndexes = new int[0];
    AppMethodBeat.o(210925);
  }
  
  public int getAnimateColor()
  {
    return this.mAnimateColor;
  }
  
  public boolean getIsAnimate()
  {
    return this.mAnimate;
  }
  
  public void setActiveDataIndex(int paramInt)
  {
    this.activeIndex = paramInt;
  }
  
  public void setAnimate(boolean paramBoolean)
  {
    this.mAnimate = paramBoolean;
  }
  
  public void setAnimateColor(int paramInt)
  {
    this.mAnimateColor = paramInt;
  }
  
  public void setAnimateEndTime(int paramInt)
  {
    this.mAnimateEndTime = paramInt;
  }
  
  public void setAnimateStartTime(int paramInt)
  {
    this.mAnimateStartTime = paramInt;
  }
  
  public void setDataList(List<Collection<TrailLatLng>> paramList)
  {
    AppMethodBeat.i(210930);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.notes = new TrailLatLng[0];
      this.nodeIndexes = new int[0];
      AppMethodBeat.o(210930);
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
    this.notes = ((TrailLatLng[])localArrayList.toArray(new TrailLatLng[0]));
    AppMethodBeat.o(210930);
  }
  
  public void setDisplayLevel(int paramInt)
  {
    this.mDisplayLevel = paramInt;
  }
  
  public void setHighLightDuration(int paramInt)
  {
    this.mHighLightDuration = paramInt;
  }
  
  public void setMaxZoom(int paramInt)
  {
    this.mMaxZoom = paramInt;
  }
  
  public void setMinZoom(int paramInt)
  {
    this.mMinZoom = paramInt;
  }
  
  public void setNodes(TrailLatLng[] paramArrayOfTrailLatLng)
  {
    this.notes = paramArrayOfTrailLatLng;
  }
  
  public void setOpacity(float paramFloat)
  {
    this.mOpacity = paramFloat;
  }
  
  public void setPlayRatio(float paramFloat)
  {
    this.mPlayRatio = paramFloat;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
  }
  
  public void setWidth(float paramFloat)
  {
    this.mWidth = paramFloat;
  }
  
  public void setzIndex(int paramInt)
  {
    this.mZIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.TrailOverlayInfo
 * JD-Core Version:    0.7.0.1
 */