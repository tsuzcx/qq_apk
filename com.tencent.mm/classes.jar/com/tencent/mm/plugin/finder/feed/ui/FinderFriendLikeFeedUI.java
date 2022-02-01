package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.r.a;
import com.tencent.mm.plugin.finder.feed.r.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$Presenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "targetNickname", "getTargetNickname", "()Ljava/lang/String;", "setTargetNickname", "(Ljava/lang/String;)V", "targetUsername", "getTargetUsername", "setTargetUsername", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onBackPressed", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendLikeFeedUI
  extends FinderBaseGridFeedUI<r.b, r.a>
{
  public String ACm;
  public BaseFinderFeedLoader ALH;
  private r.a Bnd;
  private r.b Bne;
  public String Bnf;
  private final String TAG = "Finder.FinderFriendLikeFeedUI";
  
  private void awa(String paramString)
  {
    AppMethodBeat.i(364633);
    s.u(paramString, "<set-?>");
    this.Bnf = paramString;
    AppMethodBeat.o(364633);
  }
  
  private String eeN()
  {
    AppMethodBeat.i(364616);
    String str = this.ACm;
    if (str != null)
    {
      AppMethodBeat.o(364616);
      return str;
    }
    s.bIx("targetUsername");
    AppMethodBeat.o(364616);
    return null;
  }
  
  private String eeO()
  {
    AppMethodBeat.i(364624);
    String str = this.Bnf;
    if (str != null)
    {
      AppMethodBeat.o(364624);
      return str;
    }
    s.bIx("targetNickname");
    AppMethodBeat.o(364624);
    return null;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_friend_like_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364664);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    s.u(localObject1, "<set-?>");
    this.ACm = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    awa((String)localObject1);
    localObject1 = av.GiL;
    awa(av.ip(eeN(), eeO()));
    Log.i(this.TAG, "initOnCreate " + eeN() + ", " + eeO());
    int i;
    if (((CharSequence)eeN()).length() > 0) {
      i = 1;
    }
    Object localObject3;
    while (i != 0)
    {
      localObject1 = h.ax(n.class);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.messenger.foundation.api.IMessengerStorage");
        AppMethodBeat.o(364664);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        au localau = ((n)localObject1).bzA().JE(eeN());
        localObject1 = getContext().getResources().getString(e.h.finder_he);
        s.s(localObject1, "context.resources.getString(R.string.finder_he)");
        localObject2 = getContext().getResources().getString(e.h.finder_she);
        s.s(localObject2, "context.resources.getString(R.string.finder_she)");
        if (localau == null) {
          break label469;
        }
        localObject3 = (Context)getContext();
        i = e.h.finder_feed_he_recent_like;
        if (localau.sex != 1) {
          break label464;
        }
        setMMTitle((CharSequence)p.b((Context)localObject3, (CharSequence)getString(i, new Object[] { localObject1 })));
      }
    }
    label284:
    localObject1 = eeN();
    localObject2 = k.aeZF;
    localObject1 = new FinderFriendLikeLoader((String)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((b)new a((FinderFriendLikeLoader)localObject1, this));
    localObject2 = ah.aiuX;
    localObject1 = (BaseFinderFeedLoader)localObject1;
    s.u(localObject1, "<set-?>");
    this.ALH = ((BaseFinderFeedLoader)localObject1);
    localObject2 = (MMActivity)this;
    localObject1 = this.ALH;
    if (localObject1 != null)
    {
      label371:
      this.Bnd = new r.a((MMActivity)localObject2, (BaseFinderFeedLoader)localObject1);
      this.Bne = new r.b((MMActivity)this);
      localObject1 = this.Bne;
      if (localObject1 != null) {
        break label518;
      }
      s.bIx("viewCallback");
      localObject1 = null;
    }
    label518:
    for (;;)
    {
      localObject3 = this.Bnd;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((r.b)localObject1).a((c.a)localObject2);
      if (Util.isNullOrNil(eeN())) {
        finish();
      }
      AppMethodBeat.o(364664);
      return;
      label464:
      localObject1 = localObject2;
      break;
      label469:
      setMMTitle((CharSequence)p.b((Context)getContext(), (CharSequence)getString(e.h.finder_feed_he_recent_like, new Object[] { localObject1 })));
      break label284;
      s.bIx("feedLoader");
      localObject1 = null;
      break label371;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(364668);
    finish();
    AppMethodBeat.o(364668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<IResponse<cc>, ah>
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