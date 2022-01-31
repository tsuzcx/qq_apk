package a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"})
public final class y<T>
{
  public final int index;
  public final T value;
  
  public y(int paramInt, T paramT)
  {
    this.index = paramInt;
    this.value = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56159);
    if (this != paramObject)
    {
      if (!(paramObject instanceof y)) {
        break label65;
      }
      paramObject = (y)paramObject;
      if (this.index != paramObject.index) {
        break label60;
      }
    }
    label60:
    for (int i = 1; (i != 0) && (j.e(this.value, paramObject.value)); i = 0)
    {
      AppMethodBeat.o(56159);
      return true;
    }
    label65:
    AppMethodBeat.o(56159);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56158);
    int j = this.index;
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      AppMethodBeat.o(56158);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56157);
    String str = "IndexedValue(index=" + this.index + ", value=" + this.value + ")";
    AppMethodBeat.o(56157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.a.y
 * JD-Core Version:    0.7.0.1
 */