package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements az.a
{
  public BlockingQueue<g.a> fQV;
  public String mFileName;
  
  public c()
  {
    AppMethodBeat.i(116541);
    this.mFileName = null;
    this.fQV = new ArrayBlockingQueue(1024);
    AppMethodBeat.o(116541);
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(116542);
    ab.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.aki();
    try
    {
      ab.i("MicroMsg.SpeexEncoderWorker", "path ".concat(String.valueOf(str)));
      Object localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      locald.eN(str + this.mFileName + ".temp");
      while (this.fQV.size() > 0)
      {
        localObject = (g.a)this.fQV.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).ckj > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          AppMethodBeat.o(116542);
        }
      }
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.Fb();
      try
      {
        new File(str + this.mFileName + ".temp").renameTo(new File(str + this.mFileName + ".spx"));
        e.aks().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bo.l(localException2) });
        }
      }
    }
  }
  
  public final boolean acT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bf.c
 * JD-Core Version:    0.7.0.1
 */