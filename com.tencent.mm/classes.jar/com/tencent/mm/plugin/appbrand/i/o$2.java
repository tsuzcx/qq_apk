package com.tencent.mm.plugin.appbrand.i;

import android.webkit.ValueCallback;
import java.net.URL;

final class o$2
  implements Runnable
{
  o$2(o paramo, URL paramURL, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    com.tencent.xweb.g localg = o.a(this.gIA);
    URL localURL = this.gIB;
    String str = this.bhZ;
    ValueCallback localValueCallback = this.gIs;
    if (!localg.gIx) {
      localg.xgu.evaluateJavascript(str, localValueCallback, localURL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.o.2
 * JD-Core Version:    0.7.0.1
 */