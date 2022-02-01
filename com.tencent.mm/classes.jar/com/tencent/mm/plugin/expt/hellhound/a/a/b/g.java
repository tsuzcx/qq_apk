package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
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

public final class g
{
  private static int sCq = 0;
  
  private static List<ez> a(ez paramez)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramez.abV().getBytes();
    if (localObject3.length <= 5120)
    {
      paramez.euD = 0;
      paramez.euE = 1;
      localArrayList.add(paramez);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramez.euA;
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
        Log.printErrStackTrace("HABBYGE-MALI.SnsReport", localException, "Sns, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        localObject3 = new ez();
        ((ez)localObject3).euv = paramez.euv;
        ((ez)localObject3).rV(paramez.euw);
        ((ez)localObject3).rW(paramez.ekG);
        ((ez)localObject3).eux = paramez.eux;
        ((ez)localObject3).euy = paramez.euy;
        ((ez)localObject3).euz = paramez.euz;
        ((ez)localObject3).euC = paramez.euC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((ez)localObject3).euA = localJSONArray.toString();
        ((ez)localObject3).euB = localJSONArray.length();
        ((ez)localObject3).euD = k;
        ((ez)localObject3).euE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new ez();
        ((ez)localObject3).euv = paramez.euv;
        ((ez)localObject3).rV(paramez.euw);
        ((ez)localObject3).rW(paramez.ekG);
        ((ez)localObject3).eux = paramez.eux;
        ((ez)localObject3).euy = paramez.euy;
        ((ez)localObject3).euz = paramez.euz;
        ((ez)localObject3).euC = paramez.euC;
        paramez = new JSONArray();
        while (i < n)
        {
          paramez.put(localObject2.opt(i));
          i += 1;
        }
        ((ez)localObject3).euA = paramez.toString();
        ((ez)localObject3).euB = paramez.length();
        ((ez)localObject3).euD = k;
        ((ez)localObject3).euE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(ebf paramebf, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramebf == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    ez localez1 = new ez();
    localez1.euv = Process.myPid();
    ez localez2 = localez1.rV(((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName).rW(paramebf.dRM);
    localez2.eux = paramebf.NaS;
    localez2.euy = paramebf.NaT;
    localez2.euz = paramebf.NaU;
    localez2.euA = ((String)paramc.get(0));
    localez2.euB = ((Integer)paramc.get(1)).intValue();
    int i = sCq;
    sCq = i + 1;
    localez2.euC = i;
    Log.i("HABBYGE-MALI.SnsReport", "report16242: " + localez1.abV());
    paramebf = a(localez1);
    if (paramebf == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramebf = paramebf.iterator();
    while (paramebf.hasNext())
    {
      paramc = (ez)paramebf.next();
      paramc.euA = paramc.euA.replace(",", "#");
      paramc.bfK();
      Log.i("HABBYGE-MALI.SnsReport", "report16242-sub: " + paramc.abV());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */