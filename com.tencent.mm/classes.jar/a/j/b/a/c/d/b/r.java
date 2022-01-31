package a.j.b.a.c.d.b;

import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.ai;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.e;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.d.c;
import a.j.b.a.c.l.av;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class r
{
  public static final j V(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(120305);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = (j)y.a(paramw, (k)l.Cjt, w.CjK, (u)v.Cjz);
    AppMethodBeat.o(120305);
    return paramw;
  }
  
  private static String a(a.j.b.a.c.b.t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120300);
    a.f.b.j.q(paramt, "receiver$0");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if (paramBoolean2)
    {
      if (!(paramt instanceof a.j.b.a.c.b.k)) {
        break label119;
      }
      localObject1 = "<init>";
    }
    Object localObject2;
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("(");
      localObject1 = paramt.edu().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (au)((Iterator)localObject1).next();
        a.f.b.j.p(localObject2, "parameter");
        localObject2 = ((au)localObject2).eer();
        a.f.b.j.p(localObject2, "parameter.type");
        a(localStringBuilder, (a.j.b.a.c.l.w)localObject2);
      }
      label119:
      localObject1 = paramt.edF().name;
      a.f.b.j.p(localObject1, "name.asString()");
    }
    localStringBuilder.append(")");
    int i;
    if (paramBoolean1)
    {
      localObject1 = (a.j.b.a.c.b.a)paramt;
      a.f.b.j.q(localObject1, "descriptor");
      if (!(localObject1 instanceof a.j.b.a.c.b.k)) {
        break label206;
      }
      i = 1;
      if (i == 0) {
        break label274;
      }
      localStringBuilder.append("V");
    }
    for (;;)
    {
      paramt = localStringBuilder.toString();
      a.f.b.j.p(paramt, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(120300);
      return paramt;
      label206:
      localObject2 = ((a.j.b.a.c.b.a)localObject1).eds();
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      if (g.D((a.j.b.a.c.l.w)localObject2))
      {
        localObject2 = ((a.j.b.a.c.b.a)localObject1).eds();
        if (localObject2 == null) {
          a.f.b.j.ebi();
        }
        if ((!av.aB((a.j.b.a.c.l.w)localObject2)) && (!(localObject1 instanceof ai)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      label274:
      paramt = paramt.eds();
      if (paramt == null) {
        a.f.b.j.ebi();
      }
      a.f.b.j.p(paramt, "returnType!!");
      a(localStringBuilder, paramt);
    }
  }
  
  private static final void a(StringBuilder paramStringBuilder, a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(120304);
    paramStringBuilder.append(V(paramw));
    AppMethodBeat.o(120304);
  }
  
  public static final boolean b(a.j.b.a.c.b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120302);
    a.f.b.j.q(parama, "f");
    if (!(parama instanceof a.j.b.a.c.b.t))
    {
      AppMethodBeat.o(120302);
      return false;
    }
    if ((((a.j.b.a.c.b.t)parama).edu().size() != 1) || (a.j.b.a.c.d.a.t.s((a.j.b.a.c.b.b)parama)) || ((a.f.b.j.e(((a.j.b.a.c.b.t)parama).edF().name, "remove") ^ true)))
    {
      AppMethodBeat.o(120302);
      return false;
    }
    Object localObject1 = ((a.j.b.a.c.b.t)parama).edO();
    a.f.b.j.p(localObject1, "f.original");
    localObject1 = ((a.j.b.a.c.b.t)localObject1).edu();
    a.f.b.j.p(localObject1, "f.original.valueParameters");
    localObject1 = a.a.j.fU((List)localObject1);
    a.f.b.j.p(localObject1, "f.original.valueParameters.single()");
    localObject1 = ((au)localObject1).eer();
    a.f.b.j.p(localObject1, "f.original.valueParameters.single().type");
    Object localObject3 = V((a.j.b.a.c.l.w)localObject1);
    localObject1 = localObject3;
    if (!(localObject3 instanceof j.c)) {
      localObject1 = null;
    }
    localObject3 = (j.c)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((j.c)localObject3).Cjs;
    }
    if (localObject1 != c.CwX)
    {
      AppMethodBeat.o(120302);
      return false;
    }
    parama = a.j.b.a.c.d.a.d.e((a.j.b.a.c.b.t)parama);
    if (parama == null)
    {
      AppMethodBeat.o(120302);
      return false;
    }
    localObject1 = parama.edO();
    a.f.b.j.p(localObject1, "overridden.original");
    localObject1 = ((a.j.b.a.c.b.t)localObject1).edu();
    a.f.b.j.p(localObject1, "overridden.original.valueParameters");
    localObject1 = a.a.j.fU((List)localObject1);
    a.f.b.j.p(localObject1, "overridden.original.valueParameters.single()");
    localObject1 = ((au)localObject1).eer();
    a.f.b.j.p(localObject1, "overridden.original.valueParameters.single().type");
    localObject1 = V((a.j.b.a.c.l.w)localObject1);
    parama = parama.ecv();
    a.f.b.j.p(parama, "overridden.containingDeclaration");
    if ((a.f.b.j.e(a.j.b.a.c.i.c.a.q(parama), g.BRU.BSW.CqE)) && ((localObject1 instanceof j.b)) && (a.f.b.j.e(((j.b)localObject1).Cjr, "java/lang/Object")))
    {
      AppMethodBeat.o(120302);
      return true;
    }
    AppMethodBeat.o(120302);
    return false;
  }
  
  public static final String c(a.j.b.a.c.b.a parama)
  {
    AppMethodBeat.i(120303);
    a.f.b.j.q(parama, "receiver$0");
    Object localObject1 = t.Cjx;
    if (a.j.b.a.c.i.d.m((a.j.b.a.c.b.l)parama))
    {
      AppMethodBeat.o(120303);
      return null;
    }
    Object localObject2 = parama.ecv();
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    if (localObject2 == null)
    {
      AppMethodBeat.o(120303);
      return null;
    }
    localObject1 = ((e)localObject2).edF();
    a.f.b.j.p(localObject1, "classDescriptor.name");
    if (((f)localObject1).CqN)
    {
      AppMethodBeat.o(120303);
      return null;
    }
    localObject1 = parama.edt();
    parama = (a.j.b.a.c.b.a)localObject1;
    if (!(localObject1 instanceof al)) {
      parama = null;
    }
    parama = (al)parama;
    if (parama == null)
    {
      AppMethodBeat.o(120303);
      return null;
    }
    parama = t.a((e)localObject2, a((a.j.b.a.c.b.t)parama, false, false, 3));
    AppMethodBeat.o(120303);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.b.r
 * JD-Core Version:    0.7.0.1
 */