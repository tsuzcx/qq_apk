package a.j.b.a.e;

import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaValueParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "type", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "reflectAnnotations", "", "", "reflectName", "", "isVararg", "", "(Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;[Ljava/lang/annotation/Annotation;Ljava/lang/String;Z)V", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "isDeprecatedInJavaDoc", "()Z", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "[Ljava/lang/annotation/Annotation;", "getType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "toString", "descriptors.runtime"})
public final class y
  extends n
  implements a.j.b.a.c.d.a.e.y
{
  private final w CGb;
  private final Annotation[] CGc;
  private final String CGd;
  private final boolean CGe;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123129);
    this.CGb = paramw;
    this.CGc = paramArrayOfAnnotation;
    this.CGd = paramString;
    this.CGe = paramBoolean;
    AppMethodBeat.o(123129);
  }
  
  public final f edF()
  {
    AppMethodBeat.i(123127);
    Object localObject = this.CGd;
    if (localObject != null)
    {
      localObject = f.ayW((String)localObject);
      AppMethodBeat.o(123127);
      return localObject;
    }
    AppMethodBeat.o(123127);
    return null;
  }
  
  public final boolean egB()
  {
    return this.CGe;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123128);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.CGe) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + edF() + ": " + this.CGb;
      AppMethodBeat.o(123128);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.e.y
 * JD-Core Version:    0.7.0.1
 */