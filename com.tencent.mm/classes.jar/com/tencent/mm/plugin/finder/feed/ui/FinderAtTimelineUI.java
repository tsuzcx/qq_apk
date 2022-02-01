package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.g.g;
import com.tencent.mm.plugin.finder.feed.g.h;
import com.tencent.mm.plugin.finder.feed.g.i;
import com.tencent.mm.plugin.finder.feed.model.internal.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<g.g, g.i, g.h>
{
  public static final a KRb;
  private static ConcurrentHashMap<Long, FinderItem> qBG;
  private g.h KQY;
  private g.i KQZ;
  private g.g KRa;
  private final String TAG = "Finder.FinderAtTimelineUI";
  private HashMap _$_findViewCache;
  private long qxT;
  private final int scene = 2;
  
  static
  {
    AppMethodBeat.i(198373);
    KRb = new a((byte)0);
    qBG = new ConcurrentHashMap();
    AppMethodBeat.o(198373);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198375);
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
    AppMethodBeat.o(198375);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 13;
  }
  
  public final int getLayoutId()
  {
    return 2131496171;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198368);
    setMMTitle(2131763115);
    this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    ad.i(this.TAG, "cacheId:" + this.qxT);
    qBG.clear();
    this.KQY = new g.h((MMActivity)this, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.KQY;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    this.KQZ = new g.i((MMActivity)localObject1, (g.h)localObject2, this.scene);
    localObject1 = u.aqO();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = b.KQN;
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    localObject1 = new g.g((String)localObject1, (b)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    ((g.g)localObject1).fetchEndCallback = ((d.g.a.a)new b(this));
    this.KRa = ((g.g)localObject1);
    AppMethodBeat.o(198368);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198369);
    super.onDestroy();
    qBG.clear();
    AppMethodBeat.o(198369);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */