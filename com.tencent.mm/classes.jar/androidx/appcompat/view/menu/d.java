package androidx.appcompat.view.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d<T>
{
  public final T lv;
  
  d(T paramT)
  {
    AppMethodBeat.i(239144);
    if (paramT == null)
    {
      paramT = new IllegalArgumentException("Wrapped Object can not be null.");
      AppMethodBeat.o(239144);
      throw paramT;
    }
    this.lv = paramT;
    AppMethodBeat.o(239144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.d
 * JD-Core Version:    0.7.0.1
 */