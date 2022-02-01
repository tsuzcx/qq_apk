package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ar.b;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.au.l;
import com.tencent.mm.plugin.finder.feed.au.m;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.q;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class ap
  extends UIComponent
{
  public static final a BoR;
  public au BoO;
  public com.tencent.mm.plugin.finder.feed.as BoP;
  private av BoQ;
  private final com.tencent.mm.plugin.finder.viewmodel.a xSM;
  private boolean zJQ;
  private boolean zJR;
  
  static
  {
    AppMethodBeat.i(275389);
    BoR = new a((byte)0);
    AppMethodBeat.o(275389);
  }
  
  public ap(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(275388);
    paramAppCompatActivity = g.Xox;
    paramAppCompatActivity = g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
    p.j(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.xSM = ((com.tencent.mm.plugin.finder.viewmodel.a)paramAppCompatActivity);
    this.zJQ = true;
    this.zJR = true;
    AppMethodBeat.o(275388);
  }
  
  private final void dME()
  {
    AppMethodBeat.i(275387);
    if (this.zJR)
    {
      this.zJR = false;
      Object localObject = this.BoO;
      if (localObject != null) {
        ((au)localObject).KT(100L);
      }
      localObject = this.BoP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.as)localObject).KT(100L);
      }
      localObject = n.zWF;
      n.al((Context)getActivity(), 5);
    }
    AppMethodBeat.o(275387);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(275379);
    Object localObject = this.BoO;
    if (localObject != null) {
      ((au)localObject).onActionbarClick(true);
    }
    localObject = this.BoP;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.feed.as)localObject).onActionbarClick(true);
      AppMethodBeat.o(275379);
      return;
    }
    AppMethodBeat.o(275379);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_timeline_lbs_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(275385);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = this.BoO;
      if (localObject1 != null)
      {
        p.k(paramIntent, "data");
        Object localObject2 = ((au)localObject1).xBR;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        if (localObject2 != null)
        {
          localObject2 = ((ar.b)localObject2).getRecyclerView();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
            paramIntent = com.tencent.mm.plugin.finder.utils.aj.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((au)localObject1).xCg, false, (kotlin.g.a.b)au.m.xCs);
            localObject1 = h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp();
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.QX(2);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.lastBuffer;
              if (paramIntent == null) {}
            }
            for (paramIntent = paramIntent.toByteArray();; paramIntent = null)
            {
              ((ao)localObject1).set((com.tencent.mm.storage.ar.a)localObject2, Util.encodeHexString(paramIntent));
              AppMethodBeat.o(275385);
              return;
            }
          }
        }
        AppMethodBeat.o(275385);
        return;
      }
    }
    AppMethodBeat.o(275385);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(275375);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTI().aSr()).intValue() == 1)
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(275375);
        throw paramBundle;
      }
      paramBundle = new au((MMActivity)paramBundle, (FinderHomeTabFragment)getFragment());
      this.BoO = paramBundle;
      localObject = getActivity();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(275375);
        throw paramBundle;
      }
      localObject = new av((MMActivity)localObject, (com.tencent.mm.plugin.finder.feed.ar.a)paramBundle, getRootView());
      paramBundle.a((ar.b)localObject);
      this.BoQ = ((av)localObject);
      AppMethodBeat.o(275375);
      return;
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(275375);
      throw paramBundle;
    }
    paramBundle = new com.tencent.mm.plugin.finder.feed.as((MMActivity)paramBundle, (FinderHomeTabFragment)getFragment());
    this.BoP = paramBundle;
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(275375);
      throw paramBundle;
    }
    paramBundle.a((ar.b)new at((MMActivity)localObject, (com.tencent.mm.plugin.finder.feed.ar.a)paramBundle, getRootView()));
    AppMethodBeat.o(275375);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(275384);
    super.onDestroy();
    Object localObject = k.yBj;
    k.b(null, s.t.yGM, s.l.yFX.scene, c.yAo);
    localObject = this.BoO;
    if (localObject != null) {
      ((au)localObject).onDetach();
    }
    localObject = this.BoP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.feed.as)localObject).onDetach();
    }
    localObject = j.zVy;
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      j.e(2, (bid)localObject);
      AppMethodBeat.o(275384);
      return;
    }
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(275383);
    super.onFinished();
    Object localObject1 = this.BoO;
    if (localObject1 != null)
    {
      localObject2 = ((au)localObject1).xBR;
      if (localObject2 == null) {
        p.bGy("viewCallback");
      }
      localObject2 = ((ar.b)localObject2).getRecyclerView();
      if (localObject2 != null) {
        break label95;
      }
    }
    for (;;)
    {
      localObject1 = this.BoP;
      if (localObject1 == null) {
        break label334;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.feed.as)localObject1).xBR;
      if (localObject2 == null) {
        p.bGy("viewCallback");
      }
      localObject2 = ((ar.b)localObject2).getRecyclerView();
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(275383);
      return;
      label95:
      i = au.findFirstPosition((RecyclerView)localObject2);
      Log.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((au)localObject1).totalDy);
      localObject2 = ((Iterable)((au)localObject1).xCg.getDataListJustForAdapter()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bu)((Iterator)localObject2).next();
        if ((localObject3 instanceof BaseFinderFeed)) {
          ((BaseFinderFeed)localObject3).dKr();
        }
      }
      com.tencent.mm.plugin.finder.viewmodel.b.a(((au)localObject1).tlCache, 2, 0, ((au)localObject1).totalDy, (ArrayList)((au)localObject1).xCg.getDataListJustForAdapter(), null, null, false, 112);
    }
    int i = com.tencent.mm.plugin.finder.feed.as.findFirstPosition((RecyclerView)localObject2);
    Log.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((com.tencent.mm.plugin.finder.feed.as)localObject1).totalDy);
    Object localObject2 = ((com.tencent.mm.plugin.finder.feed.as)localObject1).tlCache;
    int j = ((com.tencent.mm.plugin.finder.feed.as)localObject1).totalDy;
    Object localObject3 = new ArrayList(0);
    localObject1 = ((com.tencent.mm.plugin.finder.feed.as)localObject1).xBQ;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    com.tencent.mm.plugin.finder.viewmodel.b.a((com.tencent.mm.plugin.finder.viewmodel.b)localObject2, 1000, i, j, (ArrayList)localObject3, (ArrayList)((FinderLbsLoader)localObject1).getDataListJustForAdapter(), null, false, 96);
    AppMethodBeat.o(275383);
    return;
    label334:
    AppMethodBeat.o(275383);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(275377);
    super.onPause();
    this.zJQ = com.tencent.mm.plugin.finder.viewmodel.a.ejZ();
    Object localObject = k.yBj;
    localObject = this.BoQ;
    if (localObject != null) {}
    for (localObject = ((av)localObject).getRecyclerView();; localObject = null)
    {
      k.b((RecyclerView)localObject, s.t.yGM, s.l.yFX.scene, c.yAj);
      AppMethodBeat.o(275377);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(275386);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        dME();
        AppMethodBeat.o(275386);
        return;
      }
      paramArrayOfString = n.zWF;
      n.al((Context)getActivity(), 3);
    }
    AppMethodBeat.o(275386);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(275376);
    super.onResume();
    if ((!this.zJQ) && (com.tencent.mm.plugin.finder.viewmodel.a.ejZ())) {
      dME();
    }
    Object localObject = j.zVy;
    j.Pq(2);
    localObject = k.yBj;
    localObject = this.BoQ;
    if (localObject != null) {}
    for (localObject = ((av)localObject).getRecyclerView();; localObject = null)
    {
      k.b((RecyclerView)localObject, s.t.yGM, s.l.yFX.scene, c.yAi);
      AppMethodBeat.o(275376);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(275381);
    super.onUserVisibleFocused();
    Object localObject = g.Xox;
    g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
    localObject = this.BoO;
    n localn;
    if (localObject != null)
    {
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new au.l((au)localObject));
      if (((au)localObject).isEmptyLocation)
      {
        localn = n.zWF;
        n.al((Context)((au)localObject).activity, 1);
      }
    }
    localObject = this.BoP;
    if (localObject != null)
    {
      if (((com.tencent.mm.plugin.finder.feed.as)localObject).isEmptyLocation)
      {
        localn = n.zWF;
        n.al((Context)((com.tencent.mm.plugin.finder.feed.as)localObject).activity, 1);
      }
      localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().aBd("finder_tl_nearby_tab");
      localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().gW("finder_tl_nearby_tab", "onRefreshEnd");
    }
    localObject = g.Xox;
    ((as)g.bD(PluginFinder.class).i(as.class)).Q((kotlin.g.a.b)ap.b.BoS);
    this.xSM.cKK();
    localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    if (((PluginFinder)localObject).getRedDotManager().Mq(2))
    {
      Log.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject = this.BoO;
      if (localObject != null) {
        ((au)localObject).KT(0L);
      }
      localObject = this.BoP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.as)localObject).KT(0L);
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1)
      {
        localObject = aj.Bnu;
        localObject = aj.a.fZ((Context)getActivity());
        if (localObject != null)
        {
          localn = n.zWF;
          n.b(((aj)localObject).ekY(), 6);
        }
      }
    }
    localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().aBd("finder_tl_nearby_tab");
    AppMethodBeat.o(275381);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(275382);
    super.onUserVisibleUnFocused();
    g localg = g.Xox;
    ((com.tencent.mm.plugin.finder.viewmodel.b)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RH(2);
    AppMethodBeat.o(275382);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ap
 * JD-Core Version:    0.7.0.1
 */