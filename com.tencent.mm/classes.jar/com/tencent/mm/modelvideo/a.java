package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class a
{
  public static void a(z paramz, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (paramz == null)
    {
      Log.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = Util.currentTicks();
    v.bOh();
    String str = aa.PX(paramz.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.Sm(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.Sl(str);
      if (localb.pDJ != null) {
        l1 = localb.pDJ.pDG;
      }
    }
    for (;;)
    {
      long l4 = paramz.hTh;
      str = z.PM(paramz.bOu());
      long l5 = paramz.osy;
      paramz = new StringBuilder();
      paramz.append(l4).append(";").append(str).append(";");
      paramz.append(l5).append(";");
      paramz.append(i).append(";").append(l2).append(";");
      paramz.append(l1).append(";").append(paramInt);
      paramz = paramz.toString();
      Log.d("MicroMsg.AtomStatUtil", "report moov content : " + paramz + " cost time: " + Util.ticksToNow(l3));
      h.OAn.b(11098, new Object[] { Integer.valueOf(8000), paramz });
      AppMethodBeat.o(126778);
      return;
      l1 = 0L;
      continue;
      Log.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void n(int paramInt, String paramString1, String paramString2)
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
      long l1 = y.bEl(paramString1);
      long l2 = y.bEl(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      Log.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.OAn.b(11098, new Object[] { Integer.valueOf(8001), paramString1 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */