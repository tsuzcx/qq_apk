package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int pGg = 0;
  
  private static List<ab> a(ab paramab)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramab.PV().getBytes();
    if (localObject3.length <= 5120)
    {
      paramab.dKD = 0;
      paramab.dKE = 1;
      localArrayList.add(paramab);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramab.dKA;
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
        localObject3 = new ab();
        ((ab)localObject3).dKu = paramab.dKu;
        ((ab)localObject3).gA(paramab.dKv);
        ((ab)localObject3).gB(paramab.dKw);
        ((ab)localObject3).gC(paramab.dKG);
        ((ab)localObject3).gD(paramab.dKH);
        ((ab)localObject3).dKx = paramab.dKx;
        ((ab)localObject3).dKy = paramab.dKy;
        ((ab)localObject3).dKz = paramab.dKz;
        ((ab)localObject3).dKC = paramab.dKC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((ab)localObject3).dKA = localJSONArray.toString();
        ((ab)localObject3).dKB = localJSONArray.length();
        ((ab)localObject3).dKD = k;
        ((ab)localObject3).dKE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new ab();
        ((ab)localObject3).dKu = paramab.dKu;
        ((ab)localObject3).gA(paramab.dKv);
        ((ab)localObject3).gB(paramab.dKw);
        ((ab)localObject3).gC(paramab.dKG);
        ((ab)localObject3).gD(paramab.dKH);
        ((ab)localObject3).dKx = paramab.dKx;
        ((ab)localObject3).dKy = paramab.dKy;
        ((ab)localObject3).dKz = paramab.dKz;
        ((ab)localObject3).dKC = paramab.dKC;
        paramab = new JSONArray();
        while (i < n)
        {
          paramab.put(localObject2.opt(i));
          i += 1;
        }
        ((ab)localObject3).dKA = paramab.toString();
        ((ab)localObject3).dKB = paramab.length();
        ((ab)localObject3).dKD = k;
        ((ab)localObject3).dKE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(cwd paramcwd, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramcwd == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    ab localab1 = new ab();
    localab1.dKu = Process.myPid();
    ab localab2 = localab1.gA(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName).gB(paramcwd.dpw).gC(paramcwd.dnF).gD(paramcwd.EnW);
    localab2.dKx = paramcwd.EnS;
    localab2.dKy = paramcwd.EnT;
    localab2.dKz = paramcwd.EnU;
    localab2.dKA = ((String)paramc.get(0));
    localab2.dKB = ((Integer)paramc.get(1)).intValue();
    int i = pGg;
    pGg = i + 1;
    localab2.dKC = i;
    paramcwd = a(localab1);
    if (paramcwd == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramcwd = paramcwd.iterator();
    while (paramcwd.hasNext())
    {
      paramc = (ab)paramcwd.next();
      paramc.dKA = paramc.dKA.replace(",", "#");
      paramc.aBj();
      ad.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.PV() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */