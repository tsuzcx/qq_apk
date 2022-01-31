package a.j.b.a;

import a.a.e;
import a.f.a.b;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflect-api"})
public final class c$b
  extends c
{
  final Constructor<?> BNT;
  
  public c$b(Constructor<?> paramConstructor)
  {
    super((byte)0);
    AppMethodBeat.i(118674);
    this.BNT = paramConstructor;
    AppMethodBeat.o(118674);
  }
  
  public final String mk()
  {
    AppMethodBeat.i(118673);
    Object localObject = this.BNT.getParameterTypes();
    j.p(localObject, "constructor.parameterTypes");
    localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)c.b.a.BNU, 24);
    AppMethodBeat.o(118673);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */