package a.j.b.a.c.l;

import a.j.b.a.c.b.am;
import a.j.b.a.c.b.c.ah;
import a.j.b.a.c.b.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
{
  public static au a(List<a.j.b.a.c.b.ar> paramList1, as paramas, l paraml, List<a.j.b.a.c.b.ar> paramList2)
  {
    AppMethodBeat.i(122517);
    paramList1 = a(paramList1, paramas, paraml, paramList2, null);
    if (paramList1 == null)
    {
      paramList1 = new AssertionError("Substitution failed");
      AppMethodBeat.o(122517);
      throw paramList1;
    }
    AppMethodBeat.o(122517);
    return paramList1;
  }
  
  public static au a(List<a.j.b.a.c.b.ar> paramList1, as paramas, l paraml, List<a.j.b.a.c.b.ar> paramList2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(122518);
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.j.b.a.c.b.ar localar = (a.j.b.a.c.b.ar)((Iterator)localObject2).next();
      ah localah = ah.a(paraml, localar.ecM(), localar.edH(), localar.edG(), localar.edF(), i, am.BWF);
      ((Map)localObject1).put(localar.ecx(), new ar(localah.edE()));
      localHashMap.put(localar, localah);
      paramList2.add(localah);
      i += 1;
    }
    paramas = au.b(paramas, ao.bc((Map)localObject1));
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (a.j.b.a.c.b.ar)paramList1.next();
      paraml = (ah)localHashMap.get(paramList2);
      paramList2 = paramList2.ebo().iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (w)paramList2.next();
        localObject2 = paramas.c((w)localObject1, ba.CBY);
        if (localObject2 == null)
        {
          AppMethodBeat.o(122518);
          return null;
        }
        if ((localObject2 != localObject1) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        paraml.L((w)localObject2);
      }
      paraml.setInitialized();
    }
    AppMethodBeat.o(122518);
    return paramas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.l.k
 * JD-Core Version:    0.7.0.1
 */