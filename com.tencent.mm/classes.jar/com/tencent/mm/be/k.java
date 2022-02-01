package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class k
  implements i
{
  private k()
  {
    AppMethodBeat.i(150802);
    h.aHF().kcd.a(159, this);
    h.aHF().kcd.a(160, this);
    o localo = new o(5);
    h.aHF().kcd.a(localo, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void bnN()
  {
    AppMethodBeat.i(150805);
    h.aHG().aHp().i(81939, Long.valueOf(Util.nowMilliSecond()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    h.aHF().kcd.b(159, this);
    h.aHF().kcd.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public static void update()
  {
    AppMethodBeat.i(207106);
    long l = Util.nullAs((Long)h.aHG().aHp().b(81939, null), 0L);
    if (Util.nowMilliSecond() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new k();
      }
      AppMethodBeat.o(207106);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150804);
    if ((!(paramq instanceof com.tencent.mm.an.s)) || (((com.tencent.mm.an.s)paramq).big() != 5))
    {
      Log.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(150804);
      return;
    }
    int i = paramq.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bnN();
        paramString = w.bnU().wJ(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.fES);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new n(paramString.id, 5);
        h.aHF().kcd.a(paramString, 0);
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
        bnN();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.k
 * JD-Core Version:    0.7.0.1
 */