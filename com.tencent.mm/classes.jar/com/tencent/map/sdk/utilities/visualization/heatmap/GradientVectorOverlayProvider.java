package com.tencent.map.sdk.utilities.visualization.heatmap;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GradientVectorOverlayProvider
  extends BaseOverlayProvider
{
  private static final boolean DEFAULT_ANIMATE = false;
  private static final int DEFAULT_ANIMATE_TIME = 0;
  private static final int DEFAULT_COLOR_MAP_SIZE = 500;
  private static final boolean DEFAULT_DRAW_3D = false;
  private static final int[] DEFAULT_GRADIENT_COLORS;
  private static final float[] DEFAULT_GRADIENT_START_POINTS;
  public static final float DEFAULT_MAX_HEIGHT = 60.0F;
  public static final float DEFAULT_MAX_INTENSITY = 2000.0F;
  public static final float DEFAULT_MIN_INTENSITY = 0.0F;
  public static final float DEFAULT_OPACITY = 1.0F;
  public static final int DEFAULT_RADIUS = 30;
  private static final int MAX_RADIUS = 150;
  private static final int MIN_RADIUS = 18;
  private int colorMapSize;
  private float[] colorPoints;
  private int[] colors;
  private List<WeightedLatLng> dataList;
  private boolean draw3D;
  private boolean intensityFlag;
  private boolean mAnimate;
  private int mAnimationDuration;
  private float maxHeight;
  private float maxIntensity;
  private float minIntensity;
  private int radius;
  
  static
  {
    AppMethodBeat.i(211098);
    DEFAULT_GRADIENT_COLORS = new int[] { Color.argb(255, 77, 111, 255), Color.argb(255, 0, 238, 227), Color.argb(255, 113, 236, 80), Color.argb(255, 255, 176, 0), Color.argb(255, 255, 72, 0) };
    DEFAULT_GRADIENT_START_POINTS = new float[] { 0.1F, 0.185F, 0.3571F, 0.6142F, 1.0F };
    AppMethodBeat.o(211098);
  }
  
  public GradientVectorOverlayProvider()
  {
    AppMethodBeat.i(211087);
    this.dataList = new ArrayList();
    this.maxHeight = 60.0F;
    this.radius = 30;
    this.colors = DEFAULT_GRADIENT_COLORS;
    this.colorPoints = DEFAULT_GRADIENT_START_POINTS;
    this.colorMapSize = 500;
    this.draw3D = false;
    this.maxIntensity = 2000.0F;
    this.minIntensity = 0.0F;
    this.intensityFlag = false;
    this.mAnimate = false;
    this.mAnimationDuration = 0;
    AppMethodBeat.o(211087);
  }
  
  private static List<WeightedLatLng> wrapData(List<LatLng> paramList)
  {
    AppMethodBeat.i(211090);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramList.next()));
    }
    AppMethodBeat.o(211090);
    return localArrayList;
  }
  
  public GradientVectorOverlayProvider data(List<LatLng> paramList)
  {
    AppMethodBeat.i(211172);
    paramList = weightedData(wrapData(paramList));
    AppMethodBeat.o(211172);
    return paramList;
  }
  
  public GradientVectorOverlayProvider displayLevel(int paramInt)
  {
    AppMethodBeat.i(211130);
    super.displayLevel(paramInt);
    AppMethodBeat.o(211130);
    return this;
  }
  
  public GradientVectorOverlayProvider enable3D(boolean paramBoolean)
  {
    this.draw3D = paramBoolean;
    return this;
  }
  
  public int getAnimateDuration()
  {
    return this.mAnimationDuration;
  }
  
  public int getColorMapSize()
  {
    return this.colorMapSize;
  }
  
  public float[] getColorPoints()
  {
    return this.colorPoints;
  }
  
  public int[] getColors()
  {
    return this.colors;
  }
  
  public List<WeightedLatLng> getData()
  {
    return this.dataList;
  }
  
  public int getDisplayLevel()
  {
    AppMethodBeat.i(211124);
    int i = super.getDisplayLevel();
    AppMethodBeat.o(211124);
    return i;
  }
  
  public float getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public float getMaxIntensity()
  {
    return this.maxIntensity;
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(211154);
    int i = super.getMaxZoom();
    AppMethodBeat.o(211154);
    return i;
  }
  
  public float getMinIntensity()
  {
    return this.minIntensity;
  }
  
  public int getMinZoom()
  {
    AppMethodBeat.i(211151);
    int i = super.getMinZoom();
    AppMethodBeat.o(211151);
    return i;
  }
  
  public float getOpacity()
  {
    AppMethodBeat.i(211102);
    float f = super.getOpacity();
    AppMethodBeat.o(211102);
    return f;
  }
  
  public int getRadius()
  {
    return this.radius;
  }
  
  public int getZIndex()
  {
    AppMethodBeat.i(211110);
    int i = super.getZIndex();
    AppMethodBeat.o(211110);
    return i;
  }
  
  public GradientVectorOverlayProvider gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfFloat != null) && (paramArrayOfInt.length > 0) && (paramArrayOfFloat.length > 0) && (paramArrayOfInt.length == paramArrayOfFloat.length))
    {
      i = 1;
      if (i >= paramArrayOfFloat.length) {
        break label90;
      }
      if (paramArrayOfFloat[(i - 1)] <= paramArrayOfFloat[i]) {
        break label83;
      }
    }
    label83:
    label90:
    for (int i = 0;; i = 1)
    {
      if ((i == 1) && (paramArrayOfFloat[0] >= 0.0F) && (paramArrayOfFloat[(paramArrayOfFloat.length - 1)] <= 1.0F))
      {
        this.colors = paramArrayOfInt;
        this.colorPoints = paramArrayOfFloat;
      }
      return this;
      i += 1;
      break;
    }
  }
  
  public boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public boolean isEnable3D()
  {
    return this.draw3D;
  }
  
  public boolean isIntensityFlag()
  {
    return this.intensityFlag;
  }
  
  public boolean isVisibility()
  {
    AppMethodBeat.i(211139);
    boolean bool = super.isVisibility();
    AppMethodBeat.o(211139);
    return bool;
  }
  
  public GradientVectorOverlayProvider opacity(float paramFloat)
  {
    AppMethodBeat.i(211105);
    super.opacity(paramFloat);
    AppMethodBeat.o(211105);
    return this;
  }
  
  public GradientVectorOverlayProvider radius(int paramInt)
  {
    if ((paramInt < 18) || (paramInt > 150)) {
      return this;
    }
    this.radius = paramInt;
    return this;
  }
  
  public GradientVectorOverlayProvider setAnimateDuration(int paramInt)
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
  
  public GradientVectorOverlayProvider setIntensityRange(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < paramFloat2) && (paramFloat1 >= 0.0F))
    {
      this.maxIntensity = paramFloat2;
      this.minIntensity = paramFloat1;
      this.intensityFlag = true;
      return this;
    }
    this.intensityFlag = false;
    return this;
  }
  
  public GradientVectorOverlayProvider setMaxHeight(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.maxHeight = paramFloat;
    }
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211256);
    String str = "GradientVectorOverlayProvider{dataList=" + this.dataList.size() + ", maxHeight=" + this.maxHeight + ", radius=" + this.radius + ", colors=" + Arrays.toString(this.colors) + ", colorPoints=" + Arrays.toString(this.colorPoints) + ", colorMapSize=" + this.colorMapSize + ", draw3D=" + this.draw3D + ", maxIntensity=" + this.maxIntensity + ", minIntensity=" + this.minIntensity + ", intensityFlag=" + this.intensityFlag + ", mAnimate=" + this.mAnimate + ", mAnimationDuration=" + this.mAnimationDuration + ", mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + '}';
    AppMethodBeat.o(211256);
    return str;
  }
  
  public GradientVectorOverlayProvider visibility(boolean paramBoolean)
  {
    AppMethodBeat.i(211142);
    super.visibility(paramBoolean);
    AppMethodBeat.o(211142);
    return this;
  }
  
  public GradientVectorOverlayProvider weightedData(List<WeightedLatLng> paramList)
  {
    if (paramList != null) {
      this.dataList = paramList;
    }
    return this;
  }
  
  public GradientVectorOverlayProvider zIndex(int paramInt)
  {
    AppMethodBeat.i(211118);
    super.zIndex(paramInt);
    AppMethodBeat.o(211118);
    return this;
  }
  
  public GradientVectorOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211163);
    if (paramInt1 <= paramInt2)
    {
      super.minZoom(paramInt1);
      super.maxZoom(paramInt2);
    }
    AppMethodBeat.o(211163);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider
 * JD-Core Version:    0.7.0.1
 */