package a.j.b.a.b;

import a.f.b.j;
import a.j.b.a.c.b.am;
import a.j.b.a.c.d.b.n;
import a.j.b.a.c.d.b.n.a;
import a.j.b.a.c.d.b.n.c;
import a.j.b.a.c.d.b.n.e;
import a.j.b.a.c.d.b.n.f;
import a.j.b.a.c.f.f;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "klass", "Ljava/lang/Class;", "classHeader", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/header/KotlinClassHeader;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;)V", "getClassHeader", "()Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "getKlass", "()Ljava/lang/Class;", "location", "", "getLocation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "loadClassAnnotations", "", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "cachedContents", "", "toString", "visitMembers", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "Factory", "descriptors.runtime"})
public final class e
  implements n
{
  public static final e.a BRi;
  public final Class<?> BRg;
  public final a.j.b.a.c.d.b.a.a BRh;
  
  static
  {
    AppMethodBeat.i(119040);
    BRi = new e.a((byte)0);
    AppMethodBeat.o(119040);
  }
  
  private e(Class<?> paramClass, a.j.b.a.c.d.b.a.a parama)
  {
    this.BRg = paramClass;
    this.BRh = parama;
  }
  
  public final void a(n.c paramc)
  {
    AppMethodBeat.i(119035);
    j.q(paramc, "visitor");
    b localb = b.BRe;
    b.a(this.BRg, paramc);
    AppMethodBeat.o(119035);
  }
  
  public final void a(n.e parame)
  {
    AppMethodBeat.i(119036);
    j.q(parame, "visitor");
    Object localObject1 = b.BRe;
    localObject1 = this.BRg;
    j.q(localObject1, "klass");
    j.q(parame, "memberVisitor");
    Object localObject2 = ((Class)localObject1).getDeclaredMethods();
    int m = localObject2.length;
    int i = 0;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    int j;
    Object localObject6;
    Object localObject7;
    int n;
    int i1;
    Object localObject8;
    while (i < m)
    {
      localObject4 = localObject2[i];
      j.p(localObject4, "method");
      localObject3 = f.ayT(((Method)localObject4).getName());
      j.p(localObject3, "Name.identifier(method.name)");
      localObject5 = l.BRu;
      localObject3 = parame.a((f)localObject3, l.e((Method)localObject4));
      localObject5 = ((Method)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (n.c)localObject3;
        j.p(localObject6, "annotation");
        b.a((n.c)localObject7, localObject6);
        j += 1;
      }
      localObject4 = ((Method)localObject4).getParameterAnnotations();
      j.p(localObject4, "method.parameterAnnotations");
      n = localObject4.length;
      j = 0;
      while (j < n)
      {
        localObject5 = localObject4[j];
        i1 = localObject5.length;
        k = 0;
        while (k < i1)
        {
          localObject6 = localObject5[k];
          localObject7 = a.f.a.a(a.f.a.a(localObject6));
          localObject8 = a.j.b.a.e.b.aU((Class)localObject7);
          j.p(localObject6, "annotation");
          localObject8 = ((n.f)localObject3).a(j, (a.j.b.a.c.f.a)localObject8, (am)new a(localObject6));
          if (localObject8 != null) {
            b.BRe.a((n.a)localObject8, localObject6, (Class)localObject7);
          }
          k += 1;
        }
        j += 1;
      }
      ((n.f)localObject3).zi();
      i += 1;
    }
    localObject2 = ((Class)localObject1).getDeclaredConstructors();
    m = localObject2.length;
    i = 0;
    while (i < m)
    {
      localObject4 = localObject2[i];
      localObject3 = f.ayV("<init>");
      j.p(localObject3, "Name.special(\"<init>\")");
      localObject5 = l.BRu;
      j.p(localObject4, "constructor");
      localObject3 = parame.a((f)localObject3, l.a((Constructor)localObject4));
      localObject5 = ((Constructor)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (n.c)localObject3;
        j.p(localObject6, "annotation");
        b.a((n.c)localObject7, localObject6);
        j += 1;
      }
      localObject5 = ((Constructor)localObject4).getParameterAnnotations();
      j.p(localObject5, "parameterAnnotations");
      label461:
      int i2;
      if (((Object[])localObject5).length == 0)
      {
        j = 1;
        if (j != 0) {
          break label607;
        }
        j = 1;
        if (j == 0) {
          break label619;
        }
        n = ((Constructor)localObject4).getParameterTypes().length;
        i1 = ((Object[])localObject5).length;
        i2 = localObject5.length;
        j = 0;
      }
      for (;;)
      {
        if (j >= i2) {
          break label619;
        }
        localObject4 = localObject5[j];
        int i3 = localObject4.length;
        k = 0;
        for (;;)
        {
          if (k < i3)
          {
            localObject6 = localObject4[k];
            localObject7 = a.f.a.a(a.f.a.a(localObject6));
            localObject8 = a.j.b.a.e.b.aU((Class)localObject7);
            j.p(localObject6, "annotation");
            localObject8 = ((n.f)localObject3).a(j + (n - i1), (a.j.b.a.c.f.a)localObject8, (am)new a(localObject6));
            if (localObject8 != null) {
              b.BRe.a((n.a)localObject8, localObject6, (Class)localObject7);
            }
            k += 1;
            continue;
            j = 0;
            break;
            label607:
            j = 0;
            break label461;
          }
        }
        j += 1;
      }
      label619:
      ((n.f)localObject3).zi();
      i += 1;
    }
    localObject1 = ((Class)localObject1).getDeclaredFields();
    int k = localObject1.length;
    i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      j.p(localObject2, "field");
      localObject3 = f.ayT(((Field)localObject2).getName());
      j.p(localObject3, "Name.identifier(field.name)");
      localObject4 = l.BRu;
      localObject3 = parame.b((f)localObject3, l.e((Field)localObject2));
      localObject2 = ((Field)localObject2).getDeclaredAnnotations();
      m = localObject2.length;
      j = 0;
      while (j < m)
      {
        localObject4 = localObject2[j];
        j.p(localObject4, "annotation");
        b.a((n.c)localObject3, (Annotation)localObject4);
        j += 1;
      }
      ((n.c)localObject3).zi();
      i += 1;
    }
    AppMethodBeat.o(119036);
  }
  
  public final a.j.b.a.c.d.b.a.a ebZ()
  {
    return this.BRh;
  }
  
  public final a.j.b.a.c.f.a ebx()
  {
    AppMethodBeat.i(119034);
    a.j.b.a.c.f.a locala = a.j.b.a.e.b.aU(this.BRg);
    AppMethodBeat.o(119034);
    return locala;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119037);
    if (((paramObject instanceof e)) && (j.e(this.BRg, ((e)paramObject).BRg)))
    {
      AppMethodBeat.o(119037);
      return true;
    }
    AppMethodBeat.o(119037);
    return false;
  }
  
  public final String getLocation()
  {
    AppMethodBeat.i(119033);
    Object localObject = new StringBuilder();
    String str = this.BRg.getName();
    j.p(str, "klass.name");
    localObject = m.a(str, '.', '/') + ".class";
    AppMethodBeat.o(119033);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(119038);
    int i = this.BRg.hashCode();
    AppMethodBeat.o(119038);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119039);
    String str = getClass().getName() + ": " + this.BRg;
    AppMethodBeat.o(119039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */