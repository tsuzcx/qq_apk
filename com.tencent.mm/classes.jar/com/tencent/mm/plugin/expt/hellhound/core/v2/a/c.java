package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import a.f.b.j;
import a.l;
import a.o;
import a.v;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "Ljava/lang/reflect/InvocationHandler;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "LauncherUI_Class", "Ljava/lang/Class;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mLastFragmentIndex", "", "mLauncherUI", "Landroid/support/v4/app/FragmentActivity;", "mTabsAdapte_Orignal", "", "_doMonitor4MMFragmentActivity", "", "mmfActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "_doMonitorViewPagerEvent", "_getCurFragmentFromBusiness", "Lkotlin/Pair;", "Landroid/support/v4/app/Fragment;", "fm", "Landroid/support/v4/app/FragmentManager;", "index", "doMonitor4MMFragmentActivity", "mmfa", "fragmentPauseCallback", "fa", "getIndex", "args", "", "([Ljava/lang/Object;)I", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "monitor", "", "launcherUI", "onPageSelected", "([Ljava/lang/Object;)V", "unmonitor", "LauncherUI", "Companion", "plugin-expt_release"})
public final class c
  implements InvocationHandler
{
  public static final c.a mar;
  d mai;
  Class<?> mal;
  a mam;
  FragmentActivity man;
  private int mao;
  private Object maq;
  
  static
  {
    AppMethodBeat.i(152500);
    mar = new c.a((byte)0);
    AppMethodBeat.o(152500);
  }
  
  public c(d paramd)
  {
    AppMethodBeat.i(152499);
    this.mai = paramd;
    try
    {
      paramd = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
      this.mal = a.a.getClass("com.tencent.mm.ui.LauncherUI");
      this.mam = new a(this.mai);
      AppMethodBeat.o(152499);
      return;
    }
    catch (Exception paramd)
    {
      ab.printErrStackTrace("FragmentLauncherUIMonitor", (Throwable)paramd, "habbyge-mali, FragmentLauncherUIMonitor", new Object[0]);
      AppMethodBeat.o(152499);
    }
  }
  
  final void brR()
  {
    Object localObject5 = null;
    AppMethodBeat.i(156197);
    Object localObject3;
    label190:
    Object localObject2;
    for (;;)
    {
      try
      {
        ab.i("FragmentLauncherUIMonitor", "habbyge-mali, _doMonitorViewPagerEvent");
        Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
        localObject1 = a.a.a(this.mal, "getInstance", null);
        if (localObject1 == null)
        {
          AppMethodBeat.o(156197);
          return;
        }
        localObject3 = ((Method)localObject1).invoke(null, new Object[0]);
        localObject1 = this.mal;
        if (localObject1 == null) {
          break label190;
        }
        localObject1 = ((Class)localObject1).getDeclaredMethod("getHomeUI", new Class[0]);
        if (localObject1 != null) {
          ((Method)localObject1).setAccessible(true);
        }
        if (localObject1 == null) {
          break label195;
        }
        localObject1 = ((Method)localObject1).invoke(localObject3, new Object[0]);
        if (localObject1 == null) {
          break label200;
        }
        localObject3 = localObject1.getClass();
        if (localObject3 == null) {
          break label200;
        }
        localObject3 = ((Class)localObject3).getDeclaredMethod("getMainTabUI", new Class[0]);
        if (localObject3 != null) {
          ((Method)localObject3).setAccessible(true);
        }
        if (localObject3 == null) {
          break label206;
        }
        localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
        localObject3 = Class.forName("com.tencent.mm.ui.MainTabUI$TabsAdapter");
        if (localObject3 != null) {
          break;
        }
        AppMethodBeat.o(156197);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("FragmentLauncherUIMonitor", (Throwable)localException, "habbyge-mali, _doMonitorViewPagerEvent, Crash", new Object[0]);
      }
      AppMethodBeat.o(156197);
      return;
      localObject2 = null;
      continue;
      label195:
      localObject2 = null;
      continue;
      label200:
      localObject3 = null;
      continue;
      label206:
      localObject2 = null;
    }
    Object localObject6 = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH.ak((Class)localObject3);
    if (localObject6 == null)
    {
      AppMethodBeat.o(156197);
      return;
    }
    Object localObject4 = new Class[((ArrayList)localObject6).size()];
    int j = localObject4.length;
    int i = 0;
    while (i < j)
    {
      localObject4[i] = ((Class)((ArrayList)localObject6).get(i));
      i += 1;
    }
    localObject6 = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
    localObject6 = a.a.a(((Class)localObject3).getClassLoader(), (Class[])localObject4, (InvocationHandler)this);
    localObject4 = Class.forName("com.tencent.mm.ui.MainTabUI");
    if (localObject4 != null)
    {
      localObject3 = ((Class)localObject4).getDeclaredField("mTabsAdapter");
      label315:
      if (localObject3 != null) {
        ((Field)localObject3).setAccessible(true);
      }
      if (localObject3 == null) {
        break label546;
      }
      localObject3 = ((Field)localObject3).get(localObject2);
      label339:
      this.maq = localObject3;
      if (localObject4 == null) {
        break label552;
      }
    }
    label546:
    label552:
    for (localObject4 = ((Class)localObject4).getDeclaredField("mViewPager");; localObject4 = null)
    {
      if (localObject4 != null) {
        ((Field)localObject4).setAccessible(true);
      }
      localObject3 = localObject5;
      if (localObject4 != null) {
        localObject3 = ((Field)localObject4).get(localObject2);
      }
      localObject2 = Class.forName("com.tencent.mm.ui.mogic.WxViewPager");
      if (localObject2 != null)
      {
        localObject4 = ((Class)localObject2).getDeclaredMethod("getCurrentItem", new Class[0]);
        if (localObject4 != null) {}
      }
      else
      {
        AppMethodBeat.o(156197);
        return;
      }
      ((Method)localObject4).setAccessible(true);
      if (localObject3 != null)
      {
        localObject4 = ((Method)localObject4).invoke(localObject3, new Object[0]);
        if (localObject4 == null)
        {
          localObject2 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(156197);
          throw ((Throwable)localObject2);
        }
        this.mao = ((Integer)localObject4).intValue();
      }
      localObject2 = ((Class)localObject2).getDeclaredMethod("setOnPageChangeListener", new Class[] { ViewPager.OnPageChangeListener.class });
      if (localObject2 != null) {
        ((Method)localObject2).setAccessible(true);
      }
      if (localObject3 == null) {
        break;
      }
      if (localObject2 != null)
      {
        ((Method)localObject2).invoke(localObject3, new Object[] { localObject6 });
        AppMethodBeat.o(156197);
        return;
      }
      AppMethodBeat.o(156197);
      return;
      localObject3 = null;
      break label315;
      localObject3 = null;
      break label339;
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int i = -1;
    d locald = null;
    AppMethodBeat.i(152498);
    if (paramMethod != null)
    {
      paramObject = paramMethod.getName();
      if (paramObject != null) {}
    }
    else
    {
      AppMethodBeat.o(152498);
      return null;
    }
    Object localObject;
    if (j.e("onPageSelected", paramObject))
    {
      ab.i("FragmentLauncherUIMonitor", "habbyge-mali, onPageSelected");
      if (paramArrayOfObject == null)
      {
        paramObject = this.man;
        if (paramObject == null) {
          break label197;
        }
        localObject = paramObject.getSupportFragmentManager();
        label66:
        paramObject = locald;
        if (localObject != null)
        {
          localObject = ((g)localObject).getFragments();
          if (localObject != null) {
            break label203;
          }
          paramObject = locald;
        }
        label89:
        if (paramObject != null) {
          break label257;
        }
      }
    }
    else
    {
      try
      {
        label93:
        paramObject = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
        paramObject = a.a.a(this.maq, paramMethod, paramArrayOfObject);
        AppMethodBeat.o(152498);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        ab.printErrStackTrace("FragmentLauncherUIMonitor", (Throwable)paramObject, "FragmentLauncherUIMonitor invokeMethod crash ", new Object[0]);
        paramObject = new Object();
        AppMethodBeat.o(152498);
        return paramObject;
      }
    }
    int j = paramArrayOfObject.length;
    i = 0;
    label153:
    if (i < j)
    {
      paramObject = paramArrayOfObject[i];
      if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    }
    for (i = ((Number)paramObject).intValue();; i = -1)
    {
      break;
      i += 1;
      break label153;
      label197:
      localObject = null;
      break label66;
      label203:
      j.p(localObject, "fm?.fragments ?: return null");
      paramObject = locald;
      if (((List)localObject).size() <= i) {
        break label89;
      }
      paramObject = new o(((List)localObject).get(this.mao), ((List)localObject).get(i));
      break label89;
      label257:
      this.mao = i;
      localObject = (Fragment)paramObject.first;
      paramObject = (Fragment)paramObject.second;
      if (localObject != null)
      {
        locald = this.mai;
        if (locald != null) {
          locald.b(this.man, localObject.getClass().getCanonicalName());
        }
      }
      if (paramObject == null) {
        break label93;
      }
      b.Q(paramObject.getArguments());
      localObject = this.mai;
      if (localObject == null) {
        break label93;
      }
      ((d)localObject).a(this.man, paramObject.getClass().getCanonicalName());
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.c
 * JD-Core Version:    0.7.0.1
 */