package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(101220);
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
    this.iLevel = OverlayLevel.OverlayLevelAboveRoads;
    this.points = new ArrayList();
    AppMethodBeat.o(101220);
  }
  
  public final PolylineOptions add(LatLng paramLatLng)
  {
    AppMethodBeat.i(101221);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(101221);
      return this;
    }
    this.points.add(paramLatLng);
    AppMethodBeat.o(101221);
    return this;
  }
  
  public final PolylineOptions add(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(101222);
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(101222);
      return this;
    }
    this.points.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(101222);
    return this;
  }
  
  public final PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(101223);
    if (paramIterable == null)
    {
      AppMethodBeat.o(101223);
      return this;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    AppMethodBeat.o(101223);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */