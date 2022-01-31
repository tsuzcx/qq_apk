package a.j.b.a.c.b.c;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.i.e.d;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.i.j;
import a.j.b.a.c.k.c;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

final class n$a
  extends a.j.b.a.c.i.e.i
{
  private final c<a.j.b.a.c.f.f, Collection<al>> BZs;
  private final c<a.j.b.a.c.f.f, Collection<ah>> BZt;
  private final a.j.b.a.c.k.f<Collection<l>> BZu;
  
  static
  {
    AppMethodBeat.i(119450);
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(119450);
      return;
    }
  }
  
  public n$a(n paramn, a.j.b.a.c.k.i parami)
  {
    AppMethodBeat.i(119439);
    this.BZs = parami.i(new n.a.1(this, paramn));
    this.BZt = parami.i(new n.a.2(this, paramn));
    this.BZu = parami.l(new n.a.3(this, paramn));
    AppMethodBeat.o(119439);
  }
  
  private h eeS()
  {
    AppMethodBeat.i(119442);
    Object localObject = this.BZv.BZl.eeO();
    if ((!$assertionsDisabled) && (((Collection)localObject).size() != 1))
    {
      localObject = new AssertionError("Enum entry and its companion object both should have exactly one supertype: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(119442);
      throw ((Throwable)localObject);
    }
    localObject = ((w)((Collection)localObject).iterator().next()).ecq();
    AppMethodBeat.o(119442);
    return localObject;
  }
  
  private <D extends a.j.b.a.c.b.b> Collection<D> j(Collection<D> paramCollection)
  {
    AppMethodBeat.i(119443);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    j.a(paramCollection, Collections.emptySet(), this.BZv, new n.a.4(this, localLinkedHashSet));
    AppMethodBeat.o(119443);
    return localLinkedHashSet;
  }
  
  public final Collection a(a.j.b.a.c.f.f paramf, a parama)
  {
    AppMethodBeat.i(119440);
    paramf = (Collection)this.BZt.S(paramf);
    AppMethodBeat.o(119440);
    return paramf;
  }
  
  public final Collection<l> a(d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(119444);
    paramd = (Collection)this.BZu.invoke();
    AppMethodBeat.o(119444);
    return paramd;
  }
  
  public final Collection b(a.j.b.a.c.f.f paramf, a parama)
  {
    AppMethodBeat.i(119441);
    paramf = (Collection)this.BZs.S(paramf);
    AppMethodBeat.o(119441);
    return paramf;
  }
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    AppMethodBeat.i(119445);
    Set localSet = (Set)n.a(this.BZv).invoke();
    AppMethodBeat.o(119445);
    return localSet;
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    AppMethodBeat.i(119446);
    Set localSet = (Set)n.a(this.BZv).invoke();
    AppMethodBeat.o(119446);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.b.c.n.a
 * JD-Core Version:    0.7.0.1
 */