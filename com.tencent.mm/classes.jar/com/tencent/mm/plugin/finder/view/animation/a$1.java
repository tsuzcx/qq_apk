package com.tencent.mm.plugin.finder.view.animation;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  implements Runnable
{
  a$1(a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(168649);
    Iterator localIterator = this.bUQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.b)localIterator.next();
      a locala = this.GGj;
      RecyclerView.v localv = ((a.b)localObject).bVi;
      int k = ((a.b)localObject).bVe;
      int i = ((a.b)localObject).bVf;
      int m = ((a.b)localObject).bVg;
      int j = ((a.b)localObject).bVh;
      localObject = localv.caK;
      k = m - k;
      i = j - i;
      if (k != 0) {
        ((View)localObject).animate().translationX(0.0F);
      }
      if (i != 0) {
        ((View)localObject).animate().translationY(0.0F);
      }
      ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
      locala.bUN.add(localv);
      localViewPropertyAnimator.setDuration(locala.bZK).setListener(new a.6(locala, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
    }
    this.bUQ.clear();
    this.GGj.bUK.remove(this.bUQ);
    AppMethodBeat.o(168649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.1
 * JD-Core Version:    0.7.0.1
 */