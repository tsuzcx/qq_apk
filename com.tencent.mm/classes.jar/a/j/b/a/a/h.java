package a.j.b.a.a;

import a.f.b.j;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.b;
import a.j.b.a.c.i.f;
import a.j.b.a.c.l.w;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "isDefault", "", "kotlin-reflect-api"})
public final class h
{
  public static final <M extends Member> d<M> a(e<? extends M> parame, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(119014);
    j.q(parame, "receiver$0");
    j.q(paramb, "descriptor");
    Object localObject1 = paramb.edu();
    j.p(localObject1, "descriptor.valueParameters");
    localObject1 = (Iterable)localObject1;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (au)((Iterator)localObject1).next();
          j.p(localObject2, "it");
          localObject2 = ((au)localObject2).eer();
          j.p(localObject2, "it.type");
          if (f.ab((w)localObject2))
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = paramb.eds();
              if ((localObject1 == null) || (f.ab((w)localObject1) != true))
              {
                if ((parame instanceof c)) {
                  break label225;
                }
                localObject1 = paramb.edp();
                if (localObject1 == null) {
                  break label225;
                }
                localObject1 = ((ak)localObject1).eer();
                if ((localObject1 == null) || (f.ab((w)localObject1) != true)) {
                  break label225;
                }
              }
            }
          }
        }
      }
    }
    label225:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label230;
      }
      parame = (d)new g(paramb, parame, paramBoolean);
      AppMethodBeat.o(119014);
      return parame;
      i = 0;
      break;
    }
    label230:
    parame = (d)parame;
    AppMethodBeat.o(119014);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */