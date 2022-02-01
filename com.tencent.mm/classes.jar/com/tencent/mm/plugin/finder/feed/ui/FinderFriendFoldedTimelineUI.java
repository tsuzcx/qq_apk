package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.n.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "feedNonceId", "foldedType", "", "isFullScreen", "", "()Z", "isFullScreen$delegate", "Lkotlin/Lazy;", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "isOtherEnableFullScreenEnjoy", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<FinderFriendFoldedFeedLoader, n.b, n.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private long feedId;
  private String nickname;
  private final int scene;
  private String uaa;
  private n.a uau;
  private n.b uav;
  private FinderFriendFoldedFeedLoader uaw;
  private int uax;
  private final f uay;
  private String username;
  
  public FinderFriendFoldedTimelineUI()
  {
    AppMethodBeat.i(245226);
    this.TAG = "Finder.FinderFriendFoldedTimelineUI";
    this.scene = 2;
    this.uaa = "";
    this.uay = g.ah((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(245226);
  }
  
  private final boolean isFullScreen()
  {
    AppMethodBeat.i(245220);
    boolean bool = ((Boolean)this.uay.getValue()).booleanValue();
    AppMethodBeat.o(245220);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245229);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245229);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245228);
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
    AppMethodBeat.o(245228);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 14;
  }
  
  public final int getLayoutId()
  {
    return 2131494315;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245221);
    Object localObject2 = getIntent().getStringExtra("USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.username = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.nickname = ((String)localObject1);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.uaa = ((String)localObject1);
    this.uax = getIntent().getIntExtra("FOLED_TYPE", 1);
    if (this.uax == 1)
    {
      localObject1 = (Context)getContext();
      localObject2 = this.nickname;
      if (localObject2 == null) {
        p.btv("nickname");
      }
      setMMTitle(getString(2131759770, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)localObject2) }));
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      long l = this.feedId;
      localObject2 = this.username;
      if (localObject2 == null) {
        p.btv("username");
      }
      this.uau = new n.a((MMActivity)localObject1, l, (String)localObject2, this.scene, isFullScreen());
      localObject1 = (MMActivity)this;
      localObject2 = this.uau;
      if (localObject2 == null) {
        p.btv("mPresenter");
      }
      this.uav = new n.b((MMActivity)localObject1, (n.a)localObject2, this.scene);
      localObject1 = this.username;
      if (localObject1 == null) {
        p.btv("username");
      }
      l = this.feedId;
      localObject2 = this.uaa;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      localObject1 = new FinderFriendFoldedFeedLoader((String)localObject1, l, (String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFriendFoldedFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFriendFoldedFeedLoader)localObject1).setInitDone((h)new a((FinderFriendFoldedFeedLoader)localObject1, this));
      ((FinderFriendFoldedFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.uaw = ((FinderFriendFoldedFeedLoader)localObject1);
      AppMethodBeat.o(245221);
      return;
      if (this.uax == 2)
      {
        localObject1 = (Context)getContext();
        localObject2 = this.nickname;
        if (localObject2 == null) {
          p.btv("nickname");
        }
        setMMTitle(getString(2131759748, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)localObject2) }));
      }
      else
      {
        setMMTitle("");
      }
    }
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(245222);
    boolean bool = isFullScreen();
    AppMethodBeat.o(245222);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFriendFoldedFeedLoader paramFinderFriendFoldedFeedLoader, FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245217);
      Object localObject = FinderFriendFoldedTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245217);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.uaz.getInitPos(), 0);
        AppMethodBeat.o(245217);
        return;
      }
      AppMethodBeat.o(245217);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<bo>, x>
  {
    b(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI
 * JD-Core Version:    0.7.0.1
 */