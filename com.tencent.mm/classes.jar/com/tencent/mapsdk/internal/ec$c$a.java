package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public abstract class ec$c$a
  extends JsonComposer
{
  @Json(name="displayLevel")
  public int f;
  @Json(name="zIndex")
  public int g;
  @Json(name="hidden")
  public boolean h;
  @Json(name="opacity")
  public double i;
  @Json(name="maxZoom")
  public int j;
  @Json(name="minZoom")
  public int k;
  @Json(name="themeName")
  public String l;
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec.c.a
 * JD-Core Version:    0.7.0.1
 */