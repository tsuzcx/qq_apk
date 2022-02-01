package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class a
{
  public static void a(s params, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (params == null)
    {
      ad.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = bt.GC();
    o.aCI();
    String str = t.zQ(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.BH(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.BG(str);
      if (localb.hWZ != null) {
        l1 = localb.hWZ.hWV;
      }
    }
    for (;;)
    {
      long l4 = params.drA;
      str = s.zM(params.aCT());
      long l5 = params.gTY;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      ad.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + bt.aS(l3));
      h.vKh.f(11098, new Object[] { Integer.valueOf(8000), params });
      AppMethodBeat.o(126778);
      return;
      l1 = 0L;
      continue;
      ad.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126779);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      AppMethodBeat.o(126779);
      return;
    }
    try
    {
      long l1 = i.aMN(paramString1);
      long l2 = i.aMN(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      ad.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.vKh.f(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      AppMethodBeat.o(126779);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      ad.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      AppMethodBeat.o(126779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */