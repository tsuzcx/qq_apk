package com.tencent.mm.danmaku.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.d.a.a;
import com.tencent.mm.danmaku.d.g;
import com.tencent.mm.danmaku.d.g.a;
import com.tencent.mm.danmaku.e.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class i
{
  HandlerThread gOA;
  private a gOB;
  int gOC;
  Boolean gOu;
  Handler gOz;
  
  public i(d paramd)
  {
    AppMethodBeat.i(241663);
    this.gOu = Boolean.FALSE;
    this.gOC = 0;
    this.gOB = new a(paramd, (byte)0);
    AppMethodBeat.o(241663);
  }
  
  private boolean ass()
  {
    return this.gOC == 1;
  }
  
  protected final void asp()
  {
    AppMethodBeat.i(241664);
    if (this.gOz != null) {
      this.gOz.removeMessages(4);
    }
    AppMethodBeat.o(241664);
  }
  
  protected final void asq()
  {
    AppMethodBeat.i(241667);
    if (asr())
    {
      this.gOz.removeMessages(4);
      this.gOz.sendEmptyMessage(4);
    }
    AppMethodBeat.o(241667);
  }
  
  final boolean asr()
  {
    AppMethodBeat.i(241668);
    if (ass())
    {
      if (this.gOz != null)
      {
        AppMethodBeat.o(241668);
        return true;
      }
      AppMethodBeat.o(241668);
      return false;
    }
    if ((this.gOA != null) && (this.gOA.isAlive()) && (this.gOz != null))
    {
      AppMethodBeat.o(241668);
      return true;
    }
    AppMethodBeat.o(241668);
    return false;
  }
  
  protected final void sendMessage(int paramInt)
  {
    AppMethodBeat.i(241665);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    sendMessage(localMessage);
    AppMethodBeat.o(241665);
  }
  
  final void sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(241666);
    if (asr()) {
      this.gOz.sendMessage(paramMessage);
    }
    AppMethodBeat.o(241666);
  }
  
  static final class a
    implements Handler.Callback
  {
    private WeakReference<d> gOD;
    
    private a(d paramd)
    {
      AppMethodBeat.i(241661);
      this.gOD = new WeakReference(paramd);
      AppMethodBeat.o(241661);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(241662);
      Object localObject1 = (d)this.gOD.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(241662);
        return false;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(241662);
        return false;
        ((d)localObject1).gNB = false;
        ((d)localObject1).gNK = true;
        if (paramMessage.obj != null) {}
        for (((d)localObject1).gNJ = ((Long)paramMessage.obj).longValue();; ((d)localObject1).gNJ = 0L)
        {
          ((d)localObject1).gNP = 0;
          ((d)localObject1).gNQ = 0;
          ((d)localObject1).gNR = 0;
          ((d)localObject1).gNw.gNI = SystemClock.uptimeMillis();
          paramMessage = ((d)localObject1).gNw;
          paramMessage.gQv = 0L;
          paramMessage.gQw = 0L;
          if (com.tencent.mm.danmaku.e.e.gQV >= 3) {
            com.tencent.mm.danmaku.e.e.i("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(((d)localObject1).gNJ) });
          }
          ((d)localObject1).asb();
          break;
        }
        ((d)localObject1).asb();
        continue;
        ((d)localObject1).ase();
        continue;
        ((d)localObject1).asf();
        continue;
        ((d)localObject1).i(paramMessage);
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleQuit()");
        ((d)localObject1).gNB = true;
        ((d)localObject1).gNt.gPo.atl();
        ((d)localObject1).gNF.clear();
        paramMessage = ((d)localObject1).gNu.gNx;
        localObject1 = paramMessage.gQm.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a.a)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((a.a)localObject2).destroy();
          }
        }
        paramMessage.gQm.clear();
        paramMessage.gQp = 0;
        paramMessage.gQq = 0;
        paramMessage.gQr = 0;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "message quit");
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleConfigChanged()");
        ((d)localObject1).gNZ.arP();
        localObject1 = ((d)localObject1).gNF;
        ((e)localObject1).asm();
        paramMessage = ((e)localObject1).gOl;
        Object localObject2 = paramMessage.gQB.gQE;
        if (localObject2 != paramMessage.gQB)
        {
          paramMessage = ((g.a)localObject2).mData;
          label401:
          paramMessage = (com.tencent.mm.danmaku.b.a)paramMessage;
          if (paramMessage != null) {
            break label436;
          }
        }
        label436:
        for (((e)localObject1).gOn = -1L;; ((e)localObject1).gOn = paramMessage.getTime())
        {
          ((e)localObject1).asn();
          com.tencent.mm.danmaku.e.e.i("DanmakuManager", "message config changed");
          break;
          paramMessage = null;
          break label401;
        }
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleRelease()");
        paramMessage = ((d)localObject1).gOc;
        if ((paramMessage.gOA != null) && (!paramMessage.gOu.booleanValue()))
        {
          if (!c.atm()) {
            break label557;
          }
          paramMessage.gOA.quitSafely();
        }
        for (;;)
        {
          paramMessage.gOA = null;
          paramMessage = ((d)localObject1).gNH;
          if ((paramMessage.gOs != null) && (paramMessage.gOs.isAlive())) {
            break label568;
          }
          paramMessage = ((d)localObject1).gNu;
          if ((paramMessage.gNy == null) || (!paramMessage.gNy.isAlive())) {
            break;
          }
          if (!c.atm()) {
            break label611;
          }
          paramMessage.gNy.quitSafely();
          break;
          label557:
          paramMessage.gOA.quit();
        }
        label568:
        if (!paramMessage.gOu.booleanValue())
        {
          if (!c.atm()) {
            break label600;
          }
          paramMessage.gOs.quitSafely();
        }
        for (;;)
        {
          paramMessage.gOs = null;
          break;
          label600:
          paramMessage.gOs.quit();
        }
        label611:
        paramMessage.gNy.quit();
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleClear()");
        ((d)localObject1).gNZ.arQ();
        ((d)localObject1).gNt.gPo.atl();
        ((d)localObject1).gNF.clear();
        continue;
        if (((d)localObject1).gOa != null) {
          while (!((d)localObject1).gNX.isEmpty())
          {
            paramMessage = (com.tencent.mm.danmaku.d.h)((d)localObject1).gNX.poll();
            localObject2 = ((d)localObject1).gNZ.a(paramMessage);
            if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
              com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "handleClick:", paramMessage, ",currentTime:", Long.valueOf(SystemClock.uptimeMillis()) });
            }
            com.tencent.mm.danmaku.f.b.post(new d.2((d)localObject1, (com.tencent.mm.danmaku.b.a)localObject2, paramMessage));
          }
        }
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "message click");
        continue;
        ((d)localObject1).ask();
        continue;
        ((d)localObject1).asj();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.i
 * JD-Core Version:    0.7.0.1
 */