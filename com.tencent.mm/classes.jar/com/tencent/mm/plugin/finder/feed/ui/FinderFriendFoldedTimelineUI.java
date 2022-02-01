package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "feedNonceId", "foldedType", "", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<FinderFriendFoldedFeedLoader, m.b, m.a>
{
  private final String TAG = "Finder.FinderFriendFoldedTimelineUI";
  private HashMap _$_findViewCache;
  private long dtq;
  private String nickname;
  private final int scene = 2;
  private m.a set;
  private m.b seu;
  private FinderFriendFoldedFeedLoader sev;
  private String sew = "";
  private int sex;
  private String username;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202698);
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
    AppMethodBeat.o(202698);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 14;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496202;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202693);
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
    this.dtq = getIntent().getLongExtra("FEED_ID", 0L);
    localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.sew = ((String)localObject1);
    this.sex = getIntent().getIntExtra("FOLED_TYPE", 1);
    if (this.sex == 1)
    {
      localObject1 = (Context)getContext();
      localObject2 = this.nickname;
      if (localObject2 == null) {
        p.bcb("nickname");
      }
      setMMTitle(getString(2131766419, new Object[] { k.c((Context)localObject1, (CharSequence)localObject2) }));
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      long l = this.dtq;
      localObject2 = this.username;
      if (localObject2 == null) {
        p.bcb("username");
      }
      this.set = new m.a((MMActivity)localObject1, l, (String)localObject2, this.scene);
      localObject1 = (MMActivity)this;
      localObject2 = this.set;
      if (localObject2 == null) {
        p.bcb("mPresenter");
      }
      this.seu = new m.b((MMActivity)localObject1, (m.a)localObject2, this.scene);
      localObject1 = this.username;
      if (localObject1 == null) {
        p.bcb("username");
      }
      l = this.dtq;
      localObject2 = this.sew;
      a locala = a.KiD;
      localObject1 = new FinderFriendFoldedFeedLoader((String)localObject1, l, (String)localObject2, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFriendFoldedFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFriendFoldedFeedLoader)localObject1).setInitDone((h)new a((FinderFriendFoldedFeedLoader)localObject1, this));
      ((FinderFriendFoldedFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.sev = ((FinderFriendFoldedFeedLoader)localObject1);
      AppMethodBeat.o(202693);
      return;
      if (this.sex == 2)
      {
        localObject1 = (Context)getContext();
        localObject2 = this.nickname;
        if (localObject2 == null) {
          p.bcb("nickname");
        }
        setMMTitle(getString(2131759222, new Object[] { k.c((Context)localObject1, (CharSequence)localObject2) }));
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFriendFoldedFeedLoader paramFinderFriendFoldedFeedLoader, FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202691);
      Object localObject = FinderFriendFoldedTimelineUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202691);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sey.getInitPos(), 0);
        AppMethodBeat.o(202691);
        return;
      }
      AppMethodBeat.o(202691);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
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