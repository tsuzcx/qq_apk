package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.a;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.b;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.d;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "finderHotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "followID", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "onHellScrollerListener", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "topicId", "", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<FinderTopicTimelineUIContract.Loader, FinderTopicTimelineUIContract.d, FinderTopicTimelineUIContract.b>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private String dST;
  private axt location;
  private final int scene;
  private final int tCE;
  private bcc tvs;
  private long twp;
  private int type;
  private FinderTopicTimelineUIContract.d udA;
  private FinderTopicTimelineUIContract.Loader udB;
  private com.tencent.mm.bw.b udC;
  private String udD;
  private final c udE;
  private FinderTopicTimelineUIContract.b udz;
  
  public FinderTopicTimelineUI()
  {
    AppMethodBeat.i(245602);
    this.TAG = "Finder.FinderTopicTimelineUI";
    this.dST = "";
    this.tCE = 9;
    this.scene = 2;
    this.udE = new c(this);
    AppMethodBeat.o(245602);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245605);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245605);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245604);
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
    AppMethodBeat.o(245604);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245599);
    int i = getIntent().getIntExtra("key_topic_type", 1);
    if (i == 1)
    {
      AppMethodBeat.o(245599);
      return 9;
    }
    if (i == 4)
    {
      AppMethodBeat.o(245599);
      return 52;
    }
    if (i == 5)
    {
      AppMethodBeat.o(245599);
      return 64;
    }
    if (i == 7)
    {
      AppMethodBeat.o(245599);
      return 60;
    }
    AppMethodBeat.o(245599);
    return 27;
  }
  
  public final int getLayoutId()
  {
    return 2131494664;
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
    this.dST = ((String)localObject1);
    this.twp = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
    this.udD = getIntent().getStringExtra("KEY_FOLLOW_ID");
    localObject1 = getIntent().getByteArrayExtra("KEY_HOT_TOPIC_BUFFER");
    if (localObject1 != null) {
      this.udC = new com.tencent.mm.bw.b((byte[])localObject1);
    }
    switch (this.type)
    {
    default: 
      setMMTitle(String.valueOf(this.dST));
    }
    for (;;)
    {
      this.location = new axt();
      localObject1 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject1 != null)
      {
        localObject3 = this.location;
        if (localObject3 == null) {
          p.btv("location");
        }
        ((axt)localObject3).parseFrom((byte[])localObject1);
      }
      localObject1 = (com.tencent.mm.bw.a)new bcc();
      localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        this.tvs = ((bcc)localObject1);
        Log.i(this.TAG, "type:" + this.type + ", topic:" + this.dST + ',');
        this.udz = new FinderTopicTimelineUIContract.b((MMActivity)this, this.scene, this.type);
        localObject1 = (MMActivity)this;
        localObject3 = this.udz;
        if (localObject3 == null) {
          p.btv("presenter");
        }
        this.udA = new FinderTopicTimelineUIContract.d((MMActivity)localObject1, (FinderTopicTimelineUIContract.b)localObject3, this.scene, this.tCE);
        int i = this.type;
        localObject1 = this.dST;
        long l = this.twp;
        localObject3 = this.location;
        if (localObject3 == null) {
          p.btv("location");
        }
        Object localObject4 = e.tYu;
        bcc localbcc = this.tvs;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        localObject1 = new FinderTopicTimelineUIContract.Loader(i, (String)localObject1, l, (axt)localObject3, (e)localObject4, localbcc, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
        localObject3 = getIntent();
        p.g(localObject3, "intent");
        ((FinderTopicTimelineUIContract.Loader)localObject1).initFromCache((Intent)localObject3);
        ((FinderTopicTimelineUIContract.Loader)localObject1).groupId = this.udD;
        ((FinderTopicTimelineUIContract.Loader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a((FinderTopicTimelineUIContract.Loader)localObject1, this));
        ((FinderTopicTimelineUIContract.Loader)localObject1).refObjectId = getIntent().getLongExtra("key_ref_object_id", 0L);
        ((FinderTopicTimelineUIContract.Loader)localObject1).tTS = ((kotlin.g.a.a)new b(this));
        if (((FinderTopicTimelineUIContract.Loader)localObject1).type == 7)
        {
          ((FinderTopicTimelineUIContract.Loader)localObject1).twd = getIntent().getLongExtra("key_activity_id", 0L);
          ((FinderTopicTimelineUIContract.Loader)localObject1).tTH = getIntent().getIntExtra("key_activity_inner_tab_type", 0);
        }
        ((FinderTopicTimelineUIContract.Loader)localObject1).tTR = this.udC;
        this.udB = ((FinderTopicTimelineUIContract.Loader)localObject1);
        localObject1 = this.udA;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        ((b.b)localObject1).tLS.getRecyclerView().a((RecyclerView.l)this.udE);
        AppMethodBeat.o(166284);
        return;
        setMMTitle("#" + this.dST);
        continue;
        localObject3 = getIntent().getStringExtra("key_activity_name");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject4 = getIntent().getStringExtra("key_nick_name");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        setMMTitle(getString(2131766207, new Object[] { localObject3, localObject1 }));
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
    FinderTopicTimelineUIContract.d locald = this.udA;
    if (locald == null) {
      p.btv("viewCallback");
    }
    locald.tLS.getRecyclerView().b((RecyclerView.l)this.udE);
    super.onDestroy();
    AppMethodBeat.o(178307);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245601);
    super.onPause();
    Object localObject1 = FinderTopicTimelineUIContract.tTP;
    localObject1 = FinderTopicTimelineUIContract.a.IK(this.type);
    Object localObject2 = k.vkd;
    localObject2 = this.udA;
    if (localObject2 == null) {
      p.btv("viewCallback");
    }
    localObject2 = ((b.b)localObject2).tLS.getRecyclerView();
    Object localObject3 = ((com.tencent.mm.vending.j.c)localObject1).hdM();
    p.g(localObject3, "tuple2.`$1`()");
    localObject3 = (s.p)localObject3;
    localObject1 = ((com.tencent.mm.vending.j.c)localObject1).hdN();
    p.g(localObject1, "tuple2.`$2`()");
    k.b((RecyclerView)localObject2, (s.p)localObject3, (String)localObject1, com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(245601);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245600);
    super.onResume();
    Object localObject1 = FinderTopicTimelineUIContract.tTP;
    localObject1 = FinderTopicTimelineUIContract.a.IK(this.type);
    Object localObject2 = k.vkd;
    localObject2 = this.udA;
    if (localObject2 == null) {
      p.btv("viewCallback");
    }
    localObject2 = ((b.b)localObject2).tLS.getRecyclerView();
    Object localObject3 = ((com.tencent.mm.vending.j.c)localObject1).hdM();
    p.g(localObject3, "tuple2.`$1`()");
    localObject3 = (s.p)localObject3;
    localObject1 = ((com.tencent.mm.vending.j.c)localObject1).hdN();
    p.g(localObject1, "tuple2.`$2`()");
    k.b((RecyclerView)localObject2, (s.p)localObject3, (String)localObject1, com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(245600);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderTopicTimelineUIContract.Loader paramLoader, FinderTopicTimelineUI paramFinderTopicTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245595);
      Object localObject = FinderTopicTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245595);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.udF.getInitPos(), 0);
      }
      localObject = this.udF.getCache();
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.feed.model.h)localObject).tXU;; localObject = null)
      {
        if ((localObject instanceof FinderTopicTimelineUIContract.c)) {
          FinderTopicTimelineUI.b(jdField_this).tTT = ((FinderTopicTimelineUIContract.c)localObject).tUb;
        }
        AppMethodBeat.o(245595);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$2"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(FinderTopicTimelineUI paramFinderTopicTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245598);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245598);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245597);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = FinderTopicTimelineUIContract.tTP;
      localObject1 = FinderTopicTimelineUIContract.a.IK(FinderTopicTimelineUI.c(this.udG));
      Object localObject2 = k.vkd;
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).hdM();
      p.g(localObject2, "tuple2.`$1`()");
      localObject2 = (s.p)localObject2;
      localObject1 = ((com.tencent.mm.vending.j.c)localObject1).hdN();
      p.g(localObject1, "tuple2.`$2`()");
      k.b(paramRecyclerView, (s.p)localObject2, (String)localObject1, com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245597);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */