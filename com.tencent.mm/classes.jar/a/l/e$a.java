package a.l;

import a.f.b.a.a;
import a.i.d;
import a.l;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class e$a
  implements a, Iterator<d>
{
  private int CGI;
  private int CGJ;
  private d CGK;
  private int CGm;
  private int counter;
  
  e$a()
  {
    AppMethodBeat.i(56263);
    this.CGm = -1;
    this.CGI = a.i.e.aP(localObject.jih, 0, localObject.CGG.length());
    this.CGJ = this.CGI;
    AppMethodBeat.o(56263);
  }
  
  private final void epi()
  {
    AppMethodBeat.i(56260);
    if (this.CGJ < 0)
    {
      this.CGm = 0;
      this.CGK = null;
      AppMethodBeat.o(56260);
      return;
    }
    if (this.CGL.limit > 0)
    {
      this.counter += 1;
      if (this.counter >= this.CGL.limit) {}
    }
    else
    {
      if (this.CGJ <= this.CGL.CGG.length()) {
        break label122;
      }
    }
    this.CGK = new d(this.CGI, m.ar(this.CGL.CGG));
    label122:
    o localo;
    for (this.CGJ = -1;; this.CGJ = -1)
    {
      this.CGm = 1;
      AppMethodBeat.o(56260);
      return;
      localo = (o)this.CGL.CGH.h(this.CGL.CGG, Integer.valueOf(this.CGJ));
      if (localo != null) {
        break;
      }
      this.CGK = new d(this.CGI, m.ar(this.CGL.CGG));
    }
    int j = ((Number)localo.first).intValue();
    int i = ((Number)localo.second).intValue();
    this.CGK = a.i.e.iD(this.CGI, j);
    this.CGI = (j + i);
    j = this.CGI;
    if (i == 0) {}
    for (i = 1;; i = 0)
    {
      this.CGJ = (i + j);
      break;
    }
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(56262);
    if (this.CGm == -1) {
      epi();
    }
    if (this.CGm == 1)
    {
      AppMethodBeat.o(56262);
      return true;
    }
    AppMethodBeat.o(56262);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(56264);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56264);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.l.e.a
 * JD-Core Version:    0.7.0.1
 */