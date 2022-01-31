package a.l;

import a.a.a;
import a.f.a.b;
import a.f.b.k;
import a.k.i;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.regex.MatchResult;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
public final class j$b
  extends a<f>
  implements h
{
  public final int getSize()
  {
    AppMethodBeat.i(56288);
    int i = this.CGS.CGO.groupCount();
    AppMethodBeat.o(56288);
    return i + 1;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(56289);
    Iterator localIterator = i.d(a.a.j.t((Iterable)a.a.j.e(this)), (b)new a(this)).iterator();
    AppMethodBeat.o(56289);
    return localIterator;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
  static final class a
    extends k
    implements b<Integer, f>
  {
    a(j.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.l.j.b
 * JD-Core Version:    0.7.0.1
 */