package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a
{
  public static void N(int paramInt, long paramLong)
  {
    AppMethodBeat.i(73438);
    int i;
    if (paramLong <= 500000L) {
      i = 0;
    }
    for (;;)
    {
      h.OAn.idkeyStat(paramInt, i, 1L, false);
      AppMethodBeat.o(73438);
      return;
      if (paramLong <= 1000000L) {
        i = 1;
      } else if (paramLong <= 2000000L) {
        i = 2;
      } else if (paramLong <= 3000000L) {
        i = 3;
      } else if (paramLong <= 4000000L) {
        i = 4;
      } else if (paramLong <= 5000000L) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  public static void O(int paramInt, long paramLong)
  {
    AppMethodBeat.i(73439);
    int i;
    if (paramLong <= 20000000L) {
      i = 0;
    }
    for (;;)
    {
      h.OAn.idkeyStat(paramInt, i, 1L, false);
      AppMethodBeat.o(73439);
      return;
      if (paramLong <= 25000000L) {
        i = 1;
      } else if (paramLong <= 30000000L) {
        i = 2;
      } else if (paramLong <= 35000000L) {
        i = 3;
      } else if (paramLong <= 40000000L) {
        i = 4;
      } else if (paramLong <= 50000000L) {
        i = 5;
      } else if (paramLong <= 60000000L) {
        i = 6;
      } else if (paramLong <= 70000000L) {
        i = 7;
      } else if (paramLong <= 80000000L) {
        i = 8;
      } else {
        i = 9;
      }
    }
  }
  
  public static void d(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(73437);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(73437);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(703);
    int i;
    if (paramInt1 == 1)
    {
      i = 3;
      localIDKey.SetKey(i);
      localIDKey.SetValue(paramLong1);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(703);
      if (paramInt1 != 1) {
        break label196;
      }
      i = 4;
      label108:
      localIDKey.SetKey(i);
      localIDKey.SetValue(paramLong2);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(703);
      if (paramInt1 != 1) {
        break label202;
      }
    }
    label196:
    label202:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      localIDKey.SetKey(paramInt1);
      localIDKey.SetValue(paramInt2);
      localArrayList.add(localIDKey);
      h.OAn.b(localArrayList, false);
      AppMethodBeat.o(73437);
      return;
      i = 0;
      break;
      i = 1;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a
 * JD-Core Version:    0.7.0.1
 */