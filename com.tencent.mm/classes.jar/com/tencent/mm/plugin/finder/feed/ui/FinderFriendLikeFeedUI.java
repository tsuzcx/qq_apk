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
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.w;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.t.a;
import com.tencent.mm.plugin.finder.feed.t.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.v;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"})
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<t.b, t.a>
{
  private t.a KRZ;
  private t.b KSa;
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  private HashMap _$_findViewCache;
  public String qBo;
  public BaseFinderFeedLoader qvo;
  public String qwI;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198467);
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
    AppMethodBeat.o(198467);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496203;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198462);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.qwI = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.qBo = ((String)localObject1);
    localObject1 = i.qTa;
    localObject1 = this.qwI;
    if (localObject1 == null) {
      d.g.b.k.aPZ("targetUsername");
    }
    localObject2 = this.qBo;
    if (localObject2 == null) {
      d.g.b.k.aPZ("targetNickname");
    }
    this.qBo = i.fX((String)localObject1, (String)localObject2);
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("initOnCreate ");
    Object localObject3 = this.qwI;
    if (localObject3 == null) {
      d.g.b.k.aPZ("targetUsername");
    }
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = this.qBo;
    if (localObject3 == null) {
      d.g.b.k.aPZ("targetNickname");
    }
    ad.i((String)localObject1, (String)localObject3);
    localObject1 = this.qwI;
    if (localObject1 == null) {
      d.g.b.k.aPZ("targetUsername");
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
        AppMethodBeat.o(198462);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).apM();
        localObject2 = this.qwI;
        if (localObject2 == null) {
          d.g.b.k.aPZ("targetUsername");
        }
        localObject3 = ((bg)localObject1).aHY((String)localObject2);
        localObject1 = getContext();
        d.g.b.k.g(localObject1, "context");
        localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131766403);
        localObject2 = getContext();
        d.g.b.k.g(localObject2, "context");
        localObject2 = ((AppCompatActivity)localObject2).getResources().getString(2131766484);
        if (localObject3 == null) {
          break label548;
        }
        Context localContext = (Context)getContext();
        if (((af)localObject3).eMK() != 1) {
          break label543;
        }
        setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)getString(2131766378, new Object[] { localObject1 })));
      }
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      localObject2 = this.qwI;
      if (localObject2 == null) {
        d.g.b.k.aPZ("targetUsername");
      }
      localObject3 = a.LCX;
      localObject2 = new w((String)localObject2, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((w)localObject2).KPL = ((b)new a((w)localObject2, this));
      this.qvo = ((BaseFinderFeedLoader)localObject2);
      localObject2 = this.qvo;
      if (localObject2 == null) {
        d.g.b.k.aPZ("feedLoader");
      }
      this.KRZ = new t.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
      this.KSa = new t.b((MMActivity)this);
      localObject1 = this.KSa;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject2 = this.KRZ;
      if (localObject2 == null) {
        d.g.b.k.aPZ("presenter");
      }
      ((t.b)localObject1).a((n.a)localObject2);
      localObject1 = this.qwI;
      if (localObject1 == null) {
        d.g.b.k.aPZ("targetUsername");
      }
      if (bt.isNullOrNil((String)localObject1)) {
        finish();
      }
      AppMethodBeat.o(198462);
      return;
      label543:
      localObject1 = localObject2;
      break;
      label548:
      setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)getString(2131766378, new Object[] { localObject1 })));
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198465);
    finish();
    AppMethodBeat.o(198465);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(w paramw, FinderFriendLikeFeedUI paramFinderFriendLikeFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeFeedUI
 * JD-Core Version:    0.7.0.1
 */