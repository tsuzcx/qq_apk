package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class i
  implements f
{
  public i()
  {
    AppMethodBeat.i(150802);
    g.ajQ().gDv.a(159, this);
    g.ajQ().gDv.a(160, this);
    l locall = new l(5);
    g.ajQ().gDv.a(locall, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void aKm()
  {
    AppMethodBeat.i(150805);
    g.ajR().ajA().set(81939, Long.valueOf(bu.fpO()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    g.ajQ().gDv.b(159, this);
    g.ajQ().gDv.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150804);
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aFc() != 5))
    {
      ae.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(150804);
      return;
    }
    int i = paramn.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aKm();
        paramString = t.aKs().pU(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          ae.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        ae.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.duK);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new k(paramString.id, 5);
        g.ajQ().gDv.a(paramString, 0);
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
        aKm();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.i
 * JD-Core Version:    0.7.0.1
 */