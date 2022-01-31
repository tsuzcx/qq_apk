package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "componentType", "getComponentType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReflectType", "()Ljava/lang/reflect/Type;", "descriptors.runtime"})
public final class i
  extends w
  implements f
{
  private final w CFJ;
  private final Type CFK;
  
  public i(Type paramType)
  {
    AppMethodBeat.i(123039);
    this.CFK = paramType;
    paramType = this.CFK;
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      j.p(paramType, "genericComponentType");
    }
    for (paramType = w.a.k(paramType);; paramType = w.a.k((Type)paramType))
    {
      this.CFJ = paramType;
      AppMethodBeat.o(123039);
      return;
      if ((!(paramType instanceof Class)) || (!((Class)paramType).isArray())) {
        break;
      }
      paramType = ((Class)paramType).getComponentType();
      j.p(paramType, "getComponentType()");
    }
    paramType = (Throwable)new IllegalArgumentException("Not an array type (" + this.CFK.getClass() + "): " + this.CFK);
    AppMethodBeat.o(123039);
    throw paramType;
  }
  
  protected final Type epg()
  {
    return this.CFK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.e.i
 * JD-Core Version:    0.7.0.1
 */