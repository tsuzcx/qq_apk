package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oy$c
  extends JsonComposer
{
  @Json(name="fill_color")
  String a;
  @Json(name="stroke_color")
  String b;
  @Json(name="stroke_width")
  int c;
  
  public final String toString()
  {
    AppMethodBeat.i(222993);
    Object localObject = new StringBuffer("AoiStyle{");
    ((StringBuffer)localObject).append("fillColor='").append(this.a).append('\'');
    ((StringBuffer)localObject).append(", strokeColor='").append(this.b).append('\'');
    ((StringBuffer)localObject).append(", strokeWidth=").append(this.c);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222993);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oy.c
 * JD-Core Version:    0.7.0.1
 */