package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.aq.a;
import com.tencent.mm.plugin.finder.feed.aq.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderRelatedLoader, aq.b, aq.a>
{
  private bav AYw;
  private aq.a Brt;
  private aq.b Bru;
  private FinderRelatedLoader Brv;
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private final int scene = 2;
  private String title = "";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365220);
    Object localObject2 = this.Bru;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    RecyclerView.LayoutManager localLayoutManager = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      localObject1 = av.GiL;
      localObject2 = this.Brv;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        localObject1 = null;
      }
      setResult(-1, av.a((BaseFinderFeedLoader)localObject1, (LinearLayoutManager)localLayoutManager));
    }
    super.finish();
    AppMethodBeat.o(365220);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(365206);
    switch (getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0))
    {
    default: 
      AppMethodBeat.o(365206);
      return 0;
    case 2: 
      AppMethodBeat.o(365206);
      return 29;
    }
    AppMethodBeat.o(365206);
    return 31;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject3 = null;
    AppMethodBeat.i(365193);
    Object localObject4 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (a)new bav();
    localObject4 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject4);
      this.AYw = ((bav)localObject1);
      if (this.AYw == null)
      {
        Log.i(this.TAG, "req is null, finish");
        finish();
        this.AYw = new bav();
      }
      this.Brt = new aq.a((MMActivity)this, this.scene);
      localObject4 = (MMActivity)this;
      localObject1 = this.Brt;
      if (localObject1 == null)
      {
        s.bIx("presenter");
        localObject1 = localObject3;
        this.Bru = new aq.b((MMActivity)localObject4, (aq.a)localObject1, this.scene, getCommentScene());
        localObject1 = this.AYw;
        s.checkNotNull(localObject1);
        int i = ((bav)localObject1).hJx;
        int j = getCommentScene();
        localObject1 = this.AYw;
        s.checkNotNull(localObject1);
        float f1 = ((bav)localObject1).longitude;
        localObject1 = this.AYw;
        s.checkNotNull(localObject1);
        float f2 = ((bav)localObject1).latitude;
        localObject1 = this.AYw;
        s.checkNotNull(localObject1);
        localObject3 = ((bav)localObject1).ACr;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new bve();
        }
        localObject3 = k.aeZF;
        localObject1 = new FinderRelatedLoader(i, j, f1, f2, (bve)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
        localObject3 = getIntent();
        s.s(localObject3, "intent");
        ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject3);
        ((FinderRelatedLoader)localObject1).setInitDone((j)new a(this, (FinderRelatedLoader)localObject1));
        ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
        localObject3 = ah.aiuX;
        this.Brv = ((FinderRelatedLoader)localObject1);
        AppMethodBeat.o(365193);
        return;
      }
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderRelatedTimelineUI paramFinderRelatedTimelineUI, FinderRelatedLoader paramFinderRelatedLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364835);
      Object localObject2 = FinderRelatedTimelineUI.a(this.Brw);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.Brx;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderRelatedLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(364835);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<IResponse<cc>, ah>
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