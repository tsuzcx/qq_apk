package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements w.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(136141);
    ab.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.laX = new f((com.tencent.mm.plugin.downloader.c.a.a.b)paramb.fsW.fta);
      if (g.laW != null) {
        g.laW.gu(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(136141);
      return 0;
      if (g.laW != null) {
        g.laW.gu(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.g.1
 * JD-Core Version:    0.7.0.1
 */