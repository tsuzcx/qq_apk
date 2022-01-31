package com.tencent.mapsdk.raster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
{
  public static final int LINE_TYPE_DOTTEDLINE = 2;
  public static final int LINE_TYPE_MULTICOLORLINE = 0;
  private float arrowGap = 90.0F;
  private BitmapDescriptor arrowTexture;
  private int color = -16777216;
  private BitmapDescriptor colorTexture = null;
  private int edgeColor = -983041;
  private float edgeWidth = 0.0F;
  private boolean isDottedLine = false;
  private boolean isGeodesic = false;
  private boolean isVisible = true;
  private int lineType = 0;
  private IndoorInfo mIndoorInfo;
  private final List<LatLng> points = new ArrayList();
  private float width = 10.0F;
  private float zIndex = 0.0F;
  
  public final PolylineOptions add(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return this;
    }
    this.points.add(paramLatLng);
    return this;
  }
  
  public final PolylineOptions add(LatLng... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return this;
    }
    this.points.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    if (paramIterable == null) {}
    for (;;)
    {
      return this;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.points.add(localLatLng);
      }
    }
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
  
  public final IndoorInfo getIndoorInfo()
  {
    return this.mIndoorInfo;
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