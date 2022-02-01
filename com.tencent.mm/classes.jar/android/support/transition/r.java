package android.support.transition;

import android.support.v4.e.a;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class r
{
  private static Transition zP = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> zQ = new ThreadLocal();
  static ArrayList<ViewGroup> zR = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!zR.contains(paramViewGroup)) && (t.ay(paramViewGroup)))
    {
      zR.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = zP;
      }
      paramTransition = ((Transition)localObject).dq();
      localObject = (ArrayList)dr().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).J(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      localObject = n.F(paramViewGroup);
      if ((localObject != null) && (n.F(((n)localObject).yH) == localObject) && (((n)localObject).yI != null)) {
        ((n)localObject).yI.run();
      }
      paramViewGroup.setTag(2131306066, null);
      if ((paramTransition != null) && (paramViewGroup != null))
      {
        paramTransition = new a(paramTransition, paramViewGroup);
        paramViewGroup.addOnAttachStateChangeListener(paramTransition);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
      }
    }
  }
  
  static a<ViewGroup, ArrayList<Transition>> dr()
  {
    Object localObject = (WeakReference)zQ.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    zQ.set(localWeakReference);
    return localObject;
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    ViewGroup yH;
    Transition zO;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.zO = paramTransition;
      this.yH = paramViewGroup;
    }
    
    private void ds()
    {
      this.yH.getViewTreeObserver().removeOnPreDrawListener(this);
      this.yH.removeOnAttachStateChangeListener(this);
    }
    
    public final boolean onPreDraw()
    {
      ds();
      if (!r.zR.remove(this.yH)) {
        return true;
      }
      final a locala = r.dr();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.yH);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.yH, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.zO);
        this.zO.a(new q()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            ((ArrayList)locala.get(r.a.this.yH)).remove(paramAnonymousTransition);
          }
        });
        this.zO.b(this.yH, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).K(this.yH);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.zO.a(this.yH);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      ds();
      r.zR.remove(this.yH);
      paramView = (ArrayList)r.dr().get(this.yH);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).K(this.yH);
        }
      }
      this.zO.B(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.r
 * JD-Core Version:    0.7.0.1
 */