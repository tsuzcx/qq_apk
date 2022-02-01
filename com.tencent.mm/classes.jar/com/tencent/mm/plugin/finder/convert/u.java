package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.if;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.h;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "listener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderEnhanceActionEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "listener$delegate", "Lkotlin/Lazy;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "formatSecToMin", "", "second", "getLayoutId", "jumpToMegaVideo", "context", "Landroid/content/Context;", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onCreateViewHolder", "onDetachedFromRecyclerView", "refreshEnhanceView", "event", "Companion", "plugin-finder_release"})
public class u
  extends p<af>
{
  public static final a xlj;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private final f xli;
  
  static
  {
    AppMethodBeat.i(276834);
    xlj = new a((byte)0);
    AppMethodBeat.o(276834);
  }
  
  public u(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(276832);
    this.xkW = paraml;
    this.xhU = parami;
    this.xli = g.ar((a)new f(this));
    AppMethodBeat.o(276832);
  }
  
  private final IListener<if> dpA()
  {
    AppMethodBeat.i(276829);
    IListener localIListener = (IListener)this.xli.getValue();
    AppMethodBeat.o(276829);
    return localIListener;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(276830);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    if (this.fEH == 4) {
      dpA().alive();
    }
    AppMethodBeat.o(276830);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(276826);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.xhU.dsv());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    paramRecyclerView = (FinderFullSeekBarLayout)parami.RD(b.f.full_seek_bar_layout);
    if (paramRecyclerView != null)
    {
      paramRecyclerView.setFloatPlayIcon((WeImageView)parami.RD(b.f.float_play_icon));
      AppMethodBeat.o(276826);
      return;
    }
    AppMethodBeat.o(276826);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(276831);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    if (this.fEH == 4) {
      dpA().dead();
    }
    AppMethodBeat.o(276831);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(276825);
    d locald = d.AjH;
    if (((Number)d.dXx().aSr()).intValue() == 1)
    {
      i = b.g._finder_feed_full_video_item_new;
      AppMethodBeat.o(276825);
      return i;
    }
    int i = b.g._finder_feed_full_video_item;
    AppMethodBeat.o(276825);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$1"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$2"})
  static final class c
    extends q
    implements a<x>
  {
    c(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$3"})
  static final class d
    extends q
    implements a<Boolean>
  {
    d(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isPause", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
  static final class e
    extends q
    implements m<Boolean, FinderVideoLayout.b, x>
  {
    e(com.tencent.mm.view.recyclerview.i parami, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$listener$2$1", "invoke", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$listener$2$1;"})
  static final class f
    extends q
    implements a<1>
  {
    f(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.u
 * JD-Core Version:    0.7.0.1
 */