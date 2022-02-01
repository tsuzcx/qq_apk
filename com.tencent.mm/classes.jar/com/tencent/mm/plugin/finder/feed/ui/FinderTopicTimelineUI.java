package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.a;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.b;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.bl;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "finderHotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "followID", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "onHellScrollerListener", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "topicId", "", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<FinderTopicTimelineUIContract.Loader, FinderTopicTimelineUIContract.c, FinderTopicTimelineUIContract.b>
{
  private bve ACr;
  private long ADo;
  private final int AJo;
  private FinderTopicTimelineUIContract.b BsD;
  private FinderTopicTimelineUIContract.c BsE;
  private FinderTopicTimelineUIContract.Loader BsF;
  private com.tencent.mm.bx.b BsG;
  private String BsH;
  private final c BsI;
  private final String TAG;
  private boi location;
  private final int scene;
  private String topic;
  private int type;
  
  public FinderTopicTimelineUI()
  {
    AppMethodBeat.i(365057);
    this.TAG = "Finder.FinderTopicTimelineUI";
    this.topic = "";
    this.AJo = 9;
    this.scene = 2;
    this.BsI = new c(this);
    AppMethodBeat.o(365057);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(365118);
    switch (getIntent().getIntExtra("key_topic_type", 1))
    {
    case 2: 
    case 3: 
    case 6: 
    default: 
      AppMethodBeat.o(365118);
      return 27;
    case 1: 
      AppMethodBeat.o(365118);
      return 9;
    case 4: 
      AppMethodBeat.o(365118);
      return 52;
    case 5: 
      AppMethodBeat.o(365118);
      return 64;
    }
    AppMethodBeat.o(365118);
    return 60;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_topic_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166284);
    this.type = getIntent().getIntExtra("key_topic_type", 1);
    Object localObject2 = getIntent().getStringExtra("key_topic_title");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.topic = ((String)localObject1);
    this.ADo = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
    this.BsH = getIntent().getStringExtra("KEY_FOLLOW_ID");
    long l1 = getIntent().getLongExtra("key_ref_object_id", 0L);
    localObject1 = getIntent().getByteArrayExtra("KEY_HOT_TOPIC_BUFFER");
    if (localObject1 != null) {
      this.BsG = new com.tencent.mm.bx.b((byte[])localObject1);
    }
    switch (this.type)
    {
    default: 
      setMMTitle(this.topic);
    }
    for (;;)
    {
      this.location = new boi();
      Object localObject3 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject3 != null)
      {
        localObject2 = this.location;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("location");
          localObject1 = null;
        }
        ((boi)localObject1).parseFrom((byte[])localObject3);
      }
      localObject1 = (com.tencent.mm.bx.a)new bve();
      localObject2 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject2);
        this.ACr = ((bve)localObject1);
        Log.i(this.TAG, "type:" + this.type + ", topic:" + this.topic + ',');
        this.BsD = new FinderTopicTimelineUIContract.b((MMActivity)this, this.scene, this.type);
        localObject3 = (MMActivity)this;
        localObject2 = this.BsD;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          localObject1 = null;
        }
        this.BsE = new FinderTopicTimelineUIContract.c((MMActivity)localObject3, (FinderTopicTimelineUIContract.b)localObject1, this.scene, this.AJo);
        int i = this.type;
        localObject3 = this.topic;
        long l2 = this.ADo;
        localObject2 = this.location;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("location");
          localObject1 = null;
        }
        localObject2 = g.Bkn;
        bve localbve = this.ACr;
        k localk = k.aeZF;
        localObject1 = new FinderTopicTimelineUIContract.Loader(i, (String)localObject3, l2, (boi)localObject1, (g)localObject2, localbve, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
        localObject2 = getIntent();
        kotlin.g.b.s.s(localObject2, "intent");
        ((FinderTopicTimelineUIContract.Loader)localObject1).initFromCache((Intent)localObject2);
        ((FinderTopicTimelineUIContract.Loader)localObject1).groupId = this.BsH;
        ((FinderTopicTimelineUIContract.Loader)localObject1).setInitDone((j)new a(this, (FinderTopicTimelineUIContract.Loader)localObject1));
        ((FinderTopicTimelineUIContract.Loader)localObject1).refObjectId = l1;
        ((FinderTopicTimelineUIContract.Loader)localObject1).BbB = ((kotlin.g.a.a)new b(this));
        if (((FinderTopicTimelineUIContract.Loader)localObject1).type == 7)
        {
          ((FinderTopicTimelineUIContract.Loader)localObject1).ocD = getIntent().getLongExtra("key_activity_id", 0L);
          ((FinderTopicTimelineUIContract.Loader)localObject1).Bbt = getIntent().getIntExtra("key_activity_inner_tab_type", 1);
        }
        ((FinderTopicTimelineUIContract.Loader)localObject1).BbA = this.BsG;
        localObject2 = ah.aiuX;
        this.BsF = ((FinderTopicTimelineUIContract.Loader)localObject1);
        localObject2 = this.BsE;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject1 = null;
        }
        ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)this.BsI);
        if (this.type == 7)
        {
          localObject1 = com.tencent.mm.plugin.finder.topic.a.FNS;
          com.tencent.mm.plugin.finder.topic.a.k((Context)this, this.ADo);
          AppMethodBeat.o(166284);
          return;
          setMMTitle(kotlin.g.b.s.X("#", this.topic));
          continue;
          setMMTitle("");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          locala = null;
        }
        com.tencent.mm.plugin.finder.topic.a locala = com.tencent.mm.plugin.finder.topic.a.FNS;
        com.tencent.mm.plugin.finder.topic.a.a((Context)this, l1, this.ADo, this.topic);
        AppMethodBeat.o(166284);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178307);
    FinderTopicTimelineUIContract.c localc2 = this.BsE;
    FinderTopicTimelineUIContract.c localc1 = localc2;
    if (localc2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localc1 = null;
    }
    localc1.ATx.getRecyclerView().b((RecyclerView.l)this.BsI);
    super.onDestroy();
    AppMethodBeat.o(178307);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365143);
    super.onPause();
    Object localObject1 = FinderTopicTimelineUIContract.Bby;
    Object localObject3 = FinderTopicTimelineUIContract.a.NL(this.type);
    ce localce = (ce)h.ax(ce.class);
    Object localObject2 = this.BsE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((b.b)localObject1).ATx.getRecyclerView();
    localObject2 = ((com.tencent.mm.vending.j.b)localObject3).get(0);
    kotlin.g.b.s.s(localObject2, "tuple2.`$1`()");
    localObject2 = (q.w)localObject2;
    localObject3 = ((c)localObject3).get(1);
    kotlin.g.b.s.s(localObject3, "tuple2.`$2`()");
    localce.b((RecyclerView)localObject1, (q.w)localObject2, (String)localObject3, d.Dng);
    AppMethodBeat.o(365143);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365135);
    super.onResume();
    Object localObject1 = FinderTopicTimelineUIContract.Bby;
    Object localObject3 = FinderTopicTimelineUIContract.a.NL(this.type);
    ce localce = (ce)h.ax(ce.class);
    Object localObject2 = this.BsE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((b.b)localObject1).ATx.getRecyclerView();
    localObject2 = ((com.tencent.mm.vending.j.b)localObject3).get(0);
    kotlin.g.b.s.s(localObject2, "tuple2.`$1`()");
    localObject2 = (q.w)localObject2;
    localObject3 = ((c)localObject3).get(1);
    kotlin.g.b.s.s(localObject3, "tuple2.`$2`()");
    localce.b((RecyclerView)localObject1, (q.w)localObject2, (String)localObject3, d.Dnf);
    AppMethodBeat.o(365135);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderTopicTimelineUI paramFinderTopicTimelineUI, FinderTopicTimelineUIContract.Loader paramLoader) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(365627);
      Object localObject3 = FinderTopicTimelineUI.a(this.BsJ);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject3 = this.BsK;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderTopicTimelineUIContract.Loader)localObject3).getInitPos(), 0);
      }
      localObject1 = this.BsK.getCache();
      if (localObject1 == null)
      {
        localObject1 = null;
        if ((localObject1 instanceof bl))
        {
          localObject3 = FinderTopicTimelineUI.b(this.BsJ);
          if (localObject3 != null) {
            break label130;
          }
          kotlin.g.b.s.bIx("feedLoader");
        }
      }
      for (;;)
      {
        localObject2.BbC = ((bl)localObject1).BbS;
        AppMethodBeat.o(365627);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).BjG;
        break;
        label130:
        localObject2 = localObject3;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderTopicTimelineUI paramFinderTopicTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(FinderTopicTimelineUI paramFinderTopicTimelineUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365688);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(365688);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365675);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = FinderTopicTimelineUIContract.Bby;
      Object localObject2 = FinderTopicTimelineUIContract.a.NL(FinderTopicTimelineUI.c(this.BsJ));
      localObject1 = (ce)h.ax(ce.class);
      Object localObject3 = ((com.tencent.mm.vending.j.b)localObject2).get(0);
      kotlin.g.b.s.s(localObject3, "tuple2.`$1`()");
      localObject3 = (q.w)localObject3;
      localObject2 = ((c)localObject2).get(1);
      kotlin.g.b.s.s(localObject2, "tuple2.`$2`()");
      ((ce)localObject1).b(paramRecyclerView, (q.w)localObject3, (String)localObject2, d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */