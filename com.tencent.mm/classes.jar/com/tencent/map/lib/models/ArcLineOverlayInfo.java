package com.tencent.map.lib.models;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArcLineOverlayInfo
{
  private static final float DEFAULT_MAX_OPACITY = 1.0F;
  private static final float DEFAULT_MIN_OPACITY = 0.0F;
  protected int activeIndex;
  protected boolean mAnimate;
  protected int mAnimateColor;
  protected int mAnimateDuration;
  protected int mColorMapSize;
  protected float[] mColorPoints;
  protected int[] mColors;
  protected int mDisplayLevel;
  protected boolean mDraw3D;
  protected int mHighLightDuration;
  protected int mMaxZoom;
  protected int mMinZoom;
  protected float mOpacity;
  protected int mType;
  protected boolean mVisibility;
  protected float mWidth;
  protected int mZIndex;
  protected int[] nodeIndexes;
  protected FromToLatLng[] notes;
  
  public ArcLineOverlayInfo()
  {
    AppMethodBeat.i(210957);
    this.mType = 0;
    this.mZIndex = 0;
    this.activeIndex = 0;
    this.mOpacity = 1.0F;
    this.mVisibility = true;
    this.mMinZoom = 3;
    this.mMaxZoom = 22;
    this.mDisplayLevel = 1;
    this.mWidth = 4.0F;
    this.mColors = new int[] { Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170) };
    this.mColorPoints = new float[] { 0.0F, 0.5F, 1.0F };
    this.mColorMapSize = 200;
    this.mDraw3D = false;
    this.mAnimate = false;
    this.mHighLightDuration = 5000;
    this.mAnimateDuration = 5000;
    this.mAnimateColor = -16776961;
    this.notes = new FromToLatLng[0];
    this.nodeIndexes = new int[0];
    AppMethodBeat.o(210957);
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
  
  public void setAnimateDuration(int paramInt)
  {
    this.mAnimateDuration = paramInt;
  }
  
  public void setDataList(List<Collection<FromToLatLng>> paramList)
  {
    AppMethodBeat.i(210962);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.notes = new FromToLatLng[0];
      this.nodeIndexes = new int[0];
      AppMethodBeat.o(210962);
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
    this.notes = ((FromToLatLng[])localArrayList.toArray(new FromToLatLng[0]));
    AppMethodBeat.o(210962);
  }
  
  public void setDisplayLevel(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      this.mDisplayLevel = paramInt;
    }
  }
  
  public void setDraw3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
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
  
  public void setNodes(FromToLatLng[] paramArrayOfFromToLatLng)
  {
    this.notes = paramArrayOfFromToLatLng;
  }
  
  public void setOpacity(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      this.mOpacity = 1.0F;
      return;
    }
    if (paramFloat < 0.0F)
    {
      this.mOpacity = 0.0F;
      return;
    }
    this.mOpacity = paramFloat;
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
 * Qualified Name:     com.tencent.map.lib.models.ArcLineOverlayInfo
 * JD-Core Version:    0.7.0.1
 */