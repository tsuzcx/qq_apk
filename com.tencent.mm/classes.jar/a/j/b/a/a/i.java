package a.j.b.a.a;

import a.a.v;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class i
  implements d
{
  public static final i BRc;
  
  static
  {
    AppMethodBeat.i(119018);
    BRc = new i();
    AppMethodBeat.o(119018);
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(119017);
    j.q(paramArrayOfObject, "args");
    paramArrayOfObject = (Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    AppMethodBeat.o(119017);
    throw paramArrayOfObject;
  }
  
  public final Type ebW()
  {
    AppMethodBeat.i(119016);
    Object localObject = Void.TYPE;
    j.p(localObject, "Void.TYPE");
    localObject = (Type)localObject;
    AppMethodBeat.o(119016);
    return localObject;
  }
  
  public final List<Type> ebX()
  {
    return (List)v.BMx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */