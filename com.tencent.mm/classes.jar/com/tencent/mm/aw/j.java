package com.tencent.mm.aw;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g;
import com.tencent.mm.memory.a.b;

final class j
  implements g
{
  private f<String, Bitmap> hhH;
  
  j()
  {
    AppMethodBeat.i(150666);
    this.hhH = new b(5, getClass());
    AppMethodBeat.o(150666);
  }
  
  public final void c(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(150667);
    this.hhH.o((String)paramObject1, (Bitmap)paramObject2);
    AppMethodBeat.o(150667);
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(150668);
    paramObject = this.hhH.get((String)paramObject);
    AppMethodBeat.o(150668);
    return paramObject;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(150669);
    this.hhH.remove((String)paramObject);
    AppMethodBeat.o(150669);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aw.j
 * JD-Core Version:    0.7.0.1
 */