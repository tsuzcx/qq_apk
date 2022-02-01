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
import com.tencent.mm.sdk.platformtools.ac;
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
  public final IJSRuntime cMX;
  public final d cMY;
  final LinkedList<o> cMZ;
  public final e cMg;
  private final FutureTask<V8Context> cNa;
  V8Object cNb;
  private final HashMap<String, V8Object> cNc;
  
  public m(IJSRuntime paramIJSRuntime, e parame, final a parama)
  {
    AppMethodBeat.i(144056);
    this.cMZ = new LinkedList();
    this.cNb = null;
    this.cNc = new HashMap();
    this.cMX = paramIJSRuntime;
    this.cNa = new FutureTask(new Callable() {});
    paramIJSRuntime.r(this.cNa);
    paramIJSRuntime = parame;
    if (parame == null) {
      paramIJSRuntime = new u();
    }
    this.cMg = paramIJSRuntime;
    this.cMY = new j(this);
    this.cMX.s(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144048);
        if (m.this.LR() != null) {}
        try
        {
          V8Object localV8Object = m.this.LR().getGlobalObject();
          m.this.cNb = localV8Object.getObject("console");
          m.this.cMZ.add(new q().a(m.this));
          m.this.cMZ.add(new t().a(m.this));
          m.this.cMZ.add(new s().a(m.this));
          ac.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { m.this.cMX.LC() });
          if (m.this.cMg.supportBufferStoreBindTo())
          {
            ac.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
            m.this.cMg.bufferStoreBindTo(m.this.cMX.getIsolatePtr(), m.this.LS());
            m.this.cMZ.add(new r(m.this.cMY).a(m.this));
            AppMethodBeat.o(144048);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
            continue;
            ac.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
            m.this.cMZ.add(new p(m.this.cMg).a(m.this));
          }
        }
      }
    });
    AppMethodBeat.o(144056);
  }
  
  final V8Context LR()
  {
    AppMethodBeat.i(144058);
    try
    {
      V8Context localV8Context = (V8Context)this.cNa.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(144058);
      return localV8Context;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final long LS()
  {
    AppMethodBeat.i(144059);
    long l = LR().getPtr();
    AppMethodBeat.o(144059);
    return l;
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(144066);
    this.cMX.a(paramInt, paramh);
    AppMethodBeat.o(144066);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(144061);
    this.cMX.r(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144050);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.LR().executeScript(paramString, localc);
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
        m.this.LR().executeVoidScript(paramString, null);
        AppMethodBeat.o(144050);
      }
    });
    AppMethodBeat.o(144061);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb)
  {
    AppMethodBeat.i(144062);
    this.cMX.r(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144051);
        ac.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.LR().executeScript(paramString2, paramString1, 0, localc);
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
        m.this.LR().executeVoidScript(paramString2, paramString1, 0, null);
        AppMethodBeat.o(144051);
      }
    });
    AppMethodBeat.o(144062);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb, final String paramString3, final String paramString4, final int paramInt)
  {
    AppMethodBeat.i(144063);
    this.cMX.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144052);
        ac.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          localc.cNu = paramInt;
          m.c.b(localc);
          Object localObject = m.this.LR().executeScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, localc);
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
        m.this.LR().executeVoidScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, null);
        AppMethodBeat.o(144052);
      }
    });
    AppMethodBeat.o(144063);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(144067);
    this.cMX.t(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144045);
        ac.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        Object localObject = m.this.cMZ.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((o)((Iterator)localObject).next()).cleanup();
        }
        m.this.cMZ.clear();
        localObject = m.this.LR();
        if (localObject != null) {
          try
          {
            ((V8Context)localObject).release();
            AppMethodBeat.o(144045);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(144045);
      }
    });
    AppMethodBeat.o(144067);
  }
  
  public static abstract interface a
  {
    public abstract V8Context LJ();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, m.c paramc);
  }
  
  public static final class c
    extends ExecuteDetails
  {
    public long cNs;
    public long cNt;
    public int cNu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */