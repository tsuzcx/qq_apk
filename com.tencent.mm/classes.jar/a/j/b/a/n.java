package a.j.b.a;

import a.a.v;
import a.f.a.m;
import a.f.b.j;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.k;
import a.j.b.a.c.e.a.ag;
import a.j.b.a.c.e.a.s;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.b.a.g;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.j.b.a.c.g.q;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "toString", "Data", "kotlin-reflect-api"})
public final class n
  extends i
{
  final Class<?> BNl;
  private final z.b<n.a> BOr;
  private final String BPq;
  
  public n(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(118815);
    this.BNl = paramClass;
    this.BPq = paramString;
    paramClass = z.k((a.f.a.a)new n.b(this));
    j.p(paramClass, "ReflectProperties.lazy { Data() }");
    this.BOr = paramClass;
    AppMethodBeat.o(118815);
  }
  
  private final a.j.b.a.c.i.e.h ebG()
  {
    AppMethodBeat.i(118808);
    a.j.b.a.c.i.e.h localh = ((ad)((n.a)this.BOr.invoke()).BOs.invoke()).ecq();
    AppMethodBeat.o(118808);
    return localh;
  }
  
  public final ah TR(int paramInt)
  {
    AppMethodBeat.i(118811);
    Object localObject2 = (a.t)((n.a)this.BOr.invoke()).BPt.invoke();
    if (localObject2 != null)
    {
      Object localObject3 = (a.j.b.a.c.e.b.a.h)((a.t)localObject2).first;
      Object localObject1 = (a.s)((a.t)localObject2).second;
      localObject2 = (g)((a.t)localObject2).BMe;
      Object localObject4 = (i.c)localObject1;
      Object localObject5 = a.j.b.a.c.e.b.b.Cpz;
      j.p(localObject5, "JvmProtoBuf.packageLocalVariable");
      localObject5 = (a.u)a.j.b.a.c.e.a.f.a((i.c)localObject4, (i.f)localObject5, paramInt);
      if (localObject5 != null)
      {
        localObject4 = this.BNl;
        localObject5 = (q)localObject5;
        localObject3 = (a.j.b.a.c.e.a.c)localObject3;
        localObject1 = ((a.s)localObject1).Clq;
        j.p(localObject1, "packageProto.typeTable");
        localObject1 = (ah)af.a((Class)localObject4, (q)localObject5, (a.j.b.a.c.e.a.c)localObject3, new a.j.b.a.c.e.a.h((a.ag)localObject1), (a.j.b.a.c.e.a.a)localObject2, (m)n.c.BPx);
        AppMethodBeat.o(118811);
        return localObject1;
      }
      AppMethodBeat.o(118811);
      return null;
    }
    AppMethodBeat.o(118811);
    return null;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(118809);
    j.q(paramf, "name");
    paramf = ebG().a(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA);
    AppMethodBeat.o(118809);
    return paramf;
  }
  
  public final Collection<a.j.b.a.c.b.t> b(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(118810);
    j.q(paramf, "name");
    paramf = ebG().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbA);
    AppMethodBeat.o(118810);
    return paramf;
  }
  
  protected final Class<?> ebB()
  {
    AppMethodBeat.i(118807);
    Class localClass = (Class)((n.a)this.BOr.invoke()).BPs.invoke();
    AppMethodBeat.o(118807);
    return localClass;
  }
  
  public final Class<?> ebg()
  {
    return this.BNl;
  }
  
  public final Collection<k> ebq()
  {
    return (Collection)v.BMx;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118812);
    if (((paramObject instanceof n)) && (j.e(this.BNl, ((n)paramObject).BNl)))
    {
      AppMethodBeat.o(118812);
      return true;
    }
    AppMethodBeat.o(118812);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118813);
    int i = this.BNl.hashCode();
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118814);
    Object localObject = a.j.b.a.e.b.aU(this.BNl).BUK;
    j.p(localObject, "jClass.classId.packageFqName");
    StringBuilder localStringBuilder = new StringBuilder("package ");
    if (((a.j.b.a.c.f.b)localObject).CqE.CqJ.isEmpty()) {
      localObject = "<default>";
    }
    for (;;)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(118814);
      return localObject;
      localObject = ((a.j.b.a.c.f.b)localObject).CqE.CqJ;
      j.p(localObject, "fqName.asString()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.n
 * JD-Core Version:    0.7.0.1
 */