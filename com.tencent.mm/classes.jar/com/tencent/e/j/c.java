package com.tencent.e.j;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.e.d.e;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.j;
import com.tencent.e.i.k;
import com.tencent.e.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements com.tencent.e.d.a
{
  final String EPB;
  private final a EYE;
  private final Handler.Callback IAb;
  public boolean IAc;
  private b IAd;
  final Handler IyH;
  AtomicBoolean IyI;
  public boolean IzH;
  
  public c(a parama)
  {
    this(parama, null);
  }
  
  public c(a parama, Handler.Callback paramCallback)
  {
    AppMethodBeat.i(183430);
    this.IzH = true;
    this.IyI = new AtomicBoolean();
    this.IyH = new Handler(Looper.getMainLooper())
    {
      public final void dispatchMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(183411);
        c.this.dispatchMessage(paramAnonymousMessage);
        AppMethodBeat.o(183411);
      }
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(183412);
        c.this.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(183412);
      }
      
      public final boolean sendMessageAtTime(Message paramAnonymousMessage, long paramAnonymousLong)
      {
        AppMethodBeat.i(183413);
        paramAnonymousMessage.setTarget(c.this.IyH);
        boolean bool = c.this.sendMessageAtTime(paramAnonymousMessage, paramAnonymousLong);
        AppMethodBeat.o(183413);
        return bool;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(183414);
        String str = c.this.toString();
        AppMethodBeat.o(183414);
        return str;
      }
    };
    this.IAd = new b(Message.class, "recycleUnchecked", new Class[0]);
    Objects.requireNonNull(parama);
    this.EYE = parama;
    this.EPB = parama.tag;
    this.IAb = paramCallback;
    try
    {
      parama = this.IyH;
      new com.tencent.e.k.a(Handler.class, "mLooper").et(parama);
      AppMethodBeat.o(183430);
      return;
    }
    catch (Exception parama)
    {
      parama = new RuntimeException(parama);
      AppMethodBeat.o(183430);
      throw parama;
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(183451);
    if (paramMessage.getCallback() != null)
    {
      paramMessage.getCallback().run();
      AppMethodBeat.o(183451);
      return;
    }
    if ((this.IAb != null) && (this.IAb.handleMessage(paramMessage)))
    {
      AppMethodBeat.o(183451);
      return;
    }
    handleMessage(paramMessage);
    AppMethodBeat.o(183451);
  }
  
  public void dump(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(183461);
    paramPrinter.println(paramString + this.EYE.IzX.foq().toString());
    AppMethodBeat.o(183461);
  }
  
  public boolean executeOrSendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183449);
    if (a.fom() == this.EYE)
    {
      dispatchMessage(paramMessage);
      AppMethodBeat.o(183449);
      return true;
    }
    boolean bool = sendMessage(paramMessage);
    AppMethodBeat.o(183449);
    return bool;
  }
  
  public Looper getLooper()
  {
    return null;
  }
  
  public String getMessageName(Message paramMessage)
  {
    AppMethodBeat.i(183431);
    paramMessage = this.IyH.getMessageName(paramMessage);
    AppMethodBeat.o(183431);
    return paramMessage;
  }
  
  public Handler getSelf()
  {
    return null;
  }
  
  public a getSerial()
  {
    return this.EYE;
  }
  
  public String getSerialTag()
  {
    return this.EPB;
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public boolean hasMessages(final int paramInt)
  {
    AppMethodBeat.i(183457);
    boolean bool = this.EYE.IzX.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183423);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.IAi == c.this) && (c.a.a(paramAnonymouse).what == paramInt))
          {
            AppMethodBeat.o(183423);
            return true;
          }
          AppMethodBeat.o(183423);
          return false;
        }
        AppMethodBeat.o(183423);
        return false;
      }
    });
    AppMethodBeat.o(183457);
    return bool;
  }
  
  public boolean hasMessages(int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(183458);
    boolean bool = this.EYE.IzX.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183424);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.IAi == c.this) && (c.a.a(paramAnonymouse).obj == paramObject))
          {
            AppMethodBeat.o(183424);
            return true;
          }
          AppMethodBeat.o(183424);
          return false;
        }
        AppMethodBeat.o(183424);
        return false;
      }
    });
    AppMethodBeat.o(183458);
    return bool;
  }
  
  public boolean isQuit()
  {
    AppMethodBeat.i(183459);
    boolean bool = this.IyI.get();
    AppMethodBeat.o(183459);
    return bool;
  }
  
  public Message obtainMessage()
  {
    AppMethodBeat.i(183432);
    Message localMessage = this.IyH.obtainMessage();
    AppMethodBeat.o(183432);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(183433);
    Message localMessage = this.IyH.obtainMessage(paramInt);
    AppMethodBeat.o(183433);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(183435);
    Message localMessage = this.IyH.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(183435);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(183436);
    paramObject = this.IyH.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(183436);
    return paramObject;
  }
  
  public Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183434);
    paramObject = this.IyH.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(183434);
    return paramObject;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(183437);
    boolean bool = this.IyH.post(paramRunnable);
    AppMethodBeat.o(183437);
    return bool;
  }
  
  public boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(183442);
    boolean bool = this.IyH.sendMessageAtTime(Message.obtain(this.IyH, paramRunnable), -9223372036854775808L);
    AppMethodBeat.o(183442);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183438);
    boolean bool = this.IyH.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(183438);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183439);
    boolean bool = this.IyH.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(183439);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183440);
    boolean bool = this.IyH.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183440);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183441);
    paramRunnable = Message.obtain(this.IyH, paramRunnable);
    paramRunnable.obj = paramObject;
    boolean bool = sendMessageDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183441);
    return bool;
  }
  
  public boolean quit()
  {
    AppMethodBeat.i(183460);
    if (this.IyI.compareAndSet(false, true))
    {
      this.EYE.IzX.a(new d.b()
      {
        public final boolean c(e paramAnonymouse)
        {
          boolean bool = false;
          AppMethodBeat.i(183425);
          paramAnonymouse = paramAnonymouse.IzM;
          if ((paramAnonymouse instanceof c.a))
          {
            paramAnonymouse = (c.a)paramAnonymouse;
            if (paramAnonymouse.IAi == c.this) {
              bool = true;
            }
            if (bool) {
              paramAnonymouse.cancel();
            }
            AppMethodBeat.o(183425);
            return bool;
          }
          AppMethodBeat.o(183425);
          return false;
        }
      });
      AppMethodBeat.o(183460);
      return true;
    }
    AppMethodBeat.o(183460);
    return false;
  }
  
  public void removeCallbacks(final Runnable paramRunnable)
  {
    AppMethodBeat.i(183452);
    this.EYE.IzX.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183418);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.IAi == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).getCallback() == paramRunnable) {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183418);
          return bool1;
        }
        AppMethodBeat.o(183418);
        return false;
      }
    });
    AppMethodBeat.o(183452);
  }
  
  public void removeCallbacks(final Runnable paramRunnable, final Object paramObject)
  {
    AppMethodBeat.i(183453);
    this.EYE.IzX.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183419);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.IAi == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).getCallback() == paramRunnable)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj == paramObject) {
                bool1 = true;
              }
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183419);
          return bool1;
        }
        AppMethodBeat.o(183419);
        return false;
      }
    });
    AppMethodBeat.o(183453);
  }
  
  public void removeCallbacksAndMessages(final Object paramObject)
  {
    AppMethodBeat.i(183456);
    this.EYE.IzX.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183422);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.IAi == c.this) {
            if (paramObject != null)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj != paramObject) {}
            }
            else
            {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183422);
          return bool1;
        }
        AppMethodBeat.o(183422);
        return false;
      }
    });
    AppMethodBeat.o(183456);
  }
  
  public void removeMessages(final int paramInt)
  {
    AppMethodBeat.i(183454);
    this.EYE.IzX.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183420);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.IAi == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).what == paramInt) {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183420);
          return bool1;
        }
        AppMethodBeat.o(183420);
        return false;
      }
    });
    AppMethodBeat.o(183454);
  }
  
  public void removeMessages(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(183455);
    this.EYE.IzX.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183421);
        paramAnonymouse = paramAnonymouse.IzM;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.IAi == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).what == paramInt)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj == paramObject) {
                bool1 = true;
              }
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183421);
          return bool1;
        }
        AppMethodBeat.o(183421);
        return false;
      }
    });
    AppMethodBeat.o(183455);
  }
  
  public boolean sendEmptyMessage(int paramInt)
  {
    AppMethodBeat.i(183444);
    boolean bool = this.IyH.sendEmptyMessage(paramInt);
    AppMethodBeat.o(183444);
    return bool;
  }
  
  public boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183446);
    boolean bool = this.IyH.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(183446);
    return bool;
  }
  
  public boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183445);
    boolean bool = this.IyH.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(183445);
    return bool;
  }
  
  public boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183443);
    boolean bool = this.IyH.sendMessage(paramMessage);
    AppMethodBeat.o(183443);
    return bool;
  }
  
  public boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(183448);
    boolean bool = this.IyH.sendMessageAtTime(paramMessage, -9223372036854775808L);
    AppMethodBeat.o(183448);
    return bool;
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183450);
    paramMessage = new a(paramMessage);
    if (isQuit())
    {
      com.tencent.e.d.IxS.f(paramMessage.IAh, 0, this.EPB);
      AppMethodBeat.o(183450);
      return false;
    }
    if (h.Iye.isShutdown())
    {
      com.tencent.e.d.IxS.f(paramMessage.IAh, 0, this.EPB);
      AppMethodBeat.o(183450);
      return false;
    }
    if (paramLong == -9223372036854775808L) {
      if (a.fol() == this.EYE) {
        h.Iye.aO(paramMessage);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(183450);
      return true;
      h.Iye.g(paramMessage, this.EPB);
      continue;
      paramLong -= SystemClock.uptimeMillis();
      if (a.fol() == this.EYE) {
        h.Iye.p(paramMessage, paramLong);
      } else {
        h.Iye.a(paramMessage, paramLong, this.EPB);
      }
    }
  }
  
  public boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183447);
    boolean bool = this.IyH.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(183447);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(183462);
    String str = String.format("SerialHandler(%s) %s", new Object[] { getSerialTag(), getClass().getName() });
    AppMethodBeat.o(183462);
    return str;
  }
  
  final class a
    implements com.tencent.e.i.e, j
  {
    private Message IAg;
    String IAh;
    Object IAi;
    private Future<?> daz;
    
    a(Message paramMessage)
    {
      AppMethodBeat.i(183426);
      if (paramMessage == null)
      {
        this$1 = new NullPointerException("msg is null");
        AppMethodBeat.o(183426);
        throw c.this;
      }
      this.IAg = paramMessage;
      this.IAh = (c.this.EPB + "#" + c.this.getMessageName(paramMessage));
      this.IAi = c.this;
      AppMethodBeat.o(183426);
    }
    
    public final void a(Future paramFuture)
    {
      this.daz = paramFuture;
    }
    
    public final boolean adf()
    {
      AppMethodBeat.i(183429);
      boolean bool = c.this.IzH;
      AppMethodBeat.o(183429);
      return bool;
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(183428);
      c.a(c.this, this.IAg);
      boolean bool = this.daz.cancel(false);
      AppMethodBeat.o(183428);
      return bool;
    }
    
    public final String getKey()
    {
      return this.IAh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183427);
      if (c.this.IyI.get())
      {
        this.daz.cancel(false);
        com.tencent.e.d.IxU.w("SerialHandler", String.format("this handler has quit! %s", new Object[] { this.IAh }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      if ((this.IAg.getTarget() == null) && (this.IAg.obj == null) && (this.IAg.what == 0))
      {
        this.daz.cancel(false);
        com.tencent.e.d.IxU.w("SerialHandler", String.format("maybe it's removed before! %s", new Object[] { this.IAh }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      ((Handler)Objects.requireNonNull(this.IAg.getTarget(), "target is null!")).dispatchMessage(this.IAg);
      c.a(c.this, this.IAg);
      AppMethodBeat.o(183427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.j.c
 * JD-Core Version:    0.7.0.1
 */