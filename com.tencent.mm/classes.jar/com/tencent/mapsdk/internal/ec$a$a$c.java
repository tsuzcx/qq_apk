package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;

public class ec$a$a$c
  extends ec.a.a.a
{
  @Json(deserializer=LatLngDeserializer.class, name="coordinates")
  public LatLng b;
  @Json(name="weight")
  public int c;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec.a.a.c
 * JD-Core Version:    0.7.0.1
 */