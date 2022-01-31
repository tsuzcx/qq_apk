package a.j.b.a.a;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class e$e$a
  extends e.e
  implements c
{
  private final Object BPg;
  
  public e$e$a(Field paramField, boolean paramBoolean, Object paramObject)
  {
    super(paramField, paramBoolean, false, (byte)0);
    AppMethodBeat.i(118984);
    this.BPg = paramObject;
    AppMethodBeat.o(118984);
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118983);
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    ((Field)this.BQP).set(this.BPg, a.a.e.M(paramArrayOfObject));
    paramArrayOfObject = y.BMg;
    AppMethodBeat.o(118983);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.a.e.e.a
 * JD-Core Version:    0.7.0.1
 */