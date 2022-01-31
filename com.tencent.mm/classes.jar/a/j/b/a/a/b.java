package a.j.b.a.a;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.r;
import a.g;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflect-api", "hashCode", "toString"})
public final class b
{
  static
  {
    AppMethodBeat.i(118966);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new r(a.f.b.v.i(b.class, "kotlin-reflect-api"), "hashCode", "<v#0>")), (a.j.k)a.f.b.v.a(new r(a.f.b.v.i(b.class, "kotlin-reflect-api"), "toString", "<v#1>")) };
    AppMethodBeat.o(118966);
  }
  
  public static final <T> T a(Class<T> paramClass, final Map<String, ? extends Object> paramMap, List<Method> paramList)
  {
    AppMethodBeat.i(118967);
    j.q(paramClass, "annotationClass");
    j.q(paramMap, "values");
    j.q(paramList, "methods");
    b.a locala = new b.a(paramClass, paramList, paramMap);
    f localf1 = g.j((a)new b.b(paramMap));
    a.j.k localk1 = eOJ[0];
    f localf2 = g.j((a)new d(paramClass, paramMap));
    a.j.k localk2 = eOJ[1];
    paramList = paramClass.getClassLoader();
    paramMap = (InvocationHandler)new b.c(paramClass, localf2, localk2, localf1, localk1, locala, paramMap);
    paramClass = Proxy.newProxyInstance(paramList, new Class[] { paramClass }, paramMap);
    if (paramClass == null)
    {
      paramClass = new a.v("null cannot be cast to non-null type T");
      AppMethodBeat.o(118967);
      throw paramClass;
    }
    AppMethodBeat.o(118967);
    return paramClass;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "", "invoke"})
  static final class d
    extends a.f.b.k
    implements a<String>
  {
    d(Class paramClass, Map paramMap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */