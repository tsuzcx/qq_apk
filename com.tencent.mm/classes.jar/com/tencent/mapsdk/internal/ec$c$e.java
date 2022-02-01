package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class ec$c$e
  extends JsonComposer
{
  @Json(name="points")
  public List<Double> a;
  @Json(name="colors")
  public List<Integer> b;
  
  private boolean a()
  {
    AppMethodBeat.i(226151);
    if ((this.a != null) && (this.a.size() > 0) && (this.b != null) && (this.b.size() > 0))
    {
      AppMethodBeat.o(226151);
      return true;
    }
    AppMethodBeat.o(226151);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec.c.e
 * JD-Core Version:    0.7.0.1
 */