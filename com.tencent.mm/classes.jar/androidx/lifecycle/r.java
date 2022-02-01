package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class r<T>
  extends LiveData<T>
{
  public final void L(T paramT)
  {
    AppMethodBeat.i(241235);
    super.L(paramT);
    AppMethodBeat.o(241235);
  }
  
  public void setValue(T paramT)
  {
    AppMethodBeat.i(241237);
    super.setValue(paramT);
    AppMethodBeat.o(241237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.r
 * JD-Core Version:    0.7.0.1
 */