package a.j.b.a.c.k;

import a.j.b.a.c.n.c;
import a.j.b.a.c.n.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;

class b$g<K, V>
  implements d<K, V>
{
  final b CAE;
  private final ConcurrentMap<K, Object> CAG;
  private final a.f.a.b<? super K, ? extends V> CAH;
  
  public b$g(b paramb, ConcurrentMap<K, Object> paramConcurrentMap, a.f.a.b<? super K, ? extends V> paramb1)
  {
    this.CAE = paramb;
    this.CAG = paramConcurrentMap;
    this.CAH = paramb1;
  }
  
  private AssertionError G(K paramK, Object paramObject)
  {
    AppMethodBeat.i(122449);
    paramK = (AssertionError)b.p(new AssertionError("Race condition detected on input " + paramK + ". Old value is " + paramObject + " under " + this.CAE));
    AppMethodBeat.o(122449);
    return paramK;
  }
  
  public V S(K paramK)
  {
    AppMethodBeat.i(122448);
    Object localObject1 = this.CAG.get(paramK);
    if ((localObject1 != null) && (localObject1 != b.i.CAJ))
    {
      paramK = j.dS(localObject1);
      AppMethodBeat.o(122448);
      return paramK;
    }
    this.CAE.mHZ.lock();
    try
    {
      localObject1 = this.CAG.get(paramK);
      if (localObject1 == b.i.CAJ)
      {
        paramK = (AssertionError)b.p(new AssertionError("Recursion detected on input: " + paramK + " under " + this.CAE));
        AppMethodBeat.o(122448);
        throw paramK;
      }
    }
    finally
    {
      this.CAE.mHZ.unlock();
      AppMethodBeat.o(122448);
    }
    if (localObject1 != null)
    {
      paramK = j.dS(localObject1);
      this.CAE.mHZ.unlock();
      AppMethodBeat.o(122448);
      return paramK;
    }
    AssertionError localAssertionError = null;
    localObject1 = localAssertionError;
    try
    {
      this.CAG.put(paramK, b.i.CAJ);
      localObject1 = localAssertionError;
      localObject2 = this.CAH.S(paramK);
      localObject1 = localAssertionError;
      Object localObject3 = this.CAG.put(paramK, j.dR(localObject2));
      localObject1 = localAssertionError;
      if (localObject3 != b.i.CAJ)
      {
        localObject1 = localAssertionError;
        localAssertionError = G(paramK, localObject3);
        localObject1 = localAssertionError;
        AppMethodBeat.o(122448);
        localObject1 = localAssertionError;
        throw localAssertionError;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      if (c.r(localThrowable))
      {
        this.CAG.remove(paramK);
        paramK = (RuntimeException)localThrowable;
        AppMethodBeat.o(122448);
        throw paramK;
        this.CAE.mHZ.unlock();
        AppMethodBeat.o(122448);
        return localObject2;
      }
      if (localThrowable == localObject1)
      {
        paramK = b.a(this.CAE).q(localThrowable);
        AppMethodBeat.o(122448);
        throw paramK;
      }
      localObject1 = this.CAG.put(paramK, j.s(localThrowable));
      if (localObject1 != b.i.CAJ)
      {
        paramK = G(paramK, localObject1);
        AppMethodBeat.o(122448);
        throw paramK;
      }
      paramK = b.a(this.CAE).q(localThrowable);
      AppMethodBeat.o(122448);
      throw paramK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.k.b.g
 * JD-Core Version:    0.7.0.1
 */