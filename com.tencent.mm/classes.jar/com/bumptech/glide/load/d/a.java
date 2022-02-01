package com.bumptech.glide.load.d;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a<T>
  implements v<T>
{
  protected final T data;
  
  public a(T paramT)
  {
    AppMethodBeat.i(77345);
    this.data = j.checkNotNull(paramT, "Argument must not be null");
    AppMethodBeat.o(77345);
  }
  
  public final T get()
  {
    return this.data;
  }
  
  public final int getSize()
  {
    return 1;
  }
  
  public final Class<T> oV()
  {
    AppMethodBeat.i(77346);
    Class localClass = this.data.getClass();
    AppMethodBeat.o(77346);
    return localClass;
  }
  
  public final void recycle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a
 * JD-Core Version:    0.7.0.1
 */