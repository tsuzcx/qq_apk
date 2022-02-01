package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "commentPreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "loadNextCommend", "onAttach", "callback", "onDetach", "releaseListener", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.plugin.finder.presenter.base.a<d>
{
  final String TAG;
  final Context context;
  ArrayList<m> data;
  private int duh;
  boolean isLoading;
  private com.tencent.mm.bx.b lastBuffer;
  private final WxRecyclerAdapter<m> rPu;
  FinderItem rUg;
  d rUh;
  private com.tencent.mm.sdk.b.c<gz> rUi;
  private com.tencent.mm.plugin.finder.feed.model.d rUj;
  private Boolean rUk;
  boolean rUl;
  private int scene;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(201716);
    this.context = paramContext;
    this.TAG = "Finder.FinderBulletSubtitlePresenter";
    this.scene = 2;
    this.data = new ArrayList();
    this.rPu = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new a(this), this.data);
    this.rUk = Boolean.TRUE;
    AppMethodBeat.o(201716);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(201713);
    p.h(paramd, "callback");
    this.rUh = paramd;
    paramd = this.rUh;
    if (paramd == null) {
      p.bcb("viewCallback");
    }
    paramd.initView();
    AppMethodBeat.o(201713);
  }
  
  public final void a(FinderItem paramFinderItem, int paramInt)
  {
    AppMethodBeat.i(201708);
    p.h(paramFinderItem, "feedObj");
    this.duh = paramInt;
    this.isLoading = false;
    this.rUg = paramFinderItem;
    Object localObject = com.tencent.mm.plugin.finder.report.a.smX;
    com.tencent.mm.plugin.finder.report.a.start(paramFinderItem.getId());
    this.data.clear();
    this.rPu.notifyDataSetChanged();
    cAV();
    if ((this.context instanceof FinderHomeUI))
    {
      paramFinderItem = com.tencent.mm.ui.component.a.KiD;
      paramFinderItem = com.tencent.mm.ui.component.a.s((MMActivity)this.context).get(FinderHomeUIC.class);
      p.g(paramFinderItem, "UICProvider.of(context).…inderHomeUIC::class.java)");
      paramFinderItem = ((FinderHomeUIC)paramFinderItem).Gr(paramInt);
      if (paramFinderItem != null) {
        localObject = com.tencent.mm.ui.component.a.KiD;
      }
    }
    for (this.rUj = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.of((Fragment)paramFinderItem).get(FinderCommentPreloaderUIC.class)).rTq;; this.rUj = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramFinderItem).get(FinderCommentPreloaderUIC.class)).rTq)
    {
      if (this.rUj == null)
      {
        ad.e(this.TAG, "bindData: get commentPreLoader failed, context = " + this.context);
        paramFinderItem = z.MKo;
      }
      this.rUl = false;
      AppMethodBeat.o(201708);
      return;
      paramFinderItem = com.tencent.mm.ui.component.a.KiD;
      paramFinderItem = this.context;
      if (paramFinderItem == null)
      {
        paramFinderItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201708);
        throw paramFinderItem;
      }
    }
  }
  
  public final void aUU()
  {
    AppMethodBeat.i(201710);
    if ((this.rUg != null) && (!this.rUl) && (!this.isLoading)) {
      if (((Collection)this.data).isEmpty()) {
        break label55;
      }
    }
    label55:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(201710);
      return;
    }
    this.isLoading = true;
    Object localObject = this.rUi;
    if (localObject != null) {
      ((com.tencent.mm.sdk.b.c)localObject).dead();
    }
    this.rUi = ((com.tencent.mm.sdk.b.c)new b(this));
    localObject = this.rUi;
    if (localObject != null) {
      ((com.tencent.mm.sdk.b.c)localObject).alive();
    }
    this.data.addAll((Collection)cAU());
    if (!((Collection)this.data).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        cAV();
      }
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("refreshData: get comment from cache, size=").append(this.data.size()).append(", feedId=");
      FinderItem localFinderItem = this.rUg;
      if (localFinderItem == null) {
        p.gfZ();
      }
      ad.i((String)localObject, localFinderItem.getId());
      this.rPu.notifyDataSetChanged();
      AppMethodBeat.o(201710);
      return;
    }
  }
  
  final List<m> cAU()
  {
    Object localObject2 = null;
    AppMethodBeat.i(201711);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = e.szM;
    Object localObject3 = this.rUg;
    if (localObject3 == null) {
      p.gfZ();
    }
    localObject3 = ((e)localObject1).wV(((FinderItem)localObject3).getId());
    if (localObject3 != null)
    {
      localObject1 = e.szM;
      Object localObject4 = this.rUg;
      if (localObject4 == null) {
        p.gfZ();
      }
      localObject4 = ((e)localObject1).Q(((FinderItem)localObject4).getId(), 0L);
      if (localObject4 != null) {}
      for (localObject1 = ((e.b)localObject4).lastBuffer;; localObject1 = null)
      {
        this.lastBuffer = ((com.tencent.mm.bx.b)localObject1);
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Boolean.valueOf(((e.b)localObject4).rUJ);
        }
        this.rUk = ((Boolean)localObject1);
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new m((ab)((Iterator)localObject2).next()));
        }
      }
      localArrayList.addAll((Collection)localObject1);
      this.isLoading = false;
      this.rPu.notifyDataSetChanged();
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(201711);
    return localObject1;
  }
  
  public final void cAV()
  {
    AppMethodBeat.i(201712);
    com.tencent.mm.sdk.b.c localc = this.rUi;
    if (localc != null) {
      localc.dead();
    }
    this.rUi = null;
    this.isLoading = false;
    AppMethodBeat.o(201712);
  }
  
  public final WxRecyclerAdapter<?> eM(Context paramContext)
  {
    AppMethodBeat.i(201709);
    p.h(paramContext, "context");
    paramContext = this.rPu;
    AppMethodBeat.o(201709);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201715);
    cAV();
    AppMethodBeat.o(201715);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(201705);
      Object localObject = m.skk;
      if (paramInt == m.cCJ())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d(this.rUm.context);
        AppMethodBeat.o(201705);
        return localObject;
      }
      localObject = m.skk;
      if (paramInt == m.cCK())
      {
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.d(this.rUm.context);
        AppMethodBeat.o(201705);
        return localObject;
      }
      p.gfZ();
      AppMethodBeat.o(201705);
      return null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<gz>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1$callback$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c
 * JD-Core Version:    0.7.0.1
 */