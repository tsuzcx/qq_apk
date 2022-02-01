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
  private static Transition CE = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> CF = new ThreadLocal();
  static ArrayList<ViewGroup> CG = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!CG.contains(paramViewGroup)) && (t.ay(paramViewGroup)))
    {
      CG.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = CE;
      }
      paramTransition = ((Transition)localObject).dM();
      localObject = (ArrayList)dN().get(paramViewGroup);
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
      if ((localObject != null) && (n.F(((n)localObject).By) == localObject) && (((n)localObject).Bz != null)) {
        ((n)localObject).Bz.run();
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
  
  static a<ViewGroup, ArrayList<Transition>> dN()
  {
    Object localObject = (WeakReference)CF.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    CF.set(localWeakReference);
    return localObject;
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    ViewGroup By;
    Transition CD;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.CD = paramTransition;
      this.By = paramViewGroup;
    }
    
    private void dO()
    {
      this.By.getViewTreeObserver().removeOnPreDrawListener(this);
      this.By.removeOnAttachStateChangeListener(this);
    }
    
    public final boolean onPreDraw()
    {
      dO();
      if (!r.CG.remove(this.By)) {
        return true;
      }
      final a locala = r.dN();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.By);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.By, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.CD);
        this.CD.a(new q()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            ((ArrayList)locala.get(r.a.this.By)).remove(paramAnonymousTransition);
          }
        });
        this.CD.b(this.By, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).K(this.By);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.CD.a(this.By);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      dO();
      r.CG.remove(this.By);
      paramView = (ArrayList)r.dN().get(this.By);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).K(this.By);
        }
      }
      this.CD.B(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.r
 * JD-Core Version:    0.7.0.1
 */