package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class f$2
  implements Runnable
{
  f$2(f paramf, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133903);
    Iterator localIterator = this.act.iterator();
    if (localIterator.hasNext())
    {
      f.a locala = (f.a)localIterator.next();
      f localf = this.jfS;
      Object localObject1 = locala.acD;
      if (localObject1 == null)
      {
        localObject1 = null;
        label51:
        localObject2 = locala.acE;
        if (localObject2 == null) {
          break label234;
        }
      }
      label234:
      for (Object localObject2 = ((RecyclerView.v)localObject2).aku;; localObject2 = null)
      {
        if (localObject1 != null)
        {
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localf.aji);
          localf.acq.add(locala.acD);
          localViewPropertyAnimator.translationX(locala.acH - locala.acF);
          localViewPropertyAnimator.translationY(locala.acI - locala.acG);
          localViewPropertyAnimator.alpha(0.0F).setListener(new f.7(localf, locala, localViewPropertyAnimator, (View)localObject1)).start();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((View)localObject2).animate();
        localf.acq.add(locala.acE);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localf.aji).alpha(1.0F).setListener(new f.8(localf, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
        break;
        localObject1 = ((RecyclerView.v)localObject1).aku;
        break label51;
      }
    }
    this.act.clear();
    this.jfS.acm.remove(this.act);
    AppMethodBeat.o(133903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.2
 * JD-Core Version:    0.7.0.1
 */