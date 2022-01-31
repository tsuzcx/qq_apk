package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class v$1
  implements Runnable
{
  v$1(v paramv, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.acr.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (v.b)localIterator.next();
      v localv = this.acs;
      RecyclerView.v localv1 = ((v.b)localObject).acJ;
      int k = ((v.b)localObject).acF;
      int i = ((v.b)localObject).acG;
      int m = ((v.b)localObject).acH;
      int j = ((v.b)localObject).acI;
      localObject = localv1.aku;
      k = m - k;
      i = j - i;
      if (k != 0) {
        ((View)localObject).animate().translationX(0.0F);
      }
      if (i != 0) {
        ((View)localObject).animate().translationY(0.0F);
      }
      ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
      localv.aco.add(localv1);
      localViewPropertyAnimator.setDuration(localv.ajh).setListener(new v.6(localv, localv1, k, (View)localObject, i, localViewPropertyAnimator)).start();
    }
    this.acr.clear();
    this.acs.acl.remove(this.acr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.v.1
 * JD-Core Version:    0.7.0.1
 */