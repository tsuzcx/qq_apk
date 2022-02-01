package com.tencent.h.a.c;

import android.os.Handler;
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
  private com.tencent.h.a.c.d.c ahXC;
  private AtomicBoolean ahXD;
  private AtomicBoolean ahXE;
  
  public c(String paramString, com.tencent.h.a.a.c paramc)
  {
    super(paramString, paramc, new com.tencent.h.a.b.b()
    {
      public final void kdo()
      {
        AppMethodBeat.i(212218);
        Object localObject = new com.tencent.h.a.b.c.a(c.this);
        this.ahXh.a((d)localObject);
        localObject = new com.tencent.h.a.b.c.b(c.this);
        this.ahXh.a((d)localObject);
        AppMethodBeat.o(212218);
      }
    });
    AppMethodBeat.i(212148);
    this.ahXD = new AtomicBoolean(false);
    this.ahXE = new AtomicBoolean(true);
    this.ahXC = new com.tencent.h.a.c.d.c(paramc);
    this.ahXC.ahZl = this;
    AppMethodBeat.o(212148);
  }
  
  private static void A(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(212158);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(212158);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null)) {
        locald.kdv();
      }
    }
    AppMethodBeat.o(212158);
  }
  
  private static void B(HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(212166);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(212166);
      return;
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      d locald = (d)((Map.Entry)paramHashMap.next()).getValue();
      if ((locald != null) && (locald != null))
      {
        if (!locald.stop()) {}
        for (boolean bool = true;; bool = false)
        {
          locald.OI(bool);
          break;
        }
      }
    }
    AppMethodBeat.o(212166);
  }
  
  private void aJd(int paramInt)
  {
    AppMethodBeat.i(212175);
    this.ahWL.removeMessages(paramInt);
    AppMethodBeat.o(212175);
  }
  
  private void kdA()
  {
    AppMethodBeat.i(212171);
    aJd(3);
    aJd(7);
    AppMethodBeat.o(212171);
  }
  
  private void kdB()
  {
    AppMethodBeat.i(212181);
    kdm();
    B(this.ahXd.ahXh.HlG);
    kdA();
    this.ahXC.fzH();
    AppMethodBeat.o(212181);
  }
  
  public final boolean a(h.a parama, com.tencent.h.a.b.c paramc)
  {
    AppMethodBeat.i(212202);
    super.a(parama, paramc);
    S(1, parama);
    AppMethodBeat.o(212202);
    return true;
  }
  
  public final boolean a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(212219);
    super.a(parama, paramLong);
    parama = new a.a(this, new Object[] { parama });
    if (this.ahWL != null)
    {
      Message localMessage = this.ahWL.obtainMessage();
      localMessage.what = 4;
      localMessage.arg1 = 6;
      localMessage.obj = parama;
      this.ahWL.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(212219);
    return true;
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(212232);
    boolean bool = this.ahXE.get();
    AppMethodBeat.o(212232);
    return bool;
  }
  
  public final boolean aFG()
  {
    AppMethodBeat.i(212238);
    if (!this.ahXD.get())
    {
      AppMethodBeat.o(212238);
      return true;
    }
    AppMethodBeat.o(212238);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(212227);
    super.destroy();
    aJc(8);
    AppMethodBeat.o(212227);
  }
  
  public final boolean kdh()
  {
    AppMethodBeat.i(212209);
    kde();
    AppMethodBeat.o(212209);
    return true;
  }
  
  public final boolean kdi()
  {
    AppMethodBeat.i(212214);
    l(4, 5, null);
    AppMethodBeat.o(212214);
    return true;
  }
  
  public final boolean kdj()
  {
    AppMethodBeat.i(212225);
    l(4, 7, null);
    AppMethodBeat.o(212225);
    return true;
  }
  
  public final void y(Message paramMessage)
  {
    AppMethodBeat.i(212195);
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(212195);
      return;
    case 1: 
      if (this.ahXD.get())
      {
        i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK started");
        AppMethodBeat.o(212195);
        return;
      }
      this.ahXc = ((h.a)paramMessage.obj);
      kdn();
      kdl();
      i.d("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK");
      this.ahXD.set(true);
      aJd(1);
      aJd(3);
      aJd(7);
      this.ahXC.a(this);
      paramMessage = this.ahXd.ahXh.HlG;
      if ((paramMessage == null) || (paramMessage.isEmpty()))
      {
        AppMethodBeat.o(212195);
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
          if ((locald != null) && (!locald.kdw())) {
            locald.OI(locald.kdu());
          }
        }
      }
      AppMethodBeat.o(212195);
      return;
    case 2: 
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_RESUME_TASK : " + this.ahXE.get());
      if (!this.ahXE.get())
      {
        i.i("sensor_MasterEngine", "[method: consumeMessage ] resumed");
        AppMethodBeat.o(212195);
        return;
      }
      this.ahXC.kdN();
      this.ahXE.set(false);
      AppMethodBeat.o(212195);
      return;
    case 3: 
      if ((!this.ahXD.get()) || (this.ahXE.get()))
      {
        this.ahXC.T(paramMessage.arg1, paramMessage.obj);
        AppMethodBeat.o(212195);
        return;
      }
      this.ahXC.U(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(212195);
      return;
    case 5: 
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_PAUSE_TASK : " + this.ahXE.get());
      if (this.ahXE.get())
      {
        AppMethodBeat.o(212195);
        return;
      }
      this.ahXE.set(true);
      this.ahXC.OJ(true);
      AppMethodBeat.o(212195);
      return;
    case 4: 
      A(this.ahXd.ahXh.HlG);
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_NOTIFY_TASK_STOP msg.arg1 : " + paramMessage.arg1);
      if ((paramMessage.arg1 == 5) || (paramMessage.arg1 == 7))
      {
        aJc(paramMessage.arg1);
        AppMethodBeat.o(212195);
        return;
      }
      S(paramMessage.arg1, paramMessage.obj);
      AppMethodBeat.o(212195);
      return;
    case 6: 
      if (!this.ahXD.get())
      {
        AppMethodBeat.o(212195);
        return;
      }
      this.ahXD.set(false);
      this.ahXE.set(true);
      kdm();
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_DELAY : ");
      paramMessage = (a.a)paramMessage.obj;
      kdf();
      if (paramMessage.ahXg.length <= 0) {
        break;
      }
    }
    for (paramMessage = (i.a)paramMessage.ahXg[0];; paramMessage = null)
    {
      localObject = this.ahXC;
      if (paramMessage != null) {}
      for (boolean bool = paramMessage.ahWx;; bool = true)
      {
        ((com.tencent.h.a.c.d.c)localObject).OJ(bool);
        AppMethodBeat.o(212195);
        return;
      }
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_IMMEDIATELY");
      kdB();
      AppMethodBeat.o(212195);
      return;
      i.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_DESTROY");
      kdB();
      kdd();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c
 * JD-Core Version:    0.7.0.1
 */