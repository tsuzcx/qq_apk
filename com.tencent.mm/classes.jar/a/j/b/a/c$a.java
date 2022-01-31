package a.j.b.a;

import a.a.e;
import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflect-api"})
public final class c$a
  extends c
{
  final List<Method> BNR;
  private final Class<?> BNl;
  
  public c$a(Class<?> paramClass)
  {
    super((byte)0);
    AppMethodBeat.i(118670);
    this.BNl = paramClass;
    paramClass = this.BNl.getDeclaredMethods();
    a.f.b.j.p(paramClass, "jClass.declaredMethods");
    Comparator localComparator = (Comparator)new c.a.a();
    a.f.b.j.q(paramClass, "receiver$0");
    a.f.b.j.q(localComparator, "comparator");
    a.f.b.j.q(paramClass, "receiver$0");
    a.f.b.j.q(localComparator, "comparator");
    if (paramClass.length == 0) {
      i = 1;
    }
    if (i != 0) {}
    for (;;)
    {
      this.BNR = e.asList(paramClass);
      AppMethodBeat.o(118670);
      return;
      paramClass = Arrays.copyOf(paramClass, paramClass.length);
      a.f.b.j.p(paramClass, "java.util.Arrays.copyOf(this, size)");
      e.a(paramClass, localComparator);
    }
  }
  
  public final String mk()
  {
    AppMethodBeat.i(118669);
    String str = a.a.j.a((Iterable)this.BNR, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)c.a.b.BNS, 24);
    AppMethodBeat.o(118669);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */