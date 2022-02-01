package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "showJumpEntry", "getShowJumpEntry", "setShowJumpEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<j.b, e>
{
  final String TAG;
  private HashMap _$_findViewCache;
  String dzZ;
  com.tencent.mm.bw.b likeBuffer;
  private String objectNonceId;
  long rRn;
  BaseFinderFeed rZB;
  int roH;
  private j.b sPn;
  private e sSi;
  boolean sSj;
  private boolean sSk;
  private View sSl;
  private View sSm;
  private boolean sSn;
  private boolean sSo;
  private int scene;
  private String sef;
  private final d.f shW;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.sef = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.dzZ = "";
    this.shW = d.g.O((d.g.a.a)new a(this));
    this.sSj = true;
    this.sSk = ((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry();
    this.sSn = true;
    AppMethodBeat.o(167676);
  }
  
  private e cMW()
  {
    AppMethodBeat.i(204797);
    e locale = this.sSi;
    if (locale == null) {
      p.bdF("presenter");
    }
    AppMethodBeat.o(204797);
    return locale;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204798);
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
    AppMethodBeat.o(204798);
    return localView1;
  }
  
  public final int cCL()
  {
    return 25;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final void cDN()
  {
    AppMethodBeat.i(167673);
    setMMTitle(2131759376);
    View localView = findViewById(2131304742);
    p.g(localView, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.sSm = localView;
    localView = this.sSm;
    if (localView == null) {
      p.bdF("tipsLayout");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(167673);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.d cDv()
  {
    AppMethodBeat.i(204796);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.shW.getValue();
    AppMethodBeat.o(204796);
    return locald;
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.rRn = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.sef = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.roH = getIntent().getIntExtra("report_scene", 0);
    this.dzZ = getIntent().getStringExtra("from_user");
    this.sSj = getIntent().getBooleanExtra("key_show_jump_entry", true);
    localObject1 = getIntent().getStringExtra("key_like_buffer");
    if ((localObject1 != null) && (!bu.isNullOrNil((String)localObject1))) {
      this.likeBuffer = com.tencent.mm.bw.b.cm(bu.aSx((String)localObject1));
    }
    if ((this.rRn == 0L) && (bu.isNullOrNil(this.sef)))
    {
      ae.w(this.TAG, "objectId " + this.rRn + ", encryptedObjectId " + this.sef + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    int j;
    if (!this.sSk)
    {
      bool1 = true;
      this.sSi = new e(i, (MMActivity)localObject1, bool1);
      localObject1 = (MMActivity)this;
      localObject2 = this.sSi;
      if (localObject2 == null) {
        p.bdF("presenter");
      }
      localObject2 = (j.a)localObject2;
      i = this.scene;
      j = cCL();
      if (this.sSk) {
        break label547;
      }
    }
    label547:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sPn = new j.b((MMActivity)localObject1, (j.a)localObject2, i, j, bool1);
      if (this.rRn != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
        localObject1 = d.a.xk(this.rRn);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          this.rZB = b.a.j((FinderItem)localObject1);
          localObject1 = this.sSi;
          if (localObject1 == null) {
            p.bdF("presenter");
          }
          localObject1 = ((j.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject2 = this.rZB;
            if (localObject2 == null) {
              p.gkB();
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      if (this.roH != 0) {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1278L, 14L, 1L, false);
      }
      cDv().a(this.scene, cCL(), (d.g.a.b)new b(this));
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = FinderReporterUIC.a.fc((Context)localObject1);
      if (localObject1 == null) {
        break label552;
      }
      localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
      if (localObject1 == null) {
        break label552;
      }
      ((c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)cDv());
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
    }
    label552:
    AppMethodBeat.o(167672);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178446);
    if ((this.roH != 0) && (!this.sSo))
    {
      localObject = i.syT;
      long l = this.rRn;
      int i = this.roH;
      String str = this.dzZ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      i.a(l, i, (String)localObject, 0);
      this.sSo = true;
    }
    cDv().onDetach();
    Object localObject = FinderReporterUIC.tnG;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fc((Context)localObject);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)cDv());
      }
    }
    cMW().onDetach();
    super.onDestroy();
    AppMethodBeat.o(178446);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    long l = this.rRn;
    String str1 = this.objectNonceId;
    int i = cCL();
    String str2 = this.sef;
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
    {
      new com.tencent.mm.plugin.finder.cgi.q(l, str1, i, 2, "", true, null, null, 0L, null, false, false, str2, (arn)localObject, 0, 20416).aET().b((com.tencent.mm.vending.c.a)new c(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    b(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(FinderShareFeedDetailUI paramFinderShareFeedDetailUI) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
    static final class a
      implements View.OnClickListener
    {
      a(BaseFinderFeed paramBaseFinderFeed, FinderObject paramFinderObject, FinderShareFeedDetailUI.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(167669);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).resetLastTimelineExitTime();
        paramView = UUID.randomUUID().toString();
        p.g(paramView, "UUID.randomUUID().toString()");
        localObject = i.syT;
        i.gs(paramView, "Enter");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_context_id", paramView);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.sSs.sSp, (Intent)localObject, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */