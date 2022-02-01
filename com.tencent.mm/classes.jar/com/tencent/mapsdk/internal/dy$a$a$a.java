package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public final class dy$a$a$a
  extends ec.c.a
{
  @Json(name="enable3D")
  public boolean a;
  @Json(name="animated")
  public boolean b;
  @Json(name="animation")
  public a c;
  
  public static final class a
    extends JsonComposer
  {
    @Json(name="highlightDuration")
    public double a;
    @Json(name="highlightColor")
    public int b;
    @Json(name="duration")
    public double c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dy.a.a.a
 * JD-Core Version:    0.7.0.1
 */