package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class v$2
  implements Runnable
{
  v$2(v paramv, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.act.iterator();
    if (localIterator.hasNext())
    {
      v.a locala = (v.a)localIterator.next();
      v localv = this.acs;
      Object localObject1 = locala.acD;
      if (localObject1 == null)
      {
        localObject1 = null;
        label46:
        localObject2 = locala.acE;
        if (localObject2 == null) {
          break label229;
        }
      }
      label229:
      for (Object localObject2 = ((RecyclerView.v)localObject2).aku;; localObject2 = null)
      {
        if (localObject1 != null)
        {
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localv.aji);
          localv.acq.add(locala.acD);
          localViewPropertyAnimator.translationX(locala.acH - locala.acF);
          localViewPropertyAnimator.translationY(locala.acI - locala.acG);
          localViewPropertyAnimator.alpha(0.0F).setListener(new v.7(localv, locala, localViewPropertyAnimator, (View)localObject1)).start();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((View)localObject2).animate();
        localv.acq.add(locala.acE);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localv.aji).alpha(1.0F).setListener(new v.8(localv, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
        break;
        localObject1 = ((RecyclerView.v)localObject1).aku;
        break label46;
      }
    }
    this.act.clear();
    this.acs.acm.remove(this.act);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.v.2
 * JD-Core Version:    0.7.0.1
 */