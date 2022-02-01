package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.feed.q.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "feedNonceId", "foldedType", "", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<FinderFriendFoldedFeedLoader, q.b, q.a>
{
  private q.a BmX;
  private q.b BmY;
  private FinderFriendFoldedFeedLoader BmZ;
  private String Bmz = "";
  private int Bna;
  private final String TAG = "Finder.FinderFriendFoldedTimelineUI";
  private long feedId;
  private String nickname;
  private final int scene = 2;
  private String username;
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 14;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_folded_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364284);
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
    this.Bmz = ((String)localObject1);
    this.Bna = getIntent().getIntExtra("FOLED_TYPE", 1);
    int i;
    Object localObject3;
    if (this.Bna == 1)
    {
      i = e.h.finder_folded_list_title;
      localObject3 = (Context)getContext();
      localObject2 = this.nickname;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("nickname");
        localObject1 = null;
      }
      setMMTitle(getString(i, new Object[] { p.b((Context)localObject3, (CharSequence)localObject1) }));
    }
    for (;;)
    {
      localObject3 = (MMActivity)this;
      long l = this.feedId;
      localObject2 = this.username;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("username");
        localObject1 = null;
      }
      this.BmX = new q.a((MMActivity)localObject3, l, (String)localObject1, this.scene);
      localObject3 = (MMActivity)this;
      localObject2 = this.BmX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mPresenter");
        localObject1 = null;
      }
      this.BmY = new q.b((MMActivity)localObject3, (q.a)localObject1, this.scene);
      localObject2 = this.username;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("username");
        localObject1 = null;
      }
      l = this.feedId;
      localObject2 = this.Bmz;
      localObject3 = k.aeZF;
      localObject1 = new FinderFriendFoldedFeedLoader((String)localObject1, l, (String)localObject2, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
      localObject2 = getIntent();
      s.s(localObject2, "intent");
      ((FinderFriendFoldedFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFriendFoldedFeedLoader)localObject1).setInitDone((j)new a(this, (FinderFriendFoldedFeedLoader)localObject1));
      ((FinderFriendFoldedFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      localObject2 = ah.aiuX;
      this.BmZ = ((FinderFriendFoldedFeedLoader)localObject1);
      AppMethodBeat.o(364284);
      return;
      if (this.Bna == 2)
      {
        i = e.h.finder_feed_of_user;
        localObject3 = (Context)getContext();
        localObject2 = this.nickname;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("nickname");
          localObject1 = null;
        }
        setMMTitle(getString(i, new Object[] { p.b((Context)localObject3, (CharSequence)localObject1) }));
      }
      else
      {
        setMMTitle("");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI, FinderFriendFoldedFeedLoader paramFinderFriendFoldedFeedLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364685);
      Object localObject2 = FinderFriendFoldedTimelineUI.a(this.Bnb);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mViewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.Bnc;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderFriendFoldedFeedLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(364685);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<IResponse<cc>, ah>
  {
    b(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI
 * JD-Core Version:    0.7.0.1
 */