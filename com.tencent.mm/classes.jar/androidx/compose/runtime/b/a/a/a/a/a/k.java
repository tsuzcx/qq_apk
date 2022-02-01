package androidx.compose.runtime.b.a.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "index", "", "size", "height", "([Ljava/lang/Object;III)V", "isInRightEdge", "", "path", "[Ljava/lang/Object;", "elementAtCurrentIndex", "()Ljava/lang/Object;", "fillPath", "", "startLevel", "fillPathIfNeeded", "indexPredicate", "next", "previous", "reset", "reset$runtime_release", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k<E>
  extends a<E>
{
  private Object[] aqK;
  private boolean aqL;
  private int height;
  
  public k(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(202842);
    this.height = paramInt3;
    this.aqK = new Object[this.height];
    if (paramInt1 == paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.aqL = bool;
      this.aqK[0] = paramArrayOfObject;
      paramInt2 = i;
      if (this.aqL) {
        paramInt2 = 1;
      }
      T(paramInt1 - paramInt2, 1);
      AppMethodBeat.o(202842);
      return;
    }
  }
  
  private final void T(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202848);
    int j = (this.height - paramInt2) * 5;
    int i = paramInt2;
    paramInt2 = j;
    while (i < this.height)
    {
      Object localObject1 = this.aqK;
      Object localObject2 = localObject1[(i - 1)];
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(202848);
        throw ((Throwable)localObject1);
      }
      localObject1[i] = ((Object[])localObject2)[(paramInt1 >> paramInt2 & 0x1F)];
      i += 1;
      paramInt2 -= 5;
    }
    AppMethodBeat.o(202848);
  }
  
  private final void cf(int paramInt)
  {
    AppMethodBeat.i(202854);
    int i = 0;
    while ((getIndex() >> i & 0x1F) == paramInt) {
      i += 5;
    }
    if (i > 0)
    {
      paramInt = this.height;
      i /= 5;
      T(getIndex(), paramInt - 1 - i + 1);
    }
    AppMethodBeat.o(202854);
  }
  
  private final E qF()
  {
    AppMethodBeat.i(202863);
    int i = getIndex();
    Object localObject = this.aqK[(this.height - 1)];
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
      AppMethodBeat.o(202863);
      throw ((Throwable)localObject);
    }
    localObject = ((Object[])localObject)[(i & 0x1F)];
    AppMethodBeat.o(202863);
    return localObject;
  }
  
  public final void c(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(202872);
    s.u(paramArrayOfObject, "root");
    setIndex(paramInt1);
    setSize(paramInt2);
    this.height = paramInt3;
    if (this.aqK.length < paramInt3) {
      this.aqK = new Object[paramInt3];
    }
    this.aqK[0] = paramArrayOfObject;
    if (paramInt1 == paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.aqL = bool;
      paramInt2 = i;
      if (this.aqL) {
        paramInt2 = 1;
      }
      T(paramInt1 - paramInt2, 1);
      AppMethodBeat.o(202872);
      return;
    }
  }
  
  public final E next()
  {
    AppMethodBeat.i(202881);
    if (!hasNext())
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(202881);
      throw ((Throwable)localObject);
    }
    Object localObject = qF();
    setIndex(getIndex() + 1);
    if (getIndex() == getSize())
    {
      this.aqL = true;
      AppMethodBeat.o(202881);
      return localObject;
    }
    cf(0);
    AppMethodBeat.o(202881);
    return localObject;
  }
  
  public final E previous()
  {
    AppMethodBeat.i(202884);
    if (!hasPrevious())
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(202884);
      throw ((Throwable)localObject);
    }
    setIndex(getIndex() - 1);
    if (this.aqL)
    {
      this.aqL = false;
      localObject = qF();
      AppMethodBeat.o(202884);
      return localObject;
    }
    cf(31);
    Object localObject = qF();
    AppMethodBeat.o(202884);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */