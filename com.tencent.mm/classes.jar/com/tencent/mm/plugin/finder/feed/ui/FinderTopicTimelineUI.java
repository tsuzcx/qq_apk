package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.a;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.b;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "plugin-finder_release"})
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<FinderTopicTimelineUIContract.Loader, FinderTopicTimelineUIContract.c, FinderTopicTimelineUIContract.a>
{
  private final String TAG = "Finder.FinderTopicTimelineUI";
  private HashMap _$_findViewCache;
  private String dzZ = "";
  private aoy location;
  private arg rJv;
  private final int rTD = 9;
  private final int scene = 2;
  private FinderTopicTimelineUIContract.a shY;
  private FinderTopicTimelineUIContract.c shZ;
  private FinderTopicTimelineUIContract.Loader sia;
  private int type;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202906);
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
    AppMethodBeat.o(202906);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(202904);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(202904);
      return 9;
    }
    AppMethodBeat.o(202904);
    return 27;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131494122;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(166284);
    this.type = getIntent().getIntExtra("key_topic_type", 1);
    Object localObject1 = getIntent().getStringExtra("key_topic_title");
    p.g(localObject1, "intent.getStringExtra(Co…icFeedUI.KEY_TOPIC_TITLE)");
    this.dzZ = ((String)localObject1);
    switch (this.type)
    {
    default: 
      setMMTitle(String.valueOf(this.dzZ));
    }
    for (;;)
    {
      this.location = new aoy();
      localObject1 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject1 != null)
      {
        localObject3 = this.location;
        if (localObject3 == null) {
          p.bcb("location");
        }
        ((aoy)localObject3).parseFrom((byte[])localObject1);
      }
      localObject1 = (com.tencent.mm.bx.a)new arg();
      Object localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        this.rJv = ((arg)localObject1);
        ad.i(this.TAG, "type:" + this.type + ", topic:" + this.dzZ + ',');
        this.shY = new FinderTopicTimelineUIContract.a((MMActivity)this, this.scene);
        localObject1 = (MMActivity)this;
        localObject3 = this.shY;
        if (localObject3 == null) {
          p.bcb("presenter");
        }
        this.shZ = new FinderTopicTimelineUIContract.c((MMActivity)localObject1, (FinderTopicTimelineUIContract.a)localObject3, this.scene, this.rTD);
        int i = this.type;
        localObject1 = this.dzZ;
        localObject3 = this.location;
        if (localObject3 == null) {
          p.bcb("location");
        }
        com.tencent.mm.plugin.finder.feed.model.internal.e locale = com.tencent.mm.plugin.finder.feed.model.internal.e.scP;
        arg localarg = this.rJv;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
        localObject1 = new FinderTopicTimelineUIContract.Loader(i, (String)localObject1, (aoy)localObject3, locale, localarg, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
        localObject3 = getIntent();
        p.g(localObject3, "intent");
        ((FinderTopicTimelineUIContract.Loader)localObject1).initFromCache((Intent)localObject3);
        ((FinderTopicTimelineUIContract.Loader)localObject1).setInitDone((h)new a((FinderTopicTimelineUIContract.Loader)localObject1, this));
        ((FinderTopicTimelineUIContract.Loader)localObject1).refObjectId = getIntent().getLongExtra("key_ref_object_id", 0L);
        ((FinderTopicTimelineUIContract.Loader)localObject1).rTm = ((d.g.a.a)new b(this));
        this.sia = ((FinderTopicTimelineUIContract.Loader)localObject1);
        AppMethodBeat.o(166284);
        return;
        setMMTitle("#" + this.dzZ + '#');
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178307);
    super.onDestroy();
    AppMethodBeat.o(178307);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderTopicTimelineUIContract.Loader paramLoader, FinderTopicTimelineUI paramFinderTopicTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202902);
      Object localObject = FinderTopicTimelineUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202902);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sib.getInitPos(), 0);
      }
      localObject = this.sib.getCache();
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.feed.model.e)localObject).scs;; localObject = null)
      {
        if ((localObject instanceof FinderTopicTimelineUIContract.b)) {
          FinderTopicTimelineUI.b(jdField_this).saJ = ((FinderTopicTimelineUIContract.b)localObject).saM;
        }
        AppMethodBeat.o(202902);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$2$2"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderTopicTimelineUI paramFinderTopicTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */