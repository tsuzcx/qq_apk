package a.a;

import a.i.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"})
public final class h$a
  extends b<Integer>
  implements RandomAccess
{
  h$a(int[] paramArrayOfInt) {}
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(56215);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(56215);
      return false;
    }
    int i = ((Number)paramObject).intValue();
    boolean bool = e.contains(this.BMq, i);
    AppMethodBeat.o(56215);
    return bool;
  }
  
  public final int getSize()
  {
    return this.BMq.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(56217);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(56217);
      return -1;
    }
    int i = ((Number)paramObject).intValue();
    i = e.k(this.BMq, i);
    AppMethodBeat.o(56217);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.BMq.length == 0;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(56218);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(56218);
      return -1;
    }
    int i = ((Number)paramObject).intValue();
    paramObject = this.BMq;
    a.f.b.j.q(paramObject, "receiver$0");
    a.f.b.j.q(paramObject, "receiver$0");
    Iterator localIterator = j.l((Iterable)new d(0, e.M(paramObject))).iterator();
    while (localIterator.hasNext())
    {
      int j = ((Number)localIterator.next()).intValue();
      if (i == paramObject[j])
      {
        AppMethodBeat.o(56218);
        return j;
      }
    }
    AppMethodBeat.o(56218);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.h.a
 * JD-Core Version:    0.7.0.1
 */