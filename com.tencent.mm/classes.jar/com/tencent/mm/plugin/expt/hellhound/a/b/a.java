package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a qlf;
  public d qjC;
  public WeakReference<Fragment> qlb;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b qlc;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qld;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qle;
  
  static
  {
    AppMethodBeat.i(195339);
    qlf = new a.a((byte)0);
    AppMethodBeat.o(195339);
  }
  
  private static boolean aap(String paramString)
  {
    AppMethodBeat.i(195336);
    if ((k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(195336);
      return true;
    }
    AppMethodBeat.o(195336);
    return false;
  }
  
  private final void aaq(String paramString)
  {
    AppMethodBeat.i(195337);
    this.qlc = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.qlc;
    if (localb == null) {
      k.aVY("statyTimeStatic");
    }
    localb.sessionId = c.cku().cit();
    localb = this.qlc;
    if (localb == null) {
      k.aVY("statyTimeStatic");
    }
    localb.qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    paramString = this.qlc;
    if (paramString == null) {
      k.aVY("statyTimeStatic");
    }
    paramString.qok = System.currentTimeMillis();
    paramString = this.qlc;
    if (paramString == null) {
      k.aVY("statyTimeStatic");
    }
    paramString.qon = "143";
    paramString = this.qlc;
    if (paramString == null) {
      k.aVY("statyTimeStatic");
    }
    paramString.dtw = c.b.qnb.value;
    AppMethodBeat.o(195337);
  }
  
  private final void aar(String paramString)
  {
    AppMethodBeat.i(195338);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    if (cjw())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.qlc;
      if (localb == null) {
        k.aVY("statyTimeStatic");
      }
      if (k.g(localb.qoi, paramString))
      {
        paramString = this.qlc;
        if (paramString == null) {
          k.aVY("statyTimeStatic");
        }
        paramString.qol = System.currentTimeMillis();
        paramString = this.qlc;
        if (paramString == null) {
          k.aVY("statyTimeStatic");
        }
        localb = this.qlc;
        if (localb == null) {
          k.aVY("statyTimeStatic");
        }
        long l = localb.qol;
        localb = this.qlc;
        if (localb == null) {
          k.aVY("statyTimeStatic");
        }
        paramString.qoj = (l - localb.qok);
        paramString = this.qlc;
        if (paramString == null) {
          k.aVY("statyTimeStatic");
        }
        paramString.qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciJ();
        paramString = this.qlc;
        if (paramString == null) {
          k.aVY("statyTimeStatic");
        }
        paramString.qon = "143";
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
        paramString = this.qlc;
        if (paramString == null) {
          k.aVY("statyTimeStatic");
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.a(paramString);
      }
    }
    AppMethodBeat.o(195338);
  }
  
  public static Fragment ah(Activity paramActivity)
  {
    AppMethodBeat.i(195333);
    Fragment localFragment2 = g.cji();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = g.ac(paramActivity);
    }
    AppMethodBeat.o(195333);
    return localFragment1;
  }
  
  private final boolean cjw()
  {
    return ((a)this).qlc != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(195332);
    k.h(paramFragmentActivity, "activity");
    Fragment localFragment = ah((Activity)paramFragmentActivity);
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
      ac.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject);
      if (localFragment != null) {
        break label118;
      }
      AppMethodBeat.o(195332);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(195332);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(195332);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(195334);
    this.qlb = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    ac.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    k.g(str, "fragmentName");
    aaq(str);
    Object localObject;
    if (aap(str))
    {
      localObject = j.qnH;
      j.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.qjC;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramLong, true);
      AppMethodBeat.o(195334);
      return;
      if (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(195334);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(195335);
    String str = paramFragment.getClass().getName();
    ac.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    k.g(str, "fragmentName");
    aar(str);
    if (aap(str))
    {
      j localj = j.qnH;
      j.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      paramFragment = this.qjC;
      if (paramFragment == null) {
        break;
      }
      paramFragment.a(paramFragmentActivity, str, paramLong, true);
      AppMethodBeat.o(195335);
      return;
      if (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(195335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */