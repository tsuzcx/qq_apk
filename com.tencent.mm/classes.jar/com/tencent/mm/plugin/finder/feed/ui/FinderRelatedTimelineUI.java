package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "title", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.l, v.b, v.a>
{
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private long rhr;
  private int rht;
  private ale rjx;
  private v.a rsc;
  private v.b rsd;
  private com.tencent.mm.plugin.finder.feed.model.l rse;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202476);
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
    AppMethodBeat.o(202476);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(202474);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(202474);
      return 29;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202474);
      return 31;
    }
    AppMethodBeat.o(202474);
    return 0;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496250;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202470);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.rht = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = (com.tencent.mm.bw.a)new ale();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      this.rjx = ((ale)localObject1);
      if (this.rjx == null)
      {
        ac.i(this.TAG, "req is null, finish");
        finish();
        this.rjx = new ale();
      }
      this.rsc = new v.a((MMActivity)this, this.rhr, this.rht, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.rsc;
      if (localObject3 == null) {
        k.aVY("presenter");
      }
      this.rsd = new v.b((MMActivity)localObject1, (v.a)localObject3, this.scene, cuI());
      localObject1 = this.rjx;
      if (localObject1 == null) {
        k.fOy();
      }
      int i = ((ale)localObject1).diw;
      int j = cuI();
      localObject1 = this.rjx;
      if (localObject1 == null) {
        k.fOy();
      }
      float f1 = ((ale)localObject1).doB;
      localObject1 = this.rjx;
      if (localObject1 == null) {
        k.fOy();
      }
      float f2 = ((ale)localObject1).dmL;
      localObject1 = this.rjx;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = ((ale)localObject1).qYj;
      k.g(localObject1, "req!!.sectionInfo");
      localObject3 = com.tencent.mm.ui.component.a.IrY;
      localObject1 = new com.tencent.mm.plugin.finder.feed.model.l(i, j, f1, f2, (anu)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      ((com.tencent.mm.plugin.finder.feed.model.l)localObject1).rmE = ((b)new a(this));
      this.rse = ((com.tencent.mm.plugin.finder.feed.model.l)localObject1);
      AppMethodBeat.o(202470);
      return;
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderRelatedTimelineUI paramFinderRelatedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */