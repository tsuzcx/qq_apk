package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.f.j.d;
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
  private static int wEc = 4;
  static int zvb = 4;
  MMHandler handler;
  boolean stop;
  MMHandler[] zvc;
  int zvd;
  private int zve;
  private LinkedList<b> zvf;
  private a zvg;
  b.a zvh;
  
  public a(a parama)
  {
    AppMethodBeat.i(89465);
    this.zvd = 0;
    this.zve = 0;
    this.zvf = new LinkedList();
    this.stop = false;
    this.zvh = new b.a()
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
    this.zvg = parama;
    zvb = -1;
    if (CaptureMMProxy.getInstance() != null) {
      zvb = CaptureMMProxy.getInstance().getInt(ar.a.NZd, -1);
    }
    if (zvb == -1)
    {
      zvb = Runtime.getRuntime().availableProcessors();
      zvb = Math.min(wEc, zvb);
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(zvb), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.zvc = new MMHandler[zvb];
      SightVideoJNI.initScaleAndRoateBuffer(zvb);
      int i = 0;
      while (i < this.zvc.length)
      {
        this.zvc[i] = new MMHandler("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)));
        i += 1;
      }
      Log.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(zvb) });
    }
    this.stop = false;
    AppMethodBeat.o(89465);
  }
  
  private void ejU()
  {
    AppMethodBeat.i(89466);
    Log.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.zvf.size()), Integer.valueOf(this.zve) });
    for (;;)
    {
      if (this.zvf.size() == 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
      Log.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.zvf.size()), Integer.valueOf(this.zve) });
      Iterator localIterator = this.zvf.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.zve == localb.zvo)
        {
          this.zve += 1;
          this.zvg.output(localb.zvm);
          this.zvf.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(89466);
        return;
      }
    }
  }
  
  public final boolean ejV()
  {
    return this.zve == this.zvd;
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
    while (i < this.zvc.length)
    {
      if (this.zvc[i] != null)
      {
        this.zvc[i].getSerial().RUS.quit();
        this.zvc[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(zvb);
    this.stop = true;
    AppMethodBeat.o(89467);
  }
  
  public static abstract interface a
  {
    public abstract void output(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */