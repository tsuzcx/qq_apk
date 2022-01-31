package a.j.b.a.b;

import a.f.b.j;
import a.j.b.a.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/SignatureSerializer;", "", "()V", "constructorDesc", "", "constructor", "Ljava/lang/reflect/Constructor;", "fieldDesc", "field", "Ljava/lang/reflect/Field;", "methodDesc", "method", "Ljava/lang/reflect/Method;", "descriptors.runtime"})
final class l
{
  public static final l BRu;
  
  static
  {
    AppMethodBeat.i(119065);
    BRu = new l();
    AppMethodBeat.o(119065);
  }
  
  public static String a(Constructor<?> paramConstructor)
  {
    AppMethodBeat.i(119063);
    j.q(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      j.p(localObject, "parameterType");
      localStringBuilder.append(b.aV(localObject));
      i += 1;
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    j.p(paramConstructor, "sb.toString()");
    AppMethodBeat.o(119063);
    return paramConstructor;
  }
  
  public static String e(Field paramField)
  {
    AppMethodBeat.i(119064);
    j.q(paramField, "field");
    paramField = paramField.getType();
    j.p(paramField, "field.type");
    paramField = b.aV(paramField);
    AppMethodBeat.o(119064);
    return paramField;
  }
  
  public static String e(Method paramMethod)
  {
    AppMethodBeat.i(119062);
    j.q(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      j.p(localClass, "parameterType");
      localStringBuilder.append(b.aV(localClass));
      i += 1;
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    j.p(paramMethod, "method.returnType");
    localStringBuilder.append(b.aV(paramMethod));
    paramMethod = localStringBuilder.toString();
    j.p(paramMethod, "sb.toString()");
    AppMethodBeat.o(119062);
    return paramMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.b.l
 * JD-Core Version:    0.7.0.1
 */