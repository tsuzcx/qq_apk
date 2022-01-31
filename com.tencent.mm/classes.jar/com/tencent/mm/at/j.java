package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;

final class j
  implements com.tencent.mm.cache.f
{
  private com.tencent.mm.a.f<String, Bitmap> fFi;
  
  j()
  {
    AppMethodBeat.i(78306);
    this.fFi = new b(5, getClass());
    AppMethodBeat.o(78306);
  }
  
  public final void d(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(78307);
    this.fFi.f((String)paramObject1, (Bitmap)paramObject2);
    AppMethodBeat.o(78307);
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(78308);
    paramObject = this.fFi.get((String)paramObject);
    AppMethodBeat.o(78308);
    return paramObject;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(78309);
    this.fFi.remove((String)paramObject);
    AppMethodBeat.o(78309);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.j
 * JD-Core Version:    0.7.0.1
 */