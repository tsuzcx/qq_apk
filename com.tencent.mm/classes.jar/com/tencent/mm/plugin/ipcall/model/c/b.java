package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements d.a
{
  public MMActivity iMV;
  public com.tencent.mm.plugin.ipcall.model.a.a tJo;
  public d tJr;
  public j tJs;
  public long tJt;
  
  public b()
  {
    AppMethodBeat.i(25419);
    this.tJt = 0L;
    this.tJr = new d();
    this.tJo = new com.tencent.mm.plugin.ipcall.model.a.a();
    AppMethodBeat.o(25419);
  }
  
  public final void a(a.b paramb)
  {
    this.tJo.tIy = paramb;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(25420);
    this.tJs = paramj;
    if (paramj != null) {
      i.cUA().nf(false);
    }
    AppMethodBeat.o(25420);
  }
  
  public final void cUN()
  {
    AppMethodBeat.i(25421);
    this.tJr.tJC = this;
    d locald = this.tJr;
    if (!locald.oUL.aKH)
    {
      locald.oUL.a(locald);
      d.1 local1 = new d.1(locald);
      if (locald.oUK.aE(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(25421);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(25421);
  }
  
  public final int cUO()
  {
    AppMethodBeat.i(25426);
    a locala = this.tJo.tIz;
    if (locala != null)
    {
      if ((locala.osB != null) && (locala.isStart))
      {
        int i = locala.osB.aKj();
        AppMethodBeat.o(25426);
        return i;
      }
      AppMethodBeat.o(25426);
      return -1;
    }
    AppMethodBeat.o(25426);
    return 0;
  }
  
  public final void np(boolean paramBoolean)
  {
    AppMethodBeat.i(25422);
    this.tJo.cm(paramBoolean);
    AppMethodBeat.o(25422);
  }
  
  public final void nq(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25423);
    ac.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.iMV != null)
    {
      localMMActivity = this.iMV;
      if (paramBoolean) {
        break label75;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.cUz().cUp()) {
        break label87;
      }
      if (!paramBoolean) {
        break;
      }
      this.tJo.cm(false);
      AppMethodBeat.o(25423);
      return;
      label75:
      bool = false;
    }
    this.tJo.cUH();
    label87:
    AppMethodBeat.o(25423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.b
 * JD-Core Version:    0.7.0.1
 */