package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int tqF = 4;
  static int waY = 4;
  aq handler;
  boolean stop;
  aq[] waZ;
  int wba;
  private int wbb;
  private LinkedList<b> wbc;
  private a wbd;
  b.a wbe;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.wba = 0;
    this.wbb = 0;
    this.wbc = new LinkedList();
    this.stop = false;
    this.wbe = new b.a()
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
    this.wbd = parama;
    waY = -1;
    if (CaptureMMProxy.getInstance() != null) {
      waY = CaptureMMProxy.getInstance().getInt(am.a.IRb, -1);
    }
    if (waY == -1)
    {
      waY = Runtime.getRuntime().availableProcessors();
      waY = Math.min(tqF, waY);
      ae.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(waY), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.waZ = new aq[waY];
      SightVideoJNI.initScaleAndRoateBuffer(waY);
      int i = 0;
      while (i < this.waZ.length)
      {
        this.waZ[i] = new aq("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      ae.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(waY) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void dqe()
  {
    AppMethodBeat.i(89466);
    ae.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.wbc.size()), Integer.valueOf(this.wbb) });
    for (;;)
    {
      if (this.wbc.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      ae.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.wbc.size()), Integer.valueOf(this.wbb) });
      Iterator localIterator = this.wbc.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.wbb == localb.wbl)
        {
          this.wbb += 1;
          this.wbd.output(localb.wbj);
          this.wbc.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean dqf()
  {
    return this.wbb == this.wba;
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
    ae.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bu.fpN().toString() });
    while (i < this.waZ.length)
    {
      if (this.waZ[i] != null)
      {
        this.waZ[i].getSerial().Msx.quit();
        this.waZ[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(waY);
    this.stop = true;
    AppMethodBeat.o(89467);
  }
  
  public static abstract interface a
  {
    public abstract void output(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */