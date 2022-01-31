package a.j.b.a;

import a.f.a.a;
import a.f.b.h;
import a.f.b.v;
import a.j.b.a.a.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflect-api"})
public final class j
  extends e<Object>
  implements h<Object>, b, a.j.e<Object>
{
  private final z.a BOs;
  private final z.a BPd;
  private final z.a BPe;
  final i BPf;
  private final Object BPg;
  private final String signature;
  
  static
  {
    AppMethodBeat.i(118759);
    eOJ = new a.j.k[] { (a.j.k)v.a(new a.f.b.t(v.aG(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (a.j.k)v.a(new a.f.b.t(v.aG(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), (a.j.k)v.a(new a.f.b.t(v.aG(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")) };
    AppMethodBeat.o(118759);
  }
  
  public j(i parami, a.j.b.a.c.b.t paramt)
  {
    this(parami, str, ad.c(paramt).mk(), paramt);
    AppMethodBeat.i(118772);
    AppMethodBeat.o(118772);
  }
  
  private j(i parami, String paramString1, String paramString2, a.j.b.a.c.b.t paramt, Object paramObject)
  {
    AppMethodBeat.i(118769);
    this.BPf = parami;
    this.signature = paramString2;
    this.BPg = paramObject;
    this.BOs = z.a(paramt, (a)new j.c(this, paramString1));
    this.BPd = z.a(null, (a)new j.a(this));
    this.BPe = z.a(null, (a)new b(this));
    AppMethodBeat.o(118769);
  }
  
  public j(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
    AppMethodBeat.i(118771);
    AppMethodBeat.o(118771);
  }
  
  public final Object S(Object paramObject)
  {
    AppMethodBeat.i(118774);
    paramObject = X(new Object[] { paramObject });
    AppMethodBeat.o(118774);
    return paramObject;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(118777);
    paramObject1 = X(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(118777);
    return paramObject1;
  }
  
  public final Object d(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(118776);
    paramObject1 = X(new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(118776);
    return paramObject1;
  }
  
  public final int eaY()
  {
    AppMethodBeat.i(118765);
    int i = a.j.b.a.a.f.a(ebt());
    AppMethodBeat.o(118765);
    return i;
  }
  
  public final a.j.b.a.c.b.t ebE()
  {
    AppMethodBeat.i(118761);
    a.j.b.a.c.b.t localt = (a.j.b.a.c.b.t)this.BOs.invoke();
    AppMethodBeat.o(118761);
    return localt;
  }
  
  public final d<?> ebt()
  {
    AppMethodBeat.i(118764);
    d locald = (d)this.BPd.invoke();
    AppMethodBeat.o(118764);
    return locald;
  }
  
  public final i ebu()
  {
    return this.BPf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118766);
    paramObject = af.dr(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(118766);
      return false;
    }
    if ((a.f.b.j.e(this.BPf, paramObject.BPf)) && (a.f.b.j.e(getName(), paramObject.getName())) && (a.f.b.j.e(this.signature, paramObject.signature)) && (a.f.b.j.e(this.BPg, paramObject.BPg)))
    {
      AppMethodBeat.o(118766);
      return true;
    }
    AppMethodBeat.o(118766);
    return false;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(118763);
    String str = ebE().edF().name;
    a.f.b.j.p(str, "descriptor.name.asString()");
    AppMethodBeat.o(118763);
    return str;
  }
  
  public final Object h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(118775);
    paramObject1 = X(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(118775);
    return paramObject1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118767);
    int i = this.BPf.hashCode();
    int j = getName().hashCode();
    int k = this.signature.hashCode();
    AppMethodBeat.o(118767);
    return (i * 31 + j) * 31 + k;
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(118773);
    Object localObject = X(new Object[0]);
    AppMethodBeat.o(118773);
    return localObject;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(118760);
    boolean bool = a.f.b.j.e(this.BPg, a.f.b.c.BNj);
    AppMethodBeat.o(118760);
    return bool ^ true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118768);
    Object localObject = ab.BQm;
    localObject = ab.a(ebE());
    AppMethodBeat.o(118768);
    return localObject;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class b
    extends a.f.b.k
    implements a<d<? extends Member>>
  {
    b(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.j
 * JD-Core Version:    0.7.0.1
 */