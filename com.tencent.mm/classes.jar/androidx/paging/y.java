package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d;
import kotlin.g.a.a;
import kotlin.g.b.n;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 4, 2})
final class y
  implements m.d, n
{
  y(a parama)
  {
    this.aSH = parama;
  }
  
  public final d HK()
  {
    return this.aSH;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196979);
    if (((paramObject instanceof m.d)) && ((paramObject instanceof n)) && (s.p(this.aSH, ((n)paramObject).HK())))
    {
      AppMethodBeat.o(196979);
      return true;
    }
    AppMethodBeat.o(196979);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196987);
    int i = this.aSH.hashCode();
    AppMethodBeat.o(196987);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.y
 * JD-Core Version:    0.7.0.1
 */