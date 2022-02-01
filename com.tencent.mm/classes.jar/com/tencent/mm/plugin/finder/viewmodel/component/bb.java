package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.ay.a;
import com.tencent.mm.plugin.finder.feed.ay.b;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.feed.ba;
import com.tencent.mm.plugin.finder.feed.bb.i;
import com.tencent.mm.plugin.finder.feed.bb.j;
import com.tencent.mm.plugin.finder.feed.bc;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  extends UIComponent
{
  public static final a GVt;
  private final com.tencent.mm.plugin.finder.viewmodel.b Bsp;
  private boolean ERQ;
  private boolean ERR;
  public com.tencent.mm.plugin.finder.feed.bb GVu;
  public az GVv;
  private bc GVw;
  
  static
  {
    AppMethodBeat.i(338381);
    GVt = new a((byte)0);
    AppMethodBeat.o(338381);
  }
  
  public bb(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338366);
    paramAppCompatActivity = k.aeZF;
    paramAppCompatActivity = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.Bsp = ((com.tencent.mm.plugin.finder.viewmodel.b)paramAppCompatActivity);
    this.ERQ = true;
    this.ERR = true;
    AppMethodBeat.o(338366);
  }
  
  private final void fpp()
  {
    AppMethodBeat.i(338376);
    if (this.ERR)
    {
      this.ERR = false;
      Object localObject = this.GVu;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.bb)localObject).nx(100L);
      }
      localObject = this.GVv;
      if (localObject != null) {
        ((az)localObject).nx(100L);
      }
      localObject = z.FrZ;
      z.av((Context)getActivity(), 5);
    }
    AppMethodBeat.o(338376);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(338422);
    Object localObject = this.GVu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.feed.bb)localObject).onActionbarClick(true);
    }
    localObject = this.GVv;
    if (localObject != null) {
      ((az)localObject).onActionbarClick(true);
    }
    AppMethodBeat.o(338422);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_lbs_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(338473);
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject1 = this.GVu;
      if (localObject1 != null)
      {
        kotlin.g.b.s.u(paramIntent, "data");
        localObject2 = ((com.tencent.mm.plugin.finder.feed.bb)localObject1).ecE();
        if (localObject2 != null)
        {
          localObject2 = ((ay.b)localObject2).getRecyclerView();
          if (localObject2 != null)
          {
            av localav = av.GiL;
            paramIntent = av.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((com.tencent.mm.plugin.finder.feed.bb)localObject1).AZs, false, (kotlin.g.a.b)bb.j.AZw);
            localObject1 = h.baE().ban();
            localObject2 = av.GiL;
            localObject2 = av.Uh(2);
            if (paramIntent != null) {
              break label133;
            }
            paramIntent = null;
          }
        }
      }
    }
    for (;;)
    {
      ((aq)localObject1).set((at.a)localObject2, Util.encodeHexString(paramIntent));
      AppMethodBeat.o(338473);
      return;
      label133:
      paramIntent = paramIntent.lastBuffer;
      if (paramIntent == null) {
        paramIntent = null;
      } else {
        paramIntent = paramIntent.toByteArray();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338400);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eRZ().bmg()).intValue() == 1)
    {
      Object localObject = new com.tencent.mm.plugin.finder.feed.bb((MMActivity)getActivity(), (FinderHomeTabFragment)getFragment());
      this.GVu = ((com.tencent.mm.plugin.finder.feed.bb)localObject);
      paramBundle = new bc((MMActivity)getActivity(), (ay.a)localObject, getRootView());
      ((com.tencent.mm.plugin.finder.feed.bb)localObject).a((ay.b)paramBundle);
      localObject = ah.aiuX;
      this.GVw = paramBundle;
      AppMethodBeat.o(338400);
      return;
    }
    paramBundle = new az((MMActivity)getActivity(), (FinderHomeTabFragment)getFragment());
    this.GVv = paramBundle;
    paramBundle.a((ay.b)new ba((MMActivity)getActivity(), (ay.a)paramBundle, getRootView()));
    AppMethodBeat.o(338400);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338461);
    super.onDestroy();
    ((ce)h.ax(ce.class)).b(null, q.w.DwO, q.n.DtB.scene, com.tencent.mm.plugin.finder.live.report.d.Dnl);
    Object localObject = this.GVu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.feed.bb)localObject).onDetach();
    }
    localObject = this.GVv;
    if (localObject != null) {
      ((az)localObject).onDetach();
    }
    localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
    localObject = as.GSQ;
    localObject = as.a.hu((Context)getActivity());
    if (localObject == null) {}
    for (localObject = null;; localObject = ((as)localObject).fou())
    {
      com.tencent.mm.plugin.finder.report.s.e(2, (bui)localObject);
      AppMethodBeat.o(338461);
      return;
    }
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(338449);
    super.onFinished();
    Object localObject1 = this.GVu;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.feed.bb)localObject1).ecE().getRecyclerView();
      if (localObject2 != null)
      {
        i = com.tencent.mm.plugin.finder.feed.bb.findFirstPosition((RecyclerView)localObject2);
        Log.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((com.tencent.mm.plugin.finder.feed.bb)localObject1).totalDy);
        localObject2 = ((Iterable)((com.tencent.mm.plugin.finder.feed.bb)localObject1).AZs.getDataListJustForAdapter()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cc localcc = (cc)((Iterator)localObject2).next();
          if ((localcc instanceof BaseFinderFeed)) {
            ((BaseFinderFeed)localcc).eDg();
          }
        }
        com.tencent.mm.plugin.finder.viewmodel.d.a(((com.tencent.mm.plugin.finder.feed.bb)localObject1).AZj, 2, 0, ((com.tencent.mm.plugin.finder.feed.bb)localObject1).totalDy, (ArrayList)((com.tencent.mm.plugin.finder.feed.bb)localObject1).AZs.getDataListJustForAdapter(), null, 112);
      }
    }
    localObject1 = this.GVv;
    if (localObject1 != null)
    {
      localObject2 = ((az)localObject1).ecE().getRecyclerView();
      if (localObject2 != null)
      {
        i = az.findFirstPosition((RecyclerView)localObject2);
        Log.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((az)localObject1).totalDy);
        com.tencent.mm.plugin.finder.viewmodel.d.a(((az)localObject1).AZj, 1000, i, ((az)localObject1).totalDy, new ArrayList(0), (ArrayList)((az)localObject1).ecD().getDataListJustForAdapter(), 96);
      }
    }
    AppMethodBeat.o(338449);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338416);
    super.onPause();
    this.ERQ = this.Bsp.dUi();
    ce localce = (ce)h.ax(ce.class);
    Object localObject = this.GVw;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bc)localObject).getRecyclerView())
    {
      localce.b((RecyclerView)localObject, q.w.DwO, q.n.DtB.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
      AppMethodBeat.o(338416);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(338477);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        fpp();
        AppMethodBeat.o(338477);
        return;
      }
      paramArrayOfString = z.FrZ;
      z.av((Context)getActivity(), 3);
    }
    AppMethodBeat.o(338477);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338410);
    super.onResume();
    if ((!this.ERQ) && (this.Bsp.dUi())) {
      fpp();
    }
    Object localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.St(2);
    ce localce = (ce)h.ax(ce.class);
    localObject = this.GVw;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bc)localObject).getRecyclerView())
    {
      localce.b((RecyclerView)localObject, q.w.DwO, q.n.DtB.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
      AppMethodBeat.o(338410);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(338435);
    super.onUserVisibleFocused();
    Object localObject = k.aeZF;
    k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    localObject = this.GVu;
    z localz;
    if (localObject != null)
    {
      com.tencent.mm.ae.d.B((a)new bb.i((com.tencent.mm.plugin.finder.feed.bb)localObject));
      if (((com.tencent.mm.plugin.finder.feed.bb)localObject).isEmptyLocation)
      {
        localz = z.FrZ;
        z.av((Context)((com.tencent.mm.plugin.finder.feed.bb)localObject).activity, 1);
      }
    }
    localObject = this.GVv;
    if (localObject != null)
    {
      if (((az)localObject).isEmptyLocation)
      {
        localz = z.FrZ;
        z.av((Context)((az)localObject).activity, 1);
      }
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("finder_tl_nearby_tab");
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().hH("finder_tl_nearby_tab", "onRefreshEnd");
    }
    localObject = k.aeZF;
    ((be)k.cn(PluginFinder.class).q(be.class)).aw((kotlin.g.a.b)bb.b.GVx);
    this.Bsp.pH(false);
    if (((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Nw(2))
    {
      Log.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject = this.GVu;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.bb)localObject).nx(0L);
      }
      localObject = this.GVv;
      if (localObject != null) {
        ((az)localObject).nx(0L);
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1)
      {
        localObject = as.GSQ;
        localObject = as.a.hu((Context)getActivity());
        if (localObject != null)
        {
          localz = z.FrZ;
          z.b(((as)localObject).fou(), 6);
        }
      }
    }
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("finder_tl_nearby_tab");
    AppMethodBeat.o(338435);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(338440);
    super.onUserVisibleUnFocused();
    k localk = k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UT(2);
    AppMethodBeat.o(338440);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bb
 * JD-Core Version:    0.7.0.1
 */