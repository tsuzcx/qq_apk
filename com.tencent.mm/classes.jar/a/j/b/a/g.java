package a.j.b.a;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.t;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.j.b.a.c.g.q;
import a.j.b.a.c.j.a.a.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflect_api", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflect_api", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflect-api"})
public final class g<T>
  extends i
  implements a.j.b<T>
{
  final Class<T> BNl;
  final z.b<g<T>.a> BOr;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(118739);
    this.BNl = paramClass;
    paramClass = z.k((a.f.a.a)new g.b(this));
    a.f.b.j.p(paramClass, "ReflectProperties.lazy { Data() }");
    this.BOr = paramClass;
    AppMethodBeat.o(118739);
  }
  
  private e ebw()
  {
    AppMethodBeat.i(118727);
    e locale = ((g.a)this.BOr.invoke()).ebw();
    AppMethodBeat.o(118727);
    return locale;
  }
  
  private final a.j.b.a.c.f.a ebx()
  {
    AppMethodBeat.i(118728);
    Object localObject1 = ad.BQq;
    localObject1 = this.BNl;
    a.f.b.j.q(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      a.f.b.j.p(localObject1, "klass.componentType");
      localObject1 = ad.aK((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new a.j.b.a.c.f.a(a.j.b.a.c.a.g.BRJ, ((a.j.b.a.c.a.h)localObject1).BTO);
        AppMethodBeat.o(118728);
        return localObject1;
      }
      localObject1 = a.j.b.a.c.f.a.n(a.j.b.a.c.a.g.BRU.BSh.emf());
      a.f.b.j.p(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(118728);
      return localObject1;
    }
    if (a.f.b.j.e(localObject1, Void.TYPE))
    {
      localObject1 = ad.BQp;
      AppMethodBeat.o(118728);
      return localObject1;
    }
    Object localObject2 = ad.aK((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new a.j.b.a.c.f.a(a.j.b.a.c.a.g.BRJ, ((a.j.b.a.c.a.h)localObject2).BTN);
      AppMethodBeat.o(118728);
      return localObject1;
    }
    localObject1 = a.j.b.a.e.b.aU((Class)localObject1);
    if (!((a.j.b.a.c.f.a)localObject1).CqC)
    {
      localObject2 = a.j.b.a.c.a.b.c.BVe;
      localObject2 = ((a.j.b.a.c.f.a)localObject1).emc();
      a.f.b.j.p(localObject2, "classId.asSingleFqName()");
      localObject2 = a.j.b.a.c.a.b.c.f((a.j.b.a.c.f.b)localObject2);
      if (localObject2 != null)
      {
        AppMethodBeat.o(118728);
        return localObject2;
      }
    }
    AppMethodBeat.o(118728);
    return localObject1;
  }
  
  public final ah TR(int paramInt)
  {
    AppMethodBeat.i(118734);
    for (Object localObject1 = this; a.f.b.j.e(((g)localObject1).BNl.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).BNl.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = a.f.a.aF((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new a.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(118734);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).ebw();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof d)) {
      localObject2 = null;
    }
    localObject2 = (d)localObject2;
    if (localObject2 != null)
    {
      localObject3 = (i.c)((d)localObject2).Cys;
      i.f localf = a.j.b.a.c.e.b.b.Cpw;
      a.f.b.j.p(localf, "JvmProtoBuf.classLocalVariable");
      localObject3 = (a.u)a.j.b.a.c.e.a.f.a((i.c)localObject3, localf, paramInt);
      if (localObject3 != null)
      {
        localObject1 = (ah)af.a(((g)localObject1).BNl, (q)localObject3, ((d)localObject2).CyY.BOc, ((d)localObject2).CyY.BOd, ((d)localObject2).Cyt, (a.f.a.m)g.c.BOP);
        AppMethodBeat.o(118734);
        return localObject1;
      }
      AppMethodBeat.o(118734);
      return null;
    }
    AppMethodBeat.o(118734);
    return null;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(118732);
    a.f.b.j.q(paramf, "name");
    paramf = (Collection)a.a.j.b(eby().a(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA), (Iterable)ebz().a(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA));
    AppMethodBeat.o(118732);
    return paramf;
  }
  
  public final Collection<t> b(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(118733);
    a.f.b.j.q(paramf, "name");
    paramf = (Collection)a.a.j.b(eby().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA), (Iterable)ebz().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA));
    AppMethodBeat.o(118733);
    return paramf;
  }
  
  public final Class<T> ebg()
  {
    return this.BNl;
  }
  
  public final String ebh()
  {
    AppMethodBeat.i(118735);
    String str = (String)((g.a)this.BOr.invoke()).BOv.invoke();
    AppMethodBeat.o(118735);
    return str;
  }
  
  public final Collection<a.j.b.a.c.b.k> ebq()
  {
    AppMethodBeat.i(118731);
    Object localObject = ebw();
    if ((((e)localObject).ecB() == a.j.b.a.c.b.f.BWg) || (((e)localObject).ecB() == a.j.b.a.c.b.f.BWk))
    {
      localObject = (Collection)a.a.v.BMx;
      AppMethodBeat.o(118731);
      return localObject;
    }
    localObject = ((e)localObject).ecA();
    a.f.b.j.p(localObject, "descriptor.constructors");
    AppMethodBeat.o(118731);
    return localObject;
  }
  
  public final a.j.b.a.c.i.e.h eby()
  {
    AppMethodBeat.i(118729);
    a.j.b.a.c.i.e.h localh = ebw().edE().ecq();
    AppMethodBeat.o(118729);
    return localh;
  }
  
  public final a.j.b.a.c.i.e.h ebz()
  {
    AppMethodBeat.i(118730);
    a.j.b.a.c.i.e.h localh = ebw().ecw();
    a.f.b.j.p(localh, "descriptor.staticScope");
    AppMethodBeat.o(118730);
    return localh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118736);
    if (((paramObject instanceof g)) && (a.f.b.j.e(a.f.a.c(this), a.f.a.c((a.j.b)paramObject))))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118737);
    int i = a.f.a.c(this).hashCode();
    AppMethodBeat.o(118737);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118738);
    StringBuilder localStringBuilder = new StringBuilder("class ");
    Object localObject2 = ebx();
    Object localObject1 = ((a.j.b.a.c.f.a)localObject2).BUK;
    a.f.b.j.p(localObject1, "classId.packageFqName");
    if (((a.j.b.a.c.f.b)localObject1).CqE.CqJ.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((a.j.b.a.c.f.b)localObject1).CqE.CqJ + ".")
    {
      localObject2 = ((a.j.b.a.c.f.a)localObject2).CqB.CqE.CqJ;
      a.f.b.j.p(localObject2, "classId.relativeClassName.asString()");
      localObject2 = a.l.m.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(118738);
      return localObject1;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
  static final class a$i
    extends a.f.b.k
    implements a.f.a.a<e>
  {
    a$i(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.g
 * JD-Core Version:    0.7.0.1
 */