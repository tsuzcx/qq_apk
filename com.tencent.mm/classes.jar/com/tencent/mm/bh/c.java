package com.tencent.mm.bh;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements be.a
{
  public BlockingQueue<g.a> inz;
  public String mFileName;
  
  public c()
  {
    AppMethodBeat.i(148377);
    this.mFileName = null;
    this.inz = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(148377);
  }
  
  public final boolean aEm()
  {
    AppMethodBeat.i(148378);
    ad.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.aLo();
    try
    {
      ad.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new com.tencent.mm.vfs.e(str);
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).mkdirs();
      }
      locald.gC(str + this.mFileName + ".temp");
      while (this.inz.size() > 0)
      {
        localObject = (g.a)this.inz.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).dhO > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          AppMethodBeat.o(148378);
        }
      }
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.Ry();
      try
      {
        new com.tencent.mm.vfs.e(str + this.mFileName + ".temp").ag(new com.tencent.mm.vfs.e(str + this.mFileName + ".spx"));
        e.aLx().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bt.n(localException2) });
        }
      }
    }
  }
  
  public final boolean aEn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bh.c
 * JD-Core Version:    0.7.0.1
 */