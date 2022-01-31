package android.support.transition;

import android.support.v4.f.a;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class af
{
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> sA = new ThreadLocal();
  private static ArrayList<ViewGroup> sB = new ArrayList();
  private static Transition sz = new AutoTransition();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!sB.contains(paramViewGroup)) && (q.al(paramViewGroup)))
    {
      sB.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = sz;
      }
      paramTransition = ((Transition)localObject).bA();
      localObject = (ArrayList)bB().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).C(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      localObject = ab.y(paramViewGroup);
      if ((localObject != null) && (ab.y(((ab)localObject).rq) == localObject) && (((ab)localObject).rr != null)) {
        ((ab)localObject).rr.run();
      }
      paramViewGroup.setTag(z.a.transition_current_scene, null);
      if ((paramTransition != null) && (paramViewGroup != null))
      {
        paramTransition = new af.a(paramTransition, paramViewGroup);
        paramViewGroup.addOnAttachStateChangeListener(paramTransition);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
      }
    }
  }
  
  static a<ViewGroup, ArrayList<Transition>> bB()
  {
    WeakReference localWeakReference2 = (WeakReference)sA.get();
    WeakReference localWeakReference1;
    if (localWeakReference2 != null)
    {
      localWeakReference1 = localWeakReference2;
      if (localWeakReference2.get() != null) {}
    }
    else
    {
      localWeakReference1 = new WeakReference(new a());
      sA.set(localWeakReference1);
    }
    return (a)localWeakReference1.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.af
 * JD-Core Version:    0.7.0.1
 */