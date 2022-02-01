package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oy$a
  extends JsonComposer
{
  @Json(name="aoi_latitude")
  String a;
  @Json(name="aoi_longitude")
  String b;
  @Json(name="area")
  oy.b c;
  
  public final String toString()
  {
    AppMethodBeat.i(222921);
    Object localObject = new StringBuffer("PoiArea{");
    ((StringBuffer)localObject).append("latitude=").append(this.a);
    ((StringBuffer)localObject).append(", longitude=").append(this.b);
    ((StringBuffer)localObject).append(", area=").append(this.c);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222921);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oy.a
 * JD-Core Version:    0.7.0.1
 */