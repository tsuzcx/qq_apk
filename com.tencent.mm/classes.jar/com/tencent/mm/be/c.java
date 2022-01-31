package com.tencent.mm.be;

import com.tencent.mm.f.b.g.a;
import com.tencent.mm.f.c.d;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements av.a
{
  public BlockingQueue<g.a> eBd = new ArrayBlockingQueue(1024);
  public String mFileName = null;
  
  public final boolean JS()
  {
    y.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.Rb();
    try
    {
      y.i("MicroMsg.SpeexEncoderWorker", "path " + str);
      Object localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      locald.cG(str + this.mFileName + ".temp");
      while (this.eBd.size() > 0)
      {
        localObject = (g.a)this.eBd.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).bDu > 0)) {
          locald.a((g.a)localObject, 0, false);
        }
      }
      localException1.uE();
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
      return true;
    }
    try
    {
      new File(str + this.mFileName + ".temp").renameTo(new File(str + this.mFileName + ".spx"));
      e.Rk().start();
      return true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bk.j(localException2) });
      }
    }
  }
  
  public final boolean JT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.be.c
 * JD-Core Version:    0.7.0.1
 */