package a.j.b.a.e;

import a.j.b.a.c.d.a.e.a;
import a.j.b.a.c.d.a.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/Collection;", "classifier", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifier;", "getClassifier", "()Lorg/jetbrains/kotlin/load/java/structure/JavaClassifier;", "classifierQualifiedName", "", "getClassifierQualifiedName", "()Ljava/lang/String;", "isDeprecatedInJavaDoc", "", "()Z", "isRaw", "presentableText", "getPresentableText", "getReflectType", "()Ljava/lang/reflect/Type;", "typeArguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "getTypeArguments", "()Ljava/util/List;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
public final class l
  extends w
  implements a.j.b.a.c.d.a.e.j
{
  final Type CFK;
  private final i CFT;
  
  public l(Type paramType)
  {
    AppMethodBeat.i(123088);
    this.CFK = paramType;
    paramType = ((l)this).CFK;
    if ((paramType instanceof Class)) {
      paramType = (i)new j((Class)paramType);
    }
    for (;;)
    {
      this.CFT = paramType;
      AppMethodBeat.o(123088);
      return;
      if ((paramType instanceof TypeVariable))
      {
        paramType = (i)new x((TypeVariable)paramType);
      }
      else
      {
        if (!(paramType instanceof ParameterizedType)) {
          break;
        }
        paramType = ((ParameterizedType)paramType).getRawType();
        if (paramType == null)
        {
          paramType = new a.v("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(123088);
          throw paramType;
        }
        paramType = (i)new j((Class)paramType);
      }
    }
    paramType = (Throwable)new IllegalStateException("Not a classifier type (" + paramType.getClass() + "): " + paramType);
    AppMethodBeat.o(123088);
    throw paramType;
  }
  
  public final Collection<a> egb()
  {
    return (Collection)a.a.v.BMx;
  }
  
  public final i egk()
  {
    return this.CFT;
  }
  
  public final List<a.j.b.a.c.d.a.e.v> egl()
  {
    AppMethodBeat.i(123086);
    Object localObject2 = (Iterable)b.j(this.CFK);
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(w.a.k((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(123086);
    return localObject1;
  }
  
  public final boolean egm()
  {
    AppMethodBeat.i(123085);
    Object localObject = this.CFK;
    if ((localObject instanceof Class))
    {
      localObject = ((Class)localObject).getTypeParameters();
      a.f.b.j.p(localObject, "getTypeParameters()");
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label60;
        }
      }
      label60:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label65;
        }
        AppMethodBeat.o(123085);
        return true;
        i = 0;
        break;
      }
    }
    label65:
    AppMethodBeat.o(123085);
    return false;
  }
  
  public final String egn()
  {
    AppMethodBeat.i(123083);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("Type not found: " + this.CFK);
    AppMethodBeat.o(123083);
    throw localThrowable;
  }
  
  public final String ego()
  {
    AppMethodBeat.i(123084);
    String str = this.CFK.toString();
    AppMethodBeat.o(123084);
    return str;
  }
  
  public final Type epg()
  {
    return this.CFK;
  }
  
  public final a m(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(123087);
    a.f.b.j.q(paramb, "fqName");
    AppMethodBeat.o(123087);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.e.l
 * JD-Core Version:    0.7.0.1
 */