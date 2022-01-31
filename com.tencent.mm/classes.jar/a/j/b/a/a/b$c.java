package a.j.b.a.a;

import a.a.e;
import a.f;
import a.f.b.j;
import a.j.b.a.x;
import a.j.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
final class b$c
  implements InvocationHandler
{
  b$c(Class paramClass, f paramf1, k paramk1, f paramf2, k paramk2, b.a parama, Map paramMap) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118962);
    j.p(paramMethod, "method");
    paramObject = paramMethod.getName();
    if (paramObject == null) {}
    while ((j.e(paramObject, "equals")) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
    {
      boolean bool = this.BQN.dt(e.P(paramArrayOfObject));
      AppMethodBeat.o(118962);
      return Boolean.valueOf(bool);
      switch (paramObject.hashCode())
      {
      default: 
        break;
      case -1776922004: 
        if (paramObject.equals("toString"))
        {
          paramObject = this.BQJ.getValue();
          AppMethodBeat.o(118962);
          return paramObject;
        }
        break;
      case 147696667: 
        if (paramObject.equals("hashCode"))
        {
          paramObject = this.BQL.getValue();
          AppMethodBeat.o(118962);
          return paramObject;
        }
        break;
      case 1444986633: 
        if (paramObject.equals("annotationType"))
        {
          paramObject = this.BQG;
          AppMethodBeat.o(118962);
          return paramObject;
        }
        break;
      }
    }
    if (this.BQI.containsKey(paramObject))
    {
      paramObject = this.BQI.get(paramObject);
      AppMethodBeat.o(118962);
      return paramObject;
    }
    paramMethod = new StringBuilder("Method is not supported: ").append(paramMethod).append(" (args: ");
    paramObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramObject = new Object[0];
    }
    paramObject = (Throwable)new x(e.R(paramObject) + ')');
    AppMethodBeat.o(118962);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */