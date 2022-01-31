package a.k;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class b<T>
  implements c<T>, h<T>
{
  final h<T> CGh;
  final int count;
  
  public b(h<? extends T> paramh, int paramInt)
  {
    AppMethodBeat.i(55972);
    this.CGh = paramh;
    this.count = paramInt;
    if (this.count >= 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramh = (Throwable)new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
      AppMethodBeat.o(55972);
      throw paramh;
    }
    AppMethodBeat.o(55972);
  }
  
  public final h<T> eph()
  {
    AppMethodBeat.i(55970);
    int i = this.count + 1;
    if (i < 0)
    {
      localh = (h)new b((h)this, 1);
      AppMethodBeat.o(55970);
      return localh;
    }
    h localh = (h)new b(this.CGh, i);
    AppMethodBeat.o(55970);
    return localh;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(55971);
    Iterator localIterator = (Iterator)new b.a(this);
    AppMethodBeat.o(55971);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.k.b
 * JD-Core Version:    0.7.0.1
 */