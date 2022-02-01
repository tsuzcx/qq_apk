package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public final class rl
  extends JsonComposer
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  @Json(name="scenetype")
  public int d;
  @Json(name="tilesrc")
  public rr e;
  
  private int a()
  {
    return this.d;
  }
  
  private void a(rr paramrr)
  {
    this.e = paramrr;
  }
  
  private rr b()
  {
    return this.e;
  }
  
  private void c()
  {
    this.d = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rl
 * JD-Core Version:    0.7.0.1
 */