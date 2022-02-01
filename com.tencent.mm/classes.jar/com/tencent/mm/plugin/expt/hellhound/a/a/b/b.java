package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class b
{
  private static int qTW = 0;
  
  private static List<co> a(co paramco)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramco.RD().getBytes();
    if (localObject3.length <= 5120)
    {
      paramco.dXu = 0;
      paramco.dXv = 1;
      localArrayList.add(paramco);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramco.dXr;
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(169321);
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.SnsReport", localException, "Sns, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        localObject3 = new co();
        ((co)localObject3).dXl = paramco.dXl;
        ((co)localObject3).lN(paramco.dXm);
        ((co)localObject3).lO(paramco.dXn);
        ((co)localObject3).dXo = paramco.dXo;
        ((co)localObject3).dXp = paramco.dXp;
        ((co)localObject3).dXq = paramco.dXq;
        ((co)localObject3).dXt = paramco.dXt;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((co)localObject3).dXr = localJSONArray.toString();
        ((co)localObject3).dXs = localJSONArray.length();
        ((co)localObject3).dXu = k;
        ((co)localObject3).dXv = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new co();
        ((co)localObject3).dXl = paramco.dXl;
        ((co)localObject3).lN(paramco.dXm);
        ((co)localObject3).lO(paramco.dXn);
        ((co)localObject3).dXo = paramco.dXo;
        ((co)localObject3).dXp = paramco.dXp;
        ((co)localObject3).dXq = paramco.dXq;
        ((co)localObject3).dXt = paramco.dXt;
        paramco = new JSONArray();
        while (i < n)
        {
          paramco.put(localObject2.opt(i));
          i += 1;
        }
        ((co)localObject3).dXr = paramco.toString();
        ((co)localObject3).dXs = paramco.length();
        ((co)localObject3).dXu = k;
        ((co)localObject3).dXv = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(dhc paramdhc, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramdhc == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    co localco1 = new co();
    localco1.dXl = Process.myPid();
    co localco2 = localco1.lN(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName).lO(paramdhc.dyV);
    localco2.dXo = paramdhc.Hvz;
    localco2.dXp = paramdhc.HvA;
    localco2.dXq = paramdhc.HvB;
    localco2.dXr = ((String)paramc.get(0));
    localco2.dXs = ((Integer)paramc.get(1)).intValue();
    int i = qTW;
    qTW = i + 1;
    localco2.dXt = i;
    ad.i("HABBYGE-MALI.SnsReport", "SnsReport-report: " + localco1.RD());
    paramdhc = a(localco1);
    if (paramdhc == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramdhc = paramdhc.iterator();
    while (paramdhc.hasNext())
    {
      paramc = (co)paramdhc.next();
      paramc.dXr = paramc.dXr.replace(",", "#");
      paramc.aLk();
      ad.i("HABBYGE-MALI.SnsReport", "SnsReport-report-sub: " + paramc.RD());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */