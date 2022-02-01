package com.tencent.mm.plugin.appbrand.jsruntime;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.e;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.13;
import com.tencent.mm.appbrand.v8.m.5;
import com.tencent.mm.appbrand.v8.m.6;
import com.tencent.mm.appbrand.v8.m.7;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

abstract class d
  implements g, k, l, n, q, s, u, v
{
  private long lFZ = 0L;
  private y lGa;
  
  public boolean Cw()
  {
    return Nx().Nk();
  }
  
  public String Cx()
  {
    return Nx().Cx();
  }
  
  public ByteBuffer J(int paramInt, boolean paramBoolean)
  {
    return bqO().cYr.getBuffer(paramInt, paramBoolean);
  }
  
  protected abstract IJSRuntime Nx();
  
  public long Nz()
  {
    return bqO().Nz();
  }
  
  public <T extends j> T P(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void Sk(String paramString)
  {
    m localm = bqO();
    localm.cZl.r(new m.6(localm, paramString));
  }
  
  public void a(y paramy)
  {
    this.lGa = paramy;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    Nx().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    Nx().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        if (parama != null) {}
        for (n.b localb = new n.b();; localb = null)
        {
          if (localb != null) {
            localb.cZG = System.currentTimeMillis();
          }
          if (d.a(d.this) == 0L)
          {
            ae.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler event[%s] src[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
            d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.Nz()));
          }
          JsBridgeBinding.nativeSubscribeHandler(d.a(d.this), bu.nullAsNil(paramString1), bu.nullAsNil(paramString2), paramInt, bu.nullAsNil(paramString3));
          if (localb != null)
          {
            localb.cZH = System.currentTimeMillis();
            parama.a(localb);
          }
          AppMethodBeat.o(144167);
          return;
        }
      }
    });
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    paramValueCallback = bqO();
    paramValueCallback.cZl.r(new m.7(paramValueCallback, paramString1, paramString2));
  }
  
  public void a(URL paramURL, String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (paramURL == null)
    {
      evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(144163);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(144163);
          }
        })
    {
      bqO().a(paramURL.toString(), paramString, paramValueCallback);
      return;
    }
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, final ValueCallback<String> paramValueCallback)
  {
    Object localObject = null;
    m localm;
    if (paramValueCallback == null)
    {
      paramValueCallback = null;
      localm = bqO();
      if (paramURL != null) {
        break label54;
      }
    }
    label54:
    for (paramURL = localObject;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramValueCallback, paramString1, paramString2, paramInt);
      return;
      paramValueCallback = new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(144164);
          paramValueCallback.onReceiveValue(paramAnonymousString);
          AppMethodBeat.o(144164);
        }
      };
      break;
    }
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, m.b paramb)
  {
    m localm = bqO();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = bqO();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.cZl.r(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    bqO().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  public final void am(final int paramInt, final String paramString)
  {
    Nx().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == 0L)
        {
          ae.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.Nz()));
        }
        JsBridgeBinding.nativeInvokeCallbackHandler(d.a(d.this), paramInt, paramString);
        AppMethodBeat.o(144166);
      }
    });
  }
  
  public void b(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      m localm = bqO();
      paramg = ((d)paramg).bqO();
      localm.cZl.r(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      ae.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  protected abstract m bqO();
  
  public y bqT()
  {
    return this.lGa;
  }
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    bqO().cYr.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public void cj(boolean paramBoolean)
  {
    Nx().cj(paramBoolean);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public void destroy()
  {
    Nx().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144165);
        if (d.a(d.this) != 0L)
        {
          JsBridgeBinding.nativeDestroyRuntime(d.a(d.this));
          d.a(d.this, 0L);
        }
        AppMethodBeat.o(144165);
      }
    });
    bqO().destroy();
  }
  
  public boolean doInnerLoopTask()
  {
    return Nx().doInnerLoopTask();
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(144162);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(144162);
          }
        })
    {
      bqO().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return Nx().getIsolatePtr();
  }
  
  public int getNativeBufferId()
  {
    return bqO().cYr.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return Nx().getUVLoopPtr();
  }
  
  public void pause()
  {
    Nx().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    bqO().cYr.releaseDirectByteBuffer(paramByteBuffer);
  }
  
  public void resume()
  {
    Nx().resume();
  }
  
  public void resumeLoopTasks()
  {
    Nx().resumeLoopTasks();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    bqO().cYr.setBuffer(paramInt, paramByteBuffer);
  }
  
  public void setThreadPriority(int paramInt)
  {
    Nx().setThreadPriority(paramInt);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return bqO().cYr.supportBufferStoreBindTo();
  }
  
  public void ua(int paramInt)
  {
    bqO().cZm.destroy(paramInt);
  }
  
  public ByteBuffer ub(int paramInt)
  {
    return bqO().cZm.hy(paramInt);
  }
  
  public int uc(int paramInt)
  {
    return bqO().cZm.hw(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d
 * JD-Core Version:    0.7.0.1
 */