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
  public MMActivity gte;
  public com.tencent.mm.plugin.ipcall.model.a.a yqo;
  public d yqr;
  public j yqs;
  public long yqt;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.yqt = 0L;
    this.yqr = new d();
    this.yqo = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.yqo.ypz = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.yqs = paramj;
    if (paramj != null) {
      i.eax().qm(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void eaK()
  {
    AppMethodBeat.i(25421);
    this.yqr.yqC = this;
    d locald = this.yqr;
    if (!locald.qUq.hasRegistered())
    {
      locald.qUq.setSensorCallBack(locald);
      d.1 local1 = new d.1(locald);
      if (locald.qUp.startShake(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int eaL()
  {
    AppMethodBeat.i(25426);
    a locala = this.yqo.ypA;
    if (locala != null)
    {
      if ((locala.qrz != null) && (locala.isStart))
      {
        int i = locala.qrz.bhV();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void qw(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.yqo.cV(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void qx(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    Log.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.gte != null)
    {
      localMMActivity = this.gte;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.eaw().eam()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.yqo.cV(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.yqo.eaE();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */