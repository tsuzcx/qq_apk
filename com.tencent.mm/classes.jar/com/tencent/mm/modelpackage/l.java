package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.r;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class l
  implements com.tencent.mm.am.h
{
  private l()
  {
    AppMethodBeat.i(150802);
    com.tencent.mm.kernel.h.baD().mCm.a(159, this);
    com.tencent.mm.kernel.h.baD().mCm.a(160, this);
    p localp = new p(5);
    com.tencent.mm.kernel.h.baD().mCm.a(localp, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void bLA()
  {
    AppMethodBeat.i(150805);
    com.tencent.mm.kernel.h.baE().ban().B(81939, Long.valueOf(Util.nowMilliSecond()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    com.tencent.mm.kernel.h.baD().mCm.b(159, this);
    com.tencent.mm.kernel.h.baD().mCm.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public static void update()
  {
    AppMethodBeat.i(230994);
    long l = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().d(81939, null), 0L);
    if (Util.nowMilliSecond() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new l();
      }
      AppMethodBeat.o(230994);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(150804);
    if ((!(paramp instanceof r)) || (((r)paramp).bFO() != 5))
    {
      Log.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(150804);
      return;
    }
    int i = paramp.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bLA();
        paramString = u.bLH().wK(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.hJK);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new o(paramString.id, 5);
        com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
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
        bLA();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.l
 * JD-Core Version:    0.7.0.1
 */