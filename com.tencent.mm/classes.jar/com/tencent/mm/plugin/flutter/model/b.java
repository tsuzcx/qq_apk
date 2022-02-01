package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;

public final class b
  implements a, k.c
{
  private k BCG;
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(221113);
    Log.i("MicroMsg.Flutter.FlutterDataReportPlugin", "onAttachedToEngine FlutterDataReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.datareport" });
    this.BCG = new k(paramb.aaqF, "com.tencent.mm.flutter.datareport");
    this.BCG.a(this);
    AppMethodBeat.o(221113);
  }
  
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
      i = ((Integer)paramj.bGt("id")).intValue();
      paramj = (String)paramj.bGt("value");
      f.Iyx.kvStat(i, paramj);
      AppMethodBeat.o(148872);
      return;
      i = ((Integer)paramj.bGt("id")).intValue();
      int j = ((Integer)paramj.bGt("key")).intValue();
      int k = ((Integer)paramj.bGt("value")).intValue();
      f.Iyx.idkeyStat(i, j, k, false);
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(221114);
    if (this.BCG != null) {
      this.BCG.a(null);
    }
    AppMethodBeat.o(221114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.b
 * JD-Core Version:    0.7.0.1
 */