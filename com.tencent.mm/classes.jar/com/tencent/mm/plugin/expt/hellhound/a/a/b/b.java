package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class b
{
  private static int pGg = 0;
  
  private static List<ax> a(ax paramax)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramax.PV().getBytes();
    if (localObject3.length <= 5120)
    {
      paramax.dKD = 0;
      paramax.dKE = 1;
      localArrayList.add(paramax);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramax.dKA;
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
        localObject3 = new ax();
        ((ax)localObject3).dKu = paramax.dKu;
        ((ax)localObject3).hN(paramax.dKv);
        ((ax)localObject3).hO(paramax.dKw);
        ((ax)localObject3).dKx = paramax.dKx;
        ((ax)localObject3).dKy = paramax.dKy;
        ((ax)localObject3).dKz = paramax.dKz;
        ((ax)localObject3).dKC = paramax.dKC;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((ax)localObject3).dKA = localJSONArray.toString();
        ((ax)localObject3).dKB = localJSONArray.length();
        ((ax)localObject3).dKD = k;
        ((ax)localObject3).dKE = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new ax();
        ((ax)localObject3).dKu = paramax.dKu;
        ((ax)localObject3).hN(paramax.dKv);
        ((ax)localObject3).hO(paramax.dKw);
        ((ax)localObject3).dKx = paramax.dKx;
        ((ax)localObject3).dKy = paramax.dKy;
        ((ax)localObject3).dKz = paramax.dKz;
        ((ax)localObject3).dKC = paramax.dKC;
        paramax = new JSONArray();
        while (i < n)
        {
          paramax.put(localObject2.opt(i));
          i += 1;
        }
        ((ax)localObject3).dKA = paramax.toString();
        ((ax)localObject3).dKB = paramax.length();
        ((ax)localObject3).dKD = k;
        ((ax)localObject3).dKE = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(cwd paramcwd, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramcwd == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    ax localax1 = new ax();
    localax1.dKu = Process.myPid();
    ax localax2 = localax1.hN(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName).hO(paramcwd.dpw);
    localax2.dKx = paramcwd.EnS;
    localax2.dKy = paramcwd.EnT;
    localax2.dKz = paramcwd.EnU;
    localax2.dKA = ((String)paramc.get(0));
    localax2.dKB = ((Integer)paramc.get(1)).intValue();
    int i = pGg;
    pGg = i + 1;
    localax2.dKC = i;
    ad.i("HABBYGE-MALI.SnsReport", "SnsReport-report: " + localax1.PV());
    paramcwd = a(localax1);
    if (paramcwd == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramcwd = paramcwd.iterator();
    while (paramcwd.hasNext())
    {
      paramc = (ax)paramcwd.next();
      paramc.dKA = paramc.dKA.replace(",", "#");
      paramc.aBj();
      ad.i("HABBYGE-MALI.SnsReport", "SnsReport-report-sub: " + paramc.PV());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */