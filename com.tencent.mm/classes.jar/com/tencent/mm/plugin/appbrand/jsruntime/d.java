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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

abstract class d
  implements g, k, l, n, q, s, u, v
{
  private long lBB = 0L;
  
  public boolean Ct()
  {
    return bqe().Np();
  }
  
  public String Cu()
  {
    return bqe().Cu();
  }
  
  public long NB()
  {
    return bqf().NB();
  }
  
  public <T extends j> T P(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void RB(String paramString)
  {
    m localm = bqf();
    localm.cYn.r(new m.6(localm, paramString));
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    bqe().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    bqe().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        if (parama != null) {}
        for (n.b localb = new n.b();; localb = null)
        {
          if (localb != null) {
            localb.cYI = System.currentTimeMillis();
          }
          if (d.a(d.this) == 0L)
          {
            ad.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler event[%s] src[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
            d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.NB()));
          }
          JsBridgeBinding.nativeSubscribeHandler(d.a(d.this), bt.nullAsNil(paramString1), bt.nullAsNil(paramString2), paramInt, bt.nullAsNil(paramString3));
          if (localb != null)
          {
            localb.cYJ = System.currentTimeMillis();
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
    paramValueCallback = bqf();
    paramValueCallback.cYn.r(new m.7(paramValueCallback, paramString1, paramString2));
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
      bqf().a(paramURL.toString(), paramString, paramValueCallback);
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
      localm = bqf();
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
    m localm = bqf();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = bqf();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.cYn.r(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    bqf().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  public ByteBuffer ak(int paramInt, boolean paramBoolean)
  {
    return bqf().cXu.getBuffer(paramInt, paramBoolean);
  }
  
  public final void am(final int paramInt, final String paramString)
  {
    bqe().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == 0L)
        {
          ad.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.NB()));
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
      m localm = bqf();
      paramg = ((d)paramg).bqf();
      localm.cYn.r(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      ad.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  protected abstract IJSRuntime bqe();
  
  protected abstract m bqf();
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    bqf().cXu.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public void cj(boolean paramBoolean)
  {
    bqe().cj(paramBoolean);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public void destroy()
  {
    bqe().r(new Runnable()
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
    bqf().destroy();
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
      bqf().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return bqe().getIsolatePtr();
  }
  
  public int getNativeBufferId()
  {
    return bqf().cXu.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return bqe().getUVLoopPtr();
  }
  
  public void pause()
  {
    bqe().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    bqf().cXu.releaseDirectByteBuffer(paramByteBuffer);
  }
  
  public void resume()
  {
    bqe().resume();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    bqf().cXu.setBuffer(paramInt, paramByteBuffer);
  }
  
  public void setThreadPriority(int paramInt)
  {
    bqe().setThreadPriority(paramInt);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return bqf().cXu.supportBufferStoreBindTo();
  }
  
  public void tU(int paramInt)
  {
    bqf().cYo.destroy(paramInt);
  }
  
  public ByteBuffer tV(int paramInt)
  {
    return bqf().cYo.hy(paramInt);
  }
  
  public int tW(int paramInt)
  {
    return bqf().cYo.hw(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d
 * JD-Core Version:    0.7.0.1
 */