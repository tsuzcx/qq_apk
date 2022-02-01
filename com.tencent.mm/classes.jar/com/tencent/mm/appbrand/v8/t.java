package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.utils.V8ObjectUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class t
  extends o
{
  int fjo;
  final SparseArray<b> fjp;
  volatile Looper fjq;
  private final boolean fjr;
  
  t()
  {
    AppMethodBeat.i(144098);
    this.fjo = 0;
    this.fjp = new SparseArray();
    this.fjr = false;
    AppMethodBeat.o(144098);
  }
  
  static int hk(String paramString)
  {
    AppMethodBeat.i(144099);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(144099);
        return -2147483648;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(144099);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Log.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", paramString, "", new Object[0]);
      AppMethodBeat.o(144099);
    }
    return -2147483648;
  }
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144100);
    if (!(paramm.fiy instanceof b)) {
      this.fjq = Looper.getMainLooper();
    }
    if ((!(paramm.fiy instanceof h)) || (!((h)paramm.fiy).fhI))
    {
      Log.i("MicroMsg.J2V8.V8DirectApiTimer", "hy: not node. need to inject direct timer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(144086);
          if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 7))
          {
            Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.length()), Integer.valueOf(paramAnonymousV8Array.getType(0)) });
            AppMethodBeat.o(144086);
            return null;
          }
          V8Function localV8Function = (V8Function)paramAnonymousV8Array.getObject(0);
          int i;
          label131:
          m localm;
          if (paramAnonymousV8Array.length() > 1) {
            if (paramAnonymousV8Array.getType(1) == 1)
            {
              i = paramAnonymousV8Array.getInteger(1);
              if (paramAnonymousV8Array.length() <= 2) {
                break label304;
              }
              paramAnonymousV8Object = V8ObjectUtils.toList(paramAnonymousV8Array);
              paramAnonymousV8Object = V8ObjectUtils.toV8Array(paramm.acm(), paramAnonymousV8Object.subList(1, paramAnonymousV8Object.size()));
              paramAnonymousV8Array = t.this;
              localm = paramm;
              paramAnonymousV8Array.fjo += 1;
              if (!(localm.fiy instanceof b)) {
                break label320;
              }
            }
          }
          label304:
          label320:
          for (paramAnonymousV8Object = new t.c(paramAnonymousV8Array, localm, paramAnonymousV8Array.fjo, localV8Function, paramAnonymousV8Object, false, i);; paramAnonymousV8Object = new t.a(paramAnonymousV8Array, localm, paramAnonymousV8Array.fjo, localV8Function, paramAnonymousV8Object, false, i))
          {
            paramAnonymousV8Object.schedule();
            paramAnonymousV8Array.fjp.put(paramAnonymousV8Array.fjo, paramAnonymousV8Object);
            i = paramAnonymousV8Array.fjo;
            AppMethodBeat.o(144086);
            return Integer.valueOf(i);
            if (paramAnonymousV8Array.getType(1) == 2)
            {
              i = (int)paramAnonymousV8Array.getDouble(1);
              break;
            }
            if (paramAnonymousV8Array.getType(1) == 4)
            {
              int j = t.hk(paramAnonymousV8Array.getString(1));
              i = j;
              if (j != -2147483648) {
                break;
              }
              AppMethodBeat.o(144086);
              return null;
            }
            Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.getType(1)) });
            AppMethodBeat.o(144086);
            return null;
            i = 0;
            break;
            paramAnonymousV8Object = paramm.acm().newV8Array();
            break label131;
          }
        }
      }, "setTimeout");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(144087);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 7))
          {
            Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.length()), Integer.valueOf(paramAnonymousV8Array.getType(0)) });
            AppMethodBeat.o(144087);
            return null;
          }
          V8Function localV8Function = (V8Function)paramAnonymousV8Array.getObject(0);
          int i;
          label124:
          m localm;
          if (paramAnonymousV8Array.getType(1) == 1)
          {
            i = paramAnonymousV8Array.getInteger(1);
            if (paramAnonymousV8Array.length() <= 2) {
              break label292;
            }
            paramAnonymousV8Object = V8ObjectUtils.toList(paramAnonymousV8Array);
            paramAnonymousV8Object = V8ObjectUtils.toV8Array(paramm.acm(), paramAnonymousV8Object.subList(1, paramAnonymousV8Object.size()));
            paramAnonymousV8Array = t.this;
            localm = paramm;
            paramAnonymousV8Array.fjo += 1;
            if (!(localm.fiy instanceof b)) {
              break label308;
            }
          }
          label292:
          label308:
          for (paramAnonymousV8Object = new t.c(paramAnonymousV8Array, localm, paramAnonymousV8Array.fjo, localV8Function, paramAnonymousV8Object, true, i);; paramAnonymousV8Object = new t.a(paramAnonymousV8Array, localm, paramAnonymousV8Array.fjo, localV8Function, paramAnonymousV8Object, true, i))
          {
            paramAnonymousV8Object.schedule();
            paramAnonymousV8Array.fjp.put(paramAnonymousV8Array.fjo, paramAnonymousV8Object);
            i = paramAnonymousV8Array.fjo;
            AppMethodBeat.o(144087);
            return Integer.valueOf(i);
            if (paramAnonymousV8Array.getType(1) == 2)
            {
              i = (int)paramAnonymousV8Array.getDouble(1);
              break;
            }
            if (paramAnonymousV8Array.getType(1) == 4)
            {
              int j = t.hk(paramAnonymousV8Array.getString(1));
              i = j;
              if (j != -2147483648) {
                break;
              }
              AppMethodBeat.o(144087);
              return null;
            }
            Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.getType(1)) });
            AppMethodBeat.o(144087);
            return null;
            paramAnonymousV8Object = paramm.acm().newV8Array();
            break label124;
          }
        }
      }, "setInterval");
      paramV8Object.registerJavaMethod(new JavaVoidCallback()
      {
        public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(144088);
          if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 1))
          {
            AppMethodBeat.o(144088);
            return;
          }
          t.a(t.this, paramAnonymousV8Array.getInteger(0));
          AppMethodBeat.o(144088);
        }
      }, "clearTimeout");
      paramV8Object.registerJavaMethod(new JavaVoidCallback()
      {
        public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(144089);
          if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 1))
          {
            AppMethodBeat.o(144089);
            return;
          }
          t.a(t.this, paramAnonymousV8Array.getInteger(0));
          AppMethodBeat.o(144089);
        }
      }, "clearInterval");
      AppMethodBeat.o(144100);
      return;
    }
    Log.i("MicroMsg.J2V8.V8DirectApiTimer", "hy: node env do not need java imp timer");
    AppMethodBeat.o(144100);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(144101);
    int i = 0;
    while (i < this.fjp.size())
    {
      ((b)this.fjp.valueAt(i)).cancel();
      i += 1;
    }
    this.fjp.clear();
    Looper localLooper = this.fjq;
    if ((localLooper != null) && (Looper.getMainLooper() != localLooper))
    {
      localLooper.quit();
      this.fjq = null;
    }
    AppMethodBeat.o(144101);
  }
  
  final class a
    extends t.c
    implements Runnable
  {
    private long fjt;
    private long fju;
    private final MTimerHandler timer;
    
    a(final m paramm, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
    {
      super(paramm, paramInt, paramV8Function, paramV8Array, paramBoolean, paramLong);
      AppMethodBeat.i(144091);
      this.timer = new MTimerHandler(t.this.fjq, new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(144090);
          t.a.a(t.a.this, SystemClock.elapsedRealtimeNanos());
          paramm.fiy.q(t.a.this);
          AppMethodBeat.o(144090);
          return false;
        }
      }, false);
      AppMethodBeat.o(144091);
    }
    
    final void cancel()
    {
      AppMethodBeat.i(144094);
      this.timer.stopTimer();
      super.cancel();
      AppMethodBeat.o(144094);
    }
    
    public final void run()
    {
      AppMethodBeat.i(144093);
      if (!isValid())
      {
        AppMethodBeat.o(144093);
        return;
      }
      a(this.fjB);
      if (!isValid())
      {
        AppMethodBeat.o(144093);
        return;
      }
      if (!this.fjA)
      {
        cleanup();
        AppMethodBeat.o(144093);
        return;
      }
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (0L == this.fjt) {}
      for (this.fjt = (l1 - this.fju);; this.fjt = ((l1 + this.fjt - this.fju) / 2L))
      {
        long l2 = this.fjz - TimeUnit.NANOSECONDS.toMillis(this.fjt);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = this.fjz;
        }
        this.timer.startTimer(l1, l1);
        AppMethodBeat.o(144093);
        return;
      }
    }
    
    final void schedule()
    {
      AppMethodBeat.i(144092);
      this.timer.startTimer(this.fjz, this.fjz);
      AppMethodBeat.o(144092);
    }
  }
  
  abstract class b
  {
    m fjx;
    V8Function fjy;
    int id;
    
    b(m paramm, int paramInt, V8Function paramV8Function)
    {
      this.fjx = paramm;
      this.fjy = paramV8Function;
      this.id = paramInt;
    }
    
    final void a(V8Array paramV8Array)
    {
      if ((!this.fjy.isReleased()) && (!this.fjx.acm().isReleased())) {
        this.fjy.call(this.fjx.acm().getGlobalObject(), paramV8Array);
      }
    }
    
    void cancel()
    {
      cleanup();
    }
    
    void cleanup()
    {
      t.this.fjp.remove(this.id);
      this.fjy.release();
    }
    
    final boolean isValid()
    {
      return (!this.fjy.isReleased()) && (!this.fjx.acm().isReleased());
    }
    
    abstract void schedule();
  }
  
  class c
    extends t.b
    implements Runnable
  {
    final boolean fjA;
    final V8Array fjB;
    final long fjz;
    
    c(m paramm, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
    {
      super(paramm, paramInt, paramV8Function);
      this.fjz = paramLong;
      this.fjA = paramBoolean;
      this.fjB = paramV8Array;
    }
    
    final void cleanup()
    {
      AppMethodBeat.i(144097);
      super.cleanup();
      this.fjB.release();
      AppMethodBeat.o(144097);
    }
    
    public void run()
    {
      AppMethodBeat.i(144096);
      if (!isValid())
      {
        AppMethodBeat.o(144096);
        return;
      }
      a(this.fjB);
      if (!isValid())
      {
        AppMethodBeat.o(144096);
        return;
      }
      if (this.fjA)
      {
        schedule();
        AppMethodBeat.o(144096);
        return;
      }
      cleanup();
      AppMethodBeat.o(144096);
    }
    
    void schedule()
    {
      AppMethodBeat.i(144095);
      this.fjx.fiy.d(this, this.fjz);
      AppMethodBeat.o(144095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t
 * JD-Core Version:    0.7.0.1
 */