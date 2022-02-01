package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "isRegisterMethodMonitorCallback", "lock", "Ljava/lang/Object;", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", "activity", "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroidx/fragment/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroidx/fragment/app/FragmentActivity;", "timestamp", "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a zFV;
  private Field field_activity;
  private Field field_fragments;
  Object lock;
  int mI;
  String zFW;
  String zFX;
  boolean zFY;
  boolean zFZ;
  com.tencent.mm.plugin.expt.hellhound.ext.b.b zGa;
  WeakReference<UIComponentActivity> zGb;
  private WeakReference<UIComponentFragment> zGc;
  private WeakReference<UIComponentFragment> zGd;
  private int zGe;
  boolean zGf;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> zGg;
  final b zGh;
  
  static
  {
    AppMethodBeat.i(300652);
    zFV = new b.a((byte)0);
    AppMethodBeat.o(300652);
  }
  
  public b()
  {
    AppMethodBeat.i(300592);
    this.zFZ = true;
    this.zGe = -1;
    this.mI = -1;
    this.lock = new Object();
    this.zGg = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
    ((List)localObject).add(new Pair("onFragmentChange", "(IIII)V"));
    ((Map)this.zGg).put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", localObject));
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver");
      s.s(localObject, "forName(NAME_FinderFragmentChangeObserver)");
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
        Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)localException, s.X("FinderFragmentCallback reflect crash: ", localException.getMessage()), new Object[0]);
      }
    }
    this.mI = -1;
    this.zFW = null;
    this.zFX = null;
    this.zFY = false;
    this.zFZ = true;
    this.zGa = new com.tencent.mm.plugin.expt.hellhound.ext.b.b();
    this.zGh = new b(this);
    AppMethodBeat.o(300592);
  }
  
  private final void dKi()
  {
    this.zFY = false;
    this.zFX = null;
    this.zFW = null;
  }
  
  private final void dKj()
  {
    this.zFZ = false;
    this.zFW = null;
  }
  
  private final UIComponentActivity fb(Object paramObject)
  {
    AppMethodBeat.i(300607);
    Field localField;
    try
    {
      localField = this.field_activity;
      if (localField == null)
      {
        paramObject = null;
        if (paramObject != null) {
          break label60;
        }
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentActivity");
        AppMethodBeat.o(300607);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(300607);
      return paramObject;
      paramObject = localField.get(paramObject);
      break;
      label60:
      paramObject = (UIComponentActivity)paramObject;
    }
  }
  
  private final UIComponentFragment t(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(300599);
    if (paramInt < 0)
    {
      AppMethodBeat.o(300599);
      return null;
    }
    Field localField;
    try
    {
      localField = this.field_fragments;
      if (localField == null)
      {
        paramObject = null;
        if (paramObject != null) {
          break label95;
        }
        paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
        AppMethodBeat.o(300599);
        throw paramObject;
      }
    }
    catch (Exception paramObject)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", (Throwable)paramObject, s.X("getFragment exception: ", paramObject.getMessage()), new Object[0]);
      paramObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(300599);
      return paramObject;
      paramObject = localField.get(paramObject);
      break;
      label95:
      paramObject = ((List)paramObject).get(paramInt);
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
        AppMethodBeat.o(300599);
        throw paramObject;
      }
      paramObject = (UIComponentFragment)paramObject;
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(300661);
    s.u(paramFragmentActivity, "activity");
    com.tencent.mm.plugin.expt.hellhound.ext.b.b localb = this.zGa;
    Object localObject1;
    if (localb != null)
    {
      s.u(paramFragmentActivity, "activity");
      localb.zEC = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).sessionId = c.dLD().dHN();
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramFragmentActivity.getClass().getName());
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIz = paramLong;
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIC = "143";
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hYb = c.b.zHb.value;
      localObject1 = localb.zEC;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject2 = null;
      }
      localObject1 = paramFragmentActivity.getIntent();
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = "";
    }
    label412:
    Object localObject3;
    for (;;)
    {
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).extraInfo = ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      localObject2 = localb.zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).extraInfo;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      s.u(localObject1, "<set-?>");
      com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.asc((String)localObject1);
      Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
      if ((this.zFX == null) || (s.p(paramFragmentActivity.getClass().getName(), this.zFX)) || (this.zFY)) {
        break;
      }
      dKi();
      localObject1 = this.zGa;
      if (localObject1 == null) {
        break label520;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject1).a(paramFragmentActivity, paramLong, true);
      AppMethodBeat.o(300661);
      return;
      localObject3 = ((Intent)localObject1).getStringExtra("key_extra_info");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
    }
    if (this.zFY)
    {
      dKi();
      AppMethodBeat.o(300661);
      return;
    }
    Object localObject2 = this.zGa;
    if (localObject2 != null)
    {
      s.u(paramFragmentActivity, "activity");
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.an((Activity)paramFragmentActivity);
      if (localObject3 != null) {
        break label527;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Log.d("HABBYGE-MALI.FinderHomeMonitor", s.X("switch2Front: ", localObject1));
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).a(paramFragmentActivity, (Fragment)localObject3, paramLong, 2);
      }
      label520:
      AppMethodBeat.o(300661);
      return;
      label527:
      localObject1 = localObject3.getClass();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((Class)localObject1).getName();
      }
    }
  }
  
  public final void c(FragmentActivity paramFragmentActivity, long paramLong)
  {
    Object localObject3 = null;
    AppMethodBeat.i(300665);
    s.u(paramFragmentActivity, "activity");
    Object localObject5 = this.zGa;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if ((localObject5 != null) && (((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).dKd()))
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH("com.tencent.mm.plugin.finder.ui.FinderHomeUI");
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH("com.tencent.mm.plugin.finder.ui.FinderConversationUI");
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI");
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      if (!s.p(((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hJW, str2))
      {
        localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("statyTimeStaticHome");
          localObject1 = null;
        }
        if (!s.p(((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hJW, str1))
        {
          localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("statyTimeStaticHome");
            localObject1 = null;
          }
          if (!s.p(((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).hJW, localObject4)) {
            break label479;
          }
        }
      }
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIA = paramLong;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      localObject4 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject2 = null;
      }
      long l = ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIA;
      localObject4 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIy = (l - ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject2).zIz);
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIC = "143";
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIY();
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      if (((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).extraInfo == null)
      {
        localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("statyTimeStaticHome");
          localObject1 = null;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).extraInfo = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
      }
      localObject1 = a.zIv;
      localObject2 = ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject5).zEC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("statyTimeStaticHome");
        localObject1 = null;
      }
      a.a.a((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1);
      Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIPause...");
    }
    label479:
    if (this.zFZ)
    {
      dKj();
      localObject1 = this.zGa;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(300665);
      }
    }
    else if ((this.zFW != null) && (!s.p(paramFragmentActivity.getClass().getName(), this.zFW)))
    {
      dKj();
      localObject1 = this.zGa;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject1).a(paramFragmentActivity, paramLong, false);
        AppMethodBeat.o(300665);
      }
    }
    else
    {
      localObject2 = this.zGa;
      if (localObject2 != null)
      {
        s.u(paramFragmentActivity, "activity");
        localObject4 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.an((Activity)paramFragmentActivity);
        if (localObject4 != null) {
          break label641;
        }
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      Log.d("HABBYGE-MALI.FinderHomeMonitor", s.X("switch2Back: ", localObject1));
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.expt.hellhound.ext.b.b)localObject2).b(paramFragmentActivity, (Fragment)localObject4, paramLong, 3);
      }
      AppMethodBeat.o(300665);
      return;
      label641:
      localObject5 = localObject4.getClass();
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = ((Class)localObject5).getName();
      }
    }
  }
  
  final UIComponentFragment s(Object paramObject, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(300655);
    if ((paramObject == null) || (paramInt < 0))
    {
      paramObject = this.zGd;
      if (paramObject == null)
      {
        AppMethodBeat.o(300655);
        return null;
      }
      paramObject = (UIComponentFragment)paramObject.get();
      AppMethodBeat.o(300655);
      return paramObject;
    }
    try
    {
      paramObject = t(paramObject, paramInt);
      AppMethodBeat.o(300655);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        WeakReference localWeakReference = this.zGd;
        paramObject = localObject;
        if (localWeakReference != null) {
          paramObject = (UIComponentFragment)localWeakReference.get();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    b(b paramb) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300559);
      if ((paramString1 == null) || (!n.U(paramString1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", false)))
      {
        AppMethodBeat.o(300559);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.ext.b.b localb;
      label327:
      long l;
      if ((s.p("onUserVisibleFragmentChange", paramString2)) && (s.p("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", paramString3)))
      {
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
        {
          boolean bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
          int i = ((Integer)paramArrayOfObject[1]).intValue();
          paramString1 = (UIComponentFragment)paramArrayOfObject[2];
          if (bool)
          {
            if (i == b.a(this.zGi))
            {
              b.a(this.zGi, new WeakReference(paramString1));
              AppMethodBeat.o(300559);
            }
          }
          else if (i == b.b(this.zGi))
          {
            b.b(this.zGi, new WeakReference(paramString1));
            AppMethodBeat.o(300559);
          }
        }
      }
      else if ((s.p("onFragmentChange", paramString2)) && (s.p("(IIII)V", paramString3)) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        b.a(this.zGi, ((Integer)paramArrayOfObject[0]).intValue());
        b.b(this.zGi, ((Integer)paramArrayOfObject[1]).intValue());
        if (paramObject != null)
        {
          paramString1 = this.zGi;
          paramString3 = b.a(paramString1, paramObject, b.a(paramString1));
          paramArrayOfObject = b.b(paramString1, paramObject, b.b(paramString1));
          paramString2 = b.a(paramString1, paramObject);
          if (paramString2 == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(300559);
            throw paramString1;
          }
          paramObject = (MMActivity)paramString2;
          b.a(paramString1, (UIComponentActivity)paramObject);
          localb = b.c(paramString1);
          if ((localb != null) && (paramObject != null))
          {
            if (paramString3 != null) {
              break label441;
            }
            paramString1 = null;
            if (paramArrayOfObject != null) {
              break label463;
            }
            paramString2 = null;
            if ((!s.p(paramString1, paramString2)) || (paramString1 == null))
            {
              l = System.currentTimeMillis();
              paramString2 = new StringBuilder("switchFragment, cur=");
              if (paramString3 != null) {
                break label486;
              }
              paramString1 = null;
              label360:
              paramString2 = paramString2.append(paramString1).append(", last=");
              if (paramArrayOfObject != null) {
                break label508;
              }
              paramString1 = null;
            }
          }
        }
      }
      for (;;)
      {
        Log.i("HABBYGE-MALI.FinderHomeMonitor", paramString1);
        if (paramArrayOfObject != null) {
          localb.b((FragmentActivity)paramObject, (Fragment)paramArrayOfObject, l, 1);
        }
        if (paramString3 != null) {
          localb.a((FragmentActivity)paramObject, (Fragment)paramString3, l, 0);
        }
        AppMethodBeat.o(300559);
        return;
        label441:
        paramString1 = paramString3.getClass();
        if (paramString1 == null)
        {
          paramString1 = null;
          break;
        }
        paramString1 = paramString1.getName();
        break;
        label463:
        paramString2 = paramArrayOfObject.getClass();
        if (paramString2 == null)
        {
          paramString2 = null;
          break label327;
        }
        paramString2 = paramString2.getName();
        break label327;
        label486:
        paramString1 = paramString3.getClass();
        if (paramString1 == null)
        {
          paramString1 = null;
          break label360;
        }
        paramString1 = paramString1.getName();
        break label360;
        label508:
        paramString1 = paramArrayOfObject.getClass();
        if (paramString1 == null) {
          paramString1 = null;
        } else {
          paramString1 = paramString1.getName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.b
 * JD-Core Version:    0.7.0.1
 */