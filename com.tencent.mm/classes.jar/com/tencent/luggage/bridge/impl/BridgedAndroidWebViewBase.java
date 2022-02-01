package com.tencent.luggage.bridge.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.luggage.bridge.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.a.a;

public class BridgedAndroidWebViewBase
  extends WebView
  implements s
{
  private static boolean csU = false;
  
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
    AppMethodBeat.i(140354);
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 19) {
      setWebContentsDebuggingEnabled(true);
    }
    AppMethodBeat.o(140354);
  }
  
  private boolean cQ(String paramString)
  {
    AppMethodBeat.i(140358);
    try
    {
      Object localObject = a.gG(a.gG(this).bvr("mProvider").object).bvr("mWebViewCore").object;
      paramString = Message.obtain(null, 194, paramString);
      a.gG(localObject).u("sendMessage", new Object[] { paramString });
      AppMethodBeat.o(140358);
      return true;
    }
    catch (Exception paramString)
    {
      Log.e(getClass().getName(), "reflectEvalJS, exception = %s", new Object[] { paramString });
      AppMethodBeat.o(140358);
    }
    return false;
  }
  
  @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(140355);
    if (Build.VERSION.SDK_INT < 17)
    {
      AppMethodBeat.o(140355);
      return;
    }
    addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(140355);
  }
  
  public final void cP(String paramString)
  {
    AppMethodBeat.i(140357);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("BridgedAndroidWebViewBase", "Empty script");
      AppMethodBeat.o(140357);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.evaluateJavascript(paramString, null);
      AppMethodBeat.o(140357);
      return;
    }
    if (csU)
    {
      if (cQ(paramString)) {
        break label82;
      }
      csU = false;
    }
    try
    {
      super.loadUrl("javascript:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(140357);
      return;
    }
    catch (Exception paramString)
    {
      label82:
      Log.i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", new Object[] { paramString });
      AppMethodBeat.o(140357);
    }
    AppMethodBeat.o(140357);
    return;
  }
  
  public void evaluateJavascript(final String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(221176);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      cP(paramString);
      AppMethodBeat.o(221176);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140353);
        BridgedAndroidWebViewBase.this.cP(paramString);
        AppMethodBeat.o(140353);
      }
    });
    AppMethodBeat.o(221176);
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(221175);
    String str = getSettings().getUserAgentString();
    AppMethodBeat.o(221175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebViewBase
 * JD-Core Version:    0.7.0.1
 */