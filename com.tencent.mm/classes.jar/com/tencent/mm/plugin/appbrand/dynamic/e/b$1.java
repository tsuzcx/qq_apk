package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView.c;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements WebView.c
{
  public final void onCoreInitFinished()
  {
    y.i("MicroMsg.JSEngineInitializer", "onCoreInitFinished");
    Iterator localIterator = b.Kd().iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)localIterator.next();
      if (locala != null) {
        locala.aaK();
      }
    }
  }
  
  public final void tc()
  {
    y.i("MicroMsg.JSEngineInitializer", "onCoreInitFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.b.1
 * JD-Core Version:    0.7.0.1
 */