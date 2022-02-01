package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.v8.ExecuteDetails;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.annotation.Annotation;
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
  public final e cYr;
  public final IJSRuntime cZl;
  public final d cZm;
  final LinkedList<o> cZn;
  private final FutureTask<V8Context> cZo;
  V8Object cZp;
  private final HashMap<String, V8Object> cZq;
  
  m(IJSRuntime paramIJSRuntime, e parame, final a parama)
  {
    AppMethodBeat.i(144056);
    this.cZn = new LinkedList();
    this.cZp = null;
    this.cZq = new HashMap();
    this.cZl = paramIJSRuntime;
    this.cZo = new FutureTask(new Callable() {});
    paramIJSRuntime.r(this.cZo);
    paramIJSRuntime = parame;
    if (parame == null) {
      paramIJSRuntime = new u();
    }
    this.cYr = paramIJSRuntime;
    this.cZm = new j(this);
    this.cZl.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144048);
        if (m.this.Ny() != null) {}
        try
        {
          V8Object localV8Object = m.this.Ny().getGlobalObject();
          m.this.cZp = localV8Object.getObject("console");
          m.this.cZn.add(new q().a(m.this));
          m.this.cZn.add(new t().a(m.this));
          m.this.cZn.add(new s().a(m.this));
          ae.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { m.this.cZl.Nf() });
          if (m.this.cYr.supportBufferStoreBindTo())
          {
            ae.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
            m.this.cYr.bufferStoreBindTo(m.this.cZl.getIsolatePtr(), m.this.Nz());
            m.this.cZn.add(new r(m.this.cZm).a(m.this));
            AppMethodBeat.o(144048);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
            continue;
            ae.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
            m.this.cZn.add(new p(m.this.cYr).a(m.this));
          }
        }
      }
    }, false);
    AppMethodBeat.o(144056);
  }
  
  public final IJSRuntime Nx()
  {
    return this.cZl;
  }
  
  public final V8Context Ny()
  {
    AppMethodBeat.i(144058);
    try
    {
      V8Context localV8Context = (V8Context)this.cZo.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(144058);
      return localV8Context;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final long Nz()
  {
    AppMethodBeat.i(144059);
    long l = Ny().getPtr();
    AppMethodBeat.o(144059);
    return l;
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(144066);
    this.cZl.a(paramInt, paramh);
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
    this.cZl.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144044);
        m localm = m.this;
        Object localObject2 = paramObject;
        String str = paramString;
        Object localObject4 = paramClass;
        Object localObject1 = localObject2.getClass();
        Object localObject3 = new ArrayList();
        while (localObject1 != Object.class)
        {
          Iterator localIterator = new ArrayList(Arrays.asList(((Class)localObject1).getDeclaredMethods())).iterator();
          while (localIterator.hasNext())
          {
            Method localMethod = (Method)localIterator.next();
            if ((localObject4 == null) || (localMethod.isAnnotationPresent((Class)localObject4))) {
              ((List)localObject3).add(localMethod);
            }
          }
          localObject1 = ((Class)localObject1).getSuperclass();
        }
        localObject1 = localm.Ny().newV8Object();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Method)((Iterator)localObject3).next();
          ((V8Object)localObject1).registerJavaMethod(localObject2, ((Method)localObject4).getName(), ((Method)localObject4).getName(), ((Method)localObject4).getParameterTypes());
        }
        localm.Ny().add(str, (V8Value)localObject1);
        ((V8Object)localObject1).release();
        AppMethodBeat.o(144044);
      }
    });
    AppMethodBeat.o(144065);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(144061);
    this.cZl.r(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144050);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.Ny().executeScript(paramString, localc);
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
        m.this.Ny().executeVoidScript(paramString, null);
        AppMethodBeat.o(144050);
      }
    });
    AppMethodBeat.o(144061);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb)
  {
    AppMethodBeat.i(144062);
    this.cZl.r(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144051);
        ae.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.Ny().executeScript(paramString2, paramString1, 0, localc);
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
        m.this.Ny().executeVoidScript(paramString2, paramString1, 0, null);
        AppMethodBeat.o(144051);
      }
    });
    AppMethodBeat.o(144062);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb, final String paramString3, final String paramString4, final int paramInt)
  {
    AppMethodBeat.i(144063);
    this.cZl.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144052);
        ae.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { paramString1 });
        if (paramb != null)
        {
          m.c localc = new m.c();
          localc.cZI = paramInt;
          m.c.b(localc);
          Object localObject = m.this.Ny().executeScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, localc);
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
        m.this.Ny().executeVoidScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, null);
        AppMethodBeat.o(144052);
      }
    });
    AppMethodBeat.o(144063);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(144067);
    this.cZl.s(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144045);
        ae.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        Object localObject = m.this.cZn.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((o)((Iterator)localObject).next()).cleanup();
        }
        m.this.cZn.clear();
        localObject = m.this.Ny();
        if (localObject != null) {
          try
          {
            ((V8Context)localObject).release();
            AppMethodBeat.o(144045);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
          }
        }
        AppMethodBeat.o(144045);
      }
    });
    AppMethodBeat.o(144067);
  }
  
  public final V8Object getGlobalObject()
  {
    AppMethodBeat.i(194170);
    V8Object localV8Object = Ny().getGlobalObject();
    AppMethodBeat.o(194170);
    return localV8Object;
  }
  
  public final V8Array newV8Array()
  {
    AppMethodBeat.i(194171);
    V8Array localV8Array = Ny().newV8Array();
    AppMethodBeat.o(194171);
    return localV8Array;
  }
  
  public static abstract interface a
  {
    public abstract V8Context Nm();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, m.c paramc);
  }
  
  public static final class c
    extends ExecuteDetails
  {
    public long cZG;
    public long cZH;
    public int cZI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */