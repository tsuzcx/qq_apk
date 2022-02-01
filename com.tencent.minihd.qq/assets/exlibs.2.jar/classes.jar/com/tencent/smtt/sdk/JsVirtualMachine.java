package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context a;
  private final IX5JsVirtualMachine b;
  private final HashSet<WeakReference<a>> c = new HashSet();
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.a = paramContext;
    this.b = X5JsCore.a(paramContext, paramLooper);
  }
  
  protected IX5JsContext a()
  {
    if (this.b == null)
    {
      a locala = new a(this.a);
      this.c.add(new WeakReference(locala));
      return locala;
    }
    return this.b.createJsContext();
  }
  
  public void destroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).destroy();
        }
      }
    }
  }
  
  public Looper getLooper()
  {
    if (this.b != null) {
      return this.b.getLooper();
    }
    return Looper.myLooper();
  }
  
  public boolean isFallback()
  {
    return this.b == null;
  }
  
  public void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public void onResume()
  {
    if (this.b != null) {
      this.b.onResume();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((a)localWeakReference.get()).b();
        }
      }
    }
  }
  
  private static class a
    implements IX5JsContext
  {
    private WebView a;
    
    public a(Context paramContext)
    {
      this.a = new WebView(paramContext);
      this.a.getSettings().setJavaScriptEnabled(true);
    }
    
    public void a()
    {
      if (this.a == null) {
        return;
      }
      this.a.onPause();
    }
    
    public void addJavascriptInterface(Object paramObject, String paramString)
    {
      if (this.a == null) {
        return;
      }
      this.a.addJavascriptInterface(paramObject, paramString);
      this.a.loadUrl("about:blank");
    }
    
    public void b()
    {
      if (this.a == null) {
        return;
      }
      this.a.onResume();
    }
    
    public void destroy()
    {
      if (this.a == null) {
        return;
      }
      this.a.clearHistory();
      this.a.clearCache(true);
      this.a.loadUrl("about:blank");
      this.a.freeMemory();
      this.a.pauseTimers();
      this.a.destroy();
      this.a = null;
    }
    
    public void evaluateJavascript(String paramString, final android.webkit.ValueCallback<String> paramValueCallback, URL paramURL)
    {
      if (this.a == null) {
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void a(String paramAnonymousString)
            {
              paramValueCallback.onReceiveValue(paramAnonymousString);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        return;
      }
    }
    
    public IX5JsValue evaluateScript(String paramString, URL paramURL)
    {
      if (this.a == null) {
        return null;
      }
      this.a.evaluateJavascript(paramString, null);
      return null;
    }
    
    public void evaluateScriptAsync(String paramString, final android.webkit.ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
    {
      if (this.a == null) {
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void a(String paramAnonymousString)
            {
              paramValueCallback.onReceiveValue(null);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        return;
      }
    }
    
    public byte[] getNativeBuffer(int paramInt)
    {
      return null;
    }
    
    public int getNativeBufferId()
    {
      return -1;
    }
    
    public void removeJavascriptInterface(String paramString)
    {
      if (this.a == null) {
        return;
      }
      this.a.removeJavascriptInterface(paramString);
    }
    
    public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> paramValueCallback) {}
    
    public void setName(String paramString) {}
    
    public int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
    {
      return -1;
    }
    
    public void setPerContextData(Object paramObject) {}
    
    public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */