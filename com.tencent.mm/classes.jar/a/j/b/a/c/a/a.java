package a.j.b.a.c.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T extends g>
{
  private volatile T BRv;
  private volatile boolean BRw;
  private Throwable BRx;
  private final a.f.a.a<T> BRy;
  
  public a(a.f.a.a<? extends T> parama)
  {
    AppMethodBeat.i(119068);
    this.BRy = parama;
    AppMethodBeat.o(119068);
  }
  
  private final void initialize()
  {
    try
    {
      AppMethodBeat.i(119066);
      if (this.BRv != null) {
        break label186;
      }
      if (this.BRx != null)
      {
        Object localObject1 = new StringBuilder("Built-in library initialization failed previously: ");
        Throwable localThrowable4 = this.BRx;
        if (localThrowable4 == null) {
          j.ebi();
        }
        localObject1 = (Throwable)new IllegalStateException(localThrowable4, this.BRx);
        AppMethodBeat.o(119066);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    if (this.BRw)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Built-in library initialization loop");
      AppMethodBeat.o(119066);
      throw localThrowable1;
    }
    this.BRw = true;
    for (;;)
    {
      try
      {
        this.BRv = ((g)this.BRy.invoke());
        this.BRw = false;
        AppMethodBeat.o(119066);
        return;
      }
      catch (Throwable localThrowable2)
      {
        this.BRx = localThrowable2;
        Throwable localThrowable3 = (Throwable)new IllegalStateException("Built-in library initialization failed. Please ensure you have kotlin-stdlib.jar in the classpath: ".concat(String.valueOf(localThrowable2)), localThrowable2);
        AppMethodBeat.o(119066);
        throw localThrowable3;
      }
      finally
      {
        this.BRw = false;
        AppMethodBeat.o(119066);
      }
      label186:
      AppMethodBeat.o(119066);
    }
  }
  
  public final T ecc()
  {
    AppMethodBeat.i(119067);
    if (this.BRw)
    {
      try
      {
        Object localObject = this.BRv;
        if (localObject == null)
        {
          localObject = (Throwable)new AssertionError("Built-ins are not initialized (note: We are under the same lock as initializing and instance)");
          AppMethodBeat.o(119067);
          throw ((Throwable)localObject);
        }
      }
      finally
      {
        AppMethodBeat.o(119067);
      }
      AppMethodBeat.o(119067);
      return ?;
    }
    if (this.BRv == null) {
      initialize();
    }
    g localg = this.BRv;
    if (localg == null) {
      j.ebi();
    }
    AppMethodBeat.o(119067);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */