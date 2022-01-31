package a.j.b.a;

import a.aa;
import a.j.b.a.a.e;
import a.j.b.a.a.e.f;
import a.j.b.a.a.e.f.a;
import a.j.b.a.a.e.f.b;
import a.j.b.a.a.e.f.c;
import a.j.b.a.a.e.f.d;
import a.j.b.a.a.e.f.e;
import a.j.b.a.a.e.f.f;
import a.j.b.a.a.h;
import a.j.b.a.c.b.b;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.b.a.f.b;
import a.j.b.a.c.e.b.b.c;
import a.j.b.a.c.e.b.b.e;
import a.l;
import a.l.k;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflect-api"})
public final class t
{
  static final a.j.b.a.a.d<?> a(s.a<?, ?> parama, boolean paramBoolean)
  {
    AppMethodBeat.i(118870);
    Object localObject1 = i.BOS;
    if (i.ebC().ao((CharSequence)parama.ebF().signature))
    {
      parama = (a.j.b.a.a.d)a.j.b.a.a.i.BRc;
      AppMethodBeat.o(118870);
      return parama;
    }
    t.a locala = new t.a(parama);
    Object localObject2 = new t.c(parama, paramBoolean, new t.b(parama), locala);
    localObject1 = ad.BQq;
    d locald = ad.c(parama.ebF().ebO());
    if ((locald instanceof d.c))
    {
      localObject1 = ((d.c)locald).BOb;
      if (paramBoolean) {
        if (((b.e)localObject1).elx())
        {
          localObject1 = ((b.e)localObject1).CpG;
          if (localObject1 == null) {
            break label259;
          }
          localObject1 = parama.ebF().BPf.H(((d.c)locald).BOc.getString(((b.c)localObject1).ClT), ((d.c)locald).BOc.getString(((b.c)localObject1).CpB), af.c((b)parama.ebP()));
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = parama.ebF().ebM();
          if (localObject1 == null)
          {
            parama = (Throwable)new x("No accessors or field is found for property " + parama.ebF());
            AppMethodBeat.o(118870);
            throw parama;
            localObject1 = null;
            break;
            if (((b.e)localObject1).ely())
            {
              localObject1 = ((b.e)localObject1).CpH;
              break;
            }
            localObject1 = null;
            break;
            label259:
            localObject1 = null;
            continue;
          }
          localObject1 = ((t.c)localObject2).d((Field)localObject1);
        }
      }
    }
    for (;;)
    {
      parama = h.a((e)localObject1, (b)parama.ebP());
      AppMethodBeat.o(118870);
      return parama;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.ebF().isBound()) {}
        for (localObject1 = (e.f)new e.f.a((Method)localObject1, parama.ebF().BPg);; localObject1 = (e.f)new e.f.d((Method)localObject1))
        {
          localObject1 = (e)localObject1;
          break;
        }
      }
      if (locala.gg())
      {
        if (parama.ebF().isBound()) {}
        for (localObject1 = (e.f)new e.f.b((Method)localObject1);; localObject1 = (e.f)new e.f.e((Method)localObject1))
        {
          localObject1 = (e)localObject1;
          break;
        }
      }
      if (parama.ebF().isBound()) {}
      for (localObject1 = (e.f)new e.f.c((Method)localObject1, parama.ebF().BPg);; localObject1 = (e.f)new e.f.f((Method)localObject1))
      {
        localObject1 = (e)localObject1;
        break;
      }
      if (!(locald instanceof d.a)) {
        break;
      }
      localObject1 = ((t.c)localObject2).d(((d.a)locald).erN);
    }
    if ((locald instanceof d.b)) {
      if (paramBoolean) {
        localObject1 = ((d.b)locald).BNX;
      }
    }
    label898:
    for (;;)
    {
      if (parama.ebF().isBound()) {}
      for (localObject1 = (e.f)new e.f.a((Method)localObject1, parama.ebF().BPg);; localObject1 = (e.f)new e.f.d((Method)localObject1))
      {
        localObject1 = (e)localObject1;
        break;
        localObject1 = ((d.b)locald).BNY;
        if (localObject1 != null) {
          break label898;
        }
        parama = (Throwable)new x("No source found for setter of Java method property: " + ((d.b)locald).BNX);
        AppMethodBeat.o(118870);
        throw parama;
      }
      if ((locald instanceof d.d))
      {
        if (paramBoolean) {
          localObject1 = ((d.d)locald).BOe;
        }
        do
        {
          localObject1 = parama.ebF().BPf.H(((c.e)localObject1).BNW.name, ((c.e)localObject1).BNW.desc, af.c((b)parama.ebP()));
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new x("No accessor found for property " + parama.ebF());
          AppMethodBeat.o(118870);
          throw parama;
          localObject2 = ((d.d)locald).BOf;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new x("No setter found for property " + parama.ebF());
        AppMethodBeat.o(118870);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (aa.BMh) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.ebF());
          AppMethodBeat.o(118870);
          throw parama;
        }
        if (parama.ebF().isBound())
        {
          parama = (a.j.b.a.a.d)new e.f.a((Method)localObject1, parama.ebF().BPg);
          AppMethodBeat.o(118870);
          return parama;
        }
        parama = (a.j.b.a.a.d)new e.f.d((Method)localObject1);
        AppMethodBeat.o(118870);
        return parama;
      }
      parama = new m();
      AppMethodBeat.o(118870);
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.t
 * JD-Core Version:    0.7.0.1
 */