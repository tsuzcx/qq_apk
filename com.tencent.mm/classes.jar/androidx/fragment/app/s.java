package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.f;
import androidx.core.c.b;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class s
{
  private static final int[] bDM;
  static final u bDN;
  static final u bDO;
  
  static
  {
    AppMethodBeat.i(193887);
    bDM = new int[] { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10 };
    if (Build.VERSION.SDK_INT >= 21) {}
    for (t localt = new t();; localt = null)
    {
      bDN = localt;
      bDO = GD();
      AppMethodBeat.o(193887);
      return;
    }
  }
  
  private static u GD()
  {
    AppMethodBeat.i(193687);
    try
    {
      u localu = (u)Class.forName("androidx.transition.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(193687);
      return localu;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(193687);
    }
    return null;
  }
  
  static View a(androidx.b.a<String, View> parama, b paramb, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(193802);
    paramb = paramb.bEi;
    if ((paramObject != null) && (parama != null) && (paramb.bBo != null) && (!paramb.bBo.isEmpty()))
    {
      if (paramBoolean) {}
      for (paramb = (String)paramb.bBo.get(0);; paramb = (String)paramb.bBp.get(0))
      {
        parama = (View)parama.get(paramb);
        AppMethodBeat.o(193802);
        return parama;
      }
    }
    AppMethodBeat.o(193802);
    return null;
  }
  
  private static androidx.b.a<String, String> a(int paramInt1, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193725);
    androidx.b.a locala = new androidx.b.a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (a)paramArrayList.get(paramInt3);
      if (((a)localObject).eT(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((a)localObject).bBo != null)
        {
          int j = ((a)localObject).bBo.size();
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int i;
          label100:
          String str1;
          if (bool)
          {
            localArrayList1 = ((a)localObject).bBo;
            localArrayList2 = ((a)localObject).bBp;
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
            localArrayList2 = ((a)localObject).bBo;
            localArrayList1 = ((a)localObject).bBp;
            break;
            label184:
            locala.put(localObject, str1);
          }
        }
      }
      label197:
      paramInt3 -= 1;
    }
    AppMethodBeat.o(193725);
    return locala;
  }
  
  private static androidx.b.a<String, View> a(u paramu, androidx.b.a<String, String> parama, Object paramObject, b paramb)
  {
    AppMethodBeat.i(193779);
    if ((parama.isEmpty()) || (paramObject == null))
    {
      parama.clear();
      AppMethodBeat.o(193779);
      return null;
    }
    paramObject = paramb.bEj;
    androidx.b.a locala = new androidx.b.a();
    paramu.a(locala, paramObject.requireView());
    paramu = paramb.bEl;
    int i;
    if (paramb.bEk)
    {
      paramObject = paramObject.getEnterTransitionCallback();
      paramu = paramu.bBp;
      if (paramu != null) {
        f.a(locala, paramu);
      }
      if (paramObject == null) {
        break label186;
      }
      i = paramu.size() - 1;
      label96:
      if (i < 0) {
        break label196;
      }
      paramb = (String)paramu.get(i);
      paramObject = (View)locala.get(paramb);
      if (paramObject != null) {
        break label153;
      }
      parama.remove(paramb);
    }
    for (;;)
    {
      i -= 1;
      break label96;
      paramObject = paramObject.getExitTransitionCallback();
      paramu = paramu.bBo;
      break;
      label153:
      if (!paramb.equals(z.ai(paramObject)))
      {
        paramb = (String)parama.remove(paramb);
        parama.put(z.ai(paramObject), paramb);
      }
    }
    label186:
    f.a(parama, locala.keySet());
    label196:
    AppMethodBeat.o(193779);
    return locala;
  }
  
  private static b a(b paramb, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(193880);
    b localb = paramb;
    if (paramb == null)
    {
      localb = new b();
      paramSparseArray.put(paramInt, localb);
    }
    AppMethodBeat.o(193880);
    return localb;
  }
  
  private static u a(Fragment paramFragment1, Fragment paramFragment2)
  {
    AppMethodBeat.i(193736);
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
      AppMethodBeat.o(193736);
      return null;
    }
    if ((bDN != null) && (a(bDN, localArrayList)))
    {
      paramFragment1 = bDN;
      AppMethodBeat.o(193736);
      return paramFragment1;
    }
    if ((bDO != null) && (a(bDO, localArrayList)))
    {
      paramFragment1 = bDO;
      AppMethodBeat.o(193736);
      return paramFragment1;
    }
    if ((bDN != null) || (bDO != null))
    {
      paramFragment1 = new IllegalArgumentException("Invalid Transition types");
      AppMethodBeat.o(193736);
      throw paramFragment1;
    }
    AppMethodBeat.o(193736);
    return null;
  }
  
  private static Object a(u paramu, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    AppMethodBeat.i(193753);
    if ((paramFragment1 == null) || (paramFragment2 == null))
    {
      AppMethodBeat.o(193753);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition())
    {
      paramu = paramu.aJ(paramu.aI(paramFragment1));
      AppMethodBeat.o(193753);
      return paramu;
    }
  }
  
  private static Object a(u paramu, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(193758);
    if (paramFragment == null)
    {
      AppMethodBeat.o(193758);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition())
    {
      paramu = paramu.aI(paramFragment);
      AppMethodBeat.o(193758);
      return paramu;
    }
  }
  
  private static Object a(u paramu, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(193851);
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
    for (paramu = paramu.a(paramObject2, paramObject1, paramObject3);; paramu = paramu.b(paramObject2, paramObject1, paramObject3))
    {
      AppMethodBeat.o(193851);
      return paramu;
      label65:
      bool1 = paramFragment.getAllowEnterTransitionOverlap();
      break;
    }
  }
  
  static String a(androidx.b.a<String, String> parama, String paramString)
  {
    AppMethodBeat.i(193793);
    int j = parama.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(parama.bl(i)))
      {
        parama = (String)parama.bn(i);
        AppMethodBeat.o(193793);
        return parama;
      }
      i += 1;
    }
    AppMethodBeat.o(193793);
    return null;
  }
  
  static ArrayList<View> a(u paramu, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    AppMethodBeat.i(193840);
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramu.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramu.a(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    AppMethodBeat.o(193840);
    return localObject;
  }
  
  static void a(final Context paramContext, d paramd, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(193716);
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
    if (localSparseArray.size() != 0)
    {
      final View localView = new View(paramContext);
      int j = localSparseArray.size();
      i = 0;
      if (i < j)
      {
        int k = localSparseArray.keyAt(i);
        final androidx.b.a locala1 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        Object localObject4 = (b)localSparseArray.valueAt(i);
        ViewGroup localViewGroup;
        final Fragment localFragment1;
        Object localObject10;
        Object localObject5;
        final boolean bool2;
        Object localObject6;
        final Object localObject7;
        Object localObject8;
        Object localObject9;
        final Fragment localFragment2;
        final Fragment localFragment3;
        Object localObject2;
        Object localObject3;
        if (paramd.onHasView())
        {
          localViewGroup = (ViewGroup)paramd.onFindViewById(k);
          if (localViewGroup != null)
          {
            if (!paramBoolean) {
              break label867;
            }
            localFragment1 = ((b)localObject4).bEg;
            localObject10 = ((b)localObject4).bEj;
            localObject5 = a((Fragment)localObject10, localFragment1);
            if (localObject5 != null)
            {
              bool1 = ((b)localObject4).bEh;
              bool2 = ((b)localObject4).bEk;
              localObject6 = new ArrayList();
              localObject7 = new ArrayList();
              localObject8 = a((u)localObject5, localFragment1, bool1);
              localObject9 = b((u)localObject5, (Fragment)localObject10, bool2);
              localFragment2 = ((b)localObject4).bEg;
              localFragment3 = ((b)localObject4).bEj;
              if (localFragment2 != null) {
                localFragment2.requireView().setVisibility(0);
              }
              if ((localFragment2 != null) && (localFragment3 != null)) {
                break label584;
              }
              paramContext = null;
              if ((localObject8 != null) || (paramContext != null) || (localObject9 != null))
              {
                localObject1 = a((u)localObject5, localObject9, (Fragment)localObject10, (ArrayList)localObject7, localView);
                localObject2 = a((u)localObject5, localObject8, localFragment1, (ArrayList)localObject6, localView);
                b((ArrayList)localObject2, 4);
                localObject3 = a((u)localObject5, localObject8, localObject9, paramContext, localFragment1, bool1);
                if ((localObject10 != null) && (localObject1 != null) && ((((ArrayList)localObject1).size() > 0) || (((ArrayList)localObject7).size() > 0)))
                {
                  localObject4 = new b();
                  parama.a((Fragment)localObject10, (b)localObject4);
                  ((u)localObject5).a(localObject3, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(193433);
                      s.this.b(this.bDP, this.bCx);
                      AppMethodBeat.o(193433);
                    }
                  });
                }
                if (localObject3 != null)
                {
                  if ((localObject10 != null) && (localObject9 != null) && (((Fragment)localObject10).mAdded) && (((Fragment)localObject10).mHidden) && (((Fragment)localObject10).mHiddenChanged))
                  {
                    ((Fragment)localObject10).setHideReplaced(true);
                    ((u)localObject5).b(localObject9, ((Fragment)localObject10).getView(), (ArrayList)localObject1);
                    androidx.core.g.u.a(((Fragment)localObject10).mContainer, new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(193441);
                        s.b(s.this, 4);
                        AppMethodBeat.o(193441);
                      }
                    });
                  }
                  localObject4 = u.d((ArrayList)localObject6);
                  ((u)localObject5).a(localObject3, localObject8, (ArrayList)localObject2, localObject9, (ArrayList)localObject1, paramContext, (ArrayList)localObject6);
                  ((u)localObject5).a(localViewGroup, localObject3);
                  ((u)localObject5).a(localViewGroup, (ArrayList)localObject7, (ArrayList)localObject6, (ArrayList)localObject4, locala1);
                  b((ArrayList)localObject2, 0);
                  ((u)localObject5).a(paramContext, (ArrayList)localObject7, (ArrayList)localObject6);
                }
              }
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label584:
          bool2 = ((b)localObject4).bEh;
          label601:
          final androidx.b.a locala2;
          if (locala1.isEmpty())
          {
            paramContext = null;
            localObject2 = a((u)localObject5, locala1, paramContext, (b)localObject4);
            locala2 = b((u)localObject5, locala1, paramContext, (b)localObject4);
            if (!locala1.isEmpty()) {
              break label696;
            }
            localObject1 = null;
            if (localObject2 != null) {
              ((androidx.b.a)localObject2).clear();
            }
            paramContext = (Context)localObject1;
            if (locala2 != null)
            {
              locala2.clear();
              paramContext = (Context)localObject1;
            }
          }
          for (;;)
          {
            if ((localObject8 != null) || (localObject9 != null) || (paramContext != null)) {
              break label723;
            }
            paramContext = null;
            break;
            paramContext = a((u)localObject5, localFragment2, localFragment3, bool2);
            break label601;
            label696:
            a((ArrayList)localObject7, (androidx.b.a)localObject2, locala1.keySet());
            a((ArrayList)localObject6, locala2, locala1.values());
          }
          label723:
          a(localFragment2, localFragment3, bool2, (androidx.b.a)localObject2);
          if (paramContext != null)
          {
            ((ArrayList)localObject6).add(localView);
            ((u)localObject5).a(paramContext, localView, (ArrayList)localObject7);
            a((u)localObject5, paramContext, localObject9, (androidx.b.a)localObject2, ((b)localObject4).bEk, ((b)localObject4).bEl);
            localObject3 = new Rect();
            localObject4 = a(locala2, (b)localObject4, localObject8, bool2);
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (localObject4 != null)
            {
              ((u)localObject5).b(localObject8, (Rect)localObject3);
              localObject2 = localObject3;
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            androidx.core.g.u.a(localViewGroup, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193455);
                s.a(s.this, localFragment3, bool2, locala2);
                if (this.bDZ != null) {
                  u.b(this.bDZ, this.bEa);
                }
                AppMethodBeat.o(193455);
              }
            });
            break;
            localObject2 = null;
          }
          label867:
          localObject5 = ((b)localObject4).bEg;
          localObject9 = ((b)localObject4).bEj;
          localObject6 = a((Fragment)localObject9, (Fragment)localObject5);
          if (localObject6 != null)
          {
            bool1 = ((b)localObject4).bEh;
            bool2 = ((b)localObject4).bEk;
            localObject7 = a((u)localObject6, (Fragment)localObject5, bool1);
            localObject2 = b((u)localObject6, (Fragment)localObject9, bool2);
            localObject10 = new ArrayList();
            localObject8 = new ArrayList();
            localFragment1 = ((b)localObject4).bEg;
            localFragment2 = ((b)localObject4).bEj;
            if ((localFragment1 != null) && (localFragment2 != null)) {
              break label1229;
            }
            paramContext = null;
            label975:
            if ((localObject7 == null) && (paramContext == null) && (localObject2 == null)) {
              break label1429;
            }
            localObject3 = a((u)localObject6, localObject2, (Fragment)localObject9, (ArrayList)localObject10, localView);
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (!((ArrayList)localObject3).isEmpty()) {}
            }
            else
            {
              localObject1 = null;
            }
            ((u)localObject6).b(localObject7, localView);
            localObject2 = a((u)localObject6, localObject7, localObject1, paramContext, (Fragment)localObject5, ((b)localObject4).bEh);
            if ((localObject9 != null) && (localObject3 != null) && ((((ArrayList)localObject3).size() > 0) || (((ArrayList)localObject10).size() > 0)))
            {
              localObject4 = new b();
              parama.a((Fragment)localObject9, (b)localObject4);
              ((u)localObject6).a(localObject2, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193447);
                  s.this.b(this.bDP, this.bCx);
                  AppMethodBeat.o(193447);
                }
              });
            }
            if (localObject2 != null)
            {
              localObject4 = new ArrayList();
              ((u)localObject6).a(localObject2, localObject7, (ArrayList)localObject4, localObject1, (ArrayList)localObject3, paramContext, (ArrayList)localObject8);
              androidx.core.g.u.a(localViewGroup, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193465);
                  ArrayList localArrayList;
                  if (s.this != null)
                  {
                    this.bBE.c(s.this, localView);
                    localArrayList = s.a(this.bBE, s.this, this.bDT, this.bDU, localView);
                    this.bDV.addAll(localArrayList);
                  }
                  if (this.bDQ != null)
                  {
                    if (localObject1 != null)
                    {
                      localArrayList = new ArrayList();
                      localArrayList.add(localView);
                      this.bBE.b(localObject1, this.bDQ, localArrayList);
                    }
                    this.bDQ.clear();
                    this.bDQ.add(localView);
                  }
                  AppMethodBeat.o(193465);
                }
              });
              androidx.core.g.u.a(localViewGroup, new u.2((u)localObject6, (ArrayList)localObject8, locala1));
              ((u)localObject6).a(localViewGroup, localObject2);
              androidx.core.g.u.a(localViewGroup, new u.3((u)localObject6, (ArrayList)localObject8, locala1));
            }
          }
        }
        label1229:
        final boolean bool1 = ((b)localObject4).bEh;
        if (locala1.isEmpty())
        {
          paramContext = null;
          label1246:
          localObject1 = a((u)localObject6, locala1, paramContext, (b)localObject4);
          if (!locala1.isEmpty()) {
            break label1302;
          }
          paramContext = null;
        }
        for (;;)
        {
          if ((localObject7 != null) || (localObject2 != null) || (paramContext != null)) {
            break label1316;
          }
          paramContext = null;
          break;
          paramContext = a((u)localObject6, localFragment1, localFragment2, bool1);
          break label1246;
          label1302:
          ((ArrayList)localObject10).addAll(((androidx.b.a)localObject1).values());
        }
        label1316:
        a(localFragment1, localFragment2, bool1, (androidx.b.a)localObject1);
        if (paramContext != null)
        {
          localObject3 = new Rect();
          ((u)localObject6).a(paramContext, localView, (ArrayList)localObject10);
          a((u)localObject6, paramContext, localObject2, (androidx.b.a)localObject1, ((b)localObject4).bEk, ((b)localObject4).bEl);
          localObject1 = localObject3;
          if (localObject7 != null) {
            ((u)localObject6).b(localObject7, (Rect)localObject3);
          }
        }
        for (localObject1 = localObject3;; localObject1 = null)
        {
          androidx.core.g.u.a(localViewGroup, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193460);
              Object localObject = s.b(s.this, locala1, paramContext, this.bEd);
              if (localObject != null)
              {
                this.bDU.addAll(((androidx.b.a)localObject).values());
                this.bDU.add(localView);
              }
              s.a(localFragment1, localFragment2, bool1, (androidx.b.a)localObject);
              if (paramContext != null)
              {
                s.this.a(paramContext, this.bEe, this.bDU);
                localObject = s.a((androidx.b.a)localObject, this.bEd, localObject7, bool1);
                if (localObject != null) {
                  u.b((View)localObject, this.bEf);
                }
              }
              AppMethodBeat.o(193460);
            }
          });
          break label975;
          label1429:
          break;
        }
      }
    }
    AppMethodBeat.o(193716);
  }
  
  static void a(androidx.b.a<String, String> parama, androidx.b.a<String, View> parama1)
  {
    AppMethodBeat.i(193821);
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!parama1.containsKey((String)parama.bl(i))) {
        parama.removeAt(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(193821);
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, androidx.b.a<String, View> parama)
  {
    int j = 0;
    AppMethodBeat.i(193831);
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
      paramFragment2.add(parama.bn(j));
      paramFragment1.add(parama.bl(j));
      j += 1;
      continue;
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
      break;
      label91:
      i = parama.size();
    }
    label100:
    AppMethodBeat.o(193831);
  }
  
  private static void a(a parama, SparseArray<b> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(193859);
    int j = parama.bDF.size();
    int i = 0;
    while (i < j)
    {
      a(parama, (r.a)parama.bDF.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(193859);
  }
  
  private static void a(a parama, r.a parama1, SparseArray<b> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193876);
    Fragment localFragment = parama1.bDv;
    if (localFragment == null)
    {
      AppMethodBeat.o(193876);
      return;
    }
    int n = localFragment.mContainerId;
    if (n == 0)
    {
      AppMethodBeat.o(193876);
      return;
    }
    if (paramBoolean1) {}
    int j;
    int k;
    boolean bool;
    for (int i = bDM[parama1.bDJ];; i = parama1.bDJ) {
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        k = 0;
        bool = false;
        Object localObject = (b)paramSparseArray.get(n);
        parama1 = (r.a)localObject;
        if (bool)
        {
          parama1 = a((b)localObject, paramSparseArray, n);
          parama1.bEg = localFragment;
          parama1.bEh = paramBoolean1;
          parama1.bEi = parama;
        }
        if ((!paramBoolean2) && (i != 0))
        {
          if ((parama1 != null) && (parama1.bEj == localFragment)) {
            parama1.bEj = null;
          }
          if (!parama.bBq)
          {
            localObject = parama.bBd;
            o localo = ((FragmentManager)localObject).createOrGetFragmentStateManager(localFragment);
            ((FragmentManager)localObject).getFragmentStore().a(localo);
            ((FragmentManager)localObject).moveToState(localFragment);
          }
        }
        localObject = parama1;
        if (j != 0) {
          if (parama1 != null)
          {
            localObject = parama1;
            if (parama1.bEj != null) {}
          }
          else
          {
            localObject = a(parama1, paramSparseArray, n);
            ((b)localObject).bEj = localFragment;
            ((b)localObject).bEk = paramBoolean1;
            ((b)localObject).bEl = parama;
          }
        }
        if ((!paramBoolean2) && (k != 0) && (localObject != null) && (((b)localObject).bEg == localFragment)) {
          ((b)localObject).bEg = null;
        }
        AppMethodBeat.o(193876);
        return;
      }
    }
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
  
  private static void a(u paramu, Object paramObject1, Object paramObject2, androidx.b.a<String, View> parama, boolean paramBoolean, a parama1)
  {
    AppMethodBeat.i(193816);
    if ((parama1.bBo != null) && (!parama1.bBo.isEmpty())) {
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (parama1 = (String)parama1.bBp.get(0);; parama1 = (String)parama1.bBo.get(0))
    {
      parama = (View)parama.get(parama1);
      paramu.a(paramObject1, parama);
      if (paramObject2 != null) {
        paramu.a(paramObject2, parama);
      }
      AppMethodBeat.o(193816);
      return;
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, androidx.b.a<String, View> parama, Collection<String> paramCollection)
  {
    AppMethodBeat.i(193770);
    int i = parama.size() - 1;
    while (i >= 0)
    {
      View localView = (View)parama.bl(i);
      if (paramCollection.contains(z.ai(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
    AppMethodBeat.o(193770);
  }
  
  private static boolean a(u paramu, List<Object> paramList)
  {
    AppMethodBeat.i(193744);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramu.aH(paramList.get(i)))
      {
        AppMethodBeat.o(193744);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(193744);
    return true;
  }
  
  static androidx.b.a<String, View> b(u paramu, androidx.b.a<String, String> parama, Object paramObject, b paramb)
  {
    AppMethodBeat.i(193786);
    Fragment localFragment = paramb.bEg;
    View localView = localFragment.getView();
    if ((parama.isEmpty()) || (paramObject == null) || (localView == null))
    {
      parama.clear();
      AppMethodBeat.o(193786);
      return null;
    }
    androidx.b.a locala = new androidx.b.a();
    paramu.a(locala, localView);
    paramu = paramb.bEi;
    int i;
    if (paramb.bEh)
    {
      paramObject = localFragment.getExitTransitionCallback();
      paramu = paramu.bBo;
      if (paramu != null)
      {
        f.a(locala, paramu);
        f.a(locala, parama.values());
      }
      if (paramObject == null) {
        break label222;
      }
      i = paramu.size() - 1;
      label120:
      if (i < 0) {
        break label228;
      }
      paramb = (String)paramu.get(i);
      paramObject = (View)locala.get(paramb);
      if (paramObject != null) {
        break label188;
      }
      paramObject = a(parama, paramb);
      if (paramObject != null) {
        parama.remove(paramObject);
      }
    }
    for (;;)
    {
      i -= 1;
      break label120;
      paramObject = localFragment.getEnterTransitionCallback();
      paramu = paramu.bBp;
      break;
      label188:
      if (!paramb.equals(z.ai(paramObject)))
      {
        paramb = a(parama, paramb);
        if (paramb != null) {
          parama.put(paramb, z.ai(paramObject));
        }
      }
    }
    label222:
    a(parama, locala);
    label228:
    AppMethodBeat.o(193786);
    return locala;
  }
  
  private static Object b(u paramu, Fragment paramFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(193763);
    if (paramFragment == null)
    {
      AppMethodBeat.o(193763);
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition())
    {
      paramu = paramu.aI(paramFragment);
      AppMethodBeat.o(193763);
      return paramu;
    }
  }
  
  private static void b(a parama, SparseArray<b> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(193867);
    if (!parama.bBd.getContainer().onHasView())
    {
      AppMethodBeat.o(193867);
      return;
    }
    int i = parama.bDF.size() - 1;
    while (i >= 0)
    {
      a(parama, (r.a)parama.bDF.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
    AppMethodBeat.o(193867);
  }
  
  static void b(ArrayList<View> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(193844);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(193844);
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
    AppMethodBeat.o(193844);
  }
  
  static abstract interface a
  {
    public abstract void a(Fragment paramFragment, b paramb);
    
    public abstract void b(Fragment paramFragment, b paramb);
  }
  
  static final class b
  {
    public Fragment bEg;
    public boolean bEh;
    public a bEi;
    public Fragment bEj;
    public boolean bEk;
    public a bEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.s
 * JD-Core Version:    0.7.0.1
 */