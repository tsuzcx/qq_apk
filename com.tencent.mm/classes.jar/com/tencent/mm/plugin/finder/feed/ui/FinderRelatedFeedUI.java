package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<ac.b, ac.a>
{
  public static final a ucF;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  public BaseFinderFeedLoader tFM;
  private ato tQh;
  private String title = "";
  private ac.a ucC;
  private ac.b ucD;
  private atp ucE;
  
  static
  {
    AppMethodBeat.i(245501);
    ucF = new a((byte)0);
    AppMethodBeat.o(245501);
  }
  
  private ac.a deq()
  {
    AppMethodBeat.i(245495);
    ac.a locala = this.ucC;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(245495);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245504);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245504);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245503);
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
    AppMethodBeat.o(245503);
    return localView1;
  }
  
  public final int ddN()
  {
    AppMethodBeat.i(245499);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if ((i == 2) || (i == 1))
    {
      AppMethodBeat.o(245499);
      return 3;
    }
    AppMethodBeat.o(245499);
    return 0;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245498);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(245498);
      return 28;
    }
    if (i == 1)
    {
      AppMethodBeat.o(245498);
      return 30;
    }
    AppMethodBeat.o(245498);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return 2131494606;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(245494);
    Object localObject1 = (com.tencent.mm.bw.a)new ato();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      this.tQh = ((ato)localObject1);
      localObject1 = (com.tencent.mm.bw.a)new atp();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
        this.ucE = ((atp)localObject1);
        if ((this.tQh == null) || (this.ucE == null))
        {
          localObject1 = new StringBuilder("req is null? ");
          if (this.tQh == null)
          {
            bool1 = true;
            localObject1 = ((StringBuilder)localObject1).append(bool1).append(", rsp is null? ");
            if (this.ucE != null) {
              break label612;
            }
            bool1 = bool2;
            Log.i("Finder.FinderRelatedFeedUI", bool1 + ", finish");
            finish();
            this.tQh = new ato();
          }
        }
        else
        {
          localObject4 = getIntent().getStringExtra("UI_TITLE");
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
          this.title = ((String)localObject1);
          setMMTitle(this.title);
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
          localObject4 = ((ato)localObject1).tvs;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new bcc();
          }
          localObject4 = com.tencent.mm.ui.component.a.PRN;
          localObject1 = new FinderRelatedLoader(i, j, f1, f2, (bcc)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
          localObject4 = getIntent();
          p.g(localObject4, "intent");
          ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject4);
          ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
          this.tFM = ((BaseFinderFeedLoader)localObject1);
          localObject1 = (MMActivity)this;
          getCommentScene();
          localObject4 = this.tFM;
          if (localObject4 == null) {
            p.btv("feedLoader");
          }
          this.ucC = new ac.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject4);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = getCommentScene();
          localObject4 = this.tQh;
          if (localObject4 == null) {
            p.hyc();
          }
          this.ucD = new ac.b((MMActivity)localObject1, i, j, (ato)localObject4, this.title);
          localObject1 = this.ucD;
          if (localObject1 == null) {
            p.btv("viewCallback");
          }
          localObject4 = this.ucC;
          if (localObject4 == null) {
            p.btv("presenter");
          }
          ((ac.b)localObject1).a((c.a)localObject4);
          AppMethodBeat.o(245494);
          return;
          localException1 = localException1;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
          continue;
          boolean bool1 = false;
          continue;
          label612:
          bool1 = false;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245500);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      ac.a locala = deq();
      p.h(paramIntent, "data");
      Object localObject = locala.tMd;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).tLS.getRecyclerView();
        if (localObject != null)
        {
          y localy = y.vXH;
          y.a(paramIntent, (RecyclerView)localObject, (BaseFeedLoader)locala.tFM);
          AppMethodBeat.o(245500);
          return;
        }
      }
      AppMethodBeat.o(245500);
      return;
    }
    AppMethodBeat.o(245500);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$initOnCreate$1$1"})
  static final class b
    extends q
    implements b<IResponse<bo>, x>
  {
    b(FinderRelatedFeedUI paramFinderRelatedFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI
 * JD-Core Version:    0.7.0.1
 */