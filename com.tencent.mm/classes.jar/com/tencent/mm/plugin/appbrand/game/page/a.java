package com.tencent.mm.plugin.appbrand.game.page;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.z;
import java.net.URL;

public final class a
  implements af
{
  private View gcr;
  private View gcs;
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback) {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public final void agB() {}
  
  public final boolean agC()
  {
    return false;
  }
  
  public final boolean agD()
  {
    return false;
  }
  
  public final void bt(String paramString1, String paramString2) {}
  
  public final void cf(Context paramContext)
  {
    if (this.gcr == null) {
      this.gcr = new View(paramContext);
    }
    if (this.gcs == null) {
      this.gcs = new View(paramContext);
    }
  }
  
  public final void destroy() {}
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {}
  
  public final int getContentHeight()
  {
    return 0;
  }
  
  public final View getContentView()
  {
    return this.gcs;
  }
  
  public final int getHeight()
  {
    return 0;
  }
  
  public final String getUserAgentString()
  {
    return "MiniGame";
  }
  
  public final int getWebScrollY()
  {
    return 0;
  }
  
  public final View getWrapperView()
  {
    return this.gcr;
  }
  
  public final void o(int paramInt, long paramLong) {}
  
  public final void pY() {}
  
  public final void qa() {}
  
  public final void setFullscreenImpl(b paramb) {}
  
  public final void setJsExceptionHandler(e parame) {}
  
  public final void setOnScrollChangedListener(ab paramab) {}
  
  public final void setOnTrimListener(aa paramaa) {}
  
  public final void setTitle(String paramString) {}
  
  public final void setWebViewLayoutListener(z paramz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.a
 * JD-Core Version:    0.7.0.1
 */