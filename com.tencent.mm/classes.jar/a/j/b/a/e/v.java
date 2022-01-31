package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.a.h;
import a.j.b.a.c.d.a.e.u;
import a.j.b.a.c.i.d.c;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPrimitiveType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPrimitiveType;", "reflectType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getReflectType", "()Ljava/lang/Class;", "type", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getType", "()Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "descriptors.runtime"})
public final class v
  extends w
  implements u
{
  private final Class<?> CFY;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(123115);
    this.CFY = paramClass;
    AppMethodBeat.o(123115);
  }
  
  public final h egz()
  {
    AppMethodBeat.i(123114);
    if (j.e(this.CFY, Void.TYPE))
    {
      AppMethodBeat.o(123114);
      return null;
    }
    Object localObject = c.azg(this.CFY.getName());
    j.p(localObject, "JvmPrimitiveType.get(reflectType.name)");
    localObject = ((c)localObject).Cxf;
    AppMethodBeat.o(123114);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.e.v
 * JD-Core Version:    0.7.0.1
 */