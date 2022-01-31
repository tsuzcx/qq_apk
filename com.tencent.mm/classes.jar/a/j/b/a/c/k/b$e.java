package a.j.b.a.c.k;

import a.f.a.a;
import a.j.b.a.c.n.c;
import a.j.b.a.c.n.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

class b$e<T>
  implements g<T>
{
  private final b CAE;
  private final a<? extends T> CAF;
  private volatile Object value = b.i.CAI;
  
  public b$e(b paramb, a<? extends T> parama)
  {
    this.CAE = paramb;
    this.CAF = parama;
  }
  
  protected void dN(T paramT) {}
  
  public final boolean eoD()
  {
    return (this.value != b.i.CAI) && (this.value != b.i.CAJ);
  }
  
  public T invoke()
  {
    AppMethodBeat.i(122444);
    Object localObject = this.value;
    if (!(localObject instanceof b.i))
    {
      localObject = j.dT(localObject);
      AppMethodBeat.o(122444);
      return localObject;
    }
    this.CAE.mHZ.lock();
    try
    {
      localObject = this.value;
      if (!(localObject instanceof b.i))
      {
        localObject = j.dT(localObject);
        return localObject;
      }
      if (localObject == b.i.CAJ)
      {
        this.value = b.i.CAK;
        b.j localj = sG(true);
        if (!localj.CAM)
        {
          localObject = localj.getValue();
          return localObject;
        }
      }
      if (localObject == b.i.CAK)
      {
        localObject = sG(false);
        if (!((b.j)localObject).CAM)
        {
          localObject = ((b.j)localObject).getValue();
          return localObject;
        }
      }
      this.value = b.i.CAJ;
      try
      {
        localObject = this.CAF.invoke();
        this.value = localObject;
        dN(localObject);
        return localObject;
      }
      catch (Throwable localThrowable1)
      {
        if (!c.r(localThrowable1)) {
          break label265;
        }
      }
      this.value = b.i.CAI;
      RuntimeException localRuntimeException1 = (RuntimeException)localThrowable1;
      AppMethodBeat.o(122444);
      throw localRuntimeException1;
    }
    finally
    {
      this.CAE.mHZ.unlock();
      AppMethodBeat.o(122444);
    }
    label265:
    if (this.value == b.i.CAJ) {
      this.value = j.s(localThrowable2);
    }
    RuntimeException localRuntimeException2 = b.a(this.CAE).q(localThrowable2);
    AppMethodBeat.o(122444);
    throw localRuntimeException2;
  }
  
  protected b.j<T> sG(boolean paramBoolean)
  {
    AppMethodBeat.i(122445);
    b.j localj = this.CAE.eoB();
    AppMethodBeat.o(122445);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.k.b.e
 * JD-Core Version:    0.7.0.1
 */