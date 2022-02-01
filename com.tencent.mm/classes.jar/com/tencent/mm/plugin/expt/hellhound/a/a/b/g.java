package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.gp;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class g
{
  private static int wil = 0;
  
  private static List<gp> a(gp paramgp)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramgp.agH().getBytes();
    if (localObject3.length <= 5120)
    {
      paramgp.gqJ = 0;
      paramgp.gqK = 1;
      localArrayList.add(paramgp);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramgp.gqG;
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
        localObject3 = new gp();
        ((gp)localObject3).gqB = paramgp.gqB;
        ((gp)localObject3).vC(paramgp.gqC);
        ((gp)localObject3).vD(paramgp.gfl);
        ((gp)localObject3).gqD = paramgp.gqD;
        ((gp)localObject3).gqE = paramgp.gqE;
        ((gp)localObject3).gqF = paramgp.gqF;
        ((gp)localObject3).gqI = paramgp.gqI;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((gp)localObject3).gqG = localJSONArray.toString();
        ((gp)localObject3).gqH = localJSONArray.length();
        ((gp)localObject3).gqJ = k;
        ((gp)localObject3).gqK = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new gp();
        ((gp)localObject3).gqB = paramgp.gqB;
        ((gp)localObject3).vC(paramgp.gqC);
        ((gp)localObject3).vD(paramgp.gfl);
        ((gp)localObject3).gqD = paramgp.gqD;
        ((gp)localObject3).gqE = paramgp.gqE;
        ((gp)localObject3).gqF = paramgp.gqF;
        ((gp)localObject3).gqI = paramgp.gqI;
        paramgp = new JSONArray();
        while (i < n)
        {
          paramgp.put(localObject2.opt(i));
          i += 1;
        }
        ((gp)localObject3).gqG = paramgp.toString();
        ((gp)localObject3).gqH = paramgp.length();
        ((gp)localObject3).gqJ = k;
        ((gp)localObject3).gqK = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(elf paramelf, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramelf == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    gp localgp1 = new gp();
    localgp1.gqB = Process.myPid();
    gp localgp2 = localgp1.vC(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName).vD(paramelf.fLj);
    localgp2.gqD = paramelf.Unm;
    localgp2.gqE = paramelf.Unn;
    localgp2.gqF = paramelf.Uno;
    localgp2.gqG = ((String)paramc.get(0));
    localgp2.gqH = ((Integer)paramc.get(1)).intValue();
    int i = wil;
    wil = i + 1;
    localgp2.gqI = i;
    Log.i("HABBYGE-MALI.SnsReport", "report16242: " + localgp1.agH());
    paramelf = a(localgp1);
    if (paramelf == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramelf = paramelf.iterator();
    while (paramelf.hasNext())
    {
      paramc = (gp)paramelf.next();
      paramc.gqG = paramc.gqG.replace(",", "#");
      paramc.bpa();
      Log.i("HABBYGE-MALI.SnsReport", "report16242-sub: " + paramc.agH());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.g
 * JD-Core Version:    0.7.0.1
 */