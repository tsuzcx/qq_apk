package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList;Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "autoPlayRunnable", "Ljava/lang/Runnable;", "getContext", "()Landroid/content/Context;", "curLivePreviewDataSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "enableNearbyLiveAutoPlay", "", "getFeedList", "()Ljava/util/ArrayList;", "heightPixels", "", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "checkAutoPlay", "pos", "view", "Landroid/view/View;", "checkAutoPlayDelay", "delayMs", "", "checkAutoPlayInternal", "checkAutoPlayOnIdle", "checkAutoStopInternal", "checkIfStopCurrentView", "detach", "findAutoPlayItem", "", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "getFeedByPos", "getOrCreateLiveView", "Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;", "livePlayerContainer", "Landroid/widget/FrameLayout;", "isCurPlayerView", "nearbyLivePreviewView", "isLeftPos", "isVisibleRectLessThan90Percent", "stopCurrentView", "Companion", "LivePreviewData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ak
{
  public static final a EJR;
  private static int EJU;
  private final WxRecyclerAdapter<?> ALE;
  private final int ANY;
  private Runnable EHY;
  private final boolean EJS;
  private HashSet<b> EJT;
  private final Context context;
  private final ArrayList<cc> feedList;
  private MMHandler mRi;
  private final RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(341098);
    EJR = new a((byte)0);
    EJU = 2;
    AppMethodBeat.o(341098);
  }
  
  public a(Context paramContext, RecyclerView paramRecyclerView, ArrayList<cc> paramArrayList, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(341005);
    this.context = paramContext;
    this.mkw = paramRecyclerView;
    this.feedList = paramArrayList;
    this.ALE = paramWxRecyclerAdapter;
    this.ANY = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    paramContext = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRZ().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.EJS = bool;
      this.mRi = new MMHandler(Looper.getMainLooper());
      this.EJT = new HashSet();
      this.mkw.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(341002);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          Log.i("FinderLiveCardAutoPlayManager", s.X("onScrollStateChanged newState:", Integer.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt == 0) {
            a.b(this.EJV);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(341002);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(341010);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          a.c(this.EJV);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(341010);
        }
      });
      AppMethodBeat.o(341005);
      return;
    }
  }
  
  private final void QD(int paramInt)
  {
    AppMethodBeat.i(341021);
    Object localObject1 = this.mkw.getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(341021);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((FinderStaggeredGridLayoutManager)localObject1).findViewByPosition(paramInt);
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      i = ((Rect)localObject2).height();
      int j = ((View)localObject1).getHeight();
      if (i * 1.0F / j >= 0.5F) {
        break label178;
      }
      i = 1;
      if (i != 0)
      {
        localObject2 = (FinderLiveCardPreviewView)((View)localObject1).findViewWithTag("finder-live-card-preview-view-tag");
        if (localObject2 == null) {
          break label183;
        }
      }
    }
    label178:
    label183:
    for (boolean bool = a((FinderLiveCardPreviewView)localObject2);; bool = false)
    {
      if (bool)
      {
        eET();
        Log.i("FinderLiveCardAutoPlayManager", "checkAutoStopInternal stop pos:" + paramInt + " view:" + localObject1);
      }
      AppMethodBeat.o(341021);
      return;
      i = 0;
      break;
    }
  }
  
  private final boolean QE(int paramInt)
  {
    AppMethodBeat.i(341029);
    int j;
    int k;
    int i;
    if (paramInt >= 0)
    {
      j = 0;
      k = paramInt;
      i = k;
      if (!(QF(j) instanceof x))
      {
        Log.i("FinderLiveCardAutoPlayManager", "isLeftPos pos:" + paramInt + " ignore pos:" + j);
        i = k - 1;
      }
      if (j != paramInt) {}
    }
    for (;;)
    {
      if (i % 2 == 0)
      {
        AppMethodBeat.o(341029);
        return true;
      }
      AppMethodBeat.o(341029);
      return false;
      j += 1;
      k = i;
      break;
      i = paramInt;
    }
  }
  
  private final cc QF(int paramInt)
  {
    AppMethodBeat.i(341057);
    if (this.feedList == null)
    {
      Log.w("FinderLiveCardAutoPlayManager", s.X("getFeedByPos return for feedList:", this.feedList));
      AppMethodBeat.o(341057);
      return null;
    }
    paramInt -= this.ALE.agOb.size();
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("FinderLiveCardAutoPlayManager", s.X("getFeedByPos return for invalid pos:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(341057);
      return null;
    }
    cc localcc = (cc)this.feedList.get(paramInt);
    AppMethodBeat.o(341057);
    return localcc;
  }
  
  private static final void a(final a parama)
  {
    AppMethodBeat.i(341076);
    s.u(parama, "this$0");
    Object localObject1 = parama.mkw.getLayoutManager();
    if (localObject1 == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(341076);
      throw parama;
    }
    FinderStaggeredGridLayoutManager localFinderStaggeredGridLayoutManager = (FinderStaggeredGridLayoutManager)localObject1;
    localObject1 = parama.mkw.getAdapter();
    if (localObject1 == null) {}
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    final int n;
    View localView;
    for (int i = 0;; i = ((RecyclerView.a)localObject1).getItemCount())
    {
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      localFinderStaggeredGridLayoutManager.n(arrayOfInt1);
      localFinderStaggeredGridLayoutManager.o(arrayOfInt2);
      int[] arrayOfInt3 = parama.a((StaggeredGridLayoutManager)localFinderStaggeredGridLayoutManager, arrayOfInt1, arrayOfInt2);
      int m = arrayOfInt3.length;
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label810;
        }
        n = arrayOfInt3[j];
        localView = localFinderStaggeredGridLayoutManager.findViewByPosition(n);
        if (localView != null) {
          break;
        }
        localObject1 = null;
        if (localObject1 == null) {
          Log.w("FinderLiveCardAutoPlayManager", "checkAutoPlayInternal invalid pos:" + n + " view:" + localView);
        }
        j += 1;
      }
    }
    if (!parama.EJS) {
      Log.w("FinderLiveCardAutoPlayManager", s.X("checkAutoPlay return for enableNearbyLiveAutoPlay:", Boolean.valueOf(parama.EJS)));
    }
    for (;;)
    {
      localObject1 = ah.aiuX;
      break;
      final cc localcc = parama.QF(n);
      if (localcc != null)
      {
        FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(p.e.live_player_container);
        if (localFrameLayout == null)
        {
          Log.w("FinderLiveCardAutoPlayManager", s.X("checkAutoPlay return for view:", localView));
          continue;
        }
        localObject1 = (FinderLiveCardPreviewView)localFrameLayout.findViewWithTag("finder-live-card-preview-view-tag");
        int k;
        if (localObject1 != null)
        {
          Log.i("FinderLiveCardAutoPlayManager", s.X("getOrCreateLiveView get view:", localObject1));
          if (!(localcc instanceof x)) {
            break label793;
          }
          localObject2 = ((x)localcc).feedObject.getFeedObject().liveInfo;
          if ((localObject2 == null) || (((bip)localObject2).liveStatus != 1)) {
            break label554;
          }
          k = 1;
          label355:
          if (k != 0) {
            break label572;
          }
          localObject1 = ((x)localcc).feedObject.getFeedObject().liveInfo;
          if (localObject1 != null) {
            break label559;
          }
        }
        label554:
        label559:
        for (localObject1 = null;; localObject1 = Integer.valueOf(((bip)localObject1).liveStatus))
        {
          Log.w("FinderLiveCardAutoPlayManager", s.X("checkAutoPlay return for liveStatus:", localObject1));
          break;
          localObject1 = k.aeZF;
          b localb = (b)k.cn(cn.class).q(b.class);
          localObject1 = (FinderLiveCardPreviewView)d.a(localb.EKc, (kotlin.g.a.b)b.b.EKi);
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = ((b)localb).eEV();
            }
            ((FinderLiveCardPreviewView)localObject2).setTag("finder-live-card-preview-view-tag");
            localFrameLayout.addView((View)localObject2);
            Log.i("FinderLiveCardAutoPlayManager", s.X("getOrCreateLiveView create view:", localObject2));
            localObject1 = localObject2;
            break;
            Log.i("FinderLiveCardPlayerViewRecycler", "getOrCreate: get view success, view.hashcode = " + ((FinderLiveCardPreviewView)localObject1).hashCode() + " recycledViews.size = " + localb.EKc.size());
          }
          k = 0;
          break label355;
        }
        label572:
        Object localObject2 = ((x)localcc).feedObject.getFeedObject().liveInfo;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((bip)localObject2).mIE;
        if (localObject2 == null) {
          continue;
        }
        if (parama.a((FinderLiveCardPreviewView)localObject1))
        {
          Log.w("FinderLiveCardAutoPlayManager", "checkAutoPlay return for same feed:" + localcc + " same view:" + localObject1 + " set:" + parama.EJT.size());
          continue;
        }
        if (parama.EJT.size() >= 2) {
          parama.eET();
        }
        parama.EJT.add(new b(n, (FinderLiveCardPreviewView)localObject1, (x)localcc));
        Log.w("FinderLiveCardAutoPlayManager", "checkAutoPlay pos:" + n + " feed:" + localcc + " view:" + localObject1);
        d.a(0L, (kotlin.g.a.a)new c((String)localObject2, localcc, parama, n, (FinderLiveCardPreviewView)localObject1));
        Log.i("FinderLiveCardAutoPlayManager", s.X("checkAutoPlay view:", localObject1));
        continue;
      }
      label793:
      Log.w("FinderLiveCardAutoPlayManager", s.X("checkAutoPlay return for feed:", localcc));
    }
    label810:
    Log.i("FinderLiveCardAutoPlayManager", "checkAutoPlayInternal visible[" + arrayOfInt1[0] + ", " + arrayOfInt2[1] + "] itemCount:" + i);
    AppMethodBeat.o(341076);
  }
  
  private final boolean a(FinderLiveCardPreviewView paramFinderLiveCardPreviewView)
  {
    AppMethodBeat.i(341035);
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((b)localObject).EJW, paramFinderLiveCardPreviewView));
    for (paramFinderLiveCardPreviewView = localObject; paramFinderLiveCardPreviewView != null; paramFinderLiveCardPreviewView = null)
    {
      AppMethodBeat.o(341035);
      return true;
    }
    AppMethodBeat.o(341035);
    return false;
  }
  
  private final int[] a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(341048);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -2;
    int k = paramArrayOfInt1[0];
    int m = paramArrayOfInt2[1];
    int i;
    if (k <= m) {
      i = 0;
    }
    for (;;)
    {
      paramArrayOfInt1 = QF(k);
      if (!(paramArrayOfInt1 instanceof x)) {
        Log.w("FinderLiveCardAutoPlayManager", "findAutoPlayItem invalid feed:" + paramArrayOfInt1 + " index:" + k);
      }
      while (k == m)
      {
        for (;;)
        {
          AppMethodBeat.o(341048);
          return arrayOfInt;
          paramArrayOfInt1 = paramStaggeredGridLayoutManager.findViewByPosition(k);
          if (paramArrayOfInt1 == null) {
            break label260;
          }
          paramArrayOfInt2 = new Rect();
          paramArrayOfInt1.getGlobalVisibleRect(paramArrayOfInt2);
          int n = paramArrayOfInt1.getHeight();
          int j = i;
          if (paramArrayOfInt2.height() * 2 > n)
          {
            Log.i("FinderLiveCardAutoPlayManager", "findAutoPlayItem item hit index:" + k + " focus[" + arrayOfInt[0] + ", " + arrayOfInt[1] + ']');
            j = i + 1;
            arrayOfInt[i] = k;
            if (j >= 2) {}
          }
          else
          {
            i = j;
            if (QE(k)) {
              break;
            }
            i = j;
            if (j <= 0) {
              break;
            }
            Log.w("FinderLiveCardAutoPlayManager", "findAutoPlayItem hit this line.");
          }
        }
        label260:
        Log.w("FinderLiveCardAutoPlayManager", s.X("findAutoPlayItem invalid view index:", Integer.valueOf(k)));
      }
      k += 1;
    }
  }
  
  private final void eEU()
  {
    AppMethodBeat.i(341014);
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    this.EHY = new a..ExternalSyntheticLambda0(this);
    this.mRi.postDelayed(this.EHY, 500L);
    AppMethodBeat.o(341014);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(341111);
    eET();
    AppMethodBeat.o(341111);
  }
  
  public final void eES()
  {
    AppMethodBeat.i(341119);
    eEU();
    AppMethodBeat.o(341119);
  }
  
  public final void eET()
  {
    AppMethodBeat.i(341126);
    Log.i("FinderLiveCardAutoPlayManager", s.X("stopCurrentView set:", Integer.valueOf(this.EJT.size())));
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    while (localIterator.hasNext()) {
      d.a(0L, (kotlin.g.a.a)new d((b)localIterator.next()));
    }
    this.EJT.clear();
    AppMethodBeat.o(341126);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$Companion;", "", "()V", "MAX_FOCUS_ITEMS", "", "MAX_SELECTED_ITEMS", "NEARBY_LIVE_PREVIEW_VIEW_TAG", "", "NOTIFY_BUFFERING_START_DELAY_MS", "", "TAG", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardAutoPlayManager$LivePreviewData;", "", "pos", "", "view", "Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "(ILcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "getPos", "()I", "getView", "()Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final FinderLiveCardPreviewView EJW;
    private final x EJX;
    private final int pos;
    
    public b(int paramInt, FinderLiveCardPreviewView paramFinderLiveCardPreviewView, x paramx)
    {
      AppMethodBeat.i(341020);
      this.pos = paramInt;
      this.EJW = paramFinderLiveCardPreviewView;
      this.EJX = paramx;
      AppMethodBeat.o(341020);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(341043);
      if (this == paramObject)
      {
        AppMethodBeat.o(341043);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(341043);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.pos != paramObject.pos)
      {
        AppMethodBeat.o(341043);
        return false;
      }
      if (!s.p(this.EJW, paramObject.EJW))
      {
        AppMethodBeat.o(341043);
        return false;
      }
      if (!s.p(this.EJX, paramObject.EJX))
      {
        AppMethodBeat.o(341043);
        return false;
      }
      AppMethodBeat.o(341043);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(341034);
      int i = this.pos;
      int j = this.EJW.hashCode();
      int k = this.EJX.hashCode();
      AppMethodBeat.o(341034);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(341028);
      String str = "LivePreviewData(pos=" + this.pos + ", view=" + this.EJW + ", feed=" + this.EJX + ')';
      AppMethodBeat.o(341028);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString, cc paramcc, a parama, int paramInt, FinderLiveCardPreviewView paramFinderLiveCardPreviewView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.a
 * JD-Core Version:    0.7.0.1
 */