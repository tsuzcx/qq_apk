package a.j.b.a.e;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.d.a.e.t;
import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPackage;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "(Lorg/jetbrains/kotlin/name/FqName;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "isDeprecatedInJavaDoc", "", "()Z", "subPackages", "", "getSubPackages", "()Ljava/util/Collection;", "equals", "other", "", "findAnnotation", "", "getClasses", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "nameFilter", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "hashCode", "", "toString", "", "descriptors.runtime"})
public final class u
  extends n
  implements t
{
  private final a.j.b.a.c.f.b BXD;
  
  public u(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(123113);
    this.BXD = paramb;
    AppMethodBeat.o(123113);
  }
  
  public final a.j.b.a.c.f.b eee()
  {
    return this.BXD;
  }
  
  public final Collection<t> egy()
  {
    return (Collection)v.BMx;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(123110);
    if (((paramObject instanceof u)) && (j.e(this.BXD, ((u)paramObject).BXD)))
    {
      AppMethodBeat.o(123110);
      return true;
    }
    AppMethodBeat.o(123110);
    return false;
  }
  
  public final Collection<g> g(a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(123108);
    j.q(paramb, "nameFilter");
    paramb = (Collection)v.BMx;
    AppMethodBeat.o(123108);
    return paramb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(123111);
    int i = this.BXD.hashCode();
    AppMethodBeat.o(123111);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123112);
    String str = getClass().getName() + ": " + this.BXD;
    AppMethodBeat.o(123112);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.e.u
 * JD-Core Version:    0.7.0.1
 */