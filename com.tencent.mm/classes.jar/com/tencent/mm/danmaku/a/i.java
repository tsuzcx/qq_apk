package com.tencent.mm.danmaku.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.d.a.a;
import com.tencent.mm.danmaku.d.g;
import com.tencent.mm.danmaku.d.g.a;
import com.tencent.mm.danmaku.e.c;
import com.tencent.mm.plugin.finder.megavideo.bullet.b.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class i
{
  Boolean jyP;
  Handler jyT;
  HandlerThread jyU;
  private a jyV;
  int jyW;
  
  public i(d paramd)
  {
    AppMethodBeat.i(268284);
    this.jyP = Boolean.FALSE;
    this.jyW = 0;
    this.jyV = new a(paramd, (byte)0);
    AppMethodBeat.o(268284);
  }
  
  private boolean azg()
  {
    return this.jyW == 1;
  }
  
  private void sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(268288);
    if (azf()) {
      this.jyT.sendMessage(paramMessage);
    }
    AppMethodBeat.o(268288);
  }
  
  protected final void azd()
  {
    AppMethodBeat.i(268285);
    if (this.jyT != null) {
      this.jyT.removeMessages(4);
    }
    AppMethodBeat.o(268285);
  }
  
  protected final void aze()
  {
    AppMethodBeat.i(268289);
    if (azf())
    {
      this.jyT.removeMessages(4);
      this.jyT.sendEmptyMessage(4);
    }
    AppMethodBeat.o(268289);
  }
  
  final boolean azf()
  {
    AppMethodBeat.i(268290);
    if (azg())
    {
      if (this.jyT != null)
      {
        AppMethodBeat.o(268290);
        return true;
      }
      AppMethodBeat.o(268290);
      return false;
    }
    if ((this.jyU != null) && (this.jyU.isAlive()) && (this.jyT != null))
    {
      AppMethodBeat.o(268290);
      return true;
    }
    AppMethodBeat.o(268290);
    return false;
  }
  
  final void rq(int paramInt)
  {
    AppMethodBeat.i(268291);
    if (azg())
    {
      if (this.jyT == null) {
        this.jyT = new Handler(Looper.getMainLooper(), this.jyV);
      }
      AppMethodBeat.o(268291);
      return;
    }
    if ((this.jyU == null) || (!this.jyU.isAlive())) {
      try
      {
        Object localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.zvH;
        localObject = b.a.dJA().zvD;
        if ((localObject != null) && (((HandlerThread)localObject).isAlive())) {
          this.jyU = ((HandlerThread)localObject);
        }
        for (this.jyP = Boolean.TRUE;; this.jyP = Boolean.FALSE)
        {
          this.jyT = new Handler(this.jyU.getLooper(), this.jyV);
          AppMethodBeat.o(268291);
          return;
          this.jyU = new HandlerThread("DanmakuDrawThreadPriority_".concat(String.valueOf(paramInt)), paramInt);
          this.jyU.setUncaughtExceptionHandler(new com.tencent.mm.danmaku.e.b());
          this.jyU.start();
        }
        AppMethodBeat.o(268291);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.danmaku.e.e.e("DanmakuManager", new Object[] { localThrowable });
      }
    }
  }
  
  protected final void sendMessage(int paramInt)
  {
    AppMethodBeat.i(268286);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    sendMessage(localMessage);
    AppMethodBeat.o(268286);
  }
  
  protected final void sendMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(268287);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    sendMessage(localMessage);
    AppMethodBeat.o(268287);
  }
  
  static final class a
    implements Handler.Callback
  {
    private WeakReference<d> jyX;
    
    private a(d paramd)
    {
      AppMethodBeat.i(268305);
      this.jyX = new WeakReference(paramd);
      AppMethodBeat.o(268305);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(268306);
      Object localObject1 = (d)this.jyX.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(268306);
        return false;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(268306);
        return false;
        ((d)localObject1).jxW = false;
        ((d)localObject1).jyf = true;
        if (paramMessage.obj != null) {}
        for (((d)localObject1).jye = ((Long)paramMessage.obj).longValue();; ((d)localObject1).jye = 0L)
        {
          ((d)localObject1).jyk = 0;
          ((d)localObject1).jyl = 0;
          ((d)localObject1).jym = 0;
          ((d)localObject1).jxR.jyd = SystemClock.uptimeMillis();
          paramMessage = ((d)localObject1).jxR;
          paramMessage.jAO = 0L;
          paramMessage.jAP = 0L;
          if (com.tencent.mm.danmaku.e.e.jBo >= 3) {
            com.tencent.mm.danmaku.e.e.i("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(((d)localObject1).jye) });
          }
          ((d)localObject1).ayO();
          break;
        }
        ((d)localObject1).ayO();
        continue;
        ((d)localObject1).ayR();
        continue;
        ((d)localObject1).ayS();
        continue;
        ((d)localObject1).i(paramMessage);
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleQuit()");
        ((d)localObject1).jxW = true;
        ((d)localObject1).jxO.jzH.aAa();
        ((d)localObject1).jya.clear();
        paramMessage = ((d)localObject1).jxP.jxS;
        localObject1 = paramMessage.jAF.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a.a)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((a.a)localObject2).destroy();
          }
        }
        paramMessage.jAF.clear();
        paramMessage.jAI = 0;
        paramMessage.jAJ = 0;
        paramMessage.jAK = 0;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "message quit");
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleConfigChanged()");
        ((d)localObject1).jyu.ayA();
        localObject1 = ((d)localObject1).jya;
        ((e)localObject1).ayZ();
        paramMessage = ((e)localObject1).jyG;
        Object localObject2 = paramMessage.jAU.jAX;
        if (localObject2 != paramMessage.jAU)
        {
          paramMessage = ((g.a)localObject2).mData;
          label401:
          paramMessage = (com.tencent.mm.danmaku.b.a)paramMessage;
          if (paramMessage != null) {
            break label436;
          }
        }
        label436:
        for (((e)localObject1).jyI = -1L;; ((e)localObject1).jyI = paramMessage.getTime())
        {
          ((e)localObject1).aza();
          com.tencent.mm.danmaku.e.e.i("DanmakuManager", "message config changed");
          break;
          paramMessage = null;
          break label401;
        }
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleRelease()");
        paramMessage = ((d)localObject1).jyx;
        if ((paramMessage.jyU != null) && (!paramMessage.jyP.booleanValue()))
        {
          if (!c.aAc()) {
            break label557;
          }
          paramMessage.jyU.quitSafely();
        }
        for (;;)
        {
          paramMessage.jyU = null;
          paramMessage = ((d)localObject1).jyc;
          if ((paramMessage.jyN != null) && (paramMessage.jyN.isAlive())) {
            break label568;
          }
          paramMessage = ((d)localObject1).jxP;
          if ((paramMessage.jxT == null) || (!paramMessage.jxT.isAlive())) {
            break;
          }
          if (!c.aAc()) {
            break label611;
          }
          paramMessage.jxT.quitSafely();
          break;
          label557:
          paramMessage.jyU.quit();
        }
        label568:
        if (!paramMessage.jyP.booleanValue())
        {
          if (!c.aAc()) {
            break label600;
          }
          paramMessage.jyN.quitSafely();
        }
        for (;;)
        {
          paramMessage.jyN = null;
          break;
          label600:
          paramMessage.jyN.quit();
        }
        label611:
        paramMessage.jxT.quit();
        continue;
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleClear()");
        ((d)localObject1).jyu.ayB();
        ((d)localObject1).jxO.jzH.aAa();
        ((d)localObject1).jya.clear();
        continue;
        if (((d)localObject1).jyv != null) {
          while (!((d)localObject1).jys.isEmpty())
          {
            paramMessage = (com.tencent.mm.danmaku.d.h)((d)localObject1).jys.poll();
            localObject2 = ((d)localObject1).jyu.a(paramMessage);
            if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
              com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "handleClick:", paramMessage, ",currentTime:", Long.valueOf(SystemClock.uptimeMillis()) });
            }
            com.tencent.mm.danmaku.f.b.post(new d.2((d)localObject1, (com.tencent.mm.danmaku.b.a)localObject2, paramMessage));
          }
        }
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "message click");
        continue;
        ((d)localObject1).ayX();
        continue;
        ((d)localObject1).ayW();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.i
 * JD-Core Version:    0.7.0.1
 */