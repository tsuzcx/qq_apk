package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class t
  extends u
{
  private static boolean a(Transition paramTransition)
  {
    AppMethodBeat.i(193526);
    if ((!Y(paramTransition.getTargetIds())) || (!Y(paramTransition.getTargetNames())) || (!Y(paramTransition.getTargetTypes())))
    {
      AppMethodBeat.o(193526);
      return true;
    }
    AppMethodBeat.o(193526);
    return false;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(193613);
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    AppMethodBeat.o(193613);
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    AppMethodBeat.i(193653);
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
    AppMethodBeat.o(193653);
  }
  
  public final void a(Object paramObject, View paramView)
  {
    AppMethodBeat.i(193587);
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      b(paramView, localRect);
      paramObject.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public final Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          return localRect;
        }
      });
    }
    AppMethodBeat.o(193587);
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(193574);
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.getTargets();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
    AppMethodBeat.o(193574);
  }
  
  public final void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    AppMethodBeat.i(193663);
    ((Transition)paramObject1).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(193854);
        paramAnonymousTransition.removeListener(this);
        AppMethodBeat.o(193854);
      }
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(193848);
        if (paramObject2 != null) {
          t.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          t.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          t.this.b(paramObject4, paramArrayList3, null);
        }
        AppMethodBeat.o(193848);
      }
    });
    AppMethodBeat.o(193663);
  }
  
  public final void a(Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(193679);
    ((Transition)paramObject).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(193855);
        paramRunnable.run();
        AppMethodBeat.o(193855);
      }
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition) {}
    });
    AppMethodBeat.o(193679);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(193604);
    paramObject = (Transition)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(193604);
      return;
    }
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        a(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
      AppMethodBeat.o(193604);
      return;
    }
    if ((!a(paramObject)) && (Y(paramObject.getTargets())))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(193604);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    AppMethodBeat.i(193689);
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
    AppMethodBeat.o(193689);
  }
  
  public final boolean aH(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object aI(Object paramObject)
  {
    AppMethodBeat.i(193543);
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).clone();
    }
    AppMethodBeat.o(193543);
    return localTransition;
  }
  
  public final Object aJ(Object paramObject)
  {
    AppMethodBeat.i(193557);
    if (paramObject == null)
    {
      AppMethodBeat.o(193557);
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    AppMethodBeat.o(193557);
    return localTransitionSet;
  }
  
  public final Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(193642);
    Object localObject = null;
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().addTransition(paramObject1).addTransition(paramObject2).setOrdering(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.addTransition(paramObject1);
      }
      paramObject2.addTransition(paramObject3);
      AppMethodBeat.o(193642);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    AppMethodBeat.o(193642);
    return paramObject1;
  }
  
  public final void b(Object paramObject, final Rect paramRect)
  {
    AppMethodBeat.i(193732);
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public final Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          AppMethodBeat.i(193862);
          if ((paramRect == null) || (paramRect.isEmpty()))
          {
            AppMethodBeat.o(193862);
            return null;
          }
          paramAnonymousTransition = paramRect;
          AppMethodBeat.o(193862);
          return paramAnonymousTransition;
        }
      });
    }
    AppMethodBeat.o(193732);
  }
  
  public final void b(Object paramObject, View paramView)
  {
    AppMethodBeat.i(193714);
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
    AppMethodBeat.o(193714);
  }
  
  public final void b(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(193631);
    ((Transition)paramObject).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(193870);
        paramAnonymousTransition.removeListener(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
        AppMethodBeat.o(193870);
      }
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(193856);
        paramAnonymousTransition.removeListener(this);
        paramAnonymousTransition.addListener(this);
        AppMethodBeat.o(193856);
      }
    });
    AppMethodBeat.o(193631);
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    AppMethodBeat.i(193702);
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        b(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
      AppMethodBeat.o(193702);
      return;
    }
    if (!a(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.addTarget((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(193702);
  }
  
  public final void c(Object paramObject, View paramView)
  {
    AppMethodBeat.i(193722);
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
    AppMethodBeat.o(193722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.t
 * JD-Core Version:    0.7.0.1
 */