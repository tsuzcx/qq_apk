package com.tencent.mm.plugin.expt.d.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static void o(List<b> paramList, int paramInt)
  {
    AppMethodBeat.i(195930);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(195930);
      return;
    }
    ae.i("EdgeComputingReporter", "[EdgeComputingReporter] reportData logID : ".concat(String.valueOf(paramInt)));
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
        if (paramList == null)
        {
          AppMethodBeat.o(195930);
          return;
        }
        while (paramList.index > j)
        {
          localArrayList.add("");
          j += 1;
        }
        i = j;
        if (paramList.index >= j) {
          if (paramList.type == 2) {
            paramList = String.valueOf(paramList.qXY);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject = paramList;
      if (paramList.contains(",")) {
        localObject = paramList.replace(",", "\\$");
      }
      localArrayList.add(localObject);
      i = j + 1;
      break;
      if (paramList.type == 1) {
        paramList = String.valueOf(paramList.intValue);
      } else if (paramList.type == 0)
      {
        if (paramList.stringValue == null)
        {
          paramList = "";
        }
        else
        {
          paramList = paramList.stringValue;
          continue;
          if (localArrayList.size() > 0)
          {
            paramList = g.yxI;
            g.m(paramInt, localArrayList);
            ae.d("EdgeComputingReporter", "[EdgeComputingReporter] reportData vals : " + localArrayList.size());
          }
          AppMethodBeat.o(195930);
        }
      }
      else {
        paramList = "";
      }
    }
  }
  
  public static void p(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(195931);
    if ((paramList == null) || (paramList.size() <= 0) || (paramInt <= 0))
    {
      AppMethodBeat.o(195931);
      return;
    }
    ae.i("EdgeComputingReporter", "[EdgeComputingReporter] reportStrData logID : ".concat(String.valueOf(paramInt)));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = str;
      if (str.contains(",")) {
        paramList = str.replace(",", "\\$");
      }
      localArrayList.add(paramList);
    }
    paramList = g.yxI;
    g.m(paramInt, localArrayList);
    ae.d("EdgeComputingReporter", "[EdgeComputingReporter] reportStrData vals : " + localArrayList.size());
    AppMethodBeat.o(195931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.g.a
 * JD-Core Version:    0.7.0.1
 */