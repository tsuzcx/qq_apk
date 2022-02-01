package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<v.b, v.a>
{
  private final String TAG = "Finder.LbsStreamFeedUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private String title = "";
  private v.a xOp;
  private v.b xOq;
  public BaseFinderFeedLoader xnX;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(248903);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(248903);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(248902);
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
    AppMethodBeat.o(248902);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader dvj()
  {
    AppMethodBeat.i(248890);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(248890);
    return localBaseFinderFeedLoader;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(248897);
    d locald = d.AjH;
    if (((Number)d.dVg().aSr()).intValue() != 0)
    {
      AppMethodBeat.o(248897);
      return 43;
    }
    AppMethodBeat.o(248897);
    return 16;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_lbs_stream_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(248892);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = z.bdh();
    p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = g.Xox;
    localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((aj)g.b((AppCompatActivity)this).i(aj.class)).ekY());
    localObject2 = getIntent();
    p.j(localObject2, "intent");
    ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new a(this));
    this.xnX = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    getCommentScene();
    localObject2 = this.xnX;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.xOp = new v.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.xOq = new v.b((MMActivity)this, this.scene, getCommentScene(), this.title);
    localObject1 = this.xOq;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.xOp;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((v.b)localObject1).a((c.a)localObject2);
    AppMethodBeat.o(248892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    a(FinderLbsStreamFeedUI paramFinderLbsStreamFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamFeedUI
 * JD-Core Version:    0.7.0.1
 */