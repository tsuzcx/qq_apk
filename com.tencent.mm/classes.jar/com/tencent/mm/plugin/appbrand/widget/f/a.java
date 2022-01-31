package com.tencent.mm.plugin.appbrand.widget.f;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a
{
  public static void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramInt2 <= 0)) {
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
        break label181;
      }
      i = 4;
      label98:
      localIDKey.SetKey(i);
      localIDKey.SetValue(paramLong2);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(703);
      if (paramInt1 != 1) {
        break label187;
      }
    }
    label181:
    label187:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      localIDKey.SetKey(paramInt1);
      localIDKey.SetValue(paramInt2);
      localArrayList.add(localIDKey);
      h.nFQ.b(localArrayList, false);
      return;
      i = 0;
      break;
      i = 1;
      break label98;
    }
  }
  
  public static void p(int paramInt, long paramLong)
  {
    int i;
    if (paramLong <= 500000L) {
      i = 0;
    }
    for (;;)
    {
      h.nFQ.a(paramInt, i, 1L, false);
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
  
  public static void q(int paramInt, long paramLong)
  {
    int i;
    if (paramLong <= 20000000L) {
      i = 0;
    }
    for (;;)
    {
      h.nFQ.a(paramInt, i, 1L, false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a
 * JD-Core Version:    0.7.0.1
 */