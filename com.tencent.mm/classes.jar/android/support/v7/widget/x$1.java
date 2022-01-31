package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class x$1
  implements Runnable
{
  x$1(x paramx, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.abG.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (x.b)localIterator.next();
      x localx = this.abH;
      RecyclerView.v localv = ((x.b)localObject).abY;
      int k = ((x.b)localObject).abU;
      int i = ((x.b)localObject).abV;
      int m = ((x.b)localObject).abW;
      int j = ((x.b)localObject).abX;
      localObject = localv.aie;
      k = m - k;
      i = j - i;
      if (k != 0) {
        ((View)localObject).animate().translationX(0.0F);
      }
      if (i != 0) {
        ((View)localObject).animate().translationY(0.0F);
      }
      ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
      localx.abD.add(localv);
      localViewPropertyAnimator.setDuration(localx.agR).setListener(new x.6(localx, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
    }
    this.abG.clear();
    this.abH.abA.remove(this.abG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.x.1
 * JD-Core Version:    0.7.0.1
 */