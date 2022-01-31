package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class f$3
  implements Runnable
{
  f$3(f paramf, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133904);
    Iterator localIterator = this.acu.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      f localf = this.jfS;
      View localView = localv.aku;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      localf.acn.add(localv);
      localView.setAlpha(1.0F);
      localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F).setDuration(localf.ajf).setListener(new f.5(localf, localv, localView, localViewPropertyAnimator)).start();
    }
    this.acu.clear();
    this.jfS.ack.remove(this.acu);
    AppMethodBeat.o(133904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.3
 * JD-Core Version:    0.7.0.1
 */