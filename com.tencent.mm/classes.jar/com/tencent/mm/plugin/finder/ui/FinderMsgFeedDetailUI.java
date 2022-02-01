package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.t;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<k.b, k.a>
{
  String TAG;
  private HashMap _$_findViewCache;
  boolean dJM;
  long hFK;
  private int iXu;
  private String objectNonceId;
  private int scene;
  BaseFinderFeed tNO;
  private long tZB;
  private String username;
  private k.a vMv;
  private k.b vMw;
  private boolean vMx;
  private final a vMy;
  private boolean vMz;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.tZB = -1L;
    this.iXu = -1;
    this.vMy = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void FX(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new c(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252554);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252554);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252553);
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
    AppMethodBeat.o(252553);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void ddP()
  {
    AppMethodBeat.i(167467);
    setMMTitle(2131760633);
    AppMethodBeat.o(167467);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(252552);
    int i = getIntent().getIntExtra("from_scene", 2);
    y localy = y.vXH;
    if (y.LC(i))
    {
      AppMethodBeat.o(252552);
      return 7;
    }
    AppMethodBeat.o(252552);
    return 5;
  }
  
  public final int getLayoutId()
  {
    return 2131494521;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(167466);
    this.username = getIntent().getStringExtra("feed_username");
    this.hFK = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.dJM = getIntent().getBooleanExtra("feed_is_self", false);
    this.tZB = getIntent().getLongExtra("mention_id", -1L);
    this.iXu = getIntent().getIntExtra("mention_create_time", -1);
    if (this.hFK == 0L)
    {
      Log.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.vMx = getIntent().getBooleanExtra("from_comment_ui", false);
    this.vMv = new k.a(this.scene, (MMActivity)this, false, this.dJM, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.vMv;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    this.vMw = new k.b((MMActivity)localObject1, (k.a)localObject2, this.scene, getCommentScene(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.a.Fy(this.hFK);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      this.tNO = c.a.s((FinderItem)localObject1);
      localObject1 = this.vMv;
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
    if (this.tNO == null)
    {
      Log.w(this.TAG, "feed null, finish");
      finish();
    }
    this.vMy.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(252551);
    k.b localb = this.vMw;
    if (localb == null) {
      p.btv("viewCallback");
    }
    if (localb.dcn().dGs())
    {
      localb = this.vMw;
      if (localb == null) {
        p.btv("viewCallback");
      }
      localb.dcn().dGr();
      AppMethodBeat.o(252551);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(252551);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.vMy.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.vMz) || (this.vMx))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.vMz = true;
    Object localObject1 = this.vMw;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((k.b)localObject1).dcn().getBuilder();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).wrX;; localObject1 = null)
    {
      if ((localObject1 instanceof t)) {
        ((t)localObject1).tOz = true;
      }
      if (this.tNO == null) {
        break label291;
      }
      if (this.tZB <= 0L) {
        break label286;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.a.k(this.tZB, this.iXu, this.scene);
      if (localObject2 == null) {
        break label279;
      }
      if (((ao)localObject2).field_type == 4)
      {
        azp localazp = ((ao)localObject2).field_notify;
        if ((localazp != null) && (localazp.subType == 3) && ((localObject1 instanceof t))) {
          ((t)localObject1).tOy = true;
        }
      }
      if ((((ao)localObject2).field_type != 3) && (((ao)localObject2).field_commentId == 0L)) {
        break;
      }
      FX(((ao)localObject2).field_commentId);
      AppMethodBeat.o(167463);
      return;
    }
    if (((ao)localObject2).field_type != 2)
    {
      if (((ao)localObject2).field_type == 4)
      {
        localObject1 = ((ao)localObject2).field_notify;
        if (localObject1 == null) {
          break label272;
        }
        if (((azp)localObject1).subType != 3) {}
      }
    }
    else
    {
      localObject1 = this.vMw;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      ((k.b)localObject1).dcn().post((Runnable)new b(this));
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
    FX(0L);
    label291:
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hg>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderMsgFeedDetailUI.a parama, hg paramhg)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252550);
      BaseFinderFeed localBaseFinderFeed = this.vMA.tNO;
      if (localBaseFinderFeed != null)
      {
        FinderMsgFeedDetailUI.a(this.vMA).dcn().a(localBaseFinderFeed.feedObject, null);
        AppMethodBeat.o(252550);
        return;
      }
      AppMethodBeat.o(252550);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.vMA.tNO;
      if (localBaseFinderFeed != null)
      {
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vMA).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject).cZR().En(localBaseFinderFeed.lT());
        }
        if (this.vMA.dJM) {
          break label145;
        }
        localObject = y.vXH;
        if (y.h(localBaseFinderFeed)) {
          break label145;
        }
        localObject = y.vXH;
        if (!y.i(localBaseFinderFeed.contact)) {
          break label145;
        }
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.KQ(2);
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.finder.view.e.a(FinderMsgFeedDetailUI.a(this.vMA).dcm(), localBaseFinderFeed.feedObject, paramLong, true, false, bool, null, 434);
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