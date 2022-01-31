package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(21813);
    try
    {
      c localc = this.nNX;
      localc.nNR = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
      localc.nNR.gA(20);
      localc.nNR.bA(true);
      localc.nNR.EB();
      localc.nNR.cjs = -19;
      localc.nNR.t(1, false);
      localc.nNR.bz(true);
      localc.nNR.cjD = localc.kJP;
      if (!localc.nNR.EC())
      {
        ab.e("MicroMsg.IPCallRecorder", "start record failed");
        if (localc.nNR.cjh != 13)
        {
          i.bJp().bJM();
          AppMethodBeat.o(21813);
        }
      }
      else
      {
        localc.nNR.bB(localc.efg);
      }
      AppMethodBeat.o(21813);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
      i.bJp().bJM();
      AppMethodBeat.o(21813);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.2
 * JD-Core Version:    0.7.0.1
 */