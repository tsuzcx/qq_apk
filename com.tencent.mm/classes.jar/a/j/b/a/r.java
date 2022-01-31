package a.j.b.a;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.g;
import a.j.b.a.c.b.ah;
import a.j.n;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflect-api"})
public class r<D, E, R>
  extends s<R>
  implements n<D, E, R>
{
  private final z.b<r.a<D, E, R>> BPB;
  private final f<Field> BPF;
  
  public r(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(118856);
    parami = z.k((a)new r.b(this));
    j.p(parami, "ReflectProperties.lazy { Getter(this) }");
    this.BPB = parami;
    this.BPF = g.a(a.k.BLU, (a)new c(this));
    AppMethodBeat.o(118856);
  }
  
  private r.a<D, E, R> ebL()
  {
    AppMethodBeat.i(118852);
    Object localObject = this.BPB.invoke();
    j.p(localObject, "_getter()");
    localObject = (r.a)localObject;
    AppMethodBeat.o(118852);
    return localObject;
  }
  
  public final R h(D paramD, E paramE)
  {
    AppMethodBeat.i(118855);
    paramD = o(paramD, paramE);
    AppMethodBeat.o(118855);
    return paramD;
  }
  
  public final R o(D paramD, E paramE)
  {
    AppMethodBeat.i(118854);
    paramD = ebL().X(new Object[] { paramD, paramE });
    AppMethodBeat.o(118854);
    return paramD;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Ljava/lang/reflect/Field;", "D", "E", "R", "invoke"})
  static final class c
    extends a.f.b.k
    implements a<Field>
  {
    c(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.r
 * JD-Core Version:    0.7.0.1
 */