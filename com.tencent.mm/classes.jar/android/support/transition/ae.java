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

public final class ae
{
  private static Transition tB = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> tC = new ThreadLocal();
  private static ArrayList<ViewGroup> tD = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!tD.contains(paramViewGroup)) && (t.as(paramViewGroup)))
    {
      tD.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = tB;
      }
      paramTransition = ((Transition)localObject).co();
      localObject = (ArrayList)cp().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).F(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      localObject = aa.B(paramViewGroup);
      if ((localObject != null) && (aa.B(((aa)localObject).sq) == localObject) && (((aa)localObject).sr != null)) {
        ((aa)localObject).sr.run();
      }
      paramViewGroup.setTag(2131820682, null);
      if ((paramTransition != null) && (paramViewGroup != null))
      {
        paramTransition = new a(paramTransition, paramViewGroup);
        paramViewGroup.addOnAttachStateChangeListener(paramTransition);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
      }
    }
  }
  
  static a<ViewGroup, ArrayList<Transition>> cp()
  {
    WeakReference localWeakReference2 = (WeakReference)tC.get();
    WeakReference localWeakReference1;
    if (localWeakReference2 != null)
    {
      localWeakReference1 = localWeakReference2;
      if (localWeakReference2.get() != null) {}
    }
    else
    {
      localWeakReference1 = new WeakReference(new a());
      tC.set(localWeakReference1);
    }
    return (a)localWeakReference1.get();
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    ViewGroup sq;
    Transition tA;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.tA = paramTransition;
      this.sq = paramViewGroup;
    }
    
    private void cr()
    {
      this.sq.getViewTreeObserver().removeOnPreDrawListener(this);
      this.sq.removeOnAttachStateChangeListener(this);
    }
    
    public final boolean onPreDraw()
    {
      cr();
      if (!ae.cq().remove(this.sq)) {
        return true;
      }
      a locala = ae.cp();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.sq);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.sq, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.tA);
        this.tA.a(new ae.a.1(this, locala));
        this.tA.b(this.sq, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).G(this.sq);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.tA.b(this.sq);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      cr();
      ae.cq().remove(this.sq);
      paramView = (ArrayList)ae.cp().get(this.sq);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).G(this.sq);
        }
      }
      this.tA.v(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.ae
 * JD-Core Version:    0.7.0.1
 */