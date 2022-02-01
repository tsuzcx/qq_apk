package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a qUc;
  public d qRK;
  public WeakReference<Fragment> qTY;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b qTZ;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qUa;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qUb;
  
  static
  {
    AppMethodBeat.i(210686);
    qUc = new b.a((byte)0);
    AppMethodBeat.o(210686);
  }
  
  private static boolean aed(String paramString)
  {
    AppMethodBeat.i(210683);
    if ((p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(210683);
      return true;
    }
    AppMethodBeat.o(210683);
    return false;
  }
  
  private final void aee(String paramString)
  {
    AppMethodBeat.i(210684);
    this.qTZ = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.qTZ;
    if (localb == null) {
      p.bcb("statyTimeStatic");
    }
    localb.sessionId = c.cpK().cnc();
    localb = this.qTZ;
    if (localb == null) {
      p.bcb("statyTimeStatic");
    }
    localb.dtL = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    paramString = this.qTZ;
    if (paramString == null) {
      p.bcb("statyTimeStatic");
    }
    paramString.qXh = System.currentTimeMillis();
    paramString = this.qTZ;
    if (paramString == null) {
      p.bcb("statyTimeStatic");
    }
    paramString.qXk = "143";
    paramString = this.qTZ;
    if (paramString == null) {
      p.bcb("statyTimeStatic");
    }
    paramString.dFx = c.b.qVZ.value;
    AppMethodBeat.o(210684);
  }
  
  private final void aef(String paramString)
  {
    AppMethodBeat.i(210685);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    if (coI())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.qTZ;
      if (localb == null) {
        p.bcb("statyTimeStatic");
      }
      if (p.i(localb.dtL, paramString))
      {
        paramString = this.qTZ;
        if (paramString == null) {
          p.bcb("statyTimeStatic");
        }
        paramString.qXi = System.currentTimeMillis();
        paramString = this.qTZ;
        if (paramString == null) {
          p.bcb("statyTimeStatic");
        }
        localb = this.qTZ;
        if (localb == null) {
          p.bcb("statyTimeStatic");
        }
        long l = localb.qXi;
        localb = this.qTZ;
        if (localb == null) {
          p.bcb("statyTimeStatic");
        }
        paramString.qXg = (l - localb.qXh);
        paramString = this.qTZ;
        if (paramString == null) {
          p.bcb("statyTimeStatic");
        }
        paramString.qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnH();
        paramString = this.qTZ;
        if (paramString == null) {
          p.bcb("statyTimeStatic");
        }
        paramString.qXk = "143";
        paramString = a.qXa;
        paramString = this.qTZ;
        if (paramString == null) {
          p.bcb("statyTimeStatic");
        }
        a.a.a(paramString);
      }
    }
    AppMethodBeat.o(210685);
  }
  
  public static Fragment ah(Activity paramActivity)
  {
    AppMethodBeat.i(210680);
    Fragment localFragment2 = h.cop();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = h.ac(paramActivity);
    }
    AppMethodBeat.o(210680);
    return localFragment1;
  }
  
  private final boolean coI()
  {
    return ((b)this).qTZ != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(210679);
    p.h(paramFragmentActivity, "activity");
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
      ad.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject);
      if (localFragment != null) {
        break label118;
      }
      AppMethodBeat.o(210679);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(210679);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(210679);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210681);
    this.qTY = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    p.g(str, "fragmentName");
    aee(str);
    Object localObject;
    if (aed(str))
    {
      localObject = j.qWF;
      j.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.qRK;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(210681);
      return;
      if (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(210681);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210682);
    String str = paramFragment.getClass().getName();
    ad.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    p.g(str, "fragmentName");
    aef(str);
    Object localObject;
    if (aed(str))
    {
      localObject = j.qWF;
      j.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.qRK;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(210682);
      return;
      if (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(210682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */