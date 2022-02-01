package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.z.a;
import com.tencent.mm.plugin.finder.feed.z.b;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderRelatedLoader, z.b, z.a>
{
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private aow sgA;
  private z.a sqd;
  private z.b sqe;
  private FinderRelatedLoader sqf;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203336);
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
    AppMethodBeat.o(203336);
    return localView1;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(203333);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(203333);
      return 29;
    }
    if (i == 1)
    {
      AppMethodBeat.o(203333);
      return 31;
    }
    AppMethodBeat.o(203333);
    return 0;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203334);
    Object localObject1 = this.sqe;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    localObject1 = ((a.b)localObject1).scj.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject2 = this.sqf;
      if (localObject2 == null) {
        d.g.b.p.bdF("feedLoader");
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.p.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(203334);
  }
  
  public final int getLayoutId()
  {
    return 2131496250;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203329);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (com.tencent.mm.bw.a)new aow();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      this.sgA = ((aow)localObject1);
      if (this.sgA == null)
      {
        ae.i(this.TAG, "req is null, finish");
        finish();
        this.sgA = new aow();
      }
      this.sqd = new z.a((MMActivity)this, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.sqd;
      if (localObject3 == null) {
        d.g.b.p.bdF("presenter");
      }
      this.sqe = new z.b((MMActivity)localObject1, (z.a)localObject3, this.scene, cCL());
      localObject1 = this.sgA;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      int i = ((aow)localObject1).dvm;
      int j = cCL();
      localObject1 = this.sgA;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      float f1 = ((aow)localObject1).dBu;
      localObject1 = this.sgA;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      float f2 = ((aow)localObject1).dzE;
      localObject1 = this.sgA;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject3 = ((aow)localObject1).rRJ;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new arv();
      }
      localObject3 = com.tencent.mm.ui.component.a.KEX;
      localObject1 = new FinderRelatedLoader(i, j, f1, f2, (arv)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
      localObject3 = getIntent();
      d.g.b.p.g(localObject3, "intent");
      ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderRelatedLoader)localObject1).setInitDone((h)new a((FinderRelatedLoader)localObject1, this));
      ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.sqf = ((FinderRelatedLoader)localObject1);
      AppMethodBeat.o(203329);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderRelatedLoader paramFinderRelatedLoader, FinderRelatedTimelineUI paramFinderRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(203327);
      Object localObject = FinderRelatedTimelineUI.a(jdField_this).scj.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(203327);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sqg.getInitPos(), 0);
        AppMethodBeat.o(203327);
        return;
      }
      AppMethodBeat.o(203327);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<am>, z>
  {
    b(FinderRelatedTimelineUI paramFinderRelatedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */