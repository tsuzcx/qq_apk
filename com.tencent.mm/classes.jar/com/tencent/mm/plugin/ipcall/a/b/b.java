package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements f.a, d.a, HeadsetPlugReceiver.a
{
  public MMActivity bER;
  public com.tencent.mm.compatible.util.b eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
  public HeadsetPlugReceiver iEH = new HeadsetPlugReceiver();
  public boolean iEI = false;
  public boolean iEJ = false;
  public a lqo = new a();
  public c lqp = new c();
  public d lqq = new d();
  public j lqr;
  private boolean lqs = false;
  public b.a lqt;
  public long lqu = 0L;
  
  public final void a(j paramj)
  {
    this.lqr = paramj;
    if (paramj != null) {
      i.bcl().bbJ();
    }
  }
  
  public final int bcy()
  {
    a locala = this.lqo;
    if ((locala.iEF != null) && (locala.bSr)) {
      return locala.iEF.bPH();
    }
    return -1;
  }
  
  public final void eH(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.lqt != null) && (paramBoolean != this.iEI))
    {
      this.iEI = paramBoolean;
      if (!this.iEJ) {
        this.lqt.gX(paramBoolean);
      }
    }
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          au.Hy().yk();
        } while ((!au.Hy().yn()) || (this.lqt == null));
        this.lqt.gX(true);
        return;
        this.iEJ = true;
      } while ((this.lqt == null) || (this.iEI));
      this.lqt.gY(true);
      return;
      this.iEJ = false;
    } while ((this.lqt == null) || (this.iEI));
    this.lqt.gY(false);
  }
  
  public final void gV(boolean paramBoolean)
  {
    this.lqo.gV(paramBoolean);
  }
  
  public final void gW(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MMActivity localMMActivity;
    if (this.bER != null)
    {
      localMMActivity = this.bER;
      if (paramBoolean) {
        break label70;
      }
    }
    for (;;)
    {
      localMMActivity.setScreenEnable(bool);
      if (i.bck().bcb())
      {
        if (!paramBoolean) {
          break;
        }
        this.lqs = a.ys();
        this.lqo.gV(false);
      }
      return;
      label70:
      bool = false;
    }
    this.lqo.gV(this.lqs);
  }
  
  public final void startRecord()
  {
    c localc = this.lqp;
    if (localc.bSr)
    {
      y.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      return;
    }
    y.i("MicroMsg.IPCallRecorder", "start record");
    localc.bSr = true;
    localc.lqx = i.bcj().lqo.lqk;
    if (localc.lqx <= 10)
    {
      if (localc.lqx <= 0)
      {
        y.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.bci().bcF();
      }
      localc.lqx = 92;
    }
    synchronized (localc.lqw)
    {
      e.post(new c.2(localc), "IPCallRecorder_startRecord");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.b
 * JD-Core Version:    0.7.0.1
 */