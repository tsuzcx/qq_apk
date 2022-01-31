package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.w;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "typeVariable", "Ljava/lang/reflect/TypeVariable;", "(Ljava/lang/reflect/TypeVariable;)V", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "getTypeVariable", "()Ljava/lang/reflect/TypeVariable;", "upperBounds", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "getUpperBounds", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "descriptors.runtime"})
public final class x
  extends n
  implements w, f
{
  private final TypeVariable<?> CGa;
  
  public x(TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(123122);
    this.CGa = paramTypeVariable;
    AppMethodBeat.o(123122);
  }
  
  public final a.j.b.a.c.f.f edF()
  {
    AppMethodBeat.i(123118);
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT(this.CGa.getName());
    j.p(localf, "Name.identifier(typeVariable.name)");
    AppMethodBeat.o(123118);
    return localf;
  }
  
  public final AnnotatedElement epf()
  {
    TypeVariable localTypeVariable2 = this.CGa;
    TypeVariable localTypeVariable1 = localTypeVariable2;
    if (!(localTypeVariable2 instanceof AnnotatedElement)) {
      localTypeVariable1 = null;
    }
    return (AnnotatedElement)localTypeVariable1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(123119);
    if (((paramObject instanceof x)) && (j.e(this.CGa, ((x)paramObject).CGa)))
    {
      AppMethodBeat.o(123119);
      return true;
    }
    AppMethodBeat.o(123119);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(123120);
    int i = this.CGa.hashCode();
    AppMethodBeat.o(123120);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123121);
    String str = getClass().getName() + ": " + this.CGa;
    AppMethodBeat.o(123121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.e.x
 * JD-Core Version:    0.7.0.1
 */