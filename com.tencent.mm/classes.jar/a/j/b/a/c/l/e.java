package a.j.b.a.c.l;

import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ap.a;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.f.c;
import a.j.b.a.c.i.d;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class e
  extends b
  implements an
{
  private final Collection<w> CaJ;
  private final a.j.b.a.c.b.e Cym;
  private final List<ar> parameters;
  
  public e(a.j.b.a.c.b.e parame, List<? extends ar> paramList, Collection<w> paramCollection, i parami)
  {
    super(parami);
    AppMethodBeat.i(122497);
    this.Cym = parame;
    this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
    this.CaJ = Collections.unmodifiableCollection(paramCollection);
    AppMethodBeat.o(122497);
  }
  
  protected final Collection<w> ecQ()
  {
    return this.CaJ;
  }
  
  public final a.j.b.a.c.b.e ecS()
  {
    return this.Cym;
  }
  
  public final boolean ecT()
  {
    return true;
  }
  
  protected final ap ecU()
  {
    return ap.a.BWH;
  }
  
  public final List<ar> getParameters()
  {
    return this.parameters;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122498);
    String str = d.n(this.Cym).CqJ;
    AppMethodBeat.o(122498);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.e
 * JD-Core Version:    0.7.0.1
 */