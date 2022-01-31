package a.j.b.a.b;

import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.d.a.e.t;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.b;
import a.j.b.a.e.u;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/ReflectJavaClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/java/JavaClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findPackage", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "knownClassNamesInPackage", "", "", "packageFqName", "descriptors.runtime"})
public final class c
  implements a.j.b.a.c.d.a.j
{
  private final ClassLoader BRf;
  
  public c(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(119030);
    this.BRf = paramClassLoader;
    AppMethodBeat.o(119030);
  }
  
  public final g a(a parama)
  {
    AppMethodBeat.i(119027);
    a.f.b.j.q(parama, "classId");
    b localb = parama.BUK;
    a.f.b.j.p(localb, "classId.packageFqName");
    parama = parama.CqB.CqE.CqJ;
    a.f.b.j.p(parama, "classId.relativeClassName.asString()");
    parama = m.a(parama, '.', '$');
    if (localb.CqE.CqJ.isEmpty()) {}
    for (;;)
    {
      parama = d.a(this.BRf, parama);
      if (parama == null) {
        break;
      }
      parama = (g)new a.j.b.a.e.j(parama);
      AppMethodBeat.o(119027);
      return parama;
      parama = localb.CqE.CqJ + "." + parama;
    }
    AppMethodBeat.o(119027);
    return null;
  }
  
  public final t a(b paramb)
  {
    AppMethodBeat.i(119028);
    a.f.b.j.q(paramb, "fqName");
    paramb = (t)new u(paramb);
    AppMethodBeat.o(119028);
    return paramb;
  }
  
  public final Set<String> b(b paramb)
  {
    AppMethodBeat.i(119029);
    a.f.b.j.q(paramb, "packageFqName");
    AppMethodBeat.o(119029);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */