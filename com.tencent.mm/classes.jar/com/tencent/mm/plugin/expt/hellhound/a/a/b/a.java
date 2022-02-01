package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int qTW = 0;
  
  private static List<av> a(av paramav)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramav.RD().getBytes();
    if (localObject3.length <= 5120)
    {
      paramav.dXu = 0;
      paramav.dXv = 1;
      localArrayList.add(paramav);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramav.dXr;
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
        ad.printErrStackTrace("HABBYGE-MALI.FinderReport", localException, "finder, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        localObject3 = new av();
        ((av)localObject3).dXl = paramav.dXl;
        ((av)localObject3).iq(paramav.dXm);
        ((av)localObject3).ir(paramav.dXn);
        ((av)localObject3).is(paramav.dXx);
        ((av)localObject3).it(paramav.dXy);
        ((av)localObject3).dXo = paramav.dXo;
        ((av)localObject3).dXp = paramav.dXp;
        ((av)localObject3).dXq = paramav.dXq;
        ((av)localObject3).dXt = paramav.dXt;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((av)localObject3).dXr = localJSONArray.toString();
        ((av)localObject3).dXs = localJSONArray.length();
        ((av)localObject3).dXu = k;
        ((av)localObject3).dXv = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new av();
        ((av)localObject3).dXl = paramav.dXl;
        ((av)localObject3).iq(paramav.dXm);
        ((av)localObject3).ir(paramav.dXn);
        ((av)localObject3).is(paramav.dXx);
        ((av)localObject3).it(paramav.dXy);
        ((av)localObject3).dXo = paramav.dXo;
        ((av)localObject3).dXp = paramav.dXp;
        ((av)localObject3).dXq = paramav.dXq;
        ((av)localObject3).dXt = paramav.dXt;
        paramav = new JSONArray();
        while (i < n)
        {
          paramav.put(localObject2.opt(i));
          i += 1;
        }
        ((av)localObject3).dXr = paramav.toString();
        ((av)localObject3).dXs = paramav.length();
        ((av)localObject3).dXu = k;
        ((av)localObject3).dXv = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(dhc paramdhc, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramdhc == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    av localav1 = new av();
    localav1.dXl = Process.myPid();
    av localav2 = localav1.iq(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName).ir(paramdhc.dyV).is(paramdhc.dxa).it(paramdhc.HvD);
    localav2.dXo = paramdhc.Hvz;
    localav2.dXp = paramdhc.HvA;
    localav2.dXq = paramdhc.HvB;
    localav2.dXr = ((String)paramc.get(0));
    localav2.dXs = ((Integer)paramc.get(1)).intValue();
    int i = qTW;
    qTW = i + 1;
    localav2.dXt = i;
    paramdhc = a(localav1);
    if (paramdhc == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramdhc = paramdhc.iterator();
    while (paramdhc.hasNext())
    {
      paramc = (av)paramdhc.next();
      paramc.dXr = paramc.dXr.replace(",", "#");
      paramc.aLk();
      ad.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.RD() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */