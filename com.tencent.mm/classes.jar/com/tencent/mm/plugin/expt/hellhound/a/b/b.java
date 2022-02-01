package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a wiA;
  public d wfT;
  public WeakReference<Fragment> wiw;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b wix;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b wiy;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b wiz;
  
  static
  {
    AppMethodBeat.i(256238);
    wiA = new b.a((byte)0);
    AppMethodBeat.o(256238);
  }
  
  public static Fragment af(Activity paramActivity)
  {
    AppMethodBeat.i(256228);
    Fragment localFragment2 = h.ddc();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = h.ac(paramActivity);
    }
    AppMethodBeat.o(256228);
    return localFragment1;
  }
  
  private static boolean axn(String paramString)
  {
    AppMethodBeat.i(256232);
    if ((p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(256232);
      return true;
    }
    AppMethodBeat.o(256232);
    return false;
  }
  
  private final void axo(String paramString)
  {
    AppMethodBeat.i(256235);
    this.wix = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.wix;
    if (localb == null) {
      p.bGy("statyTimeStatic");
    }
    localb.sessionId = c.deO().dbr();
    localb = this.wix;
    if (localb == null) {
      p.bGy("statyTimeStatic");
    }
    localb.fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    paramString = this.wix;
    if (paramString == null) {
      p.bGy("statyTimeStatic");
    }
    paramString.wmx = System.currentTimeMillis();
    paramString = this.wix;
    if (paramString == null) {
      p.bGy("statyTimeStatic");
    }
    paramString.wmA = "143";
    paramString = this.wix;
    if (paramString == null) {
      p.bGy("statyTimeStatic");
    }
    paramString.fSe = c.b.wkW.value;
    AppMethodBeat.o(256235);
  }
  
  private final void axp(String paramString)
  {
    AppMethodBeat.i(256236);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    if (ddv())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.wix;
      if (localb == null) {
        p.bGy("statyTimeStatic");
      }
      if (p.h(localb.fFe, paramString))
      {
        paramString = this.wix;
        if (paramString == null) {
          p.bGy("statyTimeStatic");
        }
        paramString.wmy = System.currentTimeMillis();
        paramString = this.wix;
        if (paramString == null) {
          p.bGy("statyTimeStatic");
        }
        localb = this.wix;
        if (localb == null) {
          p.bGy("statyTimeStatic");
        }
        long l = localb.wmy;
        localb = this.wix;
        if (localb == null) {
          p.bGy("statyTimeStatic");
        }
        paramString.wmw = (l - localb.wmx);
        paramString = this.wix;
        if (paramString == null) {
          p.bGy("statyTimeStatic");
        }
        paramString.wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dcu();
        paramString = this.wix;
        if (paramString == null) {
          p.bGy("statyTimeStatic");
        }
        paramString.wmA = "143";
        paramString = a.wmq;
        paramString = this.wix;
        if (paramString == null) {
          p.bGy("statyTimeStatic");
        }
        a.a.a(paramString);
      }
    }
    AppMethodBeat.o(256236);
  }
  
  private final boolean ddv()
  {
    return ((b)this).wix != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(256227);
    p.k(paramFragmentActivity, "activity");
    Fragment localFragment = af((Activity)paramFragmentActivity);
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
      AppMethodBeat.o(256227);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(256227);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(256227);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(256229);
    this.wiw = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    p.j(str, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    axo(str);
    Object localObject;
    if (axn(str))
    {
      localObject = k.wlT;
      k.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.wfT;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(256229);
      return;
      if (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(256229);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(256231);
    String str = paramFragment.getClass().getName();
    p.j(str, "fragment.javaClass.name");
    Log.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    axp(str);
    Object localObject;
    if (axn(str))
    {
      localObject = k.wlT;
      k.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.wfT;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(256231);
      return;
      if (p.h("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(256231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */