package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.aa.a;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.z;
import com.tencent.mm.plugin.finder.feed.model.z.a;
import com.tencent.mm.plugin.finder.feed.model.z.a.a;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "presenter", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderRelatedFeedUI
  extends FinderBaseGridFeedUI<aa.b, aa.a>
{
  private dyz KNW;
  private aa.a KSM;
  private aa.b KSN;
  private dza KSO;
  private final String TAG = "Finder.FinderRelatedFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader qvo;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198548);
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
    AppMethodBeat.o(198548);
    return localView1;
  }
  
  public final int fTB()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 28;
  }
  
  public final int getLayoutId()
  {
    return 2131496248;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(198544);
    Object localObject1 = (com.tencent.mm.bx.a)new dyz();
    Object localObject4 = getIntent().getByteArrayExtra("SECTION_REQ");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
      this.KNW = ((dyz)localObject1);
      localObject1 = (com.tencent.mm.bx.a)new dza();
      localObject4 = getIntent().getByteArrayExtra("SECTION_FIRST_RSP");
    }
    catch (Exception localException1)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
        this.KSO = ((dza)localObject1);
        if ((this.KNW == null) || (this.KSO == null))
        {
          localObject1 = this.TAG;
          localObject4 = new StringBuilder("req is null? ");
          if (this.KNW == null)
          {
            bool1 = true;
            localObject4 = ((StringBuilder)localObject4).append(bool1).append(", rsp is null? ");
            if (this.KSO != null) {
              break label601;
            }
            bool1 = bool2;
            ad.i((String)localObject1, bool1 + ", finish");
            finish();
            this.KNW = new dyz();
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
          localObject1 = z.KQl;
          localObject1 = z.a.BM(l);
          localObject4 = (MMActivity)this;
          Object localObject5 = this.KNW;
          if (localObject5 == null) {
            k.fvU();
          }
          int i = ((dyz)localObject5).IoU;
          localObject5 = this.KNW;
          if (localObject5 == null) {
            k.fvU();
          }
          float f1 = ((dyz)localObject5).dqQ;
          localObject5 = this.KNW;
          if (localObject5 == null) {
            k.fvU();
          }
          float f2 = ((dyz)localObject5).dpb;
          localObject5 = this.KNW;
          if (localObject5 == null) {
            k.fvU();
          }
          localObject5 = ((dyz)localObject5).KJJ;
          k.g(localObject5, "req!!.sectionInfo");
          com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
          localObject5 = new z(i, 28, f1, f2, (dzq)localObject5, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
          ((z)localObject5).KPL = ((b)new a(this));
          this.qvo = ((BaseFinderFeedLoader)localObject5);
          localObject5 = this.qvo;
          if (localObject5 == null) {
            k.aPZ("feedLoader");
          }
          this.KSM = new aa.a((MMActivity)localObject4, (BaseFinderFeedLoader)localObject5, ((z.a.a)localObject1).lastBuffer, ((z.a.a)localObject1).dataList);
          localObject1 = (MMActivity)this;
          i = this.scene;
          localObject4 = this.KNW;
          if (localObject4 == null) {
            k.fvU();
          }
          this.KSN = new aa.b((MMActivity)localObject1, i, (dyz)localObject4, this.title);
          localObject1 = this.KSN;
          if (localObject1 == null) {
            k.aPZ("viewCallback");
          }
          localObject4 = this.KSM;
          if (localObject4 == null) {
            k.aPZ("presenter");
          }
          ((aa.b)localObject1).a((n.a)localObject4);
          AppMethodBeat.o(198544);
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
          label601:
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderRelatedFeedUI$getLoader$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI
 * JD-Core Version:    0.7.0.1
 */