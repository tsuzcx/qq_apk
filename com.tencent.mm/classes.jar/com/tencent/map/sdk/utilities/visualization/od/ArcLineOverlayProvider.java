package com.tencent.map.sdk.utilities.visualization.od;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ArcLineOverlayProvider
  extends BaseOverlayProvider
{
  private static final int DEFAULT_COLOR_MAP_SIZE = 200;
  private static final int[] DEFAULT_GRADIENT_COLORS;
  private static final float[] DEFAULT_GRADIENT_START_POINTS;
  private List<FromToLatLng> dataList;
  private boolean mAnimate;
  private int mAnimateColor;
  private int mAnimationDuration;
  protected int mColorMapSize;
  private float[] mColorPoints;
  private int[] mColors;
  private boolean mDraw3D;
  private int mHighLightDuration;
  private float mRadian;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(211162);
    DEFAULT_GRADIENT_COLORS = new int[] { Color.argb(255, 0, 128, 255), Color.argb(51, 0, 170, 255), Color.argb(255, 0, 128, 255) };
    DEFAULT_GRADIENT_START_POINTS = new float[] { 0.0F, 0.5F, 1.0F };
    AppMethodBeat.o(211162);
  }
  
  public ArcLineOverlayProvider()
  {
    AppMethodBeat.i(211157);
    this.dataList = new ArrayList();
    this.mWidth = 6.0F;
    this.mRadian = 45.0F;
    this.mDraw3D = false;
    this.mAnimate = true;
    this.mHighLightDuration = 200;
    this.mAnimationDuration = 2000;
    this.mAnimateColor = -10046465;
    this.mColors = DEFAULT_GRADIENT_COLORS;
    this.mColorPoints = DEFAULT_GRADIENT_START_POINTS;
    this.mColorMapSize = 200;
    AppMethodBeat.o(211157);
  }
  
  public final ArcLineOverlayProvider animateColor(int paramInt)
  {
    this.mAnimateColor = paramInt;
    return this;
  }
  
  public final ArcLineOverlayProvider data(List<FromToLatLng> paramList)
  {
    if (paramList != null) {
      this.dataList = paramList;
    }
    return this;
  }
  
  public final ArcLineOverlayProvider displayLevel(int paramInt)
  {
    AppMethodBeat.i(211207);
    super.displayLevel(paramInt);
    AppMethodBeat.o(211207);
    return this;
  }
  
  public final ArcLineOverlayProvider enable3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
    return this;
  }
  
  public final int getAnimateColor()
  {
    return this.mAnimateColor;
  }
  
  public final int getAnimateDuration()
  {
    return this.mAnimationDuration;
  }
  
  public final int getColorMapSize()
  {
    return this.mColorMapSize;
  }
  
  public final float[] getColorPoints()
  {
    return this.mColorPoints;
  }
  
  public final int[] getColors()
  {
    return this.mColors;
  }
  
  public final List<FromToLatLng> getData()
  {
    return this.dataList;
  }
  
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(211201);
    int i = super.getDisplayLevel();
    AppMethodBeat.o(211201);
    return i;
  }
  
  public final int getHighLightDuration()
  {
    return this.mHighLightDuration;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(211223);
    int i = super.getMaxZoom();
    AppMethodBeat.o(211223);
    return i;
  }
  
  public final int getMinZoom()
  {
    AppMethodBeat.i(211221);
    int i = super.getMinZoom();
    AppMethodBeat.o(211221);
    return i;
  }
  
  public final float getOpacity()
  {
    AppMethodBeat.i(211181);
    float f = super.getOpacity();
    AppMethodBeat.o(211181);
    return f;
  }
  
  public final float getRadian()
  {
    return this.mRadian;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int getZIndex()
  {
    AppMethodBeat.i(211191);
    int i = super.getZIndex();
    AppMethodBeat.o(211191);
    return i;
  }
  
  public final ArcLineOverlayProvider gradient(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length != 1) {
        break label57;
      }
      this.mColors = new int[] { paramArrayOfInt[0], paramArrayOfInt[0], paramArrayOfInt[0] };
      this.mColorPoints = new float[] { 0.0F, 0.5F, 1.0F };
    }
    label57:
    do
    {
      return this;
      if (paramArrayOfInt.length == 2)
      {
        this.mColors = paramArrayOfInt;
        this.mColorPoints = new float[] { 0.0F, 1.0F };
        return this;
      }
    } while (paramArrayOfInt.length != 3);
    this.mColors = paramArrayOfInt;
    this.mColorPoints = new float[] { 0.0F, 0.5F, 1.0F };
    return this;
  }
  
  public final boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public final boolean isEnable3D()
  {
    return this.mDraw3D;
  }
  
  public final boolean isVisibility()
  {
    AppMethodBeat.i(211213);
    boolean bool = super.isVisibility();
    AppMethodBeat.o(211213);
    return bool;
  }
  
  public final ArcLineOverlayProvider opacity(float paramFloat)
  {
    AppMethodBeat.i(211188);
    super.opacity(paramFloat);
    AppMethodBeat.o(211188);
    return this;
  }
  
  public final ArcLineOverlayProvider radian(float paramFloat)
  {
    AppMethodBeat.i(211254);
    if ((paramFloat > 0.0F) && (paramFloat <= 90.0F))
    {
      this.mRadian = paramFloat;
      Iterator localIterator = this.dataList.iterator();
      while (localIterator.hasNext()) {
        ((FromToLatLng)localIterator.next()).setArc(this.mRadian);
      }
    }
    AppMethodBeat.o(211254);
    return this;
  }
  
  public final ArcLineOverlayProvider setAnimateDuration(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mAnimate = false;
      this.mAnimationDuration = 0;
    }
    while (paramInt <= 0) {
      return this;
    }
    this.mAnimationDuration = paramInt;
    this.mAnimate = true;
    return this;
  }
  
  public final ArcLineOverlayProvider setHighlightDuration(int paramInt)
  {
    if (paramInt >= 0) {
      this.mHighLightDuration = paramInt;
    }
    return this;
  }
  
  public final ArcLineOverlayProvider visibility(boolean paramBoolean)
  {
    AppMethodBeat.i(211216);
    super.visibility(paramBoolean);
    AppMethodBeat.o(211216);
    return this;
  }
  
  public final ArcLineOverlayProvider width(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.mWidth = paramFloat;
    }
    return this;
  }
  
  public final ArcLineOverlayProvider zIndex(int paramInt)
  {
    AppMethodBeat.i(211196);
    super.zIndex(paramInt);
    AppMethodBeat.o(211196);
    return this;
  }
  
  public final ArcLineOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211227);
    if (paramInt1 <= paramInt2)
    {
      super.minZoom(paramInt1);
      super.maxZoom(paramInt2);
    }
    AppMethodBeat.o(211227);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider
 * JD-Core Version:    0.7.0.1
 */