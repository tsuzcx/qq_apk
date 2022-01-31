package android.support.v7.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

final class x$2
  implements Runnable
{
  x$2(x paramx, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.abI.iterator();
    if (localIterator.hasNext())
    {
      x.a locala = (x.a)localIterator.next();
      x localx = this.abH;
      Object localObject1 = locala.abS;
      if (localObject1 == null)
      {
        localObject1 = null;
        label46:
        localObject2 = locala.abT;
        if (localObject2 == null) {
          break label229;
        }
      }
      label229:
      for (Object localObject2 = ((RecyclerView.v)localObject2).aie;; localObject2 = null)
      {
        if (localObject1 != null)
        {
          ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localx.agS);
          localx.abF.add(locala.abS);
          localViewPropertyAnimator.translationX(locala.abW - locala.abU);
          localViewPropertyAnimator.translationY(locala.abX - locala.abV);
          localViewPropertyAnimator.alpha(0.0F).setListener(new x.7(localx, locala, localViewPropertyAnimator, (View)localObject1)).start();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((View)localObject2).animate();
        localx.abF.add(locala.abT);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localx.agS).alpha(1.0F).setListener(new x.8(localx, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
        break;
        localObject1 = ((RecyclerView.v)localObject1).aie;
        break label46;
      }
    }
    this.abI.clear();
    this.abH.abB.remove(this.abI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.x.2
 * JD-Core Version:    0.7.0.1
 */