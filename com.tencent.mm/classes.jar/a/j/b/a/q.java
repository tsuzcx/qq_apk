package a.j.b.a;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.g;
import a.j.b.a.c.b.ah;
import a.j.m;
import a.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflect-api"})
public class q<T, R>
  extends s<R>
  implements m<T, R>
{
  private final z.b<q.a<T, R>> BPB;
  private final f<Field> BPF;
  
  public q(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(118847);
    parami = z.k((a)new q.b(this));
    j.p(parami, "ReflectProperties.lazy { Getter(this) }");
    this.BPB = parami;
    this.BPF = g.a(k.BLU, (a)new q.c(this));
    AppMethodBeat.o(118847);
  }
  
  public q(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(118846);
    parami = z.k((a)new q.b(this));
    j.p(parami, "ReflectProperties.lazy { Getter(this) }");
    this.BPB = parami;
    this.BPF = g.a(k.BLU, (a)new q.c(this));
    AppMethodBeat.o(118846);
  }
  
  private q.a<T, R> ebK()
  {
    AppMethodBeat.i(118841);
    Object localObject = this.BPB.invoke();
    j.p(localObject, "_getter()");
    localObject = (q.a)localObject;
    AppMethodBeat.o(118841);
    return localObject;
  }
  
  public final R S(T paramT)
  {
    AppMethodBeat.i(118845);
    paramT = get(paramT);
    AppMethodBeat.o(118845);
    return paramT;
  }
  
  public final R get(T paramT)
  {
    AppMethodBeat.i(118844);
    paramT = ebK().X(new Object[] { paramT });
    AppMethodBeat.o(118844);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.q
 * JD-Core Version:    0.7.0.1
 */