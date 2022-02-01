package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public enum e
{
  public Map<String, a> nIC;
  
  static
  {
    AppMethodBeat.i(48117);
    nIB = new e("INSTANCE");
    nID = new e[] { nIB };
    AppMethodBeat.o(48117);
  }
  
  private e()
  {
    AppMethodBeat.i(48116);
    this.nIC = new HashMap();
    AppMethodBeat.o(48116);
  }
  
  public final void ch(String paramString, int paramInt)
  {
    long l = 0L;
    int i = 1;
    AppMethodBeat.i(227383);
    boolean bool = com.tencent.mm.plugin.appbrand.task.h.bWb().afi(paramString);
    a locala = (a)this.nIC.get(paramString);
    com.tencent.mm.plugin.report.service.h localh;
    if (locala == null)
    {
      locala = new a((byte)0);
      locala.nIF = 1L;
      this.nIC.put(paramString, locala);
      if (locala.nIE > 0L) {
        l = Util.nowMilliSecond() - locala.nIE;
      }
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      if (!bool) {
        break label179;
      }
    }
    for (;;)
    {
      localh.a(16064, new Object[] { Integer.valueOf(1), paramString, Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(locala.nIF), Long.valueOf(l) });
      AppMethodBeat.o(227383);
      return;
      locala.nIF += 1L;
      break;
      label179:
      i = 0;
    }
  }
  
  public static final class a
  {
    public long nIE = -1L;
    long nIF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.e
 * JD-Core Version:    0.7.0.1
 */