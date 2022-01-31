package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class a
{
  public static void a(s params, int paramInt)
  {
    AppMethodBeat.i(50621);
    if (params == null)
    {
      ab.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      AppMethodBeat.o(50621);
      return;
    }
    long l3 = bo.yB();
    o.alE();
    String str = t.vf(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.wE(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.wD(str);
      if (localb.gmc != null) {
        l1 = localb.gmc.glY;
      }
    }
    for (;;)
    {
      long l4 = params.cFn;
      str = s.vc(params.alP());
      long l5 = params.fsd;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      ab.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + bo.av(l3));
      h.qsU.e(11098, new Object[] { Integer.valueOf(8000), params });
      AppMethodBeat.o(50621);
      return;
      l1 = 0L;
      continue;
      ab.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
  
  public static void j(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(50622);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      AppMethodBeat.o(50622);
      return;
    }
    try
    {
      long l1 = e.avI(paramString1);
      long l2 = e.avI(paramString2);
      int i = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(i);
      paramString1 = paramString1.toString();
      ab.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(paramString1)));
      h.qsU.e(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      AppMethodBeat.o(50622);
      return;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      ab.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
      AppMethodBeat.o(50622);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */