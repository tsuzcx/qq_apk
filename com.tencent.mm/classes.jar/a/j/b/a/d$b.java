package a.j.b.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflect-api"})
public final class d$b
  extends d
{
  final Method BNX;
  final Method BNY;
  
  public d$b(Method paramMethod1, Method paramMethod2)
  {
    super((byte)0);
    AppMethodBeat.i(118682);
    this.BNX = paramMethod1;
    this.BNY = paramMethod2;
    AppMethodBeat.o(118682);
  }
  
  public final String mk()
  {
    AppMethodBeat.i(118681);
    String str = ae.d(this.BNX);
    AppMethodBeat.o(118681);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.d.b
 * JD-Core Version:    0.7.0.1
 */