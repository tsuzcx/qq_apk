package androidx.compose.runtime.b.a.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorMutableIterator;", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "index", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;I)V", "expectedModCount", "lastIteratedIndex", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "checkHasIterated", "next", "()Ljava/lang/Object;", "previous", "remove", "reset", "set", "setupTrieIterator", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h<T>
  extends a<T>
  implements ListIterator<T>, kotlin.g.b.a.f
{
  private k<? extends T> aqD;
  private final f<T> aqE;
  private int aqF;
  private int aqG;
  
  public h(f<T> paramf, int paramInt)
  {
    super(paramInt, paramf.size());
    AppMethodBeat.i(202851);
    this.aqE = paramf;
    this.aqF = this.aqE.qz();
    this.aqG = -1;
    qB();
    AppMethodBeat.o(202851);
  }
  
  private final void qB()
  {
    AppMethodBeat.i(202869);
    Object[] arrayOfObject = this.aqE.aqw;
    if (arrayOfObject == null)
    {
      this.aqD = null;
      AppMethodBeat.o(202869);
      return;
    }
    int i = this.aqE.size() - 1 & 0xFFFFFFE0;
    int j = kotlin.k.k.qv(getIndex(), i);
    int k = this.aqE.aqy / 5 + 1;
    if (this.aqD == null)
    {
      this.aqD = new k(arrayOfObject, j, i, k);
      AppMethodBeat.o(202869);
      return;
    }
    k localk = this.aqD;
    s.checkNotNull(localk);
    localk.c(arrayOfObject, j, i, k);
    AppMethodBeat.o(202869);
  }
  
  private final void qC()
  {
    AppMethodBeat.i(202876);
    if (this.aqF != this.aqE.qz())
    {
      ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException();
      AppMethodBeat.o(202876);
      throw localConcurrentModificationException;
    }
    AppMethodBeat.o(202876);
  }
  
  private final void qD()
  {
    AppMethodBeat.i(202882);
    if (this.aqG == -1)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(202882);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(202882);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(202856);
    setSize(this.aqE.size());
    this.aqF = this.aqE.qz();
    this.aqG = -1;
    qB();
    AppMethodBeat.o(202856);
  }
  
  public final void add(T paramT)
  {
    AppMethodBeat.i(202899);
    qC();
    this.aqE.add(getIndex(), paramT);
    setIndex(getIndex() + 1);
    reset();
    AppMethodBeat.o(202899);
  }
  
  public final T next()
  {
    AppMethodBeat.i(202892);
    qC();
    qv();
    this.aqG = getIndex();
    Object localObject = this.aqD;
    if (localObject == null)
    {
      localObject = this.aqE.aqx;
      i = getIndex();
      setIndex(i + 1);
      localObject = localObject[i];
      AppMethodBeat.o(202892);
      return localObject;
    }
    if (((k)localObject).hasNext())
    {
      setIndex(getIndex() + 1);
      localObject = ((k)localObject).next();
      AppMethodBeat.o(202892);
      return localObject;
    }
    Object[] arrayOfObject = this.aqE.aqx;
    int i = getIndex();
    setIndex(i + 1);
    localObject = arrayOfObject[(i - localObject.getSize())];
    AppMethodBeat.o(202892);
    return localObject;
  }
  
  public final T previous()
  {
    AppMethodBeat.i(202889);
    qC();
    qw();
    this.aqG = (getIndex() - 1);
    Object localObject = this.aqD;
    if (localObject == null)
    {
      localObject = this.aqE.aqx;
      setIndex(getIndex() - 1);
      localObject = localObject[getIndex()];
      AppMethodBeat.o(202889);
      return localObject;
    }
    if (getIndex() > ((k)localObject).getSize())
    {
      Object[] arrayOfObject = this.aqE.aqx;
      setIndex(getIndex() - 1);
      localObject = arrayOfObject[(getIndex() - localObject.getSize())];
      AppMethodBeat.o(202889);
      return localObject;
    }
    setIndex(getIndex() - 1);
    localObject = ((k)localObject).previous();
    AppMethodBeat.o(202889);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(202906);
    qC();
    qD();
    this.aqE.remove(this.aqG);
    if (this.aqG < getIndex()) {
      setIndex(this.aqG);
    }
    reset();
    AppMethodBeat.o(202906);
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(202912);
    qC();
    qD();
    this.aqE.set(this.aqG, paramT);
    this.aqF = this.aqE.qz();
    qB();
    AppMethodBeat.o(202912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */