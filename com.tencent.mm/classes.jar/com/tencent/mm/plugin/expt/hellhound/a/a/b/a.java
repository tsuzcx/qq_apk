package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.cr;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class a
{
  private static int wil = 0;
  
  private static List<cr> a(cr paramcr)
  {
    AppMethodBeat.i(169319);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramcr.agH().getBytes();
    if (localObject3.length <= 5120)
    {
      paramcr.gqJ = 0;
      paramcr.gqK = 1;
      localArrayList.add(paramcr);
      AppMethodBeat.o(169319);
      return localArrayList;
    }
    Object localObject1 = paramcr.gqG;
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
        localObject3 = new cr();
        ((cr)localObject3).gqB = paramcr.gqB;
        ((cr)localObject3).mY(paramcr.gqC);
        ((cr)localObject3).mZ(paramcr.gfl);
        ((cr)localObject3).na(paramcr.gqM);
        ((cr)localObject3).nb(paramcr.gqN);
        ((cr)localObject3).gqD = paramcr.gqD;
        ((cr)localObject3).gqE = paramcr.gqE;
        ((cr)localObject3).gqF = paramcr.gqF;
        ((cr)localObject3).gqI = paramcr.gqI;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((cr)localObject3).gqG = localJSONArray.toString();
        ((cr)localObject3).gqH = localJSONArray.length();
        ((cr)localObject3).gqJ = k;
        ((cr)localObject3).gqK = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new cr();
        ((cr)localObject3).gqB = paramcr.gqB;
        ((cr)localObject3).mY(paramcr.gqC);
        ((cr)localObject3).mZ(paramcr.gfl);
        ((cr)localObject3).na(paramcr.gqM);
        ((cr)localObject3).nb(paramcr.gqN);
        ((cr)localObject3).gqD = paramcr.gqD;
        ((cr)localObject3).gqE = paramcr.gqE;
        ((cr)localObject3).gqF = paramcr.gqF;
        ((cr)localObject3).gqI = paramcr.gqI;
        paramcr = new JSONArray();
        while (i < n)
        {
          paramcr.put(localObject2.opt(i));
          i += 1;
        }
        ((cr)localObject3).gqG = paramcr.toString();
        ((cr)localObject3).gqH = paramcr.length();
        ((cr)localObject3).gqJ = k;
        ((cr)localObject3).gqK = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(169319);
    }
    return localArrayList;
  }
  
  public static void a(elf paramelf, c<String, Integer> paramc)
  {
    AppMethodBeat.i(169318);
    if ((paramelf == null) || (paramc == null))
    {
      AppMethodBeat.o(169318);
      return;
    }
    cr localcr1 = new cr();
    localcr1.gqB = Process.myPid();
    cr localcr2 = localcr1.mY(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName).mZ(paramelf.fLj).na(paramelf.fJc).nb(paramelf.Unq);
    localcr2.gqD = paramelf.Unm;
    localcr2.gqE = paramelf.Unn;
    localcr2.gqF = paramelf.Uno;
    localcr2.gqG = ((String)paramc.get(0));
    localcr2.gqH = ((Integer)paramc.get(1)).intValue();
    int i = wil;
    wil = i + 1;
    localcr2.gqI = i;
    paramelf = a(localcr1);
    if (paramelf == null)
    {
      AppMethodBeat.o(169318);
      return;
    }
    paramelf = paramelf.iterator();
    while (paramelf.hasNext())
    {
      paramc = (cr)paramelf.next();
      paramc.gqG = paramc.gqG.replace(",", "#");
      paramc.bpa();
      Log.i("HABBYGE-MALI.FinderReport", "FinderReport-report-sub: %s", new Object[] { paramc.agH() });
    }
    AppMethodBeat.o(169318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */