package a.j.b.a;

import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.ar;
import a.j.k;
import a.j.o;
import a.j.p;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflect-api"})
public final class w
  implements p
{
  private final z.a BQe;
  final ar BQf;
  
  static
  {
    AppMethodBeat.i(118888);
    eOJ = new k[] { (k)v.a(new t(v.aG(w.class), "upperBounds", "getUpperBounds()Ljava/util/List;")) };
    AppMethodBeat.o(118888);
  }
  
  public w(ar paramar)
  {
    AppMethodBeat.i(118893);
    this.BQf = paramar;
    this.BQe = z.a(null, (a)new w.a(this));
    AppMethodBeat.o(118893);
  }
  
  public final List<o> ebo()
  {
    AppMethodBeat.i(118889);
    List localList = (List)this.BQe.invoke();
    AppMethodBeat.o(118889);
    return localList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118890);
    if (((paramObject instanceof w)) && (j.e(this.BQf, ((w)paramObject).BQf)))
    {
      AppMethodBeat.o(118890);
      return true;
    }
    AppMethodBeat.o(118890);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118891);
    int i = this.BQf.hashCode();
    AppMethodBeat.o(118891);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118892);
    Object localObject = ab.BQm;
    localObject = ab.a(this.BQf);
    AppMethodBeat.o(118892);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.w
 * JD-Core Version:    0.7.0.1
 */