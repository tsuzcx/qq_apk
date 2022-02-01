package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroid/support/v4/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a rdC;
  int afo;
  private Field field_activity;
  private Field field_fragments;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> rdA;
  final b rdB;
  String rdr;
  String rds;
  boolean rdt;
  boolean rdu;
  com.tencent.mm.plugin.expt.hellhound.a.b.b rdv;
  WeakReference<UIComponentActivity> rdw;
  private WeakReference<UIComponentFragment> rdx;
  private WeakReference<UIComponentFragment> rdy;
  private int rdz;
  
  static
  {
    AppMethodBeat.i(196442);
    rdC = new b.a((byte)0);
    AppMethodBeat.o(196442);
  }
  
  public b()
  {
    AppMethodBeat.i(196441);
    this.rdu = true;
    this.rdz = -1;
    this.afo = -1;
    this.rdA = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.rdA).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
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
        ae.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)localException, "FinderFragmentCallback reflect crash: " + localException.getMessage(), new Object[0]);
      }
    }
    this.afo = -1;
    this.rdr = null;
    this.rds = null;
    this.rdt = false;
    this.rdu = true;
    this.rdv = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
    this.rdB = new b(this);
    AppMethodBeat.o(196441);
  }
  
  private final UIComponentActivity cZ(Object paramObject)
  {
    AppMethodBeat.i(196438);
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
        AppMethodBeat.o(196438);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(196438);
      return paramObject;
      paramObject = null;
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final void cqp()
  {
    this.rdt = false;
    this.rds = null;
    this.rdr = null;
  }
  
  private final void cqq()
  {
    this.rdu = false;
    this.rdr = null;
  }
  
  private final UIComponentFragment k(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(196437);
    if (paramInt < 0)
    {
      AppMethodBeat.o(196437);
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
        AppMethodBeat.o(196437);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)paramObject, "getFragment exception: " + paramObject.getMessage(), new Object[0]);
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(196437);
      return paramObject;
      paramObject = null;
      break;
      label105:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(196437);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(196439);
    p.h(paramFragmentActivity, "activity");
    Object localObject1 = this.rdv;
    if (localObject1 != null)
    {
      p.h(paramFragmentActivity, "activity");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
      if (localObject2 == null) {
        p.bdF("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
      if (localObject2 == null) {
        p.bdF("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramFragmentActivity.getClass().getName());
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
      if (localObject2 == null) {
        p.bdF("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfm = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
      if (localObject2 == null) {
        p.bdF("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfp = "143";
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
      if (localObject1 == null) {
        p.bdF("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).dGC = c.b.rdY.value;
      ae.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
    }
    if ((this.rds != null) && ((p.i(paramFragmentActivity.getClass().getName(), this.rds) ^ true)) && (!this.rdt))
    {
      cqp();
      localObject1 = this.rdv;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, true);
        AppMethodBeat.o(196439);
        return;
      }
      AppMethodBeat.o(196439);
      return;
    }
    if (this.rdt)
    {
      cqp();
      AppMethodBeat.o(196439);
      return;
    }
    Object localObject2 = this.rdv;
    if (localObject2 != null)
    {
      p.h(paramFragmentActivity, "activity");
      Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.a.b.b.ai((Activity)paramFragmentActivity);
      StringBuilder localStringBuilder = new StringBuilder("switch2Front: ");
      if (localFragment != null)
      {
        localObject1 = localFragment.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ae.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localFragment == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject2).a(paramFragmentActivity, localFragment, paramLong, 2);
        AppMethodBeat.o(196439);
        return;
      }
    }
    AppMethodBeat.o(196439);
  }
  
  public final void c(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(196440);
    p.h(paramFragmentActivity, "activity");
    Object localObject1 = this.rdv;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY == null) {
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
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
        if (localObject4 == null) {
          p.bdF("statyTimeStaticHome");
        }
        if (!p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject4).duQ, localObject3))
        {
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject3 == null) {
            p.bdF("statyTimeStaticHome");
          }
          if (!p.i(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).duQ, localObject2)) {}
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject2 == null) {
            p.bdF("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfn = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject2 == null) {
            p.bdF("statyTimeStaticHome");
          }
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject3 == null) {
            p.bdF("statyTimeStaticHome");
          }
          long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).rfn;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject3 == null) {
            p.bdF("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfl = (l - ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).rfm);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject2 == null) {
            p.bdF("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfp = "143";
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject2 == null) {
            p.bdF("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpj();
          localObject2 = a.rff;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).rbY;
          if (localObject1 == null) {
            p.bdF("statyTimeStaticHome");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          ae.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
        }
      }
      if (!this.rdu) {
        break label357;
      }
      cqq();
      localObject1 = this.rdv;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
      AppMethodBeat.o(196440);
      return;
    }
    AppMethodBeat.o(196440);
    return;
    label357:
    if ((this.rdr != null) && ((p.i(paramFragmentActivity.getClass().getName(), this.rdr) ^ true)))
    {
      cqq();
      localObject1 = this.rdv;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(196440);
        return;
      }
      AppMethodBeat.o(196440);
      return;
    }
    Object localObject2 = this.rdv;
    if (localObject2 != null)
    {
      p.h(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.ai((Activity)paramFragmentActivity);
      localObject4 = new StringBuilder("switch2Back: ");
      if (localObject3 != null)
      {
        localObject1 = localObject3.getClass();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Class)localObject1).getName();; localObject1 = null)
      {
        ae.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject1);
        if (localObject3 == null) {
          break;
        }
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject2).b(paramFragmentActivity, (Fragment)localObject3, paramLong, 3);
        AppMethodBeat.o(196440);
        return;
      }
    }
    AppMethodBeat.o(196440);
  }
  
  final UIComponentFragment j(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(196436);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.rdy;
      if (paramObject != null)
      {
        paramObject = (UIComponentFragment)paramObject.get();
        AppMethodBeat.o(196436);
        return paramObject;
      }
      AppMethodBeat.o(196436);
      return null;
    }
    try
    {
      paramObject = k(paramObject, paramInt);
      AppMethodBeat.o(196436);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.rdy;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196435);
      if ((paramString1 == null) || (!n.nF(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$")))
      {
        AppMethodBeat.o(196435);
        return;
      }
      if ((p.i("onUserVisibleFragmentChange", paramString2)) && (p.i("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
        {
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(196435);
            throw paramString1;
          }
          boolean bool = ((Boolean)paramString1).booleanValue();
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196435);
            throw paramString1;
          }
          int i = ((Integer)paramString1).intValue();
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
            AppMethodBeat.o(196435);
            throw paramString1;
          }
          paramString1 = (UIComponentFragment)paramString1;
          if (bool)
          {
            if (i == b.a(this.rdD))
            {
              b.a(this.rdD, new WeakReference(paramString1));
              AppMethodBeat.o(196435);
            }
          }
          else
          {
            if (i == b.b(this.rdD)) {
              b.b(this.rdD, new WeakReference(paramString1));
            }
            AppMethodBeat.o(196435);
          }
        }
      }
      else if ((p.i("onFragmentChange", paramString2)) && (p.i("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = this.rdD;
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(196435);
          throw paramString1;
        }
        b.b(paramString1, ((Integer)paramString2).intValue());
        paramString1 = this.rdD;
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(196435);
          throw paramString1;
        }
        b.a(paramString1, ((Integer)paramString2).intValue());
        if (paramObject != null)
        {
          paramString3 = b.a(this.rdD, paramObject, b.a(this.rdD));
          paramArrayOfObject = b.b(this.rdD, paramObject, b.b(this.rdD));
          paramString1 = b.a(this.rdD, paramObject);
          b.a(this.rdD, paramString1);
          paramObject = b.c(this.rdD);
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
                  if ((!p.i(paramString1, paramString2)) || (paramString1 == null))
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
                ae.i("HABBYGE-MALI.FinderHomeMonitor", paramString1);
                if (paramArrayOfObject != null) {
                  paramObject.b((FragmentActivity)localMMActivity, (Fragment)paramArrayOfObject, l, 1);
                }
                if (paramString3 != null) {
                  paramObject.a((FragmentActivity)localMMActivity, (Fragment)paramString3, l, 0);
                }
                AppMethodBeat.o(196435);
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
      AppMethodBeat.o(196435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */