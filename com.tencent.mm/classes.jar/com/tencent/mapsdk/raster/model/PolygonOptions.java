package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
{
  private int fillColor;
  private int iLevel;
  private boolean isVisible;
  private final List<LatLng> points;
  private int strokeColor;
  private float strokeWidth;
  private float zIndex;
  
  public PolygonOptions()
  {
    AppMethodBeat.i(87576);
    this.strokeColor = -16777216;
    this.fillColor = -16777216;
    this.strokeWidth = 10.0F;
    this.isVisible = true;
    this.zIndex = 0.0F;
    this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
    this.points = new ArrayList();
    AppMethodBeat.o(87576);
  }
  
  public final PolygonOptions add(LatLng paramLatLng)
  {
    AppMethodBeat.i(87577);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(87577);
      return this;
    }
    this.points.add(paramLatLng);
    AppMethodBeat.o(87577);
    return this;
  }
  
  public final PolygonOptions add(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(87578);
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(87578);
      return this;
    }
    this.points.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(87578);
    return this;
  }
  
  public final PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(87579);
    if (paramIterable == null)
    {
      AppMethodBeat.o(87579);
      return this;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.points.add(localLatLng);
    }
    AppMethodBeat.o(87579);
    return this;
  }
  
  public final PolygonOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public final int getFillColor()
  {
    return this.fillColor;
  }
  
  public final int getLevel()
  {
    return this.iLevel;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.points;
  }
  
  public final int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public final float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final PolygonOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public final PolygonOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public final PolygonOptions strokeWidth(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.strokeWidth = f;
    return this;
  }
  
  public final PolygonOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final PolygonOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */