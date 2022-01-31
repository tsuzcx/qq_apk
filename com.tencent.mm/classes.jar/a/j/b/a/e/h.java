package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.e;
import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "values", "", "(Lorg/jetbrains/kotlin/name/Name;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getElements", "", "descriptors.runtime"})
public final class h
  extends d
  implements e
{
  private final Object[] afB;
  
  public h(f paramf, Object[] paramArrayOfObject)
  {
    super(paramf);
    AppMethodBeat.i(123038);
    this.afB = paramArrayOfObject;
    AppMethodBeat.o(123038);
  }
  
  public final List<d> egc()
  {
    AppMethodBeat.i(123037);
    Object localObject1 = this.afB;
    Collection localCollection = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 == null) {
        j.ebi();
      }
      localCollection.add(d.a.a(localObject2, null));
      i += 1;
    }
    localObject1 = (List)localCollection;
    AppMethodBeat.o(123037);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.e.h
 * JD-Core Version:    0.7.0.1
 */