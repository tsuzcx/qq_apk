package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.d;
import a.j.b.a.c.b.l;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.i.e.h.b;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class w
  extends g
{
  private final i BRT;
  private final boolean BWA;
  private List<ar> BWy;
  public az BZE;
  private a.j.b.a.c.b.w BZj;
  private final a.j.b.a.c.b.f BZk;
  private an BZl;
  private final Collection<a.j.b.a.c.l.w> CaJ;
  
  static
  {
    AppMethodBeat.i(119535);
    if (!w.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(119535);
      return;
    }
  }
  
  public w(l paraml, a.j.b.a.c.b.f paramf, a.j.b.a.c.f.f paramf1, am paramam, i parami)
  {
    super(parami, paraml, paramf1, paramam);
    AppMethodBeat.i(119527);
    this.CaJ = new ArrayList();
    this.BRT = parami;
    if ((!$assertionsDisabled) && (paramf == a.j.b.a.c.b.f.BWk))
    {
      paraml = new AssertionError("Fix isCompanionObject()");
      AppMethodBeat.o(119527);
      throw paraml;
    }
    this.BZk = paramf;
    this.BWA = false;
    AppMethodBeat.o(119527);
  }
  
  public final void b(a.j.b.a.c.b.w paramw)
  {
    AppMethodBeat.i(119529);
    if ((!$assertionsDisabled) && (paramw == a.j.b.a.c.b.w.BWq))
    {
      paramw = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
      AppMethodBeat.o(119529);
      throw paramw;
    }
    this.BZj = paramw;
    AppMethodBeat.o(119529);
  }
  
  public final a.j.b.a.c.b.f ecB()
  {
    return this.BZk;
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    return this.BZj;
  }
  
  public final d ecD()
  {
    return null;
  }
  
  public final az ecE()
  {
    return this.BZE;
  }
  
  public final boolean ecF()
  {
    return false;
  }
  
  public final boolean ecG()
  {
    return this.BWA;
  }
  
  public final boolean ecH()
  {
    return false;
  }
  
  public final boolean ecI()
  {
    return false;
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    AppMethodBeat.i(119528);
    Object localObject = a.j.b.a.c.b.a.g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(119528);
    return localObject;
  }
  
  public final Collection<a.j.b.a.c.b.e> ecO()
  {
    AppMethodBeat.i(119532);
    List localList = Collections.emptyList();
    AppMethodBeat.o(119532);
    return localList;
  }
  
  public final List<ar> ecP()
  {
    return this.BWy;
  }
  
  public final h ecw()
  {
    return h.b.CxW;
  }
  
  public final an ecx()
  {
    return this.BZl;
  }
  
  public final h ecy()
  {
    return h.b.CxW;
  }
  
  public final a.j.b.a.c.b.e ecz()
  {
    return null;
  }
  
  public final void efe()
  {
    AppMethodBeat.i(119531);
    if ((!$assertionsDisabled) && (this.BZl != null))
    {
      localObject = new AssertionError(this.BZl);
      AppMethodBeat.o(119531);
      throw ((Throwable)localObject);
    }
    this.BZl = new a.j.b.a.c.l.e(this, this.BWy, this.CaJ, this.BRT);
    Object localObject = Collections.emptySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((f)((Iterator)localObject).next()).BZB = edE();
    }
    AppMethodBeat.o(119531);
  }
  
  public final void gc(List<ar> paramList)
  {
    AppMethodBeat.i(119530);
    if (this.BWy != null)
    {
      paramList = new IllegalStateException("Type parameters are already set for " + this.BYN);
      AppMethodBeat.o(119530);
      throw paramList;
    }
    this.BWy = new ArrayList(paramList);
    AppMethodBeat.o(119530);
  }
  
  public String toString()
  {
    AppMethodBeat.i(119533);
    String str = j.h(this);
    AppMethodBeat.o(119533);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.c.w
 * JD-Core Version:    0.7.0.1
 */