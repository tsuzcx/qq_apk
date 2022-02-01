package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.is;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "listener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderEnhanceActionEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "listener$delegate", "Lkotlin/Lazy;", "onFeedBindViewHolder", "Lkotlin/Function4;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "", "getOnFeedBindViewHolder", "()Lkotlin/jvm/functions/Function4;", "setOnFeedBindViewHolder", "(Lkotlin/jvm/functions/Function4;)V", "convertMedia", "holder", "item", "position", "type", "formatSecToMin", "", "second", "getLayoutId", "hasSomeDiff", "newList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "oldList", "jumpToMegaVideo", "context", "Landroid/content/Context;", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "refreshEnhanceView", "event", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class t
  extends FinderFeedFullConvert<com.tencent.mm.plugin.finder.model.ah>
{
  public static final a AJJ;
  private final com.tencent.mm.plugin.finder.feed.i AIh;
  private r<? super Integer, ? super com.tencent.mm.plugin.finder.model.ah, ? super com.tencent.mm.view.recyclerview.j, ? super Integer, kotlin.ah> AJK;
  private final kotlin.j AJL;
  private final l AJn;
  
  static
  {
    AppMethodBeat.i(350655);
    AJJ = new a((byte)0);
    AppMethodBeat.o(350655);
  }
  
  public t(l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(350596);
    this.AJn = paraml;
    this.AIh = parami;
    this.AJL = k.cm((a)new f(this));
    AppMethodBeat.o(350596);
  }
  
  private static final void a(t paramt, int paramInt1, com.tencent.mm.plugin.finder.model.ah paramah, com.tencent.mm.view.recyclerview.j paramj, int paramInt2)
  {
    AppMethodBeat.i(350629);
    s.u(paramt, "this$0");
    s.u(paramah, "$item");
    s.u(paramj, "$holder");
    paramt = paramt.AJK;
    if (paramt != null) {
      paramt.a(Integer.valueOf(paramInt1), paramah, paramj, Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(350629);
  }
  
  private final IListener<is> dXE()
  {
    AppMethodBeat.i(350616);
    IListener localIListener = (IListener)this.AJL.getValue();
    AppMethodBeat.o(350616);
    return localIListener;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350711);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    if (this.hJx == 4) {
      dXE().alive();
    }
    AppMethodBeat.o(350711);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350687);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.AIh.ebz());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    paramRecyclerView = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
    if (paramRecyclerView != null) {
      paramRecyclerView.setFloatPlayIcon((WeImageView)paramj.UH(e.e.float_play_icon));
    }
    Log.i("Finder.FeedFullVideoConvert", "onCreateViewHolder type:" + paramInt + " holder:" + paramj);
    AppMethodBeat.o(350687);
  }
  
  public void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.ah paramah, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350698);
    s.u(paramj, "holder");
    s.u(paramah, "item");
    Log.i("Finder.FeedFullVideoConvert", "onBindViewHolder position:" + paramInt1 + " type:" + paramInt2 + " holder:" + paramj);
    super.a(paramj, (BaseFinderFeed)paramah, paramInt1, paramInt2, paramBoolean, paramList);
    AppMethodBeat.o(350698);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350716);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    if (this.hJx == 4) {
      dXE().dead();
    }
    this.AJK = null;
    AppMethodBeat.o(350716);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_full_video_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isPause", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Boolean, FinderVideoLayout.b, kotlin.ah>
  {
    b(com.tencent.mm.view.recyclerview.j paramj, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Boolean>
  {
    c(com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<Boolean>
  {
    e(com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$listener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<FinderFeedFullVideoConvert.listener.2.1>
  {
    f(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */