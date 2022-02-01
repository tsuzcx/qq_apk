package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.h;
import com.tencent.mm.view.h.a;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isPlayingWhenDown", "adjustIndicator", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "adjustSeekLayout", "convertMedia", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMediaDoubleClick", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "onPostFinished", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "Companion", "plugin-finder_release"})
public class r
  extends p<u>
{
  public static final a xkK;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private boolean xkJ;
  
  static
  {
    AppMethodBeat.i(244628);
    xkK = new a((byte)0);
    AppMethodBeat.o(244628);
  }
  
  public r(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(244625);
    this.xhU = parami;
    AppMethodBeat.o(244625);
  }
  
  private static void k(final com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(244617);
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    final View localView1 = parami.RD(b.f.finder_feed_full_footer_layout);
    View localView2 = parami.RD(b.f.image_banner_indicator);
    if (localView2 != null)
    {
      localView2.post((Runnable)new b(localView2, parami, localFinderMediaBanner, localView1));
      AppMethodBeat.o(244617);
      return;
    }
    AppMethodBeat.o(244617);
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(244611);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.xhU.dsv());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    View localView = parami.RD(b.f.image_banner_indicator);
    FinderMediaGestureIndicator2 localFinderMediaGestureIndicator2 = (FinderMediaGestureIndicator2)localView;
    localFinderMediaGestureIndicator2.setOnSelectedPageListener((h.a)new i(this, localFinderMediaBanner, paramRecyclerView));
    localFinderMediaGestureIndicator2.setOnTouchListener((View.OnTouchListener)new j(this, localFinderMediaBanner, paramRecyclerView));
    kotlin.g.b.p.j(localView, "holder.getView<FinderMed…e\n            }\n        }");
    localFinderMediaBanner.setIndicator((h)localView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new k(parami));
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
    AppMethodBeat.o(244611);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(244622);
    kotlin.g.b.p.k(parami, "holder");
    kotlin.g.b.p.k(paramView, "view");
    kotlin.g.b.p.k(paramMotionEvent, "e");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parami.ihX();
    Rect localRect = new Rect();
    parami.RD(b.f.image_banner_indicator).getGlobalVisibleRect(localRect);
    if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
    {
      AppMethodBeat.o(244622);
      return;
    }
    if (!localBaseFinderFeed.feedObject.isPostFinish())
    {
      AppMethodBeat.o(244622);
      return;
    }
    if (localBaseFinderFeed.isPreview)
    {
      AppMethodBeat.o(244622);
      return;
    }
    parami = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    if (!((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(localBaseFinderFeed.feedObject.getFeedObject()).Mx).booleanValue()) {
      w.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(b.j.finder_feed_liked_closed_warning), 0).show();
    }
    AppMethodBeat.o(244622);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(244621);
    kotlin.g.b.p.k(parami, "holder");
    super.a(parami, paramFinderItem, paramBoolean);
    k(parami);
    AppMethodBeat.o(244621);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(244609);
    d locald = d.AjH;
    if (((Number)d.dXx().aSr()).intValue() == 1)
    {
      i = b.g._finder_feed_full_image_item_new;
      AppMethodBeat.o(244609);
      return i;
    }
    int i = b.g._finder_feed_full_image_item;
    AppMethodBeat.o(244609);
    return i;
  }
  
  public final void h(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(244619);
    kotlin.g.b.p.k(parami, "holder");
    View localView1 = parami.RD(b.f.finder_seek_bar_footer_layout);
    if (localView1 == null)
    {
      AppMethodBeat.o(244619);
      return;
    }
    View localView2 = parami.RD(b.f.image_banner_indicator);
    View localView3 = localView1.findViewById(b.f.awesome_ground_layout);
    if (localView3 != null)
    {
      localView2.post((Runnable)new r.c(localView3, localView2, parami, localView1));
      AppMethodBeat.o(244619);
      return;
    }
    AppMethodBeat.o(244619);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$adjustIndicator$1$1"})
  static final class b
    implements Runnable
  {
    b(View paramView1, com.tencent.mm.view.recyclerview.i parami, FinderMediaBanner paramFinderMediaBanner, View paramView2) {}
    
    public final void run()
    {
      AppMethodBeat.i(279790);
      Object localObject2 = new int[2];
      Object localObject1 = new int[2];
      int[] arrayOfInt = new int[2];
      parami.amk.getLocationInWindow((int[])localObject2);
      localFinderMediaBanner.getLocationInWindow((int[])localObject1);
      localObject1[0] -= localObject2[0];
      localObject1[1] -= localObject2[1];
      localView1.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] -= localObject2[0];
      arrayOfInt[1] -= localObject2[1];
      int i = arrayOfInt[1];
      localObject2 = localView1;
      kotlin.g.b.p.j(localObject2, "view");
      arrayOfInt[1] = (i + ((View)localObject2).getPaddingTop());
      localObject2 = this.xkL.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(279790);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      i = ((FrameLayout.LayoutParams)localObject2).topMargin;
      Object localObject3 = parami.getContext();
      kotlin.g.b.p.j(localObject3, "holder.context");
      ((Context)localObject3).getResources().getDimension(b.d.Edge_A);
      int j = localObject1[1];
      localObject3 = localFinderMediaBanner;
      kotlin.g.b.p.j(localObject3, "banner");
      if (j + ((FinderMediaBanner)localObject3).getHeight() + this.xkL.getHeight() >= arrayOfInt[1]) {}
      for (((FrameLayout.LayoutParams)localObject2).topMargin = (arrayOfInt[1] - this.xkL.getHeight());; ((FrameLayout.LayoutParams)localObject2).topMargin = (j + ((FinderMediaBanner)localObject1).getHeight()))
      {
        if (((FrameLayout.LayoutParams)localObject2).topMargin != i) {
          this.xkL.requestLayout();
        }
        AppMethodBeat.o(279790);
        return;
        j = localObject1[1];
        localObject1 = localFinderMediaBanner;
        kotlin.g.b.p.j(localObject1, "banner");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$6$1"})
  static final class d
    extends q
    implements a<Boolean>
  {
    d(FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, u paramu)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$6$2"})
  static final class e
    extends q
    implements a<x>
  {
    e(FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag, FinderFullSeekBarLayout paramFinderFullSeekBarLayout, u paramu)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$6$3"})
  static final class f
    extends q
    implements a<Boolean>
  {
    f(FinderFullSeekBarLayout paramFinderFullSeekBarLayout1, FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag, FinderFullSeekBarLayout paramFinderFullSeekBarLayout2, u paramu)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"})
  public static final class g
    implements h.a
  {
    g(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void Mc(int paramInt)
    {
      AppMethodBeat.i(290933);
      MediaBanner.a(this.xkT, paramInt);
      AppMethodBeat.o(290933);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"})
  public static final class i
    implements h.a
  {
    i(r paramr, FinderMediaBanner paramFinderMediaBanner, RecyclerView paramRecyclerView) {}
    
    public final void Mc(int paramInt)
    {
      AppMethodBeat.i(289597);
      MediaBanner.a(localFinderMediaBanner, paramInt);
      AppMethodBeat.o(289597);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$2"})
  static final class j
    implements View.OnTouchListener
  {
    j(r paramr, FinderMediaBanner paramFinderMediaBanner, RecyclerView paramRecyclerView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class k
    implements MediaBanner.c
  {
    k(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(286742);
      u localu = (u)this.tDl.ihX();
      if (paramInt < localu.feedObject.getMediaList().size())
      {
        Object localObject1 = localu.feedObject.getMediaList().get(paramInt);
        kotlin.g.b.p.j(localObject1, "feed.feedObject.mediaList[position]");
        localObject1 = (csg)localObject1;
        localu.currentFocusPos = paramInt;
        Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject2 = this.tDl.getContext();
        kotlin.g.b.p.j(localObject2, "holder.context");
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new com.tencent.mm.plugin.finder.report.aj(com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2)).dQy();
          long l = localu.feedObject.getId();
          String str = localu.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localu.feedObject.getMediaList());
          kotlin.g.b.p.j(localu, "feed");
          ((com.tencent.mm.plugin.finder.report.aj.a)localObject2).a(l, (csg)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localu, paramBoolean2);
          AppMethodBeat.o(286742);
          return;
        }
      }
      AppMethodBeat.o(286742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */