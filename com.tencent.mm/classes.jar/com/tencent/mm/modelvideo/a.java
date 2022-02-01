package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class a
{
  public static void a(s params, int paramInt)
  {
    AppMethodBeat.i(126778);
    if (params == null)
    {
      ac.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(126778);
      return;
    }
    long l3 = bs.Gn();
    o.aJy();
    String str = t.DV(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.FL(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.FK(str);
      if (localb.ixd != null) {
        l1 = localb.ixd.iwZ;
      }
    }
    for (;;)
    {
      long l4 = params.dpl;
      str = s.DR(params.aJK());
      long l5 = params.hux;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      ac.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + bs.aO(l3));
      h.wUl.f(11098, new Object[] { Integer.valueOf(8000), params });
      AppMethodBeat.o(126778);
      return;
      l1 = 0L;
      continue;
      ac.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void j(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126779);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      AppMethodBeat.o(126779);
      return;
    }
    try
    {
      long l1 = i.aSp(paramString1);
      long l2 = i.aSp(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      ac.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.wUl.f(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      AppMethodBeat.o(126779);
      return;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      ac.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      AppMethodBeat.o(126779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */