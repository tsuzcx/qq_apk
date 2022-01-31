package com.tencent.mm.plugin.appbrand.i;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.d.a.a;
import com.tencent.mm.d.a.b.6;
import com.tencent.mm.d.a.b.8;
import com.tencent.mm.d.a.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import java.nio.ByteBuffer;

abstract class b
  implements d, h, j, m
{
  public <T extends g> T I(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public void a(d paramd, String paramString)
  {
    if ((paramd instanceof b))
    {
      com.tencent.mm.d.a.b localb = alz();
      paramd = ((b)paramd).alz();
      localb.byY.i(new b.8(localb, paramString, paramd));
      return;
    }
    if (paramd == null) {}
    for (paramd = null;; paramd = paramd.getClass().getName())
    {
      y.e("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramd });
      return;
    }
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramURL == null)
    {
      evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new b.2(this, paramValueCallback))
    {
      alz().a(paramURL.toString(), paramString, paramValueCallback);
      return;
    }
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    a(paramURL, paramString3, paramValueCallback);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    com.tencent.mm.d.a.b localb = alz();
    if (!TextUtils.isEmpty(paramString)) {
      localb.byY.i(new b.6(localb, paramObject, paramString, JavascriptInterface.class));
    }
  }
  
  protected abstract com.tencent.mm.d.a.b alz();
  
  public void destroy()
  {
    alz().destroy();
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new b.a()
        {
          public final void cB(String paramAnonymousString)
          {
            paramValueCallback.onReceiveValue(paramAnonymousString);
          }
        })
    {
      alz().a(paramString, paramValueCallback);
      return;
    }
  }
  
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    return alz().byZ.eu(paramInt);
  }
  
  public int getNativeBufferId()
  {
    return alz().byZ.tD();
  }
  
  public void pause()
  {
    alz().pause();
  }
  
  public void resume()
  {
    alz().resume();
  }
  
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    alz().byZ.a(paramInt, paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.b
 * JD-Core Version:    0.7.0.1
 */