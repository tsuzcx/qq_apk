package com.tencent.mm.bb;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements QueueWorkerThread.ThreadObject
{
  public String mFileName;
  public BlockingQueue<g.a> oUB;
  
  public c()
  {
    AppMethodBeat.i(148377);
    this.mFileName = null;
    this.oUB = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(148377);
  }
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(148378);
    Log.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.bML();
    try
    {
      Log.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new u(str);
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
      locald.jO(str + this.mFileName + ".temp");
      while (this.oUB.size() > 0)
      {
        localObject = (g.a)this.oUB.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).hxg > 0))
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
      localException1.aIz();
      try
      {
        new u(str + this.mFileName + ".temp").am(new u(str + this.mFileName + ".spx"));
        e.bMU().start();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */