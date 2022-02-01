package com.tencent.map.sdk.utilities.visualization.aggregation;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

public abstract interface AggregationOverlay
  extends VectorOverlay
{
  public abstract VectorHeatAggregationUnit getUnit(LatLng paramLatLng);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlay
 * JD-Core Version:    0.7.0.1
 */