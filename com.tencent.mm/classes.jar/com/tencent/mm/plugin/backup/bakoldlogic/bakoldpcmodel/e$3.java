package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;

final class e$3
  implements g
{
  e$3(e parame, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21899);
    if (paramn != this.mzf.myX)
    {
      ad.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
      AppMethodBeat.o(21899);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
      paramString = (com.tencent.mm.plugin.backup.bakoldlogic.c.e)paramn;
      a.byd().mqh = paramString.mzF;
      this.mzi.run();
    }
    for (;;)
    {
      az.aeS().b(596, this);
      AppMethodBeat.o(21899);
      return;
      this.mzf.av(10010, new String("getPcPwd Fail"));
      ad.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
      this.mzj.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.3
 * JD-Core Version:    0.7.0.1
 */