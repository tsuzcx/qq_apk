package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.n;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class d
  extends n
{
  private static boolean b(Transition paramTransition)
  {
    return (!g(paramTransition.Cf)) || (!g(paramTransition.Ch)) || (!g(paramTransition.Ci));
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.c((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.c((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.c((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    s.a(paramViewGroup, (Transition)paramObject);
  }
  
  public final void a(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).a(new Transition.c()
      {
        public final Rect dJ()
        {
          if ((paramRect == null) || (paramRect.isEmpty())) {
            return null;
          }
          return paramRect;
        }
      });
    }
  }
  
  public final void a(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      a(paramView, localRect);
      paramObject.a(new Transition.c()
      {
        public final Rect dJ()
        {
          return localRect;
        }
      });
    }
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    ArrayList localArrayList = paramObject.Cg;
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
    ((Transition)paramObject1).a(new Transition.d()
    {
      public final void a(Transition paramAnonymousTransition) {}
      
      public final void dF() {}
      
      public final void dG() {}
      
      public final void dK()
      {
        if (paramObject2 != null) {
          d.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          d.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          d.this.b(paramObject4, paramArrayList3, null);
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
        j = paramObject.CT.size();
        while (i < j)
        {
          a(paramObject.ap(i), paramArrayList);
          i += 1;
        }
      }
      else if ((!b(paramObject)) && (g(paramObject.Cg)))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          paramObject.I((View)paramArrayList.get(i));
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
      paramObject.Cg.clear();
      paramObject.Cg.addAll(paramArrayList2);
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
      paramObject1 = new TransitionSet().c(paramObject1).c(paramObject2).ao(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.c(paramObject1);
      }
      paramObject2.c(paramObject3);
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
      ((Transition)paramObject).I(paramView);
    }
  }
  
  public final void b(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).a(new Transition.d()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        paramAnonymousTransition.b(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
      }
      
      public final void dF() {}
      
      public final void dG() {}
      
      public final void dK() {}
    });
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.CT.size();
      while (i < j)
      {
        b(paramObject.ap(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!b(paramObject))
    {
      ArrayList localArrayList = paramObject.Cg;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.I((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.J((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public final void c(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).J(paramView);
    }
  }
  
  public final boolean i(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object j(Object paramObject)
  {
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).dP();
    }
    return localTransition;
  }
  
  public final Object k(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.c((Transition)paramObject);
    return localTransitionSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.d
 * JD-Core Version:    0.7.0.1
 */