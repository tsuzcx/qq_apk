package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "arguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "getArguments", "()Ljava/util/Collection;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "equals", "", "other", "", "hashCode", "", "resolve", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "toString", "", "descriptors.runtime"})
public final class c
  extends n
  implements a.j.b.a.c.d.a.e.a
{
  public final Annotation BRd;
  
  public c(Annotation paramAnnotation)
  {
    AppMethodBeat.i(123029);
    this.BRd = paramAnnotation;
    AppMethodBeat.o(123029);
  }
  
  public final a.j.b.a.c.f.a ebx()
  {
    AppMethodBeat.i(123024);
    a.j.b.a.c.f.a locala = b.aU(a.f.a.a(a.f.a.a(this.BRd)));
    AppMethodBeat.o(123024);
    return locala;
  }
  
  public final Collection<a.j.b.a.c.d.a.e.b> efY()
  {
    AppMethodBeat.i(123023);
    Object localObject1 = a.f.a.a(a.f.a.a(this.BRd)).getDeclaredMethods();
    j.p(localObject1, "annotation.annotationClass.java.declaredMethods");
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      Object localObject3 = d.CFI;
      localObject3 = localObject2.invoke(this.BRd, new Object[0]);
      j.p(localObject3, "method.invoke(annotation)");
      j.p(localObject2, "method");
      localCollection.add(d.a.a(localObject3, f.ayT(localObject2.getName())));
      i += 1;
    }
    localObject1 = (Collection)localCollection;
    AppMethodBeat.o(123023);
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(123026);
    if (((paramObject instanceof c)) && (j.e(this.BRd, ((c)paramObject).BRd)))
    {
      AppMethodBeat.o(123026);
      return true;
    }
    AppMethodBeat.o(123026);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(123027);
    int i = this.BRd.hashCode();
    AppMethodBeat.o(123027);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123028);
    String str = getClass().getName() + ": " + this.BRd;
    AppMethodBeat.o(123028);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e.c
 * JD-Core Version:    0.7.0.1
 */