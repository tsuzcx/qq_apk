package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    try
    {
      c localc = this.lqB;
      localc.lqv = new com.tencent.mm.f.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
      localc.lqv.ey(20);
      localc.lqv.aY(true);
      localc.lqv.up();
      localc.lqv.bCE = -19;
      localc.lqv.t(1, false);
      localc.lqv.aX(true);
      localc.lqv.bCP = localc.iED;
      if (!localc.lqv.uq())
      {
        y.e("MicroMsg.IPCallRecorder", "start record failed");
        if (localc.lqv.bCt != 13) {
          i.bci().bcF();
        }
      }
      else
      {
        localc.lqv.aZ(localc.dnJ);
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
      i.bci().bcF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.2
 * JD-Core Version:    0.7.0.1
 */