package a.j.b.a.a;

import a.f.b.j;
import a.l;
import a.y;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflect-api"})
public abstract class e$e
  extends e<Field>
{
  private final boolean BQT;
  
  private e$e(Field paramField, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public Object X(Object[] paramArrayOfObject)
  {
    j.q(paramArrayOfObject, "args");
    Y(paramArrayOfObject);
    Field localField = (Field)this.BQP;
    if (this.BQR != null) {}
    for (Object localObject = a.a.e.M(paramArrayOfObject);; localObject = null)
    {
      localField.set(localObject, a.a.e.O(paramArrayOfObject));
      return y.BMg;
    }
  }
  
  public void Y(Object[] paramArrayOfObject)
  {
    j.q(paramArrayOfObject, "args");
    super.Y(paramArrayOfObject);
    if ((this.BQT) && (a.a.e.O(paramArrayOfObject) == null)) {
      throw ((Throwable)new IllegalArgumentException("null is not allowed as a value for this property."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.a.e.e
 * JD-Core Version:    0.7.0.1
 */