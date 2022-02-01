package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int tfM = 4;
  static int vOV = 4;
  ap handler;
  boolean stop;
  ap[] vOW;
  int vOX;
  private int vOY;
  private LinkedList<b> vOZ;
  private a vPa;
  b.a vPb;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.vOX = 0;
    this.vOY = 0;
    this.vOZ = new LinkedList();
    this.stop = false;
    this.vPb = new b.a()
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
    this.vPa = parama;
    vOV = -1;
    if (CaptureMMProxy.getInstance() != null) {
      vOV = CaptureMMProxy.getInstance().getInt(al.a.IwD, -1);
    }
    if (vOV == -1)
    {
      vOV = Runtime.getRuntime().availableProcessors();
      vOV = Math.min(tfM, vOV);
      ad.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(vOV), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.vOW = new ap[vOV];
      SightVideoJNI.initScaleAndRoateBuffer(vOV);
      int i = 0;
      while (i < this.vOW.length)
      {
        this.vOW[i] = new ap("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      ad.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(vOV) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void dng()
  {
    AppMethodBeat.i(89466);
    ad.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.vOZ.size()), Integer.valueOf(this.vOY) });
    for (;;)
    {
      if (this.vOZ.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      ad.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.vOZ.size()), Integer.valueOf(this.vOY) });
      Iterator localIterator = this.vOZ.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.vOY == localb.vPi)
        {
          this.vOY += 1;
          this.vPa.output(localb.vPg);
          this.vOZ.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean dnh()
  {
    return this.vOY == this.vOX;
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
    ad.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bt.flS().toString() });
    while (i < this.vOW.length)
    {
      if (this.vOW[i] != null)
      {
        this.vOW[i].getSerial().LVC.quit();
        this.vOW[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(vOV);
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