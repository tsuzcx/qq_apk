package a.j.b.a.b;

import a.a.e;
import a.f.b.j;
import a.j.b.a.c.a.h;
import a.j.b.a.c.b.am;
import a.j.b.a.c.d.b.n.a;
import a.j.b.a.c.d.b.n.b;
import a.j.b.a.c.d.b.n.c;
import a.j.b.a.c.d.b.n.d;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.d.c;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/ReflectClassStructure;", "", "()V", "loadClassAnnotations", "", "klass", "Ljava/lang/Class;", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "loadConstructorAnnotations", "memberVisitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "loadFieldAnnotations", "loadMethodAnnotations", "processAnnotation", "annotation", "", "processAnnotationArgumentValue", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationArgumentVisitor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "processAnnotationArguments", "annotationType", "visitMembers", "classLiteralId", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$ClassLiteralId;", "descriptors.runtime"})
final class b
{
  public static final b BRe;
  
  static
  {
    AppMethodBeat.i(119026);
    BRe = new b();
    AppMethodBeat.o(119026);
  }
  
  private final void a(n.a parama, f paramf, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(119025);
    Object localObject = paramObject.getClass();
    if (j.e(localObject, Class.class))
    {
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type java.lang.Class<*>");
        AppMethodBeat.o(119025);
        throw parama;
      }
      parama.a(paramf, aN((Class)paramObject));
      AppMethodBeat.o(119025);
      return;
    }
    if (g.eca().contains(localObject))
    {
      parama.a(paramf, paramObject);
      AppMethodBeat.o(119025);
      return;
    }
    if (a.j.b.a.e.b.aR((Class)localObject))
    {
      if (((Class)localObject).isEnum()) {}
      for (;;)
      {
        j.p(localObject, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
        localObject = a.j.b.a.e.b.aU((Class)localObject);
        if (paramObject != null) {
          break;
        }
        parama = new v("null cannot be cast to non-null type kotlin.Enum<*>");
        AppMethodBeat.o(119025);
        throw parama;
        localObject = ((Class)localObject).getEnclosingClass();
      }
      paramObject = f.ayT(((Enum)paramObject).name());
      j.p(paramObject, "Name.identifier((value as Enum<*>).name)");
      parama.a(paramf, (a.j.b.a.c.f.a)localObject, paramObject);
      AppMethodBeat.o(119025);
      return;
    }
    if (Annotation.class.isAssignableFrom((Class)localObject))
    {
      localObject = ((Class)localObject).getInterfaces();
      j.p(localObject, "clazz.interfaces");
      localObject = (Class)e.P((Object[])localObject);
      j.p(localObject, "annotationClass");
      parama = parama.a(paramf, a.j.b.a.e.b.aU((Class)localObject));
      if (parama == null)
      {
        AppMethodBeat.o(119025);
        return;
      }
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.Annotation");
        AppMethodBeat.o(119025);
        throw parama;
      }
      a(parama, (Annotation)paramObject, (Class)localObject);
      AppMethodBeat.o(119025);
      return;
    }
    if (((Class)localObject).isArray())
    {
      parama = parama.o(paramf);
      if (parama == null)
      {
        AppMethodBeat.o(119025);
        return;
      }
      paramf = ((Class)localObject).getComponentType();
      j.p(paramf, "componentType");
      if (paramf.isEnum())
      {
        paramf = a.j.b.a.e.b.aU(paramf);
        if (paramObject == null)
        {
          parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
          AppMethodBeat.o(119025);
          throw parama;
        }
        paramObject = (Object[])paramObject;
        j = paramObject.length;
        i = 0;
        while (i < j)
        {
          localObject = paramObject[i];
          if (localObject == null)
          {
            parama = new v("null cannot be cast to non-null type kotlin.Enum<*>");
            AppMethodBeat.o(119025);
            throw parama;
          }
          localObject = f.ayT(((Enum)localObject).name());
          j.p(localObject, "Name.identifier((element as Enum<*>).name)");
          parama.a(paramf, (f)localObject);
          i += 1;
        }
      }
      if (j.e(paramf, Class.class))
      {
        if (paramObject == null)
        {
          parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
          AppMethodBeat.o(119025);
          throw parama;
        }
        paramf = (Object[])paramObject;
        j = paramf.length;
        i = 0;
        while (i < j)
        {
          paramObject = paramf[i];
          if (paramObject == null)
          {
            parama = new v("null cannot be cast to non-null type java.lang.Class<*>");
            AppMethodBeat.o(119025);
            throw parama;
          }
          parama.a(aN((Class)paramObject));
          i += 1;
        }
      }
      if (paramObject == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.Array<*>");
        AppMethodBeat.o(119025);
        throw parama;
      }
      paramf = (Object[])paramObject;
      int j = paramf.length;
      while (i < j)
      {
        parama.dB(paramf[i]);
        i += 1;
      }
      parama.zi();
      AppMethodBeat.o(119025);
      return;
    }
    parama = (Throwable)new UnsupportedOperationException("Unsupported annotation argument value (" + localObject + "): " + paramObject);
    AppMethodBeat.o(119025);
    throw parama;
  }
  
  static void a(n.c paramc, Annotation paramAnnotation)
  {
    AppMethodBeat.i(119022);
    Class localClass = a.f.a.a(a.f.a.a(paramAnnotation));
    paramc = paramc.a(a.j.b.a.e.b.aU(localClass), (am)new a(paramAnnotation));
    if (paramc != null)
    {
      BRe.a(paramc, paramAnnotation, localClass);
      AppMethodBeat.o(119022);
      return;
    }
    AppMethodBeat.o(119022);
  }
  
  public static void a(Class<?> paramClass, n.c paramc)
  {
    AppMethodBeat.i(119021);
    j.q(paramClass, "klass");
    j.q(paramc, "visitor");
    paramClass = paramClass.getDeclaredAnnotations();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      j.p(localObject, "annotation");
      a(paramc, localObject);
      i += 1;
    }
    paramc.zi();
    AppMethodBeat.o(119021);
  }
  
  private static n.d aN(Class<?> paramClass)
  {
    AppMethodBeat.i(119024);
    int i = 0;
    while (paramClass.isArray())
    {
      i += 1;
      paramClass = paramClass.getComponentType();
      j.p(paramClass, "currentClass.componentType");
    }
    if (!paramClass.isPrimitive())
    {
      paramClass = a.j.b.a.e.b.aU(paramClass);
      paramClass = new n.d(paramClass, i);
      AppMethodBeat.o(119024);
      return paramClass;
    }
    paramClass = c.azg(paramClass.getName());
    j.p(paramClass, "JvmPrimitiveType.get(currentClass.name)");
    paramClass = paramClass.Cxf;
    j.p(paramClass, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
    if (paramClass.BTP != null) {}
    for (paramClass = paramClass.BTP;; paramClass = paramClass.BTP)
    {
      paramClass = a.j.b.a.c.f.a.n(paramClass);
      j.p(paramClass, "ClassId.topLevel(JvmPrim…primitiveType.typeFqName)");
      break;
      paramClass.BTP = a.j.b.a.c.a.g.BRJ.q(paramClass.BTN);
    }
  }
  
  final void a(n.a parama, Annotation paramAnnotation, Class<?> paramClass)
  {
    int i = 0;
    AppMethodBeat.i(119023);
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    while (i < j)
    {
      Object localObject2 = paramClass[i];
      try
      {
        Object localObject1 = ((Method)localObject2).invoke(paramAnnotation, new Object[0]);
        if (localObject1 == null) {
          j.ebi();
        }
        j.p(localObject2, "method");
        localObject2 = f.ayT(((Method)localObject2).getName());
        j.p(localObject2, "Name.identifier(method.name)");
        a(parama, (f)localObject2, localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label86:
        break label86;
      }
      i += 1;
    }
    parama.zi();
    AppMethodBeat.o(119023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */