package androidx.camera.core.impl.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;

class f$a<V>
  extends f<V>
{
  private final Throwable PN;
  
  f$a(Throwable paramThrowable)
  {
    this.PN = paramThrowable;
  }
  
  public V get()
  {
    AppMethodBeat.i(199061);
    ExecutionException localExecutionException = new ExecutionException(this.PN);
    AppMethodBeat.o(199061);
    throw localExecutionException;
  }
  
  public String toString()
  {
    AppMethodBeat.i(199065);
    String str = super.toString() + "[status=FAILURE, cause=[" + this.PN + "]]";
    AppMethodBeat.o(199065);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */