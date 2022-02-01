package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class x<T>
  extends LiveData<T>
{
  public x() {}
  
  public x(T paramT)
  {
    super(paramT);
  }
  
  public void setValue(T paramT)
  {
    AppMethodBeat.i(194371);
    super.setValue(paramT);
    AppMethodBeat.o(194371);
  }
  
  public final void t(T paramT)
  {
    AppMethodBeat.i(194366);
    super.t(paramT);
    AppMethodBeat.o(194366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.x
 * JD-Core Version:    0.7.0.1
 */