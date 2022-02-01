package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.b.a;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class t
{
  private static Transition cgP;
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> cgQ;
  static ArrayList<ViewGroup> cgR;
  
  static
  {
    AppMethodBeat.i(201527);
    cgP = new AutoTransition();
    cgQ = new ThreadLocal();
    cgR = new ArrayList();
    AppMethodBeat.o(201527);
  }
  
  static a<ViewGroup, ArrayList<Transition>> LZ()
  {
    AppMethodBeat.i(201506);
    Object localObject = (WeakReference)cgQ.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(201506);
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    cgQ.set(localWeakReference);
    AppMethodBeat.o(201506);
    return localObject;
  }
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    AppMethodBeat.i(201518);
    if ((!cgR.contains(paramViewGroup)) && (z.au(paramViewGroup)))
    {
      cgR.add(paramViewGroup);
      Object localObject = paramTransition;
      if (paramTransition == null) {
        localObject = cgP;
      }
      paramTransition = ((Transition)localObject).LY();
      localObject = (ArrayList)LZ().get(paramViewGroup);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).cb(paramViewGroup);
        }
      }
      if (paramTransition != null) {
        paramTransition.b(paramViewGroup, true);
      }
      if ((o)paramViewGroup.getTag(m.a.transition_current_scene) != null)
      {
        AppMethodBeat.o(201518);
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
    AppMethodBeat.o(201518);
  }
  
  static final class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    Transition cgM;
    ViewGroup cgz;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.cgM = paramTransition;
      this.cgz = paramViewGroup;
    }
    
    private void Ma()
    {
      AppMethodBeat.i(201376);
      this.cgz.getViewTreeObserver().removeOnPreDrawListener(this);
      this.cgz.removeOnAttachStateChangeListener(this);
      AppMethodBeat.o(201376);
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(201401);
      Ma();
      if (!t.cgR.remove(this.cgz))
      {
        AppMethodBeat.o(201401);
        return true;
      }
      final a locala = t.LZ();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.cgz);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.cgz, localObject);
      }
      for (;;)
      {
        ((ArrayList)localObject).add(this.cgM);
        this.cgM.a(new s()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            AppMethodBeat.i(201323);
            ((ArrayList)locala.get(t.a.this.cgz)).remove(paramAnonymousTransition);
            AppMethodBeat.o(201323);
          }
        });
        this.cgM.b(this.cgz, false);
        if (localArrayList1 == null) {
          break;
        }
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).cc(this.cgz);
        }
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      this.cgM.f(this.cgz);
      AppMethodBeat.o(201401);
      return true;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(201394);
      Ma();
      t.cgR.remove(this.cgz);
      paramView = (ArrayList)t.LZ().get(this.cgz);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).cc(this.cgz);
        }
      }
      this.cgM.bl(true);
      AppMethodBeat.o(201394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.t
 * JD-Core Version:    0.7.0.1
 */