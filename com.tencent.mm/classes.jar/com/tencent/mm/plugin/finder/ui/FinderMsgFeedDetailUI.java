package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<k.b, k.a>
{
  private k.a Atm;
  private k.b Atn;
  private boolean Ato;
  private final a Atp;
  private boolean Atq;
  String TAG;
  private HashMap _$_findViewCache;
  private int createTime;
  boolean fCB;
  private String objectNonceId;
  private int scene;
  private String username;
  long xbk;
  private long xcD;
  BaseFinderFeed xxO;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.xcD = -1L;
    this.createTime = -1;
    this.Atp = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void MX(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new c(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(289285);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289285);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289284);
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
    AppMethodBeat.o(289284);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void duT()
  {
    AppMethodBeat.i(167467);
    setMMTitle(b.j.finder_title);
    WeImageView localWeImageView = (WeImageView)findViewById(b.f.backBtnIv);
    if (localWeImageView != null)
    {
      localWeImageView.setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
      AppMethodBeat.o(167467);
      return;
    }
    AppMethodBeat.o(167467);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(289283);
    int i = getIntent().getIntExtra("from_scene", 2);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.QQ(i))
    {
      AppMethodBeat.o(289283);
      return 7;
    }
    AppMethodBeat.o(289283);
    return 5;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_msg_feed_detail_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(167466);
    this.username = getIntent().getStringExtra("feed_username");
    this.xbk = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.fCB = getIntent().getBooleanExtra("feed_is_self", false);
    this.xcD = getIntent().getLongExtra("mention_id", -1L);
    this.createTime = getIntent().getIntExtra("mention_create_time", -1);
    if (this.xbk == 0L)
    {
      Log.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.Ato = getIntent().getBooleanExtra("from_comment_ui", false);
    this.Atm = new k.a(this.scene, (MMActivity)this, false, this.fCB, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.Atm;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    this.Atn = new k.b((MMActivity)localObject1, (k.a)localObject2, this.scene, getCommentScene(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.e.a.MH(this.xbk);
    if (localObject1 != null)
    {
      localObject2 = c.AnK;
      this.xxO = c.a.a((FinderItem)localObject1);
      localObject1 = this.Atm;
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
    if (this.xxO == null)
    {
      Log.w(this.TAG, "feed null, finish");
      finish();
    }
    this.Atp.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(289282);
    k.b localb = this.Atn;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    if (localb.dsD().eis())
    {
      localb = this.Atn;
      if (localb == null) {
        p.bGy("viewCallback");
      }
      localb.dsD().eir();
      AppMethodBeat.o(289282);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(289282);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.Atp.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.Atq) || (this.Ato))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.Atq = true;
    Object localObject1 = this.Atn;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((k.b)localObject1).dsD().getBuilder();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).Bel;; localObject1 = null)
    {
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.feed.x)) {
        ((com.tencent.mm.plugin.finder.feed.x)localObject1).xyZ = true;
      }
      if (this.xxO == null) {
        break label291;
      }
      if (this.xcD <= 0L) {
        break label286;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.AnP;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.a.l(this.xcD, this.createTime, this.scene);
      if (localObject2 == null) {
        break label279;
      }
      if (((an)localObject2).field_type == 4)
      {
        bfo localbfo = ((an)localObject2).field_notify;
        if ((localbfo != null) && (localbfo.subType == 3) && ((localObject1 instanceof com.tencent.mm.plugin.finder.feed.x))) {
          ((com.tencent.mm.plugin.finder.feed.x)localObject1).xyY = true;
        }
      }
      if ((((an)localObject2).field_type != 3) && (((an)localObject2).field_commentId == 0L)) {
        break;
      }
      MX(((an)localObject2).field_commentId);
      AppMethodBeat.o(167463);
      return;
    }
    if (((an)localObject2).field_type != 2)
    {
      if (((an)localObject2).field_type == 4)
      {
        localObject1 = ((an)localObject2).field_notify;
        if (localObject1 == null) {
          break label272;
        }
        if (((bfo)localObject1).subType != 3) {}
      }
    }
    else
    {
      localObject1 = this.Atn;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      ((k.b)localObject1).dsD().post((Runnable)new b(this));
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
    MX(0L);
    label291:
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hn>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderMsgFeedDetailUI.a parama, hn paramhn)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(239427);
      BaseFinderFeed localBaseFinderFeed = this.Atr.xxO;
      if (localBaseFinderFeed != null)
      {
        FinderMsgFeedDetailUI.a(this.Atr).dsD().a(localBaseFinderFeed.feedObject, null);
        AppMethodBeat.o(239427);
        return;
      }
      AppMethodBeat.o(239427);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.Atr.xxO;
      if (localBaseFinderFeed != null)
      {
        Object localObject = g.Xox;
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.b((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.Atr).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject).dpO().KC(localBaseFinderFeed.mf());
        }
        if (this.Atr.fCB) {
          break label145;
        }
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.j(localBaseFinderFeed)) {
          break label145;
        }
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.j(localBaseFinderFeed.contact)) {
          break label145;
        }
        localObject = d.AjH;
        d.Qb(2);
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        f.a(FinderMsgFeedDetailUI.a(this.Atr).dsC(), localBaseFinderFeed.feedObject, paramLong, true, false, bool, null, 434);
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