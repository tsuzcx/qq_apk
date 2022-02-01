package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.af.a;
import com.tencent.mm.plugin.finder.feed.af.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiTimelineUIContract$Presenter;", "()V", "emptyView", "Landroid/view/View;", "feedLoader", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"})
public final class FinderPoiTimelineUI
  extends FinderLoaderFeedUI<FinderPoiTimelineLoader, af.b, af.a>
{
  public static final a xRo;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private View sxR;
  private af.a xRl;
  private af.b xRm;
  private FinderPoiTimelineLoader xRn;
  
  static
  {
    AppMethodBeat.i(285522);
    xRo = new a((byte)0);
    AppMethodBeat.o(285522);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285526);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285526);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285525);
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
    AppMethodBeat.o(285525);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 96;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_poi_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(285518);
    setMMTitle("");
    Object localObject1 = findViewById(b.f.empty_view);
    p.j(localObject1, "findViewById(R.id.empty_view)");
    this.sxR = ((View)localObject1);
    this.xRl = new af.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject3 = this.xRl;
    if (localObject3 == null) {
      p.bGy("presenter");
    }
    this.xRm = new af.b((MMActivity)localObject1, (af.a)localObject3, this.scene);
    localObject1 = g.Xox;
    FinderPoiTimelineLoader localFinderPoiTimelineLoader = new FinderPoiTimelineLoader(((aj)g.b((AppCompatActivity)this).i(aj.class)).ekY());
    localObject1 = (a)new eka();
    localObject3 = getIntent().getByteArrayExtra("key_location");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localFinderPoiTimelineLoader.xIr = ((eka)localObject1);
      localObject3 = getIntent().getSerializableExtra("key_from_type");
      localObject1 = localObject3;
      if (!(localObject3 instanceof y.a)) {
        localObject1 = null;
      }
      localFinderPoiTimelineLoader.xIs = ((y.a)localObject1);
      if (getIntent().hasExtra("key_from_scene")) {
        localFinderPoiTimelineLoader.xIt = Integer.valueOf(getIntent().getIntExtra("key_from_scene", 0));
      }
      localObject1 = getIntent();
      p.j(localObject1, "intent");
      localFinderPoiTimelineLoader.initFromCache((Intent)localObject1);
      localObject1 = localFinderPoiTimelineLoader.getCache();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
        if (localObject1 != null)
        {
          if (((Collection)localObject1).isEmpty()) {
            break label404;
          }
          i = 1;
          if (i == 1)
          {
            localObject1 = localFinderPoiTimelineLoader.getCache();
            if (localObject1 == null) {
              break label409;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
            if (localObject1 == null) {
              break label409;
            }
            localObject1 = (bu)((ArrayList)localObject1).get(0);
            localObject3 = localObject1;
            if (!(localObject1 instanceof BaseFinderFeed)) {
              localObject3 = null;
            }
            localObject1 = (BaseFinderFeed)localObject3;
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject();
              localObject3 = n.zWF;
              n.a((FinderObject)localObject1, 96);
            }
          }
        }
      }
      localFinderPoiTimelineLoader.setInitDone((j)new b(localFinderPoiTimelineLoader, this));
      localFinderPoiTimelineLoader.fetchEndCallback = ((b)new c(localFinderPoiTimelineLoader, this));
      this.xRn = localFinderPoiTimelineLoader;
      AppMethodBeat.o(285518);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        label404:
        int i = 0;
        continue;
        label409:
        localObject2 = null;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI$initOnCreate$1$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderPoiTimelineLoader paramFinderPoiTimelineLoader, FinderPoiTimelineUI paramFinderPoiTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(287168);
      Object localObject = FinderPoiTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(287168);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xRp.getInitPos(), 0);
        AppMethodBeat.o(287168);
        return;
      }
      AppMethodBeat.o(287168);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderPoiTimelineUI$initOnCreate$1$3"})
  static final class c
    extends kotlin.g.b.q
    implements b<IResponse<bu>, x>
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