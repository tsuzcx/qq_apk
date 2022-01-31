package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ai
  extends aj
  implements au
{
  public static final ai.a Cbo;
  private final au Cbj;
  private final boolean Cbk;
  private final boolean Cbl;
  private final boolean Cbm;
  private final w Cbn;
  private final int index;
  
  static
  {
    AppMethodBeat.i(119634);
    Cbo = new ai.a((byte)0);
    AppMethodBeat.o(119634);
  }
  
  public ai(a parama, au paramau, int paramInt, g paramg, f paramf, w paramw1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, w paramw2, am paramam)
  {
    super((l)parama, paramg, paramf, paramw1, paramam);
    AppMethodBeat.i(119633);
    this.index = paramInt;
    this.Cbk = paramBoolean1;
    this.Cbl = paramBoolean2;
    this.Cbm = paramBoolean3;
    this.Cbn = paramw2;
    if (paramau == null) {}
    for (parama = (au)this;; parama = paramau)
    {
      this.Cbj = parama;
      AppMethodBeat.o(119633);
      return;
    }
  }
  
  public final au a(a parama, f paramf, int paramInt)
  {
    AppMethodBeat.i(119630);
    a.f.b.j.q(parama, "newOwner");
    a.f.b.j.q(paramf, "newName");
    g localg = ecM();
    a.f.b.j.p(localg, "annotations");
    w localw1 = eer();
    a.f.b.j.p(localw1, "type");
    boolean bool1 = eet();
    boolean bool2 = this.Cbl;
    boolean bool3 = this.Cbm;
    w localw2 = this.Cbn;
    am localam = am.BWF;
    a.f.b.j.p(localam, "SourceElement.NO_SOURCE");
    parama = (au)new ai(parama, null, paramInt, localg, paramf, localw1, bool1, bool2, bool3, localw2, localam);
    AppMethodBeat.o(119630);
    return parama;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119629);
    a.f.b.j.q(paramn, "visitor");
    paramn = paramn.a((au)this, paramD);
    AppMethodBeat.o(119629);
    return paramn;
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(119631);
    az localaz = ay.BWP;
    a.f.b.j.p(localaz, "Visibilities.LOCAL");
    AppMethodBeat.o(119631);
    return localaz;
  }
  
  public final Collection<au> edw()
  {
    AppMethodBeat.i(119632);
    Collection localCollection = ees().edw();
    a.f.b.j.p(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      a.f.b.j.p(locala, "it");
      localCollection.add((au)locala.edu().get(this.index));
    }
    localCollection = (Collection)localCollection;
    AppMethodBeat.o(119632);
    return localCollection;
  }
  
  public final boolean eeB()
  {
    return false;
  }
  
  public final a ees()
  {
    AppMethodBeat.i(119620);
    Object localObject = super.ecv();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(119620);
      throw ((Throwable)localObject);
    }
    localObject = (a)localObject;
    AppMethodBeat.o(119620);
    return localObject;
  }
  
  public final boolean eet()
  {
    AppMethodBeat.i(119622);
    if (this.Cbk)
    {
      Object localObject = ees();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        AppMethodBeat.o(119622);
        throw ((Throwable)localObject);
      }
      localObject = ((b)localObject).edy();
      a.f.b.j.p(localObject, "(containingDeclaration a…bleMemberDescriptor).kind");
      if (((b.a)localObject).edz())
      {
        AppMethodBeat.o(119622);
        return true;
      }
    }
    AppMethodBeat.o(119622);
    return false;
  }
  
  public final w eeu()
  {
    return this.Cbn;
  }
  
  public final au eev()
  {
    AppMethodBeat.i(119623);
    if (this.Cbj == (ai)this)
    {
      localau = (au)this;
      AppMethodBeat.o(119623);
      return localau;
    }
    au localau = this.Cbj.eev();
    AppMethodBeat.o(119623);
    return localau;
  }
  
  public final boolean eew()
  {
    return this.Cbl;
  }
  
  public final boolean eex()
  {
    return this.Cbm;
  }
  
  public final boolean eey()
  {
    return false;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.ai
 * JD-Core Version:    0.7.0.1
 */