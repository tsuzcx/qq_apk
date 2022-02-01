package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements QueueWorkerThread.ThreadObject
{
  public String mFileName;
  public BlockingQueue<g.a> mbG;
  
  public c()
  {
    AppMethodBeat.i(148377);
    this.mFileName = null;
    this.mbG = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(148377);
  }
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(148378);
    Log.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.bpe();
    try
    {
      Log.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new q(str);
      if (!((q)localObject).ifE()) {
        ((q)localObject).ifK();
      }
      locald.in(str + this.mFileName + ".temp");
      while (this.mbG.size() > 0)
      {
        localObject = (g.a)this.mbG.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).fsR > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          AppMethodBeat.o(148378);
        }
      }
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.agC();
      try
      {
        new q(str + this.mFileName + ".temp").aj(new q(str + this.mFileName + ".spx"));
        e.bpn().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
        }
      }
    }
  }
  
  public final boolean onPostExecute()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bi.c
 * JD-Core Version:    0.7.0.1
 */