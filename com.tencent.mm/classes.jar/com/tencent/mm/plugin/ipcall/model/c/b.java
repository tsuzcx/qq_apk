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
  public MMActivity fLP;
  public com.tencent.mm.plugin.ipcall.model.a.a uMb;
  public d uMe;
  public j uMf;
  public long uMg;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.uMg = 0L;
    this.uMe = new d();
    this.uMb = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.uMb.uLl = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.uMf = paramj;
    if (paramj != null) {
      i.ddL().nz(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void ddY()
  {
    AppMethodBeat.i(25421);
    this.uMe.uMp = this;
    d locald = this.uMe;
    if (!locald.pyv.aMy)
    {
      locald.pyv.a(locald);
      d.1 local1 = new d.1(locald);
      if (locald.pyu.aD(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int ddZ()
  {
    AppMethodBeat.i(25426);
    a locala = this.uMb.uLm;
    if (locala != null)
    {
      if ((locala.oVX != null) && (locala.isStart))
      {
        int i = locala.oVX.aNs();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void nJ(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.uMb.cn(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void nK(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    ad.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.fLP != null)
    {
      localMMActivity = this.fLP;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.ddK().ddA()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.uMb.cn(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.uMb.ddS();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */