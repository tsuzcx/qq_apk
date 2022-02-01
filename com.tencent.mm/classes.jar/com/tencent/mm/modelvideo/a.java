package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static void a(s params, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (params == null)
    {
      Log.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = Util.currentTicks();
    o.bhj();
    String str = t.Qw(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.Sx(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.Sw(str);
      if (localb.jPZ != null) {
        l1 = localb.jPZ.jPV;
      }
    }
    for (;;)
    {
      long l4 = params.dTS;
      str = s.Qn(params.bhv());
      long l5 = params.iKP;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      Log.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + Util.ticksToNow(l3));
      h.CyF.a(11098, new Object[] { Integer.valueOf(8000), params });
      AppMethodBeat.o(126778);
      return;
      l1 = 0L;
      continue;
      Log.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126779);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      AppMethodBeat.o(126779);
      return;
    }
    try
    {
      long l1 = com.tencent.mm.vfs.s.boW(paramString1);
      long l2 = com.tencent.mm.vfs.s.boW(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      Log.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.CyF.a(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      AppMethodBeat.o(126779);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      Log.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      AppMethodBeat.o(126779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */