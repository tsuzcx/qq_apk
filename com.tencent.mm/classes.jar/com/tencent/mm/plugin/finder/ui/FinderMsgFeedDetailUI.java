package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
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
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<j.b, j.a>
{
  String TAG;
  private HashMap _$_findViewCache;
  boolean drv;
  private int hZE;
  private String objectNonceId;
  long rIZ;
  BaseFinderFeed rQZ;
  private j.a sEn;
  private j.b sEo;
  private boolean sEp;
  private final a sEq;
  private boolean sEr;
  private int scene;
  private long sdB;
  private String username;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.sdB = -1L;
    this.hZE = -1;
    this.sEq = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void xj(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new c(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204047);
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
    AppMethodBeat.o(204047);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(204046);
    int i = getIntent().getIntExtra("from_scene", 2);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.FL(i))
    {
      AppMethodBeat.o(204046);
      return 7;
    }
    AppMethodBeat.o(204046);
    return 5;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final void cCb()
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
    this.rIZ = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.drv = getIntent().getBooleanExtra("feed_is_self", false);
    this.sdB = getIntent().getLongExtra("mention_id", -1L);
    this.hZE = getIntent().getIntExtra("mention_create_time", -1);
    if (this.rIZ == 0L)
    {
      ad.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.sEp = getIntent().getBooleanExtra("from_comment_ui", false);
    this.sEn = new j.a(this.scene, (MMActivity)this, false, this.drv, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.sEn;
    if (localObject2 == null) {
      d.g.b.p.bcb("presenter");
    }
    this.sEo = new j.b((MMActivity)localObject1, (j.a)localObject2, this.scene, cAZ(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.szI;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.a.wT(this.rIZ);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      this.rQZ = b.a.j((FinderItem)localObject1);
      localObject1 = this.sEn;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      localObject1 = ((j.a)localObject1).feedList;
      if (localObject1 != null)
      {
        localObject2 = this.rQZ;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    if (this.rQZ == null)
    {
      ad.w(this.TAG, "feed null, finish");
      finish();
    }
    this.sEq.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(204045);
    j.b localb = this.sEo;
    if (localb == null) {
      d.g.b.p.bcb("viewCallback");
    }
    if (localb.cAM().cMZ())
    {
      localb = this.sEo;
      if (localb == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localb.cAM().cMY();
      AppMethodBeat.o(204045);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(204045);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.sEq.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.sEr) || (this.sEp))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.sEr = true;
    Object localObject1 = this.sEo;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject1 = ((j.b)localObject1).cAM().getBuilder();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).sXK;; localObject1 = null)
    {
      if ((localObject1 instanceof s)) {
        ((s)localObject1).GpL = true;
      }
      if (this.rQZ == null) {
        break label291;
      }
      if (this.sdB <= 0L) {
        break label286;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.sAw;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.a.l(this.sdB, this.hZE, this.scene);
      if (localObject2 == null) {
        break label279;
      }
      if (((ac)localObject2).field_type == 4)
      {
        apz localapz = ((ac)localObject2).field_notify;
        if ((localapz != null) && (localapz.subType == 3) && ((localObject1 instanceof s))) {
          ((s)localObject1).EIC = true;
        }
      }
      if ((((ac)localObject2).field_type != 3) && (((ac)localObject2).field_commentId == 0L)) {
        break;
      }
      xj(((ac)localObject2).field_commentId);
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
        if (((apz)localObject1).subType != 3) {}
      }
    }
    else
    {
      localObject1 = this.sEo;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      ((j.b)localObject1).cAM().post((Runnable)new b(this));
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
    xj(0L);
    label291:
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<hb>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderMsgFeedDetailUI.a parama, hb paramhb)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204044);
      BaseFinderFeed localBaseFinderFeed = this.sEs.rQZ;
      if (localBaseFinderFeed != null)
      {
        FinderMsgFeedDetailUI.a(this.sEs).cAM().a(localBaseFinderFeed.feedObject, null);
        AppMethodBeat.o(204044);
        return;
      }
      AppMethodBeat.o(204044);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.sEs.rQZ;
      if (localBaseFinderFeed != null)
      {
        Object localObject = com.tencent.mm.ui.component.a.KiD;
        localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.sEs).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject).cze().vR(localBaseFinderFeed.lP());
        }
        if (this.sEs.drv) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.d(localBaseFinderFeed)) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (!com.tencent.mm.plugin.finder.utils.p.j(localBaseFinderFeed.contact)) {
          break label144;
        }
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        com.tencent.mm.plugin.finder.storage.b.Fh(2);
      }
      label144:
      for (boolean bool = true;; bool = false)
      {
        e.a(FinderMsgFeedDetailUI.a(this.sEs).cAL(), localBaseFinderFeed.feedObject, paramLong, true, false, bool, 434);
        AppMethodBeat.o(167462);
        return;
        AppMethodBeat.o(167462);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */