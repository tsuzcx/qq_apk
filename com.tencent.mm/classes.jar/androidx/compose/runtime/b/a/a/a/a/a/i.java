package androidx.compose.runtime.b.a.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SingleElementListIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "element", "index", "", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<E>
  extends a<E>
{
  private final E aqH;
  
  public i(E paramE, int paramInt)
  {
    super(paramInt, 1);
    this.aqH = paramE;
  }
  
  public final E next()
  {
    AppMethodBeat.i(202866);
    qv();
    setIndex(getIndex() + 1);
    Object localObject = this.aqH;
    AppMethodBeat.o(202866);
    return localObject;
  }
  
  public final E previous()
  {
    AppMethodBeat.i(202874);
    qw();
    setIndex(getIndex() - 1);
    Object localObject = this.aqH;
    AppMethodBeat.o(202874);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */