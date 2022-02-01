package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int qla = 0;
  
  private static List<al> a(al paramal)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramal.PR().getBytes();
    if (localObject3.length <= 5120)
    {
      paramal.dJD = 0;
      paramal.dJE = 1;
      localArrayList.add(paramal);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramal.dJA;
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(169319);
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FinderReport", localException, "finder, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
        localObject2 = null;
      }
      int n = localObject2.length();
      double d = Math.ceil(localObject3.length / 5120.0D);
      int i1 = n / (int)d;
      int i2 = n % (int)d;
      int i = (int)d;
      int j = i;
      if (i2 > 0) {
        j = i + 1;
      }
      int k = 0;
      i = 0;
      int m = 0;
      while (m < d)
      {
        localObject3 = new al();
        ((al)localObject3).dJu = paramal.dJu;
        ((al)localObject3).gZ(paramal.dJv);
        ((al)localObject3).ha(paramal.dJw);
        ((al)localObject3).hb(paramal.dJG);
        ((al)localObject3).hc(paramal.dJH);
        ((al)localObject3).dJx = paramal.dJx;
        ((al)localObject3).dJy = paramal.dJy;
        ((al)localObject3).dJz = paramal.dJz;
        ((al)localObject3).dJC = paramal.dJC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((al)localObject3).dJA = localJSONArray.toString();
        ((al)localObject3).dJB = localJSONArray.length();
        ((al)localObject3).dJD = k;
        ((al)localObject3).dJE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new al();
        ((al)localObject3).dJu = paramal.dJu;
        ((al)localObject3).gZ(paramal.dJv);
        ((al)localObject3).ha(paramal.dJw);
        ((al)localObject3).hb(paramal.dJG);
        ((al)localObject3).hc(paramal.dJH);
        ((al)localObject3).dJx = paramal.dJx;
        ((al)localObject3).dJy = paramal.dJy;
        ((al)localObject3).dJz = paramal.dJz;
        ((al)localObject3).dJC = paramal.dJC;
        paramal = new JSONArray();
        while (i < n)
        {
          paramal.put(localObject2.opt(i));
          i += 1;
        }
        ((al)localObject3).dJA = paramal.toString();
        ((al)localObject3).dJB = paramal.length();
        ((al)localObject3).dJD = k;
        ((al)localObject3).dJE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(dbp paramdbp, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramdbp == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    al localal1 = new al();
    localal1.dJu = Process.myPid();
    al localal2 = localal1.gZ(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName).ha(paramdbp.dnh).hb(paramdbp.dln).hc(paramdbp.FKV);
    localal2.dJx = paramdbp.FKR;
    localal2.dJy = paramdbp.FKS;
    localal2.dJz = paramdbp.FKT;
    localal2.dJA = ((String)paramc.get(0));
    localal2.dJB = ((Integer)paramc.get(1)).intValue();
    int i = qla;
    qla = i + 1;
    localal2.dJC = i;
    paramdbp = a(localal1);
    if (paramdbp == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramdbp = paramdbp.iterator();
    while (paramdbp.hasNext())
    {
      paramc = (al)paramdbp.next();
      paramc.dJA = paramc.dJA.replace(",", "#");
      paramc.aHZ();
      ac.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.PR() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */