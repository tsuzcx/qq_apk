package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class v$3
  implements Runnable
{
  v$3(v paramv, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.acu.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      v localv1 = this.acs;
      View localView = localv.aku;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      localv1.acn.add(localv);
      localViewPropertyAnimator.alpha(1.0F).setDuration(localv1.ajf).setListener(new v.5(localv1, localv, localView, localViewPropertyAnimator)).start();
    }
    this.acu.clear();
    this.acs.ack.remove(this.acu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.v.3
 * JD-Core Version:    0.7.0.1
 */