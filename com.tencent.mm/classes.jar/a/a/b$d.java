package a.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.RandomAccess;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"})
final class b$d<E>
  extends b<E>
  implements RandomAccess
{
  private int BMm;
  private final b<E> BMn;
  private final int BMo;
  
  public b$d(b<? extends E> paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(56205);
    this.BMn = paramb;
    this.BMo = paramInt1;
    paramInt1 = this.BMo;
    int i = this.BMn.size();
    if ((paramInt1 < 0) || (paramInt2 > i))
    {
      paramb = (Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2 + ", size: " + i);
      AppMethodBeat.o(56205);
      throw paramb;
    }
    if (paramInt1 > paramInt2)
    {
      paramb = (Throwable)new IllegalArgumentException("fromIndex: " + paramInt1 + " > toIndex: " + paramInt2);
      AppMethodBeat.o(56205);
      throw paramb;
    }
    this.BMm = (paramInt2 - this.BMo);
    AppMethodBeat.o(56205);
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(56204);
    int i = this.BMm;
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = (Throwable)new IndexOutOfBoundsException("index: " + paramInt + ", size: " + i);
      AppMethodBeat.o(56204);
      throw ((Throwable)localObject);
    }
    Object localObject = this.BMn.get(this.BMo + paramInt);
    AppMethodBeat.o(56204);
    return localObject;
  }
  
  public final int getSize()
  {
    return this.BMm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.a.b.d
 * JD-Core Version:    0.7.0.1
 */