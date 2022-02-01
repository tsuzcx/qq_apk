package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class gg
  extends gr
{
  @Json(name="styles")
  private List<a> a;
  
  gg(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(225539);
    this.a = new ArrayList();
    AppMethodBeat.o(225539);
  }
  
  public final int a(int paramInt)
  {
    AppMethodBeat.i(225548);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a == paramInt)
      {
        paramInt = locala.b + 1;
        locala.b = paramInt;
        AppMethodBeat.o(225548);
        return paramInt;
      }
    }
    this.a.add(new a(this.g, paramInt));
    AppMethodBeat.o(225548);
    return 1;
  }
  
  static final class a
    extends gr
  {
    @Json(name="id")
    int a = 0;
    @Json(name="showCount")
    int b = 0;
    
    a(long paramLong, int paramInt)
    {
      super();
      this.a = paramInt;
      this.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gg
 * JD-Core Version:    0.7.0.1
 */