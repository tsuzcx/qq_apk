package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dx$a$a$a
  extends ec.c.a
{
  @Json(name="maxIntensity")
  public double a;
  @Json(name="minIntensity")
  public double b;
  @Json(name="enable3D")
  public boolean c;
  @Json(name="heightRange")
  public List<Double> d;
  @Json(name="animated")
  public boolean e;
  
  public final boolean a()
  {
    AppMethodBeat.i(224308);
    if ((super.a()) && (this.d != null) && (this.d.size() > 0))
    {
      AppMethodBeat.o(224308);
      return true;
    }
    AppMethodBeat.o(224308);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dx.a.a.a
 * JD-Core Version:    0.7.0.1
 */