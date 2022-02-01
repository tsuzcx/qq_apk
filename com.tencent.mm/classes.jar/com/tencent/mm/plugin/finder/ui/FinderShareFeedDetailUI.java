package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "showJumpEntry", "getShowJumpEntry", "setShowJumpEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<k.b, g>
{
  private k.b Atn;
  private g Avq;
  boolean Avr;
  private boolean Avs;
  private View Avt;
  private boolean Avu;
  private boolean Avv;
  final String TAG;
  private HashMap _$_findViewCache;
  String fLi;
  private com.tencent.mm.cd.b likeBuffer;
  private String objectNonceId;
  private int scene;
  int wwk;
  private final kotlin.f xCQ;
  private final kotlin.f xCR;
  long xbk;
  private String xxK;
  BaseFinderFeed xxO;
  private View zzB;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.xxK = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.fLi = "";
    this.xCQ = kotlin.g.ar((kotlin.g.a.a)new a(this));
    this.xCR = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Avr = true;
    this.Avs = ((ak)h.ag(ak.class)).showFinderEntry();
    this.Avu = true;
    AppMethodBeat.o(167676);
  }
  
  private k dtz()
  {
    AppMethodBeat.i(278325);
    k localk = (k)this.xCR.getValue();
    AppMethodBeat.o(278325);
    return localk;
  }
  
  private g eaY()
  {
    AppMethodBeat.i(278326);
    g localg = this.Avq;
    if (localg == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(278326);
    return localg;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278330);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278330);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278328);
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
    AppMethodBeat.o(278328);
    return localView1;
  }
  
  public final i dty()
  {
    AppMethodBeat.i(278323);
    i locali = (i)this.xCQ.getValue();
    AppMethodBeat.o(278323);
    return locali;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void duT()
  {
    AppMethodBeat.i(167673);
    setMMTitle(b.j.finder_title);
    View localView = findViewById(b.f.share_feed_detail_tips_layout);
    p.j(localView, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.zzB = localView;
    localView = this.zzB;
    if (localView == null) {
      p.bGy("tipsLayout");
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
    return b.g.finder_share_feed_detail_ui;
  }
  
  public final void initOnCreate()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.xbk = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject2 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xxK = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.wwk = getIntent().getIntExtra("report_scene", 0);
    this.fLi = getIntent().getStringExtra("from_user");
    this.Avr = getIntent().getBooleanExtra("key_show_jump_entry", true);
    localObject1 = getIntent().getStringExtra("key_like_buffer");
    if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject1))) {
      this.likeBuffer = com.tencent.mm.cd.b.cU(Util.decodeHexString((String)localObject1));
    }
    if ((this.xbk == 0L) && (Util.isNullOrNil(this.xxK)))
    {
      Log.w(this.TAG, "objectId " + this.xbk + ", encryptedObjectId " + this.xxK + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    int j;
    if (!this.Avs)
    {
      bool1 = true;
      this.Avq = new g(i, (MMActivity)localObject1, bool1);
      localObject1 = (MMActivity)this;
      localObject2 = this.Avq;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      localObject2 = (k.a)localObject2;
      i = this.scene;
      j = getCommentScene();
      if (this.Avs) {
        break label655;
      }
    }
    label655:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Atn = new k.b((MMActivity)localObject1, (k.a)localObject2, i, j, bool1);
      if (this.xbk != 0L)
      {
        localObject1 = e.AmW;
        localObject1 = e.a.MH(this.xbk);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          this.xxO = c.a.a((FinderItem)localObject1);
          localObject1 = this.Avq;
          if (localObject1 == null) {
            p.bGy("presenter");
          }
          localObject1 = ((k.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject2 = this.xxO;
            if (localObject2 == null) {
              p.iCn();
            }
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      if (this.wwk != 0) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1278L, 14L, 1L, false);
      }
      dty().a(this.scene, getCommentScene(), (kotlin.g.a.b)new c(this));
      localObject1 = aj.Bnu;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = aj.a((aj)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)dty());
        }
      }
      localObject1 = dtz();
      localObject2 = (m)new d(this);
      k.b localb = this.Atn;
      if (localb == null) {
        p.bGy("viewCallback");
      }
      ((k)localObject1).a((m)localObject2, localb.xvJ.getRecyclerView());
      localObject1 = aj.Bnu;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 == null) {
        break label660;
      }
      localObject1 = aj.a((aj)localObject1);
      if (localObject1 == null) {
        break label660;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)dtz());
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
    }
    label660:
    AppMethodBeat.o(167672);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(178446);
    if ((this.wwk != 0) && (!this.Avv))
    {
      n localn = n.zWF;
      long l = this.xbk;
      int i = this.wwk;
      String str = this.fLi;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      n.a(localn, l, i, (String)localObject, 0);
      this.Avv = true;
    }
    dty().onDetach();
    Object localObject = aj.Bnu;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = aj.a.fZ((Context)localObject);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)dty());
      }
    }
    dtz().onDetach();
    localObject = aj.Bnu;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = aj.a.fZ((Context)localObject);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)dtz());
      }
    }
    eaY().onDetach();
    super.onDestroy();
    AppMethodBeat.o(178446);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    long l = this.xbk;
    String str1 = this.objectNonceId;
    int i = getCommentScene();
    String str2 = this.xxK;
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this);
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      new ag(l, str1, i, 2, "", true, null, null, 0L, null, false, false, str2, (bid)localObject, 0, null, 53184).bhW().b((com.tencent.mm.vending.c.a)new e(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<i>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<k>
  {
    b(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, bu>
  {
    c(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class d
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    d(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(FinderShareFeedDetailUI paramFinderShareFeedDetailUI) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
    static final class a
      implements View.OnClickListener
    {
      a(BaseFinderFeed paramBaseFinderFeed, FinderObject paramFinderObject, FinderShareFeedDetailUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(167669);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = j.zVy;
        j.dPt();
        ((PluginFinder)h.ag(PluginFinder.class)).resetLastTimelineExitTime();
        paramView = UUID.randomUUID().toString();
        p.j(paramView, "UUID.randomUUID().toString()");
        localObject = n.zWF;
        n.hj(paramView, "Enter");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_context_id", paramView);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.Avz.Avw, (Intent)localObject, 1);
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