package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int Hcc = 4;
  static int KWj = 4;
  MMHandler[] KWk;
  int KWl;
  private int KWm;
  private LinkedList<b> KWn;
  private a KWo;
  b.a KWp;
  MMHandler handler;
  boolean stop;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.KWl = 0;
    this.KWm = 0;
    this.KWn = new LinkedList();
    this.stop = false;
    this.KWp = new b.a()
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
    this.KWo = parama;
    KWj = -1;
    if (CaptureMMProxy.getInstance() != null) {
      KWj = CaptureMMProxy.getInstance().getInt(at.a.acOy, -1);
    }
    if (KWj == -1)
    {
      KWj = Runtime.getRuntime().availableProcessors();
      KWj = Math.min(Hcc, KWj);
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(KWj), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.KWk = new MMHandler[KWj];
      SightVideoJNI.initScaleAndRoateBuffer(KWj);
      int i = 0;
      while (i < this.KWk.length)
      {
        this.KWk[i] = new MMHandler("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(KWj) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void gcu()
  {
    AppMethodBeat.i(89466);
    Log.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.KWn.size()), Integer.valueOf(this.KWm) });
    for (;;)
    {
      if (this.KWn.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      Log.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.KWn.size()), Integer.valueOf(this.KWm) });
      Iterator localIterator = this.KWn.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.KWm == localb.KWw)
        {
          this.KWm += 1;
          this.KWo.bZ(localb.KWu);
          this.KWn.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
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
    finally
    {
      break label9;
    }
  }
  
  public final boolean gcv()
  {
    return this.KWm == this.KWl;
  }
  
  public final void stop()
  {
    int i = 0;
    AppMethodBeat.i(89467);
    Log.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { Util.getStack().toString() });
    while (i < this.KWk.length)
    {
      if (this.KWk[i] != null)
      {
        this.KWk[i].getSerial().ahCy.quit();
        this.KWk[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(KWj);
    this.stop = true;
    AppMethodBeat.o(89467);
  }
  
  public static abstract interface a
  {
    public abstract void bZ(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */