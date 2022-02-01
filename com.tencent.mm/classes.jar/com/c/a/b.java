package com.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public class b
{
  private static volatile Integer cBI;
  
  public static int aH(Context paramContext)
  {
    int k = 2011;
    int j = -1;
    AppMethodBeat.i(206940);
    if (cBI == null) {}
    for (;;)
    {
      try
      {
        long l;
        ArrayList localArrayList;
        if (cBI == null)
        {
          l = a.aG(paramContext);
          if (l != -1L) {
            continue;
          }
          localArrayList = new ArrayList();
          i = a.getNumberOfCPUCores();
          if (i <= 0)
          {
            i = -1;
            c(localArrayList, i);
            l = a.Pb();
            if (l != -1L) {
              continue;
            }
            i = -1;
            c(localArrayList, i);
            l = a.aG(paramContext);
            if (l > 0L) {
              continue;
            }
            i = -1;
            c(localArrayList, i);
            if (!localArrayList.isEmpty()) {
              continue;
            }
            i = j;
            cBI = Integer.valueOf(i);
          }
        }
        else
        {
          i = cBI.intValue();
          AppMethodBeat.o(206940);
          return i;
        }
        if (i == 1)
        {
          i = 2008;
          continue;
        }
        if (i <= 3)
        {
          i = 2011;
          continue;
        }
        i = 2012;
        continue;
        if (l <= 528000L)
        {
          i = 2008;
          continue;
        }
        if (l <= 620000L)
        {
          i = 2009;
          continue;
        }
        if (l <= 1020000L)
        {
          i = 2010;
          continue;
        }
        if (l <= 1220000L)
        {
          i = 2011;
          continue;
        }
        if (l <= 1520000L)
        {
          i = 2012;
          continue;
        }
        if (l <= 2020000L)
        {
          i = 2013;
          continue;
        }
        i = 2014;
        continue;
        if (l <= 201326592L)
        {
          i = 2008;
          continue;
        }
        if (l <= 304087040L)
        {
          i = 2009;
          continue;
        }
        if (l <= 536870912L)
        {
          i = 2010;
          continue;
        }
        i = k;
        if (l <= 1073741824L) {
          continue;
        }
        if (l <= 1610612736L)
        {
          i = 2012;
          continue;
        }
        if (l <= 2147483648L)
        {
          i = 2013;
          continue;
        }
        i = 2014;
        continue;
        Collections.sort(localArrayList);
        if ((localArrayList.size() & 0x1) == 1)
        {
          i = ((Integer)localArrayList.get(localArrayList.size() / 2)).intValue();
          continue;
        }
        i = localArrayList.size() / 2 - 1;
        j = ((Integer)localArrayList.get(i)).intValue();
        i = (((Integer)localArrayList.get(i + 1)).intValue() - ((Integer)localArrayList.get(i)).intValue()) / 2 + j;
        continue;
        if (l <= 805306368L)
        {
          if (a.getNumberOfCPUCores() <= 1) {
            i = 2009;
          }
        }
        else
        {
          if (l <= 1073741824L)
          {
            if (a.Pb() >= 1300000) {
              break label625;
            }
            i = 2011;
            continue;
          }
          if (l <= 1610612736L)
          {
            i = a.Pb();
            if (i < 1800000)
            {
              i = 2012;
              continue;
            }
            i = 2013;
            continue;
          }
          if (l <= 2147483648L)
          {
            i = 2013;
            continue;
          }
          if (l <= 3221225472L)
          {
            i = 2014;
            continue;
          }
          if (l <= 5368709120L)
          {
            i = 2015;
            continue;
          }
          i = 2016;
          continue;
        }
        i = 2010;
      }
      finally
      {
        AppMethodBeat.o(206940);
      }
      continue;
      label625:
      int i = 2012;
    }
  }
  
  private static void c(ArrayList<Integer> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(206946);
    if (paramInt != -1) {
      paramArrayList.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(206946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.c.a.b
 * JD-Core Version:    0.7.0.1
 */