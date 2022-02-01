package com.tencent.mm.plugin.appbrand.m;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.e;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.13;
import com.tencent.mm.appbrand.v8.m.5;
import com.tencent.mm.appbrand.v8.m.6;
import com.tencent.mm.appbrand.v8.m.7;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

abstract class d
  implements g, k, l, n, q, s, u, v
{
  private y pOD;
  private AppBrandJsBridgeBinding pOE;
  
  public ByteBuffer BA(int paramInt)
  {
    return bYR().fiz.ki(paramInt);
  }
  
  public int BB(int paramInt)
  {
    return bYR().fiz.kg(paramInt);
  }
  
  public void Bz(int paramInt)
  {
    bYR().fiz.destroy(paramInt);
  }
  
  public boolean OF()
  {
    return bYQ().abY();
  }
  
  public String OG()
  {
    return bYQ().OG();
  }
  
  public ByteBuffer P(int paramInt, boolean paramBoolean)
  {
    return bYR().fhB.getBuffer(paramInt, paramBoolean);
  }
  
  public <T extends j> T Q(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void a(y paramy)
  {
    this.pOD = paramy;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    bYQ().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    bYQ().q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        n.b localb = null;
        if (parama != null) {
          localb = new n.b();
        }
        if (localb != null) {
          localb.fiR = System.currentTimeMillis();
        }
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler");
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.acn());
        }
        d.a(d.this).subscribeHandler(Util.nullAsNil(paramString1), Util.nullAsNil(paramString2), paramInt, Util.nullAsNil(paramString3));
        if (localb != null)
        {
          localb.fiS = System.currentTimeMillis();
          parama.a(localb);
        }
        AppMethodBeat.o(144167);
      }
    });
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    paramValueCallback = bYR();
    paramValueCallback.fiy.q(new m.7(paramValueCallback, paramString1, paramString2));
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
      bYR().a(paramURL.toString(), paramString, paramValueCallback);
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
      localm = bYR();
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
    m localm = bYR();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = bYR();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.fiy.q(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public long acn()
  {
    return bYR().acn();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    bYR().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  public void ajL(String paramString)
  {
    m localm = bYR();
    localm.fiy.q(new m.6(localm, paramString));
  }
  
  public void b(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      m localm = bYR();
      paramg = ((d)paramg).bYR();
      localm.fiy.q(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      Log.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  public abstract IJSRuntime bYQ();
  
  protected abstract m bYR();
  
  public y bYW()
  {
    return this.pOD;
  }
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    bYR().fhB.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public void destroy()
  {
    bYQ().q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144165);
        if (d.a(d.this) != null)
        {
          d.a(d.this).destroyRuntime();
          d.a(d.this, null);
        }
        AppMethodBeat.o(144165);
      }
    });
    bYR().destroy();
  }
  
  public boolean doInnerLoopTask()
  {
    return bYQ().doInnerLoopTask();
  }
  
  public void dp(boolean paramBoolean)
  {
    bYQ().dp(paramBoolean);
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
      bYR().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return bYQ().getIsolatePtr();
  }
  
  public int getNativeBufferId()
  {
    return bYR().fhB.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return bYQ().getUVLoopPtr();
  }
  
  public final void invokeCallbackHandler(final int paramInt, final String paramString)
  {
    bYQ().q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.acn());
        }
        d.a(d.this).invokeCallbackHandler(paramInt, paramString);
        AppMethodBeat.o(144166);
      }
    });
  }
  
  public void ke(int paramInt)
  {
    bYQ().ke(paramInt);
  }
  
  public void pause()
  {
    bYQ().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    bYR().fhB.releaseDirectByteBuffer(paramByteBuffer);
  }
  
  public void resume()
  {
    bYQ().resume();
  }
  
  public void resumeLoopTasks()
  {
    bYQ().resumeLoopTasks();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    bYR().fhB.setBuffer(paramInt, paramByteBuffer);
  }
  
  public final void subscribeHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return bYR().fhB.supportBufferStoreBindTo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.d
 * JD-Core Version:    0.7.0.1
 */