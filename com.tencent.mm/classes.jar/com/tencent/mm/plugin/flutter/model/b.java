package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;

public final class b
  implements k.c
{
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148872);
    paramd = paramj.method;
    int i = -1;
    switch (paramd.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(148872);
      return;
      if (!paramd.equals("android_kv_report")) {
        break;
      }
      i = 0;
      break;
      if (!paramd.equals("android_idkey_report")) {
        break;
      }
      i = 1;
      break;
      i = ((Integer)paramj.tn("id")).intValue();
      paramj = (String)paramj.tn("value");
      e.wTc.kvStat(i, paramj);
      AppMethodBeat.o(148872);
      return;
      i = ((Integer)paramj.tn("id")).intValue();
      int j = ((Integer)paramj.tn("key")).intValue();
      int k = ((Integer)paramj.tn("value")).intValue();
      e.wTc.idkeyStat(i, j, k, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.b
 * JD-Core Version:    0.7.0.1
 */