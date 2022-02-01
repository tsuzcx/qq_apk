package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.f.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "onAttach", "callback", "onDetach", "releaseListener", "Companion", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.finder.presenter.base.a<e>
{
  public static final a tMv;
  final Context context;
  private int dLS;
  ArrayList<s> data;
  FeedData feed;
  private boolean isLoading;
  private b lastBuffer;
  private int scene;
  private final WxRecyclerAdapter<s> tFp;
  private e tMr;
  private IListener<he> tMs;
  private Boolean tMt;
  private boolean tMu;
  
  static
  {
    AppMethodBeat.i(243719);
    tMv = new a((byte)0);
    AppMethodBeat.o(243719);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(243718);
    this.context = paramContext;
    this.scene = 2;
    this.data = new ArrayList();
    this.tFp = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(this), this.data);
    this.tMt = Boolean.TRUE;
    AppMethodBeat.o(243718);
  }
  
  private final List<s> dcw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(243713);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.f.vGd;
    Object localObject3 = this.feed;
    if (localObject3 == null) {
      p.hyc();
    }
    localObject3 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).FG(((FeedData)localObject3).getId());
    if (localObject3 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.data.f.vGd;
      Object localObject4 = this.feed;
      if (localObject4 == null) {
        p.hyc();
      }
      localObject4 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).U(((FeedData)localObject4).getId(), 0L);
      if (localObject4 != null) {}
      for (localObject1 = ((f.b)localObject4).lastBuffer;; localObject1 = null)
      {
        this.lastBuffer = ((b)localObject1);
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Boolean.valueOf(((f.b)localObject4).tMU);
        }
        this.tMt = ((Boolean)localObject1);
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new s((an)((Iterator)localObject2).next()));
        }
      }
      localArrayList.addAll((Collection)localObject1);
      this.isLoading = false;
      this.tFp.notifyDataSetChanged();
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(243713);
    return localObject1;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(243715);
    p.h(parame, "callback");
    this.tMr = parame;
    parame = this.tMr;
    if (parame == null) {
      p.btv("viewCallback");
    }
    parame.initView();
    AppMethodBeat.o(243715);
  }
  
  public final void a(FeedData paramFeedData, int paramInt)
  {
    AppMethodBeat.i(243710);
    p.h(paramFeedData, "feed");
    this.dLS = paramInt;
    this.isLoading = false;
    this.feed = paramFeedData;
    c localc = c.vdc;
    c.start(paramFeedData.getId());
    this.data.clear();
    this.tFp.notifyDataSetChanged();
    dcx();
    this.tMu = false;
    AppMethodBeat.o(243710);
  }
  
  public final void bqe()
  {
    AppMethodBeat.i(243712);
    if ((this.feed != null) && (!this.tMu) && (!this.isLoading)) {
      if (((Collection)this.data).isEmpty()) {
        break label55;
      }
    }
    label55:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(243712);
      return;
    }
    this.isLoading = true;
    Object localObject = this.tMs;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    this.tMs = ((IListener)new c(this));
    localObject = this.tMs;
    if (localObject != null) {
      ((IListener)localObject).alive();
    }
    this.data.addAll((Collection)dcw());
    if (!((Collection)this.data).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        dcx();
      }
      localObject = new StringBuilder("refreshData: get comment from cache, size=").append(this.data.size()).append(", feedId=");
      FeedData localFeedData = this.feed;
      if (localFeedData == null) {
        p.hyc();
      }
      Log.i("Finder.FinderBulletSubtitlePresenter", localFeedData.getId());
      this.tFp.notifyDataSetChanged();
      AppMethodBeat.o(243712);
      return;
    }
  }
  
  public final void dcx()
  {
    AppMethodBeat.i(243714);
    IListener localIListener = this.tMs;
    if (localIListener != null) {
      localIListener.dead();
    }
    this.tMs = null;
    this.isLoading = false;
    AppMethodBeat.o(243714);
  }
  
  public final WxRecyclerAdapter<?> fm(Context paramContext)
  {
    AppMethodBeat.i(243711);
    p.h(paramContext, "context");
    paramContext = this.tFp;
    AppMethodBeat.o(243711);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243717);
    dcx();
    AppMethodBeat.o(243717);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$Companion;", "", "()V", "TAG", "", "initSwitch", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(243707);
      Object localObject = s.uOj;
      if (paramInt == s.dky())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new g(this.tMw.context);
        AppMethodBeat.o(243707);
        return localObject;
      }
      localObject = s.uOj;
      if (paramInt == s.dkz())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new g(this.tMw.context);
        AppMethodBeat.o(243707);
        return localObject;
      }
      localObject = y.vXH;
      y.dQ("Finder.FinderBulletSubtitlePresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(243707);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<he>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(d.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d
 * JD-Core Version:    0.7.0.1
 */