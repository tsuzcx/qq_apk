package com.tencent.mm.plugin.expt.d.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static void o(List<b> paramList, int paramInt)
  {
    AppMethodBeat.i(210277);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(210277);
      return;
    }
    ad.i("EdgeComputingReporter", "[EdgeComputingReporter] reportData logID : ".concat(String.valueOf(paramInt)));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (b)localIterator.next();
        j = i;
        while (paramList.index > j)
        {
          localArrayList.add("");
          j += 1;
        }
        i = j;
        if (paramList.index >= j) {
          if (paramList.type == 2) {
            paramList = String.valueOf(paramList.qQe);
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(paramList);
      i = j + 1;
      break;
      if (paramList.type == 1)
      {
        paramList = String.valueOf(paramList.intValue);
      }
      else if (paramList.type == 0)
      {
        paramList = paramList.stringValue;
        continue;
        if (localArrayList.size() > 0)
        {
          paramList = g.yhR;
          g.l(paramInt, localArrayList);
          ad.d("EdgeComputingReporter", "[EdgeComputingReporter] reportSingleData vals : " + localArrayList.size());
        }
        AppMethodBeat.o(210277);
      }
      else
      {
        paramList = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.g.a
 * JD-Core Version:    0.7.0.1
 */