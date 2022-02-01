package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "commentPreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "loadNextCommend", "onAttach", "callback", "onDetach", "releaseListener", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.plugin.finder.presenter.base.a<d>
{
  final String TAG;
  final Context context;
  ArrayList<n> data;
  private int dvm;
  boolean isLoading;
  private com.tencent.mm.bw.b lastBuffer;
  private final WxRecyclerAdapter<n> rXV;
  FinderItem scK;
  d scL;
  private com.tencent.mm.sdk.b.c<ha> scM;
  private com.tencent.mm.plugin.finder.feed.model.d scN;
  private Boolean scO;
  boolean scP;
  private int scene;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(202175);
    this.context = paramContext;
    this.TAG = "Finder.FinderBulletSubtitlePresenter";
    this.scene = 2;
    this.data = new ArrayList();
    this.rXV = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new a(this), this.data);
    this.scO = Boolean.TRUE;
    AppMethodBeat.o(202175);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(202172);
    p.h(paramd, "callback");
    this.scL = paramd;
    paramd = this.scL;
    if (paramd == null) {
      p.bdF("viewCallback");
    }
    paramd.initView();
    AppMethodBeat.o(202172);
  }
  
  public final void a(FinderItem paramFinderItem, int paramInt)
  {
    AppMethodBeat.i(202167);
    p.h(paramFinderItem, "feedObj");
    this.dvm = paramInt;
    this.isLoading = false;
    this.scK = paramFinderItem;
    Object localObject = com.tencent.mm.plugin.finder.report.a.swO;
    com.tencent.mm.plugin.finder.report.a.start(paramFinderItem.getId());
    this.data.clear();
    this.rXV.notifyDataSetChanged();
    cCH();
    if ((this.context instanceof FinderHomeUI))
    {
      paramFinderItem = com.tencent.mm.ui.component.a.KEX;
      paramFinderItem = com.tencent.mm.ui.component.a.s((MMActivity)this.context).get(FinderHomeUIC.class);
      p.g(paramFinderItem, "UICProvider.of(context).…inderHomeUIC::class.java)");
      paramFinderItem = ((FinderHomeUIC)paramFinderItem).GO(paramInt);
      if (paramFinderItem != null) {
        localObject = com.tencent.mm.ui.component.a.KEX;
      }
    }
    for (this.scN = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.of((Fragment)paramFinderItem).get(FinderCommentPreloaderUIC.class)).sbU;; this.scN = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramFinderItem).get(FinderCommentPreloaderUIC.class)).sbU)
    {
      if (this.scN == null)
      {
        ae.e(this.TAG, "bindData: get commentPreLoader failed, context = " + this.context);
        paramFinderItem = z.Nhr;
      }
      this.scP = false;
      AppMethodBeat.o(202167);
      return;
      paramFinderItem = com.tencent.mm.ui.component.a.KEX;
      paramFinderItem = this.context;
      if (paramFinderItem == null)
      {
        paramFinderItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(202167);
        throw paramFinderItem;
      }
    }
  }
  
  public final void aVt()
  {
    AppMethodBeat.i(202169);
    if ((this.scK != null) && (!this.scP) && (!this.isLoading)) {
      if (((Collection)this.data).isEmpty()) {
        break label55;
      }
    }
    label55:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(202169);
      return;
    }
    this.isLoading = true;
    Object localObject = this.scM;
    if (localObject != null) {
      ((com.tencent.mm.sdk.b.c)localObject).dead();
    }
    this.scM = ((com.tencent.mm.sdk.b.c)new b(this));
    localObject = this.scM;
    if (localObject != null) {
      ((com.tencent.mm.sdk.b.c)localObject).alive();
    }
    this.data.addAll((Collection)cCG());
    if (!((Collection)this.data).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        cCH();
      }
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("refreshData: get comment from cache, size=").append(this.data.size()).append(", feedId=");
      FinderItem localFinderItem = this.scK;
      if (localFinderItem == null) {
        p.gkB();
      }
      ae.i((String)localObject, localFinderItem.getId());
      this.rXV.notifyDataSetChanged();
      AppMethodBeat.o(202169);
      return;
    }
  }
  
  final List<n> cCG()
  {
    Object localObject2 = null;
    AppMethodBeat.i(202170);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = e.sKJ;
    Object localObject3 = this.scK;
    if (localObject3 == null) {
      p.gkB();
    }
    localObject3 = ((e)localObject1).xm(((FinderItem)localObject3).getId());
    if (localObject3 != null)
    {
      localObject1 = e.sKJ;
      Object localObject4 = this.scK;
      if (localObject4 == null) {
        p.gkB();
      }
      localObject4 = ((e)localObject1).P(((FinderItem)localObject4).getId(), 0L);
      if (localObject4 != null) {}
      for (localObject1 = ((e.b)localObject4).lastBuffer;; localObject1 = null)
      {
        this.lastBuffer = ((com.tencent.mm.bw.b)localObject1);
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Boolean.valueOf(((e.b)localObject4).sdn);
        }
        this.scO = ((Boolean)localObject1);
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new n((ab)((Iterator)localObject2).next()));
        }
      }
      localArrayList.addAll((Collection)localObject1);
      this.isLoading = false;
      this.rXV.notifyDataSetChanged();
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(202170);
    return localObject1;
  }
  
  public final void cCH()
  {
    AppMethodBeat.i(202171);
    com.tencent.mm.sdk.b.c localc = this.scM;
    if (localc != null) {
      localc.dead();
    }
    this.scM = null;
    this.isLoading = false;
    AppMethodBeat.o(202171);
  }
  
  public final WxRecyclerAdapter<?> eQ(Context paramContext)
  {
    AppMethodBeat.i(202168);
    p.h(paramContext, "context");
    paramContext = this.rXV;
    AppMethodBeat.o(202168);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202174);
    cCH();
    AppMethodBeat.o(202174);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(202164);
      Object localObject = n.sth;
      if (paramInt == n.cEw())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d(this.scQ.context);
        AppMethodBeat.o(202164);
        return localObject;
      }
      localObject = n.sth;
      if (paramInt == n.cEx())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d(this.scQ.context);
        AppMethodBeat.o(202164);
        return localObject;
      }
      p.gkB();
      AppMethodBeat.o(202164);
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<ha>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(c.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c
 * JD-Core Version:    0.7.0.1
 */