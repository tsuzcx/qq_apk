package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.mmv8.ExecuteDetails;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class m
{
  private static volatile Log.LogImp hmK = null;
  public final e hlL;
  public final IJSRuntime hmL;
  public final d hmM;
  private final LinkedList<o> hmN;
  private final FutureTask<V8Context> hmO;
  private V8Object hmP;
  private final HashMap<String, V8Object> hmQ;
  
  m(IJSRuntime paramIJSRuntime, e parame, final a parama)
  {
    AppMethodBeat.i(144056);
    this.hmN = new LinkedList();
    this.hmP = null;
    this.hmQ = new HashMap();
    this.hmL = paramIJSRuntime;
    this.hmO = new FutureTask(new Callable() {});
    paramIJSRuntime.u(this.hmO);
    paramIJSRuntime = parame;
    if (parame == null) {
      paramIJSRuntime = new u();
    }
    this.hlL = paramIJSRuntime;
    this.hmM = new j(this);
    this.hmL.v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144048);
        if (m.this.aEm() != null) {}
        try
        {
          V8Object localV8Object = m.this.aEm().getGlobalObject();
          m.a(m.this, localV8Object.getObject("console"));
          m.a(m.this).add(new q().f(m.this));
          m.a(m.this).add(new t().f(m.this));
          m.a(m.this).add(new s().f(m.this));
          Log.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { m.b(m.this).aDS() });
          if (m.c(m.this).supportBufferStoreBindTo())
          {
            Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
            m.c(m.this).bufferStoreBindTo(m.b(m.this).getIsolatePtr(), m.this.aEn());
            m.a(m.this).add(new r(m.d(m.this)).f(m.this));
            AppMethodBeat.o(144048);
            return;
          }
        }
        finally
        {
          for (;;)
          {
            Log.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localObject.getMessage() });
            continue;
            Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
            m.a(m.this).add(new p(m.c(m.this)).f(m.this));
          }
        }
      }
    });
    AppMethodBeat.o(144056);
  }
  
  public static void a(Log.LogImp paramLogImp)
  {
    hmK = paramLogImp;
  }
  
  public static boolean aEk()
  {
    return hmK != null;
  }
  
  protected static Log.LogImp aEl()
  {
    return hmK;
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(144066);
    this.hmL.a(paramInt, paramh);
    AppMethodBeat.o(144066);
  }
  
  public final void a(final Object paramObject, final String paramString, final Class<? extends Annotation> paramClass)
  {
    AppMethodBeat.i(144065);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(144065);
      return;
    }
    this.hmL.u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144044);
        m.a(m.this, paramObject, paramString, paramClass);
        AppMethodBeat.o(144044);
      }
    });
    AppMethodBeat.o(144065);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(144061);
    this.hmL.u(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144050);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.aEm().executeScript(paramString, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (;;)
          {
            localb.onResult(str, localc);
            AppMethodBeat.o(144050);
            return;
            str = localObject.toString();
          }
        }
        m.this.aEm().executeVoidScript(paramString, null);
        AppMethodBeat.o(144050);
      }
    });
    AppMethodBeat.o(144061);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb)
  {
    AppMethodBeat.i(144062);
    this.hmL.u(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144051);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.aEm().executeScript(paramString2, paramString1, 0, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (;;)
          {
            localb.onResult(str, localc);
            AppMethodBeat.o(144051);
            return;
            str = localObject.toString();
          }
        }
        m.this.aEm().executeVoidScript(paramString2, paramString1, 0, null);
        AppMethodBeat.o(144051);
      }
    });
    AppMethodBeat.o(144062);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb, final String paramString3, final String paramString4, final int paramInt)
  {
    AppMethodBeat.i(144063);
    this.hmL.u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144052);
        if (paramb != null)
        {
          m.c localc = new m.c();
          localc.hng = paramInt;
          m.c.b(localc);
          Object localObject = m.this.aEm().executeScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (localObject = null;; localObject = localObject.toString())
          {
            localb.onResult((String)localObject, localc);
            AppMethodBeat.o(144052);
            return;
          }
        }
        m.this.aEm().executeVoidScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, null);
        AppMethodBeat.o(144052);
      }
    });
    AppMethodBeat.o(144063);
  }
  
  public final V8Context aEm()
  {
    AppMethodBeat.i(144058);
    try
    {
      V8Context localV8Context = (V8Context)this.hmO.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(144058);
      return localV8Context;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final long aEn()
  {
    AppMethodBeat.i(144059);
    long l = aEm().getPtr();
    AppMethodBeat.o(144059);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(144067);
    this.hmL.w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144045);
        Log.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        Object localObject = m.a(m.this).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((o)((Iterator)localObject).next()).cleanup();
        }
        m.a(m.this).clear();
        localObject = m.this.aEm();
        if (localObject != null) {
          try
          {
            ((V8Context)localObject).release();
            AppMethodBeat.o(144045);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(144045);
      }
    });
    AppMethodBeat.o(144067);
  }
  
  public final V8Object getGlobalObject()
  {
    AppMethodBeat.i(238708);
    V8Object localV8Object = aEm().getGlobalObject();
    AppMethodBeat.o(238708);
    return localV8Object;
  }
  
  public static abstract interface a
  {
    public abstract V8Context aDZ();
  }
  
  public static abstract interface b
  {
    public abstract void onResult(String paramString, m.c paramc);
  }
  
  public static final class c
    extends ExecuteDetails
  {
    public long hne;
    public long hnf;
    public int hng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */