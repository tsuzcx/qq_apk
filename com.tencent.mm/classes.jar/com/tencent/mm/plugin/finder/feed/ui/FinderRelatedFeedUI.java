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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<y.b, y.a>
{
  public static final FinderRelatedFeedUI.a sqb;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  public BaseFinderFeedLoader scw;
  private aow sgA;
  private y.a spY;
  private y.b spZ;
  private aox sqa;
  private String title = "";
  
  static
  {
    AppMethodBeat.i(203324);
    sqb = new FinderRelatedFeedUI.a((byte)0);
    AppMethodBeat.o(203324);
  }
  
  private y.a cEf()
  {
    AppMethodBeat.i(203318);
    y.a locala = this.spY;
    if (locala == null) {
      d.g.b.p.bdF("presenter");
    }
    AppMethodBeat.o(203318);
    return locala;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203326);
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
    AppMethodBeat.o(203326);
    return localView1;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(203321);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if (i == 2)
    {
      AppMethodBeat.o(203321);
      return 28;
    }
    if (i == 1)
    {
      AppMethodBeat.o(203321);
      return 30;
    }
    AppMethodBeat.o(203321);
    return 0;
  }
  
  public final int cDL()
  {
    AppMethodBeat.i(203322);
    int i = getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0);
    if ((i == 2) || (i == 1))
    {
      AppMethodBeat.o(203322);
      return 3;
    }
    AppMethodBeat.o(203322);
    return 0;
  }
  
  public final int getLayoutId()
  {
    return 2131496249;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(203317);
    Object localObject1 = (com.tencent.mm.bw.a)new aow();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      this.sgA = ((aow)localObject1);
      localObject1 = (com.tencent.mm.bw.a)new aox();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
        this.sqa = ((aox)localObject1);
        if ((this.sgA == null) || (this.sqa == null))
        {
          localObject1 = new StringBuilder("req is null? ");
          if (this.sgA == null)
          {
            bool1 = true;
            localObject1 = ((StringBuilder)localObject1).append(bool1).append(", rsp is null? ");
            if (this.sqa != null) {
              break label612;
            }
            bool1 = bool2;
            ae.i("Finder.FinderRelatedFeedUI", bool1 + ", finish");
            finish();
            this.sgA = new aow();
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
          localObject1 = this.sgA;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          int i = ((aow)localObject1).dvm;
          int j = cCL();
          localObject1 = this.sgA;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          float f1 = ((aow)localObject1).dBu;
          localObject1 = this.sgA;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          float f2 = ((aow)localObject1).dzE;
          localObject1 = this.sgA;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localObject4 = ((aow)localObject1).rRJ;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new arv();
          }
          localObject4 = com.tencent.mm.ui.component.a.KEX;
          localObject1 = new FinderRelatedLoader(i, j, f1, f2, (arv)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
          localObject4 = getIntent();
          d.g.b.p.g(localObject4, "intent");
          ((FinderRelatedLoader)localObject1).initFromCache((Intent)localObject4);
          ((FinderRelatedLoader)localObject1).fetchEndCallback = ((b)new b(this));
          this.scw = ((BaseFinderFeedLoader)localObject1);
          localObject1 = (MMActivity)this;
          cCL();
          localObject4 = this.scw;
          if (localObject4 == null) {
            d.g.b.p.bdF("feedLoader");
          }
          this.spY = new y.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject4);
          localObject1 = (MMActivity)this;
          i = this.scene;
          j = cCL();
          localObject4 = this.sgA;
          if (localObject4 == null) {
            d.g.b.p.gkB();
          }
          this.spZ = new y.b((MMActivity)localObject1, i, j, (aow)localObject4, this.title);
          localObject1 = this.spZ;
          if (localObject1 == null) {
            d.g.b.p.bdF("viewCallback");
          }
          localObject4 = this.spY;
          if (localObject4 == null) {
            d.g.b.p.bdF("presenter");
          }
          ((y.b)localObject1).a((b.a)localObject4);
          AppMethodBeat.o(203317);
          return;
          localException1 = localException1;
          ae.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException2 });
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
    AppMethodBeat.i(203323);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      y.a locala = cEf();
      d.g.b.p.h(paramIntent, "data");
      Object localObject = locala.scu;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).scj.getRecyclerView();
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(paramIntent, (RecyclerView)localObject, locala.scw);
          AppMethodBeat.o(203323);
          return;
        }
      }
      AppMethodBeat.o(203323);
      return;
    }
    AppMethodBeat.o(203323);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$initOnCreate$1$1"})
  static final class b
    extends q
    implements b<IResponse<am>, z>
  {
    b(FinderRelatedFeedUI paramFinderRelatedFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI
 * JD-Core Version:    0.7.0.1
 */