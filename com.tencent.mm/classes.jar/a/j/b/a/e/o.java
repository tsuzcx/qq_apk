package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.m;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaEnumValueAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaEnumValueAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/Enum;)V", "entryName", "getEntryName", "()Lorg/jetbrains/kotlin/name/Name;", "enumClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getEnumClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "descriptors.runtime"})
public final class o
  extends d
  implements m
{
  private final Enum<?> CFV;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(123094);
    this.CFV = paramEnum;
    AppMethodBeat.o(123094);
  }
  
  public final a egp()
  {
    AppMethodBeat.i(123092);
    Object localObject = this.CFV.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      j.p(localObject, "enumClass");
      localObject = b.aU((Class)localObject);
      AppMethodBeat.o(123092);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f egq()
  {
    AppMethodBeat.i(123093);
    f localf = f.ayT(this.CFV.name());
    AppMethodBeat.o(123093);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.e.o
 * JD-Core Version:    0.7.0.1
 */