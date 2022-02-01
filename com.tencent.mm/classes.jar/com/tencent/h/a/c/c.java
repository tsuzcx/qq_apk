package com.tencent.h.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.g.c.i;
import com.tencent.h.a.b.a.a;
import com.tencent.h.a.b.b.a;
import com.tencent.h.a.b.c.a.d;
import com.tencent.h.a.h.a;
import com.tencent.h.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
  extends com.tencent.h.a.b.a
{
  private com.tencent.h.a.c.d.c ZTc;
  private AtomicBoolean ZTd;
  private AtomicBoolean ZTe;
  
  public c(String paramString, com.tencent.h.a.a.c paramc)
  {
    super(paramString, paramc, new com.tencent.h.a.b.b()
    {
      public final void itS()
      {
        AppMethodBeat.i(207516);
        Object localObject = new com.tencent.h.a.b.c.a(c.this);
        this.ZSH.a((d)localObject);
        localObject = new com.tencent.h.a.b.c.b(c.this);
        this.ZSH.a((d)localObject);
        AppMethodBeat.o(207516);
      }
    });
    AppMethodBeat.i(208714);
    this.ZTd = new AtomicBoolean(false);
    this.ZTe = new AtomicBoolean(true);
    this.ZTc = new com.tencent.h.a.c.d.c(paramc);
    this.ZTc.ZUM = this;
    AppMethodBeat.o(208714);
  }
  
  private void aCq(int paramInt)
  {
    AppMethodBeat.i(208737);
    this.ZQg.removeMessages(paramInt);
    AppMethodBeat.o(208737);
  }
  
  private void iue()
  {
    AppMethodBeat.i(208734);
    aCq(3);
    aCq(7);
    AppMethodBeat.o(208734);
  }
  
  private void iuf()
  {
    AppMethodBeat.i(208739);
    itQ();
    y(this.ZSD.ZSH.BCY);
    iue();
    this.ZTc.esN();
    AppMethodBeat.o(208739);
  }
  
  private static void x(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(208730);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(208730);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null)) {
        locald.itZ();
      }
    }
    AppMethodBeat.o(208730);
  }
  
  private static void y(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(208732);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(208732);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null))
      {
        locald.TV();
        locald.IG(false);
      }
    }
    AppMethodBeat.o(208732);
  }
  
  public final boolean a(h.a parama, com.tencent.h.a.b.c paramc)
  {
    AppMethodBeat.i(208717);
    super.a(parama, paramc);
    y(1, parama);
    AppMethodBeat.o(208717);
    return true;
  }
  
  public final boolean a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(208720);
    super.a(parama, paramLong);
    parama = new a.a(this, new Object[] { parama });
    if (this.ZQg != null)
    {
      Message localMessage = this.ZQg.obtainMessage();
      localMessage.what = 4;
      localMessage.arg1 = 6;
      localMessage.obj = parama;
      this.ZQg.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(208720);
    return true;
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(208727);
    boolean bool = this.ZTe.get();
    AppMethodBeat.o(208727);
    return bool;
  }
  
  public final boolean adI()
  {
    AppMethodBeat.i(208729);
    if (!this.ZTd.get())
    {
      AppMethodBeat.o(208729);
      return true;
    }
    AppMethodBeat.o(208729);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208724);
    super.destroy();
    aCp(8);
    AppMethodBeat.o(208724);
  }
  
  public final boolean itL()
  {
    AppMethodBeat.i(208718);
    itI();
    AppMethodBeat.o(208718);
    return true;
  }
  
  public final boolean itM()
  {
    AppMethodBeat.i(208719);
    k(4, 5, null);
    AppMethodBeat.o(208719);
    return true;
  }
  
  public final boolean itN()
  {
    AppMethodBeat.i(208721);
    k(4, 7, null);
    AppMethodBeat.o(208721);
    return true;
  }
  
  public final void q(Message paramMessage)
  {
    AppMethodBeat.i(208715);
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(208715);
      return;
    case 1: 
      if (this.ZTd.get())
      {
        i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK started");
        AppMethodBeat.o(208715);
        return;
      }
      this.ZSC = ((h.a)paramMessage.obj);
      itR();
      itP();
      i.d("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK");
      this.ZTd.set(true);
      aCq(1);
      aCq(3);
      aCq(7);
      this.ZTc.a(this);
      paramMessage = this.ZSD.ZSH.BCY;
      if ((paramMessage == null) || (paramMessage.isEmpty()))
      {
        AppMethodBeat.o(208715);
        return;
      }
      paramMessage = paramMessage.entrySet().iterator();
      while (paramMessage.hasNext())
      {
        localObject = (Map.Entry)paramMessage.next();
        d locald = (d)((Map.Entry)localObject).getValue();
        if (locald != null)
        {
          locald.a(this);
          ((Integer)((Map.Entry)localObject).getKey()).intValue();
          if ((locald != null) && (!locald.iua())) {
            locald.IG(locald.itY());
          }
        }
      }
      AppMethodBeat.o(208715);
      return;
    case 2: 
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_RESUME_TASK : " + this.ZTe.get());
      if (!this.ZTe.get())
      {
        i.i("sensor_MasterEngine", "[method: consumeMessage ] resumed");
        AppMethodBeat.o(208715);
        return;
      }
      this.ZTc.iur();
      this.ZTe.set(false);
      AppMethodBeat.o(208715);
      return;
    case 3: 
      if ((!this.ZTd.get()) || (this.ZTe.get()))
      {
        this.ZTc.z(paramMessage.arg1, paramMessage.obj);
        AppMethodBeat.o(208715);
        return;
      }
      this.ZTc.A(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(208715);
      return;
    case 5: 
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_PAUSE_TASK : " + this.ZTe.get());
      if (this.ZTe.get())
      {
        AppMethodBeat.o(208715);
        return;
      }
      this.ZTe.set(true);
      this.ZTc.IH(true);
      AppMethodBeat.o(208715);
      return;
    case 4: 
      x(this.ZSD.ZSH.BCY);
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_NOTIFY_TASK_STOP msg.arg1 : " + paramMessage.arg1);
      if ((paramMessage.arg1 == 5) || (paramMessage.arg1 == 7))
      {
        aCp(paramMessage.arg1);
        AppMethodBeat.o(208715);
        return;
      }
      y(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(208715);
      return;
    case 6: 
      if (!this.ZTd.get())
      {
        AppMethodBeat.o(208715);
        return;
      }
      this.ZTd.set(false);
      this.ZTe.set(true);
      itQ();
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_DELAY : ");
      paramMessage = (a.a)paramMessage.obj;
      itJ();
      if (paramMessage.ZSG.length <= 0) {
        break;
      }
    }
    for (paramMessage = (i.a)paramMessage.ZSG[0];; paramMessage = null)
    {
      localObject = this.ZTc;
      if (paramMessage != null) {}
      for (boolean bool = paramMessage.ZSa;; bool = true)
      {
        ((com.tencent.h.a.c.d.c)localObject).IH(bool);
        AppMethodBeat.o(208715);
        return;
      }
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_IMMEDIATELY");
      iuf();
      AppMethodBeat.o(208715);
      return;
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_DESTROY");
      iuf();
      if (this.ZQg != null) {
        this.ZQg.removeCallbacksAndMessages(null);
      }
      if (this.mHandlerThread == null) {
        break;
      }
      i.i("sensor_AsyncWorker", "[method: quitHandlerThread ] ");
      this.mHandlerThread.quit();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c
 * JD-Core Version:    0.7.0.1
 */