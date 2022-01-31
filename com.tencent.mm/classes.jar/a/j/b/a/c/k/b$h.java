package a.j.b.a.c.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentMap;

final class b$h<K, V>
  extends b.g<K, V>
  implements c<K, V>
{
  static
  {
    AppMethodBeat.i(122451);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(122451);
      return;
    }
  }
  
  public b$h(b paramb, ConcurrentMap<K, Object> paramConcurrentMap, a.f.a.b<? super K, ? extends V> paramb1)
  {
    super(paramb, paramConcurrentMap, paramb1);
  }
  
  public final V S(K paramK)
  {
    AppMethodBeat.i(122450);
    paramK = super.S(paramK);
    if ((!$assertionsDisabled) && (paramK == null))
    {
      paramK = new AssertionError("compute() returned null under " + this.CAE);
      AppMethodBeat.o(122450);
      throw paramK;
    }
    AppMethodBeat.o(122450);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.k.b.h
 * JD-Core Version:    0.7.0.1
 */