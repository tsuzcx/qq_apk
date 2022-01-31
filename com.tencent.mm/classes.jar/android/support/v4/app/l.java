package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.e.h;
import android.support.v4.view.t;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class l
{
  private static final int[] wQ = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final n wR;
  private static final n wS;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (m localm = new m();; localm = null)
    {
      wR = localm;
      wS = cF();
      return;
    }
  }
  
  private static a a(a parama, SparseArray<a> paramSparseArray, int paramInt)
  {
    a locala = parama;
    if (parama == null)
    {
      locala = new a();
      paramSparseArray.put(paramInt, locala);
    }
    return locala;
  }
  
  private static n a(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.getExitTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.getReturnTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.getSharedElementReturnTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.getEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getReenterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getSharedElementEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {}
    do
    {
      return null;
      if ((wR != null) && (a(wR, localArrayList))) {
        return wR;
      }
      if ((wS != null) && (a(wS, localArrayList))) {
        return wS;
      }
    } while ((wR == null) && (wS == null));
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static a<String, String> a(int paramInt1, ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    a locala = new a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (b)paramArrayList.get(paramInt3);
      if (((b)localObject).X(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((b)localObject).vw != null)
        {
          int j = ((b)localObject).vw.size();
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int i;
          label95:
          String str1;
          if (bool)
          {
            localArrayList1 = ((b)localObject).vw;
            localArrayList2 = ((b)localObject).vx;
            i = 0;
            if (i >= j) {
              break label192;
            }
            localObject = (String)localArrayList2.get(i);
            str1 = (String)localArrayList1.get(i);
            String str2 = (String)locala.remove(str1);
            if (str2 == null) {
              break label179;
            }
            locala.put(localObject, str2);
          }
          for (;;)
          {
            i += 1;
            break label95;
            localArrayList2 = ((b)localObject).vw;
            localArrayList1 = ((b)localObject).vx;
            break;
            label179:
            locala.put(localObject, str1);
          }
        }
      }
      label192:
      paramInt3 -= 1;
    }
    return locala;
  }
  
  private static a<String, View> a(n paramn, a<String, String> parama, Object paramObject, a parama1)
  {
    if ((parama.isEmpty()) || (paramObject == null))
    {
      parama.clear();
      return null;
    }
    paramObject = parama1.xi;
    a locala = new a();
    paramn.a(locala, paramObject.getView());
    paramn = parama1.xk;
    int i;
    if (parama1.xj)
    {
      paramObject = paramObject.getEnterTransitionCallback();
      paramn = paramn.vx;
      h.a(locala, paramn);
      if (paramObject == null) {
        break label172;
      }
      i = paramn.size() - 1;
      label82:
      if (i < 0) {
        break label182;
      }
      parama1 = (String)paramn.get(i);
      paramObject = (View)locala.get(parama1);
      if (paramObject != null) {
        break label139;
      }
      parama.remove(parama1);
    }
    for (;;)
    {
      i -= 1;
      break label82;
      paramObject = paramObject.getExitTransitionCallback();
      paramn = paramn.vw;
      break;
      label139:
      if (!parama1.equals(t.ai(paramObject)))
      {
        parama1 = (String)parama.remove(parama1);
        parama.put(t.ai(paramObject), parama1);
      }
    }
    label172:
    h.a(parama, locala.keySet());
    label182:
    return locala;
  }
  
  static View a(a<String, View> parama, a parama1, Object paramObject, boolean paramBoolean)
  {
    parama1 = parama1.xh;
    if ((paramObject != null) && (parama != null) && (parama1.vw != null) && (!parama1.vw.isEmpty()))
    {
      if (paramBoolean) {}
      for (parama1 = (String)parama1.vw.get(0);; parama1 = (String)parama1.vx.get(0)) {
        return (View)parama.get(parama1);
      }
    }
    return null;
  }
  
  private static Object a(n paramn, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition()) {
      return paramn.i(paramn.h(paramFragment1));
    }
  }
  
  private static Object a(n paramn, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition()) {
      return paramn.h(paramFragment);
    }
  }
  
  private static Object a(n paramn, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null)
    {
      bool1 = bool2;
      if (paramObject2 != null)
      {
        bool1 = bool2;
        if (paramFragment != null) {
          if (!paramBoolean) {
            break label53;
          }
        }
      }
    }
    label53:
    for (bool1 = paramFragment.getAllowReturnTransitionOverlap(); bool1; bool1 = paramFragment.getAllowEnterTransitionOverlap()) {
      return paramn.a(paramObject2, paramObject1, paramObject3);
    }
    return paramn.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(a<String, String> parama, String paramString)
  {
    int j = parama.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(parama.valueAt(i))) {
        return (String)parama.keyAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  static ArrayList<View> a(n paramn, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramn.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramn.a(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    return localObject;
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, a<String, View> parama)
  {
    int j = 0;
    int i;
    if (paramBoolean)
    {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
      if (paramFragment1 == null) {
        return;
      }
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      if (parama != null) {
        break label85;
      }
      i = 0;
    }
    for (;;)
    {
      if (j >= i) {
        return;
      }
      paramFragment2.add(parama.keyAt(j));
      paramFragment1.add(parama.valueAt(j));
      j += 1;
      continue;
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
      break;
      label85:
      i = parama.size();
    }
  }
  
  static void a(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramFragmentManagerImpl.mCurState <= 0) {}
    SparseArray localSparseArray;
    final Object localObject1;
    do
    {
      return;
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject1 = (b)paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          b((b)localObject1, localSparseArray, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          a((b)localObject1, localSparseArray, paramBoolean);
        }
      }
    } while (localSparseArray.size() == 0);
    final View localView = new View(paramFragmentManagerImpl.mHost.mContext);
    int j = localSparseArray.size();
    int i = 0;
    label117:
    int k;
    final a locala1;
    Object localObject5;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      locala1 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
      localObject5 = (a)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label829;
      }
      if (!paramFragmentManagerImpl.mContainer.onHasView()) {
        break label1385;
      }
    }
    label535:
    label553:
    label682:
    label829:
    label967:
    label1233:
    label1247:
    label1383:
    label1385:
    for (ViewGroup localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(k);; localViewGroup = null)
    {
      final Fragment localFragment1;
      Object localObject11;
      Object localObject6;
      final boolean bool1;
      final boolean bool2;
      Object localObject7;
      final Object localObject8;
      Object localObject9;
      Object localObject10;
      final Fragment localFragment2;
      final Fragment localFragment3;
      final Object localObject2;
      Object localObject3;
      Object localObject4;
      if (localViewGroup != null)
      {
        localFragment1 = ((a)localObject5).xf;
        localObject11 = ((a)localObject5).xi;
        localObject6 = a((Fragment)localObject11, localFragment1);
        if (localObject6 != null)
        {
          bool1 = ((a)localObject5).xg;
          bool2 = ((a)localObject5).xj;
          localObject7 = new ArrayList();
          localObject8 = new ArrayList();
          localObject9 = a((n)localObject6, localFragment1, bool1);
          localObject10 = b((n)localObject6, (Fragment)localObject11, bool2);
          localFragment2 = ((a)localObject5).xf;
          localFragment3 = ((a)localObject5).xi;
          if (localFragment2 != null) {
            localFragment2.getView().setVisibility(0);
          }
          if ((localFragment2 != null) && (localFragment3 != null)) {
            break label535;
          }
          localObject1 = null;
          if ((localObject9 != null) || (localObject1 != null) || (localObject10 != null))
          {
            localObject2 = a((n)localObject6, localObject10, (Fragment)localObject11, (ArrayList)localObject8, localView);
            localObject3 = a((n)localObject6, localObject9, localFragment1, (ArrayList)localObject7, localView);
            a((ArrayList)localObject3, 4);
            localObject4 = a((n)localObject6, localObject9, localObject10, localObject1, localFragment1, bool1);
            if (localObject4 != null)
            {
              if ((localObject11 != null) && (localObject10 != null) && (((Fragment)localObject11).mAdded) && (((Fragment)localObject11).mHidden) && (((Fragment)localObject11).mHiddenChanged))
              {
                ((Fragment)localObject11).setHideReplaced(true);
                ((n)localObject6).b(localObject10, ((Fragment)localObject11).getView(), (ArrayList)localObject2);
                w.a(((Fragment)localObject11).mContainer, new Runnable()
                {
                  public final void run()
                  {
                    l.a(this.rD, 4);
                  }
                });
              }
              localObject5 = n.b((ArrayList)localObject7);
              ((n)localObject6).a(localObject4, localObject9, (ArrayList)localObject3, localObject10, (ArrayList)localObject2, localObject1, (ArrayList)localObject7);
              ((n)localObject6).a(localViewGroup, localObject4);
              ((n)localObject6).a(localViewGroup, (ArrayList)localObject8, (ArrayList)localObject7, (ArrayList)localObject5, locala1);
              a((ArrayList)localObject3, 0);
              ((n)localObject6).a(localObject1, (ArrayList)localObject8, (ArrayList)localObject7);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label117;
        break;
        bool2 = ((a)localObject5).xg;
        final a locala2;
        if (locala1.isEmpty())
        {
          localObject1 = null;
          localObject3 = a((n)localObject6, locala1, localObject1, (a)localObject5);
          locala2 = b((n)localObject6, locala1, localObject1, (a)localObject5);
          if (!locala1.isEmpty()) {
            break label655;
          }
          localObject2 = null;
          if (localObject3 != null) {
            ((a)localObject3).clear();
          }
          localObject1 = localObject2;
          if (locala2 != null)
          {
            locala2.clear();
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          if ((localObject9 != null) || (localObject10 != null) || (localObject1 != null)) {
            break label682;
          }
          localObject1 = null;
          break;
          localObject1 = a((n)localObject6, localFragment2, localFragment3, bool2);
          break label553;
          a((ArrayList)localObject8, (a)localObject3, locala1.keySet());
          a((ArrayList)localObject7, locala2, locala1.values());
        }
        a(localFragment2, localFragment3, bool2, (a)localObject3);
        if (localObject1 != null)
        {
          ((ArrayList)localObject7).add(localView);
          ((n)localObject6).a(localObject1, localView, (ArrayList)localObject8);
          a((n)localObject6, localObject1, localObject10, (a)localObject3, ((a)localObject5).xj, ((a)localObject5).xk);
          localObject4 = new Rect();
          localObject5 = a(locala2, (a)localObject5, localObject9, bool2);
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            ((n)localObject6).a(localObject9, (Rect)localObject4);
            localObject3 = localObject4;
          }
        }
        for (localObject2 = localObject5;; localObject2 = null)
        {
          w.a(localViewGroup, new Runnable()
          {
            public final void run()
            {
              l.a(this.wV, localFragment3, bool2, locala2);
              if (this.wZ != null) {
                n.b(this.wZ, this.rA);
              }
            }
          });
          break;
          localObject3 = null;
        }
        if (paramFragmentManagerImpl.mContainer.onHasView()) {}
        for (localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(k);; localViewGroup = null)
        {
          if (localViewGroup == null) {
            break label1383;
          }
          localObject6 = ((a)localObject5).xf;
          localObject10 = ((a)localObject5).xi;
          localObject7 = a((Fragment)localObject10, (Fragment)localObject6);
          if (localObject7 == null) {
            break;
          }
          bool1 = ((a)localObject5).xg;
          bool2 = ((a)localObject5).xj;
          localObject8 = a((n)localObject7, (Fragment)localObject6, bool1);
          localObject3 = b((n)localObject7, (Fragment)localObject10, bool2);
          localObject11 = new ArrayList();
          localObject9 = new ArrayList();
          localFragment1 = ((a)localObject5).xf;
          localFragment2 = ((a)localObject5).xi;
          if ((localFragment1 == null) || (localFragment2 == null))
          {
            localObject1 = null;
            if ((localObject8 == null) && (localObject1 == null) && (localObject3 == null)) {
              break label1364;
            }
            localObject4 = a((n)localObject7, localObject3, (Fragment)localObject10, (ArrayList)localObject11, localView);
            if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty())) {
              break label1372;
            }
          }
          for (localObject2 = null;; localObject2 = localObject3)
          {
            ((n)localObject7).b(localObject8, localView);
            localObject3 = a((n)localObject7, localObject8, localObject2, localObject1, (Fragment)localObject6, ((a)localObject5).xg);
            if (localObject3 == null) {
              break;
            }
            localObject5 = new ArrayList();
            ((n)localObject7).a(localObject3, localObject8, (ArrayList)localObject5, localObject2, (ArrayList)localObject4, localObject1, (ArrayList)localObject9);
            w.a(localViewGroup, new Runnable()
            {
              public final void run()
              {
                ArrayList localArrayList;
                if (this.rE != null)
                {
                  this.wT.c(this.rE, localView);
                  localArrayList = l.a(this.wT, this.rE, this.wV, this.rI, localView);
                  this.rF.addAll(localArrayList);
                }
                if (this.rD != null)
                {
                  if (localObject2 != null)
                  {
                    localArrayList = new ArrayList();
                    localArrayList.add(localView);
                    this.wT.b(localObject2, this.rD, localArrayList);
                  }
                  this.rD.clear();
                  this.rD.add(localView);
                }
              }
            });
            w.a(localViewGroup, new n.2((n)localObject7, (ArrayList)localObject9, locala1));
            ((n)localObject7).a(localViewGroup, localObject3);
            w.a(localViewGroup, new n.3((n)localObject7, (ArrayList)localObject9, locala1));
            break;
            bool1 = ((a)localObject5).xg;
            if (locala1.isEmpty())
            {
              localObject1 = null;
              localObject2 = a((n)localObject7, locala1, localObject1, (a)localObject5);
              if (!locala1.isEmpty()) {
                break label1233;
              }
              localObject1 = null;
            }
            for (;;)
            {
              if ((localObject8 != null) || (localObject3 != null) || (localObject1 != null)) {
                break label1247;
              }
              localObject1 = null;
              break;
              localObject1 = a((n)localObject7, localFragment1, localFragment2, bool1);
              break label1172;
              ((ArrayList)localObject11).addAll(((a)localObject2).values());
            }
            a(localFragment1, localFragment2, bool1, (a)localObject2);
            if (localObject1 != null)
            {
              localObject4 = new Rect();
              ((n)localObject7).a(localObject1, localView, (ArrayList)localObject11);
              a((n)localObject7, localObject1, localObject3, (a)localObject2, ((a)localObject5).xj, ((a)localObject5).xk);
              localObject2 = localObject4;
              if (localObject8 != null) {
                ((n)localObject7).a(localObject8, (Rect)localObject4);
              }
            }
            for (localObject2 = localObject4;; localObject2 = null)
            {
              w.a(localViewGroup, new Runnable()
              {
                public final void run()
                {
                  Object localObject = l.b(this.wT, locala1, localObject1, this.xc);
                  if (localObject != null)
                  {
                    this.rI.addAll(((a)localObject).values());
                    this.rI.add(localView);
                  }
                  l.a(localFragment1, localFragment2, bool1, (a)localObject);
                  if (localObject1 != null)
                  {
                    this.wT.a(localObject1, this.xd, this.rI);
                    localObject = l.a((a)localObject, this.xc, localObject8, bool1);
                    if (localObject != null) {
                      n.b((View)localObject, this.xe);
                    }
                  }
                }
              });
              break label967;
              break;
            }
          }
        }
      }
    }
  }
  
  private static void a(b paramb, b.a parama, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = parama.fragment;
    if (localFragment == null) {}
    int n;
    do
    {
      return;
      n = localFragment.mContainerId;
    } while (n == 0);
    int i;
    label38:
    int j;
    int k;
    boolean bool;
    if (paramBoolean1)
    {
      i = wQ[parama.vA];
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        k = 0;
        bool = false;
        parama = (a)paramSparseArray.get(n);
        if (bool)
        {
          parama = a(parama, paramSparseArray, n);
          parama.xf = localFragment;
          parama.xg = paramBoolean1;
          parama.xh = paramb;
        }
        break;
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && (i != 0))
      {
        if ((parama != null) && (parama.xi == localFragment)) {
          parama.xi = null;
        }
        FragmentManagerImpl localFragmentManagerImpl = paramb.vh;
        if ((localFragment.mState <= 0) && (localFragmentManagerImpl.mCurState > 0) && (!paramb.vy))
        {
          localFragmentManagerImpl.makeActive(localFragment);
          localFragmentManagerImpl.moveToState(localFragment, 1, 0, 0, false);
        }
      }
      if ((j != 0) && ((parama == null) || (parama.xi == null)))
      {
        parama = a(parama, paramSparseArray, n);
        parama.xi = localFragment;
        parama.xj = paramBoolean1;
        parama.xk = paramb;
      }
      for (paramb = parama; (!paramBoolean2) && (k != 0) && (paramb != null) && (paramb.xf == localFragment); paramb = parama)
      {
        paramb.xf = null;
        return;
        i = parama.vA;
        break label38;
        if (paramBoolean2) {
          if ((localFragment.mHiddenChanged) && (!localFragment.mHidden) && (localFragment.mAdded)) {
            bool = true;
          }
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          bool = false;
          continue;
          bool = localFragment.mHidden;
        }
        if (paramBoolean2) {
          bool = localFragment.mIsNewlyAdded;
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          if ((!localFragment.mAdded) && (!localFragment.mHidden)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (paramBoolean2) {
          if ((localFragment.mHiddenChanged) && (localFragment.mAdded) && (localFragment.mHidden)) {
            i = 1;
          }
        }
        int m;
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.mAdded) && (!localFragment.mHidden)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramBoolean2) {
          if ((!localFragment.mAdded) && (localFragment.mView != null) && (localFragment.mView.getVisibility() == 0) && (localFragment.mPostponedAlpha >= 0.0F)) {
            i = 1;
          }
        }
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.mAdded) && (!localFragment.mHidden)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  private static void a(b paramb, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    int j = paramb.vi.size();
    int i = 0;
    while (i < j)
    {
      a(paramb, (b.a)paramb.vi.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static void a(n paramn, Object paramObject1, Object paramObject2, a<String, View> parama, boolean paramBoolean, b paramb)
  {
    if ((paramb.vw != null) && (!paramb.vw.isEmpty())) {
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (paramb = (String)paramb.vx.get(0);; paramb = (String)paramb.vw.get(0))
    {
      parama = (View)parama.get(paramb);
      paramn.a(paramObject1, parama);
      if (paramObject2 != null) {
        paramn.a(paramObject2, parama);
      }
      return;
    }
  }
  
  static void a(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        ((View)paramArrayList.get(i)).setVisibility(paramInt);
        i -= 1;
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, a<String, View> parama, Collection<String> paramCollection)
  {
    int i = parama.size() - 1;
    while (i >= 0)
    {
      View localView = (View)parama.valueAt(i);
      if (paramCollection.contains(t.ai(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static boolean a(n paramn, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramn.g(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static a<String, View> b(n paramn, a<String, String> parama, Object paramObject, a parama1)
  {
    Fragment localFragment = parama1.xf;
    View localView = localFragment.getView();
    if ((parama.isEmpty()) || (paramObject == null) || (localView == null))
    {
      parama.clear();
      return null;
    }
    a locala = new a();
    paramn.a(locala, localView);
    paramn = parama1.xh;
    if (parama1.xg)
    {
      paramObject = localFragment.getExitTransitionCallback();
      paramn = paramn.vw;
      if (paramn != null)
      {
        h.a(locala, paramn);
        h.a(locala, parama.values());
      }
      if (paramObject == null) {
        break label210;
      }
      i = paramn.size() - 1;
      label108:
      if (i < 0) {
        break label256;
      }
      parama1 = (String)paramn.get(i);
      paramObject = (View)locala.get(parama1);
      if (paramObject != null) {
        break label176;
      }
      paramObject = a(parama, parama1);
      if (paramObject != null) {
        parama.remove(paramObject);
      }
    }
    for (;;)
    {
      i -= 1;
      break label108;
      paramObject = localFragment.getEnterTransitionCallback();
      paramn = paramn.vx;
      break;
      label176:
      if (!parama1.equals(t.ai(paramObject)))
      {
        parama1 = a(parama, parama1);
        if (parama1 != null) {
          parama.put(parama1, t.ai(paramObject));
        }
      }
    }
    label210:
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!locala.containsKey((String)parama.valueAt(i))) {
        parama.removeAt(i);
      }
      i -= 1;
    }
    label256:
    return locala;
  }
  
  private static Object b(n paramn, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition()) {
      return paramn.h(paramFragment);
    }
  }
  
  private static void b(b paramb, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    if (!paramb.vh.mContainer.onHasView()) {}
    for (;;)
    {
      return;
      int i = paramb.vi.size() - 1;
      while (i >= 0)
      {
        a(paramb, (b.a)paramb.vi.get(i), paramSparseArray, true, paramBoolean);
        i -= 1;
      }
    }
  }
  
  private static n cF()
  {
    try
    {
      n localn = (n)Class.forName("android.support.transition.g").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localn;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static final class a
  {
    public Fragment xf;
    public boolean xg;
    public b xh;
    public Fragment xi;
    public boolean xj;
    public b xk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.l
 * JD-Core Version:    0.7.0.1
 */