package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int sCq = 0;
  
  private static List<ca> a(ca paramca)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramca.abV().getBytes();
    if (localObject3.length <= 5120)
    {
      paramca.euD = 0;
      paramca.euE = 1;
      localArrayList.add(paramca);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramca.euA;
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
        Log.printErrStackTrace("HABBYGE-MALI.FinderReport", localException, "finder, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        localObject3 = new ca();
        ((ca)localObject3).euv = paramca.euv;
        ((ca)localObject3).kI(paramca.euw);
        ((ca)localObject3).kJ(paramca.ekG);
        ((ca)localObject3).kK(paramca.euG);
        ((ca)localObject3).kL(paramca.euH);
        ((ca)localObject3).eux = paramca.eux;
        ((ca)localObject3).euy = paramca.euy;
        ((ca)localObject3).euz = paramca.euz;
        ((ca)localObject3).euC = paramca.euC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((ca)localObject3).euA = localJSONArray.toString();
        ((ca)localObject3).euB = localJSONArray.length();
        ((ca)localObject3).euD = k;
        ((ca)localObject3).euE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new ca();
        ((ca)localObject3).euv = paramca.euv;
        ((ca)localObject3).kI(paramca.euw);
        ((ca)localObject3).kJ(paramca.ekG);
        ((ca)localObject3).kK(paramca.euG);
        ((ca)localObject3).kL(paramca.euH);
        ((ca)localObject3).eux = paramca.eux;
        ((ca)localObject3).euy = paramca.euy;
        ((ca)localObject3).euz = paramca.euz;
        ((ca)localObject3).euC = paramca.euC;
        paramca = new JSONArray();
        while (i < n)
        {
          paramca.put(localObject2.opt(i));
          i += 1;
        }
        ((ca)localObject3).euA = paramca.toString();
        ((ca)localObject3).euB = paramca.length();
        ((ca)localObject3).euD = k;
        ((ca)localObject3).euE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(ebf paramebf, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramebf == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    ca localca1 = new ca();
    localca1.euv = Process.myPid();
    ca localca2 = localca1.kI(((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName).kJ(paramebf.dRM).kK(paramebf.dPM).kL(paramebf.NaW);
    localca2.eux = paramebf.NaS;
    localca2.euy = paramebf.NaT;
    localca2.euz = paramebf.NaU;
    localca2.euA = ((String)paramc.get(0));
    localca2.euB = ((Integer)paramc.get(1)).intValue();
    int i = sCq;
    sCq = i + 1;
    localca2.euC = i;
    paramebf = a(localca1);
    if (paramebf == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramebf = paramebf.iterator();
    while (paramebf.hasNext())
    {
      paramc = (ca)paramebf.next();
      paramc.euA = paramc.euA.replace(",", "#");
      paramc.bfK();
      Log.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.abV() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */