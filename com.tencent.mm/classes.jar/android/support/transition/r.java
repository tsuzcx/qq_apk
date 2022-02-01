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
  private static Transition AN = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> AO = new ThreadLocal();
  static ArrayList<ViewGroup> AP = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!AP.contains(paramViewGroup)) && (t.ay(paramViewGroup)))
    {
      AP.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = AN;
      }
      paramTransition = ((Transition)localObject).dx();
      localObject = (ArrayList)dy().get(paramViewGroup);
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
      if ((localObject != null) && (n.F(((n)localObject).zH) == localObject) && (((n)localObject).zI != null)) {
        ((n)localObject).zI.run();
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
  
  static a<ViewGroup, ArrayList<Transition>> dy()
  {
    Object localObject = (WeakReference)AO.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    AO.set(localWeakReference);
    return localObject;
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    Transition AM;
    ViewGroup zH;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.AM = paramTransition;
      this.zH = paramViewGroup;
    }
    
    private void dz()
    {
      this.zH.getViewTreeObserver().removeOnPreDrawListener(this);
      this.zH.removeOnAttachStateChangeListener(this);
    }
    
    public final boolean onPreDraw()
    {
      dz();
      if (!r.AP.remove(this.zH)) {
        return true;
      }
      final a locala = r.dy();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.zH);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.zH, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.AM);
        this.AM.a(new q()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            ((ArrayList)locala.get(r.a.this.zH)).remove(paramAnonymousTransition);
          }
        });
        this.AM.b(this.zH, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).K(this.zH);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.AM.a(this.zH);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      dz();
      r.AP.remove(this.zH);
      paramView = (ArrayList)r.dy().get(this.zH);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).K(this.zH);
        }
      }
      this.AM.B(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.r
 * JD-Core Version:    0.7.0.1
 */