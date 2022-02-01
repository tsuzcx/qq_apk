package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements bd.a
{
  public BlockingQueue<g.a> hUe;
  public String mFileName;
  
  public c()
  {
    AppMethodBeat.i(148377);
    this.mFileName = null;
    this.hUe = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(148377);
  }
  
  public final boolean aBj()
  {
    AppMethodBeat.i(148378);
    ac.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.aId();
    try
    {
      ac.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new com.tencent.mm.vfs.e(str);
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).mkdirs();
      }
      locald.fH(str + this.mFileName + ".temp");
      while (this.hUe.size() > 0)
      {
        localObject = (g.a)this.hUe.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).cWy > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          AppMethodBeat.o(148378);
        }
      }
    }
    catch (Exception localException1)
    {
      ac.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.PM();
      try
      {
        new com.tencent.mm.vfs.e(str + this.mFileName + ".temp").ae(new com.tencent.mm.vfs.e(str + this.mFileName + ".spx"));
        e.aIn().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bs.m(localException2) });
        }
      }
    }
  }
  
  public final boolean aBk()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bg.c
 * JD-Core Version:    0.7.0.1
 */