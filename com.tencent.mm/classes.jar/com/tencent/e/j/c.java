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
  final String HYB;
  private final a IhL;
  final Handler LUn;
  AtomicBoolean LUo;
  private final Handler.Callback LVG;
  public boolean LVH;
  private b LVI;
  public boolean LVn;
  
  public c(a parama)
  {
    this(parama, null);
  }
  
  public c(a parama, Handler.Callback paramCallback)
  {
    AppMethodBeat.i(183430);
    this.LVn = true;
    this.LUo = new AtomicBoolean();
    this.LUn = new Handler(Looper.getMainLooper())
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
        paramAnonymousMessage.setTarget(c.this.LUn);
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
    this.LVI = new b(Message.class, "recycleUnchecked", new Class[0]);
    Objects.requireNonNull(parama);
    this.IhL = parama;
    this.HYB = parama.tag;
    this.LVG = paramCallback;
    try
    {
      parama = this.LUn;
      new com.tencent.e.k.a(Handler.class, "mLooper").ex(parama);
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
    if ((this.LVG != null) && (this.LVG.handleMessage(paramMessage)))
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
    paramPrinter.println(paramString + this.IhL.LVC.fVY().toString());
    AppMethodBeat.o(183461);
  }
  
  public boolean executeOrSendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183449);
    if (a.fVU() == this.IhL)
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
    paramMessage = this.LUn.getMessageName(paramMessage);
    AppMethodBeat.o(183431);
    return paramMessage;
  }
  
  public Handler getSelf()
  {
    return null;
  }
  
  public a getSerial()
  {
    return this.IhL;
  }
  
  public String getSerialTag()
  {
    return this.HYB;
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public boolean hasMessages(final int paramInt)
  {
    AppMethodBeat.i(183457);
    boolean bool = this.IhL.LVC.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183423);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.LVN == c.this) && (c.a.a(paramAnonymouse).what == paramInt))
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
    boolean bool = this.IhL.LVC.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183424);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.LVN == c.this) && (c.a.a(paramAnonymouse).obj == paramObject))
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
    boolean bool = this.LUo.get();
    AppMethodBeat.o(183459);
    return bool;
  }
  
  public Message obtainMessage()
  {
    AppMethodBeat.i(183432);
    Message localMessage = this.LUn.obtainMessage();
    AppMethodBeat.o(183432);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(183433);
    Message localMessage = this.LUn.obtainMessage(paramInt);
    AppMethodBeat.o(183433);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(183435);
    Message localMessage = this.LUn.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(183435);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(183436);
    paramObject = this.LUn.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(183436);
    return paramObject;
  }
  
  public Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183434);
    paramObject = this.LUn.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(183434);
    return paramObject;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(183437);
    boolean bool = this.LUn.post(paramRunnable);
    AppMethodBeat.o(183437);
    return bool;
  }
  
  public boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(183442);
    boolean bool = this.LUn.sendMessageAtTime(Message.obtain(this.LUn, paramRunnable), -9223372036854775808L);
    AppMethodBeat.o(183442);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183438);
    boolean bool = this.LUn.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(183438);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183439);
    boolean bool = this.LUn.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(183439);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183440);
    boolean bool = this.LUn.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183440);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183441);
    paramRunnable = Message.obtain(this.LUn, paramRunnable);
    paramRunnable.obj = paramObject;
    boolean bool = sendMessageDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183441);
    return bool;
  }
  
  public boolean quit()
  {
    AppMethodBeat.i(183460);
    if (this.LUo.compareAndSet(false, true))
    {
      this.IhL.LVC.a(new d.b()
      {
        public final boolean c(e paramAnonymouse)
        {
          boolean bool = false;
          AppMethodBeat.i(183425);
          paramAnonymouse = paramAnonymouse.LVs;
          if ((paramAnonymouse instanceof c.a))
          {
            paramAnonymouse = (c.a)paramAnonymouse;
            if (paramAnonymouse.LVN == c.this) {
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
    this.IhL.LVC.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183418);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.LVN == c.this)
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
    this.IhL.LVC.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183419);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.LVN == c.this)
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
    this.IhL.LVC.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183422);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.LVN == c.this) {
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
    this.IhL.LVC.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183420);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.LVN == c.this)
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
    this.IhL.LVC.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183421);
        paramAnonymouse = paramAnonymouse.LVs;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.LVN == c.this)
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
    boolean bool = this.LUn.sendEmptyMessage(paramInt);
    AppMethodBeat.o(183444);
    return bool;
  }
  
  public boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183446);
    boolean bool = this.LUn.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(183446);
    return bool;
  }
  
  public boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183445);
    boolean bool = this.LUn.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(183445);
    return bool;
  }
  
  public boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183443);
    boolean bool = this.LUn.sendMessage(paramMessage);
    AppMethodBeat.o(183443);
    return bool;
  }
  
  public boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(183448);
    boolean bool = this.LUn.sendMessageAtTime(paramMessage, -9223372036854775808L);
    AppMethodBeat.o(183448);
    return bool;
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183450);
    paramMessage = new a(paramMessage);
    if (isQuit())
    {
      com.tencent.e.d.LTw.f(paramMessage.LVM, 0, this.HYB);
      AppMethodBeat.o(183450);
      return false;
    }
    if (h.LTJ.isShutdown())
    {
      com.tencent.e.d.LTw.f(paramMessage.LVM, 0, this.HYB);
      AppMethodBeat.o(183450);
      return false;
    }
    if (paramLong == -9223372036854775808L) {
      if (a.fVT() == this.IhL) {
        h.LTJ.aQ(paramMessage);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(183450);
      return true;
      h.LTJ.g(paramMessage, this.HYB);
      continue;
      paramLong -= SystemClock.uptimeMillis();
      if (a.fVT() == this.IhL) {
        h.LTJ.q(paramMessage, paramLong);
      } else {
        h.LTJ.a(paramMessage, paramLong, this.HYB);
      }
    }
  }
  
  public boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183447);
    boolean bool = this.LUn.sendMessageDelayed(paramMessage, paramLong);
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
    private Message LVL;
    String LVM;
    Object LVN;
    private Future<?> djn;
    
    a(Message paramMessage)
    {
      AppMethodBeat.i(183426);
      if (paramMessage == null)
      {
        this$1 = new NullPointerException("msg is null");
        AppMethodBeat.o(183426);
        throw c.this;
      }
      this.LVL = paramMessage;
      this.LVM = (c.this.HYB + "#" + c.this.getMessageName(paramMessage));
      this.LVN = c.this;
      AppMethodBeat.o(183426);
    }
    
    public final void a(Future paramFuture)
    {
      this.djn = paramFuture;
    }
    
    public final boolean ahh()
    {
      AppMethodBeat.i(183429);
      boolean bool = c.this.LVn;
      AppMethodBeat.o(183429);
      return bool;
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(183428);
      c.a(c.this, this.LVL);
      boolean bool = this.djn.cancel(false);
      AppMethodBeat.o(183428);
      return bool;
    }
    
    public final String getKey()
    {
      return this.LVM;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183427);
      if (c.this.LUo.get())
      {
        this.djn.cancel(false);
        com.tencent.e.d.LTy.w("SerialHandler", String.format("this handler has quit! %s", new Object[] { this.LVM }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      if ((this.LVL.getTarget() == null) && (this.LVL.obj == null) && (this.LVL.what == 0))
      {
        this.djn.cancel(false);
        com.tencent.e.d.LTy.w("SerialHandler", String.format("maybe it's removed before! %s", new Object[] { this.LVM }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      ((Handler)Objects.requireNonNull(this.LVL.getTarget(), "target is null!")).dispatchMessage(this.LVL);
      c.a(c.this, this.LVL);
      AppMethodBeat.o(183427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.j.c
 * JD-Core Version:    0.7.0.1
 */