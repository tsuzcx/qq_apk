package androidx.compose.runtime.b.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList$SubList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Lkotlin/collections/AbstractList;", "source", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "subList", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a<E>
  extends b<E>
  implements c<E>
{
  private int _size;
  private final c<E> aqs;
  private final int aqt;
  private final int aqu;
  
  public c$a(c<? extends E> paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202710);
    this.aqs = paramc;
    this.aqt = paramInt1;
    this.aqu = paramInt2;
    androidx.compose.runtime.b.a.a.a.b.c.m(this.aqt, this.aqu, this.aqs.size());
    this._size = (this.aqu - this.aqt);
    AppMethodBeat.o(202710);
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(202714);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, this._size);
    Object localObject = this.aqs.get(this.aqt + paramInt);
    AppMethodBeat.o(202714);
    return localObject;
  }
  
  public final int getSize()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */