package com.tencent.mm.plugin.appbrand.i;

import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import java.net.URL;
import java.util.LinkedList;

public final class v
  extends WebView
  implements i, o
{
  private boolean ijp;
  private final LinkedList<Pair<String, ValueCallback<String>>> ijq;
  private boolean ijr;
  private volatile boolean mDestroyed;
  private ak mHandler;
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(117474);
    evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(117474);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(117475);
    evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(117475);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(117472);
    if ((paramObject != null) && (!bo.isNullOrNil(paramString))) {
      super.addJavascriptInterface(paramObject, paramString);
    }
    AppMethodBeat.o(117472);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(117476);
    this.mDestroyed = true;
    super.destroy();
    AppMethodBeat.o(117476);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(117473);
    if (!this.ijp)
    {
      this.ijp = true;
      loadDataWithBaseURL("https://servicewechat.com/js-engine", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", "utf-8", null);
    }
    synchronized (this.ijq)
    {
      if (!this.ijr)
      {
        this.ijq.add(new Pair(paramString, paramValueCallback));
        AppMethodBeat.o(117473);
        return;
      }
      if (this.mDestroyed) {
        break label132;
      }
      paramString = new v.1(this, paramString, paramValueCallback);
      if (Looper.getMainLooper().getThread() == Thread.currentThread())
      {
        paramString.run();
        AppMethodBeat.o(117473);
        return;
      }
    }
    this.mHandler.post(paramString);
    label132:
    AppMethodBeat.o(117473);
  }
  
  public final void setJsExceptionHandler(h paramh) {}
  
  public final void setJsRuntimeTitle(String paramString)
  {
    AppMethodBeat.i(117478);
    evaluateJavascript("document.title=\"" + paramString + "\"", null);
    AppMethodBeat.o(117478);
  }
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    AppMethodBeat.i(117477);
    if (paramClass.isInstance(this))
    {
      AppMethodBeat.o(117477);
      return this;
    }
    AppMethodBeat.o(117477);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.v
 * JD-Core Version:    0.7.0.1
 */