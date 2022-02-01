package com.tencent.map.sdk.utilities.visualization.trails;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class TrailOverlayProvider
  extends BaseOverlayProvider
{
  private static final int DEFAULT_COLOR_MAP_SIZE = 200;
  private static final int[] DEFAULT_GRADIENT_COLORS;
  private static final float[] DEFAULT_GRADIENT_START_POINTS;
  private final int DEFAULT_ANIMATE_END_TIME;
  private final int DEFAULT_ANIMATE_START_TIME;
  private final int DEFAULT_HIGHLIGHT_DURATION;
  private final float DEFAULT_PLAY_RATIO;
  private final float DEFAULT_WIDTH;
  private List<TrailLatLng> dataList;
  private int mAnimatationEndTime;
  private int mAnimationStartTime;
  protected int mColorMapSize;
  private float[] mColorPoints;
  private int[] mColors;
  private int mHighLightDuration;
  private float mPlayRatio;
  private int mType;
  private float mWidth;
  
  static
  {
    AppMethodBeat.i(211103);
    DEFAULT_GRADIENT_COLORS = new int[] { Color.argb(255, 0, 128, 255), Color.argb(0, 0, 128, 255) };
    DEFAULT_GRADIENT_START_POINTS = new float[] { 0.0F, 1.0F };
    AppMethodBeat.o(211103);
  }
  
  public TrailOverlayProvider()
  {
    AppMethodBeat.i(211096);
    this.mType = 0;
    this.dataList = new ArrayList();
    this.DEFAULT_WIDTH = 6.0F;
    this.mWidth = 6.0F;
    this.DEFAULT_HIGHLIGHT_DURATION = 1000;
    this.DEFAULT_ANIMATE_START_TIME = 0;
    this.DEFAULT_ANIMATE_END_TIME = 2000;
    this.mHighLightDuration = 1000;
    this.mAnimationStartTime = 0;
    this.mAnimatationEndTime = 2000;
    this.DEFAULT_PLAY_RATIO = 1.0F;
    this.mPlayRatio = 1.0F;
    this.mColors = DEFAULT_GRADIENT_COLORS;
    this.mColorPoints = DEFAULT_GRADIENT_START_POINTS;
    this.mColorMapSize = 200;
    AppMethodBeat.o(211096);
  }
  
  public final TrailOverlayProvider data(List<TrailLatLng> paramList)
  {
    if (paramList != null) {
      this.dataList = paramList;
    }
    return this;
  }
  
  public final TrailOverlayProvider displayLevel(int paramInt)
  {
    AppMethodBeat.i(211209);
    super.displayLevel(paramInt);
    AppMethodBeat.o(211209);
    return this;
  }
  
  public final int getAnimateEndTime()
  {
    return this.mAnimatationEndTime;
  }
  
  public final int getAnimateStartTime()
  {
    return this.mAnimationStartTime;
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
  
  public final List<TrailLatLng> getData()
  {
    return this.dataList;
  }
  
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(211200);
    int i = super.getDisplayLevel();
    AppMethodBeat.o(211200);
    return i;
  }
  
  public final int getHighLightDuration()
  {
    return this.mHighLightDuration;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(211235);
    int i = super.getMaxZoom();
    AppMethodBeat.o(211235);
    return i;
  }
  
  public final int getMinZoom()
  {
    AppMethodBeat.i(211230);
    int i = super.getMinZoom();
    AppMethodBeat.o(211230);
    return i;
  }
  
  public final float getOpacity()
  {
    AppMethodBeat.i(211169);
    float f = super.getOpacity();
    AppMethodBeat.o(211169);
    return f;
  }
  
  final TrailOverlayProvider.TrailOverlayType getOverlayType()
  {
    AppMethodBeat.i(211123);
    TrailOverlayProvider.TrailOverlayType localTrailOverlayType = TrailOverlayProvider.TrailOverlayType.values()[this.mType];
    AppMethodBeat.o(211123);
    return localTrailOverlayType;
  }
  
  public final float getPlayRatio()
  {
    return this.mPlayRatio;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(211137);
    int i = getOverlayType().ordinal();
    AppMethodBeat.o(211137);
    return i;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final int getZIndex()
  {
    AppMethodBeat.i(211186);
    int i = super.getZIndex();
    AppMethodBeat.o(211186);
    return i;
  }
  
  public final TrailOverlayProvider gradient(int[] paramArrayOfInt)
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
  
  public final boolean isVisibility()
  {
    AppMethodBeat.i(211217);
    boolean bool = super.isVisibility();
    AppMethodBeat.o(211217);
    return bool;
  }
  
  public final TrailOverlayProvider opacity(float paramFloat)
  {
    AppMethodBeat.i(211177);
    super.opacity(paramFloat);
    AppMethodBeat.o(211177);
    return this;
  }
  
  public final TrailOverlayProvider setAnimateStartTime(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < paramInt2) && (paramInt1 >= 0))
    {
      this.mAnimationStartTime = paramInt1;
      this.mAnimatationEndTime = paramInt2;
    }
    return this;
  }
  
  public final TrailOverlayProvider setHighlightDuration(int paramInt)
  {
    if (paramInt > 0) {
      this.mHighLightDuration = paramInt;
    }
    return this;
  }
  
  public final TrailOverlayProvider setPlayRatio(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.mPlayRatio = paramFloat;
    }
    return this;
  }
  
  public final TrailOverlayProvider type(TrailOverlayProvider.TrailOverlayType paramTrailOverlayType)
  {
    AppMethodBeat.i(211113);
    this.mType = paramTrailOverlayType.ordinal();
    AppMethodBeat.o(211113);
    return this;
  }
  
  public final TrailOverlayProvider visibility(boolean paramBoolean)
  {
    AppMethodBeat.i(211222);
    super.visibility(paramBoolean);
    AppMethodBeat.o(211222);
    return this;
  }
  
  public final TrailOverlayProvider width(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.mWidth = paramFloat;
    }
    return this;
  }
  
  public final TrailOverlayProvider zIndex(int paramInt)
  {
    AppMethodBeat.i(211193);
    super.zIndex(paramInt);
    AppMethodBeat.o(211193);
    return this;
  }
  
  public final TrailOverlayProvider zoomRange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211243);
    if (paramInt1 <= paramInt2)
    {
      super.minZoom(paramInt1);
      super.maxZoom(paramInt2);
    }
    AppMethodBeat.o(211243);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider
 * JD-Core Version:    0.7.0.1
 */