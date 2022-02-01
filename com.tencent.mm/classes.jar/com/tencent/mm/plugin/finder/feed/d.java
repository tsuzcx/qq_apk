package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.hl;
import com.tencent.mm.plugin.finder.convert.h;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.f.b;
import com.tencent.mm.plugin.finder.utils.aj;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "onAttach", "callback", "onDetach", "releaseListener", "Companion", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.finder.presenter.base.a<e>
{
  public static final a xwm;
  final Context context;
  ArrayList<s> data;
  private int fEH;
  FeedData feed;
  private boolean isLoading;
  private b lastBuffer;
  private int scene;
  private final WxRecyclerAdapter<s> xnR;
  private e xwi;
  private IListener<hl> xwj;
  private Boolean xwk;
  private boolean xwl;
  
  static
  {
    AppMethodBeat.i(271930);
    xwm = new a((byte)0);
    AppMethodBeat.o(271930);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(271929);
    this.context = paramContext;
    this.scene = 2;
    this.data = new ArrayList();
    this.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(this), this.data);
    this.xwk = Boolean.TRUE;
    AppMethodBeat.o(271929);
  }
  
  private final List<s> dsM()
  {
    Object localObject2 = null;
    AppMethodBeat.i(271923);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.f.Anc;
    Object localObject3 = this.feed;
    if (localObject3 == null) {
      p.iCn();
    }
    localObject3 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).MO(((FeedData)localObject3).getId());
    if (localObject3 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.data.f.Anc;
      Object localObject4 = this.feed;
      if (localObject4 == null) {
        p.iCn();
      }
      localObject4 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).Z(((FeedData)localObject4).getId(), 0L);
      if (localObject4 != null) {}
      for (localObject1 = ((f.b)localObject4).lastBuffer;; localObject1 = null)
      {
        this.lastBuffer = ((b)localObject1);
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Boolean.valueOf(((f.b)localObject4).xwL);
        }
        this.xwk = ((Boolean)localObject1);
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new s((am)((Iterator)localObject2).next()));
        }
      }
      localArrayList.addAll((Collection)localObject1);
      this.isLoading = false;
      this.xnR.notifyDataSetChanged();
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(271923);
    return localObject1;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(271926);
    p.k(parame, "callback");
    this.xwi = parame;
    parame = this.xwi;
    if (parame == null) {
      p.bGy("viewCallback");
    }
    parame.initView();
    AppMethodBeat.o(271926);
  }
  
  public final void a(FeedData paramFeedData, int paramInt)
  {
    AppMethodBeat.i(271920);
    p.k(paramFeedData, "feed");
    this.fEH = paramInt;
    this.isLoading = false;
    this.feed = paramFeedData;
    c localc = c.zTT;
    c.start(paramFeedData.getId());
    this.data.clear();
    this.xnR.notifyDataSetChanged();
    dsN();
    this.xwl = false;
    AppMethodBeat.o(271920);
  }
  
  public final void dlN()
  {
    AppMethodBeat.i(271922);
    if ((this.feed != null) && (!this.xwl) && (!this.isLoading)) {
      if (((Collection)this.data).isEmpty()) {
        break label55;
      }
    }
    label55:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(271922);
      return;
    }
    this.isLoading = true;
    Object localObject = this.xwj;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    this.xwj = ((IListener)new c(this));
    localObject = this.xwj;
    if (localObject != null) {
      ((IListener)localObject).alive();
    }
    this.data.addAll((Collection)dsM());
    if (!((Collection)this.data).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        dsN();
      }
      localObject = new StringBuilder("refreshData: get comment from cache, size=").append(this.data.size()).append(", feedId=");
      FeedData localFeedData = this.feed;
      if (localFeedData == null) {
        p.iCn();
      }
      Log.i("Finder.FinderBulletSubtitlePresenter", localFeedData.getId());
      this.xnR.notifyDataSetChanged();
      AppMethodBeat.o(271922);
      return;
    }
  }
  
  public final void dsN()
  {
    AppMethodBeat.i(271925);
    IListener localIListener = this.xwj;
    if (localIListener != null) {
      localIListener.dead();
    }
    this.xwj = null;
    this.isLoading = false;
    AppMethodBeat.o(271925);
  }
  
  public final WxRecyclerAdapter<?> fs(Context paramContext)
  {
    AppMethodBeat.i(271921);
    p.k(paramContext, "context");
    paramContext = this.xnR;
    AppMethodBeat.o(271921);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(271928);
    dsN();
    AppMethodBeat.o(271928);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$Companion;", "", "()V", "TAG", "", "initSwitch", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(288856);
      Object localObject = s.zAx;
      if (paramInt == s.dKv())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new h(this.xwn.context);
        AppMethodBeat.o(288856);
        return localObject;
      }
      localObject = s.zAx;
      if (paramInt == s.dKw())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new h(this.xwn.context);
        AppMethodBeat.o(288856);
        return localObject;
      }
      localObject = aj.AGc;
      aj.em("Finder.FinderBulletSubtitlePresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(288856);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hl>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$loadData$1$callback$1$1"})
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