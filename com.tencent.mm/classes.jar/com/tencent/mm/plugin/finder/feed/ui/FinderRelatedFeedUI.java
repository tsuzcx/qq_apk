package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.l.a;
import com.tencent.mm.plugin.finder.feed.model.l.a.a;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<u.b, u.a>
{
  private final String TAG = "Finder.FinderRelatedFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rgh;
  private ale rjx;
  private u.a rrY;
  private u.b rrZ;
  private alf rsa;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202468);
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
    AppMethodBeat.o(202468);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(202465);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(202465);
      return 28;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202465);
      return 30;
    }
    AppMethodBeat.o(202465);
    return 0;
  }
  
  public final int cvJ()
  {
    AppMethodBeat.i(202466);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if ((i == 2) || (i == 1))
    {
      AppMethodBeat.o(202466);
      return 3;
    }
    AppMethodBeat.o(202466);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return 2131496249;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(202462);
    Object localObject1 = (com.tencent.mm.bw.a)new ale();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      this.rjx = ((ale)localObject1);
      localObject1 = (com.tencent.mm.bw.a)new alf();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
        this.rsa = ((alf)localObject1);
        if ((this.rjx == null) || (this.rsa == null))
        {
          localObject1 = this.TAG;
          localObject4 = new StringBuilder("req is null? ");
          if (this.rjx == null)
          {
            bool1 = true;
            localObject4 = ((StringBuilder)localObject4).append(bool1).append(", rsp is null? ");
            if (this.rsa != null) {
              break label621;
            }
            bool1 = bool2;
            ac.i((String)localObject1, bool1 + ", finish");
            finish();
            this.rjx = new ale();
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
          long l = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
          localObject1 = com.tencent.mm.plugin.finder.feed.model.l.rng;
          localObject1 = l.a.uo(l);
          localObject4 = (MMActivity)this;
          cuI();
          Object localObject5 = this.rjx;
          if (localObject5 == null) {
            k.fOy();
          }
          int i = ((ale)localObject5).diw;
          int j = cuI();
          localObject5 = this.rjx;
          if (localObject5 == null) {
            k.fOy();
          }
          float f1 = ((ale)localObject5).doB;
          localObject5 = this.rjx;
          if (localObject5 == null) {
            k.fOy();
          }
          float f2 = ((ale)localObject5).dmL;
          localObject5 = this.rjx;
          if (localObject5 == null) {
            k.fOy();
          }
          localObject5 = ((ale)localObject5).qYj;
          k.g(localObject5, "req!!.sectionInfo");
          com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
          localObject5 = new com.tencent.mm.plugin.finder.feed.model.l(i, j, f1, f2, (anu)localObject5, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
          ((com.tencent.mm.plugin.finder.feed.model.l)localObject5).rmE = ((b)new a(this));
          this.rgh = ((BaseFinderFeedLoader)localObject5);
          localObject5 = this.rgh;
          if (localObject5 == null) {
            k.aVY("feedLoader");
          }
          this.rrY = new u.a((MMActivity)localObject4, (BaseFinderFeedLoader)localObject5, ((l.a.a)localObject1).lastBuffer, ((l.a.a)localObject1).dataList);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = cuI();
          localObject4 = this.rjx;
          if (localObject4 == null) {
            k.fOy();
          }
          this.rrZ = new u.b((MMActivity)localObject1, i, j, (ale)localObject4, this.title);
          localObject1 = this.rrZ;
          if (localObject1 == null) {
            k.aVY("viewCallback");
          }
          localObject4 = this.rrY;
          if (localObject4 == null) {
            k.aVY("presenter");
          }
          ((u.b)localObject1).a((c.a)localObject4);
          AppMethodBeat.o(202462);
          return;
          localException1 = localException1;
          ac.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
          continue;
          boolean bool1 = false;
          continue;
          label621:
          bool1 = false;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderRelatedFeedUI paramFinderRelatedFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI
 * JD-Core Version:    0.7.0.1
 */