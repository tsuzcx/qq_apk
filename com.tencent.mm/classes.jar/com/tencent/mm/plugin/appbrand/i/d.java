package com.tencent.mm.plugin.appbrand.i;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.e;
import com.tencent.mm.d.a.f;
import com.tencent.mm.d.a.l.10;
import com.tencent.mm.d.a.l.12;
import com.tencent.mm.d.a.l.3;
import com.tencent.mm.d.a.l.4;
import com.tencent.mm.d.a.l.5;
import com.tencent.mm.d.a.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import java.nio.ByteBuffer;

abstract class d
  implements g, k, l, n, p, r, s
{
  public void Di(String paramString)
  {
    com.tencent.mm.d.a.l locall = aGy();
    locall.cbC.k(new l.4(locall, paramString));
  }
  
  public void a(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      com.tencent.mm.d.a.l locall = aGy();
      paramg = ((d)paramg).aGy();
      locall.cbC.k(new l.3(locall, paramString, paramg));
      return;
    }
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getClass().getName())
    {
      ab.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    paramValueCallback = aGy();
    paramValueCallback.cbC.k(new l.5(paramValueCallback, paramString1, paramString2));
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramURL == null)
    {
      evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new d.2(this, paramValueCallback))
    {
      aGy().a(paramURL.toString(), paramString, paramValueCallback);
      return;
    }
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, String paramString3, final ValueCallback<String> paramValueCallback)
  {
    com.tencent.mm.d.a.l locall;
    if (paramValueCallback == null)
    {
      paramValueCallback = null;
      locall = aGy();
      if (paramURL != null) {
        break label62;
      }
    }
    label62:
    for (paramURL = null;; paramURL = paramURL.toString())
    {
      locall.cbC.k(new l.10(locall, paramURL, paramValueCallback, paramString3, paramString1, paramString2));
      return;
      paramValueCallback = new l.b()
      {
        public final void dO(String paramAnonymousString)
        {
          AppMethodBeat.i(113936);
          paramValueCallback.onReceiveValue(paramAnonymousString);
          AppMethodBeat.o(113936);
        }
      };
      break;
    }
  }
  
  public long aGD()
  {
    return aGy().Cu().getPtr();
  }
  
  protected abstract c aGx();
  
  protected abstract com.tencent.mm.d.a.l aGy();
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    com.tencent.mm.d.a.l locall = aGy();
    if (!TextUtils.isEmpty(paramString)) {
      locall.cbC.k(new l.12(locall, paramObject, paramString, JavascriptInterface.class));
    }
  }
  
  public void destroy()
  {
    aGy().destroy();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new d.1(this, paramValueCallback))
    {
      aGy().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public long getIsolatePtr()
  {
    return aGx().getIsolatePtr();
  }
  
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    return aGy().cbf.gk(paramInt);
  }
  
  public int getNativeBufferId()
  {
    return aGy().cbf.Co();
  }
  
  public int oA(int paramInt)
  {
    return aGy().cbD.gh(paramInt);
  }
  
  public void oy(int paramInt)
  {
    aGy().cbD.destroy(paramInt);
  }
  
  public ByteBuffer oz(int paramInt)
  {
    return aGy().cbD.gj(paramInt);
  }
  
  public void pause()
  {
    aGx().pause();
  }
  
  public void post(Runnable paramRunnable)
  {
    aGx().f(paramRunnable, 0L);
  }
  
  public void resume()
  {
    aGx().resume();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    aGy().cbf.a(paramInt, paramByteBuffer);
  }
  
  public void setThreadPriority(int paramInt)
  {
    aGx().setThreadPriority(paramInt);
  }
  
  public boolean uB()
  {
    return aGx().Cl();
  }
  
  public <T extends j> T v(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.d
 * JD-Core Version:    0.7.0.1
 */