package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class c$9
  implements Runnable
{
  c$9(c paramc, LinkedBlockingQueue paramLinkedBlockingQueue) {}
  
  public final void run()
  {
    for (;;)
    {
      if ((!c.m(this.hIn)) && (!c.aue())) {
        try
        {
          c.a locala = (c.a)this.hIp.poll(500L, TimeUnit.MILLISECONDS);
          y.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.hIp.size()), locala });
          if (locala != null) {
            this.hIn.a(locala.gEA, locala.type, locala.buf, locala.eAK);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.9
 * JD-Core Version:    0.7.0.1
 */