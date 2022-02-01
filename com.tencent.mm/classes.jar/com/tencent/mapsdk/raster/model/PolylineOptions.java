package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
{
  public static final int LINE_TYPE_DOTTEDLINE = 2;
  public static final int LINE_TYPE_MULTICOLORLINE = 0;
  private float arrowGap;
  private BitmapDescriptor arrowTexture;
  private int color;
  private BitmapDescriptor colorTexture;
  private int edgeColor;
  private float edgeWidth;
  private int eraseColor;
  private int[] iColors;
  private int[] iIndexs;
  private int iLevel;
  private boolean isDottedLine;
  private boolean isGeodesic;
  private boolean isVisible;
  private int lineType;
  private IndoorInfo mIndoorInfo;
  private final List<LatLng> points;
  private float width;
  private float zIndex;
  
  public PolylineOptions()
  {
    AppMethodBeat.i(87572);
    this.isDottedLine = false;
    this.isGeodesic = false;
    this.isVisible = true;
    this.color = -16777216;
    this.eraseColor = -7829368;
    this.width = 10.0F;
    this.zIndex = 0.0F;
    this.edgeWidth = 0.0F;
    this.edgeColor = -983041;
    this.arrowGap = 90.0F;
    this.lineType = 0;
    this.colorTexture = null;
    this.iColors = null;
    this.iIndexs = null;
    this.iLevel = OverlayLevel.OverlayLevelAboveRoads;
    this.points = new ArrayList();
    AppMethodBeat.o(87572);
  }
  
  public final PolylineOptions add(LatLng paramLatLng)
  {
    AppMethodBeat.i(87573);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(87573);
      return this;
    }
    this.points.add(paramLatLng);
    AppMethodBeat.o(87573);
    return this;
  }
  
  public final PolylineOptions add(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(87574);
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(87574);
      return this;
    }
    this.points.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(87574);
    return this;
  }
  
  public final PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(87575);
    if (paramIterable == null)
    {
      AppMethodBeat.o(87575);
      return this;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    AppMethodBeat.o(87575);
    return this;
  }
  
  public final PolylineOptions arrowGap(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.arrowGap = paramFloat;
    }
    return this;
  }
  
  public final PolylineOptions arrowTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null) {
      this.arrowTexture = paramBitmapDescriptor;
    }
    return this;
  }
  
  public final PolylineOptions color(int paramInt)
  {
    this.color = paramInt;
    return this;
  }
  
  public final PolylineOptions colorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.colorTexture = paramBitmapDescriptor;
    return this;
  }
  
  public final PolylineOptions colors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.iColors = paramArrayOfInt1;
    this.iIndexs = paramArrayOfInt2;
    return this;
  }
  
  public final PolylineOptions edgeColor(int paramInt)
  {
    this.edgeColor = paramInt;
    return this;
  }
  
  public final PolylineOptions edgeWidth(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.edgeWidth = paramFloat;
    }
    return this;
  }
  
  public final PolylineOptions eraseColor(int paramInt)
  {
    this.eraseColor = paramInt;
    return this;
  }
  
  public final PolylineOptions geodesic(boolean paramBoolean)
  {
    this.isGeodesic = paramBoolean;
    return this;
  }
  
  public final float getArrowGap()
  {
    return this.arrowGap;
  }
  
  public final BitmapDescriptor getArrowTexture()
  {
    return this.arrowTexture;
  }
  
  public final int getColor()
  {
    return this.color;
  }
  
  public final BitmapDescriptor getColorTexture()
  {
    return this.colorTexture;
  }
  
  public final int[][] getColors()
  {
    if ((this.iColors == null) || (this.iIndexs == null)) {}
    while (this.iColors.length != this.iIndexs.length) {
      return null;
    }
    int i = this.iColors.length;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i });
    arrayOfInt[0] = this.iColors;
    arrayOfInt[1] = this.iIndexs;
    return arrayOfInt;
  }
  
  public final int getEdgeColor()
  {
    return this.edgeColor;
  }
  
  public final float getEdgeWidth()
  {
    return this.edgeWidth;
  }
  
  public final int getEraseColor()
  {
    return this.eraseColor;
  }
  
  public final IndoorInfo getIndoorInfo()
  {
    return this.mIndoorInfo;
  }
  
  public final int getLevel()
  {
    return this.iLevel;
  }
  
  public final int getLineType()
  {
    return this.lineType;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public final float getWidth()
  {
    return this.width;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final PolylineOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    this.mIndoorInfo = paramIndoorInfo;
    return this;
  }
  
  public final boolean isDottedLine()
  {
    return this.isDottedLine;
  }
  
  public final boolean isGeodesic()
  {
    return this.isGeodesic;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final PolylineOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public final PolylineOptions lineType(int paramInt)
  {
    this.lineType = paramInt;
    return this;
  }
  
  public final PolylineOptions setDottedLine(boolean paramBoolean)
  {
    this.isDottedLine = paramBoolean;
    return this;
  }
  
  public final PolylineOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final PolylineOptions width(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.width = f;
    return this;
  }
  
  public final PolylineOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
  
  public static final class Colors
  {
    public static final int DARK_BLUE = 6;
    public static final int GRAYBLUE = 8;
    public static final int GREEN = 4;
    public static final int GREY = 0;
    public static final int LIGHT_BLUE = 1;
    public static final int LIVER_RED = 9;
    public static final int MID_BLUE = 5;
    public static final int RED = 2;
    public static final int TRANSPARENT = 7;
    public static final int YELLOW = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */