package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.io.File;
import java.util.Map;

final class g$a
  implements Runnable
{
  private g$a(g paramg) {}
  
  public final void run()
  {
    long l1;
    synchronized (this.eMb)
    {
      y.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
        localFile = new File(g.Tz());
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
        localFile.delete();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "delete file failed", new Object[0]);
        }
      }
      g.a(this.eMb, new com.tencent.mm.f.b.c(16000, 1, 3));
      g.a(this.eMb).bCE = -19;
      g.a(this.eMb).aX(false);
      g.a(this.eMb, new com.tencent.mm.f.c.c(16000, 23900));
      if (!g.b(this.eMb).cG(g.Tz()))
      {
        y.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
        g.b(this.eMb).uE();
        g.a(this.eMb, null);
        this.eMb.bA(5, -1);
        return;
      }
    }
    if (q.dyn.dwY > 0)
    {
      g.a(this.eMb).t(q.dyn.dwY, true);
      label287:
      g.a(this.eMb).ey(50);
      g.a(this.eMb).aY(false);
    }
    for (;;)
    {
      try
      {
        g.a(this.eMb, new com.tencent.mm.modelvoiceaddr.a.c());
        g.d(this.eMb).eMI = g.c(this.eMb);
        com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100235");
        if (!localc.isValid()) {
          break label513;
        }
        i = bk.getInt((String)localc.ctr().get("MMVoipVadOn"), 0);
        g.a(this.eMb, new c(g.Tz(), String.valueOf(l1), String.valueOf(i), g.e(this.eMb), g.f(this.eMb)));
        g.a(this.eMb).bCP = g.g(this.eMb);
        if (g.a(this.eMb).uq()) {
          break;
        }
        y.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
        this.eMb.bA(8, -1);
      }
      catch (Throwable localThrowable)
      {
        y.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localThrowable, "init VoiceDetectAPI failed", new Object[0]);
        this.eMb.bA(7, -1);
      }
      g.a(this.eMb).t(5, false);
      break label287;
      break;
      label513:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.a
 * JD-Core Version:    0.7.0.1
 */