package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.n;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class g
  extends n
{
  private static boolean b(Transition paramTransition)
  {
    return (!h(paramTransition.sR)) || (!h(paramTransition.sT)) || (!h(paramTransition.sU));
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.d((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.d((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.d((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    ae.a(paramViewGroup, (Transition)paramObject);
  }
  
  public final void a(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).a(new g.4(this, paramRect));
    }
  }
  
  public final void a(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      b(paramView, localRect);
      paramObject.a(new g.1(this, localRect));
    }
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    ArrayList localArrayList = paramObject.sS;
    localArrayList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a(localArrayList, (View)paramArrayList.get(i));
      i += 1;
    }
    localArrayList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
  }
  
  public final void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).a(new g.3(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int j;
      if ((paramObject instanceof TransitionSet))
      {
        paramObject = (TransitionSet)paramObject;
        j = paramObject.tG.size();
        while (i < j)
        {
          a(paramObject.V(i), paramArrayList);
          i += 1;
        }
      }
      else if ((!b(paramObject)) && (h(paramObject.sS)))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          paramObject.D((View)paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.sS.clear();
      paramObject.sS.addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public final Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().d(paramObject1).d(paramObject2).U(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.d(paramObject1);
      }
      paramObject2.d(paramObject3);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    return paramObject1;
  }
  
  public final void b(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).D(paramView);
    }
  }
  
  public final void b(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).a(new g.2(this, paramView, paramArrayList));
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.tG.size();
      while (i < j)
      {
        b(paramObject.V(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!b(paramObject))
    {
      ArrayList localArrayList = paramObject.sS;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.D((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.E((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public final void c(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).E(paramView);
    }
  }
  
  public final boolean g(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object h(Object paramObject)
  {
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).co();
    }
    return localTransition;
  }
  
  public final Object i(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.d((Transition)paramObject);
    return localTransitionSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.g
 * JD-Core Version:    0.7.0.1
 */