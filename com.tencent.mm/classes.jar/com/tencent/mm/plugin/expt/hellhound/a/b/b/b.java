package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroidx/fragment/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroidx/fragment/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a wkd;
  private Field field_activity;
  private Field field_fragments;
  int lL;
  String wjS;
  String wjT;
  boolean wjU;
  boolean wjV;
  com.tencent.mm.plugin.expt.hellhound.a.b.b wjW;
  WeakReference<UIComponentActivity> wjX;
  private WeakReference<UIComponentFragment> wjY;
  private WeakReference<UIComponentFragment> wjZ;
  private int wka;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> wkb;
  final b wkc;
  
  static
  {
    AppMethodBeat.i(257908);
    wkd = new b.a((byte)0);
    AppMethodBeat.o(257908);
  }
  
  public b()
  {
    AppMethodBeat.i(257906);
    this.wjV = true;
    this.wka = -1;
    this.lL = -1;
    this.wkb = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.wkb).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver");
      p.j(localObject, "Class.forName(NAME_FinderFragmentChangeObserver)");
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
    this.lL = -1;
    this.wjS = null;
    this.wjT = null;
    this.wjU = false;
    this.wjV = true;
    this.wjW = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
    this.wkc = new b(this);
    AppMethodBeat.o(257906);
  }
  
  private final UIComponentActivity dd(Object paramObject)
  {
    AppMethodBeat.i(257901);
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
        AppMethodBeat.o(257901);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(257901);
      return paramObject;
      paramObject = null;
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final void ddA()
  {
    this.wjV = false;
    this.wjS = null;
  }
  
  private final void ddz()
  {
    this.wjU = false;
    this.wjT = null;
    this.wjS = null;
  }
  
  private final UIComponentFragment q(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(257900);
    if (paramInt < 0)
    {
      AppMethodBeat.o(257900);
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
        AppMethodBeat.o(257900);
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
      AppMethodBeat.o(257900);
      return paramObject;
      paramObject = null;
      break;
      label105:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(257900);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(257903);
    p.k(paramFragmentActivity, "activity");
    Object localObject1 = this.wjW;
    if (localObject1 != null)
    {
      p.k(paramFragmentActivity, "activity");
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
      if (localObject2 == null) {
        p.bGy("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).sessionId = c.deO().dbr();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
      if (localObject2 == null) {
        p.bGy("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramFragmentActivity.getClass().getName());
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
      if (localObject2 == null) {
        p.bGy("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmx = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
      if (localObject2 == null) {
        p.bGy("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmA = "143";
      localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
      if (localObject1 == null) {
        p.bGy("statyTimeStaticHome");
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1).fSe = c.b.wkW.value;
      Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
    }
    if ((this.wjT != null) && ((p.h(paramFragmentActivity.getClass().getName(), this.wjT) ^ true)) && (!this.wjU))
    {
      ddz();
      localObject1 = this.wjW;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, true);
        AppMethodBeat.o(257903);
        return;
      }
      AppMethodBeat.o(257903);
      return;
    }
    if (this.wjU)
    {
      ddz();
      AppMethodBeat.o(257903);
      return;
    }
    Object localObject2 = this.wjW;
    if (localObject2 != null)
    {
      p.k(paramFragmentActivity, "activity");
      Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.a.b.b.af((Activity)paramFragmentActivity);
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
        AppMethodBeat.o(257903);
        return;
      }
    }
    AppMethodBeat.o(257903);
  }
  
  public final void c(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(257904);
    p.k(paramFragmentActivity, "activity");
    Object localObject1 = this.wjW;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy == null) {
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
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
        if (localObject4 == null) {
          p.bGy("statyTimeStaticHome");
        }
        if (!p.h(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject4).fFe, localObject3))
        {
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject3 == null) {
            p.bGy("statyTimeStaticHome");
          }
          if (!p.h(((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).fFe, localObject2)) {}
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject2 == null) {
            p.bGy("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmy = paramLong;
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject2 == null) {
            p.bGy("statyTimeStaticHome");
          }
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject3 == null) {
            p.bGy("statyTimeStaticHome");
          }
          long l = ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).wmy;
          localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject3 == null) {
            p.bGy("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmw = (l - ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject3).wmx);
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject2 == null) {
            p.bGy("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmA = "143";
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject2 == null) {
            p.bGy("statyTimeStaticHome");
          }
          ((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject2).wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dcu();
          localObject2 = a.wmq;
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).wiy;
          if (localObject1 == null) {
            p.bGy("statyTimeStaticHome");
          }
          a.a.a((com.tencent.mm.plugin.expt.hellhound.a.b.c.b)localObject1);
          Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
        }
      }
      if (!this.wjV) {
        break label357;
      }
      ddA();
      localObject1 = this.wjW;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
      AppMethodBeat.o(257904);
      return;
    }
    AppMethodBeat.o(257904);
    return;
    label357:
    if ((this.wjS != null) && ((p.h(paramFragmentActivity.getClass().getName(), this.wjS) ^ true)))
    {
      ddA();
      localObject1 = this.wjW;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.a.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(257904);
        return;
      }
      AppMethodBeat.o(257904);
      return;
    }
    Object localObject2 = this.wjW;
    if (localObject2 != null)
    {
      p.k(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.af((Activity)paramFragmentActivity);
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
        AppMethodBeat.o(257904);
        return;
      }
    }
    AppMethodBeat.o(257904);
  }
  
  final UIComponentFragment p(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(257899);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.wjZ;
      if (paramObject != null)
      {
        paramObject = (UIComponentFragment)paramObject.get();
        AppMethodBeat.o(257899);
        return paramObject;
      }
      AppMethodBeat.o(257899);
      return null;
    }
    try
    {
      paramObject = q(paramObject, paramInt);
      AppMethodBeat.o(257899);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.wjZ;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(256491);
      if ((paramString1 == null) || (!n.M(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", false)))
      {
        AppMethodBeat.o(256491);
        return;
      }
      if ((p.h("onUserVisibleFragmentChange", paramString2)) && (p.h("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
        {
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(256491);
            throw paramString1;
          }
          boolean bool = ((Boolean)paramString1).booleanValue();
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(256491);
            throw paramString1;
          }
          int i = ((Integer)paramString1).intValue();
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
            AppMethodBeat.o(256491);
            throw paramString1;
          }
          paramString1 = (UIComponentFragment)paramString1;
          if (bool)
          {
            if (i == b.a(this.wke))
            {
              b.a(this.wke, new WeakReference(paramString1));
              AppMethodBeat.o(256491);
            }
          }
          else
          {
            if (i == b.b(this.wke)) {
              b.b(this.wke, new WeakReference(paramString1));
            }
            AppMethodBeat.o(256491);
          }
        }
      }
      else if ((p.h("onFragmentChange", paramString2)) && (p.h("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = this.wke;
        paramString2 = paramArrayOfObject[0];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(256491);
          throw paramString1;
        }
        b.b(paramString1, ((Integer)paramString2).intValue());
        paramString1 = this.wke;
        paramString2 = paramArrayOfObject[1];
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(256491);
          throw paramString1;
        }
        b.a(paramString1, ((Integer)paramString2).intValue());
        if (paramObject != null)
        {
          paramString3 = b.a(this.wke, paramObject, b.a(this.wke));
          paramArrayOfObject = b.b(this.wke, paramObject, b.b(this.wke));
          paramString1 = b.a(this.wke, paramObject);
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256491);
            throw paramString1;
          }
          paramObject = (MMActivity)paramString1;
          b.a(this.wke, (UIComponentActivity)paramObject);
          com.tencent.mm.plugin.expt.hellhound.a.b.b localb = b.c(this.wke);
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
                if ((!p.h(paramString1, paramString2)) || (paramString1 == null))
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
              AppMethodBeat.o(256491);
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
      AppMethodBeat.o(256491);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */