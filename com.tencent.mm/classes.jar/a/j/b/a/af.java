package a.j.b.a;

import a.a.ad;
import a.j.b.a.b.e.a;
import a.j.b.a.b.k.a;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.d.b.a.a.a;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.b.a.g;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.j.b.a.c.j.a.k;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isPublicInBytecode", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Z", "packageModuleName", "", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "getPackageModuleName", "(Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;)Ljava/lang/String;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflect-api"})
public final class af
{
  private static final a.j.b.a.c.f.b BQs;
  
  static
  {
    AppMethodBeat.i(118946);
    BQs = new a.j.b.a.c.f.b("kotlin.jvm.JvmStatic");
    AppMethodBeat.o(118946);
  }
  
  public static final <M extends a.j.b.a.c.g.q, D extends a.j.b.a.c.b.a> D a(Class<?> paramClass, M paramM, a.j.b.a.c.e.a.c paramc, a.j.b.a.c.e.a.h paramh, a.j.b.a.c.e.a.a parama, a.f.a.m<? super a.j.b.a.c.j.a.q, ? super M, ? extends D> paramm)
  {
    AppMethodBeat.i(118945);
    a.f.b.j.q(paramClass, "moduleAnchor");
    a.f.b.j.q(paramM, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    a.f.b.j.q(paramh, "typeTable");
    a.f.b.j.q(parama, "metadataVersion");
    a.f.b.j.q(paramm, "createDescriptor");
    Object localObject1 = y.aJ(paramClass);
    if ((paramM instanceof a.o)) {}
    for (paramClass = ((a.o)paramM).Cld;; paramClass = ((a.u)paramM).Cld)
    {
      a.j.b.a.c.j.a.i locali = ((a.j.b.a.b.i)localObject1).BRl;
      localObject1 = (a.j.b.a.c.b.l)((a.j.b.a.b.i)localObject1).BRl.BVj;
      Object localObject2 = a.j.b.a.c.e.a.i.CoX;
      localObject2 = a.j.b.a.c.e.a.i.ekN();
      a.f.b.j.p(paramClass, "typeParameters");
      paramClass = (a.j.b.a.c.b.a)paramm.h(new a.j.b.a.c.j.a.q(new k(locali, paramc, (a.j.b.a.c.b.l)localObject1, paramh, (a.j.b.a.c.e.a.i)localObject2, parama, null, null, paramClass)), paramM);
      AppMethodBeat.o(118945);
      return paramClass;
      if (!(paramM instanceof a.u)) {
        break;
      }
    }
    paramClass = (Throwable)new IllegalStateException("Unsupported message: ".concat(String.valueOf(paramM)).toString());
    AppMethodBeat.o(118945);
    throw paramClass;
  }
  
  public static final ak a(a.j.b.a.c.b.a parama)
  {
    AppMethodBeat.i(118944);
    a.f.b.j.q(parama, "receiver$0");
    if (parama.edq() != null)
    {
      parama = parama.ecv();
      if (parama == null)
      {
        parama = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(118944);
        throw parama;
      }
      parama = ((a.j.b.a.c.b.e)parama).edK();
      AppMethodBeat.o(118944);
      return parama;
    }
    AppMethodBeat.o(118944);
    return null;
  }
  
  public static final Class<?> a(a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(118935);
    a.f.b.j.q(parame, "receiver$0");
    Object localObject1 = parame.ecN();
    a.f.b.j.p(localObject1, "source");
    if ((localObject1 instanceof a.j.b.a.c.d.b.p))
    {
      parame = ((a.j.b.a.c.d.b.p)localObject1).Cjv;
      if (parame == null)
      {
        parame = new a.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.components.ReflectKotlinClass");
        AppMethodBeat.o(118935);
        throw parame;
      }
      parame = ((a.j.b.a.b.e)parame).BRg;
      AppMethodBeat.o(118935);
      return parame;
    }
    if ((localObject1 instanceof k.a))
    {
      parame = ((k.a)localObject1).BRt;
      if (parame == null)
      {
        parame = new a.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.structure.ReflectJavaClass");
        AppMethodBeat.o(118935);
        throw parame;
      }
      parame = ((a.j.b.a.e.j)parame).BRg;
      AppMethodBeat.o(118935);
      return parame;
    }
    localObject1 = a.j.b.a.c.a.b.c.BVe;
    localObject1 = a.j.b.a.c.i.d.n((a.j.b.a.c.b.l)parame);
    a.f.b.j.p(localObject1, "DescriptorUtils.getFqName(this)");
    Object localObject2 = a.j.b.a.c.a.b.c.c((a.j.b.a.c.f.c)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a.j.b.a.c.i.c.a.c((a.j.b.a.c.b.h)parame);
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(118935);
      return null;
    }
    localObject2 = ((a.j.b.a.c.f.a)localObject1).BUK.CqE.CqJ;
    a.f.b.j.p(localObject2, "classId.packageFqName.asString()");
    localObject1 = ((a.j.b.a.c.f.a)localObject1).CqB.CqE.CqJ;
    a.f.b.j.p(localObject1, "classId.relativeClassName.asString()");
    parame = a(a.j.b.a.e.b.aQ(parame.getClass()), (String)localObject2, (String)localObject1);
    AppMethodBeat.o(118935);
    return parame;
  }
  
  private static Class<?> a(ClassLoader paramClassLoader, String paramString1, String paramString2)
  {
    AppMethodBeat.i(118936);
    a.f.b.j.q(paramClassLoader, "classLoader");
    a.f.b.j.q(paramString1, "packageName");
    a.f.b.j.q(paramString2, "className");
    if (a.f.b.j.e(paramString1, "kotlin")) {
      switch (paramString2.hashCode())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      paramClassLoader = a.j.b.a.b.d.a(paramClassLoader, paramString1 + '.' + a.l.m.a(paramString2, '.', '$'));
                      AppMethodBeat.o(118936);
                      return paramClassLoader;
                    } while (!paramString2.equals("Array"));
                    AppMethodBeat.o(118936);
                    return [Ljava.lang.Object.class;
                  } while (!paramString2.equals("LongArray"));
                  AppMethodBeat.o(118936);
                  return [J.class;
                } while (!paramString2.equals("CharArray"));
                AppMethodBeat.o(118936);
                return [C.class;
              } while (!paramString2.equals("FloatArray"));
              AppMethodBeat.o(118936);
              return [F.class;
            } while (!paramString2.equals("IntArray"));
            AppMethodBeat.o(118936);
            return [I.class;
          } while (!paramString2.equals("ByteArray"));
          AppMethodBeat.o(118936);
          return [B.class;
        } while (!paramString2.equals("ShortArray"));
        AppMethodBeat.o(118936);
        return [S.class;
      } while (!paramString2.equals("DoubleArray"));
      AppMethodBeat.o(118936);
      return [D.class;
    } while (!paramString2.equals("BooleanArray"));
    AppMethodBeat.o(118936);
    return [Z.class;
  }
  
  private static final Object a(a.j.b.a.c.i.b.f<?> paramf, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(118939);
    if ((paramf instanceof a.j.b.a.c.i.b.a))
    {
      paramf = a((a.j.b.a.c.b.a.c)((a.j.b.a.c.i.b.a)paramf).getValue());
      AppMethodBeat.o(118939);
      return paramf;
    }
    Object localObject;
    if ((paramf instanceof a.j.b.a.c.i.b.b))
    {
      localObject = (Iterable)((a.j.b.a.c.i.b.b)paramf).getValue();
      paramf = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(a((a.j.b.a.c.i.b.f)((Iterator)localObject).next(), paramClassLoader));
      }
      paramf = ((Collection)paramf).toArray(new Object[0]);
      if (paramf == null)
      {
        paramf = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(118939);
        throw paramf;
      }
      AppMethodBeat.o(118939);
      return paramf;
    }
    if ((paramf instanceof a.j.b.a.c.i.b.i))
    {
      paramf = (a.o)((a.j.b.a.c.i.b.i)paramf).getValue();
      localObject = (a.j.b.a.c.f.a)paramf.first;
      paramf = (a.j.b.a.c.f.f)paramf.second;
      String str = ((a.j.b.a.c.f.a)localObject).BUK.CqE.CqJ;
      a.f.b.j.p(str, "enumClassId.packageFqName.asString()");
      localObject = ((a.j.b.a.c.f.a)localObject).CqB.CqE.CqJ;
      a.f.b.j.p(localObject, "enumClassId.relativeClassName.asString()");
      paramClassLoader = a(paramClassLoader, str, (String)localObject);
      if (paramClassLoader != null)
      {
        if (paramClassLoader == null)
        {
          paramf = new a.v("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
          AppMethodBeat.o(118939);
          throw paramf;
        }
        paramf = Enum.valueOf(paramClassLoader, paramf.name);
        AppMethodBeat.o(118939);
        return paramf;
      }
      AppMethodBeat.o(118939);
      return null;
    }
    if ((paramf instanceof a.j.b.a.c.i.b.o))
    {
      paramClassLoader = ((a.j.b.a.c.i.b.o)paramf).enW().enU().ecR();
      paramf = paramClassLoader;
      if (!(paramClassLoader instanceof a.j.b.a.c.b.e)) {
        paramf = null;
      }
      paramf = (a.j.b.a.c.b.e)paramf;
      if (paramf != null)
      {
        paramf = a(paramf);
        AppMethodBeat.o(118939);
        return paramf;
      }
      AppMethodBeat.o(118939);
      return null;
    }
    if (((paramf instanceof a.j.b.a.c.i.b.j)) || ((paramf instanceof a.j.b.a.c.i.b.q)))
    {
      AppMethodBeat.o(118939);
      return null;
    }
    paramf = paramf.getValue();
    AppMethodBeat.o(118939);
    return paramf;
  }
  
  public static final String a(a.j.b.a.b.e parame)
  {
    AppMethodBeat.i(118942);
    Object localObject1 = parame;
    label260:
    label265:
    for (;;)
    {
      a.f.b.j.q(localObject1, "receiver$0");
      Object localObject2 = ((a.j.b.a.b.e)localObject1).BRh;
      if (!((a.j.b.a.c.d.b.a.a)localObject2).CjR.elW())
      {
        AppMethodBeat.o(118942);
        return null;
      }
      parame = ((a.j.b.a.c.d.b.a.a)localObject2).CjQ;
      switch (ag.bLo[parame.ordinal()])
      {
      }
      label208:
      label255:
      do
      {
        parame = null;
        do
        {
          AppMethodBeat.o(118942);
          return parame;
          parame = ((a.j.b.a.c.d.b.a.a)localObject2).CjT;
          if (parame == null) {
            a.f.b.j.ebi();
          }
          localObject1 = ((a.j.b.a.c.d.b.a.a)localObject2).strings;
          if (localObject1 == null) {
            a.f.b.j.ebi();
          }
          localObject1 = a.j.b.a.c.e.b.a.j.e(parame, (String[])localObject1);
          parame = (a.j.b.a.c.e.b.a.h)((a.o)localObject1).first;
          localObject1 = (i.c)((a.o)localObject1).second;
          localObject2 = a.j.b.a.c.e.b.b.Cpy;
          a.f.b.j.p(localObject2, "JvmProtoBuf.packageModuleName");
          localObject1 = (Integer)a.j.b.a.c.e.a.f.a((i.c)localObject1, (i.f)localObject2);
          if (localObject1 == null) {
            break;
          }
          localObject1 = parame.getString(((Number)localObject1).intValue());
          parame = (a.j.b.a.b.e)localObject1;
        } while (localObject1 != null);
        AppMethodBeat.o(118942);
        return "main";
        parame = ((a.j.b.a.c.d.b.a.a)localObject2).CjT;
        int i;
        if (((a.j.b.a.c.d.b.a.a)localObject2).CjQ == a.a.Ckb)
        {
          i = 1;
          if (i == 0) {
            break label255;
          }
          if (parame == null) {
            break label260;
          }
        }
        for (parame = a.a.e.asList(parame);; parame = null)
        {
          localObject2 = parame;
          if (parame == null) {
            localObject2 = (List)a.a.v.BMx;
          }
          parame = (String)a.a.j.fR((List)localObject2);
          if (parame != null) {
            break label265;
          }
          AppMethodBeat.o(118942);
          return null;
          i = 0;
          break;
          parame = null;
          break label208;
        }
        localObject2 = a.j.b.a.b.e.BRi;
        parame = ((a.j.b.a.b.e)localObject1).BRg.getClassLoader().loadClass(a.l.m.a(parame, '/', '.'));
        a.f.b.j.p(parame, "klass.classLoader.loadCl…rtName.replace('/', '.'))");
        localObject1 = e.a.aO(parame);
      } while (localObject1 == null);
    }
  }
  
  private static final Annotation a(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(118938);
    Object localObject1 = a.j.b.a.c.i.c.a.l(paramc);
    if (localObject1 != null)
    {
      localObject1 = a((a.j.b.a.c.b.e)localObject1);
      if ((localObject1 instanceof Class)) {
        break label206;
      }
      localObject1 = null;
    }
    label178:
    label206:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(118938);
        return null;
        localObject1 = null;
        break;
      }
      paramc = (Iterable)paramc.eeG().entrySet();
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        paramc = (a.j.b.a.c.f.f)((Map.Entry)localObject2).getKey();
        localObject2 = (a.j.b.a.c.i.b.f)((Map.Entry)localObject2).getValue();
        ClassLoader localClassLoader = ((Class)localObject1).getClassLoader();
        a.f.b.j.p(localClassLoader, "annotationClass.classLoader");
        localObject2 = a((a.j.b.a.c.i.b.f)localObject2, localClassLoader);
        if (localObject2 != null) {}
        for (paramc = u.F(paramc.name, localObject2);; paramc = null)
        {
          if (paramc == null) {
            break label178;
          }
          localCollection.add(paramc);
          break;
        }
      }
      paramc = (Annotation)a.j.b.a.a.b.a((Class)localObject1, ad.w((Iterable)localCollection));
      AppMethodBeat.o(118938);
      return paramc;
    }
  }
  
  public static final List<Annotation> a(a.j.b.a.c.b.a.a parama)
  {
    AppMethodBeat.i(118937);
    a.f.b.j.q(parama, "receiver$0");
    parama = (Iterable)parama.ecM();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = parama.iterator();
    label150:
    while (localIterator.hasNext())
    {
      parama = (a.j.b.a.c.b.a.c)localIterator.next();
      Object localObject = parama.ecN();
      if ((localObject instanceof a.j.b.a.b.a)) {
        parama = ((a.j.b.a.b.a)localObject).BRd;
      }
      for (;;)
      {
        if (parama == null) {
          break label150;
        }
        localCollection.add(parama);
        break;
        if ((localObject instanceof k.a))
        {
          localObject = ((k.a)localObject).BRt;
          parama = (a.j.b.a.c.b.a.a)localObject;
          if (!(localObject instanceof a.j.b.a.e.c)) {
            parama = null;
          }
          parama = (a.j.b.a.e.c)parama;
          if (parama != null) {
            parama = parama.BRd;
          } else {
            parama = null;
          }
        }
        else
        {
          parama = a(parama);
        }
      }
    }
    parama = (List)localCollection;
    AppMethodBeat.o(118937);
    return parama;
  }
  
  public static final boolean c(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(118943);
    a.f.b.j.q(paramb, "receiver$0");
    az localaz = paramb.ecE();
    a.f.b.j.p(localaz, "visibility");
    if (((a.f.b.j.e(localaz, ay.BWO)) || (a.f.b.j.e(localaz, ay.BWN))) && (!a.j.b.a.c.b.a.f.a((a.j.b.a.c.b.v)paramb)))
    {
      AppMethodBeat.o(118943);
      return true;
    }
    AppMethodBeat.o(118943);
    return false;
  }
  
  public static final j dr(Object paramObject)
  {
    AppMethodBeat.i(118940);
    if (!(paramObject instanceof j)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      j localj = (j)localObject;
      localObject = localj;
      if (localj == null)
      {
        if ((paramObject instanceof a.f.b.i)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (a.f.b.i)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.ebc();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof j)) {
            localObject = null;
          }
          localObject = (j)localObject;
          AppMethodBeat.o(118940);
          return localObject;
        }
      }
    }
  }
  
  public static final s<?> ds(Object paramObject)
  {
    AppMethodBeat.i(118941);
    if (!(paramObject instanceof s)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      s locals = (s)localObject;
      localObject = locals;
      if (locals == null)
      {
        if ((paramObject instanceof a.f.b.p)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (a.f.b.p)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.ebc();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof s)) {
            localObject = null;
          }
          localObject = (s)localObject;
          AppMethodBeat.o(118941);
          return localObject;
        }
      }
    }
  }
  
  public static final a.j.b.a.c.f.b ebU()
  {
    return BQs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.af
 * JD-Core Version:    0.7.0.1
 */