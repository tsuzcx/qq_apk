package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class i
  implements f
{
  public i()
  {
    AppMethodBeat.i(78448);
    g.RK().eHt.a(159, this);
    g.RK().eHt.a(160, this);
    k localk = new k(5);
    g.RK().eHt.a(localk, 0);
    AppMethodBeat.o(78448);
  }
  
  private static void aiJ()
  {
    AppMethodBeat.i(78451);
    g.RL().Ru().set(81939, Long.valueOf(bo.aoy()));
    AppMethodBeat.o(78451);
  }
  
  private void release()
  {
    AppMethodBeat.i(78449);
    g.RK().eHt.b(159, this);
    g.RK().eHt.b(160, this);
    AppMethodBeat.o(78449);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(78450);
    if ((!(paramm instanceof o)) || (((o)paramm).ads() != 5))
    {
      ab.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(78450);
      return;
    }
    int i = paramm.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aiJ();
        paramString = r.aiP().lS(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          ab.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(78450);
          return;
        }
        paramString = paramString[0];
        ab.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.cvs);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(78450);
          return;
        }
        paramString = new j(paramString.id, 5);
        g.RK().eHt.a(paramString, 0);
        AppMethodBeat.o(78450);
        return;
      }
      release();
      AppMethodBeat.o(78450);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        aiJ();
      }
      release();
    }
    AppMethodBeat.o(78450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ba.i
 * JD-Core Version:    0.7.0.1
 */