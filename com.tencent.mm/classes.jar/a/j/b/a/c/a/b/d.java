package a.j.b.a.c.a.b;

import a.a.aj;
import a.a.x;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.c;
import a.j.b.a.c.k.i;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class d
  implements a.j.b.a.c.b.b.b
{
  private static final a.j.b.a.c.f.b BVl;
  private static final a.j.b.a.c.f.f BVm;
  private static final a.j.b.a.c.f.a BVn;
  public static final d.a BVo;
  private final a.j.b.a.c.k.f BVi;
  private final y BVj;
  private final a.f.a.b<y, l> BVk;
  
  static
  {
    AppMethodBeat.i(119194);
    eOJ = new k[] { (k)v.a(new t(v.aG(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;")) };
    BVo = new d.a((byte)0);
    BVl = g.BRJ;
    Object localObject = g.BRU.BSc.emh();
    j.p(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    BVm = (a.j.b.a.c.f.f)localObject;
    localObject = a.j.b.a.c.f.a.n(g.BRU.BSc.emf());
    j.p(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    BVn = (a.j.b.a.c.f.a)localObject;
    AppMethodBeat.o(119194);
  }
  
  private d(i parami, y paramy, a.f.a.b<? super y, ? extends l> paramb)
  {
    AppMethodBeat.i(119199);
    this.BVj = paramy;
    this.BVk = paramb;
    this.BVi = parami.l((a.f.a.a)new d.b(this, parami));
    AppMethodBeat.o(119199);
  }
  
  private final a.j.b.a.c.b.c.h edb()
  {
    AppMethodBeat.i(119195);
    a.j.b.a.c.b.c.h localh = (a.j.b.a.c.b.c.h)a.j.b.a.c.k.h.a(this.BVi, eOJ[0]);
    AppMethodBeat.o(119195);
    return localh;
  }
  
  public final boolean a(a.j.b.a.c.f.b paramb, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119196);
    j.q(paramb, "packageFqName");
    j.q(paramf, "name");
    if ((j.e(paramf, BVm)) && (j.e(paramb, BVl)))
    {
      AppMethodBeat.o(119196);
      return true;
    }
    AppMethodBeat.o(119196);
    return false;
  }
  
  public final Collection<e> d(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119198);
    j.q(paramb, "packageFqName");
    if (j.e(paramb, BVl))
    {
      paramb = (Collection)aj.setOf(edb());
      AppMethodBeat.o(119198);
      return paramb;
    }
    paramb = (Collection)x.BMz;
    AppMethodBeat.o(119198);
    return paramb;
  }
  
  public final e e(a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(119197);
    j.q(parama, "classId");
    if (j.e(parama, BVn))
    {
      parama = (e)edb();
      AppMethodBeat.o(119197);
      return parama;
    }
    AppMethodBeat.o(119197);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.a.b.d
 * JD-Core Version:    0.7.0.1
 */