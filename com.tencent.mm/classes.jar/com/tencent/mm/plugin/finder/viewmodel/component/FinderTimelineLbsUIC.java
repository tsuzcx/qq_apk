package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.ae;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.af.j;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.x;
import com.tencent.mm.plugin.finder.feed.model.y;
import com.tencent.mm.plugin.finder.feed.model.y.a;
import com.tencent.mm.plugin.finder.feed.model.y.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.a.j;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC
  extends UIComponent
{
  public static final a Ljv;
  private final FinderGlobalLocationVM KTa;
  public af Ljq;
  public com.tencent.mm.plugin.finder.feed.ad Ljr;
  private ag Ljs;
  private boolean Ljt;
  private boolean Lju;
  
  static
  {
    AppMethodBeat.i(200508);
    Ljv = new a((byte)0);
    AppMethodBeat.o(200508);
  }
  
  public FinderTimelineLbsUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200507);
    paramMMActivity = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.KTa = ((FinderGlobalLocationVM)paramMMActivity);
    this.Ljt = true;
    this.Lju = true;
    AppMethodBeat.o(200507);
  }
  
  private final void fXz()
  {
    AppMethodBeat.i(200506);
    if (this.Lju)
    {
      this.Lju = false;
      Object localObject = this.Ljq;
      if (localObject != null) {
        ((af)localObject).BH(100L);
      }
      localObject = this.Ljr;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.ad)localObject).BH(100L);
      }
      localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.aS((Context)getActivity(), 5);
    }
    AppMethodBeat.o(200506);
  }
  
  public final void fTo()
  {
    AppMethodBeat.i(200501);
    super.fTo();
    Object localObject1 = this.Ljq;
    Object localObject2;
    if (localObject1 != null)
    {
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new af.j((af)localObject1));
      if (((af)localObject1).KOd)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.aS((Context)((af)localObject1).activity, 1);
      }
    }
    localObject1 = this.Ljr;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.finder.feed.ad)localObject1).KOd)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.aS((Context)((com.tencent.mm.plugin.finder.feed.ad)localObject1).activity, 1);
      }
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject1).getRedDotManager().ahg(1003);
    }
    localObject1 = com.tencent.mm.ui.component.a.LCX;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoRecycler.class)).J((d.g.a.b)b.Ljw);
    this.KTa.bMk();
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    if (((com.tencent.mm.plugin.finder.extension.reddot.c)localObject1).ahh(2))
    {
      com.tencent.mm.sdk.platformtools.ad.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject2 = this.Ljq;
      if (localObject2 != null) {
        ((af)localObject2).BH(0L);
      }
      localObject2 = this.Ljr;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.feed.ad)localObject2).BH(0L);
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUw())
      {
        localObject2 = FinderReporterUIC.Ljl;
        localObject2 = FinderReporterUIC.a.lB((Context)getActivity());
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject2).fXs(), 6);
        }
      }
    }
    ((com.tencent.mm.plugin.finder.extension.reddot.c)localObject1).ahg(1003);
    localObject1 = com.tencent.mm.ui.component.a.LCX;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).ahM(2);
    AppMethodBeat.o(200501);
  }
  
  public final void fVI()
  {
    AppMethodBeat.i(200500);
    Object localObject = this.Ljq;
    if (localObject != null) {
      ((af)localObject).yB(true);
    }
    localObject = this.Ljr;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.feed.ad)localObject).yB(true);
      AppMethodBeat.o(200500);
      return;
    }
    AppMethodBeat.o(200500);
  }
  
  public final void fXy()
  {
    AppMethodBeat.i(200502);
    super.fXy();
    Object localObject1 = this.Ljq;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((af)localObject1).KNZ;
      if (localObject2 == null) {
        k.aPZ("viewCallback");
      }
      i = af.x(((ac.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ad.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((af)localObject1).KOb);
      FinderHomeTabStateVM.a(((af)localObject1).KOa, 2, 0, ((af)localObject1).KOb, (ArrayList)((af)localObject1).qrj.getDataListJustForAdapter());
    }
    localObject1 = this.Ljr;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.feed.ad)localObject1).KNZ;
      if (localObject2 == null) {
        k.aPZ("viewCallback");
      }
      i = com.tencent.mm.plugin.finder.feed.ad.x(((ac.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((com.tencent.mm.plugin.finder.feed.ad)localObject1).KOb);
      localObject2 = ((com.tencent.mm.plugin.finder.feed.ad)localObject1).KOa;
      int j = ((com.tencent.mm.plugin.finder.feed.ad)localObject1).KOb;
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((com.tencent.mm.plugin.finder.feed.ad)localObject1).KNY;
      if (localObject1 == null) {
        k.aPZ("feedLoader");
      }
      ((FinderHomeTabStateVM)localObject2).a(1000, i, j, localArrayList, (ArrayList)((x)localObject1).getDataListJustForAdapter());
      AppMethodBeat.o(200502);
      return;
    }
    AppMethodBeat.o(200502);
  }
  
  public final int getLayoutId()
  {
    return 2131496264;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(200504);
    if ((paramInt1 == 501) && (paramInt2 == 0) && (this.Ljq != null) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("KEY_CACHE_ID", 0L);
      int i = paramIntent.getIntExtra("KEY_CLICK_FEED_POSITION", -1);
      paramIntent = y.KQe;
      y.a.a locala = y.a.BL(l);
      paramIntent = y.KQe;
      y.a.BI(l);
      Object localObject2 = this.Ljq;
      Object localObject1;
      label143:
      int j;
      Object localObject4;
      label233:
      Object localObject5;
      if (localObject2 != null)
      {
        paramIntent = ((af)localObject2).fTq();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getRecyclerView();
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getAdapter();
            if (localObject2 == null) {
              break label293;
            }
            localObject1 = ((af)localObject2).fTq();
            if (localObject1 == null) {
              break label293;
            }
            localObject1 = ((ac.b)localObject1).getRecyclerView();
            if (localObject1 == null) {
              break label293;
            }
            localObject1 = ((RecyclerView)localObject1).getLayoutManager();
            if ((paramIntent == null) || (!(paramIntent instanceof WxRecyclerAdapter)) || (!(localObject1 instanceof StaggeredGridLayoutManager)) || (bt.gL(locala.dataList)) || (locala.lastBuffer == null)) {
              break label502;
            }
            j = ((WxRecyclerAdapter)paramIntent).Ibl.size();
            localObject2 = ((af)localObject2).qrj.getDataList();
            localObject4 = (Iterable)localObject2;
            localObject3 = (Collection)new ArrayList();
            localObject4 = ((Iterable)localObject4).iterator();
            paramInt1 = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label304;
            }
            localObject5 = ((Iterator)localObject4).next();
            if (paramInt1 < 0) {
              j.fvx();
            }
            if (paramInt1 < j) {
              break label299;
            }
          }
        }
      }
      label293:
      label299:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 != 0) {
          ((Collection)localObject3).add(localObject5);
        }
        paramInt1 += 1;
        break label233;
        paramIntent = null;
        break;
        localObject1 = null;
        break label143;
      }
      label304:
      Object localObject3 = (List)localObject3;
      if (((List)localObject3).size() != locala.dataList.size())
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((DataBuffer)localObject2).remove((BaseFinderFeed)((Iterator)localObject3).next());
        }
        ((DataBuffer)localObject2).addAll((Collection)locala.dataList);
        localObject3 = g.afB();
        k.g(localObject3, "MMKernel.storage()");
        localObject3 = ((e)localObject3).afk();
        localObject4 = i.qTa;
        ((ab)localObject3).set(i.ahH(2), bt.cy(locala.lastBuffer.toByteArray()));
        paramIntent.notifyDataSetChanged();
      }
      if (i >= 0) {
        ((StaggeredGridLayoutManager)localObject1).af(i + j, 0);
      }
      com.tencent.mm.sdk.platformtools.ad.i("Finder.TimelineLbsUIC", "lxl onActivityResult refresh lbs, pos:" + i + ", headCount:" + j + ", datasize:" + ((DataBuffer)localObject2).size());
    }
    label502:
    AppMethodBeat.o(200504);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200497);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUz())
    {
      paramBundle = new af(getActivity(), (FinderHomeTabFragment)this.fragment);
      this.Ljq = paramBundle;
      ag localag = new ag(getActivity(), (ac.a)paramBundle, getRootView());
      paramBundle.a((ac.b)localag);
      this.Ljs = localag;
      AppMethodBeat.o(200497);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.finder.feed.ad(getActivity(), (FinderHomeTabFragment)this.fragment);
    this.Ljr = paramBundle;
    paramBundle.a((ac.b)new ae(getActivity(), (ac.a)paramBundle, getRootView()));
    AppMethodBeat.o(200497);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200503);
    super.onDestroy();
    Object localObject = this.Ljq;
    if (localObject != null) {
      ((af)localObject).onDetach();
    }
    localObject = this.Ljr;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.feed.ad)localObject).onDetach();
      AppMethodBeat.o(200503);
      return;
    }
    AppMethodBeat.o(200503);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200499);
    super.onPause();
    this.Ljt = FinderGlobalLocationVM.fXe();
    AppMethodBeat.o(200499);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200505);
    k.h(paramArrayOfString, "permissions");
    k.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        fXz();
        AppMethodBeat.o(200505);
        return;
      }
      paramArrayOfString = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.aS((Context)getActivity(), 3);
    }
    AppMethodBeat.o(200505);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200498);
    super.onResume();
    if ((!this.Ljt) && (FinderGlobalLocationVM.fXe())) {
      fXz();
    }
    AppMethodBeat.o(200498);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<o, Boolean>
  {
    public static final b Ljw;
    
    static
    {
      AppMethodBeat.i(200496);
      Ljw = new b();
      AppMethodBeat.o(200496);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC
 * JD-Core Version:    0.7.0.1
 */