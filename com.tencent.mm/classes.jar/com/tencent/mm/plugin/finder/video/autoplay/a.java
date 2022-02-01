package com.tencent.mm.plugin.finder.video.autoplay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.aj.a;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter;", "", "()V", "SCREEN_HEIGHT", "", "curScrollDirection", "enableCheckVisibilityFeed", "", "lastSelectedFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "mediaRect", "Landroid/graphics/Rect;", "onFeedChangeCallback", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "timeConsumingTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "bindFeed", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "bindRecyclerView", "checkIsCareVisibleFeed", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "feedList", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "checkScrollDirectionChanged", "unselectedFeed", "selectedFeed", "checkSelect", "forceCheckSame", "checkSelectedInternal", "otherCareType", "", "invokeSource", "", "dispatchOnFeedSelected", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "dispatchOnFeedUnSelected", "dispatchOnFeedVisible", "feeds", "dispatchOnNextFeedPrepare", "findNextFeed", "handleOnPageSelected", "position", "handleOnScrollStateChanged", "newState", "isValidFeed", "postCheckSelect", "setOnFeedChangeCallback", "translateRVFeedToFeedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "Companion", "OnFeedChangeCallback", "plugin-finder_release"})
public final class a
{
  public static final a APw;
  private final Rect AFR;
  private final int APq;
  b APr;
  private b APs;
  private int APt;
  private final c APu;
  private final boolean APv;
  RecyclerView jLl;
  
  static
  {
    AppMethodBeat.i(257928);
    APw = new a((byte)0);
    AppMethodBeat.o(257928);
  }
  
  public a()
  {
    AppMethodBeat.i(257927);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    this.APq = ((Resources)localObject).getDisplayMetrics().heightPixels;
    this.AFR = new Rect();
    this.APs = new b(false, null, 127);
    this.APt = 1;
    this.APu = new c("FinderFeedSelectorAdapter");
    localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.APv = com.tencent.mm.plugin.finder.live.utils.a.dEP();
    AppMethodBeat.o(257927);
  }
  
  private final aj.a a(aj.a parama, bu parambu, i parami)
  {
    AppMethodBeat.i(257911);
    if (this.APv)
    {
      aj localaj = aj.AGc;
      if (aj.edW().contains(Integer.valueOf(parambu.bAQ()))) {
        parama.AGd.add(new aj.a(parambu, parami));
      }
    }
    AppMethodBeat.o(257911);
    return parama;
  }
  
  private final void a(aj.a parama)
  {
    AppMethodBeat.i(257919);
    b localb = this.APr;
    if (localb != null)
    {
      localb.b(parama);
      AppMethodBeat.o(257919);
      return;
    }
    AppMethodBeat.o(257919);
  }
  
  private final void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(257922);
    int j = this.APt;
    if ((paramb1.ACR >= 0) && (paramb2.ACR >= 0)) {
      if (paramb2.ACR <= paramb1.ACR) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 2)
    {
      this.APt = i;
      if (j != this.APt) {
        Log.i("FinderFeedSelectorAdapter", "checkScrollDirectionChanged direction change from " + j + " to " + this.APt);
      }
      AppMethodBeat.o(257922);
      return;
    }
  }
  
  private final void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb)
  {
    AppMethodBeat.i(257912);
    this.APu.aGV("onFeedUnSelected begin");
    if (a(paramb, "dispatchOnFeedUnSelected"))
    {
      b localb = this.APr;
      if (localb != null)
      {
        i locali = paramb.xhX;
        if (locali == null) {
          p.iCn();
        }
        localb.a(paramList, paramb, locali);
      }
    }
    this.APu.aGV("onFeedUnSelected end");
    AppMethodBeat.o(257912);
  }
  
  private static boolean a(b paramb, String paramString)
  {
    AppMethodBeat.i(257925);
    if (paramb == null)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for feed:" + paramb);
      AppMethodBeat.o(257925);
      return false;
    }
    if (!paramb.cSY)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for isValid:" + paramb.cSY);
      AppMethodBeat.o(257925);
      return false;
    }
    if (paramb.ACR < 0)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for position:" + paramb.ACR);
      AppMethodBeat.o(257925);
      return false;
    }
    if (paramb.feedId == 0L)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for feedId:" + paramb.feedId);
      AppMethodBeat.o(257925);
      return false;
    }
    if (paramb.xhX == null)
    {
      Log.w("FinderFeedSelectorAdapter", paramString + " checkFeedValid return for holder:" + paramb.xhX);
      AppMethodBeat.o(257925);
      return false;
    }
    AppMethodBeat.o(257925);
    return true;
  }
  
  private final void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb)
  {
    AppMethodBeat.i(257915);
    this.APu.aGV("onFeedSelected begin");
    if (a(paramb, "dispatchOnFeedSelected"))
    {
      a(this.APs, paramb);
      this.APs = b.b(paramb);
      Object localObject = aj.AGc;
      aj.Nf(paramb.feedId);
      localObject = this.APr;
      if (localObject != null)
      {
        i locali = paramb.xhX;
        if (locali == null) {
          p.iCn();
        }
        ((b)localObject).a(paramList, paramb, locali, paramb.ACR);
      }
    }
    this.APu.aGV("onFeedSelected end");
    AppMethodBeat.o(257915);
  }
  
  private final b c(b paramb)
  {
    AppMethodBeat.i(257921);
    Iterator localIterator = ((List)paramb.ACP).iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (((b)localIterator.next()).feedId == paramb.feedId)
      {
        j = 1;
        label55:
        if (j == 0) {
          break label79;
        }
      }
    }
    for (int j = i;; j = -1)
    {
      if (j != -1) {
        break label91;
      }
      AppMethodBeat.o(257921);
      return null;
      j = 0;
      break label55;
      label79:
      i += 1;
      break;
    }
    label91:
    i = j + 1;
    if (this.APt == 1) {
      i = j + 1;
    }
    while ((i >= 0) && (i < paramb.ACP.size()))
    {
      paramb = (b)paramb.ACP.get(i);
      AppMethodBeat.o(257921);
      return paramb;
      if (this.APt == 2) {
        i = j - 1;
      }
    }
    AppMethodBeat.o(257921);
    return null;
  }
  
  private final void c(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb)
  {
    AppMethodBeat.i(257917);
    this.APu.aGV("onNextFeedPrepare begin");
    if (a(paramb, "dispatchOnNextFeedPrepare"))
    {
      b localb = this.APr;
      if (localb != null)
      {
        if (paramb == null) {
          p.iCn();
        }
        i locali = paramb.xhX;
        if (locali == null) {
          p.iCn();
        }
        localb.b(paramList, paramb, locali);
      }
    }
    this.APu.aGV("onNextFeedPrepare end");
    AppMethodBeat.o(257917);
  }
  
  private static FeedData e(bu parambu)
  {
    AppMethodBeat.i(257924);
    if ((parambu instanceof BaseFinderFeed))
    {
      FeedData.a locala = FeedData.Companion;
      parambu = FeedData.a.t((BaseFinderFeed)parambu);
      AppMethodBeat.o(257924);
      return parambu;
    }
    if ((parambu instanceof bs))
    {
      parambu = ((bs)parambu).dtn();
      AppMethodBeat.o(257924);
      return parambu;
    }
    if ((parambu instanceof an))
    {
      parambu = ((an)parambu).dtn();
      AppMethodBeat.o(257924);
      return parambu;
    }
    AppMethodBeat.o(257924);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$Companion;", "", "()V", "BASE_LINE", "", "SCROLL_DIRECTION_DOWN", "", "SCROLL_DIRECTION_UP", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "", "onCareFeedVisibility", "", "feeds", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "onFeedSelected", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "feed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onFeedUnSelected", "onNextFeedPrepare", "onPageScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb, i parami);
    
    public abstract void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb, i parami, int paramInt);
    
    public abstract void b(aj.a parama);
    
    public abstract void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, b paramb, i parami);
    
    public abstract void i(RecyclerView paramRecyclerView, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindRecyclerView$1", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView$OnPageChangeCallback;", "onPageScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder_release"})
  public static final class c
    implements FinderRecyclerView.b
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(288985);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(288985);
    }
    
    public final void h(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288986);
      p.k(paramRecyclerView, "recyclerView");
      a.a(this.APx, paramRecyclerView, paramInt);
      AppMethodBeat.o(288986);
    }
    
    public final void i(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288987);
      p.k(paramRecyclerView, "recyclerView");
      a.b(this.APx, paramRecyclerView, paramInt);
      AppMethodBeat.o(288987);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$bindRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.i
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView) {}
    
    public final void aT(View paramView)
    {
      AppMethodBeat.i(270305);
      p.k(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        this.xmk.post((Runnable)new a(this));
      }
      AppMethodBeat.o(270305);
    }
    
    public final void aU(View paramView)
    {
      AppMethodBeat.i(270304);
      p.k(paramView, "view");
      AppMethodBeat.o(270304);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(288664);
        a.a(this.APy.APx, null, false, "onChildViewAttachedToWindow", 3);
        AppMethodBeat.o(288664);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.autoplay.a
 * JD-Core Version:    0.7.0.1
 */