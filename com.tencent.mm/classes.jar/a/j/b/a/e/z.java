package a.j.b.a.e;

import a.a.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaWildcardType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaWildcardType;", "reflectType", "Ljava/lang/reflect/WildcardType;", "(Ljava/lang/reflect/WildcardType;)V", "bound", "getBound", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "isExtends", "", "()Z", "getReflectType", "()Ljava/lang/reflect/WildcardType;", "descriptors.runtime"})
public final class z
  extends w
  implements a.j.b.a.c.d.a.e.z
{
  private final WildcardType CGf;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(123132);
    this.CGf = paramWildcardType;
    AppMethodBeat.o(123132);
  }
  
  public final boolean egD()
  {
    AppMethodBeat.i(123131);
    Type[] arrayOfType = this.CGf.getUpperBounds();
    j.p(arrayOfType, "reflectType.upperBounds");
    boolean bool = j.e((Type)e.N(arrayOfType), Object.class);
    AppMethodBeat.o(123131);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.e.z
 * JD-Core Version:    0.7.0.1
 */