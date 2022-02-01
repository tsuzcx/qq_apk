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
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.v;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<l.b, l.a>
{
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  private HashMap _$_findViewCache;
  public String qYd;
  public BaseFinderFeedLoader rgh;
  private l.a rpL;
  private l.b rpM;
  public String rpN;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202380);
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
    AppMethodBeat.o(202380);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496204;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202375);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.qYd = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.rpN = ((String)localObject1);
    localObject1 = n.rPN;
    localObject1 = this.qYd;
    if (localObject1 == null) {
      d.g.b.k.aVY("targetUsername");
    }
    localObject2 = this.rpN;
    if (localObject2 == null) {
      d.g.b.k.aVY("targetNickname");
    }
    this.rpN = n.gm((String)localObject1, (String)localObject2);
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("initOnCreate ");
    Object localObject3 = this.qYd;
    if (localObject3 == null) {
      d.g.b.k.aVY("targetUsername");
    }
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = this.rpN;
    if (localObject3 == null) {
      d.g.b.k.aVY("targetNickname");
    }
    ac.i((String)localObject1, (String)localObject3);
    localObject1 = this.qYd;
    if (localObject1 == null) {
      d.g.b.k.aVY("targetUsername");
    }
    int i;
    if (((CharSequence)localObject1).length() > 0) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
        AppMethodBeat.o(202375);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB();
        localObject2 = this.qYd;
        if (localObject2 == null) {
          d.g.b.k.aVY("targetUsername");
        }
        localObject3 = ((bj)localObject1).aNt((String)localObject2);
        localObject1 = getContext();
        d.g.b.k.g(localObject1, "context");
        localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131766425);
        localObject2 = getContext();
        d.g.b.k.g(localObject2, "context");
        localObject2 = ((AppCompatActivity)localObject2).getResources().getString(2131766498);
        if (localObject3 == null) {
          break label548;
        }
        Context localContext = (Context)getContext();
        if (((ai)localObject3).Tt() != 1) {
          break label543;
        }
        setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)getString(2131766397, new Object[] { localObject1 })));
      }
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      localObject2 = this.qYd;
      if (localObject2 == null) {
        d.g.b.k.aVY("targetUsername");
      }
      localObject3 = a.IrY;
      localObject2 = new h((String)localObject2, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      ((h)localObject2).rmE = ((b)new a((h)localObject2, this));
      this.rgh = ((BaseFinderFeedLoader)localObject2);
      localObject2 = this.rgh;
      if (localObject2 == null) {
        d.g.b.k.aVY("feedLoader");
      }
      this.rpL = new l.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
      this.rpM = new l.b((MMActivity)this);
      localObject1 = this.rpM;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject2 = this.rpL;
      if (localObject2 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((l.b)localObject1).a((c.a)localObject2);
      localObject1 = this.qYd;
      if (localObject1 == null) {
        d.g.b.k.aVY("targetUsername");
      }
      if (bs.isNullOrNil((String)localObject1)) {
        finish();
      }
      AppMethodBeat.o(202375);
      return;
      label543:
      localObject1 = localObject2;
      break;
      label548:
      setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)getString(2131766397, new Object[] { localObject1 })));
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202378);
    finish();
    AppMethodBeat.o(202378);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(h paramh, FinderFriendLikeFeedUI paramFinderFriendLikeFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeFeedUI
 * JD-Core Version:    0.7.0.1
 */