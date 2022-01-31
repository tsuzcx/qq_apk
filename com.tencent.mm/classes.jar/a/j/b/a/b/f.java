package a.j.b.a.b;

import a.f.b.j;
import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.d.b.n;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findBuiltInsData", "Ljava/io/InputStream;", "packageFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "findKotlinClass", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "fqName", "", "javaClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findMetadata", "hasMetadataPackage", "", "descriptors.runtime"})
public final class f
  implements a.j.b.a.c.d.b.m
{
  private final ClassLoader BRf;
  
  public f(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(119044);
    this.BRf = paramClassLoader;
    AppMethodBeat.o(119044);
  }
  
  private final n ayv(String paramString)
  {
    AppMethodBeat.i(119041);
    paramString = d.a(this.BRf, paramString);
    if (paramString != null) {
      e.a locala = e.BRi;
    }
    for (paramString = e.a.aO(paramString);; paramString = null)
    {
      paramString = (n)paramString;
      AppMethodBeat.o(119041);
      return paramString;
    }
  }
  
  public final n a(g paramg)
  {
    AppMethodBeat.i(119043);
    j.q(paramg, "javaClass");
    paramg = paramg.eee();
    if (paramg != null)
    {
      paramg = paramg.CqE.CqJ;
      if (paramg != null) {}
    }
    else
    {
      AppMethodBeat.o(119043);
      return null;
    }
    paramg = ayv(paramg);
    AppMethodBeat.o(119043);
    return paramg;
  }
  
  public final n b(a parama)
  {
    AppMethodBeat.i(119042);
    j.q(parama, "classId");
    String str = parama.CqB.CqE.CqJ;
    j.p(str, "relativeClassName.asString()");
    str = a.l.m.a(str, '.', '$');
    b localb = parama.BUK;
    j.p(localb, "packageFqName");
    if (localb.CqE.CqJ.isEmpty()) {}
    for (parama = str;; parama = parama.BUK + '.' + str)
    {
      parama = ayv(parama);
      AppMethodBeat.o(119042);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */