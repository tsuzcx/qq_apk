package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.f;
import com.tencent.mm.plugin.finder.feed.m.g;
import com.tencent.mm.plugin.finder.feed.m.h;
import com.tencent.mm.plugin.finder.feed.model.internal.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "commentScene", "", "feedLoader", "initPos", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "plugin-finder_release"})
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<m.f, m.h, m.g>
{
  private dzq KJJ;
  private final String TAG = "Finder.FinderTopicTimelineUI";
  private HashMap _$_findViewCache;
  private String dqA = "";
  private ajq location;
  private m.g qBL;
  private m.h qBM;
  private m.f qBN;
  private final int qqE = 9;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  private int type;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198596);
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
    AppMethodBeat.o(198596);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(198595);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(198595);
      return 9;
    }
    AppMethodBeat.o(198595);
    return 27;
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
    k.g(localObject1, "intent.getStringExtra(Co…icFeedUI.KEY_TOPIC_TITLE)");
    this.dqA = ((String)localObject1);
    switch (this.type)
    {
    default: 
      setMMTitle(String.valueOf(this.dqA));
    }
    for (;;)
    {
      this.location = new ajq();
      localObject1 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject1 != null)
      {
        localObject3 = this.location;
        if (localObject3 == null) {
          k.aPZ("location");
        }
        ((ajq)localObject3).parseFrom((byte[])localObject1);
      }
      this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      this.qvB = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
      localObject1 = (com.tencent.mm.bx.a)new dzq();
      Object localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        this.KJJ = ((dzq)localObject1);
        ad.i(this.TAG, "type:" + this.type + ", topic:" + this.dqA + ", cacheId:" + this.qxT + ", initPos:" + this.qvB);
        this.qBL = new m.g((MMActivity)this, this.qxT, this.qvB, this.scene);
        localObject1 = (MMActivity)this;
        localObject3 = this.qBL;
        if (localObject3 == null) {
          k.aPZ("presenter");
        }
        this.qBM = new m.h((MMActivity)localObject1, (m.g)localObject3, this.scene, this.qqE);
        int i = this.type;
        localObject1 = this.dqA;
        localObject3 = this.location;
        if (localObject3 == null) {
          k.aPZ("location");
        }
        b localb = b.KQI;
        dzq localdzq = this.KJJ;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
        localObject1 = new m.f(i, (String)localObject1, (ajq)localObject3, localb, localdzq, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
        ((m.f)localObject1).refObjectId = getIntent().getLongExtra("key_ref_object_id", 0L);
        ((m.f)localObject1).fetchEndCallback = ((d.g.a.a)new a(this));
        this.qBN = ((m.f)localObject1);
        AppMethodBeat.o(166284);
        return;
        setMMTitle("#" + this.dqA + '#');
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
    m.a locala = m.qxS;
    m.a.BI(this.qxT);
    AppMethodBeat.o(178307);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$2$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(FinderTopicTimelineUI paramFinderTopicTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */