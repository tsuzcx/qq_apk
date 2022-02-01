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
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.n.b;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.q;
import d.v;
import d.z;
import java.util.HashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<n.b, n.a>
{
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  private HashMap _$_findViewCache;
  public String rRD;
  public BaseFinderFeedLoader scw;
  private n.a snp;
  private n.b snq;
  public String snr;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203181);
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
    AppMethodBeat.o(203181);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496204;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203176);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.rRD = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.snr = ((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    localObject1 = this.rRD;
    if (localObject1 == null) {
      d.g.b.p.bdF("targetUsername");
    }
    localObject2 = this.snr;
    if (localObject2 == null) {
      d.g.b.p.bdF("targetNickname");
    }
    this.snr = com.tencent.mm.plugin.finder.utils.p.gC((String)localObject1, (String)localObject2);
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("initOnCreate ");
    Object localObject3 = this.rRD;
    if (localObject3 == null) {
      d.g.b.p.bdF("targetUsername");
    }
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = this.snr;
    if (localObject3 == null) {
      d.g.b.p.bdF("targetNickname");
    }
    ae.i((String)localObject1, (String)localObject3);
    localObject1 = this.rRD;
    if (localObject1 == null) {
      d.g.b.p.bdF("targetUsername");
    }
    int i;
    if (((CharSequence)localObject1).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
        AppMethodBeat.o(203176);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF();
        localObject2 = this.rRD;
        if (localObject2 == null) {
          d.g.b.p.bdF("targetUsername");
        }
        localObject3 = ((bq)localObject1).BH((String)localObject2);
        localObject1 = getContext();
        d.g.b.p.g(localObject1, "context");
        localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131766425);
        localObject2 = getContext();
        d.g.b.p.g(localObject2, "context");
        localObject2 = ((AppCompatActivity)localObject2).getResources().getString(2131766498);
        if (localObject3 == null) {
          break label547;
        }
        Context localContext = (Context)getContext();
        if (((an)localObject3).VQ() != 1) {
          break label542;
        }
        setMMTitle((CharSequence)k.c(localContext, (CharSequence)getString(2131766397, new Object[] { localObject1 })));
      }
    }
    for (;;)
    {
      localObject1 = this.rRD;
      if (localObject1 == null) {
        d.g.b.p.bdF("targetUsername");
      }
      localObject2 = a.KEX;
      localObject1 = new FinderFriendLikeLoader((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
      ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((b)new a((FinderFriendLikeLoader)localObject1, this));
      this.scw = ((BaseFinderFeedLoader)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.scw;
      if (localObject2 == null) {
        d.g.b.p.bdF("feedLoader");
      }
      this.snp = new n.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
      this.snq = new n.b((MMActivity)this);
      localObject1 = this.snq;
      if (localObject1 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject2 = this.snp;
      if (localObject2 == null) {
        d.g.b.p.bdF("presenter");
      }
      ((n.b)localObject1).a((b.a)localObject2);
      localObject1 = this.rRD;
      if (localObject1 == null) {
        d.g.b.p.bdF("targetUsername");
      }
      if (bu.isNullOrNil((String)localObject1)) {
        finish();
      }
      AppMethodBeat.o(203176);
      return;
      label542:
      localObject1 = localObject2;
      break;
      label547:
      setMMTitle((CharSequence)k.c((Context)getContext(), (CharSequence)getString(2131766397, new Object[] { localObject1 })));
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203179);
    finish();
    AppMethodBeat.o(203179);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<am>, z>
  {
    a(FinderFriendLikeLoader paramFinderFriendLikeLoader, FinderFriendLikeFeedUI paramFinderFriendLikeFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeFeedUI
 * JD-Core Version:    0.7.0.1
 */