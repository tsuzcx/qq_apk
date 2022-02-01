package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.a;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.b;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.bd;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "finderHotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "followID", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "onHellScrollerListener", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "topicId", "", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<FinderTopicTimelineUIContract.Loader, FinderTopicTimelineUIContract.c, FinderTopicTimelineUIContract.b>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private bdm location;
  private final int scene;
  private String topic;
  private int type;
  private FinderTopicTimelineUIContract.b xTg;
  private FinderTopicTimelineUIContract.c xTh;
  private FinderTopicTimelineUIContract.Loader xTi;
  private com.tencent.mm.cd.b xTj;
  private String xTk;
  private final c xTl;
  private biv xcZ;
  private long xee;
  private final int xkX;
  
  public FinderTopicTimelineUI()
  {
    AppMethodBeat.i(269619);
    this.TAG = "Finder.FinderTopicTimelineUI";
    this.topic = "";
    this.xkX = 9;
    this.scene = 2;
    this.xTl = new c(this);
    AppMethodBeat.o(269619);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(269623);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(269623);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(269622);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(269622);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(269616);
    int i = getIntent().getIntExtra("key_topic_type", 1);
    if (i == 1)
    {
      AppMethodBeat.o(269616);
      return 9;
    }
    if (i == 4)
    {
      AppMethodBeat.o(269616);
      return 52;
    }
    if (i == 5)
    {
      AppMethodBeat.o(269616);
      return 64;
    }
    if (i == 7)
    {
      AppMethodBeat.o(269616);
      return 60;
    }
    AppMethodBeat.o(269616);
    return 27;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_topic_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166284);
    this.type = getIntent().getIntExtra("key_topic_type", 1);
    Object localObject3 = getIntent().getStringExtra("key_topic_title");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.topic = ((String)localObject1);
    this.xee = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
    this.xTk = getIntent().getStringExtra("KEY_FOLLOW_ID");
    localObject1 = getIntent().getByteArrayExtra("KEY_HOT_TOPIC_BUFFER");
    if (localObject1 != null) {
      this.xTj = new com.tencent.mm.cd.b((byte[])localObject1);
    }
    switch (this.type)
    {
    default: 
      setMMTitle(String.valueOf(this.topic));
    }
    for (;;)
    {
      this.location = new bdm();
      localObject1 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject1 != null)
      {
        localObject3 = this.location;
        if (localObject3 == null) {
          p.bGy("location");
        }
        ((bdm)localObject3).parseFrom((byte[])localObject1);
      }
      localObject1 = (com.tencent.mm.cd.a)new biv();
      localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        this.xcZ = ((biv)localObject1);
        Log.i(this.TAG, "type:" + this.type + ", topic:" + this.topic + ',');
        this.xTg = new FinderTopicTimelineUIContract.b((MMActivity)this, this.scene, this.type);
        localObject1 = (MMActivity)this;
        localObject3 = this.xTg;
        if (localObject3 == null) {
          p.bGy("presenter");
        }
        this.xTh = new FinderTopicTimelineUIContract.c((MMActivity)localObject1, (FinderTopicTimelineUIContract.b)localObject3, this.scene, this.xkX);
        int i = this.type;
        localObject1 = this.topic;
        long l = this.xee;
        localObject3 = this.location;
        if (localObject3 == null) {
          p.bGy("location");
        }
        com.tencent.mm.plugin.finder.feed.model.internal.g localg = com.tencent.mm.plugin.finder.feed.model.internal.g.xKy;
        biv localbiv = this.xcZ;
        com.tencent.mm.ui.component.g localg1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = new FinderTopicTimelineUIContract.Loader(i, (String)localObject1, l, (bdm)localObject3, localg, localbiv, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).ekY());
        localObject3 = getIntent();
        p.j(localObject3, "intent");
        ((FinderTopicTimelineUIContract.Loader)localObject1).initFromCache((Intent)localObject3);
        ((FinderTopicTimelineUIContract.Loader)localObject1).groupId = this.xTk;
        ((FinderTopicTimelineUIContract.Loader)localObject1).setInitDone((j)new a((FinderTopicTimelineUIContract.Loader)localObject1, this));
        ((FinderTopicTimelineUIContract.Loader)localObject1).refObjectId = getIntent().getLongExtra("key_ref_object_id", 0L);
        ((FinderTopicTimelineUIContract.Loader)localObject1).xEI = ((kotlin.g.a.a)new b(this));
        if (((FinderTopicTimelineUIContract.Loader)localObject1).type == 7)
        {
          ((FinderTopicTimelineUIContract.Loader)localObject1).xdR = getIntent().getLongExtra("key_activity_id", 0L);
          ((FinderTopicTimelineUIContract.Loader)localObject1).xEw = getIntent().getIntExtra("key_activity_inner_tab_type", 1);
        }
        ((FinderTopicTimelineUIContract.Loader)localObject1).xEH = this.xTj;
        this.xTi = ((FinderTopicTimelineUIContract.Loader)localObject1);
        localObject1 = this.xTh;
        if (localObject1 == null) {
          p.bGy("viewCallback");
        }
        ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)this.xTl);
        AppMethodBeat.o(166284);
        return;
        setMMTitle("#" + this.topic);
        continue;
        setMMTitle("");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178307);
    FinderTopicTimelineUIContract.c localc = this.xTh;
    if (localc == null) {
      p.bGy("viewCallback");
    }
    localc.xvJ.getRecyclerView().b((RecyclerView.l)this.xTl);
    super.onDestroy();
    AppMethodBeat.o(178307);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(269618);
    super.onPause();
    Object localObject1 = FinderTopicTimelineUIContract.xEF;
    localObject1 = FinderTopicTimelineUIContract.a.MC(this.type);
    Object localObject2 = k.yBj;
    localObject2 = this.xTh;
    if (localObject2 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = ((b.b)localObject2).xvJ.getRecyclerView();
    Object localObject3 = ((com.tencent.mm.vending.j.c)localObject1).ieT();
    p.j(localObject3, "tuple2.`$1`()");
    localObject3 = (s.t)localObject3;
    localObject1 = ((com.tencent.mm.vending.j.c)localObject1).ieU();
    p.j(localObject1, "tuple2.`$2`()");
    k.b((RecyclerView)localObject2, (s.t)localObject3, (String)localObject1, com.tencent.mm.plugin.finder.live.report.c.yAj);
    AppMethodBeat.o(269618);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(269617);
    super.onResume();
    Object localObject1 = FinderTopicTimelineUIContract.xEF;
    localObject1 = FinderTopicTimelineUIContract.a.MC(this.type);
    Object localObject2 = k.yBj;
    localObject2 = this.xTh;
    if (localObject2 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = ((b.b)localObject2).xvJ.getRecyclerView();
    Object localObject3 = ((com.tencent.mm.vending.j.c)localObject1).ieT();
    p.j(localObject3, "tuple2.`$1`()");
    localObject3 = (s.t)localObject3;
    localObject1 = ((com.tencent.mm.vending.j.c)localObject1).ieU();
    p.j(localObject1, "tuple2.`$2`()");
    k.b((RecyclerView)localObject2, (s.t)localObject3, (String)localObject1, com.tencent.mm.plugin.finder.live.report.c.yAi);
    AppMethodBeat.o(269617);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderTopicTimelineUIContract.Loader paramLoader, FinderTopicTimelineUI paramFinderTopicTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(290871);
      Object localObject = FinderTopicTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(290871);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xTm.getInitPos(), 0);
      }
      localObject = this.xTm.getCache();
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.feed.model.q)localObject).xJT;; localObject = null)
      {
        if ((localObject instanceof bd)) {
          FinderTopicTimelineUI.b(jdField_this).xEJ = ((bd)localObject).xEX;
        }
        AppMethodBeat.o(290871);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$2"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FinderTopicTimelineUI paramFinderTopicTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(244884);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(244884);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(244879);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = FinderTopicTimelineUIContract.xEF;
      localObject1 = FinderTopicTimelineUIContract.a.MC(FinderTopicTimelineUI.c(this.xTn));
      Object localObject2 = k.yBj;
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).ieT();
      p.j(localObject2, "tuple2.`$1`()");
      localObject2 = (s.t)localObject2;
      localObject1 = ((com.tencent.mm.vending.j.c)localObject1).ieU();
      p.j(localObject1, "tuple2.`$2`()");
      k.b(paramRecyclerView, (s.t)localObject2, (String)localObject1, com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(244879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */