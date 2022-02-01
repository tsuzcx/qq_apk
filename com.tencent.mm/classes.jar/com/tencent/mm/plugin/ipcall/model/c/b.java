package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements d.a
{
  public com.tencent.mm.plugin.ipcall.model.a.a JHB;
  public d JHE;
  public i JHF;
  public long JHG;
  public MMActivity lzt;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.JHG = 0L;
    this.JHE = new d();
    this.JHB = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.JHB.JGO = paramb;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(25420);
    this.JHF = parami;
    if (parami != null) {
      h.fRv().xz(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void fRJ()
  {
    AppMethodBeat.i(25421);
    this.JHE.JHO = this;
    d locald = this.JHE;
    if (!locald.xCV.hasRegistered())
    {
      locald.xCV.setSensorCallBack(locald);
      d.1 local1 = new d.1(locald);
      if (locald.xCU.startShake(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int fwf()
  {
    AppMethodBeat.i(25426);
    a locala = this.JHB.JGP;
    if (locala == null)
    {
      AppMethodBeat.o(25426);
      return 0;
    }
    if ((locala.wTy != null) && (locala.isStart))
    {
      int i = locala.wTy.gdZ();
      AppMethodBeat.o(25426);
      return i;
    }
    AppMethodBeat.o(25426);
    return -1;
  }
  
  public final void xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.JHB.ee(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void xK(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    Log.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.lzt != null)
    {
      localMMActivity = this.lzt;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!h.fRu().fRk()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.JHB.ee(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.JHB.fRC();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */