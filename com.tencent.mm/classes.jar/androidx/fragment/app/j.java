package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.f;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class j
{
  private static final int[] Wr;
  private static final l Ws;
  private static final l Wt;
  
  static
  {
    AppMethodBeat.i(212994);
    Wr = new int[] { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
    if (Build.VERSION.SDK_INT >= 21) {}
    for (k localk = new k();; localk = null)
    {
      Ws = localk;
      Wt = iF();
      AppMethodBeat.o(212994);
      return;
    }
  }
  
  static View a(androidx.b.a<String, View> parama, a parama1, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(212974);
    parama1 = parama1.WO;
    if ((paramObject != null) && (parama != null) && (parama1.Vd != null) && (!parama1.Vd.isEmpty()))
    {
      if (paramBoolean) {}
      for (parama1 = (String)parama1.Vd.get(0);; parama1 = (String)parama1.Ve.get(0))
      {
        parama = (View)parama.get(parama1);
        AppMethodBeat.o(212974);
        return parama;
      }
    }
    AppMethodBeat.o(212974);
    return null;
  }
  
  private static androidx.b.a<String, String> a(int paramInt1, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212949);
    androidx.b.a locala = new androidx.b.a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (a)paramArrayList.get(paramInt3);
      if (((a)localObject).bY(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((a)localObject).Vd != null)
        {
          int j = ((a)localObject).Vd.size();
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int i;
          label100:
          String str1;
          if (bool)
          {
            localArrayList1 = ((a)localObject).Vd;
            localArrayList2 = ((a)localObject).Ve;
            i = 0;
            if (i >= j) {
              break label197;
            }
            localObject = (String)localArrayList2.get(i);
            str1 = (String)localArrayList1.get(i);
            String str2 = (String)locala.remove(str1);
            if (str2 == null) {
              break label184;
            }
            locala.put(localObject, str2);
          }
          for (;;)
          {
            i += 1;
            break label100;
            localArrayList2 = ((a)localObject).Vd;
            localArrayList1 = ((a)localObject).Ve;
            break;
            label184:
            locala.put(localObject, str1);
          }
        }
      }
      label197:
      paramInt3 -= 1;
    }
    AppMethodBeat.o(212949);
    return locala;
  }
  
  private static androidx.b.a<String, View> a(l paraml, androidx.b.a<String, String> parama, Object paramObject, a parama1)
  {
    AppMethodBeat.i(212966);
    if ((parama.isEmpty()) || (paramObject == null))
    {
      parama.clear();
      AppMethodBeat.o(212966);
      return null;
    }
    paramObject = parama1.WP;
    androidx.b.a locala = new androidx.b.a();
    paraml.a(locala, paramObject.getView());
    paraml = parama1.WR;
    int i;
    if (parama1.WQ)
    {
      paramObject = paramObject.getEnterTransitionCallback();
      paraml = paraml.Ve;
      f.a(locala, paraml);
      if (paramObject == null) {
        break label182;
      }
      i = paraml.size() - 1;
      label92:
      if (i < 0) {
        break label192;
      }
      parama1 = (String)paraml.get(i);
      paramObject = (View)locala.get(parama1);
      if (paramObject != null) {
        break label149;
      }
      parama.remove(parama1);
    }
    for (;;)
    {
      i -= 1;
      break label92;
      paramObject = paramObject.getExitTransitionCallback();
      paraml = paraml.Vd;
      break;
      label149:
      if (!parama1.equals(w.W(paramObject)))
      {
        parama1 = (String)parama.remove(parama1);
        parama.put(w.W(paramObject), parama1);
      }
    }
    label182:
    f.a(parama, locala.keySet());
    label192:
    AppMethodBeat.o(212966);
    return locala;
  }
  
  private static a a(a parama, SparseArray<a> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(212993);
    a locala = parama;
    if (parama == null)
    {
      locala = new a();
      paramSparseArray.put(paramInt, locala);
    }
    AppMethodBeat.o(212993);
    return locala;
  }
  
  private static l a(Fragment paramFragment1, Fragment paramFragment2)
  {
    AppMethodBeat.i(212954);
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
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(212954);
      return null;
    }
    if ((Ws != null) && (a(Ws, localArrayList)))
    {
      paramFragment1 = Ws;
      AppMethodBeat.o(212954);
      return paramFragment1;
    }
    if ((Wt != null) && (a(Wt, localArrayList)))
    {
      paramFragment1 = Wt;
      AppMethodBeat.o(212954);
      return paramFragment1;
    }
    if ((Ws != null) || (Wt != null))
    {
      paramFragment1 = new IllegalArgumentException("Invalid Transition types");
      AppMethodBeat.o(212954);
      throw paramFragment1;
    }
    AppMethodBeat.o(212954);
    return null;
  }
  
  private static Object a(l paraml, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    AppMethodBeat.i(212959);
    if ((paramFragment1 == null) || (paramFragment2 == null))
    {
      AppMethodBeat.o(212959);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition())
    {
      paraml = paraml.J(paraml.I(paramFragment1));
      AppMethodBeat.o(212959);
      return paraml;
    }
  }
  
  private static Object a(l paraml, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212962);
    if (paramFragment == null)
    {
      AppMethodBeat.o(212962);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition())
    {
      paraml = paraml.I(paramFragment);
      AppMethodBeat.o(212962);
      return paraml;
    }
  }
  
  private static Object a(l paraml, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212984);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null)
    {
      bool1 = bool2;
      if (paramObject2 != null)
      {
        bool1 = bool2;
        if (paramFragment != null)
        {
          if (!paramBoolean) {
            break label65;
          }
          bool1 = paramFragment.getAllowReturnTransitionOverlap();
        }
      }
    }
    if (bool1) {}
    for (paraml = paraml.a(paramObject2, paramObject1, paramObject3);; paraml = paraml.b(paramObject2, paramObject1, paramObject3))
    {
      AppMethodBeat.o(212984);
      return paraml;
      label65:
      bool1 = paramFragment.getAllowEnterTransitionOverlap();
      break;
    }
  }
  
  private static String a(androidx.b.a<String, String> parama, String paramString)
  {
    AppMethodBeat.i(212972);
    int j = parama.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(parama.aM(i)))
      {
        parama = (String)parama.aO(i);
        AppMethodBeat.o(212972);
        return parama;
      }
      i += 1;
    }
    AppMethodBeat.o(212972);
    return null;
  }
  
  static ArrayList<View> a(l paraml, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    AppMethodBeat.i(212982);
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paraml.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paraml.a(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    AppMethodBeat.o(212982);
    return localObject;
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, androidx.b.a<String, View> parama)
  {
    int j = 0;
    AppMethodBeat.i(212981);
    int i;
    if (paramBoolean)
    {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
      if (paramFragment1 == null) {
        break label100;
      }
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      if (parama != null) {
        break label91;
      }
      i = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label100;
      }
      paramFragment2.add(parama.aO(j));
      paramFragment1.add(parama.aM(j));
      j += 1;
      continue;
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
      break;
      label91:
      i = parama.size();
    }
    label100:
    AppMethodBeat.o(212981);
  }
  
  static void a(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(212945);
    if (paramFragmentManagerImpl.mCurState <= 0)
    {
      AppMethodBeat.o(212945);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    final Object localObject1;
    if (i < paramInt2)
    {
      localObject1 = (a)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        b((a)localObject1, localSparseArray, paramBoolean);
      }
      for (;;)
      {
        i += 1;
        break;
        a((a)localObject1, localSparseArray, paramBoolean);
      }
    }
    final View localView;
    int k;
    final androidx.b.a locala1;
    Object localObject5;
    if (localSparseArray.size() != 0)
    {
      localView = new View(paramFragmentManagerImpl.mHost.mContext);
      int j = localSparseArray.size();
      i = 0;
      if (i < j)
      {
        k = localSparseArray.keyAt(i);
        locala1 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        localObject5 = (a)localSparseArray.valueAt(i);
        if (paramBoolean) {
          if (!paramFragmentManagerImpl.mContainer.it()) {
            break label1404;
          }
        }
      }
    }
    label547:
    label565:
    label694:
    label979:
    label1245:
    label1259:
    label1391:
    label1402:
    label1404:
    for (ViewGroup localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.bZ(k);; localViewGroup = null)
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
        localFragment1 = ((a)localObject5).WM;
        localObject11 = ((a)localObject5).WP;
        localObject6 = a((Fragment)localObject11, localFragment1);
        if (localObject6 != null)
        {
          bool1 = ((a)localObject5).WN;
          bool2 = ((a)localObject5).WQ;
          localObject7 = new ArrayList();
          localObject8 = new ArrayList();
          localObject9 = a((l)localObject6, localFragment1, bool1);
          localObject10 = b((l)localObject6, (Fragment)localObject11, bool2);
          localFragment2 = ((a)localObject5).WM;
          localFragment3 = ((a)localObject5).WP;
          if (localFragment2 != null) {
            localFragment2.getView().setVisibility(0);
          }
          if ((localFragment2 != null) && (localFragment3 != null)) {
            break label547;
          }
          localObject1 = null;
          if ((localObject9 != null) || (localObject1 != null) || (localObject10 != null))
          {
            localObject2 = a((l)localObject6, localObject10, (Fragment)localObject11, (ArrayList)localObject8, localView);
            localObject3 = a((l)localObject6, localObject9, localFragment1, (ArrayList)localObject7, localView);
            b((ArrayList)localObject3, 4);
            localObject4 = a((l)localObject6, localObject9, localObject10, localObject1, localFragment1, bool1);
            if (localObject4 != null)
            {
              if ((localObject11 != null) && (localObject10 != null) && (((Fragment)localObject11).mAdded) && (((Fragment)localObject11).mHidden) && (((Fragment)localObject11).mHiddenChanged))
              {
                ((Fragment)localObject11).setHideReplaced(true);
                ((l)localObject6).b(localObject10, ((Fragment)localObject11).getView(), (ArrayList)localObject2);
                m.b(((Fragment)localObject11).mContainer, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(212904);
                    j.b(this.Wu, 4);
                    AppMethodBeat.o(212904);
                  }
                });
              }
              localObject5 = l.c((ArrayList)localObject7);
              ((l)localObject6).a(localObject4, localObject9, (ArrayList)localObject3, localObject10, (ArrayList)localObject2, localObject1, (ArrayList)localObject7);
              ((l)localObject6).a(localViewGroup, localObject4);
              ((l)localObject6).a(localViewGroup, (ArrayList)localObject8, (ArrayList)localObject7, (ArrayList)localObject5, locala1);
              b((ArrayList)localObject3, 0);
              ((l)localObject6).a(localObject1, (ArrayList)localObject8, (ArrayList)localObject7);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        bool2 = ((a)localObject5).WN;
        final androidx.b.a locala2;
        if (locala1.isEmpty())
        {
          localObject1 = null;
          localObject3 = a((l)localObject6, locala1, localObject1, (a)localObject5);
          locala2 = b((l)localObject6, locala1, localObject1, (a)localObject5);
          if (!locala1.isEmpty()) {
            break label667;
          }
          localObject2 = null;
          if (localObject3 != null) {
            ((androidx.b.a)localObject3).clear();
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
            break label694;
          }
          localObject1 = null;
          break;
          localObject1 = a((l)localObject6, localFragment2, localFragment3, bool2);
          break label565;
          a((ArrayList)localObject8, (androidx.b.a)localObject3, locala1.keySet());
          a((ArrayList)localObject7, locala2, locala1.values());
        }
        a(localFragment2, localFragment3, bool2, (androidx.b.a)localObject3);
        if (localObject1 != null)
        {
          ((ArrayList)localObject7).add(localView);
          ((l)localObject6).a(localObject1, localView, (ArrayList)localObject8);
          a((l)localObject6, localObject1, localObject10, (androidx.b.a)localObject3, ((a)localObject5).WQ, ((a)localObject5).WR);
          localObject4 = new Rect();
          localObject5 = a(locala2, (a)localObject5, localObject9, bool2);
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            ((l)localObject6).b(localObject9, (Rect)localObject4);
            localObject3 = localObject4;
          }
        }
        for (localObject2 = localObject5;; localObject2 = null)
        {
          m.b(localViewGroup, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212925);
              j.a(this.Wy, localFragment3, bool2, locala2);
              if (this.WF != null) {
                l.b(this.WF, this.WG);
              }
              AppMethodBeat.o(212925);
            }
          });
          break;
          localObject3 = null;
        }
        if (paramFragmentManagerImpl.mContainer.it()) {}
        for (localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.bZ(k);; localViewGroup = null)
        {
          if (localViewGroup == null) {
            break label1402;
          }
          localObject6 = ((a)localObject5).WM;
          localObject10 = ((a)localObject5).WP;
          localObject7 = a((Fragment)localObject10, (Fragment)localObject6);
          if (localObject7 == null) {
            break;
          }
          bool1 = ((a)localObject5).WN;
          bool2 = ((a)localObject5).WQ;
          localObject8 = a((l)localObject7, (Fragment)localObject6, bool1);
          localObject3 = b((l)localObject7, (Fragment)localObject10, bool2);
          localObject11 = new ArrayList();
          localObject9 = new ArrayList();
          localFragment1 = ((a)localObject5).WM;
          localFragment2 = ((a)localObject5).WP;
          if ((localFragment1 == null) || (localFragment2 == null))
          {
            localObject1 = null;
            if ((localObject8 == null) && (localObject1 == null) && (localObject3 == null)) {
              break label1376;
            }
            localObject4 = a((l)localObject7, localObject3, (Fragment)localObject10, (ArrayList)localObject11, localView);
            if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty())) {
              break label1391;
            }
          }
          for (localObject2 = null;; localObject2 = localObject3)
          {
            ((l)localObject7).b(localObject8, localView);
            localObject3 = a((l)localObject7, localObject8, localObject2, localObject1, (Fragment)localObject6, ((a)localObject5).WN);
            if (localObject3 == null) {
              break;
            }
            localObject5 = new ArrayList();
            ((l)localObject7).a(localObject3, localObject8, (ArrayList)localObject5, localObject2, (ArrayList)localObject4, localObject1, (ArrayList)localObject9);
            m.b(localViewGroup, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(212915);
                ArrayList localArrayList;
                if (this.Wv != null)
                {
                  this.Ww.c(this.Wv, localView);
                  localArrayList = j.a(this.Ww, this.Wv, this.Wy, this.Wz, localView);
                  this.WA.addAll(localArrayList);
                }
                if (this.Wu != null)
                {
                  if (localObject2 != null)
                  {
                    localArrayList = new ArrayList();
                    localArrayList.add(localView);
                    this.Ww.b(localObject2, this.Wu, localArrayList);
                  }
                  this.Wu.clear();
                  this.Wu.add(localView);
                }
                AppMethodBeat.o(212915);
              }
            });
            m.b(localViewGroup, new l.2((l)localObject7, (ArrayList)localObject9, locala1));
            ((l)localObject7).a(localViewGroup, localObject3);
            m.b(localViewGroup, new l.3((l)localObject7, (ArrayList)localObject9, locala1));
            break;
            bool1 = ((a)localObject5).WN;
            if (locala1.isEmpty())
            {
              localObject1 = null;
              localObject2 = a((l)localObject7, locala1, localObject1, (a)localObject5);
              if (!locala1.isEmpty()) {
                break label1245;
              }
              localObject1 = null;
            }
            for (;;)
            {
              if ((localObject8 != null) || (localObject3 != null) || (localObject1 != null)) {
                break label1259;
              }
              localObject1 = null;
              break;
              localObject1 = a((l)localObject7, localFragment1, localFragment2, bool1);
              break label1184;
              ((ArrayList)localObject11).addAll(((androidx.b.a)localObject2).values());
            }
            a(localFragment1, localFragment2, bool1, (androidx.b.a)localObject2);
            if (localObject1 != null)
            {
              localObject4 = new Rect();
              ((l)localObject7).a(localObject1, localView, (ArrayList)localObject11);
              a((l)localObject7, localObject1, localObject3, (androidx.b.a)localObject2, ((a)localObject5).WQ, ((a)localObject5).WR);
              localObject2 = localObject4;
              if (localObject8 != null) {
                ((l)localObject7).b(localObject8, (Rect)localObject4);
              }
            }
            for (localObject2 = localObject4;; localObject2 = null)
            {
              m.b(localViewGroup, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(212933);
                  Object localObject = j.b(this.Ww, locala1, localObject1, this.WJ);
                  if (localObject != null)
                  {
                    this.Wz.addAll(((androidx.b.a)localObject).values());
                    this.Wz.add(localView);
                  }
                  j.a(localFragment1, localFragment2, bool1, (androidx.b.a)localObject);
                  if (localObject1 != null)
                  {
                    this.Ww.a(localObject1, this.WK, this.Wz);
                    localObject = j.a((androidx.b.a)localObject, this.WJ, localObject8, bool1);
                    if (localObject != null) {
                      l.b((View)localObject, this.WL);
                    }
                  }
                  AppMethodBeat.o(212933);
                }
              });
              break label979;
              break;
            }
            AppMethodBeat.o(212945);
            return;
          }
        }
      }
    }
  }
  
  private static void a(a parama, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(212985);
    int j = parama.UO.size();
    int i = 0;
    while (i < j)
    {
      a(parama, (a.a)parama.UO.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(212985);
  }
  
  private static void a(a parama, a.a parama1, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(212989);
    Fragment localFragment = parama1.fragment;
    if (localFragment == null)
    {
      AppMethodBeat.o(212989);
      return;
    }
    int m = localFragment.mContainerId;
    if (m == 0)
    {
      AppMethodBeat.o(212989);
      return;
    }
    int i;
    boolean bool;
    int k;
    int j;
    if (paramBoolean1)
    {
      i = Wr[parama1.Vh];
      bool = false;
      k = 0;
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        parama1 = (a)paramSparseArray.get(m);
        if (bool)
        {
          parama1 = a(parama1, paramSparseArray, m);
          parama1.WM = localFragment;
          parama1.WN = paramBoolean1;
          parama1.WO = parama;
        }
        break;
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && (k != 0))
      {
        if ((parama1 != null) && (parama1.WP == localFragment)) {
          parama1.WP = null;
        }
        FragmentManagerImpl localFragmentManagerImpl = parama.UN;
        if ((localFragment.mState <= 0) && (localFragmentManagerImpl.mCurState > 0) && (!parama.Vf))
        {
          localFragmentManagerImpl.makeActive(localFragment);
          localFragmentManagerImpl.moveToState(localFragment, 1, 0, 0, false);
        }
      }
      if ((i != 0) && ((parama1 == null) || (parama1.WP == null)))
      {
        parama1 = a(parama1, paramSparseArray, m);
        parama1.WP = localFragment;
        parama1.WQ = paramBoolean1;
        parama1.WR = parama;
      }
      for (parama = parama1;; parama = parama1)
      {
        if ((!paramBoolean2) && (j != 0) && (parama != null) && (parama.WM == localFragment)) {
          parama.WM = null;
        }
        AppMethodBeat.o(212989);
        return;
        i = parama1.Vh;
        break;
        if (paramBoolean2) {
          if ((localFragment.mHiddenChanged) && (!localFragment.mHidden) && (localFragment.mAdded)) {
            bool = true;
          }
        }
        for (;;)
        {
          k = 1;
          i = 0;
          j = 0;
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
          k = 1;
          i = 0;
          j = 0;
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
        for (;;)
        {
          j = 1;
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
          j = 1;
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
  
  private static void a(l paraml, Object paramObject1, Object paramObject2, androidx.b.a<String, View> parama, boolean paramBoolean, a parama1)
  {
    AppMethodBeat.i(212978);
    if ((parama1.Vd != null) && (!parama1.Vd.isEmpty())) {
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (parama1 = (String)parama1.Ve.get(0);; parama1 = (String)parama1.Vd.get(0))
    {
      parama = (View)parama.get(parama1);
      paraml.a(paramObject1, parama);
      if (paramObject2 != null) {
        paraml.a(paramObject2, parama);
      }
      AppMethodBeat.o(212978);
      return;
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, androidx.b.a<String, View> parama, Collection<String> paramCollection)
  {
    AppMethodBeat.i(212964);
    int i = parama.size() - 1;
    while (i >= 0)
    {
      View localView = (View)parama.aM(i);
      if (paramCollection.contains(w.W(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
    AppMethodBeat.o(212964);
  }
  
  private static boolean a(l paraml, List<Object> paramList)
  {
    AppMethodBeat.i(212957);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paraml.H(paramList.get(i)))
      {
        AppMethodBeat.o(212957);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(212957);
    return true;
  }
  
  static androidx.b.a<String, View> b(l paraml, androidx.b.a<String, String> parama, Object paramObject, a parama1)
  {
    AppMethodBeat.i(212970);
    Fragment localFragment = parama1.WM;
    View localView = localFragment.getView();
    if ((parama.isEmpty()) || (paramObject == null) || (localView == null))
    {
      parama.clear();
      AppMethodBeat.o(212970);
      return null;
    }
    androidx.b.a locala = new androidx.b.a();
    paraml.a(locala, localView);
    paraml = parama1.WO;
    if (parama1.WN)
    {
      paramObject = localFragment.getExitTransitionCallback();
      paraml = paraml.Vd;
      if (paraml != null)
      {
        f.a(locala, paraml);
        f.a(locala, parama.values());
      }
      if (paramObject == null) {
        break label222;
      }
      i = paraml.size() - 1;
      label120:
      if (i < 0) {
        break label268;
      }
      parama1 = (String)paraml.get(i);
      paramObject = (View)locala.get(parama1);
      if (paramObject != null) {
        break label188;
      }
      paramObject = a(parama, parama1);
      if (paramObject != null) {
        parama.remove(paramObject);
      }
    }
    for (;;)
    {
      i -= 1;
      break label120;
      paramObject = localFragment.getEnterTransitionCallback();
      paraml = paraml.Ve;
      break;
      label188:
      if (!parama1.equals(w.W(paramObject)))
      {
        parama1 = a(parama, parama1);
        if (parama1 != null) {
          parama.put(parama1, w.W(paramObject));
        }
      }
    }
    label222:
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!locala.containsKey((String)parama.aM(i))) {
        parama.removeAt(i);
      }
      i -= 1;
    }
    label268:
    AppMethodBeat.o(212970);
    return locala;
  }
  
  private static Object b(l paraml, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(212963);
    if (paramFragment == null)
    {
      AppMethodBeat.o(212963);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition())
    {
      paraml = paraml.I(paramFragment);
      AppMethodBeat.o(212963);
      return paraml;
    }
  }
  
  private static void b(a parama, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(212987);
    if (!parama.UN.mContainer.it())
    {
      AppMethodBeat.o(212987);
      return;
    }
    int i = parama.UO.size() - 1;
    while (i >= 0)
    {
      a(parama, (a.a)parama.UO.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
    AppMethodBeat.o(212987);
  }
  
  static void b(ArrayList<View> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(212983);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(212983);
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
    AppMethodBeat.o(212983);
  }
  
  private static l iF()
  {
    AppMethodBeat.i(212937);
    try
    {
      l locall = (l)Class.forName("androidx.transition.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(212937);
      return locall;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(212937);
    }
    return null;
  }
  
  static final class a
  {
    public Fragment WM;
    public boolean WN;
    public a WO;
    public Fragment WP;
    public boolean WQ;
    public a WR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.j
 * JD-Core Version:    0.7.0.1
 */