package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.a.f;
import com.tencent.mm.plugin.finder.feed.a.g;
import com.tencent.mm.plugin.finder.feed.a.h;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<a.f, a.h, a.g>
{
  private static ConcurrentHashMap<Long, FinderItem> roF;
  public static final FinderAtTimelineUI.a roG;
  private final String TAG = "Finder.FinderAtTimelineUI";
  private HashMap _$_findViewCache;
  private long rhr;
  private a.g roC;
  private a.h roD;
  private a.f roE;
  private final int scene = 2;
  
  static
  {
    AppMethodBeat.i(202285);
    roG = new FinderAtTimelineUI.a((byte)0);
    roF = new ConcurrentHashMap();
    AppMethodBeat.o(202285);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202287);
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
    AppMethodBeat.o(202287);
    return localView1;
  }
  
  public final int cuI()
  {
    return 13;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496172;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202280);
    setMMTitle(2131764860);
    this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    ac.i(this.TAG, "cacheId:" + this.rhr);
    roF.clear();
    this.roC = new a.g((MMActivity)this, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.roC;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    this.roD = new a.h((MMActivity)localObject1, (a.g)localObject2, this.scene);
    localObject1 = u.axE();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = c.rom;
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    localObject1 = new a.f((String)localObject1, (c)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    ((a.f)localObject1).fetchEndCallback = ((d.g.a.a)new b(this));
    this.roE = ((a.f)localObject1);
    AppMethodBeat.o(202280);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202281);
    super.onDestroy();
    roF.clear();
    AppMethodBeat.o(202281);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */