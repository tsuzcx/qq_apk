package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.Loader;
import com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.b;
import com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<FinderAtTimelineUIContract.Loader, FinderAtTimelineUIContract.c, FinderAtTimelineUIContract.b>
{
  private static ConcurrentHashMap<Long, FinderItem> smf;
  public static final FinderAtTimelineUI.a smg;
  private final String TAG = "Finder.FinderAtTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private FinderAtTimelineUIContract.b smb;
  private FinderAtTimelineUIContract.c smc;
  private FinderAtTimelineUIContract.Loader smd;
  private long sme;
  
  static
  {
    AppMethodBeat.i(203086);
    smg = new FinderAtTimelineUI.a((byte)0);
    smf = new ConcurrentHashMap();
    AppMethodBeat.o(203086);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203088);
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
    AppMethodBeat.o(203088);
    return localView1;
  }
  
  public final int cCL()
  {
    return 13;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496172;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203081);
    setMMTitle(2131764860);
    this.sme = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    ae.i(this.TAG, "cacheId:" + this.sme);
    smf.clear();
    this.smb = new FinderAtTimelineUIContract.b((MMActivity)this, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.smb;
    if (localObject2 == null) {
      p.bdF("presenter");
    }
    this.smc = new FinderAtTimelineUIContract.c((MMActivity)localObject1, (FinderAtTimelineUIContract.b)localObject2, this.scene);
    localObject1 = v.aAK();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = e.slL;
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    localObject1 = new FinderAtTimelineUIContract.Loader((String)localObject1, (e)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
    ((FinderAtTimelineUIContract.Loader)localObject1).sbQ = ((d.g.a.a)new b(this));
    this.smd = ((FinderAtTimelineUIContract.Loader)localObject1);
    AppMethodBeat.o(203081);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203082);
    super.onDestroy();
    smf.clear();
    AppMethodBeat.o(203082);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */