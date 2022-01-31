package a.j.b.a.a;

import a.a.e;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class e$f$d
  extends e.f
{
  public e$f$d(Method paramMethod)
  {
    super(paramMethod, false, null, 6);
    AppMethodBeat.i(118998);
    AppMethodBeat.o(118998);
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118997);
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    Object localObject = paramArrayOfObject[0];
    if (paramArrayOfObject.length <= 1) {
      paramArrayOfObject = new Object[0];
    }
    Object[] arrayOfObject;
    do
    {
      paramArrayOfObject = a(localObject, paramArrayOfObject);
      AppMethodBeat.o(118997);
      return paramArrayOfObject;
      arrayOfObject = e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
      paramArrayOfObject = arrayOfObject;
    } while (arrayOfObject != null);
    paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
    AppMethodBeat.o(118997);
    throw paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.a.e.f.d
 * JD-Core Version:    0.7.0.1
 */