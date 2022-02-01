package com.tencent.mm.plugin.expt.hellhound.ext.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ik;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class f
{
  private static int zEo = 0;
  
  private static List<ik> a(ik paramik)
  {
    AppMethodBeat.i(169321);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramik.aIE().getBytes();
    if (localObject3.length <= 5120)
    {
      paramik.iAw = 0;
      paramik.iAx = 1;
      localArrayList.add(paramik);
      AppMethodBeat.o(169321);
      return localArrayList;
    }
    Object localObject1 = paramik.iAt;
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
        localObject3 = new ik();
        ((ik)localObject3).iAo = paramik.iAo;
        ((ik)localObject3).rO(paramik.iAp);
        ((ik)localObject3).rP(paramik.ilK);
        ((ik)localObject3).iAq = paramik.iAq;
        ((ik)localObject3).iAr = paramik.iAr;
        ((ik)localObject3).iAs = paramik.iAs;
        ((ik)localObject3).iAv = paramik.iAv;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((ik)localObject3).iAt = localJSONArray.toString();
        ((ik)localObject3).iAu = localJSONArray.length();
        ((ik)localObject3).iAw = k;
        ((ik)localObject3).iAx = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new ik();
        ((ik)localObject3).iAo = paramik.iAo;
        ((ik)localObject3).rO(paramik.iAp);
        ((ik)localObject3).rP(paramik.ilK);
        ((ik)localObject3).iAq = paramik.iAq;
        ((ik)localObject3).iAr = paramik.iAr;
        ((ik)localObject3).iAs = paramik.iAs;
        ((ik)localObject3).iAv = paramik.iAv;
        paramik = new JSONArray();
        while (i < n)
        {
          paramik.put(localObject2.opt(i));
          i += 1;
        }
        ((ik)localObject3).iAt = paramik.toString();
        ((ik)localObject3).iAu = paramik.length();
        ((ik)localObject3).iAw = k;
        ((ik)localObject3).iAx = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169321);
    }
    return localArrayList;
  }
  
  public static void a(ffn paramffn, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169320);
    if ((paramffn == null) || (paramc == null))
    {
      AppMethodBeat.o(169320);
      return;
    }
    ik localik1 = new ik();
    localik1.iAo = Process.myPid();
    ik localik2 = localik1.rO(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName).rP(paramffn.hQR);
    localik2.iAq = paramffn.abFt;
    localik2.iAr = paramffn.abFu;
    localik2.iAs = paramffn.abFv;
    localik2.iAt = ((String)paramc.get(0));
    localik2.iAu = ((Integer)paramc.get(1)).intValue();
    int i = zEo;
    zEo = i + 1;
    localik2.iAv = i;
    Log.i("HABBYGE-MALI.SnsReport", "report16242: " + localik1.aIE());
    paramffn = a(localik1);
    if (paramffn == null)
    {
      AppMethodBeat.o(169320);
      return;
    }
    paramffn = paramffn.iterator();
    while (paramffn.hasNext())
    {
      paramc = (ik)paramffn.next();
      paramc.iAt = paramc.iAt.replace(",", "#");
      paramc.bMH();
      Log.i("HABBYGE-MALI.SnsReport", "report16242-sub: " + paramc.aIE());
    }
    AppMethodBeat.o(169320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.b.f
 * JD-Core Version:    0.7.0.1
 */