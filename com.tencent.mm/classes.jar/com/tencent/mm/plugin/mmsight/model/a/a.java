package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int mid = 4;
  static int mie = 4;
  ah handler;
  HandlerThread[] mif;
  int mig = 0;
  private int mih = 0;
  private LinkedList<b> mii = new LinkedList();
  private a.a mij;
  b.a mik = new a.1(this);
  boolean stop = false;
  
  public a(a.a parama)
  {
    this.mij = parama;
    mie = -1;
    if (CaptureMMProxy.getInstance() != null) {
      mie = CaptureMMProxy.getInstance().getInt(ac.a.utT, -1);
    }
    if (mie == -1)
    {
      mie = Runtime.getRuntime().availableProcessors();
      mie = Math.min(mid, mie);
      y.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(mie), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.mif = new HandlerThread[mie];
      SightVideoJNI.initScaleAndRoateBuffer(mie);
      int i = 0;
      while (i < this.mif.length)
      {
        this.mif[i] = e.ds("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_" + i, -1);
        this.mif[i].start();
        i += 1;
      }
      y.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(mie) });
    }
    this.stop = false;
  }
  
  private void bjf()
  {
    y.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.mii.size()), Integer.valueOf(this.mih) });
    for (;;)
    {
      if (this.mii.size() == 0) {
        return;
      }
      y.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.mii.size()), Integer.valueOf(this.mih) });
      Iterator localIterator = this.mii.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.mih == localb.mis)
        {
          this.mih += 1;
          this.mij.output(localb.miq);
          this.mii.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0) {
        return;
      }
    }
  }
  
  public final boolean bjg()
  {
    return this.mih == this.mig;
  }
  
  protected final void finalize()
  {
    try
    {
      stop();
      label4:
      super.finalize();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label4;
    }
  }
  
  public final void stop()
  {
    int i = 0;
    y.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bk.csb().toString() });
    while (i < this.mif.length)
    {
      if (this.mif[i] != null)
      {
        this.mif[i].quit();
        this.mif[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(mie);
    this.stop = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */