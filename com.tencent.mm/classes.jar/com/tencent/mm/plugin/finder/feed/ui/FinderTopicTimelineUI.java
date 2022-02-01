package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.feed.aj.f;
import com.tencent.mm.plugin.finder.feed.aj.g;
import com.tencent.mm.plugin.finder.feed.aj.h;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "commentScene", "", "feedLoader", "initPos", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "plugin-finder_release"})
public final class FinderTopicTimelineUI
  extends FinderLoaderFeedUI<aj.f, aj.h, aj.g>
{
  private final String TAG = "Finder.FinderTopicTimelineUI";
  private HashMap _$_findViewCache;
  private String dol = "";
  private alt location;
  private anu qYj;
  private final int rfR = 9;
  private long rhr;
  private int rht;
  private aj.g rsM;
  private aj.h rsN;
  private aj.f rsO;
  private final int scene = 2;
  private int type;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202520);
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
    AppMethodBeat.o(202520);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(202519);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(202519);
      return 9;
    }
    AppMethodBeat.o(202519);
    return 27;
  }
  
  public final int cvJ()
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
    k.g(localObject1, "intent.getStringExtra(Co…icFeedUI.KEY_TOPIC_TITLE)");
    this.dol = ((String)localObject1);
    switch (this.type)
    {
    default: 
      setMMTitle(String.valueOf(this.dol));
    }
    for (;;)
    {
      this.location = new alt();
      localObject1 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
      if (localObject1 != null)
      {
        localObject3 = this.location;
        if (localObject3 == null) {
          k.aVY("location");
        }
        ((alt)localObject3).parseFrom((byte[])localObject1);
      }
      this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      this.rht = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
      localObject1 = (com.tencent.mm.bw.a)new anu();
      Object localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        this.qYj = ((anu)localObject1);
        ac.i(this.TAG, "type:" + this.type + ", topic:" + this.dol + ", cacheId:" + this.rhr + ", initPos:" + this.rht);
        this.rsM = new aj.g((MMActivity)this, this.rhr, this.rht, this.scene);
        localObject1 = (MMActivity)this;
        localObject3 = this.rsM;
        if (localObject3 == null) {
          k.aVY("presenter");
        }
        this.rsN = new aj.h((MMActivity)localObject1, (aj.g)localObject3, this.scene, this.rfR);
        int i = this.type;
        localObject1 = this.dol;
        localObject3 = this.location;
        if (localObject3 == null) {
          k.aVY("location");
        }
        c localc = c.roh;
        anu localanu = this.qYj;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
        localObject1 = new aj.f(i, (String)localObject1, (alt)localObject3, localc, localanu, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
        ((aj.f)localObject1).refObjectId = getIntent().getLongExtra("key_ref_object_id", 0L);
        ((aj.f)localObject1).fetchEndCallback = ((d.g.a.a)new a(this));
        this.rsO = ((aj.f)localObject1);
        AppMethodBeat.o(166284);
        return;
        setMMTitle("#" + this.dol + '#');
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178307);
    super.onDestroy();
    aj.a locala = aj.rmg;
    aj.a.ui(this.rhr);
    AppMethodBeat.o(178307);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$2$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI
 * JD-Core Version:    0.7.0.1
 */