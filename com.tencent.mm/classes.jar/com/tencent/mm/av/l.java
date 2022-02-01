package com.tencent.mm.av;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g;
import com.tencent.mm.memory.a.b;

final class l
  implements g
{
  private f<String, Bitmap> iYN;
  
  l()
  {
    AppMethodBeat.i(150666);
    this.iYN = new b(5, getClass());
    AppMethodBeat.o(150666);
  }
  
  public final void f(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(150667);
    this.iYN.x((String)paramObject1, (Bitmap)paramObject2);
    AppMethodBeat.o(150667);
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(150668);
    paramObject = this.iYN.get((String)paramObject);
    AppMethodBeat.o(150668);
    return paramObject;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(150669);
    this.iYN.remove((String)paramObject);
    AppMethodBeat.o(150669);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.l
 * JD-Core Version:    0.7.0.1
 */