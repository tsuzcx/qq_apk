package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int oIk = 4;
  static int oIl = 4;
  ak handler;
  HandlerThread[] oIm;
  int oIn;
  private int oIo;
  private LinkedList<b> oIp;
  private a.a oIq;
  boolean oIr;
  b.a oIs;
  
  public a(a.a parama)
  {
    AppMethodBeat.i(76564);
    this.oIn = 0;
    this.oIo = 0;
    this.oIp = new LinkedList();
    this.oIr = false;
    this.oIs = new a.1(this);
    this.oIq = parama;
    oIl = -1;
    if (CaptureMMProxy.getInstance() != null) {
      oIl = CaptureMMProxy.getInstance().getInt(ac.a.yDW, -1);
    }
    if (oIl == -1)
    {
      oIl = Runtime.getRuntime().availableProcessors();
      oIl = Math.min(oIk, oIl);
      ab.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[] { Integer.valueOf(oIl), Integer.valueOf(Runtime.getRuntime().availableProcessors()) });
    }
    for (;;)
    {
      this.oIm = new HandlerThread[oIl];
      SightVideoJNI.initScaleAndRoateBuffer(oIl);
      int i = 0;
      while (i < this.oIm.length)
      {
        this.oIm[i] = d.ey("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_".concat(String.valueOf(i)), -1);
        this.oIm[i].start();
        i += 1;
      }
      ab.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[] { Integer.valueOf(oIl) });
    }
    this.oIr = false;
    AppMethodBeat.o(76564);
  }
  
  private void bRi()
  {
    AppMethodBeat.i(76565);
    ab.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[] { Integer.valueOf(this.oIp.size()), Integer.valueOf(this.oIo) });
    for (;;)
    {
      if (this.oIp.size() == 0)
      {
        AppMethodBeat.o(76565);
        return;
      }
      ab.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[] { Integer.valueOf(this.oIp.size()), Integer.valueOf(this.oIo) });
      Iterator localIterator = this.oIp.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (this.oIo == localb.oIz)
        {
          this.oIo += 1;
          this.oIq.output(localb.oIx);
          this.oIp.remove(localb);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(76565);
        return;
      }
    }
  }
  
  public final boolean bRj()
  {
    return this.oIo == this.oIn;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(76567);
    try
    {
      stop();
      label9:
      super.finalize();
      AppMethodBeat.o(76567);
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
    AppMethodBeat.i(76566);
    ab.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[] { bo.dtY().toString() });
    while (i < this.oIm.length)
    {
      if (this.oIm[i] != null)
      {
        this.oIm[i].quit();
        this.oIm[i] = null;
      }
      i += 1;
    }
    SightVideoJNI.releaseScaleAndRoateBuffer(oIl);
    this.oIr = true;
    AppMethodBeat.o(76566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.a
 * JD-Core Version:    0.7.0.1
 */