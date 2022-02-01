package com.tencent.mm.plugin.finder.video.autoplay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter;", "", "()V", "SCREEN_HEIGHT", "", "curScrollDirection", "enableCheckVisibilityFeed", "", "isShowFirst", "lastFocusFeedId", "", "lastSelectedFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "mediaRect", "Landroid/graphics/Rect;", "onFeedChangeCallback", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tabType", "timeConsumingTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "bindFeed", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "bindFinderFeedFullVideoConvert", "bindPrepareFeedListener", "bindRecyclerView", "checkIsCareVisibleFeed", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "feedList", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "checkScrollDirectionChanged", "unselectedFeed", "selectedFeed", "checkSelect", "forceCheckSame", "checkSelectedInternal", "otherCareType", "", "invokeSource", "", "dispatchOnFeedSelected", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "dispatchOnFeedUnSelected", "dispatchOnNextFeedPrepare", "getCenterFeed", "position", "handleOnPageSelected", "handleOnScrollStateChanged", "newState", "isNextFeed", "curPos", "nextFeed", "isValidFeed", "postCheckSelect", "publishFocusView", "selectedFeedId", "setOnFeedChangeCallback", "translateRVFeedToFeedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "Companion", "OnFeedChangeCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a GrJ;
  private boolean BwR;
  private final int CCP;
  private long Fsw;
  private final Rect GiR;
  b GrK;
  private d GrL;
  private int GrM;
  private final c GrN;
  private final boolean GrO;
  int hJx;
  RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(335545);
    GrJ = new a((byte)0);
    AppMethodBeat.o(335545);
  }
  
  public a()
  {
    AppMethodBeat.i(335354);
    this.CCP = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    this.hJx = -1;
    this.GiR = new Rect();
    this.GrL = new d(false, null, 255);
    this.GrM = 1;
    this.Fsw = -1L;
    this.GrN = new c("FinderFeedSelectorAdapter");
    this.BwR = true;
    this.GrO = ((g)com.tencent.mm.kernel.h.ax(g.class)).bUv();
    AppMethodBeat.o(335354);
  }
  
  private final d a(int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    aw localaw = null;
    AppMethodBeat.i(335438);
    Object localObject = paramj;
    if (paramj == null)
    {
      paramj = this.mkw;
      if (paramj != null) {
        break label78;
      }
      paramj = null;
      if (!(paramj instanceof com.tencent.mm.view.recyclerview.j)) {
        break label88;
      }
    }
    label78:
    label88:
    for (localObject = (com.tencent.mm.view.recyclerview.j)paramj;; localObject = null)
    {
      if (localObject != null) {
        break label93;
      }
      Log.w("FinderFeedSelectorAdapter", "handleOnPageSelected return for holder:" + localObject + " position:" + paramInt);
      AppMethodBeat.o(335438);
      return null;
      paramj = paramj.w(paramInt, false);
      break;
    }
    label93:
    paramj = ((com.tencent.mm.view.recyclerview.j)localObject).CSA;
    if ((paramj instanceof cc)) {}
    for (paramj = (cc)paramj; paramj == null; paramj = null)
    {
      Log.w("FinderFeedSelectorAdapter", "handleOnPageSelected return for item:" + paramj + " position:" + paramInt);
      AppMethodBeat.o(335438);
      return null;
    }
    FeedData localFeedData = h(paramj);
    d locald = new d(false, null, 255);
    locald.GfT = paramj.bZB();
    locald.GfU = paramInt;
    locald.AIz = ((com.tencent.mm.view.recyclerview.j)localObject);
    locald.feedId = paramj.bZA();
    locald.feed = localFeedData;
    locald.GfV = paramj;
    paramj = av.GiL;
    localObject = ((com.tencent.mm.view.recyclerview.j)localObject).UH(e.e.media_banner);
    if (localFeedData == null)
    {
      paramj = localaw;
      localaw = aw.Gjk;
      if ((localObject != null) && (paramj != null))
      {
        localObject = (FinderMediaBanner)localObject;
        if ((((FinderMediaBanner)localObject).getFocusPosition() >= 0) && (((FinderMediaBanner)localObject).getFocusPosition() < paramj.size()))
        {
          paramj = (dji)p.ae((List)paramj, ((FinderMediaBanner)localObject).getFocusPosition());
          if (paramj != null) {
            break label326;
          }
          paramj = "";
        }
      }
    }
    for (;;)
    {
      locald.setMediaId(paramj);
      AppMethodBeat.o(335438);
      return locald;
      paramj = localFeedData.getMediaList();
      break;
      label326:
      localObject = paramj.mediaId;
      paramj = (com.tencent.mm.view.recyclerview.j)localObject;
      if (localObject == null) {
        paramj = "";
      }
    }
  }
  
  private final void a(RecyclerView paramRecyclerView, long paramLong)
  {
    AppMethodBeat.i(335368);
    if (this.Fsw == paramLong)
    {
      AppMethodBeat.o(335368);
      return;
    }
    Object localObject = k.aeZF;
    localObject = paramRecyclerView.getContext();
    s.s(localObject, "recyclerView.context");
    localObject = ((as)k.nq((Context)localObject).q(as.class)).Vo(this.hJx);
    if (localObject != null)
    {
      Log.i("FinderFeedSelectorAdapter", "publishFocusView: targetFeedId = " + paramLong + ", lastFocusFeedId = " + this.Fsw);
      com.tencent.mm.plugin.finder.event.base.b localb = ((f)localObject).h(paramRecyclerView, 6);
      this.Fsw = ((com.tencent.mm.plugin.finder.event.base.h)localb).AOv;
      paramRecyclerView.post(new a..ExternalSyntheticLambda0((f)localObject, localb));
    }
    AppMethodBeat.o(335368);
  }
  
  private static final void a(f paramf, com.tencent.mm.plugin.finder.event.base.j paramj)
  {
    AppMethodBeat.i(335458);
    s.u(paramf, "$it");
    s.u(paramj, "$event");
    paramf.c((com.tencent.mm.plugin.finder.event.base.b)paramj);
    AppMethodBeat.o(335458);
  }
  
  private final void a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(335417);
    int j = this.GrM;
    if ((paramd1.GfU >= 0) && (paramd2.GfU >= 0)) {
      if (paramd2.GfU < paramd1.GfU) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      this.GrM = i;
      if (j != this.GrM) {
        Log.i("FinderFeedSelectorAdapter", "checkScrollDirectionChanged direction change from " + j + " to " + this.GrM);
      }
      AppMethodBeat.o(335417);
      return;
    }
  }
  
  private final void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, d paramd)
  {
    AppMethodBeat.i(335400);
    this.GrN.aDn("onFeedUnSelected begin");
    if (a(paramd, "dispatchOnFeedUnSelected"))
    {
      b localb = this.GrK;
      if (localb != null)
      {
        com.tencent.mm.view.recyclerview.j localj = paramd.AIz;
        s.checkNotNull(localj);
        localb.a(paramList, paramd, localj, paramd.GfU);
      }
    }
    this.GrN.aDn("onFeedUnSelected end");
    AppMethodBeat.o(335400);
  }
  
  private static boolean a(d paramd, String paramString)
  {
    AppMethodBeat.i(335448);
    if (paramd == null)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for feed:" + paramd);
      AppMethodBeat.o(335448);
      return false;
    }
    if (!paramd.clZ)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for isValid:" + paramd.clZ);
      AppMethodBeat.o(335448);
      return false;
    }
    if (paramd.GfU < 0)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for position:" + paramd.GfU);
      AppMethodBeat.o(335448);
      return false;
    }
    if (paramd.feedId == 0L)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for feedId:" + paramd.feedId);
      AppMethodBeat.o(335448);
      return false;
    }
    if (paramd.AIz == null)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for holder:" + paramd.AIz);
      AppMethodBeat.o(335448);
      return false;
    }
    AppMethodBeat.o(335448);
    return true;
  }
  
  private static final void b(f paramf, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(335464);
    s.u(paramf, "$it");
    s.u(paramb, "$event");
    paramf.c(paramb);
    AppMethodBeat.o(335464);
  }
  
  private static final void b(f paramf, com.tencent.mm.plugin.finder.event.base.j paramj)
  {
    AppMethodBeat.i(335469);
    s.u(paramf, "$it");
    s.u(paramj, "$event");
    paramf.c((com.tencent.mm.plugin.finder.event.base.b)paramj);
    AppMethodBeat.o(335469);
  }
  
  private final void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, d paramd)
  {
    AppMethodBeat.i(335409);
    this.GrN.aDn("onFeedSelected begin");
    if (a(paramd, "dispatchOnFeedSelected"))
    {
      a(this.GrL, paramd);
      this.GrL = d.b(paramd);
      Object localObject = av.GiL;
      av.qL(paramd.feedId);
      localObject = this.GrK;
      if (localObject != null)
      {
        com.tencent.mm.view.recyclerview.j localj = paramd.AIz;
        s.checkNotNull(localj);
        ((b)localObject).b(paramList, paramd, localj, paramd.GfU);
      }
    }
    this.GrN.aDn("onFeedSelected end");
    AppMethodBeat.o(335409);
  }
  
  private static FeedData h(cc paramcc)
  {
    AppMethodBeat.i(335427);
    if ((paramcc instanceof BaseFinderFeed))
    {
      FeedData.a locala = FeedData.Companion;
      paramcc = FeedData.a.l((BaseFinderFeed)paramcc);
      AppMethodBeat.o(335427);
      return paramcc;
    }
    if ((paramcc instanceof ca))
    {
      paramcc = ((ca)paramcc).ecz();
      AppMethodBeat.o(335427);
      return paramcc;
    }
    if ((paramcc instanceof au))
    {
      paramcc = ((au)paramcc).ecz();
      AppMethodBeat.o(335427);
      return paramcc;
    }
    AppMethodBeat.o(335427);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$Companion;", "", "()V", "BASE_LINE", "", "SCROLL_DIRECTION_DOWN", "", "SCROLL_DIRECTION_UP", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "", "onFeedSelected", "", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "feed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onFeedUnSelected", "onNextFeedPrepare", "onPageScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, d paramd, com.tencent.mm.view.recyclerview.j paramj, int paramInt);
    
    public abstract void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, d paramd, com.tencent.mm.view.recyclerview.j paramj, int paramInt);
    
    public abstract void c(List<? extends com.tencent.mm.view.recyclerview.a> paramList, d paramd, com.tencent.mm.view.recyclerview.j paramj, int paramInt);
    
    public abstract void k(RecyclerView paramRecyclerView, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(RecyclerView paramRecyclerView, a parama) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(335359);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      s.u(paramRecyclerView, "recyclerView");
      int i;
      label142:
      label151:
      label323:
      int j;
      if (paramInt == 0)
      {
        localObject1 = this.GrP.getLayoutManager();
        if ((localObject1 instanceof LinearLayoutManager))
        {
          localObject1 = (LinearLayoutManager)localObject1;
          if (localObject1 != null) {
            break label142;
          }
        }
        for (i = -1;; i = ((LinearLayoutManager)localObject1).Ju())
        {
          if (i != -1) {
            break label151;
          }
          Log.i("FinderFeedSelectorAdapter", "bindPrepareFeedListener: invalid pos = " + i + ' ');
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(335359);
          return;
          localObject1 = null;
          break;
        }
        switch (a.a(this.GrQ))
        {
        default: 
          paramInt = i + 1;
        }
        for (;;)
        {
          paramRecyclerView = paramRecyclerView.getAdapter();
          if (paramRecyclerView != null) {
            break;
          }
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
          AppMethodBeat.o(335359);
          throw paramRecyclerView;
          paramInt = i + 1;
          continue;
          paramInt = i - 1;
        }
        List localList = (List)((WxRecyclerAdapter)paramRecyclerView).data;
        if ((paramInt < 0) || (paramInt >= localList.size()))
        {
          Log.i("FinderFeedSelectorAdapter", "bindPrepareFeedListener: pos out of range, nextPos= " + paramInt + ' ');
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(335359);
          return;
        }
        paramRecyclerView = this.GrP.fT(paramInt);
        if ((paramRecyclerView instanceof com.tencent.mm.view.recyclerview.j))
        {
          paramRecyclerView = (com.tencent.mm.view.recyclerview.j)paramRecyclerView;
          if (paramRecyclerView != null) {
            break label401;
          }
          localObject1 = null;
          if (!(localObject1 instanceof ah)) {
            break label410;
          }
        }
        label401:
        label410:
        for (localObject1 = (ah)localObject1;; localObject1 = null)
        {
          if ((paramRecyclerView != null) && (localObject1 != null)) {
            break label416;
          }
          Log.i("FinderFeedSelectorAdapter", "bindPrepareFeedListener: invalid holder or item  holder=" + paramRecyclerView + ", item=" + localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(335359);
          return;
          paramRecyclerView = null;
          break;
          localObject1 = paramRecyclerView.CSA;
          break label323;
        }
        label416:
        j = paramRecyclerView.caO;
        if (!a.a(this.GrQ, i, paramInt, (cc)localObject1)) {
          break label573;
        }
        localObject1 = a.a(this.GrQ, paramInt, paramRecyclerView);
        StringBuilder localStringBuilder = new StringBuilder("bindPrepareFeedListener curPos:").append(i).append(" nextPos:").append(paramInt).append(" type:").append(j).append(" holder").append(paramRecyclerView).append(" feed:");
        if (localObject1 != null) {
          break label549;
        }
        paramRecyclerView = localObject2;
        Log.i("FinderFeedSelectorAdapter", paramRecyclerView);
        a.a(this.GrQ, localList, (d)localObject1);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(335359);
        return;
        label549:
        FeedData localFeedData = ((d)localObject1).feed;
        paramRecyclerView = localObject2;
        if (localFeedData == null) {
          break;
        }
        paramRecyclerView = localFeedData.getDescription();
        break;
        label573:
        Log.i("FinderFeedSelectorAdapter", "bindPrepareFeedListener curPos:" + i + " nextPos:" + paramInt + " type:" + j + " holder" + paramRecyclerView);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335367);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindPrepareFeedListener$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(335367);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindRecyclerView$1", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements FinderRecyclerView.b
  {
    d(a parama) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(335344);
      s.u(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(335344);
    }
    
    public final void j(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(335351);
      s.u(paramRecyclerView, "recyclerView");
      a.a(this.GrQ, paramRecyclerView, paramInt);
      AppMethodBeat.o(335351);
    }
    
    public final void k(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(335362);
      s.u(paramRecyclerView, "recyclerView");
      a.b(this.GrQ, paramRecyclerView, paramInt);
      AppMethodBeat.o(335362);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements RecyclerView.i
  {
    private boolean isFirst = true;
    
    e(RecyclerView paramRecyclerView, a parama) {}
    
    private static final void b(a parama)
    {
      AppMethodBeat.i(335347);
      s.u(parama, "this$0");
      a.a(parama, null, false, "onChildViewAttachedToWindow", 3);
      AppMethodBeat.o(335347);
    }
    
    public final void bm(View paramView)
    {
      AppMethodBeat.i(335372);
      s.u(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        this.AJl.post(new a.e..ExternalSyntheticLambda0(this.GrQ));
      }
      AppMethodBeat.o(335372);
    }
    
    public final void bn(View paramView)
    {
      AppMethodBeat.i(335363);
      s.u(paramView, "view");
      AppMethodBeat.o(335363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.autoplay.a
 * JD-Core Version:    0.7.0.1
 */