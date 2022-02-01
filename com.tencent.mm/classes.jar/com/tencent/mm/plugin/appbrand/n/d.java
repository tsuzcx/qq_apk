package com.tencent.mm.plugin.appbrand.n;

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
  private y sTc;
  private AppBrandJsBridgeBinding sTd;
  
  public void BM(int paramInt)
  {
    czf().hmM.destroy(paramInt);
  }
  
  public ByteBuffer BN(int paramInt)
  {
    return czf().hmM.nQ(paramInt);
  }
  
  public int BO(int paramInt)
  {
    return czf().hmM.nO(paramInt);
  }
  
  public <T extends j> T Z(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void a(y paramy)
  {
    this.sTc = paramy;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    cze().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    cze().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        n.b localb = null;
        if (parama != null) {
          localb = new n.b();
        }
        if (localb != null) {
          localb.hne = System.currentTimeMillis();
        }
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler");
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.aEn());
        }
        d.a(d.this).subscribeHandler(Util.nullAsNil(paramString1), Util.nullAsNil(paramString2), paramInt, Util.nullAsNil(paramString3));
        if (localb != null)
        {
          localb.hnf = System.currentTimeMillis();
          parama.a(localb);
        }
        AppMethodBeat.o(144167);
      }
    });
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    paramValueCallback = czf();
    paramValueCallback.hmL.u(new m.7(paramValueCallback, paramString1, paramString2));
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
          public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(144163);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(144163);
          }
        })
    {
      czf().a(paramURL.toString(), paramString, paramValueCallback);
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
      localm = czf();
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
        public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
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
    m localm = czf();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = czf();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.hmL.u(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public long aEn()
  {
    return czf().aEn();
  }
  
  public void acL(String paramString)
  {
    m localm = czf();
    localm.hmL.u(new m.6(localm, paramString));
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    czf().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  public ByteBuffer ae(int paramInt, boolean paramBoolean)
  {
    return czf().hlL.getBuffer(paramInt, paramBoolean);
  }
  
  public boolean aoN()
  {
    return cze().aDX();
  }
  
  public String aoO()
  {
    return cze().aoO();
  }
  
  public void b(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      m localm = czf();
      paramg = ((d)paramg).czf();
      localm.hmL.u(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      Log.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    czf().hlL.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public abstract IJSRuntime cze();
  
  protected abstract m czf();
  
  public y czk()
  {
    return this.sTc;
  }
  
  public void destroy()
  {
    cze().u(new Runnable()
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
    czf().destroy();
  }
  
  public boolean doInnerLoopTask()
  {
    return cze().doInnerLoopTask();
  }
  
  public void eb(boolean paramBoolean)
  {
    cze().eb(paramBoolean);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new m.b()
        {
          public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(144162);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(144162);
          }
        })
    {
      czf().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return cze().getIsolatePtr();
  }
  
  public int getNativeBufferId()
  {
    return czf().hlL.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return cze().getUVLoopPtr();
  }
  
  public final void invokeCallbackHandler(final int paramInt, final String paramString)
  {
    cze().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.aEn());
        }
        d.a(d.this).invokeCallbackHandler(paramInt, paramString);
        AppMethodBeat.o(144166);
      }
    });
  }
  
  public void nM(int paramInt)
  {
    cze().nM(paramInt);
  }
  
  public void pause()
  {
    cze().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    czf().hlL.releaseDirectByteBuffer(paramByteBuffer);
  }
  
  public void resume()
  {
    cze().resume();
  }
  
  public void resumeLoopTasks()
  {
    cze().resumeLoopTasks();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    czf().hlL.setBuffer(paramInt, paramByteBuffer);
  }
  
  public final void subscribeHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return czf().hlL.supportBufferStoreBindTo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d
 * JD-Core Version:    0.7.0.1
 */