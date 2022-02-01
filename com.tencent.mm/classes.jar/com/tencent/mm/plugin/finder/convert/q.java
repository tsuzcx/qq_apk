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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.ay;
import com.tencent.mm.plugin.finder.report.ay.a;
import com.tencent.mm.plugin.finder.report.ay.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.i.a;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isPlayingWhenDown", "adjustIndicator", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "adjustSeekLayout", "convertMedia", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onFocusFeedCenter", "onMediaDoubleClick", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "onPostFinished", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFinderLivingStatusView", "refreshRealNameRecommendLayout", "refeshByClick", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class q
  extends FinderFeedFullConvert<v>
{
  public static final a AJd;
  private final com.tencent.mm.plugin.finder.feed.i AIh;
  private boolean AJe;
  
  static
  {
    AppMethodBeat.i(350607);
    AJd = new a((byte)0);
    AppMethodBeat.o(350607);
  }
  
  public q(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(350552);
    this.AIh = parami;
    AppMethodBeat.o(350552);
  }
  
  private static final void a(j paramj, View paramView1, View paramView2, View paramView3)
  {
    AppMethodBeat.i(350591);
    s.u(paramj, "$holder");
    s.u(paramView1, "$indicator");
    s.u(paramView2, "$seekLayout");
    s.u(paramView3, "$awesome");
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    paramj.caK.getLocationInWindow((int[])localObject);
    paramView1.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] -= localObject[0];
    arrayOfInt[1] -= localObject[1];
    paramj = paramView1.getLayoutParams();
    if (paramj == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(350591);
      throw paramj;
    }
    paramj = (FrameLayout.LayoutParams)paramj;
    localObject = paramView2.getLayoutParams();
    if (localObject == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(350591);
      throw paramj;
    }
    ((FrameLayout.LayoutParams)localObject).topMargin = (paramj.topMargin + (paramView1.getHeight() - paramView3.getHeight()) / 2);
    paramView2.requestLayout();
    AppMethodBeat.o(350591);
  }
  
  private static final void a(j paramj, FinderMediaBanner paramFinderMediaBanner, View paramView1, View paramView2)
  {
    AppMethodBeat.i(350580);
    s.u(paramj, "$holder");
    s.u(paramView2, "$indicator");
    int[] arrayOfInt3 = new int[2];
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramj.caK.getLocationInWindow(arrayOfInt3);
    paramFinderMediaBanner.getLocationInWindow(arrayOfInt1);
    arrayOfInt1[0] -= arrayOfInt3[0];
    arrayOfInt1[1] -= arrayOfInt3[1];
    paramView1.getLocationInWindow(arrayOfInt2);
    arrayOfInt2[0] -= arrayOfInt3[0];
    arrayOfInt2[1] -= arrayOfInt3[1];
    arrayOfInt2[1] += paramView1.getPaddingTop();
    paramView1 = paramView2.getLayoutParams();
    if (paramView1 == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(350580);
      throw paramj;
    }
    paramView1 = (FrameLayout.LayoutParams)paramView1;
    int i = paramView1.topMargin;
    paramj.context.getResources().getDimension(e.c.Edge_A);
    if (arrayOfInt1[1] + paramFinderMediaBanner.getHeight() + paramView2.getHeight() >= arrayOfInt2[1]) {}
    for (paramView1.topMargin = (arrayOfInt2[1] - paramView2.getHeight());; paramView1.topMargin = (arrayOfInt1[1] + paramFinderMediaBanner.getHeight()))
    {
      if (paramView1.topMargin != i) {
        paramView2.requestLayout();
      }
      AppMethodBeat.o(350580);
      return;
    }
  }
  
  private static void q(j paramj)
  {
    AppMethodBeat.i(350569);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    View localView1 = paramj.UH(e.e.finder_feed_full_footer_layout);
    View localView2 = paramj.UH(e.e.image_banner_indicator);
    if (localView2 != null) {
      localView2.post(new q..ExternalSyntheticLambda1(paramj, localFinderMediaBanner, localView1, localView2));
    }
    AppMethodBeat.o(350569);
  }
  
  public final void a(final RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350632);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.AIh.ebz());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    View localView = paramj.UH(e.e.image_banner_indicator);
    FinderMediaGestureIndicator2 localFinderMediaGestureIndicator2 = (FinderMediaGestureIndicator2)localView;
    localFinderMediaGestureIndicator2.setOnSelectedPageListener((i.a)new g(localFinderMediaBanner));
    localFinderMediaGestureIndicator2.setOnTouchListener((View.OnTouchListener)new h(this, localFinderMediaBanner, paramRecyclerView));
    paramRecyclerView = ah.aiuX;
    s.s(localView, "holder.getView<FinderMed…e\n            }\n        }");
    localFinderMediaBanner.setIndicator((com.tencent.mm.view.i)localView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new i(paramj));
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
    AppMethodBeat.o(350632);
  }
  
  public final void a(j paramj, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(350665);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    s.u(paramMotionEvent, "e");
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
    Rect localRect = new Rect();
    paramj.UH(e.e.image_banner_indicator).getGlobalVisibleRect(localRect);
    if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
    {
      AppMethodBeat.o(350665);
      return;
    }
    if (!localBaseFinderFeed.feedObject.isPostFinish())
    {
      AppMethodBeat.o(350665);
      return;
    }
    if (localBaseFinderFeed.isPreview)
    {
      AppMethodBeat.o(350665);
      return;
    }
    paramj = l.Gdj;
    if (!((Boolean)l.fek().u(localBaseFinderFeed.feedObject.getFeedObject()).bsC).booleanValue()) {
      aa.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(e.h.finder_feed_liked_closed_warning), 0).show();
    }
    AppMethodBeat.o(350665);
  }
  
  public void a(j paramj, v paramv)
  {
    AppMethodBeat.i(350654);
    s.u(paramj, "holder");
    s.u(paramv, "item");
    super.g(paramj, (BaseFinderFeed)paramv);
    q(paramj);
    AppMethodBeat.o(350654);
  }
  
  public final void a(j paramj, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    AppMethodBeat.i(350649);
    s.u(paramj, "holder");
    super.a(paramj, paramFinderItem, paramBoolean);
    q(paramj);
    AppMethodBeat.o(350649);
  }
  
  public final void e(j paramj)
  {
    AppMethodBeat.i(350639);
    s.u(paramj, "holder");
    RecyclerView localRecyclerView = this.mkw;
    int i;
    int k;
    if (localRecyclerView != null)
    {
      i = 0;
      k = localRecyclerView.getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      paramj = localRecyclerView.getChildAt(i);
      if (paramj != null)
      {
        paramj = localRecyclerView.bj(paramj);
        if (!(paramj instanceof j)) {
          break label100;
        }
      }
      label100:
      for (paramj = (j)paramj;; paramj = null)
      {
        if ((paramj != null) && (paramj.caO == 2)) {
          q(paramj);
        }
        if (j < k) {
          break;
        }
        AppMethodBeat.o(350639);
        return;
      }
      i = j;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_full_image_item;
  }
  
  public final void n(j paramj)
  {
    AppMethodBeat.i(350644);
    s.u(paramj, "holder");
    View localView1 = paramj.UH(e.e.finder_seek_bar_footer_layout);
    if (localView1 == null)
    {
      AppMethodBeat.o(350644);
      return;
    }
    View localView2 = paramj.UH(e.e.image_banner_indicator);
    if (localView2 == null)
    {
      AppMethodBeat.o(350644);
      return;
    }
    View localView3 = localView1.findViewById(e.e.awesome_ground_layout);
    if (localView3 != null) {
      localView2.post(new q..ExternalSyntheticLambda0(paramj, localView2, localView1, localView3));
    }
    AppMethodBeat.o(350644);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.a
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void Ng(int paramInt)
    {
      AppMethodBeat.i(349608);
      FinderMediaBanner localFinderMediaBanner = this.AJf;
      s.s(localFinderMediaBanner, "banner");
      MediaBanner.a((MediaBanner)localFinderMediaBanner, paramInt);
      AppMethodBeat.o(349608);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Boolean>
  {
    d(FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<Boolean>
  {
    f(FinderMediaBanner paramFinderMediaBanner, FinderFullSeekBarLayout paramFinderFullSeekBarLayout1, FinderImgFeedMusicTag paramFinderImgFeedMusicTag, FinderFullSeekBarLayout paramFinderFullSeekBarLayout2, v paramv)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.a
  {
    g(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void Ng(int paramInt)
    {
      AppMethodBeat.i(349629);
      FinderMediaBanner localFinderMediaBanner = this.AJf;
      s.s(localFinderMediaBanner, "banner");
      MediaBanner.a((MediaBanner)localFinderMediaBanner, paramInt);
      AppMethodBeat.o(349629);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    implements View.OnTouchListener
  {
    h(q paramq, FinderMediaBanner paramFinderMediaBanner, RecyclerView paramRecyclerView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(349624);
      if (paramMotionEvent.getAction() == 0)
      {
        q.a(this.AJk, localFinderMediaBanner.isAutoPlay);
        localFinderMediaBanner.setAutoPlay(false);
        paramView = paramRecyclerView.getLayoutManager();
        if ((paramView == null) || (!(paramView instanceof FinderLinearLayoutManager))) {}
      }
      for (((FinderLinearLayoutManager)paramView).GHU = false;; ((FinderLinearLayoutManager)paramView).GHU = true) {
        do
        {
          do
          {
            AppMethodBeat.o(349624);
            return false;
          } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
          localFinderMediaBanner.setAutoPlay(q.a(this.AJk));
          paramView = paramRecyclerView.getLayoutManager();
        } while ((paramView == null) || (!(paramView instanceof FinderLinearLayoutManager)));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements MediaBanner.c
  {
    i(j paramj) {}
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(349592);
      v localv = (v)this.wHm.CSA;
      if (paramInt < localv.feedObject.getMediaList().size())
      {
        Object localObject1 = localv.feedObject.getMediaList().get(paramInt);
        s.s(localObject1, "feed.feedObject.mediaList[position]");
        localObject1 = (dji)localObject1;
        localv.currentFocusPos = paramInt;
        Object localObject2 = as.GSQ;
        localObject2 = this.wHm.context;
        s.s(localObject2, "holder.context");
        localObject2 = as.a.hu((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = (ay.a)new ay.c(new ay(((bn)localObject2).Vm(-1)));
          long l = localv.feedObject.getId();
          String str = localv.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localv.feedObject.getMediaList());
          s.s(localv, "feed");
          ((ay.a)localObject2).a(l, (dji)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localv, paramBoolean2);
        }
      }
      AppMethodBeat.o(349592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.q
 * JD-Core Version:    0.7.0.1
 */