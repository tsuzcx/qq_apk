package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r$e
{
  public static final e hcb;
  
  static
  {
    AppMethodBeat.i(129633);
    hcb = new e();
    AppMethodBeat.o(129633);
  }
  
  static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129632);
    h.qsU.e(14112, new Object[] { Integer.valueOf(1), bo.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(129632);
  }
  
  static void axu()
  {
    AppMethodBeat.i(129629);
    a((String)g.RL().Ru().get(ac.a.yCS, ""), ((Long)g.RL().Ru().get(ac.a.yCT, Long.valueOf(0L))).longValue(), 3, axw());
    AppMethodBeat.o(129629);
  }
  
  public static void axv()
  {
    AppMethodBeat.i(129630);
    a("", 0L, 1, 1);
    AppMethodBeat.o(129630);
  }
  
  static int axw()
  {
    AppMethodBeat.i(129631);
    if (g.RL().Ru().getBoolean(ac.a.yCY, false))
    {
      AppMethodBeat.o(129631);
      return 1;
    }
    int j = ((Integer)g.RL().Ru().get(ac.a.yCV, Integer.valueOf(0))).intValue();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    AppMethodBeat.o(129631);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.e
 * JD-Core Version:    0.7.0.1
 */