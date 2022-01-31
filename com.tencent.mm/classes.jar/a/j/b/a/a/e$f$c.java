package a.j.b.a.a;

import a.f.b.j;
import a.f.b.x;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class e$f$c
  extends e.f
  implements c
{
  private final Object BPg;
  
  public e$f$c(Method paramMethod, Object paramObject) {}
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118995);
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    x localx = new x(2);
    localx.add(this.BPg);
    localx.dh(paramArrayOfObject);
    paramArrayOfObject = a(null, localx.toArray(new Object[localx.ceo.size()]));
    AppMethodBeat.o(118995);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.a.e.f.c
 * JD-Core Version:    0.7.0.1
 */