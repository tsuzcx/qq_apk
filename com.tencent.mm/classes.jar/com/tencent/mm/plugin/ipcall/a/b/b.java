package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements g.a, d.a, HeadsetPlugReceiver.a
{
  public MMActivity cmc;
  public com.tencent.mm.compatible.util.b gaP;
  public HeadsetPlugReceiver kJT;
  public boolean kJU;
  public boolean kJV;
  public a nNK;
  public c nNL;
  public d nNM;
  public j nNN;
  private boolean nNO;
  public b.a nNP;
  public long nNQ;
  
  public b()
  {
    AppMethodBeat.i(21804);
    this.nNO = false;
    this.kJV = false;
    this.kJU = false;
    this.nNQ = 0L;
    this.nNK = new a();
    this.nNL = new c();
    this.nNM = new d();
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.kJT = new HeadsetPlugReceiver();
    AppMethodBeat.o(21804);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(21805);
    this.nNN = paramj;
    if (paramj != null) {
      i.bJs().bIQ();
    }
    AppMethodBeat.o(21805);
  }
  
  public final void bJF()
  {
    AppMethodBeat.i(21806);
    this.nNM.nNZ = this;
    d locald = this.nNM;
    if (!locald.mub.yqq)
    {
      locald.mub.a(locald);
      d.1 local1 = new d.1(locald);
      if (locald.mtY.ai(local1))
      {
        locald.lastShakeTime = 0L;
        AppMethodBeat.o(21806);
        return;
      }
      locald.lastShakeTime = -1L;
    }
    AppMethodBeat.o(21806);
  }
  
  public final int bJG()
  {
    AppMethodBeat.i(21811);
    a locala = this.nNK;
    if ((locala.kJR != null) && (locala.isStart))
    {
      int i = locala.kJR.cLL();
      AppMethodBeat.o(21811);
      return i;
    }
    AppMethodBeat.o(21811);
    return -1;
  }
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(21810);
    ab.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.nNP != null) && (paramBoolean != this.kJU))
    {
      this.kJU = paramBoolean;
      if (!this.kJV) {
        this.nNP.iH(paramBoolean);
      }
    }
    AppMethodBeat.o(21810);
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(21809);
    ab.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21809);
      return;
      aw.aaA().KE();
      if ((aw.aaA().KH()) && (this.nNP != null))
      {
        this.nNP.iH(true);
        AppMethodBeat.o(21809);
        return;
        this.kJV = true;
        if ((this.nNP != null) && (!this.kJU))
        {
          this.nNP.iI(true);
          AppMethodBeat.o(21809);
          return;
          this.kJV = false;
          if ((this.nNP != null) && (!this.kJU))
          {
            this.nNP.iI(false);
            AppMethodBeat.o(21809);
            return;
            g.KC().KE();
          }
        }
      }
    }
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(21807);
    this.nNK.iE(paramBoolean);
    AppMethodBeat.o(21807);
  }
  
  public final void iG(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(21808);
    ab.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.cmc != null)
    {
      localMMActivity = this.cmc;
      if (paramBoolean) {
        break label82;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (!i.bJr().bJi()) {
        break label98;
      }
      if (!paramBoolean) {
        break;
      }
      this.nNO = a.KM();
      this.nNK.iE(false);
      AppMethodBeat.o(21808);
      return;
      label82:
      bool = false;
    }
    this.nNK.iE(this.nNO);
    label98:
    AppMethodBeat.o(21808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.b
 * JD-Core Version:    0.7.0.1
 */