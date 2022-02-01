package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroid/support/v4/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a sEj;
  int afB;
  private Field field_activity;
  private Field field_fragments;
  String sDY;
  String sDZ;
  boolean sEa;
  boolean sEb;
  com.tencent.mm.plugin.expt.hellhound.a.b.b sEc;
  WeakReference<UIComponentActivity> sEd;
  private WeakReference<UIComponentFragment> sEe;
  private WeakReference<UIComponentFragment> sEf;
  private int sEg;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> sEh;
  final b sEi;
  
  static
  {
    AppMethodBeat.i(220907);
    sEj = new b.a((byte)0);
    AppMethodBeat.o(220907);
  }
  
  public b()
  {
    AppMethodBeat.i(220906);
    this.sEb = true;
    this.sEg = -1;
    this.afB = -1;
    this.sEh = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.sEh).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver");
      p.g(localObject, "Class.forName(NAME_FinderFragmentChangeObserver)");
      this.field_activity = ((Class)localObject).getDeclaredField("activity");
      Field localField = this.field_activity;
      if (localField != null) {
        localField.setAccessible(true);
      }
      this.field_fragments = ((Class)localObject).getDeclaredField("fragments");
      localObject = this.field_fragments;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)localException, "FinderFragmentCallback reflect crash: " + localException.getMessage(), new Object[0]);
      }
    }
    this.afB = -1;
    this.sDY = null;
    this.sDZ = null;
    this.sEa = false;
    this.sEb = true;
    this.sEc = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
    this.sEi = new b(this);
    AppMethodBeat.o(220906);
  }
  
  private final void cOH()
  {
    this.sEa = false;
    this.sDZ = null;
    this.sDY = null;
  }
  
  private final void cOI()
  {
    this.sEb = false;
    this.sDY = null;
  }
  
  private final UIComponentActivity dg(Object paramObject)
  {
    AppMethodBeat.i(220903);
    try
    {
      Field localField = this.field_activity;
      if (localField != null)
      {
        paramObject = localField.get(paramObject);
        if (paramObject != null) {
          break label60;
        }
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentActivity");
        AppMethodBeat.o(220903);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(220903);
      return paramObject;
      paramObject = null;
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final UIComponentFragment m(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(220902);
    if (paramInt < 0)
    {
      AppMethodBeat.o(220902);
      return null;
    }
    try
    {
      Field localField = this.field_fragments;
      if (localField != null)
      {
        paramObject = localField.get(paramObject);
        if (paramObject != null) {
          break label105;
        }
        paramObject = new t("null cannot be cast to non-null type kotlin.collections.List<*>");
        AppMethodBeat.o(220902);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)paramObject, "getFragment exception: " + paramObject.getMessage(), new Object[0]);
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(220902);
      return paramObject;
      paramObject = null;
      break;
      label105:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(220902);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(220904);
    p.h(paramFragmentActivity, "activity");
    Object localObject1 = this.sEc;
    if (localObject1 != null)
    {
      p.h(paramFragmentActivity, "activity");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
      if (localObject2 == null) {
        p.btv("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
      if (localObject2 == null) {
        p.btv("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramFragmentActivity.getClass().getName());
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
      if (localObject2 == null) {
        p.btv("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGC = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
      if (localObject2 == null) {
        p.btv("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGF = "143";
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
      if (localObject1 == null) {
        p.btv("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dYn = c.b.sFb.value;
      Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
    }
    if ((this.sDZ != null) && ((p.j(paramFragmentActivity.getClass().getName(), this.sDZ) ^ true)) && (!this.sEa))
    {
      cOH();
      localObject1 = this.sEc;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, true);
        AppMethodBeat.o(220904);
        return;
      }
      AppMethodBeat.o(220904);
      return;
    }
    if (this.sEa)
    {
      cOH();
      AppMethodBeat.o(220904);
      return;
    }
    Object localObject2 = this.sEc;
    if (localObject2 != null)
    {
      p.h(paramFragmentActivity, "activity");
      Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.a.b.b.ae((Activity)paramFragmentActivity);
      StringBuilder localStringBuilder = new StringBuilder("switch2Front: ");
      if (localFragment != null)
      {
        localObject1 = localFragment.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        Log.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localFragment == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject2).a(paramFragmentActivity, localFragment, paramLong, 2);
        AppMethodBeat.o(220904);
        return;
      }
    }
    AppMethodBeat.o(220904);
  }
  
  public final void c(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(220905);
    p.h(paramFragmentActivity, "activity");
    Object localObject1 = this.sEc;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE == null) {
        break label344;
      }
    }
    Object localObject3;
    Object localObject4;
    label344:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
        if (localObject4 == null) {
          p.btv("statyTimeStaticHome");
        }
        if (!p.j(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject4).dMl, localObject3))
        {
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject3 == null) {
            p.btv("statyTimeStaticHome");
          }
          if (!p.j(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).dMl, localObject2)) {}
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject2 == null) {
            p.btv("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGD = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject2 == null) {
            p.btv("statyTimeStaticHome");
          }
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject3 == null) {
            p.btv("statyTimeStaticHome");
          }
          long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).sGD;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject3 == null) {
            p.btv("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGB = (l - ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).sGC);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject2 == null) {
            p.btv("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGF = "143";
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject2 == null) {
            p.btv("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNC();
          localObject2 = a.sGv;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).sCE;
          if (localObject1 == null) {
            p.btv("statyTimeStaticHome");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
        }
      }
      if (!this.sEb) {
        break label357;
      }
      cOI();
      localObject1 = this.sEc;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
      AppMethodBeat.o(220905);
      return;
    }
    AppMethodBeat.o(220905);
    return;
    label357:
    if ((this.sDY != null) && ((p.j(paramFragmentActivity.getClass().getName(), this.sDY) ^ true)))
    {
      cOI();
      localObject1 = this.sEc;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(220905);
        return;
      }
      AppMethodBeat.o(220905);
      return;
    }
    Object localObject2 = this.sEc;
    if (localObject2 != null)
    {
      p.h(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.ae((Activity)paramFragmentActivity);
      localObject4 = new StringBuilder("switch2Back: ");
      if (localObject3 != null)
      {
        localObject1 = localObject3.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        Log.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localObject3 == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject2).b(paramFragmentActivity, (Fragment)localObject3, paramLong, 3);
        AppMethodBeat.o(220905);
        return;
      }
    }
    AppMethodBeat.o(220905);
  }
  
  final UIComponentFragment l(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(220901);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.sEf;
      if (paramObject != null)
      {
        paramObject = (UIComponentFragment)paramObject.get();
        AppMethodBeat.o(220901);
        return paramObject;
      }
      AppMethodBeat.o(220901);
      return null;
    }
    try
    {
      paramObject = m(paramObject, paramInt);
      AppMethodBeat.o(220901);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.sEf;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220900);
      if ((paramString1 == null) || (!n.J(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", false)))
      {
        AppMethodBeat.o(220900);
        return;
      }
      if ((p.j("onUserVisibleFragmentChange", paramString2)) && (p.j("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
        {
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(220900);
            throw paramString1;
          }
          boolean bool = ((Boolean)paramString1).booleanValue();
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220900);
            throw paramString1;
          }
          int i = ((Integer)paramString1).intValue();
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
            AppMethodBeat.o(220900);
            throw paramString1;
          }
          paramString1 = (UIComponentFragment)paramString1;
          if (bool)
          {
            if (i == b.a(this.sEk))
            {
              b.a(this.sEk, new WeakReference(paramString1));
              AppMethodBeat.o(220900);
            }
          }
          else
          {
            if (i == b.b(this.sEk)) {
              b.b(this.sEk, new WeakReference(paramString1));
            }
            AppMethodBeat.o(220900);
          }
        }
      }
      else if ((p.j("onFragmentChange", paramString2)) && (p.j("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = this.sEk;
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(220900);
          throw paramString1;
        }
        b.b(paramString1, ((Integer)paramString2).intValue());
        paramString1 = this.sEk;
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(220900);
          throw paramString1;
        }
        b.a(paramString1, ((Integer)paramString2).intValue());
        if (paramObject != null)
        {
          paramString3 = b.a(this.sEk, paramObject, b.a(this.sEk));
          paramArrayOfObject = b.b(this.sEk, paramObject, b.b(this.sEk));
          paramString1 = b.a(this.sEk, paramObject);
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(220900);
            throw paramString1;
          }
          paramObject = (MMActivity)paramString1;
          b.a(this.sEk, (UIComponentActivity)paramObject);
          com.tencent.mm.plugin.expt.hellhound.a.b.b localb = b.c(this.sEk);
          if ((localb != null) && (paramObject != null))
          {
            label487:
            long l;
            if (paramString3 != null)
            {
              paramString1 = paramString3.getClass();
              if (paramString1 != null)
              {
                paramString1 = paramString1.getName();
                if (paramArrayOfObject == null) {
                  break label631;
                }
                paramString2 = paramArrayOfObject.getClass();
                if (paramString2 == null) {
                  break label631;
                }
                paramString2 = paramString2.getName();
                if ((!p.j(paramString1, paramString2)) || (paramString1 == null))
                {
                  l = System.currentTimeMillis();
                  paramString2 = new StringBuilder("switchFragment, cur=");
                  if (paramString3 == null) {
                    break label636;
                  }
                  paramString1 = paramString3.getClass();
                  if (paramString1 == null) {
                    break label636;
                  }
                  paramString1 = paramString1.getName();
                  label532:
                  paramString2 = paramString2.append(paramString1).append(", last=");
                  if (paramArrayOfObject == null) {
                    break label641;
                  }
                  paramString1 = paramArrayOfObject.getClass();
                  if (paramString1 == null) {
                    break label641;
                  }
                }
              }
            }
            label641:
            for (paramString1 = paramString1.getName();; paramString1 = null)
            {
              Log.i("HABBYGE-MALI.FinderHomeMonitor", paramString1);
              if (paramArrayOfObject != null) {
                localb.b((FragmentActivity)paramObject, (Fragment)paramArrayOfObject, l, 1);
              }
              if (paramString3 != null) {
                localb.a((FragmentActivity)paramObject, (Fragment)paramString3, l, 0);
              }
              AppMethodBeat.o(220900);
              return;
              paramString1 = null;
              break;
              label631:
              paramString2 = null;
              break label487;
              label636:
              paramString1 = null;
              break label532;
            }
          }
        }
      }
      AppMethodBeat.o(220900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */