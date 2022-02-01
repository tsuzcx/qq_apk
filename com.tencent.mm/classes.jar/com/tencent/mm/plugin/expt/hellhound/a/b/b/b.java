package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroid/support/v4/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final a KGt;
  String KGi;
  String KGj;
  boolean KGk;
  boolean KGl;
  com.tencent.mm.plugin.expt.hellhound.a.b.a KGm;
  WeakReference<UIComponentActivity> KGn;
  private WeakReference<UIComponentFragment> KGo;
  private WeakReference<UIComponentFragment> KGp;
  private int KGq;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> KGr;
  final b KGs;
  int acD;
  private Field field_activity;
  private Field field_fragments;
  
  static
  {
    AppMethodBeat.i(205169);
    KGt = new a((byte)0);
    AppMethodBeat.o(205169);
  }
  
  public b()
  {
    AppMethodBeat.i(205168);
    this.KGl = true;
    this.KGq = -1;
    this.acD = -1;
    this.KGr = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver");
      k.g(localObject, "Class.forName(NAME_FinderFragmentChangeObserver)");
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
        ad.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)localException, "FinderFragmentCallback reflect crash: " + localException.getMessage(), new Object[0]);
      }
    }
    this.acD = -1;
    this.KGi = null;
    this.KGj = null;
    this.KGk = false;
    this.KGl = true;
    this.KGm = new com.tencent.mm.plugin.expt.hellhound.a.b.a();
    this.KGs = new b(this);
    AppMethodBeat.o(205168);
  }
  
  private final void fRv()
  {
    this.KGk = false;
    this.KGj = null;
    this.KGi = null;
  }
  
  private final void fRw()
  {
    this.KGl = false;
    this.KGi = null;
  }
  
  private final UIComponentActivity gd(Object paramObject)
  {
    AppMethodBeat.i(205165);
    try
    {
      Field localField = this.field_activity;
      if (localField != null)
      {
        paramObject = localField.get(paramObject);
        if (paramObject != null) {
          break label60;
        }
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentActivity");
        AppMethodBeat.o(205165);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(205165);
      return paramObject;
      paramObject = null;
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final UIComponentFragment o(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(205164);
    if (paramInt < 0)
    {
      AppMethodBeat.o(205164);
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
        paramObject = new v("null cannot be cast to non-null type kotlin.collections.List<*>");
        AppMethodBeat.o(205164);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)paramObject, "getFragment exception: " + paramObject.getMessage(), new Object[0]);
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(205164);
      return paramObject;
      paramObject = null;
      break;
      label105:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(205164);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(205166);
    k.h(paramFragmentActivity, "activity");
    Object localObject1 = this.KGm;
    if (localObject1 != null)
    {
      k.h(paramFragmentActivity, "activity");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
      if (localObject2 == null) {
        k.aPZ("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
      if (localObject2 == null) {
        k.aPZ("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramFragmentActivity.getClass().getName());
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
      if (localObject2 == null) {
        k.aPZ("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).KHU = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
      if (localObject2 == null) {
        k.aPZ("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).pZX = "143";
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
      if (localObject1 == null) {
        k.aPZ("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dvJ = c.b.KGN.value;
      ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
    }
    if ((this.KGj != null) && ((k.g(paramFragmentActivity.getClass().getName(), this.KGj) ^ true)) && (!this.KGk))
    {
      fRv();
      localObject1 = this.KGm;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, true);
        AppMethodBeat.o(205166);
        return;
      }
      AppMethodBeat.o(205166);
      return;
    }
    if (this.KGk)
    {
      fRv();
      AppMethodBeat.o(205166);
      return;
    }
    Object localObject2 = this.KGm;
    if (localObject2 != null)
    {
      k.h(paramFragmentActivity, "activity");
      Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.a.b.a.bv((Activity)paramFragmentActivity);
      StringBuilder localStringBuilder = new StringBuilder("switch2Front: ");
      if (localFragment != null)
      {
        localObject1 = localFragment.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ad.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localFragment == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject2).a(paramFragmentActivity, localFragment, paramLong, 2);
        AppMethodBeat.o(205166);
        return;
      }
    }
    AppMethodBeat.o(205166);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(205167);
    k.h(paramFragmentActivity, "activity");
    Object localObject1 = this.KGm;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES == null) {
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
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
        if (localObject4 == null) {
          k.aPZ("statyTimeStaticHome");
        }
        if (!k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject4).DDP, localObject3))
        {
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject3 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          if (!k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).DDP, localObject2)) {}
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject2 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).KHV = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject2 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject3 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).KHV;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject3 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).xBr = (l - ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).KHU);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject2 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).pZX = "143";
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject2 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRn();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).KES;
          if (localObject1 == null) {
            k.aPZ("statyTimeStaticHome");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ad.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
        }
      }
      if (!this.KGl) {
        break label357;
      }
      fRw();
      localObject1 = this.KGm;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, false);
      AppMethodBeat.o(205167);
      return;
    }
    AppMethodBeat.o(205167);
    return;
    label357:
    if ((this.KGi != null) && ((k.g(paramFragmentActivity.getClass().getName(), this.KGi) ^ true)))
    {
      fRw();
      localObject1 = this.KGm;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(205167);
        return;
      }
      AppMethodBeat.o(205167);
      return;
    }
    Object localObject2 = this.KGm;
    if (localObject2 != null)
    {
      k.h(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.a.bv((Activity)paramFragmentActivity);
      localObject4 = new StringBuilder("switch2Back: ");
      if (localObject3 != null)
      {
        localObject1 = localObject3.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ad.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localObject3 == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject2).b(paramFragmentActivity, (Fragment)localObject3, paramLong, 3);
        AppMethodBeat.o(205167);
        return;
      }
    }
    AppMethodBeat.o(205167);
  }
  
  final UIComponentFragment n(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(205163);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.KGp;
      if (paramObject != null)
      {
        paramObject = (UIComponentFragment)paramObject.get();
        AppMethodBeat.o(205163);
        return paramObject;
      }
      AppMethodBeat.o(205163);
      return null;
    }
    try
    {
      paramObject = o(paramObject, paramInt);
      AppMethodBeat.o(205163);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.KGp;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$Companion;", "", "()V", "DESC_onFragmentChange_1", "", "DESC_onFragmentChange_2", "HEADER", "NAME_FinderFragmentChangeObserver", "NAME_activity", "NAME_fragments", "NAME_onFragmentChange_1", "NAME_onFragmentChange_2", "SUPER", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205162);
      if ((paramString1 == null) || (!n.mA(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$")))
      {
        AppMethodBeat.o(205162);
        return;
      }
      if ((k.g("onUserVisibleFragmentChange", paramString2)) && (k.g("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
        {
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(205162);
            throw paramString1;
          }
          boolean bool = ((Boolean)paramString1).booleanValue();
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(205162);
            throw paramString1;
          }
          int i = ((Integer)paramString1).intValue();
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
            AppMethodBeat.o(205162);
            throw paramString1;
          }
          paramString1 = (UIComponentFragment)paramString1;
          if (bool)
          {
            if (i == b.a(this.KGu))
            {
              b.a(this.KGu, new WeakReference(paramString1));
              AppMethodBeat.o(205162);
            }
          }
          else
          {
            if (i == b.b(this.KGu)) {
              b.b(this.KGu, new WeakReference(paramString1));
            }
            AppMethodBeat.o(205162);
          }
        }
      }
      else if ((k.g("onFragmentChange", paramString2)) && (k.g("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = this.KGu;
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205162);
          throw paramString1;
        }
        b.b(paramString1, ((Integer)paramString2).intValue());
        paramString1 = this.KGu;
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205162);
          throw paramString1;
        }
        b.a(paramString1, ((Integer)paramString2).intValue());
        if (paramObject != null)
        {
          paramString3 = b.a(this.KGu, paramObject, b.a(this.KGu));
          paramArrayOfObject = b.b(this.KGu, paramObject, b.b(this.KGu));
          paramString1 = b.a(this.KGu, paramObject);
          b.a(this.KGu, paramString1);
          paramObject = b.c(this.KGu);
          if (paramObject != null)
          {
            MMActivity localMMActivity = (MMActivity)paramString1;
            if (localMMActivity != null)
            {
              label461:
              long l;
              if (paramString3 != null)
              {
                paramString1 = paramString3.getClass();
                if (paramString1 != null)
                {
                  paramString1 = paramString1.getName();
                  if (paramArrayOfObject == null) {
                    break label605;
                  }
                  paramString2 = paramArrayOfObject.getClass();
                  if (paramString2 == null) {
                    break label605;
                  }
                  paramString2 = paramString2.getName();
                  if ((!k.g(paramString1, paramString2)) || (paramString1 == null))
                  {
                    l = System.currentTimeMillis();
                    paramString2 = new StringBuilder("switchFragment, cur=");
                    if (paramString3 == null) {
                      break label610;
                    }
                    paramString1 = paramString3.getClass();
                    if (paramString1 == null) {
                      break label610;
                    }
                    paramString1 = paramString1.getName();
                    label506:
                    paramString2 = paramString2.append(paramString1).append(", last=");
                    if (paramArrayOfObject == null) {
                      break label615;
                    }
                    paramString1 = paramArrayOfObject.getClass();
                    if (paramString1 == null) {
                      break label615;
                    }
                  }
                }
              }
              label605:
              label610:
              label615:
              for (paramString1 = paramString1.getName();; paramString1 = null)
              {
                ad.i("HABBYGE-MALI.FinderHomeMonitor", paramString1);
                if (paramArrayOfObject != null) {
                  paramObject.b((FragmentActivity)localMMActivity, (Fragment)paramArrayOfObject, l, 1);
                }
                if (paramString3 != null) {
                  paramObject.a((FragmentActivity)localMMActivity, (Fragment)paramString3, l, 0);
                }
                AppMethodBeat.o(205162);
                return;
                paramString1 = null;
                break;
                paramString2 = null;
                break label461;
                paramString1 = null;
                break label506;
              }
            }
          }
        }
      }
      AppMethodBeat.o(205162);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */