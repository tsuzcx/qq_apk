package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext
{
  private final JsVirtualMachine a;
  private final IX5JsContext b;
  private ExceptionHandler c;
  private String d;
  
  public JsContext(Context paramContext)
  {
    this(new JsVirtualMachine(paramContext));
  }
  
  public JsContext(JsVirtualMachine paramJsVirtualMachine)
  {
    if (paramJsVirtualMachine == null) {
      throw new IllegalArgumentException("The virtualMachine value can not be null");
    }
    this.a = paramJsVirtualMachine;
    this.b = this.a.a();
    try
    {
      this.b.setPerContextData(this);
      return;
    }
    catch (AbstractMethodError paramJsVirtualMachine) {}
  }
  
  public static JsContext current()
  {
    return (JsContext)X5JsCore.a();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.b.addJavascriptInterface(paramObject, paramString);
  }
  
  public void destroy()
  {
    this.b.destroy();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback, null);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    this.b.evaluateJavascript(paramString, paramValueCallback, paramURL);
  }
  
  public JsValue evaluateScript(String paramString)
  {
    return evaluateScript(paramString, null);
  }
  
  public JsValue evaluateScript(String paramString, URL paramURL)
  {
    paramString = this.b.evaluateScript(paramString, paramURL);
    if (paramString == null) {
      return null;
    }
    return new JsValue(this, paramString);
  }
  
  public void evaluateScriptAsync(String paramString, final ValueCallback<JsValue> paramValueCallback, URL paramURL)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
        {
          public void a(IX5JsValue paramAnonymousIX5JsValue)
          {
            ValueCallback localValueCallback = paramValueCallback;
            if (paramAnonymousIX5JsValue == null) {}
            for (paramAnonymousIX5JsValue = null;; paramAnonymousIX5JsValue = new JsValue(JsContext.this, paramAnonymousIX5JsValue))
            {
              localValueCallback.onReceiveValue(paramAnonymousIX5JsValue);
              return;
            }
          }
        })
    {
      this.b.evaluateScriptAsync(paramString, paramValueCallback, paramURL);
      return;
    }
  }
  
  public ExceptionHandler exceptionHandler()
  {
    return this.c;
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return this.b.getNativeBuffer(paramInt);
  }
  
  public int getNativeBufferId()
  {
    return this.b.getNativeBufferId();
  }
  
  public String name()
  {
    return this.d;
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.b.removeJavascriptInterface(paramString);
  }
  
  public void setExceptionHandler(ExceptionHandler paramExceptionHandler)
  {
    this.c = paramExceptionHandler;
    if (paramExceptionHandler == null)
    {
      this.b.setExceptionHandler(null);
      return;
    }
    this.b.setExceptionHandler(new ValueCallback()
    {
      public void a(IX5JsError paramAnonymousIX5JsError)
      {
        JsContext.a(JsContext.this).handleException(JsContext.this, new JsError(paramAnonymousIX5JsError));
      }
    });
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
    this.b.setName(paramString);
  }
  
  public int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    return this.b.setNativeBuffer(paramInt, paramArrayOfByte);
  }
  
  public void stealValueFromOtherCtx(String paramString1, JsContext paramJsContext, String paramString2)
  {
    this.b.stealValueFromOtherCtx(paramString1, paramJsContext.b, paramString2);
  }
  
  public JsVirtualMachine virtualMachine()
  {
    return this.a;
  }
  
  public static abstract interface ExceptionHandler
  {
    public abstract void handleException(JsContext paramJsContext, JsError paramJsError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext
 * JD-Core Version:    0.7.0.1
 */