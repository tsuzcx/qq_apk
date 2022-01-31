package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.r;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class g
  extends r
{
  private static boolean b(Transition paramTransition)
  {
    return (!h(paramTransition.rQ)) || (!h(paramTransition.rS)) || (!h(paramTransition.rT));
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
    af.a(paramViewGroup, (Transition)paramObject);
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
    ArrayList localArrayList = paramObject.rR;
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
  
  public final void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).a(new Transition.c()
    {
      public final void a(Transition paramAnonymousTransition) {}
      
      public final void bq() {}
      
      public final void br() {}
      
      public final void bv()
      {
        if (paramObject2 != null) {
          g.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          g.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          g.this.b(paramObject4, paramArrayList3, null);
        }
      }
    });
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
        j = paramObject.sE.size();
        while (i < j)
        {
          a(paramObject.W(i), paramArrayList);
          i += 1;
        }
      }
      else if ((!b(paramObject)) && (h(paramObject.rR)))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          paramObject.A((View)paramArrayList.get(i));
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
      paramObject.rR.clear();
      paramObject.rR.addAll(paramArrayList2);
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
      paramObject1 = new TransitionSet().d(paramObject1).d(paramObject2).V(1);
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
      ((Transition)paramObject).A(paramView);
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
      j = paramObject.sE.size();
      while (i < j)
      {
        b(paramObject.W(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!b(paramObject))
    {
      ArrayList localArrayList = paramObject.rR;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.A((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.B((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public final void c(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).B(paramView);
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
      localTransition = ((Transition)paramObject).bA();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.g
 * JD-Core Version:    0.7.0.1
 */