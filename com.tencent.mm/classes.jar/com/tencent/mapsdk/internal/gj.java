package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

public final class gj
  extends gr
{
  @Json(name="showCount")
  public int a = 0;
  
  gj(long paramLong)
  {
    super(paramLong);
  }
  
  private int a()
  {
    int i = this.a + 1;
    this.a = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gj
 * JD-Core Version:    0.7.0.1
 */