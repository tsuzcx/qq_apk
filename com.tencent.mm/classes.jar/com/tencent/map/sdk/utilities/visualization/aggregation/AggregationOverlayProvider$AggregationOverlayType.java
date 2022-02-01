package com.tencent.map.sdk.utilities.visualization.aggregation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AggregationOverlayProvider$AggregationOverlayType
{
  static
  {
    AppMethodBeat.i(211109);
    HoneyComb = new AggregationOverlayType("HoneyComb", 0);
    Square = new AggregationOverlayType("Square", 1);
    $VALUES = new AggregationOverlayType[] { HoneyComb, Square };
    AppMethodBeat.o(211109);
  }
  
  private AggregationOverlayProvider$AggregationOverlayType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider.AggregationOverlayType
 * JD-Core Version:    0.7.0.1
 */