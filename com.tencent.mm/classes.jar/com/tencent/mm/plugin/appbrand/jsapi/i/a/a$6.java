package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(146465);
    ViewGroup localViewGroup = (ViewGroup)this.kQN.container;
    synchronized (this.kQN.kQq)
    {
      Iterator localIterator = this.kQN.kQq.iterator();
      if (localIterator.hasNext()) {
        localViewGroup.removeView(((a.b)localIterator.next()).kRt);
      }
    }
    this.kQN.kQq.clear();
    AppMethodBeat.o(146465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.a.6
 * JD-Core Version:    0.7.0.1
 */