package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "setMusicManager", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;)V", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Landroid/support/v7/app/AppCompatActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.plugin.finder.life.a
  implements o
{
  public static final a weW;
  private final int dLS;
  private RecyclerView hak;
  public FinderVideoRecycler weH;
  public FinderImgFeedMusicPlayerManager weI;
  r weR;
  public FinderVideoAutoPlayManager weS;
  public com.tencent.mm.plugin.finder.event.c weT;
  public MediaPreloadCore weU;
  public long weV;
  
  static
  {
    AppMethodBeat.i(168046);
    weW = new a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(254272);
    this.dLS = paramInt;
    this.weR = new r();
    AppMethodBeat.o(254272);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(254270);
    p.h(paramAppCompatActivity, "context");
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
    p.g(localObject1, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    this.weH = ((FinderVideoRecycler)localObject1);
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderImgFeedMusicPlayerManager.class);
    p.g(localObject1, "UICProvider.of(context).…layerManager::class.java)");
    this.weI = ((FinderImgFeedMusicPlayerManager)localObject1);
    localObject1 = this.weH;
    if (localObject1 == null) {
      p.btv("recycler");
    }
    ((FinderVideoRecycler)localObject1).a(paramAppCompatActivity, paramBoolean);
    Object localObject2;
    Object localObject3;
    if (paramb != null)
    {
      localObject1 = paramb.dch();
      this.hak = ((RecyclerView)localObject1);
      paramb = paramb.dci();
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class)).MA(this.dLS);
      if (localObject2 != null) {
        this.weT = new com.tencent.mm.plugin.finder.event.c((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      }
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(MediaPreloadCore.class);
      localObject3 = (MediaPreloadCore)localObject2;
      if (this.dLS != -1) {
        break label360;
      }
    }
    label360:
    for (int i = -2147483648;; i = this.dLS)
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      ((MediaPreloadCore)localObject3).a(paramb, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class)).MA(this.dLS));
      this.weU = ((MediaPreloadCore)localObject2);
      this.weR = new r(this.weU);
      paramb = (MMFragmentActivity)paramAppCompatActivity;
      localObject2 = this.weH;
      if (localObject2 == null) {
        p.btv("recycler");
      }
      localObject3 = this.weI;
      if (localObject3 == null) {
        p.btv("musicManager");
      }
      this.weS = new FinderVideoAutoPlayManager(paramb, (RecyclerView)localObject1, (FinderVideoRecycler)localObject2, (FinderImgFeedMusicPlayerManager)localObject3, this.dLS);
      paramb = this.weS;
      if (paramb == null) {
        p.hyc();
      }
      paramb.setup();
      a((MMFragmentActivity)paramAppCompatActivity, (UILifecycleObserver)new FinderVideoCore.onInitialize.2(this, paramAppCompatActivity));
      AppMethodBeat.o(254270);
      return;
    }
  }
  
  public final FinderVideoRecycler dFx()
  {
    AppMethodBeat.i(254268);
    FinderVideoRecycler localFinderVideoRecycler = this.weH;
    if (localFinderVideoRecycler == null) {
      p.btv("recycler");
    }
    AppMethodBeat.o(254268);
    return localFinderVideoRecycler;
  }
  
  public final FinderImgFeedMusicPlayerManager dFy()
  {
    AppMethodBeat.i(254269);
    FinderImgFeedMusicPlayerManager localFinderImgFeedMusicPlayerManager = this.weI;
    if (localFinderImgFeedMusicPlayerManager == null) {
      p.btv("musicManager");
    }
    AppMethodBeat.o(254269);
    return localFinderImgFeedMusicPlayerManager;
  }
  
  public final void dFz()
  {
    AppMethodBeat.i(168043);
    FinderVideoRecycler localFinderVideoRecycler = this.weH;
    if (localFinderVideoRecycler == null) {
      p.btv("recycler");
    }
    localFinderVideoRecycler.J((b)k.c.weY);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.weH;
    if (paramString == null) {
      p.btv("recycler");
    }
    paramString.fJ(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView dch();
    
    public abstract DataBuffer<bo> dci();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.k
 * JD-Core Version:    0.7.0.1
 */