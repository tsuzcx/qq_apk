package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class ec$a$a$b
  extends ec.a.a.a
{
  @Json(deserializer=ee.class, name="coordinates")
  public List<LatLng> b;
  @Json(name="weight")
  public int c;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec.a.a.b
 * JD-Core Version:    0.7.0.1
 */