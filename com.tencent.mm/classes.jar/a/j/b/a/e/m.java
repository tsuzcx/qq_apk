package a.j.b.a.e;

import a.a.e;
import a.a.v;
import a.f.b.j;
import a.j.b.a.c.d.a.e.k;
import a.j.b.a.c.d.a.e.y;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaConstructor;", "member", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getMember", "()Ljava/lang/reflect/Constructor;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
public final class m
  extends r
  implements k
{
  public final Constructor<?> CFU;
  
  public m(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(123091);
    this.CFU = paramConstructor;
    AppMethodBeat.o(123091);
  }
  
  public final List<x> edr()
  {
    AppMethodBeat.i(123090);
    Object localObject = this.CFU.getTypeParameters();
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
    AppMethodBeat.o(123090);
    return localObject;
  }
  
  public final List<y> edu()
  {
    AppMethodBeat.i(123089);
    Object localObject1 = this.CFU.getGenericParameterTypes();
    j.p(localObject1, "types");
    if (localObject1.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = (List)v.BMx;
      AppMethodBeat.o(123089);
      return localObject1;
    }
    Object localObject2 = this.CFU.getDeclaringClass();
    j.p(localObject2, "klass");
    if ((((Class)localObject2).getDeclaringClass() != null) && (!Modifier.isStatic(((Class)localObject2).getModifiers()))) {
      localObject1 = (Type[])e.copyOfRange((Object[])localObject1, 1, localObject1.length);
    }
    for (;;)
    {
      localObject2 = this.CFU.getParameterAnnotations();
      if (((Object[])localObject2).length >= localObject1.length) {
        break;
      }
      localObject1 = (Throwable)new IllegalStateException("Illegal generic signature: " + this.CFU);
      AppMethodBeat.o(123089);
      throw ((Throwable)localObject1);
    }
    if (((Object[])localObject2).length > localObject1.length)
    {
      j.p(localObject2, "annotations");
      localObject2 = (Annotation[][])e.copyOfRange((Object[])localObject2, ((Object[])localObject2).length - localObject1.length, ((Object[])localObject2).length);
    }
    for (;;)
    {
      j.p(localObject1, "realTypes");
      j.p(localObject2, "realAnnotations");
      localObject1 = a((Type[])localObject1, (Annotation[][])localObject2, this.CFU.isVarArgs());
      AppMethodBeat.o(123089);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.e.m
 * JD-Core Version:    0.7.0.1
 */