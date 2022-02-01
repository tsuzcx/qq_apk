package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.feed.d.a;
import com.tencent.mm.plugin.finder.feed.d.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "setCommentPreloader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;)V", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<d.b, c>
{
  private String KZL;
  private boolean KZM;
  private boolean KZN;
  final String TAG;
  private HashMap _$_findViewCache;
  String dpv;
  long objectId;
  private String objectNonceId;
  int pOf;
  BaseFinderFeed qHv;
  private d.b qNT;
  private c qQg;
  private boolean qQh;
  private View qQi;
  private View qQj;
  com.tencent.mm.plugin.finder.feed.model.e qvy;
  private int scene;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.KZL = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.dpv = "";
    this.qvy = new com.tencent.mm.plugin.finder.feed.model.e((MMActivity)this);
    this.qQh = ((j)g.ad(j.class)).showFinderEntry();
    this.KZM = true;
    AppMethodBeat.o(167676);
  }
  
  private c fVF()
  {
    AppMethodBeat.i(199442);
    c localc = this.qQg;
    if (localc == null) {
      k.aPZ("presenter");
    }
    AppMethodBeat.o(199442);
    return localc;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199443);
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
    AppMethodBeat.o(199443);
    return localView1;
  }
  
  public final void cmB()
  {
    AppMethodBeat.i(167673);
    setMMTitle(2131759376);
    View localView = findViewById(2131304742);
    k.g(localView, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.qQj = localView;
    localView = this.qQj;
    if (localView == null) {
      k.aPZ("tipsLayout");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(167673);
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 25;
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.objectId = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.KZL = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.pOf = getIntent().getIntExtra("report_scene", 0);
    this.dpv = getIntent().getStringExtra("from_user");
    if ((this.objectId == 0L) && (bt.isNullOrNil(this.KZL)))
    {
      ad.w(this.TAG, "objectId " + this.objectId + ", encryptedObjectId " + this.KZL + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    if (!this.qQh)
    {
      bool1 = true;
      this.qQg = new c(i, (MMActivity)localObject1, bool1);
      localObject1 = (MMActivity)this;
      localObject2 = this.qQg;
      if (localObject2 == null) {
        k.aPZ("presenter");
      }
      localObject2 = (d.a)localObject2;
      i = this.scene;
      if (this.qQh) {
        break label417;
      }
    }
    label417:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qNT = new d.b((MMActivity)localObject1, (d.a)localObject2, i, 25, bool1);
      if (this.objectId != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
        localObject1 = com.tencent.mm.plugin.finder.storage.data.b.a.qC(this.objectId);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          this.qHv = com.tencent.mm.plugin.finder.storage.logic.b.a.h((FinderItem)localObject1);
          localObject1 = this.qQg;
          if (localObject1 == null) {
            k.aPZ("presenter");
          }
          localObject1 = ((d.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject2 = this.qHv;
            if (localObject2 == null) {
              k.fvU();
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      if (this.pOf != 0) {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1278L, 14L, 1L, false);
      }
      this.qvy.a(this.scene, 25, null);
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178446);
    if ((this.pOf != 0) && (!this.KZN))
    {
      Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      long l = this.objectId;
      int i = this.pOf;
      String str = this.dpv;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.b.a(l, i, (String)localObject, 0);
      this.KZN = true;
    }
    this.qvy.onDetach();
    fVF().onDetach();
    super.onDestroy();
    AppMethodBeat.o(178446);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    long l = this.objectId;
    String str1 = this.objectNonceId;
    String str2 = this.KZL;
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).fXs();; localObject = null)
    {
      new h(l, str1, 25, 2, "", true, null, null, 0L, null, false, false, str2, (dzp)localObject, 4032).auK().b((com.tencent.mm.vending.c.a)new a(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI) {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
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
        Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.fQ(paramView, "Enter");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_context_id", paramView);
        paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.qQn.qQk, (Intent)localObject, 1);
        AppMethodBeat.o(167669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */