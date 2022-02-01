package androidx.compose.runtime.b.a.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "tail", "index", "", "size", "trieHeight", "([Ljava/lang/Object;[Ljava/lang/Object;III)V", "[Ljava/lang/Object;", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g<T>
  extends a<T>
{
  private final k<T> aqD;
  private final T[] aqx;
  
  public g(Object[] paramArrayOfObject, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(202849);
    this.aqx = paramArrayOfT;
    paramInt2 = paramInt2 - 1 & 0xFFFFFFE0;
    this.aqD = new k(paramArrayOfObject, kotlin.k.k.qv(paramInt1, paramInt2), paramInt2, paramInt3);
    AppMethodBeat.o(202849);
  }
  
  public final T next()
  {
    AppMethodBeat.i(202857);
    qv();
    if (this.aqD.hasNext())
    {
      setIndex(getIndex() + 1);
      localObject = this.aqD.next();
      AppMethodBeat.o(202857);
      return localObject;
    }
    Object localObject = this.aqx;
    int i = getIndex();
    setIndex(i + 1);
    localObject = localObject[(i - this.aqD.getSize())];
    AppMethodBeat.o(202857);
    return localObject;
  }
  
  public final T previous()
  {
    AppMethodBeat.i(202867);
    qw();
    if (getIndex() > this.aqD.getSize())
    {
      localObject = this.aqx;
      setIndex(getIndex() - 1);
      localObject = localObject[(getIndex() - this.aqD.getSize())];
      AppMethodBeat.o(202867);
      return localObject;
    }
    setIndex(getIndex() - 1);
    Object localObject = this.aqD.previous();
    AppMethodBeat.o(202867);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */