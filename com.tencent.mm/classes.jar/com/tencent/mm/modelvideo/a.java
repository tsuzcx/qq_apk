package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class a
{
  public static void a(w paramw, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (paramw == null)
    {
      Log.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = Util.currentTicks();
    s.bqB();
    String str = x.XT(paramw.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.ZZ(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.ZY(str);
      if (localb.mHj != null) {
        l1 = localb.mHj.mHf;
      }
    }
    for (;;)
    {
      long l4 = paramw.fNu;
      str = w.XK(paramw.bqO());
      long l5 = paramw.lAW;
      paramw = new StringBuilder();
      paramw.append(l4).append(";").append(str).append(";");
      paramw.append(l5).append(";");
      paramw.append(i).append(";").append(l2).append(";");
      paramw.append(l1).append(";").append(paramInt);
      paramw = paramw.toString();
      Log.d("MicroMsg.AtomStatUtil", "report moov content : " + paramw + " cost time: " + Util.ticksToNow(l3));
      h.IzE.a(11098, new Object[] { Integer.valueOf(8000), paramw });
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
      long l1 = u.bBQ(paramString1);
      long l2 = u.bBQ(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      Log.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.IzE.a(11098, new Object[] { Integer.valueOf(8001), paramString1 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */