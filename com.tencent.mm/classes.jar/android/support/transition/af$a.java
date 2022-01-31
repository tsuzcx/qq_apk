package android.support.transition;

import android.support.v4.f.a;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;

final class af$a
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  ViewGroup rq;
  Transition sy;
  
  af$a(Transition paramTransition, ViewGroup paramViewGroup)
  {
    this.sy = paramTransition;
    this.rq = paramViewGroup;
  }
  
  private void bD()
  {
    this.rq.getViewTreeObserver().removeOnPreDrawListener(this);
    this.rq.removeOnAttachStateChangeListener(this);
  }
  
  public final boolean onPreDraw()
  {
    bD();
    if (!af.bC().remove(this.rq)) {
      return true;
    }
    a locala = af.bB();
    ArrayList localArrayList2 = (ArrayList)locala.get(this.rq);
    ArrayList localArrayList1 = null;
    Object localObject;
    if (localArrayList2 == null)
    {
      localObject = new ArrayList();
      locala.put(this.rq, localObject);
    }
    for (;;)
    {
      ((ArrayList)localObject).add(this.sy);
      this.sy.a(new af.a.1(this, locala));
      this.sy.b(this.rq, false);
      if (localArrayList1 == null) {
        break;
      }
      localObject = localArrayList1.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).D(this.rq);
      }
      localObject = localArrayList2;
      if (localArrayList2.size() > 0)
      {
        localArrayList1 = new ArrayList(localArrayList2);
        localObject = localArrayList2;
      }
    }
    this.sy.c(this.rq);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    bD();
    af.bC().remove(this.rq);
    paramView = (ArrayList)af.bB().get(this.rq);
    if ((paramView != null) && (paramView.size() > 0))
    {
      paramView = paramView.iterator();
      while (paramView.hasNext()) {
        ((Transition)paramView.next()).D(this.rq);
      }
    }
    this.sy.u(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.af.a
 * JD-Core Version:    0.7.0.1
 */