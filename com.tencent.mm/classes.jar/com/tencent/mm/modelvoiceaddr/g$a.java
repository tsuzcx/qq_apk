package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.e.a;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.io.File;
import java.util.Map;

final class g$a
  implements Runnable
{
  private g$a(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(116711);
    long l1;
    synchronized (this.gbI)
    {
      ab.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      long l2 = System.nanoTime() & 0xFFFFFFFF;
      l1 = l2;
      if (l2 < 0L) {
        l1 = Math.abs(l2);
      }
      try
      {
        File localFile = new File(g.access$100());
        if (!localFile.exists()) {
          localFile.mkdir();
        }
        localFile = new File(g.amL());
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
        localFile.delete();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "delete file failed", new Object[0]);
        }
      }
      g.a(this.gbI, new com.tencent.mm.audio.b.c(16000, 1, 3));
      g.a(this.gbI).cjs = -19;
      g.a(this.gbI).bz(false);
      g.a(this.gbI, new com.tencent.mm.audio.e.c(16000, 23900));
      if (!g.b(this.gbI).eN(g.amL()))
      {
        ab.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
        g.b(this.gbI).Fb();
        g.a(this.gbI, null);
        this.gbI.cL(5, -1);
        AppMethodBeat.o(116711);
        return;
      }
    }
    if (ac.erF.eoW > 0)
    {
      g.a(this.gbI).t(ac.erF.eoW, true);
      label302:
      g.a(this.gbI).gA(50);
      g.a(this.gbI).bA(false);
    }
    for (;;)
    {
      try
      {
        g.a(this.gbI, new com.tencent.mm.modelvoiceaddr.a.c(true, true));
        g.d(this.gbI).gcn = g.c(this.gbI);
        com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100235");
        if (!localc.isValid()) {
          break label532;
        }
        i = bo.getInt((String)localc.dvN().get("MMVoipVadOn"), 0);
        g.a(this.gbI, new c(g.amL(), String.valueOf(l1), String.valueOf(i), g.e(this.gbI), g.f(this.gbI)));
        g.a(this.gbI).cjD = g.g(this.gbI);
        if (g.a(this.gbI).EC()) {
          break;
        }
        ab.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
        this.gbI.cL(8, -1);
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localThrowable, "init VoiceDetectAPI failed", new Object[0]);
        this.gbI.cL(7, -1);
      }
      g.a(this.gbI).t(5, false);
      break label302;
      break;
      label532:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.a
 * JD-Core Version:    0.7.0.1
 */