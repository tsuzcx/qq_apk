package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.b.a;
import androidx.core.f.f;
import androidx.core.g.ab;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
  extends x
{
  b(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private Map<x.b, Boolean> a(List<c> paramList, final boolean paramBoolean, final x.b paramb1, final x.b paramb2)
  {
    AppMethodBeat.i(193695);
    HashMap localHashMap = new HashMap();
    final Object localObject4 = null;
    Object localObject3 = paramList.iterator();
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      if (!((c)localObject5).Gb())
      {
        localObject1 = ((c)localObject5).aG(((c)localObject5).bBO);
        localObject2 = ((c)localObject5).aG(((c)localObject5).bBQ);
        if ((localObject1 != null) && (localObject2 != null) && (localObject1 != localObject2))
        {
          paramList = new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + ((b)localObject5).bBM.bDv + " returned Transition " + ((c)localObject5).bBO + " which uses a different Transition  type than its shared element transition " + ((c)localObject5).bBQ);
          AppMethodBeat.o(193695);
          throw paramList;
        }
        if (localObject1 != null) {}
        for (;;)
        {
          if (localObject4 != null) {
            break label184;
          }
          localObject4 = localObject1;
          break;
          localObject1 = localObject2;
        }
        label184:
        if ((localObject1 != null) && (localObject4 != localObject1))
        {
          paramList = new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + ((b)localObject5).bBM.bDv + " returned Transition " + ((c)localObject5).bBO + " which uses a different Transition  type than other Fragments.");
          AppMethodBeat.o(193695);
          throw paramList;
        }
      }
    }
    if (localObject4 == null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramb1 = (c)paramList.next();
        localHashMap.put(paramb1.bBM, Boolean.FALSE);
        paramb1.Gc();
      }
      AppMethodBeat.o(193695);
      return localHashMap;
    }
    Object localObject6 = new View(getContainer().getContext());
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    final Rect localRect = new Rect();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a locala = new a();
    Object localObject7 = paramList.iterator();
    int j;
    Object localObject9;
    Object localObject8;
    Object localObject10;
    Object localObject11;
    while (((Iterator)localObject7).hasNext())
    {
      localObject3 = (c)((Iterator)localObject7).next();
      if (((c)localObject3).bBQ != null) {}
      int k;
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (paramb1 == null) || (paramb2 == null)) {
          break label1938;
        }
        localObject5 = localObject4.aJ(localObject4.aI(((c)localObject3).bBQ));
        localObject9 = paramb2.bDv.getSharedElementSourceNames();
        localObject1 = paramb1.bDv.getSharedElementSourceNames();
        localObject3 = paramb1.bDv.getSharedElementTargetNames();
        j = 0;
        while (j < ((ArrayList)localObject3).size())
        {
          k = ((ArrayList)localObject9).indexOf(((ArrayList)localObject3).get(j));
          if (k != -1) {
            ((ArrayList)localObject9).set(k, ((ArrayList)localObject1).get(j));
          }
          j += 1;
        }
      }
      localObject8 = paramb2.bDv.getSharedElementTargetNames();
      if (!paramBoolean) {
        localObject3 = paramb1.bDv.getExitTransitionCallback();
      }
      for (localObject1 = paramb2.bDv.getEnterTransitionCallback();; localObject1 = paramb2.bDv.getExitTransitionCallback())
      {
        k = ((ArrayList)localObject9).size();
        j = 0;
        while (j < k)
        {
          locala.put((String)((ArrayList)localObject9).get(j), (String)((ArrayList)localObject8).get(j));
          j += 1;
        }
        localObject3 = paramb1.bDv.getEnterTransitionCallback();
      }
      localObject10 = new a();
      a((Map)localObject10, paramb1.bDv.mView);
      ((a)localObject10).retainAll((Collection)localObject9);
      if (localObject3 != null)
      {
        j = ((ArrayList)localObject9).size() - 1;
        if (j >= 0)
        {
          localObject11 = (String)((ArrayList)localObject9).get(j);
          localObject3 = (View)((a)localObject10).get(localObject11);
          if (localObject3 == null) {
            locala.remove(localObject11);
          }
          for (;;)
          {
            j -= 1;
            break;
            if (!((String)localObject11).equals(z.ai((View)localObject3)))
            {
              localObject11 = (String)locala.remove(localObject11);
              locala.put(z.ai((View)localObject3), localObject11);
            }
          }
        }
      }
      else
      {
        locala.retainAll(((a)localObject10).keySet());
      }
      localObject3 = new a();
      a((Map)localObject3, paramb2.bDv.mView);
      ((a)localObject3).retainAll((Collection)localObject8);
      ((a)localObject3).retainAll(locala.values());
      if (localObject1 != null)
      {
        j = ((ArrayList)localObject8).size() - 1;
        if (j >= 0)
        {
          localObject11 = (String)((ArrayList)localObject8).get(j);
          localObject1 = (View)((a)localObject3).get(localObject11);
          if (localObject1 == null)
          {
            localObject1 = s.a(locala, (String)localObject11);
            if (localObject1 != null) {
              locala.remove(localObject1);
            }
          }
          for (;;)
          {
            j -= 1;
            break;
            if (!((String)localObject11).equals(z.ai((View)localObject1)))
            {
              localObject11 = s.a(locala, (String)localObject11);
              if (localObject11 != null) {
                locala.put(localObject11, z.ai((View)localObject1));
              }
            }
          }
        }
      }
      else
      {
        s.a(locala, (a)localObject3);
      }
      a((a)localObject10, locala.keySet());
      a((a)localObject3, locala.values());
      if (locala.isEmpty())
      {
        localObject1 = null;
        localArrayList1.clear();
        localArrayList2.clear();
      }
      else
      {
        s.a(paramb2.bDv, paramb1.bDv, paramBoolean, (a)localObject10);
        androidx.core.g.u.a(getContainer(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193404);
            s.a(paramb2.bDv, paramb1.bDv, paramBoolean, this.bBD);
            AppMethodBeat.o(193404);
          }
        });
        localObject1 = ((a)localObject10).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(localArrayList1, (View)((Iterator)localObject1).next());
        }
        if (((ArrayList)localObject9).isEmpty()) {
          break label1931;
        }
        localObject1 = (View)((a)localObject10).get((String)((ArrayList)localObject9).get(0));
        localObject4.a(localObject5, (View)localObject1);
        label1120:
        localObject2 = ((a)localObject3).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          a(localArrayList2, (View)((Iterator)localObject2).next());
        }
        if (((ArrayList)localObject8).isEmpty()) {
          break label1941;
        }
        localObject2 = (View)((a)localObject3).get((String)((ArrayList)localObject8).get(0));
        if (localObject2 == null) {
          break label1941;
        }
        androidx.core.g.u.a(getContainer(), new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193407);
            u.b(this.bBF, localRect);
            AppMethodBeat.o(193407);
          }
        });
        i = 1;
      }
    }
    label1928:
    label1931:
    label1938:
    label1941:
    for (;;)
    {
      localObject4.a(localObject5, (View)localObject6, localArrayList1);
      localObject4.a(localObject5, null, null, null, null, localObject5, localArrayList2);
      localHashMap.put(paramb1, Boolean.TRUE);
      localHashMap.put(paramb2, Boolean.TRUE);
      localObject2 = localObject1;
      localObject1 = localObject5;
      for (;;)
      {
        break;
        localObject7 = new ArrayList();
        localObject3 = null;
        localObject8 = paramList.iterator();
        localObject5 = null;
        while (((Iterator)localObject8).hasNext())
        {
          localObject9 = (c)((Iterator)localObject8).next();
          if (((c)localObject9).Gb())
          {
            localHashMap.put(((b)localObject9).bBM, Boolean.FALSE);
            ((c)localObject9).Gc();
          }
          else
          {
            localObject10 = localObject4.aI(((c)localObject9).bBO);
            localObject11 = ((b)localObject9).bBM;
            if ((localObject1 != null) && ((localObject11 == paramb1) || (localObject11 == paramb2))) {}
            for (j = 1;; j = 0)
            {
              if (localObject10 != null) {
                break label1434;
              }
              if (j != 0) {
                break label1928;
              }
              localHashMap.put(localObject11, Boolean.FALSE);
              ((c)localObject9).Gc();
              break;
            }
            label1434:
            final ArrayList localArrayList3 = new ArrayList();
            a(localArrayList3, ((x.b)localObject11).bDv.mView);
            if (j != 0)
            {
              if (localObject11 == paramb1) {
                localArrayList3.removeAll(localArrayList1);
              }
            }
            else
            {
              label1476:
              if (!localArrayList3.isEmpty()) {
                break label1573;
              }
              localObject4.b(localObject10, (View)localObject6);
              label1493:
              if (((x.b)localObject11).bEM != x.b.b.bEX) {
                break label1646;
              }
              ((ArrayList)localObject7).addAll(localArrayList3);
              if (i != 0) {
                localObject4.b(localObject10, localRect);
              }
            }
            for (;;)
            {
              localHashMap.put(localObject11, Boolean.TRUE);
              if (!((c)localObject9).bBP) {
                break label1658;
              }
              localObject5 = localObject4.a(localObject5, localObject10, null);
              break;
              localArrayList3.removeAll(localArrayList2);
              break label1476;
              label1573:
              localObject4.a(localObject10, localArrayList3);
              localObject4.a(localObject10, localObject10, localArrayList3, null, null, null, null);
              if (((x.b)localObject11).bEM != x.b.b.bEY) {
                break label1493;
              }
              localObject4.b(localObject10, ((x.b)localObject11).bDv.mView, localArrayList3);
              androidx.core.g.u.a(getContainer(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193415);
                  s.b(localArrayList3, 4);
                  AppMethodBeat.o(193415);
                }
              });
              break label1493;
              label1646:
              localObject4.a(localObject10, (View)localObject2);
            }
            label1658:
            localObject3 = localObject4.a(localObject3, localObject10, null);
          }
        }
        for (;;)
        {
          break;
          localObject2 = localObject4.b(localObject5, localObject3, localObject1);
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject3 = (c)paramList.next();
            if (!((c)localObject3).Gb())
            {
              localObject5 = ((c)localObject3).bBO;
              localObject6 = ((b)localObject3).bBM;
              if ((localObject1 != null) && ((localObject6 == paramb1) || (localObject6 == paramb2))) {}
              for (i = 1;; i = 0)
              {
                if ((localObject5 == null) && (i == 0)) {
                  break label1824;
                }
                if (z.au(getContainer())) {
                  break label1826;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                  new StringBuilder("SpecialEffectsController: Container ").append(getContainer()).append(" has not been laid out. Completing operation ").append(localObject6);
                }
                ((c)localObject3).Gc();
                break;
              }
              label1824:
              continue;
              label1826:
              localObject4.a(localObject2, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193627);
                  this.bBI.Gc();
                  AppMethodBeat.o(193627);
                }
              });
            }
          }
          if (!z.au(getContainer()))
          {
            AppMethodBeat.o(193695);
            return localHashMap;
          }
          s.b((ArrayList)localObject7, 4);
          paramList = u.d(localArrayList2);
          localObject4.a(getContainer(), localObject2);
          localObject4.a(getContainer(), localArrayList1, localArrayList2, paramList, locala);
          s.b((ArrayList)localObject7, 0);
          localObject4.a(localObject1, localArrayList1, localArrayList2);
          AppMethodBeat.o(193695);
          return localHashMap;
        }
        localObject1 = localObject2;
        break label1120;
      }
    }
  }
  
  private static void a(a<String, View> parama, Collection<String> paramCollection)
  {
    AppMethodBeat.i(193707);
    parama = parama.entrySet().iterator();
    while (parama.hasNext()) {
      if (!paramCollection.contains(z.ai((View)((Map.Entry)parama.next()).getValue()))) {
        parama.remove();
      }
    }
    AppMethodBeat.o(193707);
  }
  
  static void a(x.b paramb)
  {
    AppMethodBeat.i(193741);
    View localView = paramb.bDv.mView;
    paramb.bEM.bc(localView);
    AppMethodBeat.o(193741);
  }
  
  private void a(ArrayList<View> paramArrayList, View paramView)
  {
    AppMethodBeat.i(193720);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (ab.d(paramView))
      {
        paramArrayList.add(paramView);
        AppMethodBeat.o(193720);
        return;
      }
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramView.getChildAt(i);
        if (localView.getVisibility() == 0) {
          a(paramArrayList, localView);
        }
        i += 1;
      }
      AppMethodBeat.o(193720);
      return;
    }
    if (!paramArrayList.contains(paramView)) {
      paramArrayList.add(paramView);
    }
    AppMethodBeat.o(193720);
  }
  
  private void a(List<a> paramList, final List<x.b> paramList1, boolean paramBoolean, Map<x.b, Boolean> paramMap)
  {
    AppMethodBeat.i(193645);
    final ViewGroup localViewGroup = getContainer();
    Context localContext = localViewGroup.getContext();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (a)paramList.next();
      if (((a)localObject2).Gb())
      {
        ((a)localObject2).Gc();
      }
      else
      {
        Object localObject3 = ((a)localObject2).ak(localContext);
        if (localObject3 == null)
        {
          ((a)localObject2).Gc();
        }
        else
        {
          localObject3 = ((c.a)localObject3).bCA;
          if (localObject3 == null)
          {
            ((ArrayList)localObject1).add(localObject2);
          }
          else
          {
            final x.b localb = ((b)localObject2).bBM;
            Object localObject4 = localb.bDv;
            if (Boolean.TRUE.equals(paramMap.get(localb)))
            {
              if (FragmentManager.isLoggingEnabled(2)) {
                new StringBuilder("Ignoring Animator set on ").append(localObject4).append(" as this Fragment was involved in a Transition.");
              }
              ((a)localObject2).Gc();
            }
            else
            {
              if (localb.bEM == x.b.b.bEY) {}
              for (final boolean bool = true;; bool = false)
              {
                if (bool) {
                  paramList1.remove(localb);
                }
                localObject4 = ((Fragment)localObject4).mView;
                localViewGroup.startViewTransition((View)localObject4);
                ((Animator)localObject3).addListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    AppMethodBeat.i(193383);
                    localViewGroup.endViewTransition(this.bBv);
                    if (bool) {
                      localb.bEM.bc(this.bBv);
                    }
                    this.bBx.Gc();
                    AppMethodBeat.o(193383);
                  }
                });
                ((Animator)localObject3).setTarget(localObject4);
                ((Animator)localObject3).start();
                ((b)localObject2).bBN.a(new androidx.core.c.b.a()
                {
                  public final void onCancel()
                  {
                    AppMethodBeat.i(193378);
                    this.bBy.end();
                    AppMethodBeat.o(193378);
                  }
                });
                i = 1;
                break;
              }
            }
          }
        }
      }
    }
    paramList = ((ArrayList)localObject1).iterator();
    while (paramList.hasNext())
    {
      paramList1 = (a)paramList.next();
      paramMap = paramList1.bBM;
      localObject1 = paramMap.bDv;
      if (paramBoolean)
      {
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("Ignoring Animation set on ").append(localObject1).append(" as Animations cannot run alongside Transitions.");
        }
        paramList1.Gc();
      }
      else if (i != 0)
      {
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("Ignoring Animation set on ").append(localObject1).append(" as Animations cannot run alongside Animators.");
        }
        paramList1.Gc();
      }
      else
      {
        localObject1 = ((Fragment)localObject1).mView;
        localObject2 = (Animation)f.checkNotNull(((c.a)f.checkNotNull(paramList1.ak(localContext))).bCz);
        if (paramMap.bEM != x.b.b.bEW)
        {
          ((View)localObject1).startAnimation((Animation)localObject2);
          paramList1.Gc();
        }
        for (;;)
        {
          paramList1.bBN.a(new androidx.core.c.b.a()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(193394);
              this.bBv.clearAnimation();
              localViewGroup.endViewTransition(this.bBv);
              paramList1.Gc();
              AppMethodBeat.o(193394);
            }
          });
          break;
          localViewGroup.startViewTransition((View)localObject1);
          paramMap = new c.b((Animation)localObject2, localViewGroup, (View)localObject1);
          paramMap.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(193396);
              localViewGroup.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193475);
                  b.5.this.val$container.endViewTransition(b.5.this.bBv);
                  b.5.this.bBx.Gc();
                  AppMethodBeat.o(193475);
                }
              });
              AppMethodBeat.o(193396);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          ((View)localObject1).startAnimation(paramMap);
        }
      }
    }
    AppMethodBeat.o(193645);
  }
  
  private void a(Map<String, View> paramMap, View paramView)
  {
    AppMethodBeat.i(193731);
    Object localObject = z.ai(paramView);
    if (localObject != null) {
      paramMap.put(localObject, paramView);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramView.getChildAt(i);
        if (((View)localObject).getVisibility() == 0) {
          a(paramMap, (View)localObject);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(193731);
  }
  
  final void c(List<x.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(193762);
    Object localObject4 = paramList.iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    if (((Iterator)localObject4).hasNext())
    {
      localObject3 = (x.b)((Iterator)localObject4).next();
      localObject5 = x.b.b.bb(((x.b)localObject3).bDv.mView);
      switch (2.bBu[localObject3.bEM.ordinal()])
      {
      }
      for (;;)
      {
        break;
        if ((localObject5 == x.b.b.bEX) && (localObject2 == null))
        {
          localObject2 = localObject3;
          break;
          if (localObject5 != x.b.b.bEX) {
            localObject1 = localObject3;
          }
        }
      }
    }
    localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject3 = new ArrayList(paramList);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      final x.b localb = (x.b)paramList.next();
      androidx.core.c.b localb1 = new androidx.core.c.b();
      localb.a(localb1);
      ((List)localObject4).add(new a(localb, localb1, paramBoolean));
      localb1 = new androidx.core.c.b();
      localb.a(localb1);
      boolean bool;
      if (paramBoolean) {
        if (localb == localObject2) {
          bool = true;
        }
      }
      for (;;)
      {
        ((List)localObject5).add(new c(localb, localb1, paramBoolean, bool));
        localb.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193374);
            if (this.bBr.contains(localb))
            {
              this.bBr.remove(localb);
              b.a(localb);
            }
            AppMethodBeat.o(193374);
          }
        });
        break;
        bool = false;
        continue;
        if (localb == localObject1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    paramList = a((List)localObject5, paramBoolean, localObject2, localObject1);
    a((List)localObject4, (List)localObject3, paramList.containsValue(Boolean.TRUE), paramList);
    paramList = ((List)localObject3).iterator();
    while (paramList.hasNext()) {
      a((x.b)paramList.next());
    }
    ((List)localObject3).clear();
    AppMethodBeat.o(193762);
  }
  
  static final class a
    extends b.b
  {
    private boolean bBJ;
    private boolean bBK = false;
    private c.a bBL;
    
    a(x.b paramb, androidx.core.c.b paramb1, boolean paramBoolean)
    {
      super(paramb1);
      this.bBJ = paramBoolean;
    }
    
    final c.a ak(Context paramContext)
    {
      AppMethodBeat.i(193921);
      if (this.bBK)
      {
        paramContext = this.bBL;
        AppMethodBeat.o(193921);
        return paramContext;
      }
      Fragment localFragment = this.bBM.bDv;
      if (this.bBM.bEM == x.b.b.bEX) {}
      for (boolean bool = true;; bool = false)
      {
        this.bBL = c.a(paramContext, localFragment, bool, this.bBJ);
        this.bBK = true;
        paramContext = this.bBL;
        AppMethodBeat.o(193921);
        return paramContext;
      }
    }
  }
  
  static class b
  {
    final x.b bBM;
    final androidx.core.c.b bBN;
    
    b(x.b paramb, androidx.core.c.b paramb1)
    {
      this.bBM = paramb;
      this.bBN = paramb1;
    }
    
    final boolean Gb()
    {
      AppMethodBeat.i(193919);
      x.b.b localb1 = x.b.b.bb(this.bBM.bDv.mView);
      x.b.b localb2 = this.bBM.bEM;
      if ((localb1 == localb2) || ((localb1 != x.b.b.bEX) && (localb2 != x.b.b.bEX)))
      {
        AppMethodBeat.o(193919);
        return true;
      }
      AppMethodBeat.o(193919);
      return false;
    }
    
    final void Gc()
    {
      AppMethodBeat.i(193930);
      this.bBM.b(this.bBN);
      AppMethodBeat.o(193930);
    }
  }
  
  static final class c
    extends b.b
  {
    final Object bBO;
    final boolean bBP;
    final Object bBQ;
    
    c(x.b paramb, androidx.core.c.b paramb1, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramb1);
      AppMethodBeat.i(193905);
      if (paramb.bEM == x.b.b.bEX)
      {
        if (paramBoolean1)
        {
          paramb1 = paramb.bDv.getReenterTransition();
          this.bBO = paramb1;
          if (!paramBoolean1) {
            break label94;
          }
        }
        label94:
        for (boolean bool = paramb.bDv.getAllowReturnTransitionOverlap();; bool = paramb.bDv.getAllowEnterTransitionOverlap())
        {
          this.bBP = bool;
          if (!paramBoolean2) {
            break label159;
          }
          if (!paramBoolean1) {
            break label142;
          }
          this.bBQ = paramb.bDv.getSharedElementReturnTransition();
          AppMethodBeat.o(193905);
          return;
          paramb1 = paramb.bDv.getEnterTransition();
          break;
        }
      }
      if (paramBoolean1) {}
      for (paramb1 = paramb.bDv.getReturnTransition();; paramb1 = paramb.bDv.getExitTransition())
      {
        this.bBO = paramb1;
        this.bBP = true;
        break;
      }
      label142:
      this.bBQ = paramb.bDv.getSharedElementEnterTransition();
      AppMethodBeat.o(193905);
      return;
      label159:
      this.bBQ = null;
      AppMethodBeat.o(193905);
    }
    
    final u aG(Object paramObject)
    {
      AppMethodBeat.i(193915);
      if (paramObject == null)
      {
        AppMethodBeat.o(193915);
        return null;
      }
      if ((s.bDN != null) && (s.bDN.aH(paramObject)))
      {
        paramObject = s.bDN;
        AppMethodBeat.o(193915);
        return paramObject;
      }
      if ((s.bDO != null) && (s.bDO.aH(paramObject)))
      {
        paramObject = s.bDO;
        AppMethodBeat.o(193915);
        return paramObject;
      }
      paramObject = new IllegalArgumentException("Transition " + paramObject + " for fragment " + this.bBM.bDv + " is not a valid framework Transition or AndroidX Transition");
      AppMethodBeat.o(193915);
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.b
 * JD-Core Version:    0.7.0.1
 */