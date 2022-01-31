package com.tencent.mm.plugin.appbrand.i;

import android.webkit.ValueCallback;

final class o$1
  implements Runnable
{
  o$1(o paramo, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    com.tencent.xweb.g localg = o.a(this.gIA);
    String str = this.bhZ;
    ValueCallback localValueCallback = this.gIs;
    if (!localg.gIx) {
      localg.xgu.evaluateJavascript(str, localValueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.o.1
 * JD-Core Version:    0.7.0.1
 */