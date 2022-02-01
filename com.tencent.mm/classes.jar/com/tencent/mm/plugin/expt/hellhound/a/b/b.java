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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v4/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a rca;
  public d qZI;
  public WeakReference<Fragment> rbW;
  private com.tencent.mm.plugin.expt.hellhound.a.b.c.b rbX;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b rbY;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b rbZ;
  
  static
  {
    AppMethodBeat.i(196353);
    rca = new b.a((byte)0);
    AppMethodBeat.o(196353);
  }
  
  private static boolean aeX(String paramString)
  {
    AppMethodBeat.i(196350);
    if ((p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(196350);
      return true;
    }
    AppMethodBeat.o(196350);
    return false;
  }
  
  private final void aeY(String paramString)
  {
    AppMethodBeat.i(196351);
    this.rbX = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.rbX;
    if (localb == null) {
      p.bdF("statyTimeStatic");
    }
    localb.sessionId = c.crm().cos();
    localb = this.rbX;
    if (localb == null) {
      p.bdF("statyTimeStatic");
    }
    localb.duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    paramString = this.rbX;
    if (paramString == null) {
      p.bdF("statyTimeStatic");
    }
    paramString.rfm = System.currentTimeMillis();
    paramString = this.rbX;
    if (paramString == null) {
      p.bdF("statyTimeStatic");
    }
    paramString.rfp = "143";
    paramString = this.rbX;
    if (paramString == null) {
      p.bdF("statyTimeStatic");
    }
    paramString.dGC = c.b.rdY.value;
    AppMethodBeat.o(196351);
  }
  
  private final void aeZ(String paramString)
  {
    AppMethodBeat.i(196352);
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    if (cqk())
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = this.rbX;
      if (localb == null) {
        p.bdF("statyTimeStatic");
      }
      if (p.i(localb.duQ, paramString))
      {
        paramString = this.rbX;
        if (paramString == null) {
          p.bdF("statyTimeStatic");
        }
        paramString.rfn = System.currentTimeMillis();
        paramString = this.rbX;
        if (paramString == null) {
          p.bdF("statyTimeStatic");
        }
        localb = this.rbX;
        if (localb == null) {
          p.bdF("statyTimeStatic");
        }
        long l = localb.rfn;
        localb = this.rbX;
        if (localb == null) {
          p.bdF("statyTimeStatic");
        }
        paramString.rfl = (l - localb.rfm);
        paramString = this.rbX;
        if (paramString == null) {
          p.bdF("statyTimeStatic");
        }
        paramString.rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpj();
        paramString = this.rbX;
        if (paramString == null) {
          p.bdF("statyTimeStatic");
        }
        paramString.rfp = "143";
        paramString = a.rff;
        paramString = this.rbX;
        if (paramString == null) {
          p.bdF("statyTimeStatic");
        }
        a.a.a(paramString);
      }
    }
    AppMethodBeat.o(196352);
  }
  
  public static Fragment ai(Activity paramActivity)
  {
    AppMethodBeat.i(196347);
    Fragment localFragment2 = h.cpR();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = h.ad(paramActivity);
    }
    AppMethodBeat.o(196347);
    return localFragment1;
  }
  
  private final boolean cqk()
  {
    return ((b)this).rbX != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(196346);
    p.h(paramFragmentActivity, "activity");
    Fragment localFragment = ai((Activity)paramFragmentActivity);
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
      ae.d("HABBYGE-MALI.FinderHomeMonitor", (String)localObject);
      if (localFragment != null) {
        break label118;
      }
      AppMethodBeat.o(196346);
      return;
      localObject = "onPaused";
      break;
    }
    label118:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(196346);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(196346);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(196348);
    this.rbW = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    ae.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentResume: ".concat(String.valueOf(str)));
    p.g(str, "fragmentName");
    aeY(str);
    Object localObject;
    if (aeX(str))
    {
      localObject = j.reI;
      j.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.qZI;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, paramFragment, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(196348);
      return;
      if (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(196348);
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(196349);
    String str = paramFragment.getClass().getName();
    ae.d("HABBYGE-MALI.FinderHomeMonitor", "callbackOnFragmentPause: ".concat(String.valueOf(str)));
    p.g(str, "fragmentName");
    aeZ(str);
    Object localObject;
    if (aeX(str))
    {
      localObject = j.reI;
      j.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.qZI;
      if (localObject == null) {
        break;
      }
      ((d)localObject).a(paramFragmentActivity, str, paramFragment.hashCode(), paramLong, true);
      AppMethodBeat.o(196349);
      return;
      if (p.i("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        j.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
    AppMethodBeat.o(196349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */