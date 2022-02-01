package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.ExecuteDetails;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class m
{
  public final e cOL;
  public final IJSRuntime cPC;
  public final d cPD;
  final LinkedList<o> cPE;
  private final FutureTask<V8Context> cPF;
  V8Object cPG;
  private final HashMap<String, V8Object> cPH;
  
  public m(IJSRuntime paramIJSRuntime, e parame, final a parama)
  {
    AppMethodBeat.i(144056);
    this.cPE = new LinkedList();
    this.cPG = null;
    this.cPH = new HashMap();
    this.cPC = paramIJSRuntime;
    this.cPF = new FutureTask(new Callable() {});
    paramIJSRuntime.q(this.cPF);
    paramIJSRuntime = parame;
    if (parame == null) {
      paramIJSRuntime = new u();
    }
    this.cOL = paramIJSRuntime;
    this.cPD = new j(this);
    this.cPC.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144048);
        if (m.this.LT() != null) {}
        try
        {
          V8Object localV8Object = m.this.LT().getGlobalObject();
          m.this.cPG = localV8Object.getObject("console");
          m.this.cPE.add(new q().a(m.this));
          m.this.cPE.add(new t().a(m.this));
          m.this.cPE.add(new s().a(m.this));
          ad.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { m.this.cPC.LE() });
          if (m.this.cOL.supportBufferStoreBindTo())
          {
            ad.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
            m.this.cOL.bufferStoreBindTo(m.this.cPC.getIsolatePtr(), m.this.LU());
            m.this.cPE.add(new r(m.this.cPD).a(m.this));
            AppMethodBeat.o(144048);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
            continue;
            ad.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
            m.this.cPE.add(new p(m.this.cOL).a(m.this));
          }
        }
      }
    });
    AppMethodBeat.o(144056);
  }
  
  final V8Context LT()
  {
    AppMethodBeat.i(144058);
    try
    {
      V8Context localV8Context = (V8Context)this.cPF.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(144058);
      return localV8Context;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final long LU()
  {
    AppMethodBeat.i(144059);
    long l = LT().getPtr();
    AppMethodBeat.o(144059);
    return l;
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(144066);
    this.cPC.a(paramInt, paramh);
    AppMethodBeat.o(144066);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(144061);
    this.cPC.q(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144050);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.LT().executeScript(paramString, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (;;)
          {
            localb.a(str, localc);
            AppMethodBeat.o(144050);
            return;
            str = localObject.toString();
          }
        }
        m.this.LT().executeVoidScript(paramString, null);
        AppMethodBeat.o(144050);
      }
    });
    AppMethodBeat.o(144061);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb)
  {
    AppMethodBeat.i(144062);
    this.cPC.q(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144051);
        ad.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.LT().executeScript(paramString2, paramString1, 0, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (;;)
          {
            localb.a(str, localc);
            AppMethodBeat.o(144051);
            return;
            str = localObject.toString();
          }
        }
        m.this.LT().executeVoidScript(paramString2, paramString1, 0, null);
        AppMethodBeat.o(144051);
      }
    });
    AppMethodBeat.o(144062);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb, final String paramString3, final String paramString4, final int paramInt)
  {
    AppMethodBeat.i(144063);
    this.cPC.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144052);
        ad.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          localc.cPZ = paramInt;
          m.c.b(localc);
          Object localObject = m.this.LT().executeScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {}
          for (localObject = null;; localObject = localObject.toString())
          {
            localb.a((String)localObject, localc);
            AppMethodBeat.o(144052);
            return;
          }
        }
        m.this.LT().executeVoidScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, null);
        AppMethodBeat.o(144052);
      }
    });
    AppMethodBeat.o(144063);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(144067);
    this.cPC.s(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144045);
        ad.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        Object localObject = m.this.cPE.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((o)((Iterator)localObject).next()).cleanup();
        }
        m.this.cPE.clear();
        localObject = m.this.LT();
        if (localObject != null) {
          try
          {
            ((V8Context)localObject).release();
            AppMethodBeat.o(144045);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(144045);
      }
    });
    AppMethodBeat.o(144067);
  }
  
  public static abstract interface a
  {
    public abstract V8Context LL();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, m.c paramc);
  }
  
  public static final class c
    extends ExecuteDetails
  {
    public long cPX;
    public long cPY;
    public int cPZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */