package a.j.b.a.e;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"findAnnotation", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "", "", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "([Ljava/lang/annotation/Annotation;Lorg/jetbrains/kotlin/name/FqName;)Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "", "([Ljava/lang/annotation/Annotation;)Ljava/util/List;", "descriptors.runtime"})
public final class g
{
  public static final c a(Annotation[] paramArrayOfAnnotation, a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(123036);
    j.q(paramArrayOfAnnotation, "receiver$0");
    j.q(paramb, "fqName");
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    Annotation localAnnotation;
    if (i < j)
    {
      localAnnotation = paramArrayOfAnnotation[i];
      if (!j.e(b.aU(a.f.a.a(a.f.a.a(localAnnotation))).emc(), paramb)) {}
    }
    for (paramArrayOfAnnotation = localAnnotation;; paramArrayOfAnnotation = null)
    {
      if (paramArrayOfAnnotation == null) {
        break label88;
      }
      paramArrayOfAnnotation = new c(paramArrayOfAnnotation);
      AppMethodBeat.o(123036);
      return paramArrayOfAnnotation;
      i += 1;
      break;
    }
    label88:
    AppMethodBeat.o(123036);
    return null;
  }
  
  public static final List<c> a(Annotation[] paramArrayOfAnnotation)
  {
    AppMethodBeat.i(123035);
    j.q(paramArrayOfAnnotation, "receiver$0");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfAnnotation.length);
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new c(paramArrayOfAnnotation[i]));
      i += 1;
    }
    paramArrayOfAnnotation = (List)localCollection;
    AppMethodBeat.o(123035);
    return paramArrayOfAnnotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.e.g
 * JD-Core Version:    0.7.0.1
 */