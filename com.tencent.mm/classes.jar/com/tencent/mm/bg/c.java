package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements bf.a
{
  public BlockingQueue<g.a> iqt;
  public String mFileName;
  
  public c()
  {
    AppMethodBeat.i(148377);
    this.mFileName = null;
    this.iqt = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(148377);
  }
  
  public final boolean aEC()
  {
    AppMethodBeat.i(148378);
    ae.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.aLL();
    try
    {
      ae.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new k(str);
      if (!((k)localObject).exists()) {
        ((k)localObject).mkdirs();
      }
      locald.gI(str + this.mFileName + ".temp");
      while (this.iqt.size() > 0)
      {
        localObject = (g.a)this.iqt.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).diR > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          AppMethodBeat.o(148378);
        }
      }
    }
    catch (Exception localException1)
    {
      ae.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.Rx();
      try
      {
        new k(str + this.mFileName + ".temp").ag(new k(str + this.mFileName + ".spx"));
        e.aLU().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bu.o(localException2) });
        }
      }
    }
  }
  
  public final boolean aED()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bg.c
 * JD-Core Version:    0.7.0.1
 */