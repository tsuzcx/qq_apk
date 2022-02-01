package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.o.a;
import com.tencent.mm.plugin.finder.feed.o.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<o.b, o.a>
{
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader tFM;
  public String tvp;
  private o.a uaB;
  private o.b uaC;
  public String uaD;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245237);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245237);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245236);
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
    AppMethodBeat.o(245236);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494326;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245231);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.tvp = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.uaD = ((String)localObject1);
    localObject1 = y.vXH;
    localObject1 = this.tvp;
    if (localObject1 == null) {
      p.btv("targetUsername");
    }
    localObject2 = this.uaD;
    if (localObject2 == null) {
      p.btv("targetNickname");
    }
    this.uaD = y.hf((String)localObject1, (String)localObject2);
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("initOnCreate ");
    Object localObject3 = this.tvp;
    if (localObject3 == null) {
      p.btv("targetUsername");
    }
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = this.uaD;
    if (localObject3 == null) {
      p.btv("targetNickname");
    }
    Log.i((String)localObject1, (String)localObject3);
    localObject1 = this.tvp;
    if (localObject1 == null) {
      p.btv("targetUsername");
    }
    int i;
    if (((CharSequence)localObject1).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
        AppMethodBeat.o(245231);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN();
        localObject2 = this.tvp;
        if (localObject2 == null) {
          p.btv("targetUsername");
        }
        localObject3 = ((bv)localObject1).Kn((String)localObject2);
        localObject1 = getContext();
        p.g(localObject1, "context");
        localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131759813);
        p.g(localObject1, "context.resources.getString(R.string.finder_he)");
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((AppCompatActivity)localObject2).getResources().getString(2131760575);
        p.g(localObject2, "context.resources.getString(R.string.finder_she)");
        if (localObject3 == null) {
          break label559;
        }
        Context localContext = (Context)getContext();
        if (((as)localObject3).ajE() != 1) {
          break label554;
        }
        setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)getString(2131759727, new Object[] { localObject1 })));
      }
    }
    for (;;)
    {
      localObject1 = this.tvp;
      if (localObject1 == null) {
        p.btv("targetUsername");
      }
      localObject2 = a.PRN;
      localObject1 = new FinderFriendLikeLoader((String)localObject1, ((FinderReporterUIC)a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
      ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((b)new a((FinderFriendLikeLoader)localObject1, this));
      this.tFM = ((BaseFinderFeedLoader)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.tFM;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      this.uaB = new o.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
      this.uaC = new o.b((MMActivity)this);
      localObject1 = this.uaC;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject2 = this.uaB;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      ((o.b)localObject1).a((c.a)localObject2);
      localObject1 = this.tvp;
      if (localObject1 == null) {
        p.btv("targetUsername");
      }
      if (Util.isNullOrNil((String)localObject1)) {
        finish();
      }
      AppMethodBeat.o(245231);
      return;
      label554:
      localObject1 = localObject2;
      break;
      label559:
      setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getString(2131759727, new Object[] { localObject1 })));
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(245234);
    finish();
    AppMethodBeat.o(245234);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<bo>, x>
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