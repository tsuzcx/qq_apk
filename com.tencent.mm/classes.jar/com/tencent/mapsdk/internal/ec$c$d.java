package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public class ec$c$d
  extends JsonComposer
{
  @Json(name="duration")
  public double c;
  
  private boolean a()
  {
    return this.c >= 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec.c.d
 * JD-Core Version:    0.7.0.1
 */