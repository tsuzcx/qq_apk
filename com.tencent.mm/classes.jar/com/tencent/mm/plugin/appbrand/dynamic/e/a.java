package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.plugin.appbrand.i.m;

public final class a
  implements d
{
  public com.tencent.mm.plugin.appbrand.i.a fWr = new com.tencent.mm.plugin.appbrand.i.a();
  
  public a(Object paramObject)
  {
    this.fWr.addJavascriptInterface(paramObject, "WeixinJSCore");
  }
  
  public final void cleanup()
  {
    if (this.fWr != null) {
      this.fWr.destroy();
    }
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.fWr != null) {
      this.fWr.evaluateJavascript(paramString, paramValueCallback);
    }
  }
  
  public final void pause()
  {
    if (this.fWr != null) {
      ((m)this.fWr.I(m.class)).pause();
    }
  }
  
  public final void resume()
  {
    if (this.fWr != null) {
      ((m)this.fWr.I(m.class)).resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.a
 * JD-Core Version:    0.7.0.1
 */