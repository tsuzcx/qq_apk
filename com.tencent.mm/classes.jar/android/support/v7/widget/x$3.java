package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class x$3
  implements Runnable
{
  x$3(x paramx, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.abJ.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      x localx = this.abH;
      View localView = localv.aie;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      localx.abC.add(localv);
      localViewPropertyAnimator.alpha(1.0F).setDuration(localx.agP).setListener(new x.5(localx, localv, localView, localViewPropertyAnimator)).start();
    }
    this.abJ.clear();
    this.abH.abz.remove(this.abJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.x.3
 * JD-Core Version:    0.7.0.1
 */