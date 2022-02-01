package com.tencent.mm.plugin.expt.hellhound.ext.b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "", "()V", "curFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "statyTimeStatic", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "statyTimeStaticHome", "statyTimeStaticLbsList", "callbackOnFragmentPause", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "timestamp", "", "fragmentEventId", "", "callbackOnFragmentResume", "getCurFragment", "Landroid/app/Activity;", "getCurFragmentOfFinderHomeUI", "isFeedFlowTypeFragment", "", "fragmentName", "", "isStatyTimeStaticInit", "isStatyTimeStaticLbsListInit", "isWaterfullFlowTypeFragment", "isstatyTimeStaticHomeInit", "onFinderHomeUIPause", "onFinderHomeUIResume", "onFinderLbsStreamListUIPause", "onFinderLbsStreamListUIResume", "registerListener", "listener", "startFragmentRecord", "pageName", "stopFragmentRecord", "switch2Back", "switch2Front", "switch2Page", "isResume", "switchFragment", "Lcom/tencent/mm/ui/MMActivity;", "lastFrag", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "curFrag", "unregisterListener", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a zEz;
  public com.tencent.mm.plugin.expt.hellhound.core.d zBV;
  public WeakReference<Fragment> zEA;
  private com.tencent.mm.plugin.expt.hellhound.ext.b.c.b zEB;
  public com.tencent.mm.plugin.expt.hellhound.ext.b.c.b zEC;
  public com.tencent.mm.plugin.expt.hellhound.ext.b.c.b zED;
  
  static
  {
    AppMethodBeat.i(300280);
    zEz = new b.a((byte)0);
    AppMethodBeat.o(300280);
  }
  
  public static Fragment an(Activity paramActivity)
  {
    AppMethodBeat.i(300259);
    Fragment localFragment2 = k.dKR();
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null) {
      localFragment1 = k.ao(paramActivity);
    }
    AppMethodBeat.o(300259);
    return localFragment1;
  }
  
  private static boolean arr(String paramString)
  {
    AppMethodBeat.i(300265);
    if ((s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", paramString)))
    {
      AppMethodBeat.o(300265);
      return true;
    }
    AppMethodBeat.o(300265);
    return false;
  }
  
  private final void ars(String paramString)
  {
    AppMethodBeat.i(300270);
    this.zEB = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
    com.tencent.mm.plugin.expt.hellhound.ext.b.c.b localb = this.zEB;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("statyTimeStatic");
      localObject = null;
    }
    ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject).sessionId = c.dLD().dHN();
    localb = this.zEB;
    localObject = localb;
    if (localb == null)
    {
      s.bIx("statyTimeStatic");
      localObject = null;
    }
    ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject).hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    localObject = this.zEB;
    paramString = (String)localObject;
    if (localObject == null)
    {
      s.bIx("statyTimeStatic");
      paramString = null;
    }
    paramString.zIz = System.currentTimeMillis();
    localObject = this.zEB;
    paramString = (String)localObject;
    if (localObject == null)
    {
      s.bIx("statyTimeStatic");
      paramString = null;
    }
    paramString.zIC = "143";
    localObject = this.zEB;
    paramString = (String)localObject;
    if (localObject == null)
    {
      s.bIx("statyTimeStatic");
      paramString = null;
    }
    paramString.hYb = c.b.zHb.value;
    if (dKd())
    {
      localObject = this.zEC;
      paramString = (String)localObject;
      if (localObject == null)
      {
        s.bIx("statyTimeStaticHome");
        paramString = null;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString.extraInfo = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    AppMethodBeat.o(300270);
  }
  
  private final void art(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(300274);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    if (dKc())
    {
      Object localObject1 = this.zEB;
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        s.bIx("statyTimeStatic");
        paramString = null;
      }
      if (s.p(paramString.hJW, localObject3))
      {
        localObject1 = this.zEB;
        paramString = (String)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStatic");
          paramString = null;
        }
        paramString.zIA = System.currentTimeMillis();
        localObject1 = this.zEB;
        paramString = (String)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStatic");
          paramString = null;
        }
        localObject3 = this.zEB;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("statyTimeStatic");
          localObject1 = null;
        }
        long l = ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIA;
        localObject3 = this.zEB;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("statyTimeStatic");
          localObject1 = null;
        }
        paramString.zIy = (l - ((com.tencent.mm.plugin.expt.hellhound.ext.b.c.b)localObject1).zIz);
        localObject1 = this.zEB;
        paramString = (String)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStatic");
          paramString = null;
        }
        paramString.zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIY();
        localObject1 = this.zEB;
        paramString = (String)localObject1;
        if (localObject1 == null)
        {
          s.bIx("statyTimeStatic");
          paramString = null;
        }
        paramString.zIC = "143";
        paramString = a.zIv;
        paramString = this.zEB;
        if (paramString != null) {
          break label252;
        }
        s.bIx("statyTimeStatic");
        paramString = localObject2;
      }
    }
    label252:
    for (;;)
    {
      a.a.a(paramString);
      AppMethodBeat.o(300274);
      return;
    }
  }
  
  private final boolean dKc()
  {
    return this.zEB != null;
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(300292);
    s.u(paramFragmentActivity, "activity");
    Fragment localFragment = an((Activity)paramFragmentActivity);
    StringBuilder localStringBuilder = new StringBuilder("switch2Page: ");
    Object localObject;
    if (paramBoolean)
    {
      localObject = "onResumed";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", ");
      if (localFragment != null) {
        break label98;
      }
      localObject = null;
    }
    for (;;)
    {
      Log.d("HABBYGE-MALI.FinderHomeMonitor", localObject);
      if (localFragment != null) {
        break label126;
      }
      AppMethodBeat.o(300292);
      return;
      localObject = "onPaused";
      break;
      label98:
      localObject = localFragment.getClass();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((Class)localObject).getName();
      }
    }
    label126:
    if (paramBoolean)
    {
      a(paramFragmentActivity, localFragment, paramLong, 0);
      AppMethodBeat.o(300292);
      return;
    }
    b(paramFragmentActivity, localFragment, paramLong, 1);
    AppMethodBeat.o(300292);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(300297);
    this.zEA = new WeakReference(paramFragment);
    String str = paramFragment.getClass().getName();
    Log.d("HABBYGE-MALI.FinderHomeMonitor", s.X("callbackOnFragmentResume: ", str));
    s.s(str, "fragmentName");
    ars(str);
    Object localObject;
    if (arr(str))
    {
      localObject = k.zHQ;
      k.a(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.zBV;
      if (localObject != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject).a(paramFragmentActivity, paramFragment, str, paramFragment.hashCode(), paramLong, true);
      }
      AppMethodBeat.o(300297);
      return;
      if (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.a((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, long paramLong, int paramInt)
  {
    AppMethodBeat.i(300302);
    String str = paramFragment.getClass().getName();
    Log.d("HABBYGE-MALI.FinderHomeMonitor", s.X("callbackOnFragmentPause: ", str));
    s.s(str, "fragmentName");
    art(str);
    Object localObject;
    if (arr(str))
    {
      localObject = k.zHQ;
      k.b(paramFragmentActivity, paramFragment, paramInt);
    }
    for (;;)
    {
      localObject = this.zBV;
      if (localObject != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject).a(paramFragmentActivity, str, paramFragment.hashCode(), paramLong, true);
      }
      AppMethodBeat.o(300302);
      return;
      if (s.p("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str)) {
        k.b((Activity)paramFragmentActivity, paramFragment, paramLong, paramInt);
      }
    }
  }
  
  public final boolean dKd()
  {
    return this.zEC != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b
 * JD-Core Version:    0.7.0.1
 */