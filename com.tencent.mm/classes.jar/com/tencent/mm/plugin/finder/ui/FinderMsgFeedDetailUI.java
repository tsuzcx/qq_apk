package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<i.b, i.a>
{
  String TAG;
  private HashMap _$_findViewCache;
  private boolean dfZ;
  private int hGU;
  private String objectNonceId;
  long qXP;
  private i.a rJo;
  private i.b rJp;
  private boolean rJq;
  private final a rJr;
  private boolean rJs;
  BaseFinderFeed rdD;
  private long roS;
  private int scene;
  private String username;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.roS = -1L;
    this.hGU = -1;
    this.rJr = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void vh(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new c(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203249);
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
    AppMethodBeat.o(203249);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(203248);
    int i = getIntent().getIntExtra("from_scene", 2);
    n localn = n.rPN;
    if (n.EB(i))
    {
      AppMethodBeat.o(203248);
      return 7;
    }
    AppMethodBeat.o(203248);
    return 5;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final void cvL()
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
    this.qXP = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.dfZ = getIntent().getBooleanExtra("feed_is_self", false);
    this.roS = getIntent().getLongExtra("mention_id", -1L);
    this.hGU = getIntent().getIntExtra("mention_create_time", -1);
    if (this.qXP == 0L)
    {
      ac.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.rJq = getIntent().getBooleanExtra("from_comment_ui", false);
    this.rJo = new i.a(this.scene, (MMActivity)this, false, this.dfZ, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.rJo;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    this.rJp = new i.b((MMActivity)localObject1, (i.a)localObject2, this.scene, cuI(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.a.uS(this.qXP);
    if (localObject1 != null)
    {
      localObject2 = b.rFl;
      this.rdD = b.a.i((FinderItem)localObject1);
      localObject1 = this.rJo;
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
    if (this.rdD == null)
    {
      ac.w(this.TAG, "feed null, finish");
      finish();
    }
    this.rJr.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203247);
    i.b localb = this.rJp;
    if (localb == null) {
      k.aVY("viewCallback");
    }
    if (localb.cuA().cEG())
    {
      localb = this.rJp;
      if (localb == null) {
        k.aVY("viewCallback");
      }
      localb.cuA().cEF();
      AppMethodBeat.o(203247);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(203247);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.rJr.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.rJs) || (this.rJq))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.rJs = true;
    if (this.rdD != null)
    {
      if (this.roS > 0L)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.rFp;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.a.k(this.roS, this.hGU, this.scene);
        if (localObject != null)
        {
          if ((((u)localObject).field_type == 3) || (((u)localObject).field_commentId != 0L))
          {
            vh(((u)localObject).field_commentId);
            AppMethodBeat.o(167463);
            return;
          }
          if (((u)localObject).field_type == 2)
          {
            localObject = this.rJp;
            if (localObject == null) {
              k.aVY("viewCallback");
            }
            ((i.b)localObject).cuA().post((Runnable)new b(this));
          }
          AppMethodBeat.o(167463);
          return;
        }
        AppMethodBeat.o(167463);
        return;
      }
      vh(0L);
    }
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<gx>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderMsgFeedDetailUI.a parama, gx paramgx)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(203246);
      BaseFinderFeed localBaseFinderFeed = this.rJt.rdD;
      if (localBaseFinderFeed != null)
      {
        FinderMsgFeedDetailUI.a(this.rJt).cuA().p(localBaseFinderFeed.feedObject);
        AppMethodBeat.o(203246);
        return;
      }
      AppMethodBeat.o(203246);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.rJt.rdD;
      if (localBaseFinderFeed != null)
      {
        Object localObject = com.tencent.mm.ui.component.a.IrY;
        localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this.rJt).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject).ctb().tU(localBaseFinderFeed.lx());
        }
        com.tencent.mm.plugin.finder.view.d.a(FinderMsgFeedDetailUI.a(this.rJt).cuz(), localBaseFinderFeed.feedObject, paramLong);
        AppMethodBeat.o(167462);
        return;
      }
      AppMethodBeat.o(167462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */