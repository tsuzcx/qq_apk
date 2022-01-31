package a.j.b;

import a.j.b;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.f;
import a.j.b.a.c.b.h;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.j.b.a.u;
import a.j.b.a.x;
import a.j.c;
import a.j.o;
import a.j.p;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflect-api"})
public final class a
{
  public static final b<?> a(c paramc)
  {
    AppMethodBeat.i(118655);
    a.f.b.j.q(paramc, "receiver$0");
    if ((paramc instanceof b))
    {
      paramc = (b)paramc;
      AppMethodBeat.o(118655);
      return paramc;
    }
    if ((paramc instanceof p))
    {
      List localList = ((p)paramc).ebo();
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject;
      int i;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        paramc = (o)localObject;
        if (paramc == null)
        {
          paramc = new a.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          AppMethodBeat.o(118655);
          throw paramc;
        }
        h localh = ((u)paramc).BPZ.enU().ecR();
        paramc = localh;
        if (!(localh instanceof e)) {
          paramc = null;
        }
        paramc = (e)paramc;
        if ((paramc != null) && (paramc.ecB() != f.BWg) && (paramc.ecB() != f.BWj))
        {
          i = 1;
          label166:
          if (i == 0) {
            break label221;
          }
        }
      }
      for (paramc = (c)localObject;; paramc = null)
      {
        localObject = (o)paramc;
        paramc = (c)localObject;
        if (localObject == null) {
          paramc = (o)a.a.j.fR(localList);
        }
        if (paramc != null)
        {
          paramc = a(paramc);
          if (paramc != null) {
            break label255;
          }
        }
        paramc = a.f.b.v.aG(Object.class);
        AppMethodBeat.o(118655);
        return paramc;
        i = 0;
        break label166;
        label221:
        break;
      }
    }
    paramc = (Throwable)new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(118655);
    throw paramc;
    label255:
    AppMethodBeat.o(118655);
    return paramc;
  }
  
  private static b<?> a(o paramo)
  {
    AppMethodBeat.i(118654);
    a.f.b.j.q(paramo, "receiver$0");
    Object localObject = paramo.ebn();
    if (localObject != null)
    {
      localObject = a((c)localObject);
      if (localObject != null) {}
    }
    else
    {
      paramo = (Throwable)new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramo)));
      AppMethodBeat.o(118654);
      throw paramo;
    }
    AppMethodBeat.o(118654);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a
 * JD-Core Version:    0.7.0.1
 */