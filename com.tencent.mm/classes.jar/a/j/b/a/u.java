package a.j.b.a;

import a.f.b.r;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.e.b;
import a.j.c;
import a.j.o;
import a.j.q;
import a.l;
import a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflect-api", "parameterizedTypeArguments"})
public final class u
  implements o
{
  private final z.a BPW;
  private final z.a BPX;
  private final z.a BPY;
  public final a.j.b.a.c.l.w BPZ;
  
  static
  {
    AppMethodBeat.i(118877);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(u.class), "javaType", "getJavaType$kotlin_reflect_api()Ljava/lang/reflect/Type;")), (a.j.k)v.a(new t(v.aG(u.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (a.j.k)v.a(new t(v.aG(u.class), "arguments", "getArguments()Ljava/util/List;")), (a.j.k)v.a(new r(v.aG(u.class), "parameterizedTypeArguments", "<v#0>")) };
    AppMethodBeat.o(118877);
  }
  
  public u(a.j.b.a.c.l.w paramw, a.f.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(118884);
    this.BPZ = paramw;
    this.BPW = z.a(null, parama);
    this.BPX = z.a(null, (a.f.a.a)new u.b(this));
    this.BPY = z.a(null, (a.f.a.a)new a(this));
    AppMethodBeat.o(118884);
  }
  
  private final c a(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(118880);
    Object localObject = paramw.enU().ecR();
    if ((localObject instanceof e))
    {
      localObject = af.a((e)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(118880);
        return null;
      }
      if (((Class)localObject).isArray())
      {
        paramw = (ap)a.a.j.fV(paramw.enR());
        if (paramw != null)
        {
          paramw = paramw.eer();
          if (paramw != null) {}
        }
        else
        {
          paramw = (c)new g((Class)localObject);
          AppMethodBeat.o(118880);
          return paramw;
        }
        a.f.b.j.p(paramw, "type.arguments.singleOrN…return KClassImpl(jClass)");
        paramw = a(paramw);
        if (paramw == null)
        {
          paramw = (Throwable)new x("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
          AppMethodBeat.o(118880);
          throw paramw;
        }
        paramw = (c)new g(b.aW(a.f.a.a(a.j.b.a.a(paramw))));
        AppMethodBeat.o(118880);
        return paramw;
      }
      if (!av.aB(paramw))
      {
        paramw = b.aS((Class)localObject);
        if (paramw != null) {
          break label293;
        }
        paramw = (a.j.b.a.c.l.w)localObject;
      }
    }
    label293:
    for (;;)
    {
      paramw = (c)new g(paramw);
      AppMethodBeat.o(118880);
      return paramw;
      paramw = (c)new g((Class)localObject);
      AppMethodBeat.o(118880);
      return paramw;
      if ((localObject instanceof ar))
      {
        paramw = (c)new w((ar)localObject);
        AppMethodBeat.o(118880);
        return paramw;
      }
      if ((localObject instanceof aq))
      {
        paramw = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
        AppMethodBeat.o(118880);
        throw paramw;
      }
      AppMethodBeat.o(118880);
      return null;
    }
  }
  
  public final Type ebT()
  {
    AppMethodBeat.i(118878);
    Type localType = (Type)this.BPW.invoke();
    AppMethodBeat.o(118878);
    return localType;
  }
  
  public final c ebn()
  {
    AppMethodBeat.i(118879);
    c localc = (c)this.BPX.invoke();
    AppMethodBeat.o(118879);
    return localc;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118881);
    if (((paramObject instanceof u)) && (a.f.b.j.e(this.BPZ, ((u)paramObject).BPZ)))
    {
      AppMethodBeat.o(118881);
      return true;
    }
    AppMethodBeat.o(118881);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118882);
    int i = this.BPZ.hashCode();
    AppMethodBeat.o(118882);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118883);
    Object localObject = ab.BQm;
    localObject = ab.b(this.BPZ);
    AppMethodBeat.o(118883);
    return localObject;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
  static final class a
    extends a.f.b.k
    implements a.f.a.a<List<? extends q>>
  {
    a(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.u
 * JD-Core Version:    0.7.0.1
 */