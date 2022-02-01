package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.processes.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public enum e
{
  private Map<String, a> qKO;
  
  static
  {
    AppMethodBeat.i(48117);
    qKN = new e("INSTANCE");
    qKP = new e[] { qKN };
    AppMethodBeat.o(48117);
  }
  
  private e()
  {
    AppMethodBeat.i(48116);
    this.qKO = new HashMap();
    AppMethodBeat.o(48116);
  }
  
  public final void amI(String paramString)
  {
    AppMethodBeat.i(284296);
    paramString = (a)this.qKO.get(paramString);
    if (paramString != null) {
      paramString.qKQ = Util.nowMilliSecond();
    }
    AppMethodBeat.o(284296);
  }
  
  public final void cG(String paramString, int paramInt)
  {
    long l = 0L;
    int i = 1;
    AppMethodBeat.i(284295);
    boolean bool = i.cjb().w(paramString, -1);
    a locala = (a)this.qKO.get(paramString);
    h localh;
    if (locala == null)
    {
      locala = new a((byte)0);
      locala.qKR = 1L;
      this.qKO.put(paramString, locala);
      if (locala.qKQ > 0L) {
        l = Util.nowMilliSecond() - locala.qKQ;
      }
      localh = h.IzE;
      if (!bool) {
        break label178;
      }
    }
    for (;;)
    {
      localh.a(16064, new Object[] { Integer.valueOf(1), paramString, Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(locala.qKR), Long.valueOf(l) });
      AppMethodBeat.o(284295);
      return;
      locala.qKR += 1L;
      break;
      label178:
      i = 0;
    }
  }
  
  static final class a
  {
    long qKQ = -1L;
    long qKR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.e
 * JD-Core Version:    0.7.0.1
 */