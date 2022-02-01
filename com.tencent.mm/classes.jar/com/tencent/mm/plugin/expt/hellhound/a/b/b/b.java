package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroid/support/v4/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a qmH;
  int adx;
  private Field field_activity;
  private Field field_fragments;
  com.tencent.mm.plugin.expt.hellhound.a.b.a qmA;
  WeakReference<UIComponentActivity> qmB;
  private WeakReference<UIComponentFragment> qmC;
  private WeakReference<UIComponentFragment> qmD;
  private int qmE;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> qmF;
  final b qmG;
  String qmw;
  String qmx;
  boolean qmy;
  boolean qmz;
  
  static
  {
    AppMethodBeat.i(195428);
    qmH = new b.a((byte)0);
    AppMethodBeat.o(195428);
  }
  
  public b()
  {
    AppMethodBeat.i(195427);
    this.qmz = true;
    this.qmE = -1;
    this.adx = -1;
    this.qmF = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
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
        ac.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)localException, "FinderFragmentCallback reflect crash: " + localException.getMessage(), new Object[0]);
      }
    }
    this.adx = -1;
    this.qmw = null;
    this.qmx = null;
    this.qmy = false;
    this.qmz = true;
    this.qmA = new com.tencent.mm.plugin.expt.hellhound.a.b.a();
    this.qmG = new b(this);
    AppMethodBeat.o(195427);
  }
  
  private final UIComponentActivity cU(Object paramObject)
  {
    AppMethodBeat.i(195424);
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
        AppMethodBeat.o(195424);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(195424);
      return paramObject;
      paramObject = null;
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final void cjC()
  {
    this.qmy = false;
    this.qmx = null;
    this.qmw = null;
  }
  
  private final void cjD()
  {
    this.qmz = false;
    this.qmw = null;
  }
  
  private final UIComponentFragment j(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(195423);
    if (paramInt < 0)
    {
      AppMethodBeat.o(195423);
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
        AppMethodBeat.o(195423);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      ac.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)paramObject, "getFragment exception: " + paramObject.getMessage(), new Object[0]);
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(195423);
      return paramObject;
      paramObject = null;
      break;
      label105:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(195423);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(195425);
    k.h(paramFragmentActivity, "activity");
    Object localObject1 = this.qmA;
    if (localObject1 != null)
    {
      k.h(paramFragmentActivity, "activity");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
      if (localObject2 == null) {
        k.aVY("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
      if (localObject2 == null) {
        k.aVY("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramFragmentActivity.getClass().getName());
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
      if (localObject2 == null) {
        k.aVY("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qok = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
      if (localObject2 == null) {
        k.aVY("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qon = "143";
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
      if (localObject1 == null) {
        k.aVY("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dtw = c.b.qnb.value;
      ac.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
    }
    if ((this.qmx != null) && ((k.g(paramFragmentActivity.getClass().getName(), this.qmx) ^ true)) && (!this.qmy))
    {
      cjC();
      localObject1 = this.qmA;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, true);
        AppMethodBeat.o(195425);
        return;
      }
      AppMethodBeat.o(195425);
      return;
    }
    if (this.qmy)
    {
      cjC();
      AppMethodBeat.o(195425);
      return;
    }
    Object localObject2 = this.qmA;
    if (localObject2 != null)
    {
      k.h(paramFragmentActivity, "activity");
      Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.a.b.a.ah((Activity)paramFragmentActivity);
      StringBuilder localStringBuilder = new StringBuilder("switch2Front: ");
      if (localFragment != null)
      {
        localObject1 = localFragment.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ac.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localFragment == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject2).a(paramFragmentActivity, localFragment, paramLong, 2);
        AppMethodBeat.o(195425);
        return;
      }
    }
    AppMethodBeat.o(195425);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(195426);
    k.h(paramFragmentActivity, "activity");
    Object localObject1 = this.qmA;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld == null) {
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
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
        if (localObject4 == null) {
          k.aVY("statyTimeStaticHome");
        }
        if (!k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject4).qoi, localObject3))
        {
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject3 == null) {
            k.aVY("statyTimeStaticHome");
          }
          if (!k.g(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qoi, localObject2)) {}
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject2 == null) {
            k.aVY("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qol = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject2 == null) {
            k.aVY("statyTimeStaticHome");
          }
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject3 == null) {
            k.aVY("statyTimeStaticHome");
          }
          long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qol;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject3 == null) {
            k.aVY("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qoj = (l - ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).qok);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject2 == null) {
            k.aVY("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qon = "143";
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject2 == null) {
            k.aVY("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciJ();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).qld;
          if (localObject1 == null) {
            k.aVY("statyTimeStaticHome");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ac.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
        }
      }
      if (!this.qmz) {
        break label357;
      }
      cjD();
      localObject1 = this.qmA;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, false);
      AppMethodBeat.o(195426);
      return;
    }
    AppMethodBeat.o(195426);
    return;
    label357:
    if ((this.qmw != null) && ((k.g(paramFragmentActivity.getClass().getName(), this.qmw) ^ true)))
    {
      cjD();
      localObject1 = this.qmA;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(195426);
        return;
      }
      AppMethodBeat.o(195426);
      return;
    }
    Object localObject2 = this.qmA;
    if (localObject2 != null)
    {
      k.h(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.a.ah((Activity)paramFragmentActivity);
      localObject4 = new StringBuilder("switch2Back: ");
      if (localObject3 != null)
      {
        localObject1 = localObject3.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ac.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localObject3 == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.a)localObject2).b(paramFragmentActivity, (Fragment)localObject3, paramLong, 3);
        AppMethodBeat.o(195426);
        return;
      }
    }
    AppMethodBeat.o(195426);
  }
  
  final UIComponentFragment i(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(195422);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.qmD;
      if (paramObject != null)
      {
        paramObject = (UIComponentFragment)paramObject.get();
        AppMethodBeat.o(195422);
        return paramObject;
      }
      AppMethodBeat.o(195422);
      return null;
    }
    try
    {
      paramObject = j(paramObject, paramInt);
      AppMethodBeat.o(195422);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.qmD;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195421);
      if ((paramString1 == null) || (!n.nb(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$")))
      {
        AppMethodBeat.o(195421);
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
            AppMethodBeat.o(195421);
            throw paramString1;
          }
          boolean bool = ((Boolean)paramString1).booleanValue();
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(195421);
            throw paramString1;
          }
          int i = ((Integer)paramString1).intValue();
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
            AppMethodBeat.o(195421);
            throw paramString1;
          }
          paramString1 = (UIComponentFragment)paramString1;
          if (bool)
          {
            if (i == b.a(this.qmI))
            {
              b.a(this.qmI, new WeakReference(paramString1));
              AppMethodBeat.o(195421);
            }
          }
          else
          {
            if (i == b.b(this.qmI)) {
              b.b(this.qmI, new WeakReference(paramString1));
            }
            AppMethodBeat.o(195421);
          }
        }
      }
      else if ((k.g("onFragmentChange", paramString2)) && (k.g("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = this.qmI;
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(195421);
          throw paramString1;
        }
        b.b(paramString1, ((Integer)paramString2).intValue());
        paramString1 = this.qmI;
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(195421);
          throw paramString1;
        }
        b.a(paramString1, ((Integer)paramString2).intValue());
        if (paramObject != null)
        {
          paramString3 = b.a(this.qmI, paramObject, b.a(this.qmI));
          paramArrayOfObject = b.b(this.qmI, paramObject, b.b(this.qmI));
          paramString1 = b.a(this.qmI, paramObject);
          b.a(this.qmI, paramString1);
          paramObject = b.c(this.qmI);
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
                ac.i("HABBYGE-MALI.FinderHomeMonitor", paramString1);
                if (paramArrayOfObject != null) {
                  paramObject.b((FragmentActivity)localMMActivity, (Fragment)paramArrayOfObject, l, 1);
                }
                if (paramString3 != null) {
                  paramObject.a((FragmentActivity)localMMActivity, (Fragment)paramString3, l, 0);
                }
                AppMethodBeat.o(195421);
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
      AppMethodBeat.o(195421);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */