package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.feed.d.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "", "getScene", "()I", "setScene", "(I)V", "username", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI
  extends FinderBaseFeedUI<d.b, com.tencent.mm.plugin.finder.feed.d.a>
{
  private boolean KYH;
  String TAG;
  private HashMap _$_findViewCache;
  private boolean diE;
  long objectId;
  private String objectNonceId;
  BaseFinderFeed qHv;
  private com.tencent.mm.plugin.finder.feed.d.a qNS;
  private d.b qNT;
  private long qNU;
  private final a qNV;
  private boolean qNW;
  private int scene;
  private String username;
  
  public FinderMsgFeedDetailUI()
  {
    AppMethodBeat.i(167470);
    this.TAG = "Finder.FinderMsgFeedDetailUI";
    this.objectNonceId = "";
    this.qNU = -1L;
    this.qNV = new a(this);
    AppMethodBeat.o(167470);
  }
  
  private final void qK(final long paramLong)
  {
    AppMethodBeat.i(167465);
    getContentView().post((Runnable)new b(this, paramLong));
    AppMethodBeat.o(167465);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199278);
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
    AppMethodBeat.o(199278);
    return localView1;
  }
  
  public final void cmB()
  {
    AppMethodBeat.i(167467);
    setMMTitle(2131759376);
    AppMethodBeat.o(167467);
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(199277);
    int i = getIntent().getIntExtra("from_scene", 2);
    i locali = i.qTa;
    if (i.Di(i))
    {
      AppMethodBeat.o(199277);
      return 7;
    }
    AppMethodBeat.o(199277);
    return 5;
  }
  
  public final int getLayoutId()
  {
    return 2131494072;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(167466);
    this.username = getIntent().getStringExtra("feed_username");
    this.objectId = getIntent().getLongExtra("feed_object_id", -1L);
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceid");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.scene = getIntent().getIntExtra("from_scene", 2);
    this.diE = getIntent().getBooleanExtra("feed_is_self", false);
    this.qNU = getIntent().getLongExtra("mention_id", -1L);
    if (this.objectId == 0L)
    {
      ad.w(this.TAG, "objectId 0, finish");
      finish();
    }
    this.KYH = getIntent().getBooleanExtra("from_comment_ui", false);
    this.qNS = new com.tencent.mm.plugin.finder.feed.d.a(this.scene, (MMActivity)this, false, this.diE, 4);
    localObject1 = (MMActivity)this;
    localObject2 = this.qNS;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    this.qNT = new d.b((MMActivity)localObject1, (com.tencent.mm.plugin.finder.feed.d.a)localObject2, this.scene, getCommentScene(), false);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.b.a.qC(this.objectId);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
      this.qHv = com.tencent.mm.plugin.finder.storage.logic.b.a.h((FinderItem)localObject1);
      localObject1 = this.qNS;
      if (localObject1 == null) {
        k.aPZ("presenter");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.feed.d.a)localObject1).feedList;
      if (localObject1 != null)
      {
        localObject2 = this.qHv;
        if (localObject2 == null) {
          k.fvU();
        }
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    if (this.qHv == null)
    {
      ad.w(this.TAG, "feed null, finish");
      finish();
    }
    this.qNV.alive();
    AppMethodBeat.o(167466);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(199276);
    d.b localb = this.qNT;
    if (localb == null) {
      k.aPZ("viewCallback");
    }
    if (localb.fSZ().fiQ())
    {
      localb = this.qNT;
      if (localb == null) {
        k.aPZ("viewCallback");
      }
      localb.fSZ().csJ();
      AppMethodBeat.o(199276);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(199276);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167464);
    super.onDestroy();
    this.qNV.dead();
    AppMethodBeat.o(167464);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167463);
    super.onResume();
    if ((this.qNW) || (this.KYH))
    {
      AppMethodBeat.o(167463);
      return;
    }
    this.qNW = true;
    if (this.qHv != null)
    {
      if (this.qNU > 0L)
      {
        Object localObject = d.qKK;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.a.an(this.qNU, this.scene);
        if (localObject != null)
        {
          if ((((com.tencent.mm.plugin.finder.storage.l)localObject).field_type == 3) || (((com.tencent.mm.plugin.finder.storage.l)localObject).field_commentId != 0L))
          {
            qK(((com.tencent.mm.plugin.finder.storage.l)localObject).field_commentId);
            AppMethodBeat.o(167463);
            return;
          }
          if (((com.tencent.mm.plugin.finder.storage.l)localObject).field_type == 2)
          {
            localObject = this.qNT;
            if (localObject == null) {
              k.aPZ("viewCallback");
            }
            ((d.b)localObject).fSZ().post((Runnable)new FinderMsgFeedDetailUI.c(this));
          }
          AppMethodBeat.o(167463);
          return;
        }
        AppMethodBeat.o(167463);
        return;
      }
      qK(0L);
    }
    AppMethodBeat.o(167463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<gw>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderMsgFeedDetailUI.a parama, gw paramgw)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(167462);
      BaseFinderFeed localBaseFinderFeed = this.qNX.qHv;
      if (localBaseFinderFeed != null)
      {
        Object localObject = com.tencent.mm.ui.component.a.LCX;
        localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.qNX).get(FinderReporterUIC.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.c)localObject).fSl().Bw(localBaseFinderFeed.bMs());
        }
        f.a(FinderMsgFeedDetailUI.b(this.qNX).fSY(), localBaseFinderFeed.feedObject, paramLong);
        AppMethodBeat.o(167462);
        return;
      }
      AppMethodBeat.o(167462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */