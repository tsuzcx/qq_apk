package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int sjk = 4;
  static int uLP = 4;
  ao handler;
  boolean stop;
  ao[] uLQ;
  int uLR;
  private int uLS;
  private LinkedList<b> uLT;
  private a uLU;
  b.a uLV;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.uLR = 0;
    this.uLS = 0;
    this.uLT = new LinkedList();
    this.stop = false;
    this.uLV = new b.a()
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
    this.uLU = parama;
    uLP = -1;
    if (CaptureMMProxy.getInstance() != null) {
      uLP = CaptureMMProxy.getInstance().getInt(ah.a.GKl, -1);
    }
    if (uLP == -1)
    {
      uLP = Runtime.getRuntime().availableProcessors();
      uLP = Math.min(sjk, uLP);
      ac.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(uLP), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.uLQ = new ao[uLP];
      SightVideoJNI.initScaleAndRoateBuffer(uLP);
      int i = 0;
      while (i < this.uLQ.length)
      {
        this.uLQ[i] = new ao("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      ac.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(uLP) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void ddK()
  {
    AppMethodBeat.i(89466);
    ac.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.uLT.size()), Integer.valueOf(this.uLS) });
    for (;;)
    {
      if (this.uLT.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      ac.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.uLT.size()), Integer.valueOf(this.uLS) });
      Iterator localIterator = this.uLT.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.uLS == localb.uMc)
        {
          this.uLS += 1;
          this.uLU.output(localb.uMa);
          this.uLT.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean ddL()
  {
    return this.uLS == this.uLR;
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
    ac.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bs.eWi().toString() });
    while (i < this.uLQ.length)
    {
      if (this.uLQ[i] != null)
      {
        this.uLQ[i].getSerial().KbG.quit();
        this.uLQ[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(uLP);
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