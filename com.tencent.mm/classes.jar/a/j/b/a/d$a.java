package a.j.b.a;

import a.f.b.j;
import a.j.b.a.c.d.a.o;
import a.j.b.a.e.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflect-api"})
public final class d$a
  extends d
{
  final Field erN;
  
  public d$a(Field paramField)
  {
    super((byte)0);
    AppMethodBeat.i(118680);
    this.erN = paramField;
    AppMethodBeat.o(118680);
  }
  
  public final String mk()
  {
    AppMethodBeat.i(118679);
    Object localObject = new StringBuilder().append(o.ayF(this.erN.getName())).append("()");
    Class localClass = this.erN.getType();
    j.p(localClass, "field.type");
    localObject = b.aV(localClass);
    AppMethodBeat.o(118679);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */