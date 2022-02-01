package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class b
{
  private static int qla = 0;
  
  private static List<bx> a(bx parambx)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = parambx.PR().getBytes();
    if (localObject3.length <= 5120)
    {
      parambx.dJD = 0;
      parambx.dJE = 1;
      localArrayList.add(parambx);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = parambx.dJA;
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
        ac.printErrStackTrace("HABBYGE-MALI.SnsReport", localException, "Sns, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
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
        localObject3 = new bx();
        ((bx)localObject3).dJu = parambx.dJu;
        ((bx)localObject3).jR(parambx.dJv);
        ((bx)localObject3).jS(parambx.dJw);
        ((bx)localObject3).dJx = parambx.dJx;
        ((bx)localObject3).dJy = parambx.dJy;
        ((bx)localObject3).dJz = parambx.dJz;
        ((bx)localObject3).dJC = parambx.dJC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((bx)localObject3).dJA = localJSONArray.toString();
        ((bx)localObject3).dJB = localJSONArray.length();
        ((bx)localObject3).dJD = k;
        ((bx)localObject3).dJE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new bx();
        ((bx)localObject3).dJu = parambx.dJu;
        ((bx)localObject3).jR(parambx.dJv);
        ((bx)localObject3).jS(parambx.dJw);
        ((bx)localObject3).dJx = parambx.dJx;
        ((bx)localObject3).dJy = parambx.dJy;
        ((bx)localObject3).dJz = parambx.dJz;
        ((bx)localObject3).dJC = parambx.dJC;
        parambx = new JSONArray();
        while (i < n)
        {
          parambx.put(localObject2.opt(i));
          i += 1;
        }
        ((bx)localObject3).dJA = parambx.toString();
        ((bx)localObject3).dJB = parambx.length();
        ((bx)localObject3).dJD = k;
        ((bx)localObject3).dJE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(dbp paramdbp, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramdbp == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    bx localbx1 = new bx();
    localbx1.dJu = Process.myPid();
    bx localbx2 = localbx1.jR(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName).jS(paramdbp.dnh);
    localbx2.dJx = paramdbp.FKR;
    localbx2.dJy = paramdbp.FKS;
    localbx2.dJz = paramdbp.FKT;
    localbx2.dJA = ((String)paramc.get(0));
    localbx2.dJB = ((Integer)paramc.get(1)).intValue();
    int i = qla;
    qla = i + 1;
    localbx2.dJC = i;
    ac.i("HABBYGE-MALI.SnsReport", "SnsReport-report: " + localbx1.PR());
    paramdbp = a(localbx1);
    if (paramdbp == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramdbp = paramdbp.iterator();
    while (paramdbp.hasNext())
    {
      paramc = (bx)paramdbp.next();
      paramc.dJA = paramc.dJA.replace(",", "#");
      paramc.aHZ();
      ac.i("HABBYGE-MALI.SnsReport", "SnsReport-report-sub: " + paramc.PR());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */