package com.tencent.mm.plugin.finder.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.a;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.live.n;
import com.tencent.mm.plugin.finder.loader.ad;
import com.tencent.mm.plugin.finder.loader.z;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "liveListPlayManager", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;", "getLiveListPlayManager", "()Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;", "setLiveListPlayManager", "(Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;)V", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "setMusicManager", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;)V", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Landroidx/appcompat/app/AppCompatActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class l
  extends a
  implements o
{
  public static final a ANF;
  public FinderVideoAutoPlayManager ANA;
  public com.tencent.mm.plugin.finder.event.c ANB;
  public com.tencent.mm.plugin.finder.preload.c ANC;
  public long ANE;
  public au ANw;
  public com.tencent.mm.plugin.finder.music.b ANx;
  public n ANy;
  ad ANz;
  final int fEH;
  private RecyclerView jLl;
  
  static
  {
    AppMethodBeat.i(168046);
    ANF = new a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(291930);
    this.fEH = paramInt;
    this.ANz = ((ad)new z());
    AppMethodBeat.o(291930);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(291928);
    p.k(paramAppCompatActivity, "context");
    Object localObject1 = g.Xox;
    this.ANw = ((au)g.bD(ak.class).bE(au.class));
    localObject1 = g.Xox;
    localObject1 = g.b(paramAppCompatActivity).i(com.tencent.mm.plugin.finder.music.b.class);
    p.j(localObject1, "UICProvider.of(context).…layerManager::class.java)");
    this.ANx = ((com.tencent.mm.plugin.finder.music.b)localObject1);
    localObject1 = g.Xox;
    localObject1 = g.b(paramAppCompatActivity).i(v.class);
    p.j(localObject1, "UICProvider.of(context).…oPlayManager::class.java)");
    this.ANy = ((n)localObject1);
    localObject1 = this.ANw;
    if (localObject1 == null) {
      p.bGy("recycler");
    }
    ((au)localObject1).a(paramAppCompatActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.dsx();
      this.jLl = ((RecyclerView)localObject1);
      paramb = paramb.dsy();
      Object localObject2 = g.Xox;
      localObject2 = ((aj)g.b(paramAppCompatActivity).i(aj.class)).RU(this.fEH);
      if (localObject2 != null) {
        this.ANB = new com.tencent.mm.plugin.finder.event.c((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      }
      localObject2 = g.Xox;
      localObject2 = g.b(paramAppCompatActivity).i(com.tencent.mm.plugin.finder.preload.c.class);
      Object localObject3 = (com.tencent.mm.plugin.finder.preload.c)localObject2;
      Object localObject4 = g.Xox;
      localObject4 = g.b(paramAppCompatActivity).i(aj.class);
      p.j(localObject4, "UICProvider.of(context).…rReporterUIC::class.java)");
      localObject4 = (aj)localObject4;
      ((com.tencent.mm.plugin.finder.preload.c)localObject3).a(paramb, ((aj)localObject4).xkX, ((aj)localObject4).RU(this.fEH));
      this.ANC = ((com.tencent.mm.plugin.finder.preload.c)localObject2);
      this.ANz = ((ad)new z(this.ANC));
      paramb = (MMFragmentActivity)paramAppCompatActivity;
      localObject2 = this.ANw;
      if (localObject2 == null) {
        p.bGy("recycler");
      }
      localObject3 = this.ANx;
      if (localObject3 == null) {
        p.bGy("musicManager");
      }
      localObject4 = this.ANy;
      if (localObject4 == null) {
        p.bGy("liveListPlayManager");
      }
      this.ANA = new FinderVideoAutoPlayManager(paramb, (RecyclerView)localObject1, (au)localObject2, (com.tencent.mm.plugin.finder.music.b)localObject3, (n)localObject4, this.fEH);
      paramb = this.ANA;
      if (paramb == null) {
        p.iCn();
      }
      paramb.setup();
    }
    a((MMFragmentActivity)paramAppCompatActivity, (com.tencent.mm.plugin.finder.life.b)new FinderVideoCore.onInitialize.2(this, paramAppCompatActivity));
    AppMethodBeat.o(291928);
  }
  
  public final au ehl()
  {
    AppMethodBeat.i(291925);
    au localau = this.ANw;
    if (localau == null) {
      p.bGy("recycler");
    }
    AppMethodBeat.o(291925);
    return localau;
  }
  
  public final com.tencent.mm.plugin.finder.music.b ehm()
  {
    AppMethodBeat.i(291926);
    com.tencent.mm.plugin.finder.music.b localb = this.ANx;
    if (localb == null) {
      p.bGy("musicManager");
    }
    AppMethodBeat.o(291926);
    return localb;
  }
  
  public final n ehn()
  {
    AppMethodBeat.i(291927);
    n localn = this.ANy;
    if (localn == null) {
      p.bGy("liveListPlayManager");
    }
    AppMethodBeat.o(291927);
    return localn;
  }
  
  public final void eho()
  {
    AppMethodBeat.i(168043);
    au localau = this.ANw;
    if (localau == null) {
      p.bGy("recycler");
    }
    localau.Q((kotlin.g.a.b)l.c.ANH);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.ANw;
    if (paramString == null) {
      p.bGy("recycler");
    }
    paramString.gb(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView dsx();
    
    public abstract DataBuffer<bu> dsy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */