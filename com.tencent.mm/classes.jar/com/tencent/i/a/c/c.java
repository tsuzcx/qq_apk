package com.tencent.i.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.h.c.h;
import com.tencent.i.a.b.b.a;
import com.tencent.i.a.b.c.a.d;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.h.a;
import com.tencent.i.a.i.a;
import com.tencent.i.a.j;
import com.tencent.i.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
  extends com.tencent.i.a.b.a
{
  private AtomicBoolean SrA;
  private AtomicBoolean SrB;
  private com.tencent.i.a.c.d.c Srz;
  
  public c(String paramString, com.tencent.i.a.a.c paramc)
  {
    super(paramString, paramc, new com.tencent.i.a.b.b()
    {
      public final void hql()
      {
        AppMethodBeat.i(214721);
        Object localObject = new com.tencent.i.a.b.c.a(c.this);
        this.Sre.a((d)localObject);
        localObject = new com.tencent.i.a.b.c.b(c.this);
        this.Sre.a((d)localObject);
        AppMethodBeat.o(214721);
      }
    });
    AppMethodBeat.i(214722);
    this.SrA = new AtomicBoolean(false);
    this.SrB = new AtomicBoolean(true);
    this.Srz = new com.tencent.i.a.c.d.c(paramc);
    this.Srz.Stj = this;
    AppMethodBeat.o(214722);
  }
  
  private static void A(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(214732);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(214732);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null)) {
        locald.hqq();
      }
    }
    AppMethodBeat.o(214732);
  }
  
  private static void B(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(214733);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(214733);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null))
      {
        locald.Qt();
        locald.Ef(false);
      }
    }
    AppMethodBeat.o(214733);
  }
  
  private void asC(int paramInt)
  {
    AppMethodBeat.i(214735);
    this.Son.removeMessages(paramInt);
    AppMethodBeat.o(214735);
  }
  
  private void hqv()
  {
    AppMethodBeat.i(214734);
    asC(3);
    asC(7);
    AppMethodBeat.o(214734);
  }
  
  private void hqw()
  {
    AppMethodBeat.i(214736);
    hqj();
    B(this.Sra.Sre.wLb);
    hqv();
    this.Srz.dQn();
    AppMethodBeat.o(214736);
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(214730);
    boolean bool = this.SrB.get();
    AppMethodBeat.o(214730);
    return bool;
  }
  
  public final boolean YZ()
  {
    AppMethodBeat.i(214731);
    if (!this.SrA.get())
    {
      AppMethodBeat.o(214731);
      return true;
    }
    AppMethodBeat.o(214731);
    return false;
  }
  
  public final boolean a(h.a parama, com.tencent.i.a.b.c paramc)
  {
    AppMethodBeat.i(214724);
    super.a(parama, paramc);
    u(1, parama);
    AppMethodBeat.o(214724);
    return true;
  }
  
  public final boolean a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(214727);
    super.a(parama, paramLong);
    parama = new com.tencent.i.a.b.a.a(this, new Object[] { parama });
    if (this.Son != null)
    {
      Message localMessage = this.Son.obtainMessage();
      localMessage.what = 4;
      localMessage.arg1 = 6;
      localMessage.obj = parama;
      this.Son.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(214727);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(214729);
    super.destroy();
    asB(8);
    AppMethodBeat.o(214729);
  }
  
  public final boolean hqe()
  {
    AppMethodBeat.i(214725);
    hqd();
    AppMethodBeat.o(214725);
    return true;
  }
  
  public final boolean hqf()
  {
    AppMethodBeat.i(214726);
    j(4, 5, null);
    AppMethodBeat.o(214726);
    return true;
  }
  
  public final boolean hqg()
  {
    AppMethodBeat.i(214728);
    j(4, 7, null);
    AppMethodBeat.o(214728);
    return true;
  }
  
  public final void q(Message paramMessage)
  {
    Object localObject1 = null;
    AppMethodBeat.i(214723);
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(214723);
      return;
    case 1: 
      if (this.SrA.get())
      {
        h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK started");
        AppMethodBeat.o(214723);
        return;
      }
      this.SqZ = ((h.a)paramMessage.obj);
      hqk();
      hqi();
      h.d("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK");
      this.SrA.set(true);
      asC(1);
      asC(3);
      asC(7);
      localObject2 = this.Srz;
      ((com.tencent.i.a.c.d.a)localObject2).SqZ = hqh();
      if (((com.tencent.i.a.c.d.a)localObject2).SqZ == null) {
        paramMessage = (Message)localObject1;
      }
      for (;;)
      {
        ((com.tencent.i.a.c.d.c)localObject2).Stq = paramMessage;
        ((com.tencent.i.a.c.d.a)localObject2).Stk.clearAll();
        ((com.tencent.i.a.c.d.c)localObject2).hqH();
        paramMessage = this.Sra.Sre.wLb;
        if ((paramMessage != null) && (!paramMessage.isEmpty())) {
          break;
        }
        AppMethodBeat.o(214723);
        return;
        if (((com.tencent.i.a.c.d.a)localObject2).SqZ.Sqr == com.tencent.i.a.c.Sqm)
        {
          paramMessage = new com.tencent.i.a.c.a.c(((com.tencent.i.a.c.d.a)localObject2).SqM, this);
        }
        else
        {
          paramMessage = (Message)localObject1;
          if (((com.tencent.i.a.c.d.a)localObject2).SqZ.Sqr == com.tencent.i.a.c.Sqn) {
            paramMessage = new com.tencent.i.a.c.a.b(((com.tencent.i.a.c.d.a)localObject2).SqM, this);
          }
        }
      }
      paramMessage = paramMessage.entrySet().iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (Map.Entry)paramMessage.next();
        localObject2 = (d)((Map.Entry)localObject1).getValue();
        if (localObject2 != null)
        {
          ((d)localObject2).a(this);
          ((Integer)((Map.Entry)localObject1).getKey()).intValue();
          if ((localObject2 != null) && (!((d)localObject2).hqr())) {
            ((d)localObject2).Ef(((d)localObject2).hqp());
          }
        }
      }
      AppMethodBeat.o(214723);
      return;
    case 2: 
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_RESUME_TASK : " + this.SrB.get());
      if (!this.SrB.get())
      {
        h.i("sensor_MasterEngine", "[method: consumeMessage ] resumed");
        AppMethodBeat.o(214723);
        return;
      }
      this.Srz.hqH();
      this.SrB.set(false);
      AppMethodBeat.o(214723);
      return;
    case 3: 
      if ((!this.SrA.get()) || (this.SrB.get()))
      {
        localObject1 = this.Srz;
        int i = paramMessage.arg1;
        localObject2 = paramMessage.obj;
        paramMessage = ((com.tencent.i.a.c.d.a)localObject1).Stk;
        if (i == 1)
        {
          if (localObject2 != null)
          {
            localObject1 = (List)localObject2;
            if ((localObject1 == null) || (((List)localObject1).isEmpty()))
            {
              AppMethodBeat.o(214723);
              return;
            }
            localObject2 = (g)((List)localObject1).get(0);
            if (localObject2 != null)
            {
              localObject2 = paramMessage.bra(com.tencent.i.a.c.d.a.a.mN(i, ((g)localObject2).RNh));
              ((ArrayList)localObject2).addAll((Collection)localObject1);
              if ((paramMessage.Stp.SqZ != null) && (paramMessage.Stp.SqZ.Sqr == com.tencent.i.a.c.Sqn)) {}
              for (long l = 0L; l <= 0L; l = 500L)
              {
                ((List)localObject2).clear();
                AppMethodBeat.o(214723);
                return;
              }
              i = (int)Math.ceil((float)(paramMessage.Stp.SqM.SqN.hqa().Sqy * 500L) * 1.0F / 1000.0F * 1.0F);
              if (((List)localObject2).size() > i) {
                ((List)localObject2).removeAll(new ArrayList(((List)localObject2).subList(0, ((List)localObject2).size() - i)));
              }
              AppMethodBeat.o(214723);
            }
          }
        }
        else {
          paramMessage.bra(com.tencent.i.a.c.d.a.a.mN(i, -1)).add(localObject2);
        }
        AppMethodBeat.o(214723);
        return;
      }
      this.Srz.v(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(214723);
      return;
    case 5: 
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_PAUSE_TASK : " + this.SrB.get());
      if (this.SrB.get())
      {
        AppMethodBeat.o(214723);
        return;
      }
      this.SrB.set(true);
      this.Srz.Eg(true);
      AppMethodBeat.o(214723);
      return;
    case 4: 
      A(this.Sra.Sre.wLb);
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_NOTIFY_TASK_STOP msg.arg1 : " + paramMessage.arg1);
      if ((paramMessage.arg1 == 5) || (paramMessage.arg1 == 7))
      {
        asB(paramMessage.arg1);
        AppMethodBeat.o(214723);
        return;
      }
      u(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(214723);
      return;
    case 6: 
      if (!this.SrA.get())
      {
        AppMethodBeat.o(214723);
        return;
      }
      this.SrA.set(false);
      this.SrB.set(true);
      hqj();
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_DELAY : ");
      paramMessage = (com.tencent.i.a.b.a.a)paramMessage.obj;
      if (this.Son != null) {
        super.b(7, -1, null, 10000L);
      }
      if (paramMessage.Srd.length <= 0) {
        break;
      }
    }
    for (paramMessage = (i.a)paramMessage.Srd[0];; paramMessage = null)
    {
      localObject1 = this.Srz;
      if (paramMessage != null) {}
      for (boolean bool = paramMessage.Sqx;; bool = true)
      {
        ((com.tencent.i.a.c.d.c)localObject1).Eg(bool);
        AppMethodBeat.o(214723);
        return;
      }
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_IMMEDIATELY");
      hqw();
      AppMethodBeat.o(214723);
      return;
      h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_DESTROY");
      hqw();
      if (this.Son != null) {
        this.Son.removeCallbacksAndMessages(null);
      }
      if (this.mHandlerThread == null) {
        break;
      }
      h.i("sensor_AsyncWorker", "[method: quitHandlerThread ] ");
      this.mHandlerThread.quit();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c
 * JD-Core Version:    0.7.0.1
 */