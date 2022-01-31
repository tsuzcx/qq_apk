package a.j.b.a.a;

import a.a.e;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class e$f$e
  extends e.f
{
  public e$f$e(Method paramMethod)
  {
    super(paramMethod, true, null, 4);
    AppMethodBeat.i(119000);
    AppMethodBeat.o(119000);
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118999);
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    du(e.N(paramArrayOfObject));
    if (paramArrayOfObject.length <= 1) {
      paramArrayOfObject = new Object[0];
    }
    Object[] arrayOfObject;
    do
    {
      paramArrayOfObject = a(null, paramArrayOfObject);
      AppMethodBeat.o(118999);
      return paramArrayOfObject;
      arrayOfObject = e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
      paramArrayOfObject = arrayOfObject;
    } while (arrayOfObject != null);
    paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
    AppMethodBeat.o(118999);
    throw paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.a.e.f.e
 * JD-Core Version:    0.7.0.1
 */