package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int tDs = 4;
  static int tDt = 4;
  ap handler;
  boolean stop;
  b.a tDA;
  ap[] tDu;
  int tDv;
  private int tDw;
  private LinkedList<b> tDx;
  private a tDy;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.tDv = 0;
    this.tDw = 0;
    this.tDx = new LinkedList();
    this.stop = false;
    this.tDA = new b.a()
    {
      public final void a(final b paramAnonymousb)
      {
        AppMethodBeat.i(89464);
        a.a(a.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89463);
            a.a(a.this, paramAnonymousb);
            AppMethodBeat.o(89463);
          }
        });
        AppMethodBeat.o(89464);
      }
    };
    this.tDy = parama;
    tDt = -1;
    if (CaptureMMProxy.getInstance() != null) {
      tDt = CaptureMMProxy.getInstance().getInt(ae.a.Fmw, -1);
    }
    if (tDt == -1)
    {
      tDt = Runtime.getRuntime().availableProcessors();
      tDt = Math.min(tDs, tDt);
      ad.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(tDt), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.tDu = new ap[tDt];
      SightVideoJNI.initScaleAndRoateBuffer(tDt);
      int i = 0;
      while (i < this.tDu.length)
      {
        this.tDu[i] = new ap("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      ad.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(tDt) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void cQc()
  {
    AppMethodBeat.i(89466);
    ad.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.tDx.size()), Integer.valueOf(this.tDw) });
    for (;;)
    {
      if (this.tDx.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      ad.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.tDx.size()), Integer.valueOf(this.tDw) });
      Iterator localIterator = this.tDx.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.tDw == localb.tDH)
        {
          this.tDw += 1;
          this.tDy.output(localb.tDF);
          this.tDx.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean cQd()
  {
    return this.tDw == this.tDv;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(89468);
    try
    {
      stop();
      label9:
      super.finalize();
      AppMethodBeat.o(89468);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label9;
    }
  }
  
  public final void stop()
  {
    int i = 0;
    AppMethodBeat.i(89467);
    ad.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bt.eGN().toString() });
    while (i < this.tDu.length)
    {
      if (this.tDu[i] != null)
      {
        this.tDu[i].getSerial().IzX.quit();
        this.tDu[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(tDt);
    this.stop = true;
    AppMethodBeat.o(89467);
  }
  
  public static abstract interface a
  {
    public abstract void output(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */