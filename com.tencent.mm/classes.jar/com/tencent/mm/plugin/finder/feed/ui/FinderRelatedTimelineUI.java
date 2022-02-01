package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ad.a;
import com.tencent.mm.plugin.finder.feed.ad.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderRelatedLoader, ad.b, ad.a>
{
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private ato tQh;
  private String title = "";
  private ad.a ucH;
  private ad.b ucI;
  private FinderRelatedLoader ucJ;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245515);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245515);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245514);
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
    AppMethodBeat.o(245514);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245512);
    Object localObject1 = this.ucI;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((b.b)localObject1).tLS.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = y.vXH;
      localObject2 = this.ucJ;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      setResult(-1, y.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(245512);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245511);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(245511);
      return 29;
    }
    if (i == 1)
    {
      AppMethodBeat.o(245511);
      return 31;
    }
    AppMethodBeat.o(245511);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return 2131494607;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245507);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (com.tencent.mm.bw.a)new ato();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      this.tQh = ((ato)localObject1);
      if (this.tQh == null)
      {
        Log.i(this.TAG, "req is null, finish");
        finish();
        this.tQh = new ato();
      }
      this.ucH = new ad.a((MMActivity)this, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.ucH;
      if (localObject3 == null) {
        p.btv("presenter");
      }
      this.ucI = new ad.b((MMActivity)localObject1, (ad.a)localObject3, this.scene, getCommentScene());
      localObject1 = this.tQh;
      if (localObject1 == null) {
        p.hyc();
      }
      int i = ((ato)localObject1).dLS;
      int j = getCommentScene();
      localObject1 = this.tQh;
      if (localObject1 == null) {
        p.hyc();
      }
      float f1 = ((ato)localObject1).dTj;
      localObject1 = this.tQh;
      if (localObject1 == null) {
        p.hyc();
      }
      float f2 = ((ato)localObject1).latitude;
      localObject1 = this.tQh;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject3 = ((ato)localObject1).tvs;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new bcc();
      }
      localObject3 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = new FinderRelatedLoader(i, j, f1, f2, (bcc)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
      localObject3 = getIntent();
      p.g(localObject3, "intent");
      ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderRelatedLoader)localObject1).setInitDone((h)new a((FinderRelatedLoader)localObject1, this));
      ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.ucJ = ((FinderRelatedLoader)localObject1);
      AppMethodBeat.o(245507);
      return;
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderRelatedLoader paramFinderRelatedLoader, FinderRelatedTimelineUI paramFinderRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245505);
      Object localObject = FinderRelatedTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245505);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.ucK.getInitPos(), 0);
        AppMethodBeat.o(245505);
        return;
      }
      AppMethodBeat.o(245505);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<bo>, x>
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