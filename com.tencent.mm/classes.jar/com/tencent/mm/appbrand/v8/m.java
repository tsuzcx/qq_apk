package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.mmv8.ExecuteDetails;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public final e fhB;
  final LinkedList<o> fiA;
  private final FutureTask<V8Context> fiB;
  V8Object fiC;
  private final HashMap<String, V8Object> fiD;
  public final IJSRuntime fiy;
  public final d fiz;
  
  m(IJSRuntime paramIJSRuntime, e parame, final a parama)
  {
    AppMethodBeat.i(144056);
    this.fiA = new LinkedList();
    this.fiC = null;
    this.fiD = new HashMap();
    this.fiy = paramIJSRuntime;
    this.fiB = new FutureTask(new Callable() {});
    paramIJSRuntime.q(this.fiB);
    paramIJSRuntime = parame;
    if (parame == null) {
      paramIJSRuntime = new u();
    }
    this.fhB = paramIJSRuntime;
    this.fiz = new j(this);
    this.fiy.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144048);
        if (m.this.acm() != null) {}
        try
        {
          V8Object localV8Object = m.this.acm().getGlobalObject();
          m.this.fiC = localV8Object.getObject("console");
          m.this.fiA.add(new q().a(m.this));
          m.this.fiA.add(new t().a(m.this));
          m.this.fiA.add(new s().a(m.this));
          Log.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { m.this.fiy.abT() });
          if (m.this.fhB.supportBufferStoreBindTo())
          {
            Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
            m.this.fhB.bufferStoreBindTo(m.this.fiy.getIsolatePtr(), m.this.acn());
            m.this.fiA.add(new r(m.this.fiz).a(m.this));
            AppMethodBeat.o(144048);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
            continue;
            Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
            m.this.fiA.add(new p(m.this.fhB).a(m.this));
          }
        }
      }
    });
    AppMethodBeat.o(144056);
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(144066);
    this.fiy.a(paramInt, paramh);
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
    this.fiy.q(new Runnable()
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
        localObject1 = localm.acm().newV8Object();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Method)((Iterator)localObject3).next();
          ((V8Object)localObject1).registerJavaMethod(localObject2, ((Method)localObject4).getName(), ((Method)localObject4).getName(), ((Method)localObject4).getParameterTypes());
        }
        localm.acm().add(str, (V8Value)localObject1);
        ((V8Object)localObject1).release();
        AppMethodBeat.o(144044);
      }
    });
    AppMethodBeat.o(144065);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(144061);
    this.fiy.q(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144050);
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          Object localObject = m.this.acm().executeScript(paramString, localc);
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
        m.this.acm().executeVoidScript(paramString, null);
        AppMethodBeat.o(144050);
      }
    });
    AppMethodBeat.o(144061);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb)
  {
    AppMethodBeat.i(144062);
    this.fiy.q(new Runnable()
    {
      public final void run()
      {
        String str = null;
        AppMethodBeat.i(144051);
        long l = System.currentTimeMillis();
        Object localObject;
        if (paramb != null)
        {
          m.c localc = new m.c();
          m.c.b(localc);
          localObject = m.this.acm().executeScript(paramString2, paramString1, 0, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null) {
            localb.a(str, localc);
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)  cost(%d)", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(144051);
          return;
          str = localObject.toString();
          break;
          m.this.acm().executeVoidScript(paramString2, paramString1, 0, null);
        }
      }
    });
    AppMethodBeat.o(144062);
  }
  
  public final void a(final String paramString1, final String paramString2, final b paramb, final String paramString3, final String paramString4, final int paramInt)
  {
    AppMethodBeat.i(144063);
    this.fiy.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144052);
        long l = System.currentTimeMillis();
        Object localObject;
        if (paramb != null)
        {
          m.c localc = new m.c();
          localc.fiT = paramInt;
          m.c.b(localc);
          localObject = m.this.acm().executeScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, localc);
          m.c.c(localc);
          m.b localb = paramb;
          if (localObject == null)
          {
            localObject = null;
            localb.a((String)localObject, localc);
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s) cacheCategory(%s) cost(%d)", new Object[] { paramString1, Util.notNullToString(paramString3), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(144052);
          return;
          localObject = localObject.toString();
          break;
          m.this.acm().executeVoidScript(paramString2, paramString1, 0, paramString3, paramString4, paramInt, null);
        }
      }
    });
    AppMethodBeat.o(144063);
  }
  
  public final V8Context acm()
  {
    AppMethodBeat.i(144058);
    try
    {
      V8Context localV8Context = (V8Context)this.fiB.get(10L, TimeUnit.SECONDS);
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
  
  public final long acn()
  {
    AppMethodBeat.i(144059);
    long l = acm().getPtr();
    AppMethodBeat.o(144059);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(144067);
    this.fiy.s(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144045);
        Log.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
        Object localObject = m.this.fiA.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((o)((Iterator)localObject).next()).cleanup();
        }
        m.this.fiA.clear();
        localObject = m.this.acm();
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
    AppMethodBeat.i(262750);
    V8Object localV8Object = acm().getGlobalObject();
    AppMethodBeat.o(262750);
    return localV8Object;
  }
  
  public final V8Array newV8Array()
  {
    AppMethodBeat.i(262752);
    V8Array localV8Array = acm().newV8Array();
    AppMethodBeat.o(262752);
    return localV8Array;
  }
  
  public static abstract interface a
  {
    public abstract V8Context aca();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, m.c paramc);
  }
  
  public static final class c
    extends ExecuteDetails
  {
    public long fiR;
    public long fiS;
    public int fiT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */