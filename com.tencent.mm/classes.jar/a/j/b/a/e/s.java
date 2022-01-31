package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.q;
import a.j.b.a.c.d.a.e.y;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "hasAnnotationParameterDefaultValue", "", "getHasAnnotationParameterDefaultValue", "()Z", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
public final class s
  extends r
  implements q
{
  public final Method CFX;
  
  public s(Method paramMethod)
  {
    AppMethodBeat.i(123103);
    this.CFX = paramMethod;
    AppMethodBeat.o(123103);
  }
  
  public final List<x> edr()
  {
    AppMethodBeat.i(123102);
    Object localObject = this.CFX.getTypeParameters();
    j.p(localObject, "member.typeParameters");
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x(localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(123102);
    return localObject;
  }
  
  public final List<y> edu()
  {
    AppMethodBeat.i(123099);
    Object localObject = this.CFX.getGenericParameterTypes();
    j.p(localObject, "member.genericParameterTypes");
    Annotation[][] arrayOfAnnotation = this.CFX.getParameterAnnotations();
    j.p(arrayOfAnnotation, "member.parameterAnnotations");
    localObject = a((Type[])localObject, arrayOfAnnotation, this.CFX.isVarArgs());
    AppMethodBeat.o(123099);
    return localObject;
  }
  
  public final boolean egv()
  {
    AppMethodBeat.i(123101);
    if (this.CFX.getDefaultValue() != null)
    {
      AppMethodBeat.o(123101);
      return true;
    }
    AppMethodBeat.o(123101);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e.s
 * JD-Core Version:    0.7.0.1
 */