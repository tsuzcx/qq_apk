package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.g.a;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public final class o
  implements f, h, m
{
  private com.tencent.xweb.g gIw;
  private volatile boolean gIx = false;
  private volatile boolean gIy = false;
  private volatile CountDownLatch gIz;
  private Handler mHandler;
  
  public o(Context paramContext)
  {
    this.gIw = com.tencent.xweb.g.a(g.a.xgw, "appbrand", paramContext);
    this.gIw.addJavascriptInterface(this, "WeixinJsThreadCaller");
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    if (paramClass.isInstance(this))
    {
      o localo = this;
      if (paramClass == h.class)
      {
        localo = this;
        if (!this.gIw.xgu.cSJ()) {
          localo = null;
        }
      }
      return localo;
    }
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.gIx) {
      return;
    }
    paramURL = new o.2(this, paramURL, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramURL.run();
      return;
    }
    this.mHandler.post(paramURL);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    a(paramURL, paramString3, paramValueCallback);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.gIw.addJavascriptInterface(paramObject, paramString);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final int callFromJsThread()
  {
    y.d("MicroMsg.AppBrandMessBasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[] { Boolean.valueOf(this.gIy) });
    if (this.gIy)
    {
      y.i("MicroMsg.AppBrandMessBasedJsEngine", "pause await threadId %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      this.gIy = false;
      this.gIz = new CountDownLatch(1);
    }
    try
    {
      this.gIz.await();
      return 1;
    }
    catch (InterruptedException localInterruptedException)
    {
      y.e("MicroMsg.AppBrandMessBasedJsEngine", "pause await e = %s", new Object[] { localInterruptedException });
    }
    return 1;
  }
  
  public final void destroy()
  {
    if (!this.gIx)
    {
      com.tencent.xweb.g localg = this.gIw;
      if (!localg.gIx) {
        localg.xgu.cleanup();
      }
      localg.gIx = true;
    }
    this.gIx = true;
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.gIx) {
      return;
    }
    paramString = new o.1(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    this.mHandler.post(paramString);
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    return this.gIw.xgu.getNativeBuffer(paramInt);
  }
  
  public final int getNativeBufferId()
  {
    return this.gIw.xgu.getNativeBufferId();
  }
  
  public final boolean isValid()
  {
    return (this.gIw.xgu != null) && (com.tencent.xweb.g.xgt != g.a.xgw) && (com.tencent.xweb.g.xgt != g.a.xgA);
  }
  
  public final void pause()
  {
    if (this.gIw.cSj())
    {
      this.gIw.xgu.pause();
      return;
    }
    this.gIy = true;
    evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new o.4(this));
  }
  
  public final void resume()
  {
    if (this.gIw.cSj()) {
      this.gIw.xgu.resume();
    }
    do
    {
      return;
      this.gIy = false;
    } while (this.gIz == null);
    this.gIz.countDown();
    this.gIz = null;
  }
  
  public final void setJsExceptionHandler(e parame)
  {
    com.tencent.xweb.g localg = this.gIw;
    parame = new o.3(this, parame);
    localg.xgu.a(parame);
  }
  
  public final void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.gIw.xgu.setNativeBuffer(paramInt, paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.o
 * JD-Core Version:    0.7.0.1
 */