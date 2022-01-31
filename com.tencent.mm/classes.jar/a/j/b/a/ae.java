package a.j.b.a;

import a.a.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflect-api"})
public final class ae
{
  static final String d(Method paramMethod)
  {
    AppMethodBeat.i(118933);
    StringBuilder localStringBuilder = new StringBuilder().append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    j.p(arrayOfClass, "parameterTypes");
    localStringBuilder = localStringBuilder.append(e.a(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (a.f.a.b)ae.a.BQr, 24));
    paramMethod = paramMethod.getReturnType();
    j.p(paramMethod, "returnType");
    paramMethod = a.j.b.a.e.b.aV(paramMethod);
    AppMethodBeat.o(118933);
    return paramMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.ae
 * JD-Core Version:    0.7.0.1
 */