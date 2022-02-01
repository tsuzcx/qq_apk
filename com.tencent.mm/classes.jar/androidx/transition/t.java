package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.b.a;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class t
{
  private static Transition asg;
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> ash;
  static ArrayList<ViewGroup> asi;
  
  static
  {
    AppMethodBeat.i(192877);
    asg = new AutoTransition();
    ash = new ThreadLocal();
    asi = new ArrayList();
    AppMethodBeat.o(192877);
  }
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    AppMethodBeat.i(192874);
    if ((!asi.contains(paramViewGroup)) && (w.ah(paramViewGroup)))
    {
      asi.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = asg;
      }
      paramTransition = ((Transition)localObject).nv();
      localObject = (ArrayList)nw().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).bH(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      if ((o)paramViewGroup.getTag(m.a.transition_current_scene) != null)
      {
        AppMethodBeat.o(192874);
        throw null;
      }
      paramViewGroup.setTag(m.a.transition_current_scene, null);
      if ((paramTransition != null) && (paramViewGroup != null))
      {
        paramTransition = new a(paramTransition, paramViewGroup);
        paramViewGroup.addOnAttachStateChangeListener(paramTransition);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
      }
    }
    AppMethodBeat.o(192874);
  }
  
  static a<ViewGroup, ArrayList<Transition>> nw()
  {
    AppMethodBeat.i(192866);
    Object localObject = (WeakReference)ash.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(192866);
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    ash.set(localWeakReference);
    AppMethodBeat.o(192866);
    return localObject;
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    ViewGroup arQ;
    Transition asd;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.asd = paramTransition;
      this.arQ = paramViewGroup;
    }
    
    private void nx()
    {
      AppMethodBeat.i(192839);
      this.arQ.getViewTreeObserver().removeOnPreDrawListener(this);
      this.arQ.removeOnAttachStateChangeListener(this);
      AppMethodBeat.o(192839);
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(192859);
      nx();
      if (!t.asi.remove(this.arQ))
      {
        AppMethodBeat.o(192859);
        return true;
      }
      final a locala = t.nw();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.arQ);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.arQ, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.asd);
        this.asd.a(new s()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            AppMethodBeat.i(192831);
            ((ArrayList)locala.get(t.a.this.arQ)).remove(paramAnonymousTransition);
            AppMethodBeat.o(192831);
          }
        });
        this.asd.b(this.arQ, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).bI(this.arQ);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.asd.c(this.arQ);
      AppMethodBeat.o(192859);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(192847);
      nx();
      t.asi.remove(this.arQ);
      paramView = (ArrayList)t.nw().get(this.arQ);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).bI(this.arQ);
        }
      }
      this.asd.aD(true);
      AppMethodBeat.o(192847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.t
 * JD-Core Version:    0.7.0.1
 */