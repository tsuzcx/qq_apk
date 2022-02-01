package com.tencent.mm.plugin.finder.gallery;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryViewCallback;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryPresenter;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "tabType", "", "defaultSelected", "", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;IZ)V", "getDefaultSelected", "()Z", "feedLoader", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$feedProgressListener$1;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "hasRefresh", "presenter", "viewCallback", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initOnCreate", "", "onDestroy", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderGalleryFragment
  extends FinderBaseGridFeedFragment<n, e>
{
  private static final String TAG = "Finder.FinderGalleryFragment";
  public static final a xTS;
  private HashMap _$_findViewCache;
  private final b xNB;
  private final boolean xTM;
  private e xTN;
  private n xTO;
  public FinderGalleryLoader xTP;
  private boolean xTQ;
  private final b xTR;
  
  static
  {
    AppMethodBeat.i(237559);
    xTS = new a((byte)0);
    TAG = "Finder.FinderGalleryFragment";
    AppMethodBeat.o(237559);
  }
  
  public FinderGalleryFragment(b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(237558);
    this.xTR = new b(this);
    this.xNB = paramb;
    this.xTM = paramBoolean;
    this.fEH = paramInt;
    AppMethodBeat.o(237558);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(237564);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(237564);
  }
  
  public final FinderGalleryLoader dwd()
  {
    AppMethodBeat.i(237543);
    FinderGalleryLoader localFinderGalleryLoader = this.xTP;
    if (localFinderGalleryLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(237543);
    return localFinderGalleryLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_gallery_fav_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(237546);
    Object localObject2 = new atl();
    ((atl)localObject2).tab_type = this.fEH;
    ((atl)localObject2).scene = this.xNB.xTx.kqZ;
    if (this.xNB.xTx.xTv == null) {}
    for (Object localObject1 = null;; localObject1 = com.tencent.mm.cd.b.cU(this.xNB.xTx.xTv))
    {
      ((atl)localObject2).SDH = ((com.tencent.mm.cd.b)localObject1);
      if (this.xTM) {
        ((atl)localObject2).SGo = this.xNB.xTx.xTw;
      }
      if (this.fEH == 5) {
        this.xTQ = true;
      }
      localObject1 = g.Xox;
      this.xTP = ((FinderGalleryLoader)new FinderGalleryLoader((atl)localObject2, (atl)localObject2)
      {
        public final void onPostStart(long paramAnonymousLong)
        {
          AppMethodBeat.i(270813);
          View localView = FinderGalleryFragment.a(this.xTT).getEmptyView();
          if (localView != null) {
            localView.setVisibility(8);
          }
          FinderGalleryFragment.a(this.xTT).xvJ.setVisibility(0);
          super.onPostStart(paramAnonymousLong);
          AppMethodBeat.o(270813);
        }
      });
      localObject1 = this.xTP;
      if (localObject1 == null) {
        p.bGy("feedLoader");
      }
      ((FinderGalleryLoader)localObject1).setInitDone((j)new c(this));
      ((FinderGalleryLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new d(this));
      localObject1 = (MMActivity)ebI();
      localObject2 = this.xTP;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      this.xTN = new e((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2, this.xNB, this.fEH);
      this.xTO = ((n)new e(this, (MMActivity)ebI(), this.xNB, this.fEH));
      localObject1 = this.xTO;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject2 = this.xTN;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      ((n)localObject1).a((c.a)localObject2);
      this.xTR.alive();
      AppMethodBeat.o(237546);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(237556);
    super.onDestroy();
    this.xTR.dead();
    AppMethodBeat.o(237556);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(237549);
    if (!this.xTQ)
    {
      this.xTQ = true;
      d.a(d.aJa(), (kotlin.g.a.b)new f(this));
    }
    AppMethodBeat.o(237549);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hr>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class c
    implements j
  {
    c(FinderGalleryFragment paramFinderGalleryFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(267329);
      View localView = FinderGalleryFragment.a(this.xTT).getEmptyView();
      if (localView != null)
      {
        localView.setVisibility(8);
        FinderGalleryFragment.a(this.xTT).xvJ.getRecyclerView().setVisibility(0);
        AppMethodBeat.o(267329);
        return;
      }
      AppMethodBeat.o(267329);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$initOnCreate$2$2"})
  static final class d
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    d(FinderGalleryFragment paramFinderGalleryFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryFragment$initOnCreate$3", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryViewCallback;", "getRootView", "Landroid/view/View;", "plugin-finder_release"})
  public static final class e
    extends n
  {
    e(MMActivity paramMMActivity, b paramb, int paramInt)
    {
      super(paramInt, i);
    }
    
    public final View getRootView()
    {
      AppMethodBeat.i(267287);
      View localView = this.xTT.getView();
      AppMethodBeat.o(267287);
      return localView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Void, x>
  {
    f(FinderGalleryFragment paramFinderGalleryFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.FinderGalleryFragment
 * JD-Core Version:    0.7.0.1
 */