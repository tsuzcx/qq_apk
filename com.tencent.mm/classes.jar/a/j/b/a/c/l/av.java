package a.j.b.a.c.l;

import a.a.j;
import a.f.a.b;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.l.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class av
{
  public static final ad CBS;
  public static final ad CBT;
  public static final ad CBU;
  public static final ad CBV;
  
  static
  {
    AppMethodBeat.i(122700);
    if (!av.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CBS = p.azk("DONT_CARE");
      CBT = p.azj("Cannot be inferred");
      CBU = new av.a("NO_EXPECTED_TYPE");
      CBV = new av.a("UNIT_EXPECTED_TYPE");
      AppMethodBeat.o(122700);
      return;
    }
  }
  
  public static ad a(a.j.b.a.c.b.h paramh, a.j.b.a.c.i.e.h paramh1)
  {
    AppMethodBeat.i(122691);
    if (p.L(paramh))
    {
      paramh = p.azj("Unsubstituted type for ".concat(String.valueOf(paramh)));
      AppMethodBeat.o(122691);
      return paramh;
    }
    paramh = paramh.ecx();
    List localList = gh(paramh.getParameters());
    g.a locala = a.j.b.a.c.b.a.g.BXx;
    paramh = x.a(g.a.eeH(), paramh, localList, false, paramh1);
    AppMethodBeat.o(122691);
    return paramh;
  }
  
  public static w a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(122689);
    paramw = paramw.eoL().sr(paramBoolean);
    AppMethodBeat.o(122689);
    return paramw;
  }
  
  public static w aA(w paramw)
  {
    AppMethodBeat.i(122688);
    paramw = a(paramw, false);
    AppMethodBeat.o(122688);
    return paramw;
  }
  
  public static boolean aB(w paramw)
  {
    AppMethodBeat.i(122693);
    if (paramw.egH())
    {
      AppMethodBeat.o(122693);
      return true;
    }
    if ((t.ai(paramw)) && (aB(t.aj(paramw).CBn)))
    {
      AppMethodBeat.o(122693);
      return true;
    }
    if (aE(paramw))
    {
      if (!(paramw.enU().ecR() instanceof e))
      {
        au localau = au.aw(paramw);
        Object localObject = paramw.enU().eeO();
        ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
        Iterator localIterator = ((Collection)localObject).iterator();
        label164:
        while (localIterator.hasNext())
        {
          localObject = localau.c((w)localIterator.next(), ba.CBX);
          if (localObject != null) {}
          for (localObject = b((w)localObject, paramw.egH());; localObject = null)
          {
            if (localObject == null) {
              break label164;
            }
            localArrayList.add(localObject);
            break;
          }
        }
        paramw = localArrayList.iterator();
        while (paramw.hasNext()) {
          if (aB((w)paramw.next()))
          {
            AppMethodBeat.o(122693);
            return true;
          }
        }
      }
      AppMethodBeat.o(122693);
      return false;
    }
    paramw = paramw.enU();
    if ((paramw instanceof v))
    {
      paramw = paramw.eeO().iterator();
      while (paramw.hasNext()) {
        if (aB((w)paramw.next()))
        {
          AppMethodBeat.o(122693);
          return true;
        }
      }
    }
    AppMethodBeat.o(122693);
    return false;
  }
  
  public static boolean aC(w paramw)
  {
    AppMethodBeat.i(122694);
    if (paramw.egH())
    {
      AppMethodBeat.o(122694);
      return true;
    }
    if ((t.ai(paramw)) && (aC(t.aj(paramw).CBn)))
    {
      AppMethodBeat.o(122694);
      return true;
    }
    AppMethodBeat.o(122694);
    return false;
  }
  
  public static e aD(w paramw)
  {
    AppMethodBeat.i(122695);
    paramw = paramw.enU().ecR();
    if ((paramw instanceof e))
    {
      paramw = (e)paramw;
      AppMethodBeat.o(122695);
      return paramw;
    }
    AppMethodBeat.o(122695);
    return null;
  }
  
  public static boolean aE(w paramw)
  {
    AppMethodBeat.i(122698);
    if ((aF(paramw) != null) || ((paramw.enU() instanceof k)))
    {
      AppMethodBeat.o(122698);
      return true;
    }
    AppMethodBeat.o(122698);
    return false;
  }
  
  private static a.j.b.a.c.b.ar aF(w paramw)
  {
    AppMethodBeat.i(122699);
    if ((paramw.enU().ecR() instanceof a.j.b.a.c.b.ar))
    {
      paramw = (a.j.b.a.c.b.ar)paramw.enU().ecR();
      AppMethodBeat.o(122699);
      return paramw;
    }
    AppMethodBeat.o(122699);
    return null;
  }
  
  public static boolean ax(w paramw)
  {
    return (paramw == CBU) || (paramw == CBV);
  }
  
  public static boolean ay(w paramw)
  {
    AppMethodBeat.i(122686);
    if ((paramw != null) && (paramw.enU() == CBS.enU()))
    {
      AppMethodBeat.o(122686);
      return true;
    }
    AppMethodBeat.o(122686);
    return false;
  }
  
  public static w az(w paramw)
  {
    AppMethodBeat.i(122687);
    paramw = a(paramw, true);
    AppMethodBeat.o(122687);
    return paramw;
  }
  
  public static w b(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(122690);
    if (paramBoolean)
    {
      paramw = a(paramw, true);
      AppMethodBeat.o(122690);
      return paramw;
    }
    AppMethodBeat.o(122690);
    return paramw;
  }
  
  public static boolean b(w paramw, b<az, Boolean> paramb)
  {
    AppMethodBeat.i(122696);
    if (paramw == null)
    {
      AppMethodBeat.o(122696);
      return false;
    }
    az localaz = paramw.eoL();
    if (((Boolean)paramb.S(localaz)).booleanValue())
    {
      AppMethodBeat.o(122696);
      return true;
    }
    if ((localaz instanceof q)) {}
    for (Object localObject = (q)localaz; (localObject != null) && ((b(((q)localObject).CBm, paramb)) || (b(((q)localObject).CBn, paramb))); localObject = null)
    {
      AppMethodBeat.o(122696);
      return true;
    }
    if (((localaz instanceof g)) && (b(((g)localaz).CAW, paramb)))
    {
      AppMethodBeat.o(122696);
      return true;
    }
    localObject = paramw.enU();
    if ((localObject instanceof v))
    {
      paramw = ((v)localObject).CBw.iterator();
      while (paramw.hasNext()) {
        if (b((w)paramw.next(), paramb))
        {
          AppMethodBeat.o(122696);
          return true;
        }
      }
      AppMethodBeat.o(122696);
      return false;
    }
    paramw = paramw.enR().iterator();
    while (paramw.hasNext())
    {
      localObject = (ap)paramw.next();
      if ((!((ap)localObject).eoN()) && (b(((ap)localObject).eer(), paramb)))
      {
        AppMethodBeat.o(122696);
        return true;
      }
    }
    AppMethodBeat.o(122696);
    return false;
  }
  
  public static ap e(a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(122697);
    paramar = new ah(paramar);
    AppMethodBeat.o(122697);
    return paramar;
  }
  
  public static List<ap> gh(List<a.j.b.a.c.b.ar> paramList)
  {
    AppMethodBeat.i(122692);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ar(((a.j.b.a.c.b.ar)paramList.next()).edE()));
    }
    paramList = j.m(localArrayList);
    AppMethodBeat.o(122692);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.av
 * JD-Core Version:    0.7.0.1
 */