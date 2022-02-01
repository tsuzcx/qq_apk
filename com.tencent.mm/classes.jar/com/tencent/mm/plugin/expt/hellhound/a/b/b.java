package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a sCG;
  public WeakReference<Fragment> sCC;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCD;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCE;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b sCF;
  public d szZ;
  
  static
  {
    AppMethodBeat.i(220818);
    sCG = new b.a((byte)0);
    AppMethodBeat.o(220818);
  }
  
  public static Fragment ae(Activity paramActivity)
  {
    AppMethodBeat.i(220812);
    Fragment localFragment2 = h.cOk();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = h.ab(paramActivity);
    }
    AppMethodBeat.o(220812);
    return localFragment1;
  }
  
  private static boolean apn(String paramString)
  {
    AppMethodBeat.i(220815);
    if ((p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(220815);
      return true;
    }
    AppMethodBeat.o(220815);
    return false;
  }
  
  private final void apo(String paramString)
  {
    AppMethodBeat.i(220816);
    this.sCD = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.sCD;
    if (localb == null) {
      p.btv("statyTimeStatic");
    }
    localb.sessionId = c.cPU().cMD();
    localb = this.sCD;
    if (localb == null) {
      p.btv("statyTimeStatic");
    }
    localb.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    paramString = this.sCD;
    if (paramString == null) {
      p.btv("statyTimeStatic");
    }
    paramString.sGC = System.currentTimeMillis();
    paramString = this.sCD;
    if (paramString == null) {
      p.btv("statyTimeStatic");
    }
    paramString.sGF = "143";
    paramString = this.sCD;
    if (paramString == null) {
      p.btv("statyTimeStatic");
    }
    paramString.dYn = c.b.sFb.value;
    AppMethodBeat.o(220816);
  }
  
  private final void app(String paramString)
  {
    AppMethodBeat.i(220817);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    if (cOD())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.sCD;
      if (localb == null) {
        p.btv("statyTimeStatic");
      }
      if (p.j(localb.dMl, paramString))
      {
        paramString = this.sCD;
        if (paramString == null) {
          p.btv("statyTimeStatic");
        }
        paramString.sGD = System.currentTimeMillis();
        paramString = this.sCD;
        if (paramString == null) {
          p.btv("statyTimeStatic");
        }
        localb = this.sCD;
        if (localb == null) {
          p.btv("statyTimeStatic");
        }
        long l = localb.sGD;
        localb = this.sCD;
        if (localb == null) {
          p.btv("statyTimeStatic");
        }
        paramString.sGB = (l - localb.sGC);
        paramString = this.sCD;
        if (paramString == null) {
          p.btv("statyTimeStatic");
        }
        paramString.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNC();
        paramString = this.sCD;
        if (paramString == null) {
          p.btv("statyTimeStatic");
        }
        paramString.sGF = "143";
        paramString = a.sGv;
        paramString = this.sCD;
        if (paramString == null) {
          p.btv("statyTimeStatic");
        }
        a.a.a(paramString);
      }
    }
    AppMethodBeat.o(220817);
  }
  
  private final boolean cOD()
  {
    return ((b)this).sCD != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(220811);
    p.h(paramFragmentActivity, "activity");
    Fragment localFragment = ae((Activity)paramFragmentActivity);
    StringBuilder localStringBuilder = new StringBuilder("switch2Page: ");
    if (paramBoolean)
    {
      localObject = "onResumed";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", ");
      if (localFragment == null) {
        break label112;
      }
      localObject = localFragment.getClass();
      if (localObject == null) {
        break label112;
      }
    }
    label112:
    for (Object localObject = ((Class)localObject).getName();; localObject = null)
    {
      Log.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject);
      if (localFragment != null) {
        break label118;
      }
      AppMethodBeat.o(220811);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(220811);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(220811);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220813);
    this.sCC = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    p.g(str, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    apo(str);
    Object localObject;
    if (apn(str))
    {
      localObject = k.sFY;
      k.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.szZ;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(220813);
      return;
      if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(220813);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220814);
    String str = paramFragment.getClass().getName();
    p.g(str, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    app(str);
    Object localObject;
    if (apn(str))
    {
      localObject = k.sFY;
      k.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.szZ;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(220814);
      return;
      if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(220814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */