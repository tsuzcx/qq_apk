package android.support.transition;

import android.support.v4.e.a;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class s
{
  private static Transition CN = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> CO = new ThreadLocal();
  static ArrayList<ViewGroup> CQ = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!CQ.contains(paramViewGroup)) && (u.az(paramViewGroup)))
    {
      CQ.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = CN;
      }
      paramTransition = ((Transition)localObject).dP();
      localObject = (ArrayList)dR().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).K(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      localObject = n.G(paramViewGroup);
      if ((localObject != null) && (n.G(((n)localObject).BF) == localObject) && (((n)localObject).BG != null)) {
        ((n)localObject).BG.run();
      }
      paramViewGroup.setTag(2131309395, null);
      if ((paramTransition != null) && (paramViewGroup != null))
      {
        paramTransition = new a(paramTransition, paramViewGroup);
        paramViewGroup.addOnAttachStateChangeListener(paramTransition);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
      }
    }
  }
  
  static a<ViewGroup, ArrayList<Transition>> dR()
  {
    Object localObject = (WeakReference)CO.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    CO.set(localWeakReference);
    return localObject;
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    ViewGroup BF;
    Transition CK;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.CK = paramTransition;
      this.BF = paramViewGroup;
    }
    
    private void dS()
    {
      this.BF.getViewTreeObserver().removeOnPreDrawListener(this);
      this.BF.removeOnAttachStateChangeListener(this);
    }
    
    public final boolean onPreDraw()
    {
      dS();
      if (!s.CQ.remove(this.BF)) {
        return true;
      }
      final a locala = s.dR();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.BF);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.BF, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.CK);
        this.CK.a(new r()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            ((ArrayList)locala.get(s.a.this.BF)).remove(paramAnonymousTransition);
          }
        });
        this.CK.b(this.BF, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).L(this.BF);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.CK.a(this.BF);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      dS();
      s.CQ.remove(this.BF);
      paramView = (ArrayList)s.dR().get(this.BF);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).L(this.BF);
        }
      }
      this.CK.B(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.s
 * JD-Core Version:    0.7.0.1
 */