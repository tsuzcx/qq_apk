package a.j.b.a;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.g;
import a.j.b.a.c.b.ah;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflect-api"})
public class p<R>
  extends s<R>
  implements a.j.l<R>
{
  private final z.b<p.a<R>> BPB;
  private final f<Object> BPC;
  
  public p(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(118835);
    parami = z.k((a)new b(this));
    j.p(parami, "ReflectProperties.lazy { Getter(this) }");
    this.BPB = parami;
    this.BPC = g.a(a.k.BLU, (a)new p.c(this));
    AppMethodBeat.o(118835);
  }
  
  public p(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(118836);
    parami = z.k((a)new b(this));
    j.p(parami, "ReflectProperties.lazy { Getter(this) }");
    this.BPB = parami;
    this.BPC = g.a(a.k.BLU, (a)new p.c(this));
    AppMethodBeat.o(118836);
  }
  
  private p.a<R> ebI()
  {
    AppMethodBeat.i(118830);
    Object localObject = this.BPB.invoke();
    j.p(localObject, "_getter()");
    localObject = (p.a)localObject;
    AppMethodBeat.o(118830);
    return localObject;
  }
  
  public final R get()
  {
    AppMethodBeat.i(118833);
    Object localObject = ebI().X(new Object[0]);
    AppMethodBeat.o(118833);
    return localObject;
  }
  
  public final R invoke()
  {
    AppMethodBeat.i(118834);
    Object localObject = get();
    AppMethodBeat.o(118834);
    return localObject;
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"})
  static final class b
    extends a.f.b.k
    implements a<p.a<? extends R>>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.p
 * JD-Core Version:    0.7.0.1
 */