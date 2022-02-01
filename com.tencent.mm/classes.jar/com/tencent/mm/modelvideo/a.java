package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public static void a(s params, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (params == null)
    {
      ae.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = bu.HQ();
    o.aNh();
    String str = t.HJ(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.Jz(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.Jy(str);
      if (localb.iTf != null) {
        l1 = localb.iTf.iTb;
      }
    }
    for (;;)
    {
      long l4 = params.dCd;
      str = s.HA(params.aNt());
      long l5 = params.hPI;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      ae.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + bu.aO(l3));
      g.yxI.f(11098, new Object[] { Integer.valueOf(8000), params });
      AppMethodBeat.o(126778);
      return;
      l1 = 0L;
      continue;
      ae.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void j(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126779);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      AppMethodBeat.o(126779);
      return;
    }
    try
    {
      long l1 = com.tencent.mm.vfs.o.aZR(paramString1);
      long l2 = com.tencent.mm.vfs.o.aZR(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      ae.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      g.yxI.f(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      AppMethodBeat.o(126779);
      return;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      ae.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      AppMethodBeat.o(126779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */