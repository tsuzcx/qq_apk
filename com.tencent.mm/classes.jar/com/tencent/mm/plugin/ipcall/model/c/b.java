package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements d.a
{
  public MMActivity imP;
  public com.tencent.mm.plugin.ipcall.model.a.a sBG;
  public d sBJ;
  public j sBK;
  public long sBL;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.sBL = 0L;
    this.sBJ = new d();
    this.sBG = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.sBG.sAP = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.sBK = paramj;
    if (paramj != null) {
      i.cHp().mm(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void cHC()
  {
    AppMethodBeat.i(25421);
    this.sBJ.sBU = this;
    d locald = this.sBJ;
    if (!locald.orl.aJR)
    {
      locald.orl.a(locald);
      d.1 local1 = new d.1(locald);
      if (locald.ork.aC(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int cHD()
  {
    AppMethodBeat.i(25426);
    a locala = this.sBG.sAQ;
    if (locala != null)
    {
      if ((locala.nPx != null) && (locala.isStart))
      {
        int i = locala.nPx.aDs();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.sBG.ck(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void mx(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    ad.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.imP != null)
    {
      localMMActivity = this.imP;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.cHo().cHe()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.sBG.ck(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.sBG.cHw();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */