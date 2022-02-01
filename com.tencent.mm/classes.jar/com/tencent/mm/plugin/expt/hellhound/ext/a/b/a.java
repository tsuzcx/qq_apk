package com.tencent.mm.plugin.expt.hellhound.ext.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dr;
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

public final class a
{
  private static int zEo = 0;
  
  private static List<dr> a(dr paramdr)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramdr.aIE().getBytes();
    if (localObject3.length <= 5120)
    {
      paramdr.iAw = 0;
      paramdr.iAx = 1;
      localArrayList.add(paramdr);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramdr.iAt;
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
        localObject3 = new dr();
        ((dr)localObject3).iAo = paramdr.iAo;
        ((dr)localObject3).nE(paramdr.iAp);
        ((dr)localObject3).nF(paramdr.ilK);
        ((dr)localObject3).nG(paramdr.iAz);
        ((dr)localObject3).nH(paramdr.iAA);
        ((dr)localObject3).iAq = paramdr.iAq;
        ((dr)localObject3).iAr = paramdr.iAr;
        ((dr)localObject3).iAs = paramdr.iAs;
        ((dr)localObject3).iAv = paramdr.iAv;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((dr)localObject3).iAt = localJSONArray.toString();
        ((dr)localObject3).iAu = localJSONArray.length();
        ((dr)localObject3).iAw = k;
        ((dr)localObject3).iAx = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new dr();
        ((dr)localObject3).iAo = paramdr.iAo;
        ((dr)localObject3).nE(paramdr.iAp);
        ((dr)localObject3).nF(paramdr.ilK);
        ((dr)localObject3).nG(paramdr.iAz);
        ((dr)localObject3).nH(paramdr.iAA);
        ((dr)localObject3).iAq = paramdr.iAq;
        ((dr)localObject3).iAr = paramdr.iAr;
        ((dr)localObject3).iAs = paramdr.iAs;
        ((dr)localObject3).iAv = paramdr.iAv;
        paramdr = new JSONArray();
        while (i < n)
        {
          paramdr.put(localObject2.opt(i));
          i += 1;
        }
        ((dr)localObject3).iAt = paramdr.toString();
        ((dr)localObject3).iAu = paramdr.length();
        ((dr)localObject3).iAw = k;
        ((dr)localObject3).iAx = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(ffn paramffn, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramffn == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    dr localdr1 = new dr();
    localdr1.iAo = Process.myPid();
    dr localdr2 = localdr1.nE(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName).nF(paramffn.hQR).nG(paramffn.hOK).nH(paramffn.abFx);
    localdr2.iAq = paramffn.abFt;
    localdr2.iAr = paramffn.abFu;
    localdr2.iAs = paramffn.abFv;
    localdr2.iAt = ((String)paramc.get(0));
    localdr2.iAu = ((Integer)paramc.get(1)).intValue();
    int i = zEo;
    zEo = i + 1;
    localdr2.iAv = i;
    paramffn = a(localdr1);
    if (paramffn == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramffn = paramffn.iterator();
    while (paramffn.hasNext())
    {
      paramc = (dr)paramffn.next();
      paramc.iAt = paramc.iAt.replace(",", "#");
      paramc.bMH();
      Log.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.aIE() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.b.a
 * JD-Core Version:    0.7.0.1
 */