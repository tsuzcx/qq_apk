package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<j.b, j.a>
{
  String TAG;
  private HashMap _$_findViewCache;
  boolean dsB;
  private int icw;
  private String objectNonceId;
  long rRn;
  BaseFinderFeed rZB;
  private j.a sPm;
  private j.b sPn;
  private boolean sPo;
  private final a sPp;
  private boolean sPq;
  private int scene;
  private long smr;
  private String username;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.smr = -1L;
    this.icw = -1;
    this.sPp = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void xA(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new c(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204643);
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
    AppMethodBeat.o(204643);
    return localView1;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(204642);
    int i = getIntent().getIntExtra("from_scene", 2);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (com.tencent.mm.plugin.finder.utils.p.Gj(i))
    {
      AppMethodBeat.o(204642);
      return 7;
    }
    AppMethodBeat.o(204642);
    return 5;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final void cDN()
  {
    AppMethodBeat.i(167467);
    setMMTitle(2131759376);
    AppMethodBeat.o(167467);
  }
  
  public final int getLayoutId()
  {
    return 2131494072;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(167466);
    this.username = getIntent().getStringExtra("feed_username");
    this.rRn = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.dsB = getIntent().getBooleanExtra("feed_is_self", false);
    this.smr = getIntent().getLongExtra("mention_id", -1L);
    this.icw = getIntent().getIntExtra("mention_create_time", -1);
    if (this.rRn == 0L)
    {
      ae.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.sPo = getIntent().getBooleanExtra("from_comment_ui", false);
    this.sPm = new j.a(this.scene, (MMActivity)this, false, this.dsB, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.sPm;
    if (localObject2 == null) {
      d.g.b.p.bdF("presenter");
    }
    this.sPn = new j.b((MMActivity)localObject1, (j.a)localObject2, this.scene, cCL(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.a.xk(this.rRn);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      this.rZB = b.a.j((FinderItem)localObject1);
      localObject1 = this.sPm;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      localObject1 = ((j.a)localObject1).feedList;
      if (localObject1 != null)
      {
        localObject2 = this.rZB;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    if (this.rZB == null)
    {
      ae.w(this.TAG, "feed null, finish");
      finish();
    }
    this.sPp.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(204641);
    j.b localb = this.sPn;
    if (localb == null) {
      d.g.b.p.bdF("viewCallback");
    }
    if (localb.cCy().cPI())
    {
      localb = this.sPn;
      if (localb == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localb.cCy().cPH();
      AppMethodBeat.o(204641);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(204641);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.sPp.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.sPq) || (this.sPo))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.sPq = true;
    Object localObject1 = this.sPn;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    localObject1 = ((j.b)localObject1).cCy().getBuilder();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).tiY;; localObject1 = null)
    {
      if ((localObject1 instanceof s)) {
        ((s)localObject1).seS = true;
      }
      if (this.rZB == null) {
        break label291;
      }
      if (this.smr <= 0L) {
        break label286;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.sLu;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.a.l(this.smr, this.icw, this.scene);
      if (localObject2 == null) {
        break label279;
      }
      if (((ac)localObject2).field_type == 4)
      {
        aqm localaqm = ((ac)localObject2).field_notify;
        if ((localaqm != null) && (localaqm.subType == 3) && ((localObject1 instanceof s))) {
          ((s)localObject1).seR = true;
        }
      }
      if ((((ac)localObject2).field_type != 3) && (((ac)localObject2).field_commentId == 0L)) {
        break;
      }
      xA(((ac)localObject2).field_commentId);
      AppMethodBeat.o(167463);
      return;
    }
    if (((ac)localObject2).field_type != 2)
    {
      if (((ac)localObject2).field_type == 4)
      {
        localObject1 = ((ac)localObject2).field_notify;
        if (localObject1 == null) {
          break label272;
        }
        if (((aqm)localObject1).subType != 3) {}
      }
    }
    else
    {
      localObject1 = this.sPn;
      if (localObject1 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      ((j.b)localObject1).cCy().post((Runnable)new b(this));
    }
    AppMethodBeat.o(167463);
    return;
    label272:
    AppMethodBeat.o(167463);
    return;
    label279:
    AppMethodBeat.o(167463);
    return;
    label286:
    xA(0L);
    label291:
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<hc>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderMsgFeedDetailUI.a parama, hc paramhc)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204640);
      BaseFinderFeed localBaseFinderFeed = this.sPr.rZB;
      if (localBaseFinderFeed != null)
      {
        FinderMsgFeedDetailUI.a(this.sPr).cCy().a(localBaseFinderFeed.feedObject, null);
        AppMethodBeat.o(204640);
        return;
      }
      AppMethodBeat.o(204640);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.sPr.rZB;
      if (localBaseFinderFeed != null)
      {
        Object localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.sPr).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject).cAI().wh(localBaseFinderFeed.lP());
        }
        if (this.sPr.dsB) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.d(localBaseFinderFeed)) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        com.tencent.mm.plugin.finder.storage.b.FD(2);
      }
      label144:
      for (boolean bool = true;; bool = false)
      {
        e.a(FinderMsgFeedDetailUI.a(this.sPr).cCx(), localBaseFinderFeed.feedObject, paramLong, true, false, bool, 434);
        AppMethodBeat.o(167462);
        return;
        AppMethodBeat.o(167462);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */