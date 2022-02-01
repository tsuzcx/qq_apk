package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.task.e;

final class b$1
  implements p.a
{
  b$1(b paramb, boolean paramBoolean, String paramString, long paramLong, i parami) {}
  
  public final void onInitialized()
  {
    AppMethodBeat.i(48248);
    a.bxN();
    if (this.kko) {}
    for (e locale = e.myg;; locale = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, this.cko, d.d(this.coK));
      AppMethodBeat.o(48248);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b.1
 * JD-Core Version:    0.7.0.1
 */