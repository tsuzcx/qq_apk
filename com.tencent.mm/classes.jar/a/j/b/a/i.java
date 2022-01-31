package a.j.b.a;

import a.f.a.a;
import a.f.b.d;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.i.e.j.a;
import a.l.m;
import a.v;
import a.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Ljava.lang.Class<*>;>;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "isPublic", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "returnType", "tryGetConstructor", "declared", "tryGetMethod", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflect-api"})
public abstract class i
  implements d
{
  private static final Class<?> BOQ = Class.forName("a.f.b.g");
  static final a.l.k BOR = new a.l.k("<v#(\\d+)>");
  public static final a BOS = new a((byte)0);
  
  static Constructor<?> a(Class<?> paramClass, List<? extends Class<?>> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramList = (Collection)paramList;
      if (paramList == null) {
        throw new v("null cannot be cast to non-null type java.util.Collection<T>");
      }
      paramList = paramList.toArray(new Class[0]);
      if (paramList == null) {
        throw new v("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramList = (Class[])paramList;
      return paramClass.getDeclaredConstructor((Class[])Arrays.copyOf(paramList, paramList.length));
    }
    catch (NoSuchMethodException paramClass) {}
    paramList = (Collection)paramList;
    if (paramList == null) {
      throw new v("null cannot be cast to non-null type java.util.Collection<T>");
    }
    paramList = paramList.toArray(new Class[0]);
    if (paramList == null) {
      throw new v("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramList = (Class[])paramList;
    paramClass = paramClass.getConstructor((Class[])Arrays.copyOf(paramList, paramList.length));
    return paramClass;
    return null;
  }
  
  private final Method a(Class<?> paramClass1, String paramString, List<? extends Class<?>> paramList, Class<?> paramClass2, boolean paramBoolean)
  {
    Object localObject = (Collection)paramList;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type java.util.Collection<T>");
    }
    localObject = ((Collection)localObject).toArray(new Class[0]);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Array<T>");
    }
    Class[] arrayOfClass = (Class[])localObject;
    localObject = paramClass1;
    if (paramBoolean)
    {
      localObject = a(paramClass1, paramString, arrayOfClass, paramClass2, false);
      if (localObject != null) {
        paramList = (List<? extends Class<?>>)localObject;
      }
      do
      {
        return paramList;
        localObject = paramClass1;
        if (!paramClass1.isInterface()) {
          break;
        }
        localObject = a(Object.class, paramString, paramList, paramClass2, paramBoolean);
        paramList = (List<? extends Class<?>>)localObject;
      } while (localObject != null);
    }
    for (localObject = paramClass1;; localObject = ((Class)localObject).getSuperclass())
    {
      if (localObject == null) {
        break label154;
      }
      paramClass1 = a((Class)localObject, paramString, arrayOfClass, paramClass2, true);
      paramList = paramClass1;
      if (paramClass1 != null) {
        break;
      }
    }
    label154:
    return null;
  }
  
  private static Method a(Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Method localMethod;
      int i;
      int j;
      try
      {
        localMethod = paramClass1.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length));
        a.f.b.j.p(localMethod, "result");
        if (a.f.b.j.e(localMethod.getReturnType(), paramClass2))
        {
          break label182;
          localMethod = paramClass1.getMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length));
        }
        else
        {
          if (paramBoolean)
          {
            paramClass1 = paramClass1.getDeclaredMethods();
            a.f.b.j.p(paramClass1, "allMethods");
            int k = paramClass1.length;
            i = 0;
            if (i >= k) {
              continue;
            }
            localMethod = paramClass1[i];
            a.f.b.j.p(localMethod, "method");
            if ((a.f.b.j.e(localMethod.getName(), paramString)) && (a.f.b.j.e(localMethod.getReturnType(), paramClass2)))
            {
              Class[] arrayOfClass = localMethod.getParameterTypes();
              if (arrayOfClass == null) {
                a.f.b.j.ebi();
              }
              if (Arrays.equals(arrayOfClass, paramArrayOfClass))
              {
                j = 1;
                break label185;
              }
            }
          }
          else
          {
            paramClass1 = paramClass1.getMethods();
            continue;
          }
          j = 0;
          break label185;
          localMethod = null;
        }
      }
      catch (NoSuchMethodException paramClass1)
      {
        return null;
      }
      label182:
      label185:
      while (j != 0) {
        return localMethod;
      }
      i += 1;
    }
  }
  
  private final Class<?> aN(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramString.charAt(paramInt1))
    {
    case 'E': 
    case 'G': 
    case 'H': 
    case 'K': 
    case 'M': 
    case 'N': 
    case 'O': 
    case 'P': 
    case 'Q': 
    case 'R': 
    case 'T': 
    case 'U': 
    case 'W': 
    case 'X': 
    case 'Y': 
    default: 
      throw ((Throwable)new x("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    case 'L': 
      ClassLoader localClassLoader = a.j.b.a.e.b.aQ(ebg());
      if (paramString == null) {
        throw new v("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(paramInt1 + 1, paramInt2 - 1);
      a.f.b.j.p(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = localClassLoader.loadClass(m.a(paramString, '/', '.'));
      a.f.b.j.p(paramString, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
      return paramString;
    case '[': 
      return a.j.b.a.e.b.aW(aN(paramString, paramInt1 + 1, paramInt2));
    case 'V': 
      paramString = Void.TYPE;
      a.f.b.j.p(paramString, "Void.TYPE");
      return paramString;
    case 'Z': 
      return Boolean.TYPE;
    case 'C': 
      return Character.TYPE;
    case 'B': 
      return Byte.TYPE;
    case 'S': 
      return Short.TYPE;
    case 'I': 
      return Integer.TYPE;
    case 'F': 
      return Float.TYPE;
    case 'J': 
      return Long.TYPE;
    }
    return Double.TYPE;
  }
  
  private final List<Class<?>> ayt(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (paramString.charAt(i) != ')')
    {
      int j = i;
      while (paramString.charAt(j) == '[') {
        j += 1;
      }
      char c = paramString.charAt(j);
      if (m.c((CharSequence)"VZCBSIFJD", c)) {
        j += 1;
      }
      for (;;)
      {
        localArrayList.add(aN(paramString, i, j));
        i = j;
        break;
        if (c != 'L') {
          break label114;
        }
        j = m.a((CharSequence)paramString, ';', i, 4) + 1;
      }
      label114:
      throw ((Throwable)new x("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    }
    return (List)localArrayList;
  }
  
  private final Class<?> ayu(String paramString)
  {
    return aN(paramString, m.a((CharSequence)paramString, ')', 0, 6) + 1, paramString.length());
  }
  
  public final Method H(String paramString1, String paramString2, boolean paramBoolean)
  {
    a.f.b.j.q(paramString1, "name");
    a.f.b.j.q(paramString2, "desc");
    if (a.f.b.j.e(paramString1, "<init>")) {
      return null;
    }
    return a(ebB(), paramString1, ayt(paramString2), ayu(paramString2), paramBoolean);
  }
  
  public abstract ah TR(int paramInt);
  
  public abstract Collection<ah> a(f paramf);
  
  protected final Collection<e<?>> a(h paramh, i.c paramc)
  {
    a.f.b.j.q(paramh, "scope");
    a.f.b.j.q(paramc, "belonginess");
    i.g localg = new i.g(this);
    paramh = (Iterable)j.a.a(paramh, null, null, 3);
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramh.iterator();
    label149:
    while (localIterator.hasNext())
    {
      paramh = (a.j.b.a.c.b.l)localIterator.next();
      if (((paramh instanceof a.j.b.a.c.b.b)) && ((a.f.b.j.e(((a.j.b.a.c.b.b)paramh).ecE(), ay.BWR) ^ true)) && (paramc.a((a.j.b.a.c.b.b)paramh))) {}
      for (paramh = (e)paramh.a((n)localg, y.BMg);; paramh = null)
      {
        if (paramh == null) {
          break label149;
        }
        localCollection.add(paramh);
        break;
      }
    }
    return (Collection)a.a.j.m((Iterable)localCollection);
  }
  
  public abstract Collection<t> b(f paramf);
  
  final void c(List<Class<?>> paramList, String paramString, boolean paramBoolean)
  {
    paramString = ayt(paramString);
    paramList.addAll((Collection)paramString);
    int j = (paramString.size() + 32 - 1) / 32;
    int i = 0;
    while (i < j)
    {
      paramString = Integer.TYPE;
      a.f.b.j.p(paramString, "Integer.TYPE");
      paramList.add(paramString);
      i += 1;
    }
    if (paramBoolean) {}
    for (paramString = BOQ;; paramString = Object.class)
    {
      a.f.b.j.p(paramString, "if (isConstructor) DEFAU…RKER else Any::class.java");
      paramList.add(paramString);
      return;
    }
  }
  
  public final Constructor<?> cC(String paramString, boolean paramBoolean)
  {
    a.f.b.j.q(paramString, "desc");
    Class localClass = ebg();
    paramString = ayt(paramString);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return a(localClass, paramString, paramBoolean);
    }
  }
  
  public final Method d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a.f.b.j.q(paramString1, "name");
    a.f.b.j.q(paramString2, "desc");
    if (a.f.b.j.e(paramString1, "<init>")) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean1) {
      localArrayList.add(ebg());
    }
    c((List)localArrayList, paramString2, false);
    return a(ebB(), paramString1 + "$default", (List)localArrayList, ayu(paramString2), paramBoolean2);
  }
  
  protected Class<?> ebB()
  {
    Class localClass2 = a.j.b.a.e.b.aT(ebg());
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = ebg();
    }
    return localClass1;
  }
  
  public abstract Collection<a.j.b.a.c.b.k> ebq();
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflect_api", "()Lkotlin/text/Regex;", "kotlin-reflect-api"})
  public static final class a {}
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "invoke"})
  static final class b$a
    extends a.f.b.k
    implements a<a.j.b.a.b.i>
  {
    b$a(i.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.i
 * JD-Core Version:    0.7.0.1
 */