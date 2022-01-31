package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(51152);
    ViewGroup localViewGroup = (ViewGroup)this.hOM.hOh;
    synchronized (this.hOM.hOA)
    {
      Iterator localIterator = this.hOM.hOA.iterator();
      if (localIterator.hasNext()) {
        localViewGroup.removeView(((a.b)localIterator.next()).hPa);
      }
    }
    this.hOM.hOA.clear();
    AppMethodBeat.o(51152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.4
 * JD-Core Version:    0.7.0.1
 */