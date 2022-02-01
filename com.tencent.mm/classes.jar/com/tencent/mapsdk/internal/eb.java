package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class eb
  extends JsonComposer
{
  @Json(name="layers")
  public List<ea> a;
  @Json(name="enable")
  private int b;
  
  private List<ea> b()
  {
    return this.a;
  }
  
  public final boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(221480);
    String str = "DataLayerInfo{enable=" + this.b + ", layers=" + this.a + '}';
    AppMethodBeat.o(221480);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.eb
 * JD-Core Version:    0.7.0.1
 */