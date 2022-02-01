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
  int hnB;
  final SparseArray<b> hnC;
  volatile Looper hnD;
  private final boolean hnE;
  
  t()
  {
    AppMethodBeat.i(144098);
    this.hnB = 0;
    this.hnC = new SparseArray();
    this.hnE = false;
    AppMethodBeat.o(144098);
  }
  
  static int iL(String paramString)
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
  
  protected final void b(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144100);
    if (!(paramm.hmL instanceof b)) {
      this.hnD = Looper.getMainLooper();
    }
    if ((!(paramm.hmL instanceof h)) || (!((h)paramm.hmL).hlT))
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
              paramAnonymousV8Object = V8ObjectUtils.toV8Array(paramm.aEm(), paramAnonymousV8Object.subList(1, paramAnonymousV8Object.size()));
              paramAnonymousV8Array = t.this;
              localm = paramm;
              paramAnonymousV8Array.hnB += 1;
              if (!(localm.hmL instanceof b)) {
                break label320;
              }
            }
          }
          label304:
          label320:
          for (paramAnonymousV8Object = new t.c(paramAnonymousV8Array, localm, paramAnonymousV8Array.hnB, localV8Function, paramAnonymousV8Object, false, i);; paramAnonymousV8Object = new t.a(paramAnonymousV8Array, localm, paramAnonymousV8Array.hnB, localV8Function, paramAnonymousV8Object, false, i))
          {
            paramAnonymousV8Object.schedule();
            paramAnonymousV8Array.hnC.put(paramAnonymousV8Array.hnB, paramAnonymousV8Object);
            i = paramAnonymousV8Array.hnB;
            AppMethodBeat.o(144086);
            return Integer.valueOf(i);
            if (paramAnonymousV8Array.getType(1) == 2)
            {
              i = (int)paramAnonymousV8Array.getDouble(1);
              break;
            }
            if (paramAnonymousV8Array.getType(1) == 4)
            {
              int j = t.iL(paramAnonymousV8Array.getString(1));
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
            paramAnonymousV8Object = paramm.aEm().newV8Array();
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
            paramAnonymousV8Object = V8ObjectUtils.toV8Array(paramm.aEm(), paramAnonymousV8Object.subList(1, paramAnonymousV8Object.size()));
            paramAnonymousV8Array = t.this;
            localm = paramm;
            paramAnonymousV8Array.hnB += 1;
            if (!(localm.hmL instanceof b)) {
              break label308;
            }
          }
          label292:
          label308:
          for (paramAnonymousV8Object = new t.c(paramAnonymousV8Array, localm, paramAnonymousV8Array.hnB, localV8Function, paramAnonymousV8Object, true, i);; paramAnonymousV8Object = new t.a(paramAnonymousV8Array, localm, paramAnonymousV8Array.hnB, localV8Function, paramAnonymousV8Object, true, i))
          {
            paramAnonymousV8Object.schedule();
            paramAnonymousV8Array.hnC.put(paramAnonymousV8Array.hnB, paramAnonymousV8Object);
            i = paramAnonymousV8Array.hnB;
            AppMethodBeat.o(144087);
            return Integer.valueOf(i);
            if (paramAnonymousV8Array.getType(1) == 2)
            {
              i = (int)paramAnonymousV8Array.getDouble(1);
              break;
            }
            if (paramAnonymousV8Array.getType(1) == 4)
            {
              int j = t.iL(paramAnonymousV8Array.getString(1));
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
            paramAnonymousV8Object = paramm.aEm().newV8Array();
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
    while (i < this.hnC.size())
    {
      ((b)this.hnC.valueAt(i)).cancel();
      i += 1;
    }
    this.hnC.clear();
    Looper localLooper = this.hnD;
    if ((localLooper != null) && (Looper.getMainLooper() != localLooper))
    {
      localLooper.quit();
      this.hnD = null;
    }
    AppMethodBeat.o(144101);
  }
  
  final class a
    extends t.c
    implements Runnable
  {
    private long hnG;
    private long hnH;
    private final MTimerHandler timer;
    
    a(final m paramm, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
    {
      super(paramm, paramInt, paramV8Function, paramV8Array, paramBoolean, paramLong);
      AppMethodBeat.i(144091);
      this.timer = new MTimerHandler(t.this.hnD, new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(144090);
          t.a.a(t.a.this, SystemClock.elapsedRealtimeNanos());
          paramm.hmL.u(t.a.this);
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
      a(this.hnO);
      if (!isValid())
      {
        AppMethodBeat.o(144093);
        return;
      }
      if (!this.hnN)
      {
        cleanup();
        AppMethodBeat.o(144093);
        return;
      }
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (0L == this.hnG) {}
      for (this.hnG = (l1 - this.hnH);; this.hnG = ((l1 + this.hnG - this.hnH) / 2L))
      {
        long l2 = this.hnM - TimeUnit.NANOSECONDS.toMillis(this.hnG);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = this.hnM;
        }
        this.timer.startTimer(l1, l1);
        AppMethodBeat.o(144093);
        return;
      }
    }
    
    final void schedule()
    {
      AppMethodBeat.i(144092);
      this.timer.startTimer(this.hnM, this.hnM);
      AppMethodBeat.o(144092);
    }
  }
  
  abstract class b
  {
    m hnK;
    V8Function hnL;
    int id;
    
    b(m paramm, int paramInt, V8Function paramV8Function)
    {
      this.hnK = paramm;
      this.hnL = paramV8Function;
      this.id = paramInt;
    }
    
    final void a(V8Array paramV8Array)
    {
      if ((!this.hnL.isReleased()) && (!this.hnK.aEm().isReleased())) {
        this.hnL.call(this.hnK.aEm().getGlobalObject(), paramV8Array);
      }
    }
    
    void cancel()
    {
      cleanup();
    }
    
    void cleanup()
    {
      t.this.hnC.remove(this.id);
      this.hnL.release();
    }
    
    final boolean isValid()
    {
      return (!this.hnL.isReleased()) && (!this.hnK.aEm().isReleased());
    }
    
    abstract void schedule();
  }
  
  class c
    extends t.b
    implements Runnable
  {
    final long hnM;
    final boolean hnN;
    final V8Array hnO;
    
    c(m paramm, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
    {
      super(paramm, paramInt, paramV8Function);
      this.hnM = paramLong;
      this.hnN = paramBoolean;
      this.hnO = paramV8Array;
    }
    
    final void cleanup()
    {
      AppMethodBeat.i(144097);
      super.cleanup();
      this.hnO.release();
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
      a(this.hnO);
      if (!isValid())
      {
        AppMethodBeat.o(144096);
        return;
      }
      if (this.hnN)
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
      this.hnK.hmL.e(this, this.hnM);
      AppMethodBeat.o(144095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t
 * JD-Core Version:    0.7.0.1
 */