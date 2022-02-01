package androidx.appcompat.view.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d<T>
{
  public final T mr;
  
  d(T paramT)
  {
    AppMethodBeat.i(200944);
    if (paramT == null)
    {
      paramT = new IllegalArgumentException("Wrapped Object can not be null.");
      AppMethodBeat.o(200944);
      throw paramT;
    }
    this.mr = paramT;
    AppMethodBeat.o(200944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.appcompat.view.menu.d
 * JD-Core Version:    0.7.0.1
 */