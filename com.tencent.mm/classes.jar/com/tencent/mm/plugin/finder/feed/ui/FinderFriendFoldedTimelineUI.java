package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.model.g;
import com.tencent.mm.plugin.finder.feed.model.g.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedId", "feedLoader", "feedNonceId", "foldedType", "", "initPos", "mPresenter", "mViewCallback", "nickname", "scene", "username", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "plugin-finder_release"})
public final class FinderFriendFoldedTimelineUI
  extends FinderLoaderFeedUI<g, k.b, k.a>
{
  private final String TAG = "Finder.FinderFriendFoldedTimelineUI";
  private HashMap _$_findViewCache;
  private long dig;
  private String nickname;
  private long rhr;
  private int rht;
  private k.a rpF;
  private k.b rpG;
  private g rpH;
  private String rpI = "";
  private int rpJ;
  private final int scene = 2;
  private String username;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202373);
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
    AppMethodBeat.o(202373);
    return localView1;
  }
  
  public final int cuI()
  {
    return 14;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496202;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202367);
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
    this.dig = getIntent().getLongExtra("FEED_ID", 0L);
    localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.rpI = ((String)localObject1);
    this.rpJ = getIntent().getIntExtra("FOLED_TYPE", 1);
    this.rhr = getIntent().getLongExtra("CACHE_ID", 0L);
    this.rht = getIntent().getIntExtra("INIT_POS", 0);
    if (this.rpJ == 1)
    {
      localObject1 = (Context)getContext();
      localObject2 = this.nickname;
      if (localObject2 == null) {
        d.g.b.k.aVY("nickname");
      }
      setMMTitle(getString(2131766419, new Object[] { com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)localObject2) }));
    }
    for (;;)
    {
      localObject1 = (MMActivity)this;
      long l = this.dig;
      localObject2 = this.username;
      if (localObject2 == null) {
        d.g.b.k.aVY("username");
      }
      this.rpF = new k.a((MMActivity)localObject1, l, (String)localObject2, this.rhr, this.rht, this.scene);
      localObject1 = (MMActivity)this;
      localObject2 = this.rpF;
      if (localObject2 == null) {
        d.g.b.k.aVY("mPresenter");
      }
      this.rpG = new k.b((MMActivity)localObject1, (k.a)localObject2, this.scene);
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.k.aVY("username");
      }
      l = this.dig;
      localObject2 = this.rpI;
      a locala = a.IrY;
      localObject1 = new g((String)localObject1, l, (String)localObject2, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      ((g)localObject1).rmE = ((b)new a(this));
      this.rpH = ((g)localObject1);
      AppMethodBeat.o(202367);
      return;
      if (this.rpJ == 2)
      {
        localObject1 = (Context)getContext();
        localObject2 = this.nickname;
        if (localObject2 == null) {
          d.g.b.k.aVY("nickname");
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
    AppMethodBeat.i(202371);
    super.onDestroy();
    g.a locala = g.rmO;
    ac.i("Finder.FinderFriendFoldedFeedLoader", "clearCache");
    g.cvB().clear();
    AppMethodBeat.o(202371);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendFoldedTimelineUI$initOnCreate$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI
 * JD-Core Version:    0.7.0.1
 */