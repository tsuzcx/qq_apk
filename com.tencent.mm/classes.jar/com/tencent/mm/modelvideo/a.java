package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static void a(s params, int paramInt)
  {
    if (params == null)
    {
      y.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
      return;
    }
    long l3 = bk.UZ();
    o.Sr();
    String str = t.nS(params.getFileName());
    long l2 = 0L;
    long l1 = 0L;
    int i;
    if (c.pp(str))
    {
      i = 1;
      b localb = new b();
      l2 = localb.po(str);
      if (localb.eUe != null) {
        l1 = localb.eUe.eUa;
      }
    }
    for (;;)
    {
      long l4 = params.bXr;
      str = s.nP(params.SD());
      long l5 = params.ebK;
      params = new StringBuilder();
      params.append(l4).append(";").append(str).append(";");
      params.append(l5).append(";");
      params.append(i).append(";").append(l2).append(";");
      params.append(l1).append(";").append(paramInt);
      params = params.toString();
      y.d("MicroMsg.AtomStatUtil", "report moov content : " + params + " cost time: " + bk.cp(l3));
      h.nFQ.f(11098, new Object[] { Integer.valueOf(8000), params });
      return;
      l1 = 0L;
      continue;
      y.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.a
 * JD-Core Version:    0.7.0.1
 */