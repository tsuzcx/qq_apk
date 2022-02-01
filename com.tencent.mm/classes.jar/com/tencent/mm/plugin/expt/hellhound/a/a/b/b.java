package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class b
{
  private static int rbU = 0;
  
  private static List<co> a(co paramco)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramco.RC().getBytes();
    if (localObject3.length <= 5120)
    {
      paramco.dYL = 0;
      paramco.dYM = 1;
      localArrayList.add(paramco);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramco.dYI;
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
        ae.printErrStackTrace("HABBYGE-MALI.SnsReport", localException, "Sns, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        ((co)localObject3).dYC = paramco.dYC;
        ((co)localObject3).me(paramco.dYD);
        ((co)localObject3).mf(paramco.dYE);
        ((co)localObject3).dYF = paramco.dYF;
        ((co)localObject3).dYG = paramco.dYG;
        ((co)localObject3).dYH = paramco.dYH;
        ((co)localObject3).dYK = paramco.dYK;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((co)localObject3).dYI = localJSONArray.toString();
        ((co)localObject3).dYJ = localJSONArray.length();
        ((co)localObject3).dYL = k;
        ((co)localObject3).dYM = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new co();
        ((co)localObject3).dYC = paramco.dYC;
        ((co)localObject3).me(paramco.dYD);
        ((co)localObject3).mf(paramco.dYE);
        ((co)localObject3).dYF = paramco.dYF;
        ((co)localObject3).dYG = paramco.dYG;
        ((co)localObject3).dYH = paramco.dYH;
        ((co)localObject3).dYK = paramco.dYK;
        paramco = new JSONArray();
        while (i < n)
        {
          paramco.put(localObject2.opt(i));
          i += 1;
        }
        ((co)localObject3).dYI = paramco.toString();
        ((co)localObject3).dYJ = paramco.length();
        ((co)localObject3).dYL = k;
        ((co)localObject3).dYM = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(dhw paramdhw, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramdhw == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    co localco1 = new co();
    localco1.dYC = Process.myPid();
    co localco2 = localco1.me(((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName).mf(paramdhw.dAa);
    localco2.dYF = paramdhw.HPc;
    localco2.dYG = paramdhw.HPd;
    localco2.dYH = paramdhw.HPe;
    localco2.dYI = ((String)paramc.get(0));
    localco2.dYJ = ((Integer)paramc.get(1)).intValue();
    int i = rbU;
    rbU = i + 1;
    localco2.dYK = i;
    ae.i("HABBYGE-MALI.SnsReport", "SnsReport-report: " + localco1.RC());
    paramdhw = a(localco1);
    if (paramdhw == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramdhw = paramdhw.iterator();
    while (paramdhw.hasNext())
    {
      paramc = (co)paramdhw.next();
      paramc.dYI = paramc.dYI.replace(",", "#");
      paramc.aLH();
      ae.i("HABBYGE-MALI.SnsReport", "SnsReport-report-sub: " + paramc.RC());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */