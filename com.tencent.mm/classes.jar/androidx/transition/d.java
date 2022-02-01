package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class d
  extends u
{
  private static boolean b(Transition paramTransition)
  {
    AppMethodBeat.i(201578);
    if ((!Y(paramTransition.cgg)) || (!Y(paramTransition.cgj)) || (!Y(paramTransition.cgk)))
    {
      AppMethodBeat.o(201578);
      return true;
    }
    AppMethodBeat.o(201578);
    return false;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(201634);
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
    AppMethodBeat.o(201634);
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    AppMethodBeat.i(201652);
    t.a(paramViewGroup, (Transition)paramObject);
    AppMethodBeat.o(201652);
  }
  
  public final void a(Object paramObject, View paramView)
  {
    AppMethodBeat.i(201617);
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      b(paramView, localRect);
      paramObject.a(new Transition.c()
      {
        public final Rect LN()
        {
          return localRect;
        }
      });
    }
    AppMethodBeat.o(201617);
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(201606);
    paramObject = (TransitionSet)paramObject;
    ArrayList localArrayList = paramObject.cgh;
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
    AppMethodBeat.o(201606);
  }
  
  public final void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    AppMethodBeat.i(201660);
    ((Transition)paramObject1).a(new Transition.d()
    {
      public final void LJ() {}
      
      public final void LK() {}
      
      public final void LO()
      {
        AppMethodBeat.i(201557);
        if (paramObject2 != null) {
          d.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          d.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          d.this.b(paramObject4, paramArrayList3, null);
        }
        AppMethodBeat.o(201557);
      }
      
      public final void a(Transition paramAnonymousTransition) {}
    });
    AppMethodBeat.o(201660);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(201627);
    paramObject = (Transition)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(201627);
      return;
    }
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.cgU.size();
      while (i < j)
      {
        a(paramObject.gK(i), paramArrayList);
        i += 1;
      }
      AppMethodBeat.o(201627);
      return;
    }
    if ((!b(paramObject)) && (Y(paramObject.cgh)))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.bZ((View)paramArrayList.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(201627);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    AppMethodBeat.i(201667);
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.cgh.clear();
      paramObject.cgh.addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
    AppMethodBeat.o(201667);
  }
  
  public final boolean aH(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object aI(Object paramObject)
  {
    AppMethodBeat.i(201589);
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).LY();
    }
    AppMethodBeat.o(201589);
    return localTransition;
  }
  
  public final Object aJ(Object paramObject)
  {
    AppMethodBeat.i(201596);
    if (paramObject == null)
    {
      AppMethodBeat.o(201596);
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.c((Transition)paramObject);
    AppMethodBeat.o(201596);
    return localTransitionSet;
  }
  
  public final Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(201647);
    Object localObject = null;
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().c(paramObject1).c(paramObject2).gJ(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.c(paramObject1);
      }
      paramObject2.c(paramObject3);
      AppMethodBeat.o(201647);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    AppMethodBeat.o(201647);
    return paramObject1;
  }
  
  public final void b(Object paramObject, final Rect paramRect)
  {
    AppMethodBeat.i(201687);
    if (paramObject != null) {
      ((Transition)paramObject).a(new Transition.c()
      {
        public final Rect LN()
        {
          AppMethodBeat.i(201549);
          if ((paramRect == null) || (paramRect.isEmpty()))
          {
            AppMethodBeat.o(201549);
            return null;
          }
          Rect localRect = paramRect;
          AppMethodBeat.o(201549);
          return localRect;
        }
      });
    }
    AppMethodBeat.o(201687);
  }
  
  public final void b(Object paramObject, View paramView)
  {
    AppMethodBeat.i(201677);
    if (paramObject != null) {
      ((Transition)paramObject).bZ(paramView);
    }
    AppMethodBeat.o(201677);
  }
  
  public final void b(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(201642);
    ((Transition)paramObject).a(new Transition.d()
    {
      public final void LJ() {}
      
      public final void LK() {}
      
      public final void LO() {}
      
      public final void a(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(201566);
        paramAnonymousTransition.b(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
        AppMethodBeat.o(201566);
      }
    });
    AppMethodBeat.o(201642);
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    AppMethodBeat.i(201674);
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.cgU.size();
      while (i < j)
      {
        b(paramObject.gK(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
      AppMethodBeat.o(201674);
      return;
    }
    if (!b(paramObject))
    {
      ArrayList localArrayList = paramObject.cgh;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.bZ((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.ca((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(201674);
  }
  
  public final void c(Object paramObject, View paramView)
  {
    AppMethodBeat.i(201681);
    if (paramObject != null) {
      ((Transition)paramObject).ca(paramView);
    }
    AppMethodBeat.o(201681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.d
 * JD-Core Version:    0.7.0.1
 */