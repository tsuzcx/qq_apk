package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.feed.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.logic.f.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.teenmode.b;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<com.tencent.mm.plugin.finder.feed.k.b, k.a>
{
  private long ABR;
  private BaseFinderFeed AUZ;
  private k.a FSC;
  private com.tencent.mm.plugin.finder.feed.k.b FSD;
  private boolean FSE;
  private final feedDeleteListener.1 FSF;
  private boolean FSG;
  String TAG;
  private int createTime;
  private boolean hHq;
  long hKN;
  private String objectNonceId;
  private int scene;
  private String username;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.ABR = -1L;
    this.createTime = -1;
    this.FSF = new IListener(com.tencent.mm.app.f.hfK)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(hy paramhy, FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI)
        {
          super();
        }
      }
    };
    AppMethodBeat.o(167470);
  }
  
  private static final void a(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI)
  {
    AppMethodBeat.i(346850);
    s.u(paramFinderMsgFeedDetailUI, "this$0");
    BaseFinderFeed localBaseFinderFeed = paramFinderMsgFeedDetailUI.AUZ;
    if (localBaseFinderFeed != null)
    {
      com.tencent.mm.plugin.finder.feed.k.b localb = paramFinderMsgFeedDetailUI.FSD;
      paramFinderMsgFeedDetailUI = localb;
      if (localb == null)
      {
        s.bIx("viewCallback");
        paramFinderMsgFeedDetailUI = null;
      }
      paramFinderMsgFeedDetailUI.ebI().a(localBaseFinderFeed.feedObject, null);
    }
    AppMethodBeat.o(346850);
  }
  
  private static final void a(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong)
  {
    AppMethodBeat.i(346842);
    s.u(paramFinderMsgFeedDetailUI, "this$0");
    BaseFinderFeed localBaseFinderFeed = paramFinderMsgFeedDetailUI.AUZ;
    Object localObject;
    if (localBaseFinderFeed != null)
    {
      localObject = k.aeZF;
      localObject = k.d((AppCompatActivity)paramFinderMsgFeedDetailUI).q(as.class);
      s.s(localObject, "UICProvider.of(this@Find…rReporterUIC::class.java)");
      localObject = ((bn)localObject).foy();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.event.a)localObject).dYj();
        if (localObject != null) {
          ((a.b)localObject).na(localBaseFinderFeed.bZA());
        }
      }
      if (paramFinderMsgFeedDetailUI.hHq) {
        break label184;
      }
      localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.e(localBaseFinderFeed)) {
        break label184;
      }
      localObject = aw.Gjk;
      if (!aw.n(localBaseFinderFeed.contact)) {
        break label184;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.Tl(2);
    }
    label184:
    for (boolean bool = true;; bool = false)
    {
      localObject = paramFinderMsgFeedDetailUI.FSD;
      paramFinderMsgFeedDetailUI = (FinderMsgFeedDetailUI)localObject;
      if (localObject == null)
      {
        s.bIx("viewCallback");
        paramFinderMsgFeedDetailUI = null;
      }
      com.tencent.mm.plugin.finder.view.f.a(paramFinderMsgFeedDetailUI.ebH(), localBaseFinderFeed.feedObject, paramLong, true, false, bool, null, 0L, 1970);
      AppMethodBeat.o(346842);
      return;
    }
  }
  
  private final void qw(long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post(new FinderMsgFeedDetailUI..ExternalSyntheticLambda1(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void eeB()
  {
    AppMethodBeat.i(167467);
    setMMTitle(e.h.finder_title);
    WeImageView localWeImageView = (WeImageView)findViewById(e.e.backBtnIv);
    if (localWeImageView != null) {
      localWeImageView.setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
    }
    AppMethodBeat.o(167467);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(346913);
    int i = getIntent().getIntExtra("from_scene", 2);
    com.tencent.mm.plugin.finder.utils.av localav = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (com.tencent.mm.plugin.finder.utils.av.yi(i))
    {
      AppMethodBeat.o(346913);
      return 7;
    }
    AppMethodBeat.o(346913);
    return 5;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_feed_detail_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346866);
    Set localSet = ar.setOf(b.class);
    AppMethodBeat.o(346866);
    return localSet;
  }
  
  public final void initOnCreate()
  {
    BaseFinderFeed localBaseFinderFeed = null;
    AppMethodBeat.i(167466);
    this.username = getIntent().getStringExtra("feed_username");
    this.hKN = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.hHq = getIntent().getBooleanExtra("feed_is_self", false);
    this.ABR = getIntent().getLongExtra("mention_id", -1L);
    this.createTime = getIntent().getIntExtra("mention_create_time", -1);
    if (this.hKN == 0L)
    {
      Log.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.FSE = getIntent().getBooleanExtra("from_comment_ui", false);
    this.FSC = new k.a(this.scene, (MMActivity)this, false, this.hHq, 4);
    MMActivity localMMActivity = (MMActivity)this;
    localObject2 = this.FSC;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    this.FSD = new com.tencent.mm.plugin.finder.feed.k.b(localMMActivity, (k.a)localObject1, this.scene, getCommentScene(), false);
    localObject1 = e.FMN;
    localObject1 = e.a.jn(this.hKN);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      this.AUZ = d.a.a((FinderItem)localObject1);
      localObject1 = this.FSC;
      if (localObject1 != null) {
        break label341;
      }
      s.bIx("presenter");
      localObject1 = localBaseFinderFeed;
    }
    label341:
    for (;;)
    {
      localObject1 = ((k.a)localObject1).feedList;
      if (localObject1 != null)
      {
        localBaseFinderFeed = this.AUZ;
        s.checkNotNull(localBaseFinderFeed);
        ((ArrayList)localObject1).add(localBaseFinderFeed);
      }
      if (this.AUZ == null)
      {
        Log.w(this.TAG, "feed null, finish");
        finish();
      }
      this.FSF.alive();
      AppMethodBeat.o(167466);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(346875);
    com.tencent.mm.plugin.finder.feed.k.b localb = this.FSD;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    if (((com.tencent.mm.plugin.finder.feed.k.b)localObject1).ebI().fkp())
    {
      localObject1 = this.FSD;
      if (localObject1 == null)
      {
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.feed.k.b)localObject1).ebI().fdh();
        AppMethodBeat.o(346875);
        return;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(346875);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.FSF.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.FSG) || (this.FSE))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.FSG = true;
    Object localObject3 = this.FSD;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((com.tencent.mm.plugin.finder.feed.k.b)localObject1).ebI().getBuilder();
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 instanceof y)) {
        ((y)localObject1).AWo = true;
      }
      if (this.AUZ == null) {
        break label324;
      }
      if (this.ABR <= 0L) {
        break label319;
      }
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
      localObject3 = f.a.t(this.ABR, this.createTime, this.scene);
      if (localObject3 == null) {
        break label324;
      }
      if (((com.tencent.mm.plugin.finder.storage.av)localObject3).field_type == 4)
      {
        bqv localbqv = ((com.tencent.mm.plugin.finder.storage.av)localObject3).field_notify;
        if ((localbqv == null) || (localbqv.subType != 3)) {
          break label225;
        }
      }
    }
    label225:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((localObject1 instanceof y))) {
        ((y)localObject1).AWn = true;
      }
      if ((((com.tencent.mm.plugin.finder.storage.av)localObject3).field_type != 3) && (((com.tencent.mm.plugin.finder.storage.av)localObject3).field_commentId == 0L)) {
        break label230;
      }
      qw(((com.tencent.mm.plugin.finder.storage.av)localObject3).field_commentId);
      AppMethodBeat.o(167463);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.a)localObject1).GGG;
      break;
    }
    label230:
    if (((com.tencent.mm.plugin.finder.storage.av)localObject3).field_type != 2)
    {
      if (((com.tencent.mm.plugin.finder.storage.av)localObject3).field_type == 4)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.storage.av)localObject3).field_notify;
        if ((localObject1 == null) || (((bqv)localObject1).subType != 3)) {
          break label311;
        }
        i = 1;
        if (i == 0) {}
      }
    }
    else
    {
      localObject1 = this.FSD;
      if (localObject1 != null) {
        break label316;
      }
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label311:
    label316:
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.feed.k.b)localObject1).ebI().post(new FinderMsgFeedDetailUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(167463);
      return;
      i = 0;
      break;
    }
    label319:
    qw(0L);
    label324:
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class feedDeleteListener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    feedDeleteListener$1$a(hy paramhy, FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */