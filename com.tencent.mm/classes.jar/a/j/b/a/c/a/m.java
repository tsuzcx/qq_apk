package a.j.b.a.c.a;

import a.j.b.a.c.b.ab;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class m
{
  private static final Set<f> BUq;
  private static final HashMap<a, a> BUr;
  private static final HashMap<a, a> BUs;
  private static final Set<f> BUt;
  public static final m BUu;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(119123);
    BUu = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].BTN);
      i += 1;
    }
    BUq = a.a.j.o((Iterable)localObject);
    BUr = new HashMap();
    BUs = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].BUo.CqB.CqE.emh());
      i += 1;
    }
    BUt = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)BUr).put(((l)localObject).BUo, ((l)localObject).BUp);
      ((Map)BUs).put(((l)localObject).BUp, ((l)localObject).BUo);
      i += 1;
    }
    AppMethodBeat.o(119123);
  }
  
  public static boolean G(w paramw)
  {
    AppMethodBeat.i(119122);
    a.f.b.j.q(paramw, "type");
    if (av.ax(paramw))
    {
      AppMethodBeat.o(119122);
      return false;
    }
    paramw = paramw.enU().ecR();
    if (paramw == null)
    {
      AppMethodBeat.o(119122);
      return false;
    }
    a.f.b.j.p(paramw, "type.constructor.declara…escriptor ?: return false");
    paramw = (a.j.b.a.c.b.l)paramw;
    a.f.b.j.q(paramw, "descriptor");
    a.j.b.a.c.b.l locall = paramw.ecv();
    if (((locall instanceof ab)) && (a.f.b.j.e(((ab)locall).eee(), g.BRJ)) && (BUq.contains(paramw.edF())))
    {
      AppMethodBeat.o(119122);
      return true;
    }
    AppMethodBeat.o(119122);
    return false;
  }
  
  public static a c(a parama)
  {
    AppMethodBeat.i(119120);
    a.f.b.j.q(parama, "arrayClassId");
    parama = (a)BUr.get(parama);
    AppMethodBeat.o(119120);
    return parama;
  }
  
  public static a d(a parama)
  {
    AppMethodBeat.i(119121);
    a.f.b.j.q(parama, "arrayClassId");
    parama = (a)BUs.get(parama);
    AppMethodBeat.o(119121);
    return parama;
  }
  
  public static boolean d(f paramf)
  {
    AppMethodBeat.i(119119);
    a.f.b.j.q(paramf, "name");
    boolean bool = BUt.contains(paramf);
    AppMethodBeat.o(119119);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.a.m
 * JD-Core Version:    0.7.0.1
 */