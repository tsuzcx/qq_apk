package a.j.b.a;

import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.ae;
import a.j.b.a.c.b.au;
import a.j.b.a.c.f.f;
import a.j.j.a;
import a.j.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflect-api"})
public final class o
  implements a.j.j
{
  private final z.a BOs;
  private final z.a BOt;
  final e<?> BPy;
  final j.a BPz;
  final int index;
  
  static
  {
    AppMethodBeat.i(118818);
    eOJ = new k[] { (k)v.a(new t(v.aG(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (k)v.a(new t(v.aG(o.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(118818);
  }
  
  public o(e<?> parame, int paramInt, j.a parama, a.f.a.a<? extends ae> parama1)
  {
    AppMethodBeat.i(118824);
    this.BPy = parame;
    this.index = paramInt;
    this.BPz = parama;
    this.BOs = z.a(null, parama1);
    this.BOt = z.a(null, (a.f.a.a)new o.a(this));
    AppMethodBeat.o(118824);
  }
  
  private final ae ebH()
  {
    AppMethodBeat.i(118819);
    ae localae = (ae)this.BOs.invoke();
    AppMethodBeat.o(118819);
    return localae;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118821);
    if (((paramObject instanceof o)) && (a.f.b.j.e(this.BPy, ((o)paramObject).BPy)) && (a.f.b.j.e(ebH(), ((o)paramObject).ebH())))
    {
      AppMethodBeat.o(118821);
      return true;
    }
    AppMethodBeat.o(118821);
    return false;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(118820);
    ae localae = ebH();
    Object localObject = localae;
    if (!(localae instanceof au)) {
      localObject = null;
    }
    localObject = (au)localObject;
    if (localObject == null)
    {
      AppMethodBeat.o(118820);
      return null;
    }
    if (((au)localObject).ees().edv())
    {
      AppMethodBeat.o(118820);
      return null;
    }
    localObject = ((au)localObject).edF();
    a.f.b.j.p(localObject, "valueParameter.name");
    if (((f)localObject).CqN)
    {
      AppMethodBeat.o(118820);
      return null;
    }
    localObject = ((f)localObject).name;
    AppMethodBeat.o(118820);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118822);
    int i = this.BPy.hashCode();
    int j = ebH().hashCode();
    AppMethodBeat.o(118822);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118823);
    Object localObject = ab.BQm;
    localObject = ab.b(this);
    AppMethodBeat.o(118823);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.o
 * JD-Core Version:    0.7.0.1
 */