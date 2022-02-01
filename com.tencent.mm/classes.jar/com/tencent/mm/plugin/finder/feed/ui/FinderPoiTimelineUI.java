package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.al.a;
import com.tencent.mm.plugin.finder.feed.al.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$Presenter;", "()V", "emptyView", "Landroid/view/View;", "feedLoader", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiTimelineUI
  extends FinderLoaderFeedUI<FinderPoiTimelineLoader, al.b, al.a>
{
  public static final a BqK;
  private al.a BqL;
  private al.b BqM;
  private FinderPoiTimelineLoader BqN;
  private final int scene = 2;
  private View vDA;
  
  static
  {
    AppMethodBeat.i(365239);
    BqK = new a((byte)0);
    AppMethodBeat.o(365239);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 96;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(365254);
    setMMTitle("");
    Object localObject1 = findViewById(e.e.empty_view);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.empty_view)");
    this.vDA = ((View)localObject1);
    this.BqL = new al.a((MMActivity)this, this.scene);
    Object localObject4 = (MMActivity)this;
    Object localObject3 = this.BqL;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    this.BqM = new al.b((MMActivity)localObject4, (al.a)localObject1, this.scene);
    localObject1 = k.aeZF;
    localObject3 = new FinderPoiTimelineLoader(((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    localObject1 = (a)new fei();
    localObject4 = getIntent().getByteArrayExtra("key_location");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject4);
      ((FinderPoiTimelineLoader)localObject3).BhH = ((fei)localObject1);
      localObject1 = getIntent().getSerializableExtra("key_from_type");
      if ((localObject1 instanceof bi.a))
      {
        localObject1 = (bi.a)localObject1;
        ((FinderPoiTimelineLoader)localObject3).BhJ = ((bi.a)localObject1);
        if (getIntent().hasExtra("key_from_scene")) {
          ((FinderPoiTimelineLoader)localObject3).BhK = Integer.valueOf(getIntent().getIntExtra("key_from_scene", 0));
        }
        localObject1 = getIntent();
        kotlin.g.b.s.s(localObject1, "intent");
        ((FinderPoiTimelineLoader)localObject3).initFromCache((Intent)localObject1);
        localObject1 = ((FinderPoiTimelineLoader)localObject3).getCache();
        if (localObject1 == null) {
          break label398;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        if (localObject1 == null) {
          break label398;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label393;
        }
        i = 1;
        if (i != 1) {
          break label398;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = ((FinderPoiTimelineLoader)localObject3).getCache();
          if (localObject1 != null) {
            break label403;
          }
          localObject1 = null;
          if (!(localObject1 instanceof BaseFinderFeed)) {
            break label429;
          }
          localObject1 = (BaseFinderFeed)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject();
            localObject4 = z.FrZ;
            z.a((FinderObject)localObject1, 96);
          }
        }
        ((FinderPoiTimelineLoader)localObject3).setInitDone((j)new b(this, (FinderPoiTimelineLoader)localObject3));
        ((FinderPoiTimelineLoader)localObject3).fetchEndCallback = ((b)new c((FinderPoiTimelineLoader)localObject3, this));
        localObject1 = ah.aiuX;
        this.BqN = ((FinderPoiTimelineLoader)localObject3);
        AppMethodBeat.o(365254);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        label393:
        int i = 0;
        continue;
        label398:
        i = 0;
        continue;
        label403:
        localObject2 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject2).pUj;
        if (localObject2 == null)
        {
          localObject2 = null;
        }
        else
        {
          localObject2 = (cc)((ArrayList)localObject2).get(0);
          continue;
          label429:
          localObject2 = null;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI$initOnCreate$1$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(FinderPoiTimelineUI paramFinderPoiTimelineUI, FinderPoiTimelineLoader paramFinderPoiTimelineLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365041);
      Object localObject2 = FinderPoiTimelineUI.a(this.BqO);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.BqP;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderPoiTimelineLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(365041);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<IResponse<cc>, ah>
  {
    c(FinderPoiTimelineLoader paramFinderPoiTimelineLoader, FinderPoiTimelineUI paramFinderPoiTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiTimelineUI
 * JD-Core Version:    0.7.0.1
 */