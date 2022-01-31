package a.j.b.a.e;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "type", "Ljava/lang/reflect/Type;", "descriptors.runtime"})
public final class w$a
{
  public static w k(Type paramType)
  {
    AppMethodBeat.i(123116);
    j.q(paramType, "type");
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
    {
      paramType = (w)new v((Class)paramType);
      AppMethodBeat.o(123116);
      return paramType;
    }
    if (((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray())))
    {
      paramType = (w)new i(paramType);
      AppMethodBeat.o(123116);
      return paramType;
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (w)new z((WildcardType)paramType);
      AppMethodBeat.o(123116);
      return paramType;
    }
    paramType = (w)new l(paramType);
    AppMethodBeat.o(123116);
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.e.w.a
 * JD-Core Version:    0.7.0.1
 */