package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

public final class gt
  extends gr
{
  @Json(name="customLayerTimes")
  public int a;
  
  gt(long paramLong)
  {
    super(paramLong);
  }
  
  private int a()
  {
    this.a += 1;
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gt
 * JD-Core Version:    0.7.0.1
 */