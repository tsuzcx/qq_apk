package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gl
  extends gr
{
  @Json(name="ubs")
  public a a;
  
  gl(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(225489);
    this.a = new a(paramLong);
    AppMethodBeat.o(225489);
  }
  
  private a a()
  {
    return this.a;
  }
  
  public static final class a
    extends gr
  {
    @Json(name="showCount")
    private int a = 0;
    
    a(long paramLong)
    {
      super();
    }
    
    public final int a()
    {
      int i = this.a + 1;
      this.a = i;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gl
 * JD-Core Version:    0.7.0.1
 */