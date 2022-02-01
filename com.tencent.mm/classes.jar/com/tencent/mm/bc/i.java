package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class i
  implements com.tencent.mm.al.g
{
  public i()
  {
    AppMethodBeat.i(150802);
    com.tencent.mm.kernel.g.afA().gcy.a(159, this);
    com.tencent.mm.kernel.g.afA().gcy.a(160, this);
    l locall = new l(5);
    com.tencent.mm.kernel.g.afA().gcy.a(locall, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void azS()
  {
    AppMethodBeat.i(150805);
    com.tencent.mm.kernel.g.afB().afk().set(81939, Long.valueOf(bt.eGO()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    com.tencent.mm.kernel.g.afA().gcy.b(159, this);
    com.tencent.mm.kernel.g.afA().gcy.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150804);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).auQ() != 5))
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
        azS();
        paramString = t.azY().oA(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          ad.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        ad.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dkC);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new k(paramString.id, 5);
        com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
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
        azS();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.i
 * JD-Core Version:    0.7.0.1
 */