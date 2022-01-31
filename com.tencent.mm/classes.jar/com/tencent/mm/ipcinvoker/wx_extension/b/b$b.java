package com.tencent.mm.ipcinvoker.wx_extension.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class b$b<T>
  extends WeakReference<T>
{
  public b$b(T paramT)
  {
    super(paramT);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(126213);
    if (paramObject == this)
    {
      AppMethodBeat.o(126213);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(126213);
      return false;
    }
    paramObject = ((b)paramObject).get();
    Object localObject = get();
    if ((paramObject == localObject) || ((localObject != null) && (localObject.equals(paramObject))))
    {
      AppMethodBeat.o(126213);
      return true;
    }
    AppMethodBeat.o(126213);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b.b
 * JD-Core Version:    0.7.0.1
 */