package com.tencent.luggage.bridge.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.luggage.bridge.s;
import com.tencent.luggage.j.c;
import org.b.a;

public class BridgedAndroidWebViewBase
  extends WebView
  implements s
{
  private static boolean bhY = false;
  
  public BridgedAndroidWebViewBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BridgedAndroidWebViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BridgedAndroidWebViewBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 19) {
      setWebContentsDebuggingEnabled(true);
    }
  }
  
  private boolean aZ(String paramString)
  {
    try
    {
      Object localObject = a.cz(a.cz(this).ahx("mProvider").object).ahx("mWebViewCore").object;
      paramString = Message.obtain(null, 194, paramString);
      a.cz(localObject).y("sendMessage", new Object[] { paramString });
      return true;
    }
    catch (Exception paramString)
    {
      c.e(getClass().getName(), "reflectEvalJS, exception = %s", new Object[] { paramString });
    }
    return false;
  }
  
  public final void aX(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      aY(paramString);
      return;
    }
    post(new BridgedAndroidWebViewBase.1(this, paramString));
  }
  
  public final void aY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      c.e("BridgedAndroidWebViewBase", "Empty script");
    }
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 19)
      {
        super.evaluateJavascript(paramString, null);
        return;
      }
      if (!bhY) {
        break;
      }
    } while (aZ(paramString));
    bhY = false;
    try
    {
      super.loadUrl("javascript:" + paramString);
      return;
    }
    catch (Exception paramString)
    {
      c.i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", new Object[] { paramString });
    }
  }
  
  @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return;
    }
    addJavascriptInterface(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebViewBase
 * JD-Core Version:    0.7.0.1
 */