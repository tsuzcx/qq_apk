package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements d.a
{
  public MMActivity fNT;
  public com.tencent.mm.plugin.ipcall.model.a.a uXO;
  public d uXR;
  public j uXS;
  public long uXT;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.uXT = 0L;
    this.uXR = new d();
    this.uXO = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.uXO.uWY = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.uXS = paramj;
    if (paramj != null) {
      i.dgD().nD(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void dgQ()
  {
    AppMethodBeat.i(25421);
    this.uXR.uYc = this;
    d locald = this.uXR;
    if (!locald.pEZ.aMy)
    {
      locald.pEZ.a(locald);
      d.1 local1 = new d.1(locald);
      if (locald.pEY.aB(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int dgR()
  {
    AppMethodBeat.i(25426);
    a locala = this.uXO.uWZ;
    if (locala != null)
    {
      if ((locala.pcA != null) && (locala.isStart))
      {
        int i = locala.pcA.aNQ();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.uXO.cn(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void nO(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    ae.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.fNT != null)
    {
      localMMActivity = this.fNT;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.dgC().dgs()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.uXO.cn(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.uXO.dgK();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */