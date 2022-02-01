package com.tencent.mm.modelimage;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g;
import com.tencent.mm.memory.a.b;

final class m
  implements g
{
  private f<String, Bitmap> oHR;
  
  m()
  {
    AppMethodBeat.i(150666);
    this.oHR = new b(5, getClass());
    AppMethodBeat.o(150666);
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(150668);
    paramObject = this.oHR.get((String)paramObject);
    AppMethodBeat.o(150668);
    return paramObject;
  }
  
  public final void m(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(150667);
    this.oHR.B((String)paramObject1, (Bitmap)paramObject2);
    AppMethodBeat.o(150667);
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(150669);
    this.oHR.remove((String)paramObject);
    AppMethodBeat.o(150669);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.m
 * JD-Core Version:    0.7.0.1
 */