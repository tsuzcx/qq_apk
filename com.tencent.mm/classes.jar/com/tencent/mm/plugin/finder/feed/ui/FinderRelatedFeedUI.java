package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.y.a;
import com.tencent.mm.plugin.finder.feed.y.b;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<y.b, y.a>
{
  public static final a shh;
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rTS;
  private aoj rXP;
  private final int scene = 2;
  private y.a she;
  private y.b shf;
  private aok shg;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(202845);
    shh = new a((byte)0);
    AppMethodBeat.o(202845);
  }
  
  private y.a cCt()
  {
    AppMethodBeat.i(202839);
    y.a locala = this.she;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    AppMethodBeat.o(202839);
    return locala;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202847);
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
    AppMethodBeat.o(202847);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(202842);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(202842);
      return 28;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202842);
      return 30;
    }
    AppMethodBeat.o(202842);
    return 0;
  }
  
  public final int cBZ()
  {
    AppMethodBeat.i(202843);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if ((i == 2) || (i == 1))
    {
      AppMethodBeat.o(202843);
      return 3;
    }
    AppMethodBeat.o(202843);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return 2131496249;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(202838);
    Object localObject1 = (com.tencent.mm.bx.a)new aoj();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
      this.rXP = ((aoj)localObject1);
      localObject1 = (com.tencent.mm.bx.a)new aok();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
        this.shg = ((aok)localObject1);
        if ((this.rXP == null) || (this.shg == null))
        {
          localObject1 = new StringBuilder("req is null? ");
          if (this.rXP == null)
          {
            bool1 = true;
            localObject1 = ((StringBuilder)localObject1).append(bool1).append(", rsp is null? ");
            if (this.shg != null) {
              break label602;
            }
            bool1 = bool2;
            ad.i("Finder.FinderRelatedFeedUI", bool1 + ", finish");
            finish();
            this.rXP = new aoj();
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
          localObject4 = com.tencent.mm.ui.component.a.KiD;
          localObject1 = new FinderRelatedLoader(i, j, f1, f2, (arg)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
          localObject4 = getIntent();
          d.g.b.p.g(localObject4, "intent");
          ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject4);
          ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
          this.rTS = ((BaseFinderFeedLoader)localObject1);
          localObject1 = (MMActivity)this;
          cAZ();
          localObject4 = this.rTS;
          if (localObject4 == null) {
            d.g.b.p.bcb("feedLoader");
          }
          this.she = new y.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject4);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = cAZ();
          localObject4 = this.rXP;
          if (localObject4 == null) {
            d.g.b.p.gfZ();
          }
          this.shf = new y.b((MMActivity)localObject1, i, j, (aoj)localObject4, this.title);
          localObject1 = this.shf;
          if (localObject1 == null) {
            d.g.b.p.bcb("viewCallback");
          }
          localObject4 = this.she;
          if (localObject4 == null) {
            d.g.b.p.bcb("presenter");
          }
          ((y.b)localObject1).a((b.a)localObject4);
          AppMethodBeat.o(202838);
          return;
          localException1 = localException1;
          ad.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
          continue;
          boolean bool1 = false;
          continue;
          label602:
          bool1 = false;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(202844);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      y.a locala = cCt();
      d.g.b.p.h(paramIntent, "data");
      Object localObject = locala.rTQ;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).rTF.getRecyclerView();
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a(paramIntent, (RecyclerView)localObject, locala.rTS);
          AppMethodBeat.o(202844);
          return;
        }
      }
      AppMethodBeat.o(202844);
      return;
    }
    AppMethodBeat.o(202844);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$initOnCreate$1$1"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
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