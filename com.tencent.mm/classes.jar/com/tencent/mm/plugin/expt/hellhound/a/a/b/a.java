package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int rbU = 0;
  
  private static List<av> a(av paramav)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramav.RC().getBytes();
    if (localObject3.length <= 5120)
    {
      paramav.dYL = 0;
      paramav.dYM = 1;
      localArrayList.add(paramav);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramav.dYI;
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
        ae.printErrStackTrace("HABBYGE-MALI.FinderReport", localException, "finder, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        ((av)localObject3).dYC = paramav.dYC;
        ((av)localObject3).iA(paramav.dYD);
        ((av)localObject3).iB(paramav.dYE);
        ((av)localObject3).iC(paramav.dYO);
        ((av)localObject3).iD(paramav.dYP);
        ((av)localObject3).dYF = paramav.dYF;
        ((av)localObject3).dYG = paramav.dYG;
        ((av)localObject3).dYH = paramav.dYH;
        ((av)localObject3).dYK = paramav.dYK;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((av)localObject3).dYI = localJSONArray.toString();
        ((av)localObject3).dYJ = localJSONArray.length();
        ((av)localObject3).dYL = k;
        ((av)localObject3).dYM = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new av();
        ((av)localObject3).dYC = paramav.dYC;
        ((av)localObject3).iA(paramav.dYD);
        ((av)localObject3).iB(paramav.dYE);
        ((av)localObject3).iC(paramav.dYO);
        ((av)localObject3).iD(paramav.dYP);
        ((av)localObject3).dYF = paramav.dYF;
        ((av)localObject3).dYG = paramav.dYG;
        ((av)localObject3).dYH = paramav.dYH;
        ((av)localObject3).dYK = paramav.dYK;
        paramav = new JSONArray();
        while (i < n)
        {
          paramav.put(localObject2.opt(i));
          i += 1;
        }
        ((av)localObject3).dYI = paramav.toString();
        ((av)localObject3).dYJ = paramav.length();
        ((av)localObject3).dYL = k;
        ((av)localObject3).dYM = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(dhw paramdhw, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramdhw == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    av localav1 = new av();
    localav1.dYC = Process.myPid();
    av localav2 = localav1.iA(((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName).iB(paramdhw.dAa).iC(paramdhw.dyf).iD(paramdhw.HPg);
    localav2.dYF = paramdhw.HPc;
    localav2.dYG = paramdhw.HPd;
    localav2.dYH = paramdhw.HPe;
    localav2.dYI = ((String)paramc.get(0));
    localav2.dYJ = ((Integer)paramc.get(1)).intValue();
    int i = rbU;
    rbU = i + 1;
    localav2.dYK = i;
    paramdhw = a(localav1);
    if (paramdhw == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramdhw = paramdhw.iterator();
    while (paramdhw.hasNext())
    {
      paramc = (av)paramdhw.next();
      paramc.dYI = paramc.dYI.replace(",", "#");
      paramc.aLH();
      ae.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.RC() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */