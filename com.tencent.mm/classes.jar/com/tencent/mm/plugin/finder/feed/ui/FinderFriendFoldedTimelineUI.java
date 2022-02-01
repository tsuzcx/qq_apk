package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.r.a;
import com.tencent.mm.plugin.finder.feed.r.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "feedNonceId", "foldedType", "", "isFullScreen", "", "()Z", "isFullScreen$delegate", "Lkotlin/Lazy;", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "isOtherEnableFullScreenEnjoy", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<FinderFriendFoldedFeedLoader, r.b, r.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private long feedId;
  private String nickname;
  private final int scene;
  private String username;
  private r.a xMW;
  private r.b xMX;
  private FinderFriendFoldedFeedLoader xMY;
  private int xMZ;
  private String xMp;
  private final f xNa;
  
  public FinderFriendFoldedTimelineUI()
  {
    AppMethodBeat.i(263834);
    this.TAG = "Finder.FinderFriendFoldedTimelineUI";
    this.scene = 2;
    this.xMp = "";
    this.xNa = kotlin.g.ar((a)new c(this));
    AppMethodBeat.o(263834);
  }
  
  private final boolean QT()
  {
    AppMethodBeat.i(263828);
    boolean bool = ((Boolean)this.xNa.getValue()).booleanValue();
    AppMethodBeat.o(263828);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(263837);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(263837);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(263836);
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
    AppMethodBeat.o(263836);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 14;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_folded_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(263829);
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
    this.xMp = ((String)localObject1);
    this.xMZ = getIntent().getIntExtra("FOLED_TYPE", 1);
    int i;
    if (this.xMZ == 1)
    {
      i = b.j.finder_folded_list_title;
      localObject1 = (Context)getContext();
      localObject2 = this.nickname;
      if (localObject2 == null) {
        p.bGy("nickname");
      }
      setMMTitle(getString(i, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)localObject2) }));
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      long l = this.feedId;
      localObject2 = this.username;
      if (localObject2 == null) {
        p.bGy("username");
      }
      this.xMW = new r.a((MMActivity)localObject1, l, (String)localObject2, this.scene, QT());
      localObject1 = (MMActivity)this;
      localObject2 = this.xMW;
      if (localObject2 == null) {
        p.bGy("mPresenter");
      }
      this.xMX = new r.b((MMActivity)localObject1, (r.a)localObject2, this.scene);
      localObject1 = this.username;
      if (localObject1 == null) {
        p.bGy("username");
      }
      l = this.feedId;
      localObject2 = this.xMp;
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      localObject1 = new FinderFriendFoldedFeedLoader((String)localObject1, l, (String)localObject2, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).ekY());
      localObject2 = getIntent();
      p.j(localObject2, "intent");
      ((FinderFriendFoldedFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFriendFoldedFeedLoader)localObject1).setInitDone((j)new a((FinderFriendFoldedFeedLoader)localObject1, this));
      ((FinderFriendFoldedFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.xMY = ((FinderFriendFoldedFeedLoader)localObject1);
      AppMethodBeat.o(263829);
      return;
      if (this.xMZ == 2)
      {
        i = b.j.finder_feed_of_user;
        localObject1 = (Context)getContext();
        localObject2 = this.nickname;
        if (localObject2 == null) {
          p.bGy("nickname");
        }
        setMMTitle(getString(i, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)localObject2) }));
      }
      else
      {
        setMMTitle("");
      }
    }
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(263830);
    boolean bool = QT();
    AppMethodBeat.o(263830);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderFriendFoldedFeedLoader paramFinderFriendFoldedFeedLoader, FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(290046);
      Object localObject = FinderFriendFoldedTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(290046);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xNb.getInitPos(), 0);
        AppMethodBeat.o(290046);
        return;
      }
      AppMethodBeat.o(290046);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<bu>, x>
  {
    b(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Boolean>
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