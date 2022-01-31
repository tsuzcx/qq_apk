package a.j.b.a.e;

import a.a.ad;
import a.f.a.d;
import a.f.a.g;
import a.f.a.h;
import a.f.a.k;
import a.f.a.n;
import a.f.a.o;
import a.f.a.p;
import a.f.a.q;
import a.f.a.r;
import a.f.a.s;
import a.f.a.t;
import a.f.a.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "PRIMITIVE_CLASSES", "", "Lkotlin/reflect/KClass;", "", "PRIMITIVE_TO_WRAPPER", "WRAPPER_TO_PRIMITIVE", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/name/ClassId;", "desc", "", "getDesc", "(Ljava/lang/Class;)Ljava/lang/String;", "functionClassArity", "getFunctionClassArity", "(Ljava/lang/Class;)Ljava/lang/Integer;", "parameterizedTypeArguments", "Ljava/lang/reflect/Type;", "getParameterizedTypeArguments", "(Ljava/lang/reflect/Type;)Ljava/util/List;", "primitiveByWrapper", "getPrimitiveByWrapper", "(Ljava/lang/Class;)Ljava/lang/Class;", "safeClassLoader", "Ljava/lang/ClassLoader;", "getSafeClassLoader", "(Ljava/lang/Class;)Ljava/lang/ClassLoader;", "wrapperByPrimitive", "getWrapperByPrimitive", "createArrayType", "isEnumClassOrSpecializedEnumEntryClass", "", "descriptors.runtime"})
public final class b
{
  private static final List<a.j.b<? extends Object>> CFC;
  private static final Map<Class<? extends Object>, Class<? extends Object>> CFD;
  private static final Map<Class<? extends Object>, Class<? extends Object>> CFE;
  private static final Map<Class<? extends a.c<?>>, Integer> CFF;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(123022);
    Object localObject1 = a.a.j.listOf(new a.j.b[] { a.f.b.v.aG(Boolean.TYPE), a.f.b.v.aG(Byte.TYPE), a.f.b.v.aG(Character.TYPE), a.f.b.v.aG(Double.TYPE), a.f.b.v.aG(Float.TYPE), a.f.b.v.aG(Integer.TYPE), a.f.b.v.aG(Long.TYPE), a.f.b.v.aG(Short.TYPE) });
    CFC = (List)localObject1;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.j.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(a.u.F(a.f.a.c((a.j.b)localObject3), a.f.a.b((a.j.b)localObject3)));
    }
    CFD = ad.w((Iterable)localObject1);
    localObject2 = (Iterable)CFC;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.j.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(a.u.F(a.f.a.b((a.j.b)localObject3), a.f.a.c((a.j.b)localObject3)));
    }
    CFE = ad.w((Iterable)localObject1);
    localObject2 = (Iterable)a.a.j.listOf(new Class[] { a.f.a.a.class, a.f.a.b.class, a.f.a.m.class, q.class, r.class, s.class, t.class, a.f.a.u.class, a.f.a.v.class, w.class, a.f.a.c.class, d.class, a.f.a.e.class, a.f.a.f.class, g.class, h.class, a.f.a.i.class, a.f.a.j.class, k.class, a.f.a.l.class, n.class, o.class, p.class });
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      ((Collection)localObject1).add(a.u.F((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    CFF = ad.w((Iterable)localObject1);
    AppMethodBeat.o(123022);
  }
  
  public static final ClassLoader aQ(Class<?> paramClass)
  {
    AppMethodBeat.i(123014);
    a.f.b.j.q(paramClass, "receiver$0");
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = localClassLoader;
    if (localClassLoader == null)
    {
      paramClass = ClassLoader.getSystemClassLoader();
      a.f.b.j.p(paramClass, "ClassLoader.getSystemClassLoader()");
    }
    AppMethodBeat.o(123014);
    return paramClass;
  }
  
  public static final boolean aR(Class<?> paramClass)
  {
    AppMethodBeat.i(123015);
    a.f.b.j.q(paramClass, "receiver$0");
    boolean bool = Enum.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(123015);
    return bool;
  }
  
  public static final Class<?> aS(Class<?> paramClass)
  {
    AppMethodBeat.i(123016);
    a.f.b.j.q(paramClass, "receiver$0");
    paramClass = (Class)CFD.get(paramClass);
    AppMethodBeat.o(123016);
    return paramClass;
  }
  
  public static final Class<?> aT(Class<?> paramClass)
  {
    AppMethodBeat.i(123017);
    a.f.b.j.q(paramClass, "receiver$0");
    paramClass = (Class)CFE.get(paramClass);
    AppMethodBeat.o(123017);
    return paramClass;
  }
  
  public static final a.j.b.a.c.f.a aU(Class<?> paramClass)
  {
    AppMethodBeat.i(123018);
    a.f.b.j.q(paramClass, "receiver$0");
    if (paramClass.isPrimitive())
    {
      paramClass = (Throwable)new IllegalArgumentException("Can't compute ClassId for primitive type: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(123018);
      throw paramClass;
    }
    if (paramClass.isArray())
    {
      paramClass = (Throwable)new IllegalArgumentException("Can't compute ClassId for array type: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(123018);
      throw paramClass;
    }
    if ((paramClass.getEnclosingMethod() == null) && (paramClass.getEnclosingConstructor() == null))
    {
      localObject = paramClass.getSimpleName();
      a.f.b.j.p(localObject, "simpleName");
      if (((CharSequence)localObject).length() != 0) {
        break label171;
      }
    }
    label171:
    for (int i = 1; i != 0; i = 0)
    {
      paramClass = new a.j.b.a.c.f.b(paramClass.getName());
      paramClass = new a.j.b.a.c.f.a(paramClass.emd(), a.j.b.a.c.f.b.s(paramClass.CqE.emh()), true);
      AppMethodBeat.o(123018);
      return paramClass;
    }
    Object localObject = paramClass.getDeclaringClass();
    if (localObject != null)
    {
      localObject = aU((Class)localObject);
      if (localObject != null)
      {
        paramClass = ((a.j.b.a.c.f.a)localObject).p(a.j.b.a.c.f.f.ayT(paramClass.getSimpleName()));
        AppMethodBeat.o(123018);
        return paramClass;
      }
    }
    paramClass = a.j.b.a.c.f.a.n(new a.j.b.a.c.f.b(paramClass.getName()));
    a.f.b.j.p(paramClass, "ClassId.topLevel(FqName(name))");
    AppMethodBeat.o(123018);
    return paramClass;
  }
  
  public static final String aV(Class<?> paramClass)
  {
    AppMethodBeat.i(123019);
    a.f.b.j.q(paramClass, "receiver$0");
    if (a.f.b.j.e(paramClass, Void.TYPE))
    {
      AppMethodBeat.o(123019);
      return "V";
    }
    paramClass = aW(paramClass).getName();
    a.f.b.j.p(paramClass, "createArrayType().name");
    if (paramClass == null)
    {
      paramClass = new a.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(123019);
      throw paramClass;
    }
    paramClass = paramClass.substring(1);
    a.f.b.j.p(paramClass, "(this as java.lang.String).substring(startIndex)");
    paramClass = a.l.m.a(paramClass, '.', '/');
    AppMethodBeat.o(123019);
    return paramClass;
  }
  
  public static final Class<?> aW(Class<?> paramClass)
  {
    AppMethodBeat.i(123020);
    a.f.b.j.q(paramClass, "receiver$0");
    paramClass = Array.newInstance(paramClass, 0).getClass();
    AppMethodBeat.o(123020);
    return paramClass;
  }
  
  public static final List<Type> j(Type paramType)
  {
    AppMethodBeat.i(123021);
    a.f.b.j.q(paramType, "receiver$0");
    if (!(paramType instanceof ParameterizedType))
    {
      paramType = (List)a.a.v.BMx;
      AppMethodBeat.o(123021);
      return paramType;
    }
    if (((ParameterizedType)paramType).getOwnerType() == null)
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      a.f.b.j.p(paramType, "actualTypeArguments");
      paramType = a.a.e.R(paramType);
      AppMethodBeat.o(123021);
      return paramType;
    }
    paramType = a.k.i.c(a.k.i.c(a.k.i.a(paramType, (a.f.a.b)b.a.CFG), (a.f.a.b)b.b.CFH));
    AppMethodBeat.o(123021);
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e.b
 * JD-Core Version:    0.7.0.1
 */