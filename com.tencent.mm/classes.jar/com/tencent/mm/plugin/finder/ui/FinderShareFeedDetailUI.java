package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "setCommentPreloader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;)V", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<i.b, l>
{
  final String TAG;
  private HashMap _$_findViewCache;
  String dng;
  private String objectNonceId;
  long qXP;
  int qwN;
  private i.b rJp;
  private l rLK;
  private String rLL;
  private boolean rLM;
  private View rLN;
  private View rLO;
  private boolean rLP;
  private boolean rLQ;
  BaseFinderFeed rdD;
  c rfE;
  private int scene;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.rLL = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.dng = "";
    this.rfE = new c((MMActivity)this);
    this.rLM = ((com.tencent.mm.plugin.i.a.l)g.ad(com.tencent.mm.plugin.i.a.l.class)).showFinderEntry();
    this.rLP = true;
    AppMethodBeat.o(167676);
  }
  
  private l cCm()
  {
    AppMethodBeat.i(203418);
    l locall = this.rLK;
    if (locall == null) {
      k.aVY("presenter");
    }
    AppMethodBeat.o(203418);
    return locall;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203419);
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
    AppMethodBeat.o(203419);
    return localView1;
  }
  
  public final int cuI()
  {
    return 25;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final void cvL()
  {
    AppMethodBeat.i(167673);
    setMMTitle(2131759376);
    View localView = findViewById(2131304742);
    k.g(localView, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.rLO = localView;
    localView = this.rLO;
    if (localView == null) {
      k.aVY("tipsLayout");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(167673);
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.qXP = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.rLL = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.qwN = getIntent().getIntExtra("report_scene", 0);
    this.dng = getIntent().getStringExtra("from_user");
    if ((this.qXP == 0L) && (bs.isNullOrNil(this.rLL)))
    {
      ac.w(this.TAG, "objectId " + this.qXP + ", encryptedObjectId " + this.rLL + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    if (!this.rLM)
    {
      bool1 = true;
      this.rLK = new l(i, (MMActivity)localObject1, bool1);
      localObject1 = (MMActivity)this;
      localObject2 = this.rLK;
      if (localObject2 == null) {
        k.aVY("presenter");
      }
      localObject2 = (i.a)localObject2;
      i = this.scene;
      if (this.rLM) {
        break label417;
      }
    }
    label417:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.rJp = new i.b((MMActivity)localObject1, (i.a)localObject2, i, 25, bool1);
      if (this.qXP != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
        localObject1 = d.a.uS(this.qXP);
        if (localObject1 != null)
        {
          localObject2 = b.rFl;
          this.rdD = b.a.i((FinderItem)localObject1);
          localObject1 = this.rLK;
          if (localObject1 == null) {
            k.aVY("presenter");
          }
          localObject1 = ((i.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject2 = this.rdD;
            if (localObject2 == null) {
              k.fOy();
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      if (this.qwN != 0) {
        e.wTc.idkeyStat(1278L, 14L, 1L, false);
      }
      this.rfE.a(this.scene, 25, null);
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178446);
    if ((this.qwN != 0) && (!this.rLQ))
    {
      Object localObject = com.tencent.mm.plugin.finder.report.d.rxr;
      long l = this.qXP;
      int i = this.qwN;
      String str = this.dng;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.d.a(l, i, (String)localObject, 0);
      this.rLQ = true;
    }
    this.rfE.onDetach();
    cCm().onDetach();
    super.onDestroy();
    AppMethodBeat.o(178446);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    long l = this.qXP;
    String str1 = this.objectNonceId;
    String str2 = this.rLL;
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cGb();; localObject = null)
    {
      new m(l, str1, 25, 2, "", true, null, null, 0L, null, false, false, str2, (anm)localObject, 4032).aBB().b((com.tencent.mm.vending.c.a)new a(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI) {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
    static final class a
      implements View.OnClickListener
    {
      a(BaseFinderFeed paramBaseFinderFeed, FinderObject paramFinderObject, FinderShareFeedDetailUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(167669);
        ((PluginFinder)g.ad(PluginFinder.class)).resetLastTimelineExitTime();
        paramView = UUID.randomUUID().toString();
        k.g(paramView, "UUID.randomUUID().toString()");
        Object localObject = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.ge(paramView, "Enter");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_context_id", paramView);
        paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.rLU.rLR, (Intent)localObject, 1);
        AppMethodBeat.o(167669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */