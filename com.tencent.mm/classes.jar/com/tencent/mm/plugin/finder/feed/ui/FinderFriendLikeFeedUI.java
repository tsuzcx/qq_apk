package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.s.a;
import com.tencent.mm.plugin.finder.feed.s.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<s.b, s.a>
{
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  private HashMap _$_findViewCache;
  private s.a xNd;
  private s.b xNe;
  public String xNf;
  public String xcW;
  public BaseFinderFeedLoader xnX;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290811);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290811);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290810);
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
    AppMethodBeat.o(290810);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_friend_like_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(290805);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xcW = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xNf = ((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject1 = this.xcW;
    if (localObject1 == null) {
      p.bGy("targetUsername");
    }
    localObject2 = this.xNf;
    if (localObject2 == null) {
      p.bGy("targetNickname");
    }
    this.xNf = com.tencent.mm.plugin.finder.utils.aj.ht((String)localObject1, (String)localObject2);
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("initOnCreate ");
    Object localObject3 = this.xcW;
    if (localObject3 == null) {
      p.bGy("targetUsername");
    }
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = this.xNf;
    if (localObject3 == null) {
      p.bGy("targetNickname");
    }
    Log.i((String)localObject1, (String)localObject3);
    localObject1 = this.xcW;
    if (localObject1 == null) {
      p.bGy("targetUsername");
    }
    int i;
    if (((CharSequence)localObject1).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = h.ae(n.class);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
        AppMethodBeat.o(290805);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = ((n)localObject1).bbL();
        localObject2 = this.xcW;
        if (localObject2 == null) {
          p.bGy("targetUsername");
        }
        localObject3 = ((bv)localObject1).RG((String)localObject2);
        localObject1 = getContext();
        p.j(localObject1, "context");
        localObject1 = ((AppCompatActivity)localObject1).getResources().getString(b.j.finder_he);
        p.j(localObject1, "context.resources.getString(R.string.finder_he)");
        localObject2 = getContext();
        p.j(localObject2, "context");
        localObject2 = ((AppCompatActivity)localObject2).getResources().getString(b.j.finder_she);
        p.j(localObject2, "context.resources.getString(R.string.finder_she)");
        if (localObject3 == null) {
          break label564;
        }
        Context localContext = (Context)getContext();
        i = b.j.finder_feed_he_recent_like;
        if (((as)localObject3).apt() != 1) {
          break label559;
        }
        setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)getString(i, new Object[] { localObject1 })));
      }
    }
    for (;;)
    {
      localObject1 = this.xcW;
      if (localObject1 == null) {
        p.bGy("targetUsername");
      }
      localObject2 = g.Xox;
      localObject1 = new FinderFriendLikeLoader((String)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
      ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((b)new a((FinderFriendLikeLoader)localObject1, this));
      this.xnX = ((BaseFinderFeedLoader)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.xnX;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      this.xNd = new s.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
      this.xNe = new s.b((MMActivity)this);
      localObject1 = this.xNe;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject2 = this.xNd;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      ((s.b)localObject1).a((c.a)localObject2);
      localObject1 = this.xcW;
      if (localObject1 == null) {
        p.bGy("targetUsername");
      }
      if (Util.isNullOrNil((String)localObject1)) {
        finish();
      }
      AppMethodBeat.o(290805);
      return;
      label559:
      localObject1 = localObject2;
      break;
      label564:
      setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getString(b.j.finder_feed_he_recent_like, new Object[] { localObject1 })));
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(290808);
    finish();
    AppMethodBeat.o(290808);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<bu>, x>
  {
    a(FinderFriendLikeLoader paramFinderFriendLikeLoader, FinderFriendLikeFeedUI paramFinderFriendLikeFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeFeedUI
 * JD-Core Version:    0.7.0.1
 */