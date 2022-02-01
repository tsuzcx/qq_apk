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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a KEU;
  public WeakReference<Fragment> KEQ;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b KER;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b KES;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b KET;
  public d pEP;
  
  static
  {
    AppMethodBeat.i(205080);
    KEU = new a((byte)0);
    AppMethodBeat.o(205080);
  }
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(205077);
    if ((k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(205077);
      return true;
    }
    AppMethodBeat.o(205077);
    return false;
  }
  
  private final void aUS(String paramString)
  {
    AppMethodBeat.i(205078);
    this.KER = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.KER;
    if (localb == null) {
      k.aPZ("statyTimeStatic");
    }
    localb.sessionId = c.ccM().cbk();
    localb = this.KER;
    if (localb == null) {
      k.aPZ("statyTimeStatic");
    }
    localb.DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    paramString = this.KER;
    if (paramString == null) {
      k.aPZ("statyTimeStatic");
    }
    paramString.KHU = System.currentTimeMillis();
    paramString = this.KER;
    if (paramString == null) {
      k.aPZ("statyTimeStatic");
    }
    paramString.pZX = "143";
    paramString = this.KER;
    if (paramString == null) {
      k.aPZ("statyTimeStatic");
    }
    paramString.dvJ = c.b.KGN.value;
    AppMethodBeat.o(205078);
  }
  
  private final void aUT(String paramString)
  {
    AppMethodBeat.i(205079);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    if (fRr())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.KER;
      if (localb == null) {
        k.aPZ("statyTimeStatic");
      }
      if (k.g(localb.DDP, paramString))
      {
        paramString = this.KER;
        if (paramString == null) {
          k.aPZ("statyTimeStatic");
        }
        paramString.KHV = System.currentTimeMillis();
        paramString = this.KER;
        if (paramString == null) {
          k.aPZ("statyTimeStatic");
        }
        localb = this.KER;
        if (localb == null) {
          k.aPZ("statyTimeStatic");
        }
        long l = localb.KHV;
        localb = this.KER;
        if (localb == null) {
          k.aPZ("statyTimeStatic");
        }
        paramString.xBr = (l - localb.KHU);
        paramString = this.KER;
        if (paramString == null) {
          k.aPZ("statyTimeStatic");
        }
        paramString.KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRn();
        paramString = this.KER;
        if (paramString == null) {
          k.aPZ("statyTimeStatic");
        }
        paramString.pZX = "143";
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
        paramString = this.KER;
        if (paramString == null) {
          k.aPZ("statyTimeStatic");
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.a(paramString);
      }
    }
    AppMethodBeat.o(205079);
  }
  
  public static Fragment bv(Activity paramActivity)
  {
    AppMethodBeat.i(205074);
    Fragment localFragment2 = g.fRo();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = g.bt(paramActivity);
    }
    AppMethodBeat.o(205074);
    return localFragment1;
  }
  
  private final boolean fRr()
  {
    return ((a)this).KER != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(205073);
    k.h(paramFragmentActivity, "activity");
    Fragment localFragment = bv((Activity)paramFragmentActivity);
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
      ad.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject);
      if (localFragment != null) {
        break label118;
      }
      AppMethodBeat.o(205073);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(205073);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(205073);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(205075);
    this.KEQ = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    k.g(str, "fragmentName");
    aUS(str);
    Object localObject;
    if (aUR(str))
    {
      localObject = j.KHt;
      j.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.pEP;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramLong, true);
      AppMethodBeat.o(205075);
      return;
      if (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(205075);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(205076);
    String str = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    k.g(str, "fragmentName");
    aUT(str);
    if (aUR(str))
    {
      j localj = j.KHt;
      j.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      paramFragment = this.pEP;
      if (paramFragment == null) {
        break;
      }
      paramFragment.a(paramFragmentActivity, str, paramLong, true);
      AppMethodBeat.o(205076);
      return;
      if (k.g("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(205076);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */