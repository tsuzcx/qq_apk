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
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderRelatedLoader, z.b, z.a>
{
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private aoj rXP;
  private final int scene = 2;
  private z.a shj;
  private z.b shk;
  private FinderRelatedLoader shl;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202857);
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
    AppMethodBeat.o(202857);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(202854);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(202854);
      return 29;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202854);
      return 31;
    }
    AppMethodBeat.o(202854);
    return 0;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202855);
    Object localObject1 = this.shk;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject1 = ((a.b)localObject1).rTF.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = this.shl;
      if (localObject2 == null) {
        d.g.b.p.bcb("feedLoader");
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.p.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(202855);
  }
  
  public final int getLayoutId()
  {
    return 2131496250;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202850);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (com.tencent.mm.bx.a)new aoj();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      this.rXP = ((aoj)localObject1);
      if (this.rXP == null)
      {
        ad.i(this.TAG, "req is null, finish");
        finish();
        this.rXP = new aoj();
      }
      this.shj = new z.a((MMActivity)this, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.shj;
      if (localObject3 == null) {
        d.g.b.p.bcb("presenter");
      }
      this.shk = new z.b((MMActivity)localObject1, (z.a)localObject3, this.scene, cAZ());
      localObject1 = this.rXP;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      int i = ((aoj)localObject1).duh;
      int j = cAZ();
      localObject1 = this.rXP;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      float f1 = ((aoj)localObject1).dAp;
      localObject1 = this.rXP;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      float f2 = ((aoj)localObject1).dyz;
      localObject1 = this.rXP;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = ((aoj)localObject1).rJv;
      d.g.b.p.g(localObject1, "req!!.sectionInfo");
      localObject3 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = new FinderRelatedLoader(i, j, f1, f2, (arg)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
      localObject3 = getIntent();
      d.g.b.p.g(localObject3, "intent");
      ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderRelatedLoader)localObject1).setInitDone((h)new a((FinderRelatedLoader)localObject1, this));
      ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.shl = ((FinderRelatedLoader)localObject1);
      AppMethodBeat.o(202850);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderRelatedLoader paramFinderRelatedLoader, FinderRelatedTimelineUI paramFinderRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202848);
      Object localObject = FinderRelatedTimelineUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202848);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.shm.getInitPos(), 0);
        AppMethodBeat.o(202848);
        return;
      }
      AppMethodBeat.o(202848);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
  {
    b(FinderRelatedTimelineUI paramFinderRelatedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */