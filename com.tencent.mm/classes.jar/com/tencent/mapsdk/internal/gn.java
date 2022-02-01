package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

public final class gn
  extends gr
{
  @Json(name="showCount")
  private int a = 0;
  
  gn(long paramLong)
  {
    super(paramLong);
  }
  
  public final int a()
  {
    int i = this.a + 1;
    this.a = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gn
 * JD-Core Version:    0.7.0.1
 */