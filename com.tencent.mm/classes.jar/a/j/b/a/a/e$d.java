package a.j.b.a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflect-api"})
public abstract class e$d
  extends e<Field>
{
  private e$d(Field paramField, boolean paramBoolean) {}
  
  public Object X(Object[] paramArrayOfObject)
  {
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    Field localField = (Field)this.BQP;
    if (this.BQR != null) {}
    for (paramArrayOfObject = a.a.e.M(paramArrayOfObject);; paramArrayOfObject = null) {
      return localField.get(paramArrayOfObject);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
  public static final class b
    extends e.d
    implements c
  {
    public b(Field paramField)
    {
      super(false, (byte)0);
      AppMethodBeat.i(118978);
      AppMethodBeat.o(118978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.a.e.d
 * JD-Core Version:    0.7.0.1
 */