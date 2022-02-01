package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ab.a;
import com.tencent.mm.plugin.finder.feed.ab.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "title", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<z, ab.b, ab.a>
{
  private dyz KNW;
  private ab.a KSQ;
  private ab.b KSR;
  private z KSS;
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198555);
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
    AppMethodBeat.o(198555);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 29;
  }
  
  public final int getLayoutId()
  {
    return 2131496249;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198550);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.qvB = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = (com.tencent.mm.bx.a)new dyz();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      this.KNW = ((dyz)localObject1);
      if (this.KNW == null)
      {
        ad.i(this.TAG, "req is null, finish");
        finish();
        this.KNW = new dyz();
      }
      this.KSQ = new ab.a((MMActivity)this, this.qxT, this.qvB, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.KSQ;
      if (localObject3 == null) {
        k.aPZ("presenter");
      }
      this.KSR = new ab.b((MMActivity)localObject1, (ab.a)localObject3, this.scene);
      localObject1 = this.KNW;
      if (localObject1 == null) {
        k.fvU();
      }
      int i = ((dyz)localObject1).IoU;
      localObject1 = this.KNW;
      if (localObject1 == null) {
        k.fvU();
      }
      float f1 = ((dyz)localObject1).dqQ;
      localObject1 = this.KNW;
      if (localObject1 == null) {
        k.fvU();
      }
      float f2 = ((dyz)localObject1).dpb;
      localObject1 = this.KNW;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = ((dyz)localObject1).KJJ;
      k.g(localObject1, "req!!.sectionInfo");
      localObject3 = com.tencent.mm.ui.component.a.LCX;
      localObject1 = new z(i, 29, f1, f2, (dzq)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((z)localObject1).KPL = ((b)new a(this));
      this.KSS = ((z)localObject1);
      AppMethodBeat.o(198550);
      return;
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */