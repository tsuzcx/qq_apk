package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "value", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "descriptors.runtime"})
public final class d$a
{
  public static d a(Object paramObject, f paramf)
  {
    AppMethodBeat.i(123030);
    j.q(paramObject, "value");
    if (b.aR(paramObject.getClass()))
    {
      paramObject = (d)new o(paramf, (Enum)paramObject);
      AppMethodBeat.o(123030);
      return paramObject;
    }
    if ((paramObject instanceof Annotation))
    {
      paramObject = (d)new e(paramf, (Annotation)paramObject);
      AppMethodBeat.o(123030);
      return paramObject;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (d)new h(paramf, (Object[])paramObject);
      AppMethodBeat.o(123030);
      return paramObject;
    }
    if ((paramObject instanceof Class))
    {
      paramObject = (d)new k(paramf, (Class)paramObject);
      AppMethodBeat.o(123030);
      return paramObject;
    }
    paramObject = (d)new q(paramf, paramObject);
    AppMethodBeat.o(123030);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.e.d.a
 * JD-Core Version:    0.7.0.1
 */