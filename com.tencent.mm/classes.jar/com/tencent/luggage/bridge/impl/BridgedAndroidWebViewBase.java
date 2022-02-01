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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.a.a;

public class BridgedAndroidWebViewBase
  extends WebView
  implements s
{
  private static boolean bWL = false;
  
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
  
  private boolean bG(String paramString)
  {
    AppMethodBeat.i(140358);
    try
    {
      Object localObject = a.gc(a.gc(this).aXB("mProvider").object).aXB("mWebViewCore").object;
      paramString = Message.obtain(null, 194, paramString);
      a.gc(localObject).y("sendMessage", new Object[] { paramString });
      AppMethodBeat.o(140358);
      return true;
    }
    catch (Exception paramString)
    {
      ac.e(getClass().getName(), "reflectEvalJS, exception = %s", new Object[] { paramString });
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
  
  public final void bE(final String paramString)
  {
    AppMethodBeat.i(140356);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      bF(paramString);
      AppMethodBeat.o(140356);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140353);
        BridgedAndroidWebViewBase.this.bF(paramString);
        AppMethodBeat.o(140353);
      }
    });
    AppMethodBeat.o(140356);
  }
  
  public final void bF(String paramString)
  {
    AppMethodBeat.i(140357);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("BridgedAndroidWebViewBase", "Empty script");
      AppMethodBeat.o(140357);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.evaluateJavascript(paramString, null);
      AppMethodBeat.o(140357);
      return;
    }
    if (bWL)
    {
      if (bG(paramString)) {
        break label82;
      }
      bWL = false;
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
      ac.i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", new Object[] { paramString });
      AppMethodBeat.o(140357);
    }
    AppMethodBeat.o(140357);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebViewBase
 * JD-Core Version:    0.7.0.1
 */