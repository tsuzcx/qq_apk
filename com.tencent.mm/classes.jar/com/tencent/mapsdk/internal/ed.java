package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ed
  extends ec
{
  @Json(name="detail")
  public a a;
  
  public final int a()
  {
    AppMethodBeat.i(221458);
    if (c())
    {
      int i = this.a.c.a;
      AppMethodBeat.o(221458);
      return i;
    }
    AppMethodBeat.o(221458);
    return 0;
  }
  
  public final int b()
  {
    AppMethodBeat.i(221461);
    if (c())
    {
      int i = this.a.a.c;
      AppMethodBeat.o(221461);
      return i;
    }
    AppMethodBeat.o(221461);
    return 0;
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(221450);
    if ((super.c()) && (this.a != null) && (this.a.a()))
    {
      AppMethodBeat.o(221450);
      return true;
    }
    AppMethodBeat.o(221450);
    return false;
  }
  
  public static final class a
    extends ec.a
  {
    @Json(name="styleTable")
    public ed.a.a a;
    
    public final boolean a()
    {
      AppMethodBeat.i(224428);
      if ((super.a()) && (dw.b.a(this.b)) && (this.a != null) && (this.a.a()))
      {
        AppMethodBeat.o(224428);
        return true;
      }
      AppMethodBeat.o(224428);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ed
 * JD-Core Version:    0.7.0.1
 */