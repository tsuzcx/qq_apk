package com.tencent.mm.plugin.appbrand.jsruntime;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.e;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.13;
import com.tencent.mm.appbrand.v8.m.3;
import com.tencent.mm.appbrand.v8.m.5;
import com.tencent.mm.appbrand.v8.m.6;
import com.tencent.mm.appbrand.v8.m.7;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

abstract class d
  implements g, k, l, n, q, s, u, v
{
  private long leC = 0L;
  
  public boolean AU()
  {
    return bmt().LH();
  }
  
  public String AV()
  {
    return bmt().AV();
  }
  
  public long LS()
  {
    return bmu().LS();
  }
  
  public void Od(String paramString)
  {
    m localm = bmu();
    localm.cMX.r(new m.6(localm, paramString));
  }
  
  public <T extends j> T P(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    bmt().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    bmt().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        if (parama != null) {}
        for (n.b localb = new n.b();; localb = null)
        {
          if (localb != null) {
            localb.cNs = System.currentTimeMillis();
          }
          if (d.a(d.this) == 0L)
          {
            ac.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler event[%s] src[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
            d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.LS()));
          }
          JsBridgeBinding.nativeSubscribeHandler(d.a(d.this), bs.nullAsNil(paramString1), bs.nullAsNil(paramString2), paramInt, bs.nullAsNil(paramString3));
          if (localb != null)
          {
            localb.cNt = System.currentTimeMillis();
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
    paramValueCallback = bmu();
    paramValueCallback.cMX.r(new m.7(paramValueCallback, paramString1, paramString2));
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
      bmu().a(paramURL.toString(), paramString, paramValueCallback);
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
      localm = bmu();
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
    m localm = bmu();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = bmu();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.cMX.r(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    m localm = bmu();
    if (!TextUtils.isEmpty(paramString)) {
      localm.cMX.r(new m.3(localm, paramObject, paramString, JavascriptInterface.class));
    }
  }
  
  public final void ak(final int paramInt, final String paramString)
  {
    bmt().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == 0L)
        {
          ac.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this, JsBridgeBinding.nativeCreateRuntime(d.this.getIsolatePtr(), d.this.LS()));
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
      m localm = bmu();
      paramg = ((d)paramg).bmu();
      localm.cMX.r(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      ac.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  protected abstract IJSRuntime bmt();
  
  protected abstract m bmu();
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    bmu().cMg.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public void ci(boolean paramBoolean)
  {
    bmt().ci(paramBoolean);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public void destroy()
  {
    bmt().r(new Runnable()
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
    bmu().destroy();
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
      bmu().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return bmt().getIsolatePtr();
  }
  
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    return bmu().cMg.getBuffer(paramInt);
  }
  
  public int getNativeBufferId()
  {
    return bmu().cMg.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return bmt().getUVLoopPtr();
  }
  
  public void pause()
  {
    bmt().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void resume()
  {
    bmt().resume();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    bmu().cMg.setBuffer(paramInt, paramByteBuffer);
  }
  
  public void setThreadPriority(int paramInt)
  {
    bmt().setThreadPriority(paramInt);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return bmu().cMg.supportBufferStoreBindTo();
  }
  
  public void tr(int paramInt)
  {
    bmu().cMY.destroy(paramInt);
  }
  
  public ByteBuffer ts(int paramInt)
  {
    return bmu().cMY.hr(paramInt);
  }
  
  public int tt(int paramInt)
  {
    return bmu().cMY.hp(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d
 * JD-Core Version:    0.7.0.1
 */