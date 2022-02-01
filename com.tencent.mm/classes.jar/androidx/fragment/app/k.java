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

final class k
  extends l
{
  private static boolean a(Transition paramTransition)
  {
    AppMethodBeat.i(213043);
    if ((!h(paramTransition.getTargetIds())) || (!h(paramTransition.getTargetNames())) || (!h(paramTransition.getTargetTypes())))
    {
      AppMethodBeat.o(213043);
      return true;
    }
    AppMethodBeat.o(213043);
    return false;
  }
  
  public final boolean H(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object I(Object paramObject)
  {
    AppMethodBeat.i(213033);
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).clone();
    }
    AppMethodBeat.o(213033);
    return localTransition;
  }
  
  public final Object J(Object paramObject)
  {
    AppMethodBeat.i(213035);
    if (paramObject == null)
    {
      AppMethodBeat.o(213035);
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    AppMethodBeat.o(213035);
    return localTransitionSet;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(213045);
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
    AppMethodBeat.o(213045);
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    AppMethodBeat.i(213050);
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
    AppMethodBeat.o(213050);
  }
  
  public final void a(Object paramObject, View paramView)
  {
    AppMethodBeat.i(213039);
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
    AppMethodBeat.o(213039);
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(213037);
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
    AppMethodBeat.o(213037);
  }
  
  public final void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    AppMethodBeat.i(213052);
    ((Transition)paramObject1).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition) {}
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(213017);
        if (paramObject2 != null) {
          k.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          k.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          k.this.b(paramObject4, paramArrayList3, null);
        }
        AppMethodBeat.o(213017);
      }
    });
    AppMethodBeat.o(213052);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(213041);
    paramObject = (Transition)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(213041);
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
      AppMethodBeat.o(213041);
      return;
    }
    if ((!a(paramObject)) && (h(paramObject.getTargets())))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(213041);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    AppMethodBeat.i(213053);
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
    AppMethodBeat.o(213053);
  }
  
  public final Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(213049);
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
      AppMethodBeat.o(213049);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    AppMethodBeat.o(213049);
    return paramObject1;
  }
  
  public final void b(Object paramObject, final Rect paramRect)
  {
    AppMethodBeat.i(213061);
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public final Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          AppMethodBeat.i(213026);
          if ((paramRect == null) || (paramRect.isEmpty()))
          {
            AppMethodBeat.o(213026);
            return null;
          }
          paramAnonymousTransition = paramRect;
          AppMethodBeat.o(213026);
          return paramAnonymousTransition;
        }
      });
    }
    AppMethodBeat.o(213061);
  }
  
  public final void b(Object paramObject, View paramView)
  {
    AppMethodBeat.i(213056);
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
    AppMethodBeat.o(213056);
  }
  
  public final void b(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(213047);
    ((Transition)paramObject).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(213009);
        paramAnonymousTransition.removeListener(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
        AppMethodBeat.o(213009);
      }
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition) {}
    });
    AppMethodBeat.o(213047);
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    AppMethodBeat.i(213055);
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
      AppMethodBeat.o(213055);
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
    AppMethodBeat.o(213055);
  }
  
  public final void c(Object paramObject, View paramView)
  {
    AppMethodBeat.i(213059);
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
    AppMethodBeat.o(213059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.k
 * JD-Core Version:    0.7.0.1
 */