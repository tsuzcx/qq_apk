package com.tencent.mm.plugin.finder.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.a;
import com.tencent.mm.plugin.finder.loader.u;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.f;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "setMusicManager", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;)V", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;)V", "isBlockOnPauseAction", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "Landroidx/appcompat/app/AppCompatActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
  implements q
{
  public static final a GpV;
  public bi GpW;
  public com.tencent.mm.plugin.finder.music.b GpX;
  y GpY;
  public FinderVideoAutoPlayManager GpZ;
  public com.tencent.mm.plugin.finder.event.c Gqa;
  public f Gqb;
  long Gqc;
  private final int hJx;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(168046);
    GpV = new a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(334754);
    this.hJx = paramInt;
    this.GpY = ((y)new u());
    AppMethodBeat.o(334754);
  }
  
  private void a(y paramy)
  {
    AppMethodBeat.i(334784);
    s.u(paramy, "<set-?>");
    this.GpY = paramy;
    AppMethodBeat.o(334784);
  }
  
  private void a(com.tencent.mm.plugin.finder.music.b paramb)
  {
    AppMethodBeat.i(334777);
    s.u(paramb, "<set-?>");
    this.GpX = paramb;
    AppMethodBeat.o(334777);
  }
  
  private void a(bi parambi)
  {
    AppMethodBeat.i(334770);
    s.u(parambi, "<set-?>");
    this.GpW = parambi;
    AppMethodBeat.o(334770);
  }
  
  public static boolean fjs()
  {
    return false;
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(334834);
    s.u(paramAppCompatActivity, "context");
    Object localObject1 = k.aeZF;
    a((bi)k.cn(cn.class).cq(bi.class));
    localObject1 = k.aeZF;
    localObject1 = k.d(paramAppCompatActivity).q(com.tencent.mm.plugin.finder.music.b.class);
    s.s(localObject1, "UICProvider.of(context).…layerManager::class.java)");
    a((com.tencent.mm.plugin.finder.music.b)localObject1);
    fjp().a(paramAppCompatActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.ebB();
      this.mkw = ((RecyclerView)localObject1);
      Object localObject2 = paramb.ebE();
      Object localObject3 = k.aeZF;
      localObject3 = ((as)k.d(paramAppCompatActivity).q(as.class)).Vm(this.hJx);
      if (localObject3 != null) {
        this.Gqa = new com.tencent.mm.plugin.finder.event.c((com.tencent.mm.plugin.finder.event.base.c)localObject3);
      }
      if (paramb.ebC())
      {
        localObject3 = k.aeZF;
        localObject3 = k.d(paramAppCompatActivity).q(f.class);
        f localf = (f)localObject3;
        Object localObject4 = k.aeZF;
        localObject4 = k.d(paramAppCompatActivity).q(as.class);
        s.s(localObject4, "UICProvider.of(context).…rReporterUIC::class.java)");
        localObject4 = (as)localObject4;
        localf.a((DataBuffer)localObject2, ((as)localObject4).AJo, ((as)localObject4).Vm(this.hJx));
        localObject2 = ah.aiuX;
        this.Gqb = ((f)localObject3);
      }
      a((y)new u(this.Gqb));
      if (paramb.ebD())
      {
        this.GpZ = new FinderVideoAutoPlayManager((MMFragmentActivity)paramAppCompatActivity, (RecyclerView)localObject1, fjp(), fjq(), this.hJx);
        paramb = this.GpZ;
        s.checkNotNull(paramb);
        paramb.setup();
      }
    }
    a((MMFragmentActivity)paramAppCompatActivity, (com.tencent.mm.plugin.finder.life.b)new FinderVideoCore.onInitialize.2(this, paramAppCompatActivity));
    AppMethodBeat.o(334834);
  }
  
  public final bi fjp()
  {
    AppMethodBeat.i(334820);
    bi localbi = this.GpW;
    if (localbi != null)
    {
      AppMethodBeat.o(334820);
      return localbi;
    }
    s.bIx("recycler");
    AppMethodBeat.o(334820);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.music.b fjq()
  {
    AppMethodBeat.i(334825);
    com.tencent.mm.plugin.finder.music.b localb = this.GpX;
    if (localb != null)
    {
      AppMethodBeat.o(334825);
      return localb;
    }
    s.bIx("musicManager");
    AppMethodBeat.o(334825);
    return null;
  }
  
  public final void fjr()
  {
    AppMethodBeat.i(168043);
    fjp().aw((kotlin.g.a.b)l.c.Gqf);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    fjp().hw(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract RecyclerView ebB();
    
    public abstract boolean ebC();
    
    public abstract boolean ebD();
    
    public abstract DataBuffer<cc> ebE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */