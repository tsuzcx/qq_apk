package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int Bvh = 4;
  static int FaA = 4;
  MMHandler[] FaB;
  int FaC;
  private int FaD;
  private LinkedList<b> FaE;
  private a FaF;
  b.a FaG;
  MMHandler handler;
  boolean stop;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.FaC = 0;
    this.FaD = 0;
    this.FaE = new LinkedList();
    this.stop = false;
    this.FaG = new b.a()
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
    this.FaF = parama;
    FaA = -1;
    if (CaptureMMProxy.getInstance() != null) {
      FaA = CaptureMMProxy.getInstance().getInt(ar.a.Vnd, -1);
    }
    if (FaA == -1)
    {
      FaA = Runtime.getRuntime().availableProcessors();
      FaA = Math.min(Bvh, FaA);
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(FaA), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.FaB = new MMHandler[FaA];
      SightVideoJNI.initScaleAndRoateBuffer(FaA);
      int i = 0;
      while (i < this.FaB.length)
      {
        this.FaB[i] = new MMHandler("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(FaA) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void eTB()
  {
    AppMethodBeat.i(89466);
    Log.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.FaE.size()), Integer.valueOf(this.FaD) });
    for (;;)
    {
      if (this.FaE.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      Log.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.FaE.size()), Integer.valueOf(this.FaD) });
      Iterator localIterator = this.FaE.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.FaD == localb.FaN)
        {
          this.FaD += 1;
          this.FaF.bX(localb.FaL);
          this.FaE.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean eTC()
  {
    return this.FaD == this.FaC;
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
    Log.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { Util.getStack().toString() });
    while (i < this.FaB.length)
    {
      if (this.FaB[i] != null)
      {
        this.FaB[i].getSerial().Zxu.quit();
        this.FaB[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(FaA);
    this.stop = true;
    AppMethodBeat.o(89467);
  }
  
  public static abstract interface a
  {
    public abstract void bX(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */