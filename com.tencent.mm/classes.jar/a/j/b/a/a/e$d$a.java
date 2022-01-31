package a.j.b.a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
public final class e$d$a
  extends e.d
  implements c
{
  private final Object BPg;
  
  public e$d$a(Field paramField, Object paramObject)
  {
    super(paramField, false, (byte)0);
    AppMethodBeat.i(118977);
    this.BPg = paramObject;
    AppMethodBeat.o(118977);
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118976);
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    paramArrayOfObject = ((Field)this.BQP).get(this.BPg);
    AppMethodBeat.o(118976);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.a.e.d.a
 * JD-Core Version:    0.7.0.1
 */