package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum DataSource
{
  private final int mValue;
  
  static
  {
    AppMethodBeat.i(180732);
    NONE = new DataSource("NONE", 0, -1);
    SATELLITE = new DataSource("SATELLITE", 1, 0);
    MAP = new DataSource("MAP", 2, 1);
    STREET_VIEW_ROAD = new DataSource("STREET_VIEW_ROAD", 3, 2);
    TRAFFIC_NETWORK = new DataSource("TRAFFIC_NETWORK", 4, 3);
    INDOOR_BUILDINGS = new DataSource("INDOOR_BUILDINGS", 5, 4);
    LANDMARK = new DataSource("LANDMARK", 6, 5);
    TILE_OVERLAY = new DataSource("TILE_OVERLAY", 7, 6);
    NUM = new DataSource("NUM", 8, 7);
    $VALUES = new DataSource[] { NONE, SATELLITE, MAP, STREET_VIEW_ROAD, TRAFFIC_NETWORK, INDOOR_BUILDINGS, LANDMARK, TILE_OVERLAY, NUM };
    AppMethodBeat.o(180732);
  }
  
  private DataSource(int paramInt)
  {
    this.mValue = paramInt;
  }
  
  public static DataSource get(int paramInt)
  {
    AppMethodBeat.i(180731);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      DataSource localDataSource = localObject[i];
      if (localDataSource.mValue == paramInt)
      {
        AppMethodBeat.o(180731);
        return localDataSource;
      }
      i += 1;
    }
    localObject = NONE;
    AppMethodBeat.o(180731);
    return localObject;
  }
  
  public final int getValue()
  {
    return this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.models.DataSource
 * JD-Core Version:    0.7.0.1
 */