package a.j.b.a.c.d.a;

import a.a.v;
import a.j.b.a.c.k.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private final d<a.j.b.a.c.b.e, a.j.b.a.c.b.a.c> CbR;
  public final a.j.b.a.c.n.e CbS;
  public final boolean tXR;
  
  public a(a.j.b.a.c.k.i parami, a.j.b.a.c.n.e parame)
  {
    AppMethodBeat.i(119655);
    this.CbS = parame;
    this.CbR = parami.j((a.f.a.b)new a.c((a)this));
    this.tXR = this.CbS.eoV();
    AppMethodBeat.o(119655);
  }
  
  private final List<a.a> a(a.j.b.a.c.i.b.f<?> paramf)
  {
    AppMethodBeat.i(119654);
    if ((paramf instanceof a.j.b.a.c.i.b.b))
    {
      Object localObject = (Iterable)((a.j.b.a.c.i.b.b)paramf).getValue();
      paramf = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a.a.j.a(paramf, (Iterable)a((a.j.b.a.c.i.b.f)((Iterator)localObject).next()));
      }
      paramf = (List)paramf;
      AppMethodBeat.o(119654);
      return paramf;
    }
    if ((paramf instanceof a.j.b.a.c.i.b.i))
    {
      paramf = ((a.j.b.a.c.i.b.i)paramf).CwH.emk();
      switch (paramf.hashCode())
      {
      default: 
        paramf = null;
      }
      for (;;)
      {
        paramf = a.a.j.df(paramf);
        AppMethodBeat.o(119654);
        return paramf;
        if (!paramf.equals("FIELD")) {
          break;
        }
        paramf = a.a.CbV;
        continue;
        if (!paramf.equals("METHOD")) {
          break;
        }
        paramf = a.a.CbT;
        continue;
        if (!paramf.equals("TYPE_USE")) {
          break;
        }
        paramf = a.a.CbW;
        continue;
        if (!paramf.equals("PARAMETER")) {
          break;
        }
        paramf = a.a.CbU;
      }
    }
    paramf = (List)v.BMx;
    AppMethodBeat.o(119654);
    return paramf;
  }
  
  private final a.j.b.a.c.n.g q(a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(119653);
    parame = parame.ecM().i(b.efs());
    if (parame != null) {}
    for (parame = a.j.b.a.c.i.c.a.m(parame);; parame = null)
    {
      localObject = parame;
      if (!(parame instanceof a.j.b.a.c.i.b.i)) {
        localObject = null;
      }
      parame = (a.j.b.a.c.i.b.i)localObject;
      if (parame != null) {
        break;
      }
      AppMethodBeat.o(119653);
      return null;
    }
    Object localObject = this.CbS.CEQ;
    if (localObject != null)
    {
      AppMethodBeat.o(119653);
      return localObject;
    }
    parame = parame.CwH.name;
    switch (parame.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(119653);
          return null;
        } while (!parame.equals("STRICT"));
        parame = a.j.b.a.c.n.g.CFb;
        AppMethodBeat.o(119653);
        return parame;
      } while (!parame.equals("IGNORE"));
      parame = a.j.b.a.c.n.g.CEZ;
      AppMethodBeat.o(119653);
      return parame;
    } while (!parame.equals("WARN"));
    parame = a.j.b.a.c.n.g.CFa;
    AppMethodBeat.o(119653);
    return parame;
  }
  
  public final a.j.b.a.c.b.a.c d(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(119649);
    a.f.b.j.q(paramc, "annotationDescriptor");
    if (this.CbS.eoV())
    {
      AppMethodBeat.o(119649);
      return null;
    }
    a.j.b.a.c.b.e locale = a.j.b.a.c.i.c.a.l(paramc);
    if (locale == null)
    {
      AppMethodBeat.o(119649);
      return null;
    }
    if (b.r(locale))
    {
      AppMethodBeat.o(119649);
      return paramc;
    }
    if (locale.ecB() != a.j.b.a.c.b.f.BWj)
    {
      AppMethodBeat.o(119649);
      return null;
    }
    paramc = (a.j.b.a.c.b.a.c)this.CbR.S(locale);
    AppMethodBeat.o(119649);
    return paramc;
  }
  
  public final a.b e(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(119650);
    a.f.b.j.q(paramc, "annotationDescriptor");
    if (this.CbS.eoV())
    {
      AppMethodBeat.o(119650);
      return null;
    }
    Object localObject1 = a.j.b.a.c.i.c.a.l(paramc);
    if (localObject1 != null) {
      if (!((a.j.b.a.c.b.e)localObject1).ecM().j(b.efr())) {
        break label69;
      }
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(119650);
      return null;
      label69:
      localObject1 = null;
    }
    paramc = a.j.b.a.c.i.c.a.l(paramc);
    if (paramc == null) {
      a.f.b.j.ebi();
    }
    paramc = paramc.ecM().i(b.efr());
    if (paramc == null) {
      a.f.b.j.ebi();
    }
    paramc = paramc.eeG();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      paramc = (a.j.b.a.c.f.f)((Map.Entry)localObject2).getKey();
      localObject2 = (a.j.b.a.c.i.b.f)((Map.Entry)localObject2).getValue();
      if (a.f.b.j.e(paramc, p.Cdb)) {}
      for (paramc = a((a.j.b.a.c.i.b.f)localObject2);; paramc = (List)v.BMx)
      {
        a.a.j.a(localCollection, (Iterable)paramc);
        break;
      }
    }
    paramc = ((Iterable)localCollection).iterator();
    for (int i = 0; paramc.hasNext(); i = 1 << ((a.a)paramc.next()).ordinal() | i) {}
    localObject1 = ((Iterable)((a.j.b.a.c.b.e)localObject1).ecM()).iterator();
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      paramc = ((Iterator)localObject1).next();
      if (d((a.j.b.a.c.b.a.c)paramc) != null)
      {
        j = 1;
        label319:
        if (j == 0) {
          break label342;
        }
      }
    }
    for (;;)
    {
      paramc = (a.j.b.a.c.b.a.c)paramc;
      if (paramc != null) {
        break label349;
      }
      AppMethodBeat.o(119650);
      return null;
      j = 0;
      break label319;
      label342:
      break;
      paramc = null;
    }
    label349:
    paramc = new a.b(paramc, i);
    AppMethodBeat.o(119650);
    return paramc;
  }
  
  public final a.j.b.a.c.n.g f(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(119651);
    a.f.b.j.q(paramc, "annotationDescriptor");
    paramc = g(paramc);
    if (paramc != null)
    {
      AppMethodBeat.o(119651);
      return paramc;
    }
    paramc = this.CbS.CEP;
    AppMethodBeat.o(119651);
    return paramc;
  }
  
  public final a.j.b.a.c.n.g g(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(119652);
    a.f.b.j.q(paramc, "annotationDescriptor");
    Map localMap = this.CbS.CER;
    Object localObject = paramc.eee();
    if (localObject != null) {}
    for (localObject = ((a.j.b.a.c.f.b)localObject).CqE.CqJ;; localObject = null)
    {
      localObject = (a.j.b.a.c.n.g)localMap.get(localObject);
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(119652);
      return localObject;
    }
    paramc = a.j.b.a.c.i.c.a.l(paramc);
    if (paramc != null)
    {
      paramc = q(paramc);
      AppMethodBeat.o(119652);
      return paramc;
    }
    AppMethodBeat.o(119652);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.a
 * JD-Core Version:    0.7.0.1
 */