package a.j.b.a;

import a.j.b.a.c.a.h;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ai;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.d.a.b.e;
import a.j.b.a.c.d.a.o;
import a.j.b.a.c.d.b.r;
import a.j.b.a.c.e.a.e;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.b.a.f.b;
import a.j.b.a.c.e.b.b.e;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.j.b.a.c.j.a.a.i;
import a.j.b.a.e.m;
import a.j.b.a.e.p;
import a.j.b.a.e.s;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflect-api"})
public final class ad
{
  static final a.j.b.a.c.f.a BQp;
  public static final ad BQq;
  
  static
  {
    AppMethodBeat.i(118930);
    BQq = new ad();
    a.j.b.a.c.f.a locala = a.j.b.a.c.f.a.n(new a.j.b.a.c.f.b("java.lang.Void"));
    a.f.b.j.p(locala, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    BQp = locala;
    AppMethodBeat.o(118930);
  }
  
  static h aK(Class<?> paramClass)
  {
    AppMethodBeat.i(118929);
    if (paramClass.isPrimitive())
    {
      paramClass = a.j.b.a.c.i.d.c.azg(paramClass.getSimpleName());
      a.f.b.j.p(paramClass, "JvmPrimitiveType.get(simpleName)");
      paramClass = paramClass.Cxf;
      AppMethodBeat.o(118929);
      return paramClass;
    }
    AppMethodBeat.o(118929);
    return null;
  }
  
  private static String b(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(118928);
    String str = a.j.b.a.c.d.a.t.q(paramb);
    Object localObject = str;
    if (str == null)
    {
      if (!(paramb instanceof ai)) {
        break label54;
      }
      paramb = o.ayF(a.j.b.a.c.i.c.a.x(paramb).edF().name);
    }
    for (;;)
    {
      a.f.b.j.p(paramb, "when (descriptor) {\n    …name.asString()\n        }");
      localObject = paramb;
      AppMethodBeat.o(118928);
      return localObject;
      label54:
      if ((paramb instanceof aj)) {
        paramb = o.ayG(a.j.b.a.c.i.c.a.x(paramb).edF().name);
      } else {
        paramb = paramb.edF().name;
      }
    }
  }
  
  public static c c(a.j.b.a.c.b.t paramt)
  {
    AppMethodBeat.i(118925);
    a.f.b.j.q(paramt, "possiblySubstitutedFunction");
    paramt = a.j.b.a.c.i.d.u((a.j.b.a.c.b.b)paramt);
    a.f.b.j.p(paramt, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    a.j.b.a.c.b.t localt = ((a.j.b.a.c.b.t)paramt).edO();
    a.f.b.j.p(localt, "DescriptorUtils.unwrapFa…titutedFunction).original");
    Object localObject;
    if ((localt instanceof a.j.b.a.c.j.a.a.b))
    {
      paramt = ((a.j.b.a.c.j.a.a.b)localt).eos();
      if ((paramt instanceof a.o))
      {
        localObject = a.j.b.a.c.e.b.a.j.Cqr;
        localObject = a.j.b.a.c.e.b.a.j.a((a.o)paramt, ((a.j.b.a.c.j.a.a.b)localt).eot(), ((a.j.b.a.c.j.a.a.b)localt).eou());
        if (localObject != null)
        {
          paramt = (c)new c.e((f.b)localObject);
          AppMethodBeat.o(118925);
          return paramt;
        }
      }
      if ((paramt instanceof a.e))
      {
        localObject = a.j.b.a.c.e.b.a.j.Cqr;
        paramt = a.j.b.a.c.e.b.a.j.a((a.e)paramt, ((a.j.b.a.c.j.a.a.b)localt).eot(), ((a.j.b.a.c.j.a.a.b)localt).eou());
        if (paramt != null)
        {
          paramt = (c)new c.d(paramt);
          AppMethodBeat.o(118925);
          return paramt;
        }
      }
      paramt = (c)d(localt);
      AppMethodBeat.o(118925);
      return paramt;
    }
    if ((localt instanceof e))
    {
      localObject = ((e)localt).ecN();
      paramt = (a.j.b.a.c.b.t)localObject;
      if (!(localObject instanceof a.j.b.a.c.d.a.d.a)) {
        paramt = null;
      }
      paramt = (a.j.b.a.c.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.ecb();; paramt = null)
      {
        localObject = paramt;
        if (!(paramt instanceof s)) {
          localObject = null;
        }
        paramt = (s)localObject;
        if (paramt != null)
        {
          paramt = paramt.CFX;
          if (paramt != null) {
            break;
          }
        }
        paramt = (Throwable)new x("Incorrect resolution sequence for Java method ".concat(String.valueOf(localt)));
        AppMethodBeat.o(118925);
        throw paramt;
      }
      paramt = (c)new c.c(paramt);
      AppMethodBeat.o(118925);
      return paramt;
    }
    if ((localt instanceof a.j.b.a.c.d.a.b.c))
    {
      localObject = ((a.j.b.a.c.d.a.b.c)localt).ecN();
      paramt = (a.j.b.a.c.b.t)localObject;
      if (!(localObject instanceof a.j.b.a.c.d.a.d.a)) {
        paramt = null;
      }
      paramt = (a.j.b.a.c.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.ecb(); (paramt instanceof m); paramt = null)
      {
        paramt = (c)new c.b(((m)paramt).CFU);
        AppMethodBeat.o(118925);
        return paramt;
      }
      if (((paramt instanceof a.j.b.a.e.j)) && (((a.j.b.a.e.j)paramt).BRg.isAnnotation()))
      {
        paramt = (c)new c.a(((a.j.b.a.e.j)paramt).BRg);
        AppMethodBeat.o(118925);
        return paramt;
      }
      paramt = (Throwable)new x("Incorrect resolution sequence for Java constructor " + localt + " (" + paramt + ')');
      AppMethodBeat.o(118925);
      throw paramt;
    }
    if ((localt.edF().equals(a.j.b.a.c.i.d.CvG)) && (a.j.b.a.c.i.c.g(localt)))
    {
      i = 1;
      if (i == 0) {
        if ((!localt.edF().equals(a.j.b.a.c.i.d.CvF)) || (!a.j.b.a.c.i.c.g(localt))) {
          break label565;
        }
      }
    }
    label565:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label570;
      }
      paramt = (c)d(localt);
      AppMethodBeat.o(118925);
      return paramt;
      i = 0;
      break;
    }
    label570:
    paramt = (Throwable)new x("Unknown origin of " + localt + " (" + localt.getClass() + ')');
    AppMethodBeat.o(118925);
    throw paramt;
  }
  
  public static d c(ah paramah)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(118926);
    a.f.b.j.q(paramah, "possiblyOverriddenProperty");
    paramah = a.j.b.a.c.i.d.u((a.j.b.a.c.b.b)paramah);
    a.f.b.j.p(paramah, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    ah localah = ((ah)paramah).eek();
    a.f.b.j.p(localah, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    Object localObject3;
    if ((localah instanceof i))
    {
      paramah = ((i)localah).BOa;
      localObject2 = (i.c)paramah;
      localObject3 = a.j.b.a.c.e.b.b.Cpq;
      a.f.b.j.p(localObject3, "JvmProtoBuf.propertySignature");
      localObject2 = (b.e)a.j.b.a.c.e.a.f.a((i.c)localObject2, (i.f)localObject3);
      if (localObject2 != null)
      {
        paramah = (d)new d.c(localah, paramah, (b.e)localObject2, ((i)localah).BOc, ((i)localah).BOd);
        AppMethodBeat.o(118926);
        return paramah;
      }
    }
    else if ((localah instanceof a.j.b.a.c.d.a.b.f))
    {
      localObject1 = ((a.j.b.a.c.d.a.b.f)localah).ecN();
      paramah = (ah)localObject1;
      if (!(localObject1 instanceof a.j.b.a.c.d.a.d.a)) {
        paramah = null;
      }
      paramah = (a.j.b.a.c.d.a.d.a)paramah;
      if (paramah != null) {}
      for (paramah = paramah.ecb(); (paramah instanceof p); paramah = null)
      {
        paramah = (d)new d.a(((p)paramah).CFW);
        AppMethodBeat.o(118926);
        return paramah;
      }
      if ((paramah instanceof s))
      {
        localObject3 = ((s)paramah).CFX;
        paramah = localah.eei();
        if (paramah != null)
        {
          paramah = paramah.ecN();
          localObject1 = paramah;
          if (!(paramah instanceof a.j.b.a.c.d.a.d.a)) {
            localObject1 = null;
          }
          paramah = (a.j.b.a.c.d.a.d.a)localObject1;
          if (paramah == null) {
            break label332;
          }
        }
        label332:
        for (paramah = paramah.ecb();; paramah = null)
        {
          localObject1 = paramah;
          if (!(paramah instanceof s)) {
            localObject1 = null;
          }
          localObject1 = (s)localObject1;
          paramah = (ah)localObject2;
          if (localObject1 != null) {
            paramah = ((s)localObject1).CFX;
          }
          paramah = (d)new d.b((Method)localObject3, paramah);
          AppMethodBeat.o(118926);
          return paramah;
          paramah = null;
          break;
        }
      }
      paramah = (Throwable)new x("Incorrect resolution sequence for Java field " + localah + " (source = " + paramah + ')');
      AppMethodBeat.o(118926);
      throw paramah;
    }
    paramah = localah.eeh();
    if (paramah == null) {
      a.f.b.j.ebi();
    }
    localObject2 = d((a.j.b.a.c.b.t)paramah);
    paramah = localah.eei();
    if (paramah != null) {}
    for (paramah = d((a.j.b.a.c.b.t)paramah);; paramah = (ah)localObject1)
    {
      paramah = (d)new d.d((c.e)localObject2, paramah);
      AppMethodBeat.o(118926);
      return paramah;
    }
  }
  
  private static c.e d(a.j.b.a.c.b.t paramt)
  {
    AppMethodBeat.i(118927);
    paramt = new c.e(new f.b(b((a.j.b.a.c.b.b)paramt), r.a(paramt, false, false, 1)));
    AppMethodBeat.o(118927);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.ad
 * JD-Core Version:    0.7.0.1
 */