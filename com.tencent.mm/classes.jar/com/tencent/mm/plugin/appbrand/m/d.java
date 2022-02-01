package com.tencent.mm.plugin.appbrand.m;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
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
  private y mNJ;
  private AppBrandJsBridgeBinding mNK;
  
  public boolean LO()
  {
    return bMz().Xw();
  }
  
  public String LP()
  {
    return bMz().LP();
  }
  
  public ByteBuffer N(int paramInt, boolean paramBoolean)
  {
    return bMA().doV.getBuffer(paramInt, paramBoolean);
  }
  
  public <T extends j> T R(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public long XK()
  {
    return bMA().XK();
  }
  
  public void a(y paramy)
  {
    this.mNJ = paramy;
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    bMz().a(paramRunnable, 0L, paramBoolean);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3, final n.a parama)
  {
    bMz().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144167);
        n.b localb = null;
        if (parama != null) {
          localb = new n.b();
        }
        if (localb != null) {
          localb.dqk = System.currentTimeMillis();
        }
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler");
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.XK());
        }
        d.a(d.this).subscribeHandler(Util.nullAsNil(paramString1), Util.nullAsNil(paramString2), paramInt, Util.nullAsNil(paramString3));
        if (localb != null)
        {
          localb.dql = System.currentTimeMillis();
          parama.a(localb);
        }
        AppMethodBeat.o(144167);
      }
    });
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    paramValueCallback = bMA();
    paramValueCallback.dpQ.r(new m.7(paramValueCallback, paramString1, paramString2));
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
      bMA().a(paramURL.toString(), paramString, paramValueCallback);
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
      localm = bMA();
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
    m localm = bMA();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb)
  {
    m localm = bMA();
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      localm.dpQ.r(new m.13(localm, paramURL, paramb, paramArrayList, paramString1, paramString2));
      return;
    }
  }
  
  public void abQ(String paramString)
  {
    m localm = bMA();
    localm.dpQ.r(new m.6(localm, paramString));
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    bMA().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  public void b(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      m localm = bMA();
      paramg = ((d)paramg).bMA();
      localm.dpQ.r(new m.5(localm, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      Log.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  protected abstract m bMA();
  
  public y bMF()
  {
    return this.mNJ;
  }
  
  public abstract IJSRuntime bMz();
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    bMA().doV.bufferStoreBindTo(paramLong1, paramLong2);
  }
  
  public void cS(boolean paramBoolean)
  {
    bMz().cS(paramBoolean);
  }
  
  public void destroy()
  {
    bMz().r(new Runnable()
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
    bMA().destroy();
  }
  
  public boolean doInnerLoopTask()
  {
    return bMz().doInnerLoopTask();
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
      bMA().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return bMz().getIsolatePtr();
  }
  
  public int getNativeBufferId()
  {
    return bMA().doV.generateId();
  }
  
  public long getUVLoopPtr()
  {
    return bMz().getUVLoopPtr();
  }
  
  public final void invokeCallbackHandler(final int paramInt, final String paramString)
  {
    bMz().r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144166);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new AppBrandJsBridgeBinding());
          Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(paramInt) });
          d.a(d.this).createRuntime(d.this.getIsolatePtr(), d.this.XK());
        }
        d.a(d.this).invokeCallbackHandler(paramInt, paramString);
        AppMethodBeat.o(144166);
      }
    });
  }
  
  public void pause()
  {
    bMz().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    bMA().doV.releaseDirectByteBuffer(paramByteBuffer);
  }
  
  public void resume()
  {
    bMz().resume();
  }
  
  public void resumeLoopTasks()
  {
    bMz().resumeLoopTasks();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    bMA().doV.setBuffer(paramInt, paramByteBuffer);
  }
  
  public void setThreadPriority(int paramInt)
  {
    bMz().setThreadPriority(paramInt);
  }
  
  public final void subscribeHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return bMA().doV.supportBufferStoreBindTo();
  }
  
  public void xZ(int paramInt)
  {
    bMA().dpR.destroy(paramInt);
  }
  
  public ByteBuffer ya(int paramInt)
  {
    return bMA().dpR.iS(paramInt);
  }
  
  public int yb(int paramInt)
  {
    return bMA().dpR.iQ(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.d
 * JD-Core Version:    0.7.0.1
 */