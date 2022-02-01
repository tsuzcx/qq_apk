package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.feed.aj.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderRelatedLoader, aj.b, aj.a>
{
  private final String TAG = "Finder.FinderRelatedTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private String title = "";
  private avr xAX;
  private aj.a xRX;
  private aj.b xRY;
  private FinderRelatedLoader xRZ;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285762);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285762);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285761);
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
    AppMethodBeat.o(285761);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(285759);
    Object localObject1 = this.xRY;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((b.b)localObject1).xvJ.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject2 = this.xRZ;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.aj.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(285759);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(285758);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(285758);
      return 29;
    }
    if (i == 1)
    {
      AppMethodBeat.o(285758);
      return 31;
    }
    AppMethodBeat.o(285758);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(285754);
    Object localObject3 = getIntent().getStringExtra("KEY_TITLE");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (a)new avr();
    localObject3 = getIntent().getByteArrayExtra("KEY_REQUEST_PB");
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      this.xAX = ((avr)localObject1);
      if (this.xAX == null)
      {
        Log.i(this.TAG, "req is null, finish");
        finish();
        this.xAX = new avr();
      }
      this.xRX = new aj.a((MMActivity)this, this.scene);
      localObject1 = (MMActivity)this;
      localObject3 = this.xRX;
      if (localObject3 == null) {
        p.bGy("presenter");
      }
      this.xRY = new aj.b((MMActivity)localObject1, (aj.a)localObject3, this.scene, getCommentScene());
      localObject1 = this.xAX;
      if (localObject1 == null) {
        p.iCn();
      }
      int i = ((avr)localObject1).fEH;
      int j = getCommentScene();
      localObject1 = this.xAX;
      if (localObject1 == null) {
        p.iCn();
      }
      float f1 = ((avr)localObject1).longitude;
      localObject1 = this.xAX;
      if (localObject1 == null) {
        p.iCn();
      }
      float f2 = ((avr)localObject1).latitude;
      localObject1 = this.xAX;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject3 = ((avr)localObject1).xcZ;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new biv();
      }
      localObject3 = g.Xox;
      localObject1 = new FinderRelatedLoader(i, j, f1, f2, (biv)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
      localObject3 = getIntent();
      p.j(localObject3, "intent");
      ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderRelatedLoader)localObject1).setInitDone((j)new a((FinderRelatedLoader)localObject1, this));
      ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.xRZ = ((FinderRelatedLoader)localObject1);
      AppMethodBeat.o(285754);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderRelatedLoader paramFinderRelatedLoader, FinderRelatedTimelineUI paramFinderRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(289168);
      Object localObject = FinderRelatedTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(289168);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xSa.getInitPos(), 0);
        AppMethodBeat.o(289168);
        return;
      }
      AppMethodBeat.o(289168);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<bu>, x>
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