package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.u.q;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
  extends WebView
  implements f, k
{
  private boolean gID = false;
  private final LinkedList<Pair<String, ValueCallback<String>>> gIE = new LinkedList();
  private boolean gIF = false;
  private com.tencent.xweb.p gIG = new com.tencent.xweb.p()
  {
    public final void a(WebView arg1, String paramAnonymousString)
    {
      synchronized (p.a(p.this))
      {
        paramAnonymousString = p.a(p.this).iterator();
        if (paramAnonymousString.hasNext())
        {
          Pair localPair = (Pair)paramAnonymousString.next();
          p.b(p.this, (String)localPair.first, (ValueCallback)localPair.second);
        }
      }
      p.a(p.this).clear();
      p.b(p.this);
    }
    
    public final boolean b(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      return true;
    }
  };
  private Context mContext;
  private ah mHandler;
  private volatile boolean vF = false;
  
  public p(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mHandler = new ah(Looper.getMainLooper());
    getSettings().setJavaScriptEnabled(true);
    getSettings().setUserAgentString(q.a(this.mContext, getSettings().getUserAgentString(), (q.a)com.tencent.luggage.b.e.i(q.a.class)));
    setWebViewClient(this.gIG);
    setWillNotDraw(true);
  }
  
  private void d(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    if (this.vF) {
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        p.a(p.this, paramString, paramValueCallback);
      }
    };
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    this.mHandler.post(paramString);
  }
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    if ((paramObject != null) && (!bk.bl(paramString))) {
      super.addJavascriptInterface(paramObject, paramString);
    }
  }
  
  public final void destroy()
  {
    this.vF = true;
    super.destroy();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (!this.gID)
    {
      this.gID = true;
      loadDataWithBaseURL("https://servicewechat.com/js-engine", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", "utf-8", null);
    }
    synchronized (this.gIE)
    {
      if (!this.gIF)
      {
        this.gIE.add(new Pair(paramString, paramValueCallback));
        return;
      }
      d(paramString, paramValueCallback);
      return;
    }
  }
  
  public final void setJsExceptionHandler(e parame) {}
  
  public final void setJsRuntimeTitle(String paramString)
  {
    evaluateJavascript("document.title=\"" + paramString + "\"", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.p
 * JD-Core Version:    0.7.0.1
 */