package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements d.a
{
  public com.tencent.mm.plugin.ipcall.model.a.a DQq;
  public d DQt;
  public j DQu;
  public long DQv;
  public MMActivity iXq;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.DQv = 0L;
    this.DQt = new d();
    this.DQq = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.DQq.DPB = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.DQu = paramj;
    if (paramj != null) {
      i.eJv().to(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void eJI()
  {
    AppMethodBeat.i(25421);
    this.DQt.DQE = this;
    d locald = this.DQt;
    if (!locald.uww.hasRegistered())
    {
      locald.uww.setSensorCallBack(locald);
      d.1 local1 = new d.1(locald);
      if (locald.uwv.startShake(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int eJJ()
  {
    AppMethodBeat.i(25426);
    a locala = this.DQq.DPC;
    if (locala != null)
    {
      if ((locala.tQh != null) && (locala.isStart))
      {
        int i = locala.tQh.gxF();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.DQq.ds(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void tz(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    Log.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.iXq != null)
    {
      localMMActivity = this.iXq;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.eJu().eJk()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.DQq.ds(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.DQq.eJC();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */