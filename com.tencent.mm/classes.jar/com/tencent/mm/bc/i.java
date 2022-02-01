package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class i
  implements f
{
  public i()
  {
    AppMethodBeat.i(150802);
    g.ajB().gAO.a(159, this);
    g.ajB().gAO.a(160, this);
    l locall = new l(5);
    g.ajB().gAO.a(locall, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void aJT()
  {
    AppMethodBeat.i(150805);
    g.ajC().ajl().set(81939, Long.valueOf(bt.flT()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    g.ajB().gAO.b(159, this);
    g.ajB().gAO.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150804);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).aEM() != 5))
    {
      ad.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(150804);
      return;
    }
    int i = paramn.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aJT();
        paramString = t.aJZ().pR(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          ad.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        ad.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dtF);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new k(paramString.id, 5);
        g.ajB().gAO.a(paramString, 0);
        AppMethodBeat.o(150804);
        return;
      }
      release();
      AppMethodBeat.o(150804);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        aJT();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.i
 * JD-Core Version:    0.7.0.1
 */