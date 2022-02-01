package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class d
  extends l
{
  private static boolean b(Transition paramTransition)
  {
    AppMethodBeat.i(192223);
    if ((!h(paramTransition.ary)) || (!h(paramTransition.arA)) || (!h(paramTransition.arB)))
    {
      AppMethodBeat.o(192223);
      return true;
    }
    AppMethodBeat.o(192223);
    return false;
  }
  
  public final boolean H(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object I(Object paramObject)
  {
    AppMethodBeat.i(192208);
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).nv();
    }
    AppMethodBeat.o(192208);
    return localTransition;
  }
  
  public final Object J(Object paramObject)
  {
    AppMethodBeat.i(192210);
    if (paramObject == null)
    {
      AppMethodBeat.o(192210);
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.c((Transition)paramObject);
    AppMethodBeat.o(192210);
    return localTransitionSet;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(192226);
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
    AppMethodBeat.o(192226);
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    AppMethodBeat.i(192239);
    t.a(paramViewGroup, (Transition)paramObject);
    AppMethodBeat.o(192239);
  }
  
  public final void a(Object paramObject, View paramView)
  {
    AppMethodBeat.i(192217);
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      b(paramView, localRect);
      paramObject.a(new Transition.c()
      {
        public final Rect nk()
        {
          return localRect;
        }
      });
    }
    AppMethodBeat.o(192217);
  }
  
  public final void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(192214);
    paramObject = (TransitionSet)paramObject;
    ArrayList localArrayList = paramObject.arz;
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
    AppMethodBeat.o(192214);
  }
  
  public final void a(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    AppMethodBeat.i(192244);
    ((Transition)paramObject1).a(new Transition.d()
    {
      public final void a(Transition paramAnonymousTransition) {}
      
      public final void ng() {}
      
      public final void nh() {}
      
      public final void nl()
      {
        AppMethodBeat.i(192193);
        if (paramObject2 != null) {
          d.this.b(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          d.this.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          d.this.b(paramObject4, paramArrayList3, null);
        }
        AppMethodBeat.o(192193);
      }
    });
    AppMethodBeat.o(192244);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(192220);
    paramObject = (Transition)paramObject;
    if (paramObject == null)
    {
      AppMethodBeat.o(192220);
      return;
    }
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.asl.size();
      while (i < j)
      {
        a(paramObject.dA(i), paramArrayList);
        i += 1;
      }
      AppMethodBeat.o(192220);
      return;
    }
    if ((!b(paramObject)) && (h(paramObject.arz)))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        paramObject.bF((View)paramArrayList.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(192220);
  }
  
  public final void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    AppMethodBeat.i(192248);
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.arz.clear();
      paramObject.arz.addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
    AppMethodBeat.o(192248);
  }
  
  public final Object b(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(192238);
    Object localObject = null;
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().c(paramObject1).c(paramObject2).dz(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.c(paramObject1);
      }
      paramObject2.c(paramObject3);
      AppMethodBeat.o(192238);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    AppMethodBeat.o(192238);
    return paramObject1;
  }
  
  public final void b(Object paramObject, final Rect paramRect)
  {
    AppMethodBeat.i(192269);
    if (paramObject != null) {
      ((Transition)paramObject).a(new Transition.c()
      {
        public final Rect nk()
        {
          AppMethodBeat.i(192201);
          if ((paramRect == null) || (paramRect.isEmpty()))
          {
            AppMethodBeat.o(192201);
            return null;
          }
          Rect localRect = paramRect;
          AppMethodBeat.o(192201);
          return localRect;
        }
      });
    }
    AppMethodBeat.o(192269);
  }
  
  public final void b(Object paramObject, View paramView)
  {
    AppMethodBeat.i(192263);
    if (paramObject != null) {
      ((Transition)paramObject).bF(paramView);
    }
    AppMethodBeat.o(192263);
  }
  
  public final void b(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(192231);
    ((Transition)paramObject).a(new Transition.d()
    {
      public final void a(Transition paramAnonymousTransition)
      {
        AppMethodBeat.i(192184);
        paramAnonymousTransition.b(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
        AppMethodBeat.o(192184);
      }
      
      public final void ng() {}
      
      public final void nh() {}
      
      public final void nl() {}
    });
    AppMethodBeat.o(192231);
  }
  
  public final void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    AppMethodBeat.i(192261);
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.asl.size();
      while (i < j)
      {
        b(paramObject.dA(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
      AppMethodBeat.o(192261);
      return;
    }
    if (!b(paramObject))
    {
      ArrayList localArrayList = paramObject.arz;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.bF((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.bG((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(192261);
  }
  
  public final void c(Object paramObject, View paramView)
  {
    AppMethodBeat.i(192266);
    if (paramObject != null) {
      ((Transition)paramObject).bG(paramView);
    }
    AppMethodBeat.o(192266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.d
 * JD-Core Version:    0.7.0.1
 */