package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "showJumpEntry", "getShowJumpEntry", "setShowJumpEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<k.b, i>
{
  final String TAG;
  private HashMap _$_findViewCache;
  String dRL;
  long hFK;
  com.tencent.mm.bw.b likeBuffer;
  private String objectNonceId;
  int sQn;
  private int scene;
  private String tNK;
  BaseFinderFeed tNO;
  private final kotlin.f tRX;
  private final kotlin.f tRY;
  private View uNf;
  private k.b vMw;
  private i vOE;
  boolean vOF;
  private boolean vOG;
  private View vOH;
  private boolean vOI;
  private boolean vOJ;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.tNK = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.dRL = "";
    this.tRX = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.tRY = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vOF = true;
    this.vOG = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    this.vOI = true;
    AppMethodBeat.o(167676);
  }
  
  private i dAg()
  {
    AppMethodBeat.i(252701);
    i locali = this.vOE;
    if (locali == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(252701);
    return locali;
  }
  
  private com.tencent.mm.plugin.finder.feed.model.f dcX()
  {
    AppMethodBeat.i(252700);
    com.tencent.mm.plugin.finder.feed.model.f localf = (com.tencent.mm.plugin.finder.feed.model.f)this.tRY.getValue();
    AppMethodBeat.o(252700);
    return localf;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252703);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252703);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252702);
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
    AppMethodBeat.o(252702);
    return localView1;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.d dcW()
  {
    AppMethodBeat.i(252699);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.tRX.getValue();
    AppMethodBeat.o(252699);
    return locald;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void ddP()
  {
    AppMethodBeat.i(167673);
    setMMTitle(2131760633);
    View localView = findViewById(2131307805);
    p.g(localView, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.uNf = localView;
    localView = this.uNf;
    if (localView == null) {
      p.btv("tipsLayout");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(167673);
  }
  
  public final int getCommentScene()
  {
    return 25;
  }
  
  public final int getLayoutId()
  {
    return 2131494628;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.hFK = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.tNK = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.sQn = getIntent().getIntExtra("report_scene", 0);
    this.dRL = getIntent().getStringExtra("from_user");
    this.vOF = getIntent().getBooleanExtra("key_show_jump_entry", true);
    localObject1 = getIntent().getStringExtra("key_like_buffer");
    if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject1))) {
      this.likeBuffer = com.tencent.mm.bw.b.cD(Util.decodeHexString((String)localObject1));
    }
    if ((this.hFK == 0L) && (Util.isNullOrNil(this.tNK)))
    {
      Log.w(this.TAG, "objectId " + this.hFK + ", encryptedObjectId " + this.tNK + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    int j;
    if (!this.vOG)
    {
      bool1 = true;
      this.vOE = new i(i, (MMActivity)localObject1, bool1);
      localObject1 = (MMActivity)this;
      localObject2 = this.vOE;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      localObject2 = (k.a)localObject2;
      i = this.scene;
      j = getCommentScene();
      if (this.vOG) {
        break label623;
      }
    }
    label623:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vMw = new k.b((MMActivity)localObject1, (k.a)localObject2, i, j, bool1);
      if (this.hFK != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        localObject1 = e.a.Fy(this.hFK);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          this.tNO = c.a.s((FinderItem)localObject1);
          localObject1 = this.vOE;
          if (localObject1 == null) {
            p.btv("presenter");
          }
          localObject1 = ((k.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject2 = this.tNO;
            if (localObject2 == null) {
              p.hyc();
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      if (this.sQn != 0) {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1278L, 14L, 1L, false);
      }
      dcW().a(this.scene, getCommentScene(), (kotlin.g.a.b)new c(this));
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dcW());
        }
      }
      dcX().e((m)new d(this));
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
      if (localObject1 == null) {
        break label628;
      }
      localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
      if (localObject1 == null) {
        break label628;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)dcX());
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
    }
    label628:
    AppMethodBeat.o(167672);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178446);
    if ((this.sQn != 0) && (!this.vOJ))
    {
      k localk = k.vfA;
      long l = this.hFK;
      int i = this.sQn;
      String str = this.dRL;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      k.a(localk, l, i, (String)localObject, 0);
      this.vOJ = true;
    }
    dcW().onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fH((Context)localObject);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dcW());
      }
    }
    dcX().onDetach();
    localObject = FinderReporterUIC.wzC;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fH((Context)localObject);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dcX());
      }
    }
    dAg().onDetach();
    super.onDestroy();
    AppMethodBeat.o(178446);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    long l = this.hFK;
    String str1 = this.objectNonceId;
    int i = getCommentScene();
    String str2 = this.tNK;
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      new af(l, str1, i, 2, "", true, null, null, 0L, null, false, false, str2, (bbn)localObject, 0, 20416).aYI().b((com.tencent.mm.vending.c.a)new e(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f>
  {
    b(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, bo>
  {
    c(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class d
    extends q
    implements m<Integer, Integer, LinkedList<bo>>
  {
    d(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(FinderShareFeedDetailUI paramFinderShareFeedDetailUI) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
    static final class a
      implements View.OnClickListener
    {
      a(BaseFinderFeed paramBaseFinderFeed, FinderObject paramFinderObject, FinderShareFeedDetailUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(167669);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = h.veu;
        h.dnS();
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).resetLastTimelineExitTime();
        paramView = UUID.randomUUID().toString();
        p.g(paramView, "UUID.randomUUID().toString()");
        localObject = k.vfA;
        k.gS(paramView, "Enter");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_context_id", paramView);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.vON.vOK, (Intent)localObject, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */