package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.v;
import com.tencent.mm.plugin.finder.feed.model.v.a;
import com.tencent.mm.plugin.finder.feed.s.a;
import com.tencent.mm.plugin.finder.feed.s.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedId", "feedLoader", "feedNonceId", "foldedType", "", "initPos", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<v, s.b, s.a>
{
  private s.a KRT;
  private s.b KRU;
  private v KRV;
  private String KRW = "";
  private int KRX;
  private final String TAG = "Finder.FinderFriendFoldedTimelineUI";
  private HashMap _$_findViewCache;
  private long feedId;
  private String nickname;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  private String username;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198460);
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
    AppMethodBeat.o(198460);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 14;
  }
  
  public final int getLayoutId()
  {
    return 2131496201;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198454);
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
    this.KRW = ((String)localObject1);
    this.KRX = getIntent().getIntExtra("FOLED_TYPE", 1);
    this.qxT = getIntent().getLongExtra("CACHE_ID", 0L);
    this.qvB = getIntent().getIntExtra("INIT_POS", 0);
    if (this.KRX == 1)
    {
      localObject1 = (Context)getContext();
      localObject2 = this.nickname;
      if (localObject2 == null) {
        d.g.b.k.aPZ("nickname");
      }
      setMMTitle(getString(2131766397, new Object[] { com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)localObject2) }));
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      long l = this.feedId;
      localObject2 = this.username;
      if (localObject2 == null) {
        d.g.b.k.aPZ("username");
      }
      this.KRT = new s.a((MMActivity)localObject1, l, (String)localObject2, this.qxT, this.qvB, this.scene);
      localObject1 = (MMActivity)this;
      localObject2 = this.KRT;
      if (localObject2 == null) {
        d.g.b.k.aPZ("mPresenter");
      }
      this.KRU = new s.b((MMActivity)localObject1, (s.a)localObject2, this.scene);
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.k.aPZ("username");
      }
      l = this.feedId;
      localObject2 = this.KRW;
      a locala = a.LCX;
      localObject1 = new v((String)localObject1, l, (String)localObject2, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((v)localObject1).KPL = ((b)new a(this));
      this.KRV = ((v)localObject1);
      AppMethodBeat.o(198454);
      return;
      if (this.KRX == 2)
      {
        localObject1 = (Context)getContext();
        localObject2 = this.nickname;
        if (localObject2 == null) {
          d.g.b.k.aPZ("nickname");
        }
        setMMTitle(getString(2131759222, new Object[] { com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)localObject2) }));
      }
      else
      {
        setMMTitle("");
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198458);
    super.onDestroy();
    v.a locala = v.KPU;
    ad.i("Finder.FinderFriendFoldedFeedLoader", "clearCache");
    v.fTw().clear();
    AppMethodBeat.o(198458);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFriendFoldedTimelineUI paramFinderFriendFoldedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI
 * JD-Core Version:    0.7.0.1
 */