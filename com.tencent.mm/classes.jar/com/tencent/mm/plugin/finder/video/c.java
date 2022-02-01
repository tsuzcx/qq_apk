package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "eventSubscribers", "Lcom/tencent/mm/plugin/finder/event/FinderEventSubscribers;", "getEventSubscribers", "()Lcom/tencent/mm/plugin/finder/event/FinderEventSubscribers;", "setEventSubscribers", "(Lcom/tencent/mm/plugin/finder/event/FinderEventSubscribers;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Lcom/tencent/mm/ui/MMActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
  implements n
{
  public static final a qTM;
  private final int IoU;
  public FinderVideoRecycler Lcs;
  public MediaPreloadCore Lct;
  private RecyclerView fPw;
  m qTG;
  public FinderVideoAutoPlayManager qTH;
  public com.tencent.mm.plugin.finder.event.a qTI;
  public long qTL;
  
  static
  {
    AppMethodBeat.i(168046);
    qTM = new a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(199785);
    this.IoU = paramInt;
    this.qTG = new m();
    AppMethodBeat.o(199785);
  }
  
  public final void a(MMActivity paramMMActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(199783);
    k.h(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.ui.component.a.LCX;
    localObject1 = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoRecycler.class);
    k.g(localObject1, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    this.Lcs = ((FinderVideoRecycler)localObject1);
    localObject1 = this.Lcs;
    if (localObject1 == null) {
      k.aPZ("recycler");
    }
    ((FinderVideoRecycler)localObject1).d(paramMMActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.clN();
      this.fPw = ((RecyclerView)localObject1);
      paramb = paramb.fSX();
      Object localObject2 = com.tencent.mm.ui.component.a.LCX;
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).ahW(this.IoU);
      if (localObject2 != null)
      {
        localObject2 = new com.tencent.mm.plugin.finder.event.a((RecyclerView)localObject1, (d)localObject2);
        ((com.tencent.mm.plugin.finder.event.a)localObject2).Bu();
        this.qTI = ((com.tencent.mm.plugin.finder.event.a)localObject2);
      }
      localObject2 = com.tencent.mm.ui.component.a.LCX;
      localObject2 = com.tencent.mm.ui.component.a.s(paramMMActivity).get(MediaPreloadCore.class);
      MediaPreloadCore localMediaPreloadCore = (MediaPreloadCore)localObject2;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
      localMediaPreloadCore.a(paramb, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).ahW(this.IoU));
      this.Lct = ((MediaPreloadCore)localObject2);
      this.qTG = new m(this.Lct);
      paramb = this.Lcs;
      if (paramb == null) {
        k.aPZ("recycler");
      }
      this.qTH = new FinderVideoAutoPlayManager(paramMMActivity, (RecyclerView)localObject1, paramb, this.IoU);
      paramb = this.qTH;
      if (paramb == null) {
        k.fvU();
      }
      paramb.setup();
    }
    a(paramMMActivity, (UILifecycleObserver)new FinderVideoCore.onInitialize.2(this, paramMMActivity));
    AppMethodBeat.o(199783);
  }
  
  public final void csl()
  {
    AppMethodBeat.i(168043);
    FinderVideoRecycler localFinderVideoRecycler = this.Lcs;
    if (localFinderVideoRecycler == null) {
      k.aPZ("recycler");
    }
    localFinderVideoRecycler.J((b)c.c.qTO);
    AppMethodBeat.o(168043);
  }
  
  public final FinderVideoRecycler fWq()
  {
    AppMethodBeat.i(199782);
    FinderVideoRecycler localFinderVideoRecycler = this.Lcs;
    if (localFinderVideoRecycler == null) {
      k.aPZ("recycler");
    }
    AppMethodBeat.o(199782);
    return localFinderVideoRecycler;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.Lcs;
    if (paramString == null) {
      k.aPZ("recycler");
    }
    paramString.lD(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView clN();
    
    public abstract DataBuffer<BaseFinderFeed> fSX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c
 * JD-Core Version:    0.7.0.1
 */